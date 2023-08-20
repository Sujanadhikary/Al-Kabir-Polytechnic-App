package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class zzeh implements Callable<List<? extends zzgy>> {
    private final /* synthetic */ zzee zzlb;
    private final /* synthetic */ zzce zzle;

    zzeh(zzee zzee, zzce zzce) {
        this.zzlb = zzee;
        this.zzle = zzce;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzja zzja;
        boolean z;
        zzed zzed;
        zzgu zzgu;
        zzja zzr;
        boolean z2;
        zzja zzja2;
        zzhh zzbe = this.zzle.zzbe();
        zzch zzg = zzbe.zzg();
        zzja zzja3 = null;
        zzch zzch = zzg;
        zzgj zzd = this.zzlb.zzkq;
        boolean z3 = false;
        while (!zzd.isEmpty()) {
            zzed zzed2 = (zzed) zzd.getValue();
            if (zzed2 != null) {
                if (zzja3 == null) {
                    zzja3 = zzed2.zzr(zzch);
                }
                z2 = z3 || zzed2.zzci();
                zzja2 = zzja3;
            } else {
                z2 = z3;
                zzja2 = zzja3;
            }
            zzd = zzd.zze(zzch.isEmpty() ? zzid.zzt("") : zzch.zzbw());
            zzch = zzch.zzbx();
            zzja3 = zzja2;
            z3 = z2;
        }
        zzed zzed3 = (zzed) this.zzlb.zzkq.zzai(zzg);
        if (zzed3 == null) {
            zzed zzed4 = new zzed(this.zzlb.zzkp);
            zzgj unused = this.zzlb.zzkq = this.zzlb.zzkq.zzb(zzg, zzed4);
            zzed zzed5 = zzed4;
            zzja = zzja3;
            z = z3;
            zzed = zzed5;
        } else {
            boolean z4 = z3 || zzed3.zzci();
            if (zzja3 == null) {
                zzja3 = zzed3.zzr(zzch.zzbt());
            }
            zzed zzed6 = zzed3;
            zzja = zzja3;
            z = z4;
            zzed = zzed6;
        }
        this.zzlb.zzkp.zzg(zzbe);
        if (zzja != null) {
            zzgu = new zzgu(zzit.zza(zzja, zzbe.zzeg()), true, false);
        } else {
            zzgu zzf = this.zzlb.zzkp.zzf(zzbe);
            if (zzf.zzdo()) {
                zzgu = zzf;
            } else {
                zzja zzfv = zzir.zzfv();
                Iterator it = this.zzlb.zzkq.zzag(zzg).zzdm().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    zzed zzed7 = (zzed) ((zzgj) entry.getValue()).getValue();
                    zzfv = (zzed7 == null || (zzr = zzed7.zzr(zzch.zzbt())) == null) ? zzfv : zzfv.zze((zzid) entry.getKey(), zzr);
                }
                for (zziz zziz : zzf.zzd()) {
                    if (!zzfv.zzk(zziz.zzge())) {
                        zzfv = zzfv.zze(zziz.zzge(), zziz.zzd());
                    }
                }
                zzgu = new zzgu(zzit.zza(zzfv, zzbe.zzeg()), false, false);
            }
        }
        boolean zzc = zzed.zzc(zzbe);
        if (!zzc && !zzbe.zzek()) {
            zzex zzf2 = this.zzlb.zzcl();
            this.zzlb.zzkt.put(zzbe, zzf2);
            this.zzlb.zzks.put(zzf2, zzbe);
        }
        List<zzgx> zza = zzed.zza(this.zzle, this.zzlb.zzkr.zzt(zzg), zzgu);
        if (!zzc && !z) {
            this.zzlb.zza(zzbe, zzed.zzb(zzbe));
        }
        return zza;
    }
}
