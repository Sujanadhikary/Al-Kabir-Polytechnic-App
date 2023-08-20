package com.google.android.gms.internal.firebase_database;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzkh implements zzdt {
    private ScheduledThreadPoolExecutor zzuj = new zzki(this, 1, new zzkj(this, (zzki) null));

    public zzkh() {
        this.zzuj.setKeepAliveTime(3, TimeUnit.SECONDS);
    }

    public final void restart() {
        this.zzuj.setCorePoolSize(1);
    }

    public final void shutdown() {
        this.zzuj.setCorePoolSize(0);
    }

    public abstract void zza(Throwable th);

    public final void zzc(Runnable runnable) {
        this.zzuj.execute(runnable);
    }

    public final ScheduledExecutorService zzs() {
        return this.zzuj;
    }
}
