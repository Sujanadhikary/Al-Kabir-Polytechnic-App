package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzbv implements Iterable<Map.Entry<zzch, zzja>> {
    private static final zzbv zzgw = new zzbv(new zzgj(null));
    private final zzgj<zzja> zzgx;

    private zzbv(zzgj<zzja> zzgj) {
        this.zzgx = zzgj;
    }

    private final zzja zza(zzch zzch, zzgj<zzja> zzgj, zzja zzja) {
        if (zzgj.getValue() != null) {
            return zzja.zzl(zzch, zzgj.getValue());
        }
        Iterator<Map.Entry<zzid, zzgj<zzja>>> it = zzgj.zzdm().iterator();
        zzja zzja2 = null;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzgj zzgj2 = (zzgj) next.getValue();
            zzid zzid = (zzid) next.getKey();
            if (zzid.zzfh()) {
                zzja2 = (zzja) zzgj2.getValue();
            } else {
                zzja = zza(zzch.zza(zzid), zzgj2, zzja);
            }
        }
        return (zzja.zzam(zzch).isEmpty() || zzja2 == null) ? zzja : zzja.zzl(zzch.zza(zzid.zzfe()), zzja2);
    }

    public static zzbv zzbf() {
        return zzgw;
    }

    public static zzbv zzf(Map<String, Object> map) {
        zzgj zzdl = zzgj.zzdl();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (true) {
            zzgj zzgj = zzdl;
            if (!it.hasNext()) {
                return new zzbv(zzgj);
            }
            Map.Entry next = it.next();
            zzdl = zzgj.zza(new zzch((String) next.getKey()), new zzgj(zzjd.zza(next.getValue(), zzir.zzfv())));
        }
    }

    public static zzbv zzg(Map<zzch, zzja> map) {
        zzgj zzdl = zzgj.zzdl();
        Iterator<Map.Entry<zzch, zzja>> it = map.entrySet().iterator();
        while (true) {
            zzgj zzgj = zzdl;
            if (!it.hasNext()) {
                return new zzbv(zzgj);
            }
            Map.Entry next = it.next();
            zzdl = zzgj.zza((zzch) next.getKey(), new zzgj((zzja) next.getValue()));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return ((zzbv) obj).zzd(true).equals(zzd(true));
    }

    public final int hashCode() {
        return zzd(true).hashCode();
    }

    public final boolean isEmpty() {
        return this.zzgx.isEmpty();
    }

    public final Iterator<Map.Entry<zzch, zzja>> iterator() {
        return this.zzgx.iterator();
    }

    public final String toString() {
        String obj = zzd(true).toString();
        return new StringBuilder(String.valueOf(obj).length() + 15).append("CompoundWrite{").append(obj).append("}").toString();
    }

    public final zzbv zza(zzid zzid, zzja zzja) {
        return zze(new zzch(zzid), zzja);
    }

    public final zzbv zzb(zzch zzch, zzbv zzbv) {
        return (zzbv) zzbv.zzgx.zzb(this, new zzbw(this, zzch));
    }

    public final zzja zzb(zzja zzja) {
        return zza(zzch.zzbt(), this.zzgx, zzja);
    }

    public final zzja zzbg() {
        return this.zzgx.getValue();
    }

    public final List<zziz> zzbh() {
        ArrayList arrayList = new ArrayList();
        if (this.zzgx.getValue() != null) {
            for (zziz zziz : this.zzgx.getValue()) {
                arrayList.add(new zziz(zziz.zzge(), zziz.zzd()));
            }
        } else {
            Iterator<Map.Entry<zzid, zzgj<zzja>>> it = this.zzgx.zzdm().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                zzgj zzgj = (zzgj) next.getValue();
                if (zzgj.getValue() != null) {
                    arrayList.add(new zziz((zzid) next.getKey(), (zzja) zzgj.getValue()));
                }
            }
        }
        return arrayList;
    }

    public final Map<zzid, zzbv> zzbi() {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<zzid, zzgj<zzja>>> it = this.zzgx.zzdm().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            hashMap.put((zzid) next.getKey(), new zzbv((zzgj) next.getValue()));
        }
        return hashMap;
    }

    public final zzbv zzd(zzch zzch) {
        return zzch.isEmpty() ? zzgw : new zzbv(this.zzgx.zza(zzch, zzgj.zzdl()));
    }

    public final Map<String, Object> zzd(boolean z) {
        HashMap hashMap = new HashMap();
        this.zzgx.zza(new zzbx(this, hashMap, true));
        return hashMap;
    }

    public final zzbv zze(zzch zzch, zzja zzja) {
        if (zzch.isEmpty()) {
            return new zzbv(new zzgj(zzja));
        }
        zzch zzae = this.zzgx.zzae(zzch);
        if (zzae != null) {
            zzch zza = zzch.zza(zzae, zzch);
            zzja zzai = this.zzgx.zzai(zzae);
            zzid zzbz = zza.zzbz();
            if (zzbz != null && zzbz.zzfh() && zzai.zzam(zza.zzby()).isEmpty()) {
                return this;
            }
            return new zzbv(this.zzgx.zzb(zzae, zzai.zzl(zza, zzja)));
        }
        return new zzbv(this.zzgx.zza(zzch, new zzgj(zzja)));
    }

    public final boolean zze(zzch zzch) {
        return zzf(zzch) != null;
    }

    public final zzja zzf(zzch zzch) {
        zzch zzae = this.zzgx.zzae(zzch);
        if (zzae != null) {
            return this.zzgx.zzai(zzae).zzam(zzch.zza(zzae, zzch));
        }
        return null;
    }

    public final zzbv zzg(zzch zzch) {
        if (zzch.isEmpty()) {
            return this;
        }
        zzja zzf = zzf(zzch);
        return zzf != null ? new zzbv(new zzgj(zzf)) : new zzbv(this.zzgx.zzag(zzch));
    }
}
