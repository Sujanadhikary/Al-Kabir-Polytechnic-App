package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class zzjh {
    private final zzch zzsp;
    private final zzch zzsq;
    private final zzja zzsr;

    public zzjh(zzba zzba) {
        zzch zzch = null;
        List<String> zzap = zzba.zzap();
        this.zzsp = zzap != null ? new zzch(zzap) : null;
        List<String> zzaq = zzba.zzaq();
        this.zzsq = zzaq != null ? new zzch(zzaq) : zzch;
        this.zzsr = zzjd.zza(zzba.zzar(), zzir.zzfv());
    }

    private final zzja zzb(zzch zzch, zzja zzja, zzja zzja2) {
        boolean z = true;
        int i = 0;
        int zzj = this.zzsp == null ? 1 : zzch.compareTo(this.zzsp);
        int zzj2 = this.zzsq == null ? -1 : zzch.compareTo(this.zzsq);
        boolean z2 = this.zzsp != null && zzch.zzi(this.zzsp);
        if (this.zzsq == null || !zzch.zzi(this.zzsq)) {
            z = false;
        }
        if (zzj > 0 && zzj2 < 0 && !z) {
            return zzja2;
        }
        if (zzj > 0 && z && zzja2.zzfk()) {
            return zzja2;
        }
        if (zzj > 0 && zzj2 == 0) {
            return zzja.zzfk() ? zzir.zzfv() : zzja;
        }
        if (!z2 && !z) {
            return zzja;
        }
        HashSet hashSet = new HashSet();
        Iterator it = zzja.iterator();
        while (it.hasNext()) {
            hashSet.add(((zziz) it.next()).zzge());
        }
        Iterator it2 = zzja2.iterator();
        while (it2.hasNext()) {
            hashSet.add(((zziz) it2.next()).zzge());
        }
        ArrayList arrayList = new ArrayList(hashSet.size() + 1);
        arrayList.addAll(hashSet);
        if (!zzja2.zzfl().isEmpty() || !zzja.zzfl().isEmpty()) {
            arrayList.add(zzid.zzfe());
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        zzja zzja3 = zzja;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zzid zzid = (zzid) obj;
            zzja zzm = zzja.zzm(zzid);
            zzja zzb = zzb(zzch.zza(zzid), zzja.zzm(zzid), zzja2.zzm(zzid));
            zzja3 = zzb != zzm ? zzja3.zze(zzid, zzb) : zzja3;
        }
        return zzja3;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzsp);
        String valueOf2 = String.valueOf(this.zzsq);
        String valueOf3 = String.valueOf(this.zzsr);
        return new StringBuilder(String.valueOf(valueOf).length() + 55 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("RangeMerge{optExclusiveStart=").append(valueOf).append(", optInclusiveEnd=").append(valueOf2).append(", snap=").append(valueOf3).append('}').toString();
    }

    public final zzja zzm(zzja zzja) {
        return zzb(zzch.zzbt(), zzja, this.zzsr);
    }
}
