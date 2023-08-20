package com.google.android.gms.internal.firebase_database;

public final class zzhk {
    private final zzgu zzqa;
    private final zzgu zzqb;

    public zzhk(zzgu zzgu, zzgu zzgu2) {
        this.zzqa = zzgu;
        this.zzqb = zzgu2;
    }

    public final zzhk zza(zzit zzit, boolean z, boolean z2) {
        return new zzhk(new zzgu(zzit, z, z2), this.zzqb);
    }

    public final zzhk zzb(zzit zzit, boolean z, boolean z2) {
        return new zzhk(this.zzqa, new zzgu(zzit, z, z2));
    }

    public final zzgu zzer() {
        return this.zzqa;
    }

    public final zzja zzes() {
        if (this.zzqa.zzdo()) {
            return this.zzqa.zzd();
        }
        return null;
    }

    public final zzgu zzet() {
        return this.zzqb;
    }

    public final zzja zzeu() {
        if (this.zzqb.zzdo()) {
            return this.zzqb.zzd();
        }
        return null;
    }
}
