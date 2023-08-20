package com.google.android.gms.internal.firebase_database;

import java.io.EOFException;

final class zzbl implements Runnable {
    private final /* synthetic */ zzbh zzfh;
    private final /* synthetic */ zzjx zzfj;

    zzbl(zzbh zzbh, zzjx zzjx) {
        this.zzfh = zzbh;
        this.zzfj = zzjx;
    }

    public final void run() {
        if (this.zzfj.getCause() == null || !(this.zzfj.getCause() instanceof EOFException)) {
            this.zzfh.zzff.zzbs.zza("WebSocket error.", this.zzfj, new Object[0]);
        } else {
            this.zzfh.zzff.zzbs.zza("WebSocket reached EOF.", (Throwable) null, new Object[0]);
        }
        this.zzfh.zzff.zzat();
    }
}
