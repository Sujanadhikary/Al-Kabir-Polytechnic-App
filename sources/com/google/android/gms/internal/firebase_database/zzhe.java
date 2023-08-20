package com.google.android.gms.internal.firebase_database;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class zzhe {
    public static final zzhe zzpi = new zzhe();
    private zzis zzpe = zzjf.zzgf();
    private Integer zzpj;
    private int zzpk;
    private zzja zzpl = null;
    private zzid zzpm = null;
    private zzja zzpn = null;
    private zzid zzpo = null;
    private String zzpp = null;

    private static zzja zze(zzja zzja) {
        if ((zzja instanceof zzji) || (zzja instanceof zzic) || (zzja instanceof zziq) || (zzja instanceof zzir)) {
            return zzja;
        }
        if (zzja instanceof zziy) {
            return new zziq(Double.valueOf(((Long) zzja.getValue()).doubleValue()), zzir.zzfv());
        }
        String valueOf = String.valueOf(zzja.getValue());
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Unexpected value passed to normalizeValue: ").append(valueOf).toString());
    }

    private final zzhe zzeh() {
        zzhe zzhe = new zzhe();
        zzhe.zzpj = this.zzpj;
        zzhe.zzpl = this.zzpl;
        zzhe.zzpm = this.zzpm;
        zzhe.zzpn = this.zzpn;
        zzhe.zzpo = this.zzpo;
        zzhe.zzpk = this.zzpk;
        zzhe.zzpe = this.zzpe;
        return zzhe;
    }

    public static zzhe zzh(Map<String, Object> map) {
        zzis zzje;
        zzhe zzhe = new zzhe();
        zzhe.zzpj = (Integer) map.get("l");
        if (map.containsKey("sp")) {
            zzhe.zzpl = zze(zzjd.zza(map.get("sp"), zzir.zzfv()));
            String str = (String) map.get("sn");
            if (str != null) {
                zzhe.zzpm = zzid.zzt(str);
            }
        }
        if (map.containsKey("ep")) {
            zzhe.zzpn = zze(zzjd.zza(map.get("ep"), zzir.zzfv()));
            String str2 = (String) map.get("en");
            if (str2 != null) {
                zzhe.zzpo = zzid.zzt(str2);
            }
        }
        String str3 = (String) map.get("vf");
        if (str3 != null) {
            zzhe.zzpk = str3.equals("l") ? zzhg.zzpr : zzhg.zzps;
        }
        String str4 = (String) map.get("i");
        if (str4 != null) {
            if (str4.equals(".value")) {
                zzje = zzjk.zzgg();
            } else if (str4.equals(".key")) {
                zzje = zziu.zzgb();
            } else if (str4.equals(".priority")) {
                throw new IllegalStateException("queryDefinition shouldn't ever be .priority since it's the default");
            } else {
                zzje = new zzje(new zzch(str4));
            }
            zzhe.zzpe = zzje;
        }
        return zzhe;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhe zzhe = (zzhe) obj;
        if (this.zzpj == null ? zzhe.zzpj != null : !this.zzpj.equals(zzhe.zzpj)) {
            return false;
        }
        if (this.zzpe == null ? zzhe.zzpe != null : !this.zzpe.equals(zzhe.zzpe)) {
            return false;
        }
        if (this.zzpo == null ? zzhe.zzpo != null : !this.zzpo.equals(zzhe.zzpo)) {
            return false;
        }
        if (this.zzpn == null ? zzhe.zzpn != null : !this.zzpn.equals(zzhe.zzpn)) {
            return false;
        }
        if (this.zzpm == null ? zzhe.zzpm != null : !this.zzpm.equals(zzhe.zzpm)) {
            return false;
        }
        if (this.zzpl == null ? zzhe.zzpl != null : !this.zzpl.equals(zzhe.zzpl)) {
            return false;
        }
        return zzei() == zzhe.zzei();
    }

    public final int getLimit() {
        if (zzee()) {
            return this.zzpj.intValue();
        }
        throw new IllegalArgumentException("Cannot get limit if limit has not been set");
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzpo != null ? this.zzpo.hashCode() : 0) + (((this.zzpn != null ? this.zzpn.hashCode() : 0) + (((this.zzpm != null ? this.zzpm.hashCode() : 0) + (((this.zzpl != null ? this.zzpl.hashCode() : 0) + (((zzei() ? 1231 : 1237) + ((this.zzpj != null ? this.zzpj.intValue() : 0) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (this.zzpe != null) {
            i = this.zzpe.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isDefault() {
        return zzek() && this.zzpe.equals(zzjf.zzgf());
    }

    public final String toString() {
        return zzej().toString();
    }

    public final zzhe zza(zzis zzis) {
        zzhe zzeh = zzeh();
        zzeh.zzpe = zzis;
        return zzeh;
    }

    public final zzhe zza(zzja zzja, zzid zzid) {
        zzkq.zzf(!(zzja instanceof zziy));
        zzhe zzeh = zzeh();
        zzeh.zzpl = zzja;
        zzeh.zzpm = zzid;
        return zzeh;
    }

    public final zzhe zzb(zzja zzja, zzid zzid) {
        zzkq.zzf(!(zzja instanceof zziy));
        zzhe zzeh = zzeh();
        zzeh.zzpn = zzja;
        zzeh.zzpo = zzid;
        return zzeh;
    }

    public final zzhe zzc(int i) {
        zzhe zzeh = zzeh();
        zzeh.zzpj = Integer.valueOf(i);
        zzeh.zzpk = zzhg.zzpr;
        return zzeh;
    }

    public final zzhe zzd(int i) {
        zzhe zzeh = zzeh();
        zzeh.zzpj = Integer.valueOf(i);
        zzeh.zzpk = zzhg.zzps;
        return zzeh;
    }

    public final boolean zzdy() {
        return this.zzpl != null;
    }

    public final zzja zzdz() {
        if (zzdy()) {
            return this.zzpl;
        }
        throw new IllegalArgumentException("Cannot get index start value if start has not been set");
    }

    public final zzid zzea() {
        if (zzdy()) {
            return this.zzpm != null ? this.zzpm : zzid.zzfc();
        }
        throw new IllegalArgumentException("Cannot get index start name if start has not been set");
    }

    public final boolean zzeb() {
        return this.zzpn != null;
    }

    public final zzja zzec() {
        if (zzeb()) {
            return this.zzpn;
        }
        throw new IllegalArgumentException("Cannot get index end value if start has not been set");
    }

    public final zzid zzed() {
        if (zzeb()) {
            return this.zzpo != null ? this.zzpo : zzid.zzfd();
        }
        throw new IllegalArgumentException("Cannot get index end name if start has not been set");
    }

    public final boolean zzee() {
        return this.zzpj != null;
    }

    public final boolean zzef() {
        return zzee() && this.zzpk != 0;
    }

    public final zzis zzeg() {
        return this.zzpe;
    }

    public final boolean zzei() {
        return this.zzpk != 0 ? this.zzpk == zzhg.zzpr : zzdy();
    }

    public final Map<String, Object> zzej() {
        HashMap hashMap = new HashMap();
        if (zzdy()) {
            hashMap.put("sp", this.zzpl.getValue());
            if (this.zzpm != null) {
                hashMap.put("sn", this.zzpm.zzfg());
            }
        }
        if (zzeb()) {
            hashMap.put("ep", this.zzpn.getValue());
            if (this.zzpo != null) {
                hashMap.put("en", this.zzpo.zzfg());
            }
        }
        if (this.zzpj != null) {
            hashMap.put("l", this.zzpj);
            int i = this.zzpk;
            if (i == 0) {
                i = zzdy() ? zzhg.zzpr : zzhg.zzps;
            }
            switch (zzhf.zzpq[i - 1]) {
                case 1:
                    hashMap.put("vf", "l");
                    break;
                case 2:
                    hashMap.put("vf", "r");
                    break;
            }
        }
        if (!this.zzpe.equals(zzjf.zzgf())) {
            hashMap.put("i", this.zzpe.zzfx());
        }
        return hashMap;
    }

    public final boolean zzek() {
        return !zzdy() && !zzeb() && !zzee();
    }

    public final String zzel() {
        if (this.zzpp == null) {
            try {
                this.zzpp = zzke.zze(zzej());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return this.zzpp;
    }

    public final zzht zzem() {
        return zzek() ? new zzhr(this.zzpe) : zzee() ? new zzhs(this) : new zzhv(this);
    }
}
