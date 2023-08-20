package com.google.android.gms.internal.firebase_database;

import java.util.Map;

public final class zzgp<T> {
    private zzid zzoh;
    private zzgp<T> zzoi;
    private zzgt<T> zzoj;

    public zzgp() {
        this((zzid) null, (zzgp) null, new zzgt());
    }

    private zzgp(zzid zzid, zzgp<T> zzgp, zzgt<T> zzgt) {
        this.zzoh = zzid;
        this.zzoi = zzgp;
        this.zzoj = zzgt;
    }

    private final void zzdn() {
        zzgp<T> zzgp;
        while (true) {
            zzgp<T> zzgp2 = zzgp;
            if (zzgp2.zzoi != null) {
                zzgp = zzgp2.zzoi;
                zzid zzid = zzgp2.zzoh;
                boolean z = zzgp2.zzoj.value == null && zzgp2.zzoj.zzkk.isEmpty();
                boolean containsKey = zzgp.zzoj.zzkk.containsKey(zzid);
                if (z && containsKey) {
                    zzgp.zzoj.zzkk.remove(zzid);
                } else if (!z && !containsKey) {
                    zzgp.zzoj.zzkk.put(zzid, zzgp2.zzoj);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final T getValue() {
        return this.zzoj.value;
    }

    public final boolean hasChildren() {
        return !this.zzoj.zzkk.isEmpty();
    }

    public final void setValue(T t) {
        this.zzoj.value = t;
        zzdn();
    }

    public final String toString() {
        String zzfg = this.zzoh == null ? "<anon>" : this.zzoh.zzfg();
        String zzgt = this.zzoj.toString(String.valueOf("").concat("\t"));
        return new StringBuilder(String.valueOf("").length() + 1 + String.valueOf(zzfg).length() + String.valueOf(zzgt).length()).append("").append(zzfg).append("\n").append(zzgt).toString();
    }

    public final void zza(zzgs<T> zzgs) {
        Object[] array = this.zzoj.zzkk.entrySet().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < array.length) {
                Map.Entry entry = (Map.Entry) array[i2];
                zzgs.zzd(new zzgp((zzid) entry.getKey(), this, (zzgt) entry.getValue()));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public final void zza(zzgs<T> zzgs, boolean z, boolean z2) {
        if (z && !z2) {
            zzgs.zzd(this);
        }
        zza(new zzgq(this, zzgs, z2));
        if (z && z2) {
            zzgs.zzd(this);
        }
    }

    public final boolean zza(zzgr<T> zzgr, boolean z) {
        for (zzgp<T> zzgp = this.zzoi; zzgp != null; zzgp = zzgp.zzoi) {
            zzgr.zze(zzgp);
        }
        return false;
    }

    public final zzgp<T> zzaj(zzch zzch) {
        zzid zzbw = zzch.zzbw();
        while (zzbw != null) {
            zzgp<T> zzgp = new zzgp<>(zzbw, this, this.zzoj.zzkk.containsKey(zzbw) ? this.zzoj.zzkk.get(zzbw) : new zzgt());
            zzch = zzch.zzbx();
            zzbw = zzch.zzbw();
            this = zzgp;
        }
        return this;
    }

    public final zzch zzg() {
        if (this.zzoi != null) {
            return this.zzoi.zzg().zza(this.zzoh);
        }
        if (this.zzoh == null) {
            return zzch.zzbt();
        }
        return new zzch(this.zzoh);
    }
}
