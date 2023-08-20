package com.google.android.gms.internal.firebase_database;

public final class zzkm implements zzkf {
    private final zzkf zzum;
    private long zzun = 0;

    public zzkm(zzkf zzkf, long j) {
        this.zzum = zzkf;
        this.zzun = 0;
    }

    public final long millis() {
        return this.zzum.millis() + this.zzun;
    }

    public final void zzn(long j) {
        this.zzun = j;
    }
}
