package com.google.android.gms.common.api.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
@KeepForSdk
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> zzez = new zzo();
    @KeepName
    private zza mResultGuardian;
    private Status mStatus;
    /* access modifiers changed from: private */
    public R zzdm;
    private final Object zzfa;
    private final CallbackHandler<R> zzfb;
    private final WeakReference<GoogleApiClient> zzfc;
    private final CountDownLatch zzfd;
    private final ArrayList<PendingResult.StatusListener> zzfe;
    private ResultCallback<? super R> zzff;
    private final AtomicReference<zzcn> zzfg;
    private volatile boolean zzfh;
    private boolean zzfi;
    private boolean zzfj;
    private ICancelToken zzfk;
    private volatile zzch<R> zzfl;
    private boolean zzfm;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends Handler {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    ResultCallback resultCallback = (ResultCallback) pair.first;
                    Result result = (Result) pair.second;
                    try {
                        resultCallback.onResult(result);
                        return;
                    } catch (RuntimeException e) {
                        BasePendingResult.zzb(result);
                        throw e;
                    }
                case 2:
                    ((BasePendingResult) message.obj).zzb(Status.RESULT_TIMEOUT);
                    return;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    return;
            }
        }

        public final void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }
    }

    private final class zza {
        private zza() {
        }

        /* synthetic */ zza(BasePendingResult basePendingResult, zzo zzo) {
            this();
        }

        /* access modifiers changed from: protected */
        public final void finalize() throws Throwable {
            BasePendingResult.zzb(BasePendingResult.this.zzdm);
            super.finalize();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(Looper.getMainLooper());
        this.zzfc = new WeakReference<>((Object) null);
    }

    @KeepForSdk
    @Deprecated
    protected BasePendingResult(Looper looper) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(looper);
        this.zzfc = new WeakReference<>((Object) null);
    }

    @KeepForSdk
    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zzfc = new WeakReference<>(googleApiClient);
    }

    @KeepForSdk
    @VisibleForTesting
    protected BasePendingResult(@NonNull CallbackHandler<R> callbackHandler) {
        this.zzfa = new Object();
        this.zzfd = new CountDownLatch(1);
        this.zzfe = new ArrayList<>();
        this.zzfg = new AtomicReference<>();
        this.zzfm = false;
        this.zzfb = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zzfc = new WeakReference<>((Object) null);
    }

    private final R get() {
        R r;
        boolean z = true;
        synchronized (this.zzfa) {
            if (this.zzfh) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.zzdm;
            this.zzdm = null;
            this.zzff = null;
            this.zzfh = true;
        }
        zzcn andSet = this.zzfg.getAndSet((Object) null);
        if (andSet != null) {
            andSet.zzc(this);
        }
        return r;
    }

    private final void zza(R r) {
        this.zzdm = r;
        this.zzfk = null;
        this.zzfd.countDown();
        this.mStatus = this.zzdm.getStatus();
        if (this.zzfi) {
            this.zzff = null;
        } else if (this.zzff != null) {
            this.zzfb.removeMessages(2);
            this.zzfb.zza(this.zzff, get());
        } else if (this.zzdm instanceof Releasable) {
            this.mResultGuardian = new zza(this, (zzo) null);
        }
        ArrayList arrayList = this.zzfe;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((PendingResult.StatusListener) obj).onComplete(this.mStatus);
        }
        this.zzfe.clear();
    }

    public static void zzb(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public final void addStatusListener(PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zzfa) {
            if (isReady()) {
                statusListener.onComplete(this.mStatus);
            } else {
                this.zzfe.add(statusListener);
            }
        }
    }

    public final R await() {
        boolean z = true;
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        Preconditions.checkState(!this.zzfh, "Result has already been consumed");
        if (this.zzfl != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.zzfd.await();
        } catch (InterruptedException e) {
            zzb(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = true;
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
        if (this.zzfl != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.zzfd.await(j, timeUnit)) {
                zzb(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException e) {
            zzb(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzfa
            monitor-enter(r1)
            boolean r0 = r2.zzfi     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.zzfh     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.common.internal.ICancelToken r0 = r2.zzfk     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.internal.ICancelToken r0 = r2.zzfk     // Catch:{ RemoteException -> 0x002c }
            r0.cancel()     // Catch:{ RemoteException -> 0x002c }
        L_0x0016:
            R r0 = r2.zzdm     // Catch:{ all -> 0x0029 }
            zzb((com.google.android.gms.common.api.Result) r0)     // Catch:{ all -> 0x0029 }
            r0 = 1
            r2.zzfi = r0     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.RESULT_CANCELED     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Result r0 = r2.createFailedResult(r0)     // Catch:{ all -> 0x0029 }
            r2.zza(r0)     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            goto L_0x000c
        L_0x0029:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.cancel():void");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @NonNull
    public abstract R createFailedResult(Status status);

    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzfa) {
            z = this.zzfi;
        }
        return z;
    }

    @KeepForSdk
    public final boolean isReady() {
        return this.zzfd.getCount() == 0;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void setCancelToken(ICancelToken iCancelToken) {
        synchronized (this.zzfa) {
            this.zzfk = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(R r) {
        boolean z = true;
        synchronized (this.zzfa) {
            if (this.zzfj || this.zzfi) {
                zzb((Result) r);
                return;
            }
            if (isReady()) {
            }
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.zzfh) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            zza(r);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r5.zzfa
            monitor-enter(r3)
            if (r6 != 0) goto L_0x000c
            r0 = 0
            r5.zzff = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r5.zzfh     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zzch<R> r2 = r5.zzfl     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r0, r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r5.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r5.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r0 = r5.zzfb     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r5.get()     // Catch:{ all -> 0x0027 }
            r0.zza(r6, r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r5.zzff = r6     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r6.zzfa
            monitor-enter(r3)
            if (r7 != 0) goto L_0x000c
            r0 = 0
            r6.zzff = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r6.zzfh     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.Preconditions.checkState(r2, r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.zzch<R> r2 = r6.zzfl     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.Preconditions.checkState(r0, r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r6.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r6.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r0 = r6.zzfb     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r6.get()     // Catch:{ all -> 0x0027 }
            r0.zza(r7, r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r6.zzff = r7     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.internal.BasePendingResult$CallbackHandler<R> r0 = r6.zzfb     // Catch:{ all -> 0x0027 }
            long r4 = r10.toMillis(r8)     // Catch:{ all -> 0x0027 }
            r1 = 2
            android.os.Message r1 = r0.obtainMessage(r1, r6)     // Catch:{ all -> 0x0027 }
            r0.sendMessageDelayed(r1, r4)     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.BasePendingResult.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        Preconditions.checkState(!this.zzfh, "Result has already been consumed.");
        synchronized (this.zzfa) {
            Preconditions.checkState(this.zzfl == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zzff == null, "Cannot call then() if callbacks are set.");
            if (this.zzfi) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.zzfm = true;
            this.zzfl = new zzch<>(this.zzfc);
            then = this.zzfl.then(resultTransform);
            if (isReady()) {
                this.zzfb.zza(this.zzfl, get());
            } else {
                this.zzff = this.zzfl;
            }
        }
        return then;
    }

    public final void zza(zzcn zzcn) {
        this.zzfg.set(zzcn);
    }

    public final void zzb(Status status) {
        synchronized (this.zzfa) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zzfj = true;
            }
        }
    }

    public final Integer zzo() {
        return null;
    }

    public final boolean zzw() {
        boolean isCanceled;
        synchronized (this.zzfa) {
            if (((GoogleApiClient) this.zzfc.get()) == null || !this.zzfm) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zzx() {
        this.zzfm = this.zzfm || zzez.get().booleanValue();
    }
}
