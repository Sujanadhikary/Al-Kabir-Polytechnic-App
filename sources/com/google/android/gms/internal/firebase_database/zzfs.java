package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;

public final class zzfs implements zzfv {
    private final zzhz zzbs;
    private final zzfw zzne;
    private final zzgc zznf;
    private final zzfq zzng;
    private long zznh;

    public zzfs(zzbz zzbz, zzfw zzfw, zzfq zzfq) {
        this(zzbz, zzfw, zzfq, new zzkg());
    }

    private zzfs(zzbz zzbz, zzfw zzfw, zzfq zzfq, zzkf zzkf) {
        this.zznh = 0;
        this.zzne = zzfw;
        this.zzbs = zzbz.zzp("Persistence");
        this.zznf = new zzgc(this.zzne, this.zzbs, zzkf);
        this.zzng = zzfq;
    }

    private final void zzdg() {
        this.zznh++;
        if (this.zzng.zzm(this.zznh)) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("Reached prune check threshold.", (Throwable) null, new Object[0]);
            }
            this.zznh = 0;
            boolean z = true;
            long zzk = this.zzne.zzk();
            if (this.zzbs.zzfa()) {
                this.zzbs.zza(new StringBuilder(32).append("Cache size: ").append(zzk).toString(), (Throwable) null, new Object[0]);
            }
            while (z && this.zzng.zza(zzk, this.zznf.zzdj())) {
                zzfx zza = this.zznf.zza(this.zzng);
                if (zza.zzdh()) {
                    this.zzne.zza(zzch.zzbt(), zza);
                } else {
                    z = false;
                }
                zzk = this.zzne.zzk();
                if (this.zzbs.zzfa()) {
                    this.zzbs.zza(new StringBuilder(44).append("Cache size after prune: ").append(zzk).toString(), (Throwable) null, new Object[0]);
                }
            }
        }
    }

    public final <T> T zza(Callable<T> callable) {
        this.zzne.beginTransaction();
        try {
            T call = callable.call();
            this.zzne.setTransactionSuccessful();
            this.zzne.endTransaction();
            return call;
        } catch (Throwable th) {
            this.zzne.endTransaction();
            throw th;
        }
    }

    public final void zza(long j) {
        this.zzne.zza(j);
    }

    public final void zza(zzch zzch, zzbv zzbv, long j) {
        this.zzne.zza(zzch, zzbv, j);
    }

    public final void zza(zzch zzch, zzja zzja, long j) {
        this.zzne.zza(zzch, zzja, j);
    }

    public final void zza(zzhh zzhh, zzja zzja) {
        if (zzhh.zzek()) {
            this.zzne.zza(zzhh.zzg(), zzja);
        } else {
            this.zzne.zzb(zzhh.zzg(), zzja);
        }
        zzi(zzhh);
        zzdg();
    }

    public final void zza(zzhh zzhh, Set<zzid> set) {
        this.zzne.zza(this.zznf.zzk(zzhh).f26id, set);
    }

    public final void zza(zzhh zzhh, Set<zzid> set, Set<zzid> set2) {
        this.zzne.zza(this.zznf.zzk(zzhh).f26id, set, set2);
    }

    public final void zzc(zzch zzch, zzbv zzbv) {
        Iterator<Map.Entry<zzch, zzja>> it = zzbv.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzk(zzch.zzh((zzch) next.getKey()), (zzja) next.getValue());
        }
    }

    public final void zzd(zzch zzch, zzbv zzbv) {
        this.zzne.zza(zzch, zzbv);
        zzdg();
    }

    public final zzgu zzf(zzhh zzhh) {
        Set<zzid> zzaa;
        boolean z;
        if (this.zznf.zzm(zzhh)) {
            zzgb zzk = this.zznf.zzk(zzhh);
            if (zzhh.zzek() || zzk == null || !zzk.zznr) {
                zzaa = null;
                z = true;
            } else {
                zzaa = this.zzne.zzd(zzk.f26id);
                z = true;
            }
        } else {
            zzaa = this.zznf.zzaa(zzhh.zzg());
            z = false;
        }
        zzja zza = this.zzne.zza(zzhh.zzg());
        if (zzaa == null) {
            return new zzgu(zzit.zza(zza, zzhh.zzeg()), true, false);
        }
        zzja zzfv = zzir.zzfv();
        Iterator<zzid> it = zzaa.iterator();
        while (true) {
            zzja zzja = zzfv;
            if (!it.hasNext()) {
                return new zzgu(zzit.zza(zzja, zzhh.zzeg()), z, true);
            }
            zzid next = it.next();
            zzfv = zzja.zze(next, zza.zzm(next));
        }
    }

    public final void zzg(zzhh zzhh) {
        this.zznf.zzg(zzhh);
    }

    public final void zzh(zzhh zzhh) {
        this.zznf.zzh(zzhh);
    }

    public final void zzi(zzhh zzhh) {
        if (zzhh.zzek()) {
            this.zznf.zzz(zzhh.zzg());
        } else {
            this.zznf.zzl(zzhh);
        }
    }

    public final List<zzfa> zzj() {
        return this.zzne.zzj();
    }

    public final void zzk(zzch zzch, zzja zzja) {
        if (!this.zznf.zzac(zzch)) {
            this.zzne.zza(zzch, zzja);
            this.zznf.zzab(zzch);
        }
    }

    public final void zzm() {
        this.zzne.zzm();
    }
}
