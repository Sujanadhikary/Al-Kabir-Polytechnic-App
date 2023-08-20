package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

final class zzei implements Callable<List<zzgy>> {
    private final /* synthetic */ zzhh zziz;
    private final /* synthetic */ zzee zzlb;
    private final /* synthetic */ zzce zzle;
    private final /* synthetic */ DatabaseError zzlf;

    zzei(zzee zzee, zzhh zzhh, zzce zzce, DatabaseError databaseError) {
        this.zzlb = zzee;
        this.zziz = zzhh;
        this.zzle = zzce;
        this.zzlf = databaseError;
    }

    public final /* synthetic */ Object call() throws Exception {
        boolean z;
        zzch zzg = this.zziz.zzg();
        zzed zzed = (zzed) this.zzlb.zzkq.zzai(zzg);
        Object arrayList = new ArrayList();
        if (zzed != null && (this.zziz.isDefault() || zzed.zzc(this.zziz))) {
            zzkn<List<zzhh>, List<zzgy>> zza = zzed.zza(this.zziz, this.zzle, this.zzlf);
            if (zzed.isEmpty()) {
                zzgj unused = this.zzlb.zzkq = this.zzlb.zzkq.zzah(zzg);
            }
            List<zzhh> first = zza.getFirst();
            arrayList = zza.zzgv();
            boolean z2 = false;
            for (zzhh zzhh : first) {
                this.zzlb.zzkp.zzh(this.zziz);
                z2 = z2 || zzhh.zzek();
            }
            zzgj zzd = this.zzlb.zzkq;
            boolean z3 = zzd.getValue() != null && ((zzed) zzd.getValue()).zzci();
            Iterator<zzid> it = zzg.iterator();
            zzgj zzgj = zzd;
            while (true) {
                z = z3;
                if (!it.hasNext()) {
                    break;
                }
                zzgj = zzgj.zze(it.next());
                z3 = z || (zzgj.getValue() != null && ((zzed) zzgj.getValue()).zzci());
                if (z3 || zzgj.isEmpty()) {
                    z = z3;
                }
            }
            z = z3;
            if (z2 && !z) {
                zzgj zzag = this.zzlb.zzkq.zzag(zzg);
                if (!zzag.isEmpty()) {
                    for (zzhi zzhi : this.zzlb.zza((zzgj<zzed>) zzag)) {
                        zzev zzev = new zzev(this.zzlb, zzhi);
                        this.zzlb.zzkv.zza(zzee.zzd(zzhi.zzeo()), zzev.zzlp, zzev, zzev);
                    }
                }
            }
            if (!z && !first.isEmpty() && this.zzlf == null) {
                if (z2) {
                    this.zzlb.zzkv.zza(zzee.zzd(this.zziz), (zzex) null);
                } else {
                    for (zzhh zzhh2 : first) {
                        this.zzlb.zzkv.zza(zzee.zzd(zzhh2), this.zzlb.zze(zzhh2));
                    }
                }
            }
            this.zzlb.zzd(first);
        }
        return arrayList;
    }
}
