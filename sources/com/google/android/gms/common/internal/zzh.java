package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Message;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.util.Log;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import javax.annotation.concurrent.GuardedBy;

final class zzh extends GmsClientSupervisor implements Handler.Callback {
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */
    public final Context zzau;
    /* access modifiers changed from: private */
    @GuardedBy("mConnectionStatus")
    public final HashMap<GmsClientSupervisor.ConnectionStatusConfig, zzi> zztr = new HashMap<>();
    /* access modifiers changed from: private */
    public final ConnectionTracker zzts;
    private final long zztt;
    /* access modifiers changed from: private */
    public final long zztu;

    zzh(Context context) {
        this.zzau = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
        this.zzts = ConnectionTracker.getInstance();
        this.zztt = 5000;
        this.zztu = 300000;
    }

    /* access modifiers changed from: protected */
    public final boolean bindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            zzi zzi = this.zztr.get(connectionStatusConfig);
            if (zzi != null) {
                this.mHandler.removeMessages(0, connectionStatusConfig);
                if (!zzi.zza(serviceConnection)) {
                    zzi.zza(serviceConnection, str);
                    switch (zzi.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzi.getComponentName(), zzi.getBinder());
                            break;
                        case 2:
                            zzi.zzj(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(connectionStatusConfig);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 81).append("Trying to bind a GmsServiceConnection that was already connected before.  config=").append(valueOf).toString());
                }
            } else {
                zzi = new zzi(this, connectionStatusConfig);
                zzi.zza(serviceConnection, str);
                zzi.zzj(str);
                this.zztr.put(connectionStatusConfig, zzi);
            }
            isBound = zzi.isBound();
        }
        return isBound;
    }

    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                synchronized (this.zztr) {
                    GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                    zzi zzi = this.zztr.get(connectionStatusConfig);
                    if (zzi != null && zzi.zzcv()) {
                        if (zzi.isBound()) {
                            zzi.zzk("GmsClientSupervisor");
                        }
                        this.zztr.remove(connectionStatusConfig);
                    }
                }
                return true;
            case 1:
                synchronized (this.zztr) {
                    GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig2 = (GmsClientSupervisor.ConnectionStatusConfig) message.obj;
                    zzi zzi2 = this.zztr.get(connectionStatusConfig2);
                    if (zzi2 != null && zzi2.getState() == 3) {
                        String valueOf = String.valueOf(connectionStatusConfig2);
                        Log.wtf("GmsClientSupervisor", new StringBuilder(String.valueOf(valueOf).length() + 47).append("Timeout waiting for ServiceConnection callback ").append(valueOf).toString(), new Exception());
                        ComponentName componentName = zzi2.getComponentName();
                        if (componentName == null) {
                            componentName = connectionStatusConfig2.getComponentName();
                        }
                        zzi2.onServiceDisconnected(componentName == null ? new ComponentName(connectionStatusConfig2.getPackage(), EnvironmentCompat.MEDIA_UNKNOWN) : componentName);
                    }
                }
                return true;
            default:
                return false;
        }
    }

    @VisibleForTesting
    public final void resetForTesting() {
        synchronized (this.zztr) {
            for (zzi next : this.zztr.values()) {
                this.mHandler.removeMessages(0, next.zztx);
                if (next.isBound()) {
                    next.zzk("GmsClientSupervisor");
                }
            }
            this.zztr.clear();
        }
    }

    /* access modifiers changed from: protected */
    public final void unbindService(GmsClientSupervisor.ConnectionStatusConfig connectionStatusConfig, ServiceConnection serviceConnection, String str) {
        Preconditions.checkNotNull(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.zztr) {
            zzi zzi = this.zztr.get(connectionStatusConfig);
            if (zzi == null) {
                String valueOf = String.valueOf(connectionStatusConfig);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Nonexistent connection status for service config: ").append(valueOf).toString());
            } else if (!zzi.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(connectionStatusConfig);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 76).append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=").append(valueOf2).toString());
            } else {
                zzi.zzb(serviceConnection, str);
                if (zzi.zzcv()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, connectionStatusConfig), this.zztt);
                }
            }
        }
    }
}
