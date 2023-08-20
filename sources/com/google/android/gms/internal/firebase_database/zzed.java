package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzed {
    private final Map<zzhe, zzhi> zzko = new HashMap();
    private final zzfv zzkp;

    public zzed(zzfv zzfv) {
        this.zzkp = zzfv;
    }

    private final List<zzgx> zza(zzhi zzhi, zzfl zzfl, zzfg zzfg, zzja zzja) {
        zzhj zzb = zzhi.zzb(zzfl, zzfg, zzja);
        if (!zzhi.zzeo().zzek()) {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (zzgw next : zzb.zzpz) {
                zzgz zzdt = next.zzdt();
                if (zzdt == zzgz.CHILD_ADDED) {
                    hashSet2.add(next.zzds());
                } else if (zzdt == zzgz.CHILD_REMOVED) {
                    hashSet.add(next.zzds());
                }
            }
            if (!hashSet2.isEmpty() || !hashSet.isEmpty()) {
                this.zzkp.zza(zzhi.zzeo(), (Set<zzid>) hashSet2, (Set<zzid>) hashSet);
            }
        }
        return zzb.zzpy;
    }

    public final boolean isEmpty() {
        return this.zzko.isEmpty();
    }

    public final zzkn<List<zzhh>, List<zzgy>> zza(zzhh zzhh, zzce zzce, DatabaseError databaseError) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean zzci = zzci();
        if (zzhh.isDefault()) {
            Iterator<Map.Entry<zzhe, zzhi>> it = this.zzko.entrySet().iterator();
            while (it.hasNext()) {
                zzhi zzhi = (zzhi) it.next().getValue();
                arrayList2.addAll(zzhi.zza(zzce, databaseError));
                if (zzhi.isEmpty()) {
                    it.remove();
                    if (!zzhi.zzeo().zzek()) {
                        arrayList.add(zzhi.zzeo());
                    }
                }
            }
        } else {
            zzhi zzhi2 = this.zzko.get(zzhh.zzen());
            if (zzhi2 != null) {
                arrayList2.addAll(zzhi2.zza(zzce, databaseError));
                if (zzhi2.isEmpty()) {
                    this.zzko.remove(zzhh.zzen());
                    if (!zzhi2.zzeo().zzek()) {
                        arrayList.add(zzhi2.zzeo());
                    }
                }
            }
        }
        if (zzci && !zzci()) {
            arrayList.add(zzhh.zzal(zzhh.zzg()));
        }
        return new zzkn<>(arrayList, arrayList2);
    }

    public final List<zzgx> zza(zzce zzce, zzfg zzfg, zzgu zzgu) {
        boolean z;
        zzhh zzbe = zzce.zzbe();
        zzhi zzhi = this.zzko.get(zzbe.zzen());
        if (zzhi == null) {
            zzja zzc = zzfg.zzc(zzgu.zzdo() ? zzgu.zzd() : null);
            if (zzc != null) {
                z = true;
            } else {
                zzc = zzfg.zzd(zzgu.zzd());
                z = false;
            }
            zzhi zzhi2 = new zzhi(zzbe, new zzhk(new zzgu(zzit.zza(zzc, zzbe.zzeg()), z, false), zzgu));
            if (!zzbe.zzek()) {
                HashSet hashSet = new HashSet();
                for (zziz zzge : zzhi2.zzeq()) {
                    hashSet.add(zzge.zzge());
                }
                this.zzkp.zza(zzbe, (Set<zzid>) hashSet);
            }
            this.zzko.put(zzbe.zzen(), zzhi2);
            zzhi = zzhi2;
        }
        zzhi.zzb(zzce);
        return zzhi.zzk(zzce);
    }

    public final List<zzgx> zza(zzfl zzfl, zzfg zzfg, zzja zzja) {
        zzhe zzdc = zzfl.zzcy().zzdc();
        if (zzdc != null) {
            return zza(this.zzko.get(zzdc), zzfl, zzfg, zzja);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<zzhe, zzhi> value : this.zzko.entrySet()) {
            arrayList.addAll(zza((zzhi) value.getValue(), zzfl, zzfg, zzja));
        }
        return arrayList;
    }

    public final zzhi zzb(zzhh zzhh) {
        return zzhh.zzek() ? zzcj() : this.zzko.get(zzhh.zzen());
    }

    public final boolean zzc(zzhh zzhh) {
        return zzb(zzhh) != null;
    }

    public final List<zzhi> zzch() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<zzhe, zzhi> value : this.zzko.entrySet()) {
            zzhi zzhi = (zzhi) value.getValue();
            if (!zzhi.zzeo().zzek()) {
                arrayList.add(zzhi);
            }
        }
        return arrayList;
    }

    public final boolean zzci() {
        return zzcj() != null;
    }

    public final zzhi zzcj() {
        for (Map.Entry<zzhe, zzhi> value : this.zzko.entrySet()) {
            zzhi zzhi = (zzhi) value.getValue();
            if (zzhi.zzeo().zzek()) {
                return zzhi;
            }
        }
        return null;
    }

    public final zzja zzr(zzch zzch) {
        for (zzhi next : this.zzko.values()) {
            if (next.zzr(zzch) != null) {
                return next.zzr(zzch);
            }
        }
        return null;
    }
}
