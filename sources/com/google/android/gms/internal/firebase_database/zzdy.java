package com.google.android.gms.internal.firebase_database;

import java.util.HashMap;
import java.util.Map;

final class zzdy {
    private zzja zzkj = null;
    private Map<zzid, zzdy> zzkk = null;

    public final void zza(zzch zzch, zzec zzec) {
        if (this.zzkj != null) {
            zzec.zzf(zzch, this.zzkj);
            return;
        }
        zzea zzea = new zzea(this, zzch, zzec);
        if (this.zzkk != null) {
            for (Map.Entry next : this.zzkk.entrySet()) {
                zzea.zza((zzid) next.getKey(), (zzdy) next.getValue());
            }
        }
    }

    public final void zzh(zzch zzch, zzja zzja) {
        while (!zzch.isEmpty()) {
            if (this.zzkj != null) {
                this.zzkj = this.zzkj.zzl(zzch, zzja);
                return;
            }
            if (this.zzkk == null) {
                this.zzkk = new HashMap();
            }
            zzid zzbw = zzch.zzbw();
            if (!this.zzkk.containsKey(zzbw)) {
                this.zzkk.put(zzbw, new zzdy());
            }
            zzch = zzch.zzbx();
            this = this.zzkk.get(zzbw);
        }
        this.zzkj = zzja;
        this.zzkk = null;
    }

    public final boolean zzq(zzch zzch) {
        while (!zzch.isEmpty()) {
            if (this.zzkj != null) {
                if (this.zzkj.zzfk()) {
                    return false;
                }
                this.zzkj = null;
                ((zzif) this.zzkj).zza((zzii) new zzdz(this, zzch), false);
            } else if (this.zzkk == null) {
                return true;
            } else {
                zzid zzbw = zzch.zzbw();
                zzch zzbx = zzch.zzbx();
                if (this.zzkk.containsKey(zzbw) && this.zzkk.get(zzbw).zzq(zzbx)) {
                    this.zzkk.remove(zzbw);
                }
                if (!this.zzkk.isEmpty()) {
                    return false;
                }
                this.zzkk = null;
                return true;
            }
        }
        this.zzkj = null;
        this.zzkk = null;
        return true;
    }
}
