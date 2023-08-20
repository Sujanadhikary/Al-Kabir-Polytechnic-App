package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;

public final class zzhs implements zzht {
    private final int limit;
    private final zzis zzpe;
    private final zzhv zzqi;
    private final boolean zzqj;

    public zzhs(zzhe zzhe) {
        this.zzqi = new zzhv(zzhe);
        this.zzpe = zzhe.zzeg();
        this.limit = zzhe.getLimit();
        this.zzqj = !zzhe.zzei();
    }

    public final zzit zza(zzit zzit, zzid zzid, zzja zzja, zzch zzch, zzhu zzhu, zzhq zzhq) {
        zzja zzfv = !this.zzqi.zza(new zziz(zzid, zzja)) ? zzir.zzfv() : zzja;
        if (zzit.zzd().zzm(zzid).equals(zzfv)) {
            return zzit;
        }
        if (zzit.zzd().getChildCount() < this.limit) {
            return this.zzqi.zzew().zza(zzit, zzid, zzfv, zzch, zzhu, zzhq);
        }
        zziz zziz = new zziz(zzid, zzfv);
        zziz zzfz = this.zzqj ? zzit.zzfz() : zzit.zzga();
        boolean zza = this.zzqi.zza(zziz);
        if (zzit.zzd().zzk(zzid)) {
            zzja zzm = zzit.zzd().zzm(zzid);
            zziz zza2 = zzhu.zza(this.zzpe, zzfz, this.zzqj);
            while (zza2 != null && (zza2.zzge().equals(zzid) || zzit.zzd().zzk(zza2.zzge()))) {
                zza2 = zzhu.zza(this.zzpe, zza2, this.zzqj);
            }
            if (zza && !zzfv.isEmpty() && (zza2 == null ? 1 : this.zzpe.zza(zza2, zziz, this.zzqj)) >= 0) {
                if (zzhq != null) {
                    zzhq.zza(zzgw.zza(zzid, zzfv, zzm));
                }
                return zzit.zzg(zzid, zzfv);
            }
            if (zzhq != null) {
                zzhq.zza(zzgw.zzd(zzid, zzm));
            }
            zzit zzg = zzit.zzg(zzid, zzir.zzfv());
            if (!(zza2 != null && this.zzqi.zza(zza2))) {
                return zzg;
            }
            if (zzhq != null) {
                zzhq.zza(zzgw.zzc(zza2.zzge(), zza2.zzd()));
            }
            return zzg.zzg(zza2.zzge(), zza2.zzd());
        } else if (zzfv.isEmpty() || !zza || this.zzpe.zza(zzfz, zziz, this.zzqj) < 0) {
            return zzit;
        } else {
            if (zzhq != null) {
                zzhq.zza(zzgw.zzd(zzfz.zzge(), zzfz.zzd()));
                zzhq.zza(zzgw.zzc(zzid, zzfv));
            }
            return zzit.zzg(zzid, zzfv).zzg(zzfz.zzge(), zzir.zzfv());
        }
    }

    public final zzit zza(zzit zzit, zzit zzit2, zzhq zzhq) {
        zzit zzit3;
        zziz zzez;
        zziz zziz;
        int i;
        Iterator<zziz> it;
        if (zzit2.zzd().zzfk() || zzit2.zzd().isEmpty()) {
            zzit3 = zzit.zza(zzir.zzfv(), this.zzpe);
        } else {
            zzit zzk = zzit2.zzk(zzir.zzfv());
            if (this.zzqj) {
                Iterator<zziz> reverseIterator = zzit2.reverseIterator();
                zziz = this.zzqi.zzez();
                zzez = this.zzqi.zzey();
                it = reverseIterator;
                i = -1;
            } else {
                Iterator<zziz> it2 = zzit2.iterator();
                zziz zzey = this.zzqi.zzey();
                zzez = this.zzqi.zzez();
                zziz = zzey;
                i = 1;
                it = it2;
            }
            int i2 = 0;
            zzit3 = zzk;
            boolean z = false;
            while (it.hasNext()) {
                zziz next = it.next();
                if (!z && this.zzpe.compare(zziz, next) * i <= 0) {
                    z = true;
                }
                if (z && i2 < this.limit && this.zzpe.compare(next, zzez) * i <= 0) {
                    i2++;
                } else {
                    zzit3 = zzit3.zzg(next.zzge(), zzir.zzfv());
                }
            }
        }
        return this.zzqi.zzew().zza(zzit, zzit3, zzhq);
    }

    public final zzit zza(zzit zzit, zzja zzja) {
        return zzit;
    }

    public final zzis zzeg() {
        return this.zzpe;
    }

    public final zzht zzew() {
        return this.zzqi.zzew();
    }

    public final boolean zzex() {
        return true;
    }
}
