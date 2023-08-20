package com.google.firebase.auth.api.internal;

final class zzdg implements Runnable {
    private final /* synthetic */ zzdh zziv;
    private final /* synthetic */ zzdb zziw;

    zzdg(zzdb zzdb, zzdh zzdh) {
        this.zziw = zzdb;
        this.zziv = zzdh;
    }

    public final void run() {
        synchronized (this.zziw.zzir.zzic) {
            if (!this.zziw.zzir.zzic.isEmpty()) {
                this.zziv.zza(this.zziw.zzir.zzic.get(0), new Object[0]);
            }
        }
    }
}
