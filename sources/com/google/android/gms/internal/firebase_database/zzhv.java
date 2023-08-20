package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;

public final class zzhv implements zzht {
    private final zzis zzpe;
    private final zzhr zzqk;
    private final zziz zzql;
    private final zziz zzqm;

    public zzhv(zzhe zzhe) {
        zziz zzgc;
        zziz zzfw;
        this.zzqk = new zzhr(zzhe.zzeg());
        this.zzpe = zzhe.zzeg();
        if (zzhe.zzdy()) {
            zzgc = zzhe.zzeg().zzf(zzhe.zzea(), zzhe.zzdz());
        } else {
            zzhe.zzeg();
            zzgc = zziz.zzgc();
        }
        this.zzql = zzgc;
        if (zzhe.zzeb()) {
            zzfw = zzhe.zzeg().zzf(zzhe.zzed(), zzhe.zzec());
        } else {
            zzfw = zzhe.zzeg().zzfw();
        }
        this.zzqm = zzfw;
    }

    public final zzit zza(zzit zzit, zzid zzid, zzja zzja, zzch zzch, zzhu zzhu, zzhq zzhq) {
        return this.zzqk.zza(zzit, zzid, !zza(new zziz(zzid, zzja)) ? zzir.zzfv() : zzja, zzch, zzhu, zzhq);
    }

    public final zzit zza(zzit zzit, zzit zzit2, zzhq zzhq) {
        zzit zzit3;
        if (!zzit2.zzd().zzfk()) {
            zzit zzk = zzit2.zzk(zzir.zzfv());
            Iterator<zziz> it = zzit2.iterator();
            while (true) {
                zzit3 = zzk;
                if (!it.hasNext()) {
                    break;
                }
                zziz next = it.next();
                zzk = !zza(next) ? zzit3.zzg(next.zzge(), zzir.zzfv()) : zzit3;
            }
        } else {
            zzit3 = zzit.zza(zzir.zzfv(), this.zzpe);
        }
        return this.zzqk.zza(zzit, zzit3, zzhq);
    }

    public final zzit zza(zzit zzit, zzja zzja) {
        return zzit;
    }

    public final boolean zza(zziz zziz) {
        return this.zzpe.compare(this.zzql, zziz) <= 0 && this.zzpe.compare(zziz, this.zzqm) <= 0;
    }

    public final zzis zzeg() {
        return this.zzpe;
    }

    public final zzht zzew() {
        return this.zzqk;
    }

    public final boolean zzex() {
        return true;
    }

    public final zziz zzey() {
        return this.zzql;
    }

    public final zziz zzez() {
        return this.zzqm;
    }
}
