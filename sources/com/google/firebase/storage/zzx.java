package com.google.firebase.storage;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzc;
import com.google.android.gms.internal.firebase_storage.zzj;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

final class zzx<TListenerType, TResult extends StorageTask.ProvideError> {
    private final Queue<TListenerType> zzck = new ConcurrentLinkedQueue();
    private final HashMap<TListenerType, zzj> zzcl = new HashMap<>();
    private StorageTask<TResult> zzcm;
    private int zzcn;
    /* access modifiers changed from: private */
    public zzab<TListenerType, TResult> zzco;

    public zzx(@NonNull StorageTask<TResult> storageTask, int i, @NonNull zzab<TListenerType, TResult> zzab) {
        this.zzcm = storageTask;
        this.zzcn = i;
        this.zzco = zzab;
    }

    public final void zza(@Nullable Activity activity, @Nullable Executor executor, @NonNull TListenerType tlistenertype) {
        boolean z;
        zzj zzj;
        boolean z2 = true;
        Preconditions.checkNotNull(tlistenertype);
        synchronized (this.zzcm.mSyncObject) {
            z = (this.zzcm.zzg() & this.zzcn) != 0;
            this.zzck.add(tlistenertype);
            zzj = new zzj(executor);
            this.zzcl.put(tlistenertype, zzj);
            if (activity != null) {
                if (Build.VERSION.SDK_INT >= 17) {
                    if (activity.isDestroyed()) {
                        z2 = false;
                    }
                    Preconditions.checkArgument(z2, "Activity is already destroyed!");
                }
                zzc.zzs().zza(activity, tlistenertype, new zzy(this, tlistenertype));
            }
        }
        if (z) {
            zzj.zze(new zzz(this, tlistenertype, this.zzcm.zzh()));
        }
    }

    public final void zzc(@NonNull TListenerType tlistenertype) {
        Preconditions.checkNotNull(tlistenertype);
        synchronized (this.zzcm.mSyncObject) {
            this.zzcl.remove(tlistenertype);
            this.zzck.remove(tlistenertype);
            zzc.zzs().zzd(tlistenertype);
        }
    }

    public final void zzp() {
        if ((this.zzcm.zzg() & this.zzcn) != 0) {
            TResult zzh = this.zzcm.zzh();
            for (Object next : this.zzck) {
                zzj zzj = this.zzcl.get(next);
                if (zzj != null) {
                    zzj.zze(new zzaa(this, next, zzh));
                }
            }
        }
    }
}
