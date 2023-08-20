package com.google.android.gms.internal.firebase_database;

import java.lang.Thread;

final class zzkk implements Thread.UncaughtExceptionHandler {
    private final /* synthetic */ zzkj zzul;

    zzkk(zzkj zzkj) {
        this.zzul = zzkj;
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        this.zzul.zzuk.zza(th);
    }
}
