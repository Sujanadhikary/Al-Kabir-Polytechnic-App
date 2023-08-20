package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public final class GmsClientEventManager implements Handler.Callback {
    private final Handler mHandler;
    private final Object mLock = new Object();
    private final GmsClientEventState zztf;
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zztg = new ArrayList<>();
    @VisibleForTesting
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> zzth = new ArrayList<>();
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> zzti = new ArrayList<>();
    private volatile boolean zztj = false;
    private final AtomicInteger zztk = new AtomicInteger(0);
    private boolean zztl = false;

    @VisibleForTesting
    public interface GmsClientEventState {
        Bundle getConnectionHint();

        boolean isConnected();
    }

    public GmsClientEventManager(Looper looper, GmsClientEventState gmsClientEventState) {
        this.zztf = gmsClientEventState;
        this.mHandler = new Handler(looper, this);
    }

    public final boolean areCallbacksEnabled() {
        return this.zztj;
    }

    public final void disableCallbacks() {
        this.zztj = false;
        this.zztk.incrementAndGet();
    }

    public final void enableCallbacks() {
        this.zztj = true;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.mLock) {
                if (this.zztj && this.zztf.isConnected() && this.zztg.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.zztf.getConnectionHint());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        return false;
    }

    public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            contains = this.zztg.contains(connectionCallbacks);
        }
        return contains;
    }

    public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            contains = this.zzti.contains(onConnectionFailedListener);
        }
        return contains;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnectionFailure(com.google.android.gms.common.ConnectionResult r8) {
        /*
            r7 = this;
            r1 = 1
            r2 = 0
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r3 = r7.mHandler
            android.os.Looper r3 = r3.getLooper()
            if (r0 != r3) goto L_0x0047
            r0 = r1
        L_0x000f:
            java.lang.String r3 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.Preconditions.checkState(r0, r3)
            android.os.Handler r0 = r7.mHandler
            r0.removeMessages(r1)
            java.lang.Object r3 = r7.mLock
            monitor-enter(r3)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0055 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r1 = r7.zzti     // Catch:{ all -> 0x0055 }
            r0.<init>(r1)     // Catch:{ all -> 0x0055 }
            java.util.concurrent.atomic.AtomicInteger r1 = r7.zztk     // Catch:{ all -> 0x0055 }
            int r4 = r1.get()     // Catch:{ all -> 0x0055 }
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ all -> 0x0055 }
            int r5 = r0.size()     // Catch:{ all -> 0x0055 }
        L_0x002f:
            if (r2 >= r5) goto L_0x0058
            java.lang.Object r1 = r0.get(r2)     // Catch:{ all -> 0x0055 }
            int r2 = r2 + 1
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r1 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r1     // Catch:{ all -> 0x0055 }
            boolean r6 = r7.zztj     // Catch:{ all -> 0x0055 }
            if (r6 == 0) goto L_0x0045
            java.util.concurrent.atomic.AtomicInteger r6 = r7.zztk     // Catch:{ all -> 0x0055 }
            int r6 = r6.get()     // Catch:{ all -> 0x0055 }
            if (r6 == r4) goto L_0x0049
        L_0x0045:
            monitor-exit(r3)     // Catch:{ all -> 0x0055 }
        L_0x0046:
            return
        L_0x0047:
            r0 = r2
            goto L_0x000f
        L_0x0049:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r6 = r7.zzti     // Catch:{ all -> 0x0055 }
            boolean r6 = r6.contains(r1)     // Catch:{ all -> 0x0055 }
            if (r6 == 0) goto L_0x002f
            r1.onConnectionFailed(r8)     // Catch:{ all -> 0x0055 }
            goto L_0x002f
        L_0x0055:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0055 }
            throw r0
        L_0x0058:
            monitor-exit(r3)     // Catch:{ all -> 0x0055 }
            goto L_0x0046
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.GmsClientEventManager.onConnectionFailure(com.google.android.gms.common.ConnectionResult):void");
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void onConnectionSuccess() {
        synchronized (this.mLock) {
            onConnectionSuccess(this.zztf.getConnectionHint());
        }
    }

    @VisibleForTesting
    public final void onConnectionSuccess(Bundle bundle) {
        boolean z = true;
        int i = 0;
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.mLock) {
            Preconditions.checkState(!this.zztl);
            this.mHandler.removeMessages(1);
            this.zztl = true;
            if (this.zzth.size() != 0) {
                z = false;
            }
            Preconditions.checkState(z);
            ArrayList arrayList = new ArrayList(this.zztg);
            int i2 = this.zztk.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i < size) {
                Object obj = arrayList2.get(i);
                i++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (this.zztj && this.zztf.isConnected() && this.zztk.get() == i2) {
                    if (!this.zzth.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnected(bundle);
                    }
                }
            }
            this.zzth.clear();
            this.zztl = false;
        }
    }

    @VisibleForTesting
    public final void onUnintentionalDisconnection(int i) {
        int i2 = 0;
        Preconditions.checkState(Looper.myLooper() == this.mHandler.getLooper(), "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.mLock) {
            this.zztl = true;
            ArrayList arrayList = new ArrayList(this.zztg);
            int i3 = this.zztk.get();
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            while (i2 < size) {
                Object obj = arrayList2.get(i2);
                i2++;
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) obj;
                if (this.zztj && this.zztk.get() == i3) {
                    if (this.zztg.contains(connectionCallbacks)) {
                        connectionCallbacks.onConnectionSuspended(i);
                    }
                }
            }
            this.zzth.clear();
            this.zztl = false;
        }
    }

    public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            if (this.zztg.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.zztg.add(connectionCallbacks);
            }
        }
        if (this.zztf.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (this.zzti.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.zzti.add(onConnectionFailedListener);
            }
        }
    }

    public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        Preconditions.checkNotNull(connectionCallbacks);
        synchronized (this.mLock) {
            if (!this.zztg.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.zztl) {
                this.zzth.add(connectionCallbacks);
            }
        }
    }

    public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        Preconditions.checkNotNull(onConnectionFailedListener);
        synchronized (this.mLock) {
            if (!this.zzti.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }
}
