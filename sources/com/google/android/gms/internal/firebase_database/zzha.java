package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzha {
    private final zzhh zzpd;
    /* access modifiers changed from: private */
    public final zzis zzpe;

    public zzha(zzhh zzhh) {
        this.zzpd = zzhh;
        this.zzpe = zzhh.zzeg();
    }

    private final void zza(List<zzgx> list, zzgz zzgz, List<zzgw> list2, List<zzce> list3, zzit zzit) {
        ArrayList arrayList = new ArrayList();
        for (zzgw next : list2) {
            if (next.zzdt().equals(zzgz)) {
                arrayList.add(next);
            }
        }
        Collections.sort(arrayList, new zzhb(this));
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            zzgw zzgw = (zzgw) arrayList2.get(i);
            for (zzce next2 : list3) {
                if (next2.zza(zzgz)) {
                    list.add(next2.zza((zzgw.zzdt().equals(zzgz.VALUE) || zzgw.zzdt().equals(zzgz.CHILD_REMOVED)) ? zzgw : zzgw.zzg(zzit.zza(zzgw.zzds(), zzgw.zzdq().zzd(), this.zzpe)), this.zzpd));
                }
            }
            i = i2;
        }
    }

    public final List<zzgx> zza(List<zzgw> list, zzit zzit, List<zzce> list2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (zzgw next : list) {
            if (next.zzdt().equals(zzgz.CHILD_CHANGED)) {
                if (this.zzpe.compare(new zziz(zzid.zzfc(), next.zzdv().zzd()), new zziz(zzid.zzfc(), next.zzdq().zzd())) != 0) {
                    arrayList2.add(zzgw.zzc(next.zzds(), next.zzdq()));
                }
            }
        }
        zza(arrayList, zzgz.CHILD_REMOVED, list, list2, zzit);
        zza(arrayList, zzgz.CHILD_ADDED, list, list2, zzit);
        zza(arrayList, zzgz.CHILD_MOVED, arrayList2, list2, zzit);
        zza(arrayList, zzgz.CHILD_CHANGED, list, list2, zzit);
        zza(arrayList, zzgz.VALUE, list, list2, zzit);
        return arrayList;
    }
}
