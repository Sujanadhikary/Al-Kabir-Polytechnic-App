package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzfd {
    private static final zzgn<zzfa> zzmc = new zzff();
    private zzbv zzlz = zzbv.zzbf();
    private List<zzfa> zzma = new ArrayList();
    private Long zzmb = -1L;

    private static zzbv zza(List<zzfa> list, zzgn<zzfa> zzgn, zzch zzch) {
        zzbv zzbf = zzbv.zzbf();
        Iterator<zzfa> it = list.iterator();
        while (true) {
            zzbv zzbv = zzbf;
            if (!it.hasNext()) {
                return zzbv;
            }
            zzfa next = it.next();
            if (zzgn.zzd(next)) {
                zzch zzg = next.zzg();
                if (next.zzcq()) {
                    if (zzch.zzi(zzg)) {
                        zzbf = zzbv.zze(zzch.zza(zzch, zzg), next.zzco());
                    } else if (zzg.zzi(zzch)) {
                        zzbf = zzbv.zze(zzch.zzbt(), next.zzco().zzam(zzch.zza(zzg, zzch)));
                    }
                } else if (zzch.zzi(zzg)) {
                    zzbf = zzbv.zzb(zzch.zza(zzch, zzg), next.zzcp());
                } else if (zzg.zzi(zzch)) {
                    zzch zza = zzch.zza(zzg, zzch);
                    if (zza.isEmpty()) {
                        zzbf = zzbv.zzb(zzch.zzbt(), next.zzcp());
                    } else {
                        zzja zzf = next.zzcp().zzf(zza);
                        if (zzf != null) {
                            zzbv = zzbv.zze(zzch.zzbt(), zzf);
                        }
                    }
                }
            }
            zzbf = zzbv;
        }
    }

    public final zziz zza(zzch zzch, zzja zzja, zziz zziz, boolean z, zzis zzis) {
        zziz zziz2 = null;
        zzbv zzg = this.zzlz.zzg(zzch);
        zzja<zziz> zzf = zzg.zzf(zzch.zzbt());
        if (zzf == null) {
            if (zzja != null) {
                zzf = zzg.zzb(zzja);
            }
            return zziz2;
        }
        for (zziz zziz3 : zzf) {
            if (zzis.zza(zziz3, zziz, z) <= 0 || (zziz2 != null && zzis.zza(zziz3, zziz2, z) >= 0)) {
                zziz3 = zziz2;
            }
            zziz2 = zziz3;
        }
        return zziz2;
    }

    public final zzja zza(zzch zzch, zzch zzch2, zzja zzja, zzja zzja2) {
        zzch zzh = zzch.zzh(zzch2);
        if (this.zzlz.zze(zzh)) {
            return null;
        }
        zzbv zzg = this.zzlz.zzg(zzh);
        return zzg.isEmpty() ? zzja2.zzam(zzch2) : zzg.zzb(zzja2.zzam(zzch2));
    }

    public final zzja zza(zzch zzch, zzid zzid, zzgu zzgu) {
        zzch zza = zzch.zza(zzid);
        zzja zzf = this.zzlz.zzf(zza);
        if (zzf != null) {
            return zzf;
        }
        if (zzgu.zzf(zzid)) {
            return this.zzlz.zzg(zza).zzb(zzgu.zzd().zzm(zzid));
        }
        return null;
    }

    public final zzja zza(zzch zzch, zzja zzja, List<Long> list, boolean z) {
        if (!list.isEmpty() || z) {
            zzbv zzg = this.zzlz.zzg(zzch);
            if (!z && zzg.isEmpty()) {
                return zzja;
            }
            if (!z && zzja == null && !zzg.zze(zzch.zzbt())) {
                return null;
            }
            zzbv zza = zza(this.zzma, (zzgn<zzfa>) new zzfe(this, z, list, zzch), zzch);
            if (zzja == null) {
                zzja = zzir.zzfv();
            }
            return zza.zzb(zzja);
        }
        zzja zzf = this.zzlz.zzf(zzch);
        if (zzf != null) {
            return zzf;
        }
        zzbv zzg2 = this.zzlz.zzg(zzch);
        if (zzg2.isEmpty()) {
            return zzja;
        }
        if (zzja == null && !zzg2.zze(zzch.zzbt())) {
            return null;
        }
        if (zzja == null) {
            zzja = zzir.zzfv();
        }
        return zzg2.zzb(zzja);
    }

    public final void zza(zzch zzch, zzbv zzbv, Long l) {
        this.zzma.add(new zzfa(l.longValue(), zzch, zzbv));
        this.zzlz = this.zzlz.zzb(zzch, zzbv);
        this.zzmb = l;
    }

    public final void zza(zzch zzch, zzja zzja, Long l, boolean z) {
        this.zzma.add(new zzfa(l.longValue(), zzch, zzja, z));
        if (z) {
            this.zzlz = this.zzlz.zze(zzch, zzja);
        }
        this.zzmb = l;
    }

    public final List<zzfa> zzct() {
        ArrayList arrayList = new ArrayList(this.zzma);
        this.zzlz = zzbv.zzbf();
        this.zzma = new ArrayList();
        return arrayList;
    }

    public final zzja zzj(zzch zzch, zzja zzja) {
        zzja zzja2;
        zzja zzfv = zzir.zzfv();
        zzja zzf = this.zzlz.zzf(zzch);
        if (zzf == null) {
            zzbv zzg = this.zzlz.zzg(zzch);
            Iterator it = zzja.iterator();
            while (true) {
                zzja2 = zzfv;
                if (!it.hasNext()) {
                    break;
                }
                zziz zziz = (zziz) it.next();
                zzfv = zzja2.zze(zziz.zzge(), zzg.zzg(new zzch(zziz.zzge())).zzb(zziz.zzd()));
            }
            for (zziz next : zzg.zzbh()) {
                zzja2 = zzja2.zze(next.zzge(), next.zzd());
            }
            return zzja2;
        } else if (zzf.zzfk()) {
            return zzfv;
        } else {
            Iterator it2 = zzf.iterator();
            while (true) {
                zzja zzja3 = zzfv;
                if (!it2.hasNext()) {
                    return zzja3;
                }
                zziz zziz2 = (zziz) it2.next();
                zzfv = zzja3.zze(zziz2.zzge(), zziz2.zzd());
            }
        }
    }

    public final zzfa zzk(long j) {
        for (zzfa next : this.zzma) {
            if (next.zzcn() == j) {
                return next;
            }
        }
        return null;
    }

    public final boolean zzl(long j) {
        zzfa zzfa;
        boolean z;
        boolean z2;
        boolean z3;
        Iterator<zzfa> it = this.zzma.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                zzfa = null;
                break;
            }
            zzfa next = it.next();
            if (next.zzcn() == j) {
                zzfa = next;
                break;
            }
            i++;
        }
        this.zzma.remove(zzfa);
        boolean isVisible = zzfa.isVisible();
        int size = this.zzma.size() - 1;
        boolean z4 = false;
        while (isVisible && size >= 0) {
            zzfa zzfa2 = this.zzma.get(size);
            if (zzfa2.isVisible()) {
                if (size >= i) {
                    zzch zzg = zzfa.zzg();
                    if (!zzfa2.zzcq()) {
                        Iterator<Map.Entry<zzch, zzja>> it2 = zzfa2.zzcp().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (zzfa2.zzg().zzh((zzch) it2.next().getKey()).zzi(zzg)) {
                                    z3 = true;
                                    break;
                                }
                            } else {
                                z3 = false;
                                break;
                            }
                        }
                    } else {
                        z3 = zzfa2.zzg().zzi(zzg);
                    }
                    if (z3) {
                        z = z4;
                        z2 = false;
                        size--;
                        isVisible = z2;
                        z4 = z;
                    }
                }
                if (zzfa.zzg().zzi(zzfa2.zzg())) {
                    z = true;
                    z2 = isVisible;
                    size--;
                    isVisible = z2;
                    z4 = z;
                }
            }
            z = z4;
            z2 = isVisible;
            size--;
            isVisible = z2;
            z4 = z;
        }
        if (!isVisible) {
            return false;
        }
        if (z4) {
            this.zzlz = zza(this.zzma, zzmc, zzch.zzbt());
            if (this.zzma.size() > 0) {
                this.zzmb = Long.valueOf(this.zzma.get(this.zzma.size() - 1).zzcn());
                return true;
            }
            this.zzmb = -1L;
            return true;
        } else if (zzfa.zzcq()) {
            this.zzlz = this.zzlz.zzd(zzfa.zzg());
            return true;
        } else {
            Iterator<Map.Entry<zzch, zzja>> it3 = zzfa.zzcp().iterator();
            while (it3.hasNext()) {
                this.zzlz = this.zzlz.zzd(zzfa.zzg().zzh((zzch) it3.next().getKey()));
            }
            return true;
        }
    }

    public final zzfg zzt(zzch zzch) {
        return new zzfg(zzch, this);
    }

    public final zzja zzu(zzch zzch) {
        return this.zzlz.zzf(zzch);
    }
}
