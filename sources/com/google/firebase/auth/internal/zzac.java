package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

public final class zzac implements Executor {
    private static zzac zzls = new zzac();
    private Handler handler = new Handler(Looper.getMainLooper());

    private zzac() {
    }

    public static zzac zzbk() {
        return zzls;
    }

    public final void execute(@NonNull Runnable runnable) {
        this.handler.post(runnable);
    }
}
