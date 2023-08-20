package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzee {
    /* access modifiers changed from: private */
    public final zzhz zzbs;
    /* access modifiers changed from: private */
    public final zzfv zzkp;
    /* access modifiers changed from: private */
    public zzgj<zzed> zzkq = zzgj.zzdl();
    /* access modifiers changed from: private */
    public final zzfd zzkr = new zzfd();
    /* access modifiers changed from: private */
    public final Map<zzex, zzhh> zzks = new HashMap();
    /* access modifiers changed from: private */
    public final Map<zzhh, zzex> zzkt = new HashMap();
    private final Set<zzhh> zzku = new HashSet();
    /* access modifiers changed from: private */
    public final zzew zzkv;
    private long zzkw = 1;

    public zzee(zzbz zzbz, zzfv zzfv, zzew zzew) {
        this.zzkv = zzew;
        this.zzkp = zzfv;
        this.zzbs = zzbz.zzp("SyncTree");
    }

    /* access modifiers changed from: private */
    public final List<zzgy> zza(zzfl zzfl) {
        return zza(zzfl, this.zzkq, (zzja) null, this.zzkr.zzt(zzch.zzbt()));
    }

    private final List<zzgy> zza(zzfl zzfl, zzgj<zzed> zzgj, zzja zzja, zzfg zzfg) {
        if (zzfl.zzg().isEmpty()) {
            return zzb(zzfl, zzgj, zzja, zzfg);
        }
        zzed value = zzgj.getValue();
        if (zzja == null && value != null) {
            zzja = value.zzr(zzch.zzbt());
        }
        ArrayList arrayList = new ArrayList();
        zzid zzbw = zzfl.zzg().zzbw();
        zzfl zzc = zzfl.zzc(zzbw);
        zzgj zzgj2 = zzgj.zzdm().get(zzbw);
        if (!(zzgj2 == null || zzc == null)) {
            arrayList.addAll(zza(zzc, (zzgj<zzed>) zzgj2, zzja != null ? zzja.zzm(zzbw) : null, zzfg.zzb(zzbw)));
        }
        if (value != null) {
            arrayList.addAll(value.zza(zzfl, zzfg, zzja));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<zzhi> zza(zzgj<zzed> zzgj) {
        ArrayList arrayList = new ArrayList();
        zza(zzgj, (List<zzhi>) arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final List<? extends zzgy> zza(zzhh zzhh, zzfl zzfl) {
        zzch zzg = zzhh.zzg();
        return this.zzkq.zzai(zzg).zza(zzfl, this.zzkr.zzt(zzg), (zzja) null);
    }

    private final void zza(zzgj<zzed> zzgj, List<zzhi> list) {
        zzed value = zzgj.getValue();
        if (value == null || !value.zzci()) {
            if (value != null) {
                list.addAll(value.zzch());
            }
            Iterator<Map.Entry<zzid, zzgj<zzed>>> it = zzgj.zzdm().iterator();
            while (it.hasNext()) {
                zza((zzgj<zzed>) (zzgj) it.next().getValue(), list);
            }
            return;
        }
        list.add(value.zzcj());
    }

    /* access modifiers changed from: private */
    public final void zza(zzhh zzhh, zzhi zzhi) {
        zzch zzg = zzhh.zzg();
        zzex zze = zze(zzhh);
        zzev zzev = new zzev(this, zzhi);
        this.zzkv.zza(zzd(zzhh), zze, zzev, zzev);
        zzgj<zzed> zzag = this.zzkq.zzag(zzg);
        if (zze == null) {
            zzag.zza(new zzej(this));
        }
    }

    /* access modifiers changed from: private */
    public final zzhh zzb(zzex zzex) {
        return this.zzks.get(zzex);
    }

    /* access modifiers changed from: private */
    public final List<zzgy> zzb(zzfl zzfl, zzgj<zzed> zzgj, zzja zzja, zzfg zzfg) {
        zzed value = zzgj.getValue();
        zzja zzr = (zzja != null || value == null) ? zzja : value.zzr(zzch.zzbt());
        ArrayList arrayList = new ArrayList();
        zzgj.zzdm().inOrderTraversal(new zzek(this, zzr, zzfg, zzfl, arrayList));
        if (value != null) {
            arrayList.addAll(value.zza(zzfl, zzfg, zzr));
        }
        return arrayList;
    }

    private final List<zzgy> zzb(zzhh zzhh, zzce zzce, DatabaseError databaseError) {
        return (List) this.zzkp.zza(new zzei(this, zzhh, zzce, databaseError));
    }

    /* access modifiers changed from: private */
    public final zzex zzcl() {
        long j = this.zzkw;
        this.zzkw = 1 + j;
        return new zzex(j);
    }

    /* access modifiers changed from: private */
    public static zzhh zzd(zzhh zzhh) {
        return (!zzhh.zzek() || zzhh.isDefault()) ? zzhh : zzhh.zzal(zzhh.zzg());
    }

    /* access modifiers changed from: private */
    public final void zzd(List<zzhh> list) {
        for (zzhh next : list) {
            if (!next.zzek()) {
                zzex zze = zze(next);
                this.zzkt.remove(next);
                this.zzks.remove(zze);
            }
        }
    }

    /* access modifiers changed from: private */
    public final zzex zze(zzhh zzhh) {
        return this.zzkt.get(zzhh);
    }

    public final boolean isEmpty() {
        return this.zzkq.isEmpty();
    }

    public final List<? extends zzgy> zza(long j, boolean z, boolean z2, zzkf zzkf) {
        return (List) this.zzkp.zza(new zzem(this, z2, j, z, zzkf));
    }

    public final List<? extends zzgy> zza(zzch zzch, zzbv zzbv, zzbv zzbv2, long j, boolean z) {
        return (List) this.zzkp.zza(new zzel(this, z, zzch, zzbv, j, zzbv2));
    }

    public final List<? extends zzgy> zza(zzch zzch, zzja zzja, zzex zzex) {
        return (List) this.zzkp.zza(new zzes(this, zzex, zzch, zzja));
    }

    public final List<? extends zzgy> zza(zzch zzch, zzja zzja, zzja zzja2, long j, boolean z, boolean z2) {
        zzkq.zza(z || !z2, "We shouldn't be persisting non-visible writes.");
        return (List) this.zzkp.zza(new zzef(this, z2, zzch, zzja, j, zzja2, z));
    }

    public final List<? extends zzgy> zza(zzch zzch, List<zzjh> list, zzex zzex) {
        zzhh zzb = zzb(zzex);
        if (zzb == null) {
            return Collections.emptyList();
        }
        zzja zzep = this.zzkq.zzai(zzb.zzg()).zzb(zzb).zzep();
        Iterator<zzjh> it = list.iterator();
        while (true) {
            zzja zzja = zzep;
            if (!it.hasNext()) {
                return zza(zzch, zzja, zzex);
            }
            zzep = it.next().zzm(zzja);
        }
    }

    public final List<? extends zzgy> zza(zzch zzch, Map<zzch, zzja> map) {
        return (List) this.zzkp.zza(new zzep(this, map, zzch));
    }

    public final List<? extends zzgy> zza(zzch zzch, Map<zzch, zzja> map, zzex zzex) {
        return (List) this.zzkp.zza(new zzeg(this, zzex, zzch, map));
    }

    public final List<? extends zzgy> zza(zzex zzex) {
        return (List) this.zzkp.zza(new zzer(this, zzex));
    }

    public final List<zzgy> zza(zzhh zzhh, DatabaseError databaseError) {
        return zzb(zzhh, (zzce) null, databaseError);
    }

    public final void zza(zzhh zzhh, boolean z) {
        if (z && !this.zzku.contains(zzhh)) {
            zzg((zzce) new zzeu(zzhh));
            this.zzku.add(zzhh);
        } else if (!z && this.zzku.contains(zzhh)) {
            zzh((zzce) new zzeu(zzhh));
            this.zzku.remove(zzhh);
        }
    }

    public final List<? extends zzgy> zzb(zzch zzch, List<zzjh> list) {
        zzed zzai = this.zzkq.zzai(zzch);
        if (zzai == null) {
            return Collections.emptyList();
        }
        zzhi zzcj = zzai.zzcj();
        if (zzcj == null) {
            return Collections.emptyList();
        }
        zzja zzep = zzcj.zzep();
        Iterator<zzjh> it = list.iterator();
        while (true) {
            zzja zzja = zzep;
            if (!it.hasNext()) {
                return zzi(zzch, zzja);
            }
            zzep = it.next().zzm(zzja);
        }
    }

    public final zzja zzc(zzch zzch, List<Long> list) {
        zzja zzr;
        zzgj<zzed> zzgj = this.zzkq;
        zzgj.getValue();
        zzja zzja = null;
        zzch zzbt = zzch.zzbt();
        zzgj<zzed> zzgj2 = zzgj;
        zzch zzch2 = zzch;
        while (true) {
            zzid zzbw = zzch2.zzbw();
            zzch zzbx = zzch2.zzbx();
            zzch zza = zzbt.zza(zzbw);
            zzch zza2 = zzch.zza(zza, zzch);
            zzgj2 = zzbw != null ? zzgj2.zze(zzbw) : zzgj.zzdl();
            zzed value = zzgj2.getValue();
            zzr = value != null ? value.zzr(zza2) : zzja;
            if (!zzbx.isEmpty() && zzr == null) {
                zzja = zzr;
                zzbt = zza;
                zzch2 = zzbx;
            }
        }
        return this.zzkr.zza(zzch, zzr, list, true);
    }

    public final List<? extends zzgy> zzck() {
        return (List) this.zzkp.zza(new zzen(this));
    }

    public final List<? extends zzgy> zzg(zzce zzce) {
        return (List) this.zzkp.zza(new zzeh(this, zzce));
    }

    public final List<zzgy> zzh(zzce zzce) {
        return zzb(zzce.zzbe(), zzce, (DatabaseError) null);
    }

    public final List<? extends zzgy> zzi(zzch zzch, zzja zzja) {
        return (List) this.zzkp.zza(new zzeo(this, zzch, zzja));
    }

    public final List<? extends zzgy> zzs(zzch zzch) {
        return (List) this.zzkp.zza(new zzeq(this, zzch));
    }
}
