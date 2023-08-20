package com.google.firebase.storage;

import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class zzv implements ThreadFactory {
    private final AtomicInteger zzbw = new AtomicInteger(1);
    private final String zzbx;

    zzv(@NonNull String str) {
        this.zzbx = str;
    }

    public final Thread newThread(@NonNull Runnable runnable) {
        String str = this.zzbx;
        Thread thread = new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 27).append("FirebaseStorage-").append(str).append(this.zzbw.getAndIncrement()).toString());
        thread.setDaemon(false);
        thread.setPriority(9);
        return thread;
    }
}
