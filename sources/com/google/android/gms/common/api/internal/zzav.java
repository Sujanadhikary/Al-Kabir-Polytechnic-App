package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzav extends GoogleApiClient implements zzbq {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Looper zzcn;
    private final int zzde;
    private final GoogleApiAvailability zzdg;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    private boolean zzdk;
    private final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> zzgo = new LinkedList();
    private final GmsClientEventManager zzie;
    private zzbp zzif = null;
    private volatile boolean zzig;
    private long zzih = 120000;
    private long zzii = 5000;
    private final zzba zzij;
    @VisibleForTesting
    private GooglePlayServicesUpdatedReceiver zzik;
    final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    Set<Scope> zzim = new HashSet();
    private final ListenerHolders zzin = new ListenerHolders();
    private final ArrayList<zzp> zzio;
    private Integer zzip = null;
    Set<zzch> zziq = null;
    final zzck zzir;
    private final GmsClientEventManager.GmsClientEventState zzis = new zzaw(this);

    public zzav(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i, int i2, ArrayList<zzp> arrayList, boolean z) {
        this.mContext = context;
        this.zzga = lock;
        this.zzdk = false;
        this.zzie = new GmsClientEventManager(looper, this.zzis);
        this.zzcn = looper;
        this.zzij = new zzba(this, looper);
        this.zzdg = googleApiAvailability;
        this.zzde = i;
        if (this.zzde >= 0) {
            this.zzip = Integer.valueOf(i2);
        }
        this.zzgi = map;
        this.zzil = map2;
        this.zzio = arrayList;
        this.zzir = new zzck(this.zzil);
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.zzie.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.zzie.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.zzgf = clientSettings;
        this.zzdh = abstractClientBuilder;
    }

    /* access modifiers changed from: private */
    public final void resume() {
        this.zzga.lock();
        try {
            if (this.zzig) {
                zzax();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public static int zza(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client next : iterable) {
            if (next.requiresSignIn()) {
                z3 = true;
            }
            z2 = next.providesSignIn() ? true : z2;
        }
        if (z3) {
            return (!z2 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public final void zza(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.CommonApi.clearDefaultAccount(googleApiClient).setResultCallback(new zzaz(this, statusPendingResult, z, googleApiClient));
    }

    @GuardedBy("mLock")
    private final void zzax() {
        this.zzie.enableCallbacks();
        this.zzif.connect();
    }

    /* access modifiers changed from: private */
    public final void zzay() {
        this.zzga.lock();
        try {
            if (zzaz()) {
                zzax();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    private final void zzg(int i) {
        if (this.zzip == null) {
            this.zzip = Integer.valueOf(i);
        } else if (this.zzip.intValue() != i) {
            String zzh = zzh(i);
            String zzh2 = zzh(this.zzip.intValue());
            throw new IllegalStateException(new StringBuilder(String.valueOf(zzh).length() + 51 + String.valueOf(zzh2).length()).append("Cannot use sign-in mode: ").append(zzh).append(". Mode was already set to ").append(zzh2).toString());
        }
        if (this.zzif == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.Client next : this.zzil.values()) {
                if (next.requiresSignIn()) {
                    z2 = true;
                }
                z = next.providesSignIn() ? true : z;
            }
            switch (this.zzip.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        if (this.zzdk) {
                            this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, true);
                            return;
                        } else {
                            this.zzif = zzr.zza(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio);
                            return;
                        }
                    }
                    break;
            }
            if (!this.zzdk || z) {
                this.zzif = new zzbd(this.mContext, this, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this);
            } else {
                this.zzif = new zzw(this.mContext, this.zzga, this.zzcn, this.zzdg, this.zzil, this.zzgf, this.zzgi, this.zzdh, this.zzio, this, false);
            }
        }
    }

    private static String zzh(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public final ConnectionResult blockingConnect() {
        boolean z = true;
        Preconditions.checkState(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip == null) {
                    z = false;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            return this.zzif.blockingConnect();
        } finally {
            this.zzga.unlock();
        }
    }

    public final ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        Preconditions.checkState(z, "blockingConnect must not be called on the UI thread");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        this.zzga.lock();
        try {
            if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzg(this.zzip.intValue());
            this.zzie.enableCallbacks();
            return this.zzif.blockingConnect(j, timeUnit);
        } finally {
            this.zzga.unlock();
        }
    }

    public final PendingResult<Status> clearDefaultAccountAndReconnect() {
        Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
        Preconditions.checkState(this.zzip.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult((GoogleApiClient) this);
        if (this.zzil.containsKey(Common.CLIENT_KEY)) {
            zza(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(Common.API).addConnectionCallbacks(new zzax(this, atomicReference, statusPendingResult)).addOnConnectionFailedListener(new zzay(this, statusPendingResult)).setHandler(this.zzij).build();
            atomicReference.set(build);
            build.connect();
        }
        return statusPendingResult;
    }

    public final void connect() {
        boolean z = false;
        this.zzga.lock();
        try {
            if (this.zzde >= 0) {
                if (this.zzip != null) {
                    z = true;
                }
                Preconditions.checkState(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.zzip == null) {
                this.zzip = Integer.valueOf(zza(this.zzil.values(), false));
            } else if (this.zzip.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.zzip.intValue());
        } finally {
            this.zzga.unlock();
        }
    }

    public final void connect(int i) {
        boolean z = true;
        this.zzga.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            Preconditions.checkArgument(z, new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            zzg(i);
            zzax();
        } finally {
            this.zzga.unlock();
        }
    }

    public final void disconnect() {
        this.zzga.lock();
        try {
            this.zzir.release();
            if (this.zzif != null) {
                this.zzif.disconnect();
            }
            this.zzin.release();
            for (BaseImplementation.ApiMethodImpl apiMethodImpl : this.zzgo) {
                apiMethodImpl.zza((zzcn) null);
                apiMethodImpl.cancel();
            }
            this.zzgo.clear();
            if (this.zzif != null) {
                zzaz();
                this.zzie.disableCallbacks();
                this.zzga.unlock();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.zzig);
        printWriter.append(" mWorkQueue.size()=").print(this.zzgo.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.zzir.zzmo.size());
        if (this.zzif != null) {
            this.zzif.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(@NonNull T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                this.zzgo.add(t);
            } else {
                t = this.zzif.enqueue(t);
                this.zzga.unlock();
            }
            return t;
        } finally {
            this.zzga.unlock();
        }
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(@NonNull T t) {
        Preconditions.checkArgument(t.getClientKey() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.zzil.containsKey(t.getClientKey());
        String name = t.getApi() != null ? t.getApi().getName() : "the API";
        Preconditions.checkArgument(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.zzga.lock();
        try {
            if (this.zzif == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (this.zzig) {
                this.zzgo.add(t);
                while (!this.zzgo.isEmpty()) {
                    BaseImplementation.ApiMethodImpl remove = this.zzgo.remove();
                    this.zzir.zzb(remove);
                    remove.setFailedResult(Status.RESULT_INTERNAL_ERROR);
                }
            } else {
                t = this.zzif.execute(t);
                this.zzga.unlock();
            }
            return t;
        } finally {
            this.zzga.unlock();
        }
    }

    @NonNull
    public final <C extends Api.Client> C getClient(@NonNull Api.AnyClientKey<C> anyClientKey) {
        C c = (Api.Client) this.zzil.get(anyClientKey);
        Preconditions.checkNotNull(c, "Appropriate Api was not requested.");
        return c;
    }

    @NonNull
    public final ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.zzga.lock();
        try {
            if (!isConnected() && !this.zzig) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.zzil.containsKey(api.getClientKey())) {
                ConnectionResult connectionResult = this.zzif.getConnectionResult(api);
                if (connectionResult != null) {
                    this.zzga.unlock();
                } else if (this.zzig) {
                    connectionResult = ConnectionResult.RESULT_SUCCESS;
                } else {
                    Log.w("GoogleApiClientImpl", zzbb());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.zzga.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.zzga.unlock();
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzcn;
    }

    public final boolean hasApi(@NonNull Api<?> api) {
        return this.zzil.containsKey(api.getClientKey());
    }

    public final boolean hasConnectedApi(@NonNull Api<?> api) {
        if (!isConnected()) {
            return false;
        }
        Api.Client client = this.zzil.get(api.getClientKey());
        return client != null && client.isConnected();
    }

    public final boolean isConnected() {
        return this.zzif != null && this.zzif.isConnected();
    }

    public final boolean isConnecting() {
        return this.zzif != null && this.zzif.isConnecting();
    }

    public final boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzie.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public final boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzie.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public final boolean maybeSignIn(SignInConnectionListener signInConnectionListener) {
        return this.zzif != null && this.zzif.maybeSignIn(signInConnectionListener);
    }

    public final void maybeSignOut() {
        if (this.zzif != null) {
            this.zzif.maybeSignOut();
        }
    }

    public final void reconnect() {
        disconnect();
        connect();
    }

    public final void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzie.registerConnectionCallbacks(connectionCallbacks);
    }

    public final void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzie.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public final <L> ListenerHolder<L> registerListener(@NonNull L l) {
        this.zzga.lock();
        try {
            return this.zzin.zza(l, this.zzcn, "NO_TYPE");
        } finally {
            this.zzga.unlock();
        }
    }

    public final void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        LifecycleActivity lifecycleActivity = new LifecycleActivity(fragmentActivity);
        if (this.zzde >= 0) {
            zzi.zza(lifecycleActivity).zzc(this.zzde);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    public final void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzie.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public final void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzie.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public final void zza(zzch zzch) {
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                this.zziq = new HashSet();
            }
            this.zziq.add(zzch);
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    @GuardedBy("mLock")
    public final boolean zzaz() {
        if (!this.zzig) {
            return false;
        }
        this.zzig = false;
        this.zzij.removeMessages(2);
        this.zzij.removeMessages(1);
        if (this.zzik != null) {
            this.zzik.unregister();
            this.zzik = null;
        }
        return true;
    }

    @GuardedBy("mLock")
    public final void zzb(int i, boolean z) {
        if (i == 1 && !z && !this.zzig) {
            this.zzig = true;
            if (this.zzik == null) {
                this.zzik = this.zzdg.registerCallbackOnUpdate(this.mContext.getApplicationContext(), new zzbb(this));
            }
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(1), this.zzih);
            this.zzij.sendMessageDelayed(this.zzij.obtainMessage(2), this.zzii);
        }
        this.zzir.zzce();
        this.zzie.onUnintentionalDisconnection(i);
        this.zzie.disableCallbacks();
        if (i == 2) {
            zzax();
        }
    }

    @GuardedBy("mLock")
    public final void zzb(Bundle bundle) {
        while (!this.zzgo.isEmpty()) {
            execute(this.zzgo.remove());
        }
        this.zzie.onConnectionSuccess(bundle);
    }

    public final void zzb(zzch zzch) {
        this.zzga.lock();
        try {
            if (this.zziq == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.zziq.remove(zzch)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzba()) {
                this.zzif.zzz();
            }
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzba() {
        boolean z = false;
        this.zzga.lock();
        try {
            if (this.zziq != null) {
                if (!this.zziq.isEmpty()) {
                    z = true;
                }
                this.zzga.unlock();
            }
            return z;
        } finally {
            this.zzga.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzbb() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    @GuardedBy("mLock")
    public final void zzc(ConnectionResult connectionResult) {
        if (!this.zzdg.isPlayServicesPossiblyUpdating(this.mContext, connectionResult.getErrorCode())) {
            zzaz();
        }
        if (!this.zzig) {
            this.zzie.onConnectionFailure(connectionResult);
            this.zzie.disableCallbacks();
        }
    }
}
