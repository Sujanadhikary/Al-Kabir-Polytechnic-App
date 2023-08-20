package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.firebase.storage.StorageTask;

final class zzn implements zzab<OnPausedListener<? super TResult>, TResult> {
    zzn(StorageTask storageTask) {
    }

    public final /* synthetic */ void zza(@NonNull Object obj, @NonNull Object obj2) {
        ((OnPausedListener) obj).onPaused((StorageTask.ProvideError) obj2);
    }
}
