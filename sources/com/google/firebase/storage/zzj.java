package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageTask;

final class zzj implements zzab<OnSuccessListener<? super TResult>, TResult> {
    private final /* synthetic */ StorageTask zzbg;

    zzj(StorageTask storageTask) {
        this.zzbg = storageTask;
    }

    public final /* synthetic */ void zza(@NonNull Object obj, @NonNull Object obj2) {
        zzt.zzl().zzc(this.zzbg);
        ((OnSuccessListener) obj).onSuccess((StorageTask.ProvideError) obj2);
    }
}
