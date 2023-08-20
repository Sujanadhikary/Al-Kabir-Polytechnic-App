package com.google.android.gms.internal.firebase_database;

final class zzin implements zzio {
    private final long zzrt;

    public zzin(zzja zzja) {
        this.zzrt = Math.max(512, (long) Math.sqrt((double) (zzkl.zzn(zzja) * 100)));
    }

    public final boolean zze(zzim zzim) {
        return ((long) zzim.zzfp()) > this.zzrt && (zzim.zzfq().isEmpty() || !zzim.zzfq().zzbz().equals(zzid.zzfe()));
    }
}
