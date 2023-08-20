package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.StorageTask;

final class zzk implements zzab<OnFailureListener, TResult> {
    private final /* synthetic */ StorageTask zzbg;

    zzk(StorageTask storageTask) {
        this.zzbg = storageTask;
    }

    public final /* synthetic */ void zza(@NonNull Object obj, @NonNull Object obj2) {
        zzt.zzl().zzc(this.zzbg);
        ((OnFailureListener) obj).onFailure(((StorageTask.ProvideError) obj2).getError());
    }
}
