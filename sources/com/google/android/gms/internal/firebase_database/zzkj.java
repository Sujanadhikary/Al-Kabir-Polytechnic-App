package com.google.android.gms.internal.firebase_database;

import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

final class zzkj implements ThreadFactory {
    final /* synthetic */ zzkh zzuk;

    private zzkj(zzkh zzkh) {
        this.zzuk = zzkh;
    }

    /* synthetic */ zzkj(zzkh zzkh, zzki zzki) {
        this(zzkh);
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
        zzey zzey = zzey.zzlr;
        zzey.zza(newThread, "FirebaseDatabaseWorker");
        zzey.zza(newThread, true);
        zzey.zza(newThread, (Thread.UncaughtExceptionHandler) new zzkk(this));
        return newThread;
    }
}
