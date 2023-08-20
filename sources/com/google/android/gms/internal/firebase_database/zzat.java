package com.google.android.gms.internal.firebase_database;

import java.util.concurrent.ScheduledFuture;

final class zzat implements Runnable {
    private final /* synthetic */ zzal zzdu;

    zzat(zzal zzal) {
        this.zzdu = zzal;
    }

    public final void run() {
        ScheduledFuture unused = this.zzdu.zzdq = null;
        if (this.zzdu.zzah()) {
            this.zzdu.interrupt("connection_idle");
        } else {
            this.zzdu.zzag();
        }
    }
}
