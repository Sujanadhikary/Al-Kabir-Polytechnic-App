package com.google.android.gms.internal.firebase_storage;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.zzu;
import java.util.concurrent.Executor;

public final class zzj {
    private static boolean zzdy = false;
    private final Handler mHandler;
    private final Executor zzdx;

    public zzj(@Nullable Executor executor) {
        this.zzdx = executor;
        if (this.zzdx == null) {
            this.mHandler = new Handler(Looper.getMainLooper());
        } else {
            this.mHandler = null;
        }
    }

    public final void zze(@NonNull Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.mHandler != null) {
            this.mHandler.post(runnable);
        } else if (this.zzdx != null) {
            this.zzdx.execute(runnable);
        } else {
            zzu.zzd(runnable);
        }
    }
}
