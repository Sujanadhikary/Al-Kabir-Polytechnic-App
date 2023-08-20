package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.SignInResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zzaj implements zzbc {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> zzdh;
    /* access modifiers changed from: private */
    public final Lock zzga;
    private final ClientSettings zzgf;
    private final Map<Api<?>, Boolean> zzgi;
    /* access modifiers changed from: private */
    public final GoogleApiAvailabilityLight zzgk;
    private ConnectionResult zzgt;
    /* access modifiers changed from: private */
    public final zzbd zzhf;
    private int zzhi;
    private int zzhj = 0;
    private int zzhk;
    private final Bundle zzhl = new Bundle();
    private final Set<Api.AnyClientKey> zzhm = new HashSet();
    /* access modifiers changed from: private */
    public SignInClient zzhn;
    private boolean zzho;
    /* access modifiers changed from: private */
    public boolean zzhp;
    private boolean zzhq;
    /* access modifiers changed from: private */
    public IAccountAccessor zzhr;
    private boolean zzhs;
    private boolean zzht;
    private ArrayList<Future<?>> zzhu = new ArrayList<>();

    public zzaj(zzbd zzbd, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends SignInClient, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zzhf = zzbd;
        this.zzgf = clientSettings;
        this.zzgi = map;
        this.zzgk = googleApiAvailabilityLight;
        this.zzdh = abstractClientBuilder;
        this.zzga = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zza(SignInResponse signInResponse) {
        if (zze(0)) {
            ConnectionResult connectionResult = signInResponse.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse resolveAccountResponse = signInResponse.getResolveAccountResponse();
                ConnectionResult connectionResult2 = resolveAccountResponse.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                    zze(connectionResult2);
                    return;
                }
                this.zzhq = true;
                this.zzhr = resolveAccountResponse.getAccountAccessor();
                this.zzhs = resolveAccountResponse.getSaveDefaultAccount();
                this.zzht = resolveAccountResponse.isFromCrossClientAuth();
                zzas();
            } else if (zzd(connectionResult)) {
                zzau();
                zzas();
            } else {
                zze(connectionResult);
            }
        }
    }

    private final void zza(boolean z) {
        if (this.zzhn != null) {
            if (this.zzhn.isConnected() && z) {
                this.zzhn.clearAccountFromSessionStore();
            }
            this.zzhn.disconnect();
            this.zzhr = null;
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zzar() {
        this.zzhk--;
        if (this.zzhk > 0) {
            return false;
        }
        if (this.zzhk < 0) {
            Log.w("GoogleApiClientConnecting", this.zzhf.zzfq.zzbb());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zze(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.zzgt == null) {
            return true;
        } else {
            this.zzhf.zzje = this.zzhi;
            zze(this.zzgt);
            return false;
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zzas() {
        if (this.zzhk == 0) {
            if (!this.zzhp || this.zzhq) {
                ArrayList arrayList = new ArrayList();
                this.zzhj = 1;
                this.zzhk = this.zzhf.zzil.size();
                for (Api.AnyClientKey next : this.zzhf.zzil.keySet()) {
                    if (!this.zzhf.zzjb.containsKey(next)) {
                        arrayList.add(this.zzhf.zzil.get(next));
                    } else if (zzar()) {
                        zzat();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zzhu.add(zzbg.zzbe().submit(new zzap(this, arrayList)));
                }
            }
        }
    }

    @GuardedBy("mLock")
    private final void zzat() {
        this.zzhf.zzbd();
        zzbg.zzbe().execute(new zzak(this));
        if (this.zzhn != null) {
            if (this.zzhs) {
                this.zzhn.saveDefaultAccount(this.zzhr, this.zzht);
            }
            zza(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zzhf.zzjb.keySet()) {
            this.zzhf.zzil.get(anyClientKey).disconnect();
        }
        this.zzhf.zzjf.zzb(this.zzhl.isEmpty() ? null : this.zzhl);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zzau() {
        this.zzhp = false;
        this.zzhf.zzfq.zzim = Collections.emptySet();
        for (Api.AnyClientKey next : this.zzhm) {
            if (!this.zzhf.zzjb.containsKey(next)) {
                this.zzhf.zzjb.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private final void zzav() {
        ArrayList arrayList = this.zzhu;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zzhu.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zzaw() {
        if (this.zzgf == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zzgf.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zzgf.getOptionalApiSettings();
        for (Api next : optionalApiSettings.keySet()) {
            if (!this.zzhf.zzjb.containsKey(next.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(next).mScopes);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003f, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if ((r6.hasResolution() ? true : r5.zzgk.getErrorResolutionIntent(r6.getErrorCode()) != null) != false) goto L_0x0015;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        if (r3 >= r5.zzhi) goto L_0x003f;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzb(com.google.android.gms.common.ConnectionResult r6, com.google.android.gms.common.api.Api<?> r7, boolean r8) {
        /*
            r5 = this;
            r1 = 0
            r0 = 1
            com.google.android.gms.common.api.Api$BaseClientBuilder r2 = r7.zzj()
            int r3 = r2.getPriority()
            if (r8 == 0) goto L_0x0015
            boolean r2 = r6.hasResolution()
            if (r2 == 0) goto L_0x002f
            r2 = r0
        L_0x0013:
            if (r2 == 0) goto L_0x003f
        L_0x0015:
            com.google.android.gms.common.ConnectionResult r2 = r5.zzgt
            if (r2 == 0) goto L_0x001d
            int r2 = r5.zzhi
            if (r3 >= r2) goto L_0x003f
        L_0x001d:
            if (r0 == 0) goto L_0x0023
            r5.zzgt = r6
            r5.zzhi = r3
        L_0x0023:
            com.google.android.gms.common.api.internal.zzbd r0 = r5.zzhf
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r0 = r0.zzjb
            com.google.android.gms.common.api.Api$AnyClientKey r1 = r7.getClientKey()
            r0.put(r1, r6)
            return
        L_0x002f:
            com.google.android.gms.common.GoogleApiAvailabilityLight r2 = r5.zzgk
            int r4 = r6.getErrorCode()
            android.content.Intent r2 = r2.getErrorResolutionIntent(r4)
            if (r2 == 0) goto L_0x003d
            r2 = r0
            goto L_0x0013
        L_0x003d:
            r2 = r1
            goto L_0x0013
        L_0x003f:
            r0 = r1
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzaj.zzb(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zzd(ConnectionResult connectionResult) {
        return this.zzho && !connectionResult.hasResolution();
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zze(ConnectionResult connectionResult) {
        zzav();
        zza(!connectionResult.hasResolution());
        this.zzhf.zzf(connectionResult);
        this.zzhf.zzjf.zzc(connectionResult);
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zze(int i) {
        if (this.zzhj == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zzhf.zzfq.zzbb());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.zzhk).toString());
        String zzf = zzf(this.zzhj);
        String zzf2 = zzf(i);
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(zzf).length() + 70 + String.valueOf(zzf2).length()).append("GoogleApiClient connecting is in step ").append(zzf).append(" but received callback for step ").append(zzf2).toString(), new Exception());
        zze(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    private static String zzf(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    public final void begin() {
        this.zzhf.zzjb.clear();
        this.zzhp = false;
        this.zzgt = null;
        this.zzhj = 0;
        this.zzho = true;
        this.zzhq = false;
        this.zzhs = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zzgi.keySet()) {
            Api.Client client = this.zzhf.zzil.get(next.getClientKey());
            boolean z2 = (next.zzj().getPriority() == 1) | z;
            boolean booleanValue = this.zzgi.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zzhp = true;
                if (booleanValue) {
                    this.zzhm.add(next.getClientKey());
                } else {
                    this.zzho = false;
                }
            }
            hashMap.put(client, new zzal(this, next, booleanValue));
            z = z2;
        }
        if (z) {
            this.zzhp = false;
        }
        if (this.zzhp) {
            this.zzgf.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zzhf.zzfq)));
            zzas zzas = new zzas(this, (zzak) null);
            this.zzhn = (SignInClient) this.zzdh.buildClient(this.mContext, this.zzhf.zzfq.getLooper(), this.zzgf, this.zzgf.getSignInOptions(), zzas, zzas);
        }
        this.zzhk = this.zzhf.zzil.size();
        this.zzhu.add(zzbg.zzbe().submit(new zzam(this, hashMap)));
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zzav();
        zza(true);
        this.zzhf.zzf((ConnectionResult) null);
        return true;
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.zzhf.zzfq.zzgo.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        if (zze(1)) {
            if (bundle != null) {
                this.zzhl.putAll(bundle);
            }
            if (zzar()) {
                zzat();
            }
        }
    }

    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i) {
        zze(new ConnectionResult(8, (PendingIntent) null));
    }

    @GuardedBy("mLock")
    public final void zza(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zze(1)) {
            zzb(connectionResult, api, z);
            if (zzar()) {
                zzat();
            }
        }
    }
}
