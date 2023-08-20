package com.google.firebase.storage;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzu {
    private static zzu zzbn = new zzu();
    private static BlockingQueue<Runnable> zzbo = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzbp = new ThreadPoolExecutor(5, 5, 5, TimeUnit.SECONDS, zzbo, new zzv("Command-"));
    private static BlockingQueue<Runnable> zzbq = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzbr = new ThreadPoolExecutor(2, 2, 5, TimeUnit.SECONDS, zzbq, new zzv("Upload-"));
    private static BlockingQueue<Runnable> zzbs = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzbt = new ThreadPoolExecutor(3, 3, 5, TimeUnit.SECONDS, zzbs, new zzv("Download-"));
    private static BlockingQueue<Runnable> zzbu = new LinkedBlockingQueue(128);
    private static final ThreadPoolExecutor zzbv = new ThreadPoolExecutor(1, 1, 5, TimeUnit.SECONDS, zzbu, new zzv("Callbacks-"));

    static {
        zzbp.allowCoreThreadTimeOut(true);
        zzbr.allowCoreThreadTimeOut(true);
        zzbt.allowCoreThreadTimeOut(true);
        zzbv.allowCoreThreadTimeOut(true);
    }

    public static void zza(Runnable runnable) {
        zzbp.execute(runnable);
    }

    public static void zzb(Runnable runnable) {
        zzbr.execute(runnable);
    }

    public static void zzc(Runnable runnable) {
        zzbt.execute(runnable);
    }

    public static void zzd(Runnable runnable) {
        zzbv.execute(runnable);
    }
}
