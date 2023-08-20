package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzgc {
    private static final zzgn<Map<zzhe, zzgb>> zznt = new zzgd();
    private static final zzgn<Map<zzhe, zzgb>> zznu = new zzge();
    /* access modifiers changed from: private */
    public static final zzgn<zzgb> zznv = new zzgf();
    private static final zzgn<zzgb> zznw = new zzgg();
    private final zzhz zzbs;
    private final zzfw zzne;
    private zzgj<Map<zzhe, zzgb>> zznx;
    private final zzkf zzny;
    private long zznz = 0;

    /* JADX INFO: finally extract failed */
    public zzgc(zzfw zzfw, zzhz zzhz, zzkf zzkf) {
        this.zzne = zzfw;
        this.zzbs = zzhz;
        this.zzny = zzkf;
        this.zznx = new zzgj<>(null);
        try {
            this.zzne.beginTransaction();
            this.zzne.zzc(this.zzny.millis());
            this.zzne.setTransactionSuccessful();
            this.zzne.endTransaction();
            for (zzgb next : this.zzne.zzl()) {
                this.zznz = Math.max(next.f26id + 1, this.zznz);
                zzb(next);
            }
        } catch (Throwable th) {
            this.zzne.endTransaction();
            throw th;
        }
    }

    private final List<zzgb> zza(zzgn<zzgb> zzgn) {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<zzch, Map<zzhe, zzgb>>> it = this.zznx.iterator();
        while (it.hasNext()) {
            for (zzgb zzgb : ((Map) it.next().getValue()).values()) {
                if (zzgn.zzd(zzgb)) {
                    arrayList.add(zzgb);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void zza(zzgb zzgb) {
        zzb(zzgb);
        this.zzne.zza(zzgb);
    }

    private final boolean zzad(zzch zzch) {
        return this.zznx.zza(zzch, zznt) != null;
    }

    private final void zzb(zzgb zzgb) {
        HashMap hashMap;
        boolean z = false;
        zzhh zzhh = zzgb.zznp;
        zzkq.zza(!zzhh.zzek() || zzhh.isDefault(), "Can't have tracked non-default query that loads all data");
        Map zzai = this.zznx.zzai(zzgb.zznp.zzg());
        if (zzai == null) {
            HashMap hashMap2 = new HashMap();
            this.zznx = this.zznx.zzb(zzgb.zznp.zzg(), hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = zzai;
        }
        zzgb zzgb2 = (zzgb) hashMap.get(zzgb.zznp.zzen());
        if (zzgb2 == null || zzgb2.f26id == zzgb.f26id) {
            z = true;
        }
        zzkq.zzf(z);
        hashMap.put(zzgb.zznp.zzen(), zzgb);
    }

    private final void zzb(zzhh zzhh, boolean z) {
        zzgb zzgb;
        zzhh zzj = zzj(zzhh);
        zzgb zzk = zzk(zzj);
        long millis = this.zzny.millis();
        if (zzk != null) {
            zzgb zzgb2 = new zzgb(zzk.f26id, zzk.zznp, millis, zzk.zznr, zzk.zzns);
            zzgb = new zzgb(zzgb2.f26id, zzgb2.zznp, zzgb2.zznq, zzgb2.zznr, z);
        } else {
            long j = this.zznz;
            this.zznz = 1 + j;
            zzgb = new zzgb(j, zzj, millis, false, z);
        }
        zza(zzgb);
    }

    private static zzhh zzj(zzhh zzhh) {
        return zzhh.zzek() ? zzhh.zzal(zzhh.zzg()) : zzhh;
    }

    public final zzfx zza(zzfq zzfq) {
        List<zzgb> zza = zza(zznv);
        long size = (long) zza.size();
        long min = size - Math.min((long) Math.floor((double) ((1.0f - zzfq.zzde()) * ((float) size))), zzfq.zzdf());
        zzfx zzfx = new zzfx();
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(new StringBuilder(80).append("Pruning old queries.  Prunable: ").append(zza.size()).append(" Count to prune: ").append(min).toString(), (Throwable) null, new Object[0]);
        }
        Collections.sort(zza, new zzgi(this));
        for (int i = 0; ((long) i) < min; i++) {
            zzgb zzgb = zza.get(i);
            zzfx = zzfx.zzx(zzgb.zznp.zzg());
            zzhh zzj = zzj(zzgb.zznp);
            this.zzne.zzb(zzk(zzj).f26id);
            Map zzai = this.zznx.zzai(zzj.zzg());
            zzai.remove(zzj.zzen());
            if (zzai.isEmpty()) {
                this.zznx = this.zznx.zzah(zzj.zzg());
            }
        }
        int i2 = (int) min;
        zzfx zzfx2 = zzfx;
        while (true) {
            int i3 = i2;
            if (i3 >= zza.size()) {
                break;
            }
            zzfx2 = zzfx2.zzy(zza.get(i3).zznp.zzg());
            i2 = i3 + 1;
        }
        List<zzgb> zza2 = zza(zznw);
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(new StringBuilder(31).append("Unprunable queries: ").append(zza2.size()).toString(), (Throwable) null, new Object[0]);
        }
        for (zzgb zzgb2 : zza2) {
            zzfx2 = zzfx2.zzy(zzgb2.zznp.zzg());
        }
        return zzfx2;
    }

    public final Set<zzid> zzaa(zzch zzch) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        Map zzai = this.zznx.zzai(zzch);
        if (zzai != null) {
            for (zzgb zzgb : zzai.values()) {
                if (!zzgb.zznp.zzek()) {
                    hashSet2.add(Long.valueOf(zzgb.f26id));
                }
            }
        }
        if (!hashSet2.isEmpty()) {
            hashSet.addAll(this.zzne.zza((Set<Long>) hashSet2));
        }
        Iterator<Map.Entry<zzid, zzgj<Map<zzhe, zzgb>>>> it = this.zznx.zzag(zzch).zzdm().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzid zzid = (zzid) next.getKey();
            zzgj zzgj = (zzgj) next.getValue();
            if (zzgj.getValue() != null && zznt.zzd((Map) zzgj.getValue())) {
                hashSet.add(zzid);
            }
        }
        return hashSet;
    }

    public final void zzab(zzch zzch) {
        zzgb zzdi;
        if (!zzad(zzch)) {
            zzhh zzal = zzhh.zzal(zzch);
            zzgb zzk = zzk(zzal);
            if (zzk == null) {
                long j = this.zznz;
                this.zznz = 1 + j;
                zzdi = new zzgb(j, zzal, this.zzny.millis(), true, false);
            } else {
                zzdi = zzk.zzdi();
            }
            zza(zzdi);
        }
    }

    public final boolean zzac(zzch zzch) {
        return this.zznx.zzb(zzch, zznu) != null;
    }

    public final long zzdj() {
        return (long) zza(zznv).size();
    }

    public final void zzg(zzhh zzhh) {
        zzb(zzhh, true);
    }

    public final void zzh(zzhh zzhh) {
        zzb(zzhh, false);
    }

    public final zzgb zzk(zzhh zzhh) {
        zzhh zzj = zzj(zzhh);
        Map zzai = this.zznx.zzai(zzj.zzg());
        if (zzai != null) {
            return (zzgb) zzai.get(zzj.zzen());
        }
        return null;
    }

    public final void zzl(zzhh zzhh) {
        zzgb zzk = zzk(zzj(zzhh));
        if (zzk != null && !zzk.zznr) {
            zza(zzk.zzdi());
        }
    }

    public final boolean zzm(zzhh zzhh) {
        if (zzad(zzhh.zzg())) {
            return true;
        }
        if (zzhh.zzek()) {
            return false;
        }
        Map zzai = this.zznx.zzai(zzhh.zzg());
        return zzai != null && zzai.containsKey(zzhh.zzen()) && ((zzgb) zzai.get(zzhh.zzen())).zznr;
    }

    public final void zzz(zzch zzch) {
        this.zznx.zzag(zzch).zza(new zzgh(this));
    }
}
