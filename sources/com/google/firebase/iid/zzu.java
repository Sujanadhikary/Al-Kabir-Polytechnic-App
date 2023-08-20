package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

final class zzu implements ServiceConnection {
    @GuardedBy("this")
    int state;
    final Messenger zzbj;
    zzz zzbk;
    @GuardedBy("this")
    final Queue<zzab<?>> zzbl;
    @GuardedBy("this")
    final SparseArray<zzab<?>> zzbm;
    final /* synthetic */ zzs zzbn;

    private zzu(zzs zzs) {
        this.zzbn = zzs;
        this.state = 0;
        this.zzbj = new Messenger(new Handler(Looper.getMainLooper(), new zzv(this)));
        this.zzbl = new ArrayDeque();
        this.zzbm = new SparseArray<>();
    }

    private final void zzt() {
        this.zzbn.zzbg.execute(new zzx(this));
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service connected");
        }
        if (iBinder == null) {
            zza(0, "Null service connection");
        } else {
            try {
                this.zzbk = new zzz(iBinder);
                this.state = 2;
                zzt();
            } catch (RemoteException e) {
                zza(0, e.getMessage());
            }
        }
        return;
    }

    public final synchronized void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("MessengerIpcClient", 2)) {
            Log.v("MessengerIpcClient", "Service disconnected");
        }
        zza(2, "Service disconnected");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i) {
        zzab zzab = this.zzbm.get(i);
        if (zzab != null) {
            Log.w("MessengerIpcClient", new StringBuilder(31).append("Timing out request: ").append(i).toString());
            this.zzbm.remove(i);
            zzab.zza(new zzac(3, "Timed out waiting for response"));
            zzu();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(int i, String str) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(str);
            Log.d("MessengerIpcClient", valueOf.length() != 0 ? "Disconnected: ".concat(valueOf) : new String("Disconnected: "));
        }
        switch (this.state) {
            case 0:
                throw new IllegalStateException();
            case 1:
            case 2:
                if (Log.isLoggable("MessengerIpcClient", 2)) {
                    Log.v("MessengerIpcClient", "Unbinding service");
                }
                this.state = 4;
                ConnectionTracker.getInstance().unbindService(this.zzbn.zzz, this);
                zzac zzac = new zzac(i, str);
                for (zzab zza : this.zzbl) {
                    zza.zza(zzac);
                }
                this.zzbl.clear();
                for (int i2 = 0; i2 < this.zzbm.size(); i2++) {
                    this.zzbm.valueAt(i2).zza(zzac);
                }
                this.zzbm.clear();
                break;
            case 3:
                this.state = 4;
                break;
            case 4:
                break;
            default:
                throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(Message message) {
        int i = message.arg1;
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            Log.d("MessengerIpcClient", new StringBuilder(41).append("Received response to request: ").append(i).toString());
        }
        synchronized (this) {
            zzab zzab = this.zzbm.get(i);
            if (zzab == null) {
                Log.w("MessengerIpcClient", new StringBuilder(50).append("Received response for unknown request: ").append(i).toString());
            } else {
                this.zzbm.remove(i);
                zzu();
                Bundle data = message.getData();
                if (data.getBoolean("unsupported", false)) {
                    zzab.zza(new zzac(4, "Not supported by GmsCore"));
                } else {
                    zzab.zzb(data);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(zzab zzab) {
        boolean z = false;
        boolean z2 = true;
        synchronized (this) {
            switch (this.state) {
                case 0:
                    this.zzbl.add(zzab);
                    if (this.state == 0) {
                        z = true;
                    }
                    Preconditions.checkState(z);
                    if (Log.isLoggable("MessengerIpcClient", 2)) {
                        Log.v("MessengerIpcClient", "Starting bind to GmsCore");
                    }
                    this.state = 1;
                    Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                    intent.setPackage("com.google.android.gms");
                    if (ConnectionTracker.getInstance().bindService(this.zzbn.zzz, intent, this, 1)) {
                        this.zzbn.zzbg.schedule(new zzw(this), 30, TimeUnit.SECONDS);
                        break;
                    } else {
                        zza(0, "Unable to bind to service");
                        break;
                    }
                case 1:
                    this.zzbl.add(zzab);
                    break;
                case 2:
                    this.zzbl.add(zzab);
                    zzt();
                    break;
                case 3:
                case 4:
                    z2 = false;
                    break;
                default:
                    throw new IllegalStateException(new StringBuilder(26).append("Unknown state: ").append(this.state).toString());
            }
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzu() {
        if (this.state == 2 && this.zzbl.isEmpty() && this.zzbm.size() == 0) {
            if (Log.isLoggable("MessengerIpcClient", 2)) {
                Log.v("MessengerIpcClient", "Finished handling requests, unbinding");
            }
            this.state = 3;
            ConnectionTracker.getInstance().unbindService(this.zzbn.zzz, this);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzv() {
        if (this.state == 1) {
            zza(1, "Timed out while binding");
        }
    }
}
