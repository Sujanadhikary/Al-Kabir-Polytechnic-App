package com.google.android.gms.internal.firebase_database;

import java.util.concurrent.ScheduledFuture;

final class zzbn implements Runnable {
    private final /* synthetic */ Runnable zzgj;
    private final /* synthetic */ zzbm zzgk;

    zzbn(zzbm zzbm, Runnable runnable) {
        this.zzgk = zzbm;
        this.zzgj = runnable;
    }

    public final void run() {
        ScheduledFuture unused = this.zzgk.zzgg = null;
        this.zzgj.run();
    }
}
