package com.google.android.gms.internal.firebase_database;

public final class zzhr implements zzht {
    private final zzis zzpe;

    public zzhr(zzis zzis) {
        this.zzpe = zzis;
    }

    public final zzit zza(zzit zzit, zzid zzid, zzja zzja, zzch zzch, zzhu zzhu, zzhq zzhq) {
        zzja zzd = zzit.zzd();
        zzja zzm = zzd.zzm(zzid);
        if (zzm.zzam(zzch).equals(zzja.zzam(zzch)) && zzm.isEmpty() == zzja.isEmpty()) {
            return zzit;
        }
        if (zzhq != null) {
            if (zzja.isEmpty()) {
                if (zzd.zzk(zzid)) {
                    zzhq.zza(zzgw.zzd(zzid, zzm));
                }
            } else if (zzm.isEmpty()) {
                zzhq.zza(zzgw.zzc(zzid, zzja));
            } else {
                zzhq.zza(zzgw.zza(zzid, zzja, zzm));
            }
        }
        return (!zzd.zzfk() || !zzja.isEmpty()) ? zzit.zzg(zzid, zzja) : zzit;
    }

    public final zzit zza(zzit zzit, zzit zzit2, zzhq zzhq) {
        if (zzhq != null) {
            for (zziz zziz : zzit.zzd()) {
                if (!zzit2.zzd().zzk(zziz.zzge())) {
                    zzhq.zza(zzgw.zzd(zziz.zzge(), zziz.zzd()));
                }
            }
            if (!zzit2.zzd().zzfk()) {
                for (zziz zziz2 : zzit2.zzd()) {
                    if (zzit.zzd().zzk(zziz2.zzge())) {
                        zzja zzm = zzit.zzd().zzm(zziz2.zzge());
                        if (!zzm.equals(zziz2.zzd())) {
                            zzhq.zza(zzgw.zza(zziz2.zzge(), zziz2.zzd(), zzm));
                        }
                    } else {
                        zzhq.zza(zzgw.zzc(zziz2.zzge(), zziz2.zzd()));
                    }
                }
            }
        }
        return zzit2;
    }

    public final zzit zza(zzit zzit, zzja zzja) {
        return zzit.zzd().isEmpty() ? zzit : zzit.zzk(zzja);
    }

    public final zzis zzeg() {
        return this.zzpe;
    }

    public final zzht zzew() {
        return this;
    }

    public final boolean zzex() {
        return false;
    }
}
