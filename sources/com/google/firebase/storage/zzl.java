package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;

final class zzl implements zzab<OnCompleteListener<TResult>, TResult> {
    private final /* synthetic */ StorageTask zzbg;

    zzl(StorageTask storageTask) {
        this.zzbg = storageTask;
    }

    public final /* synthetic */ void zza(@NonNull Object obj, @NonNull Object obj2) {
        zzt.zzl().zzc(this.zzbg);
        ((OnCompleteListener) obj).onComplete(this.zzbg);
    }
}
