package com.google.android.gms.internal.firebase_database;

public final class zzgu {
    private final zzit zzom;
    private final boolean zzon;
    private final boolean zzoo;

    public zzgu(zzit zzit, boolean z, boolean z2) {
        this.zzom = zzit;
        this.zzon = z;
        this.zzoo = z2;
    }

    public final boolean zzak(zzch zzch) {
        return zzch.isEmpty() ? this.zzon && !this.zzoo : zzf(zzch.zzbw());
    }

    public final zzja zzd() {
        return this.zzom.zzd();
    }

    public final boolean zzdo() {
        return this.zzon;
    }

    public final boolean zzdp() {
        return this.zzoo;
    }

    public final zzit zzdq() {
        return this.zzom;
    }

    public final boolean zzf(zzid zzid) {
        return (this.zzon && !this.zzoo) || this.zzom.zzd().zzk(zzid);
    }
}
