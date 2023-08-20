package com.google.android.gms.internal.firebase_database;

final class zzhp implements zzhu {
    private final zzhk zzpv;
    private final zzfg zzqf;
    private final zzja zzqg;

    public zzhp(zzfg zzfg, zzhk zzhk, zzja zzja) {
        this.zzqf = zzfg;
        this.zzpv = zzhk;
        this.zzqg = zzja;
    }

    public final zziz zza(zzis zzis, zziz zziz, boolean z) {
        return this.zzqf.zza(this.zzqg != null ? this.zzqg : this.zzpv.zzeu(), zziz, z, zzis);
    }

    public final zzja zzh(zzid zzid) {
        zzgu zzer = this.zzpv.zzer();
        if (zzer.zzf(zzid)) {
            return zzer.zzd().zzm(zzid);
        }
        return this.zzqf.zza(zzid, this.zzqg != null ? new zzgu(zzit.zza(this.zzqg, zziu.zzgb()), true, false) : this.zzpv.zzet());
    }
}
