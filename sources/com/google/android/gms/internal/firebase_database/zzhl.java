package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class zzhl {
    private static zzhu zzqd = new zzhm();
    private final zzht zzqc;

    public zzhl(zzht zzht) {
        this.zzqc = zzht;
    }

    private final zzhk zza(zzhk zzhk, zzch zzch, zzbv zzbv, zzfg zzfg, zzja zzja, boolean z, zzhq zzhq) {
        if (zzhk.zzet().zzd().isEmpty() && !zzhk.zzet().zzdo()) {
            return zzhk;
        }
        if (!zzch.isEmpty()) {
            zzbv = zzbv.zzbf().zzb(zzch, zzbv);
        }
        zzja zzd = zzhk.zzet().zzd();
        Map<zzid, zzbv> zzbi = zzbv.zzbi();
        zzhk zzhk2 = zzhk;
        for (Map.Entry next : zzbi.entrySet()) {
            zzid zzid = (zzid) next.getKey();
            if (zzd.zzk(zzid)) {
                zzhk2 = zza(zzhk2, new zzch(zzid), ((zzbv) next.getValue()).zzb(zzd.zzm(zzid)), zzfg, zzja, z, zzhq);
            }
        }
        for (Map.Entry next2 : zzbi.entrySet()) {
            zzid zzid2 = (zzid) next2.getKey();
            boolean z2 = !zzhk.zzet().zzf(zzid2) && ((zzbv) next2.getValue()).zzbg() == null;
            if (!zzd.zzk(zzid2) && !z2) {
                zzhk2 = zza(zzhk2, new zzch(zzid2), ((zzbv) next2.getValue()).zzb(zzd.zzm(zzid2)), zzfg, zzja, z, zzhq);
            }
        }
        return zzhk2;
    }

    private final zzhk zza(zzhk zzhk, zzch zzch, zzfg zzfg, zzhu zzhu, zzhq zzhq) {
        zzja zza;
        zzit zza2;
        zzja zzc;
        zzgu zzer = zzhk.zzer();
        if (zzfg.zzu(zzch) != null) {
            return zzhk;
        }
        if (zzch.isEmpty()) {
            if (zzhk.zzet().zzdp()) {
                zzja zzeu = zzhk.zzeu();
                if (!(zzeu instanceof zzif)) {
                    zzeu = zzir.zzfv();
                }
                zzc = zzfg.zzd(zzeu);
            } else {
                zzc = zzfg.zzc(zzhk.zzeu());
            }
            zza2 = this.zzqc.zza(zzhk.zzer().zzdq(), zzit.zza(zzc, this.zzqc.zzeg()), zzhq);
        } else {
            zzid zzbw = zzch.zzbw();
            if (zzbw.zzfh()) {
                zzja zza3 = zzfg.zza(zzch, zzer.zzd(), zzhk.zzet().zzd());
                zza2 = zza3 != null ? this.zzqc.zza(zzer.zzdq(), zza3) : zzer.zzdq();
            } else {
                zzch zzbx = zzch.zzbx();
                if (zzer.zzf(zzbw)) {
                    zzja zza4 = zzfg.zza(zzch, zzer.zzd(), zzhk.zzet().zzd());
                    zza = zza4 != null ? zzer.zzd().zzm(zzbw).zzl(zzbx, zza4) : zzer.zzd().zzm(zzbw);
                } else {
                    zza = zzfg.zza(zzbw, zzhk.zzet());
                }
                zza2 = zza != null ? this.zzqc.zza(zzer.zzdq(), zzbw, zza, zzbx, zzhu, zzhq) : zzer.zzdq();
            }
        }
        return zzhk.zza(zza2, zzer.zzdo() || zzch.isEmpty(), this.zzqc.zzex());
    }

    private final zzhk zza(zzhk zzhk, zzch zzch, zzja zzja, zzfg zzfg, zzja zzja2, zzhq zzhq) {
        zzja zzh;
        zzgu zzer = zzhk.zzer();
        zzhp zzhp = new zzhp(zzfg, zzhk, zzja2);
        if (zzch.isEmpty()) {
            return zzhk.zza(this.zzqc.zza(zzhk.zzer().zzdq(), zzit.zza(zzja, this.zzqc.zzeg()), zzhq), true, this.zzqc.zzex());
        }
        zzid zzbw = zzch.zzbw();
        if (zzbw.zzfh()) {
            return zzhk.zza(this.zzqc.zza(zzhk.zzer().zzdq(), zzja), zzer.zzdo(), zzer.zzdp());
        }
        zzch zzbx = zzch.zzbx();
        zzja zzm = zzer.zzd().zzm(zzbw);
        if (zzbx.isEmpty()) {
            zzh = zzja;
        } else {
            zzh = zzhp.zzh(zzbw);
            if (zzh == null) {
                zzh = zzir.zzfv();
            } else if (!zzbx.zzbz().zzfh() || !zzh.zzam(zzbx.zzby()).isEmpty()) {
                zzh = zzh.zzl(zzbx, zzja);
            }
        }
        return !zzm.equals(zzh) ? zzhk.zza(this.zzqc.zza(zzer.zzdq(), zzbw, zzh, zzbx, zzhp, zzhq), zzer.zzdo(), this.zzqc.zzex()) : zzhk;
    }

    private final zzhk zza(zzhk zzhk, zzch zzch, zzja zzja, zzfg zzfg, zzja zzja2, boolean z, zzhq zzhq) {
        zzit zza;
        zzgu zzet = zzhk.zzet();
        zzht zzew = z ? this.zzqc : this.zzqc.zzew();
        if (zzch.isEmpty()) {
            zza = zzew.zza(zzet.zzdq(), zzit.zza(zzja, zzew.zzeg()), (zzhq) null);
        } else if (!zzew.zzex() || zzet.zzdp()) {
            zzid zzbw = zzch.zzbw();
            if (!zzet.zzak(zzch) && zzch.size() > 1) {
                return zzhk;
            }
            zzch zzbx = zzch.zzbx();
            zzja zzl = zzet.zzd().zzm(zzbw).zzl(zzbx, zzja);
            zza = zzbw.zzfh() ? zzew.zza(zzet.zzdq(), zzl) : zzew.zza(zzet.zzdq(), zzbw, zzl, zzbx, zzqd, (zzhq) null);
        } else {
            zzid zzbw2 = zzch.zzbw();
            zza = zzew.zza(zzet.zzdq(), zzet.zzdq().zzg(zzbw2, zzet.zzd().zzm(zzbw2).zzl(zzch.zzbx(), zzja)), (zzhq) null);
        }
        zzhk zzb = zzhk.zzb(zza, zzet.zzdo() || zzch.isEmpty(), zzew.zzex());
        return zza(zzb, zzch, zzfg, new zzhp(zzfg, zzb, zzja2), zzhq);
    }

    private static boolean zza(zzhk zzhk, zzid zzid) {
        return zzhk.zzer().zzf(zzid);
    }

    public final zzho zza(zzhk zzhk, zzfl zzfl, zzfg zzfg, zzja zzja) {
        zzhk zza;
        boolean z;
        zzhq zzhq = new zzhq();
        switch (zzhn.zzqe[zzfl.zzcz().ordinal()]) {
            case 1:
                zzfp zzfp = (zzfp) zzfl;
                if (!zzfp.zzcy().zzda()) {
                    zza = zza(zzhk, zzfp.zzg(), zzfp.zzdd(), zzfg, zzja, zzfp.zzcy().zzdb() || (zzhk.zzet().zzdp() && !zzfp.zzg().isEmpty()), zzhq);
                    break;
                } else {
                    zza = zza(zzhk, zzfp.zzg(), zzfp.zzdd(), zzfg, zzja, zzhq);
                    break;
                }
                break;
            case 2:
                zzfk zzfk = (zzfk) zzfl;
                if (!zzfk.zzcy().zzda()) {
                    zza = zza(zzhk, zzfk.zzg(), zzfk.zzcx(), zzfg, zzja, zzfk.zzcy().zzdb() || zzhk.zzet().zzdp(), zzhq);
                    break;
                } else {
                    zzch zzg = zzfk.zzg();
                    zzbv zzcx = zzfk.zzcx();
                    Iterator<Map.Entry<zzch, zzja>> it = zzcx.iterator();
                    zzhk zzhk2 = zzhk;
                    while (it.hasNext()) {
                        Map.Entry next = it.next();
                        zzch zzh = zzg.zzh((zzch) next.getKey());
                        if (zza(zzhk, zzh.zzbw())) {
                            zzhk2 = zza(zzhk2, zzh, (zzja) next.getValue(), zzfg, zzja, zzhq);
                        }
                    }
                    Iterator<Map.Entry<zzch, zzja>> it2 = zzcx.iterator();
                    while (it2.hasNext()) {
                        Map.Entry next2 = it2.next();
                        zzch zzh2 = zzg.zzh((zzch) next2.getKey());
                        if (!zza(zzhk, zzh2.zzbw())) {
                            zzhk2 = zza(zzhk2, zzh2, (zzja) next2.getValue(), zzfg, zzja, zzhq);
                        }
                    }
                    zza = zzhk2;
                    break;
                }
                break;
            case 3:
                zzfi zzfi = (zzfi) zzfl;
                if (!zzfi.zzcw()) {
                    zzch zzg2 = zzfi.zzg();
                    zzgj<Boolean> zzcv = zzfi.zzcv();
                    if (zzfg.zzu(zzg2) == null) {
                        boolean zzdp = zzhk.zzet().zzdp();
                        zzgu zzet = zzhk.zzet();
                        if (zzcv.getValue() != null) {
                            if ((!zzg2.isEmpty() || !zzet.zzdo()) && !zzet.zzak(zzg2)) {
                                if (!zzg2.isEmpty()) {
                                    zza = zzhk;
                                    break;
                                } else {
                                    zzbv zzbf = zzbv.zzbf();
                                    for (zziz zziz : zzet.zzd()) {
                                        zzbf = zzbf.zza(zziz.zzge(), zziz.zzd());
                                    }
                                    zza = zza(zzhk, zzg2, zzbf, zzfg, zzja, zzdp, zzhq);
                                    break;
                                }
                            } else {
                                zza = zza(zzhk, zzg2, zzet.zzd().zzam(zzg2), zzfg, zzja, zzdp, zzhq);
                                break;
                            }
                        } else {
                            zzbv zzbf2 = zzbv.zzbf();
                            Iterator<Map.Entry<zzch, Boolean>> it3 = zzcv.iterator();
                            while (it3.hasNext()) {
                                zzch zzch = (zzch) it3.next().getKey();
                                zzch zzh3 = zzg2.zzh(zzch);
                                if (zzet.zzak(zzh3)) {
                                    zzbf2 = zzbf2.zze(zzch, zzet.zzd().zzam(zzh3));
                                }
                            }
                            zza = zza(zzhk, zzg2, zzbf2, zzfg, zzja, zzdp, zzhq);
                            break;
                        }
                    } else {
                        zza = zzhk;
                        break;
                    }
                } else {
                    zzch zzg3 = zzfi.zzg();
                    if (zzfg.zzu(zzg3) != null) {
                        zza = zzhk;
                        break;
                    } else {
                        zzhp zzhp = new zzhp(zzfg, zzhk, zzja);
                        zzit zzdq = zzhk.zzer().zzdq();
                        if (zzg3.isEmpty() || zzg3.zzbw().zzfh()) {
                            zzdq = this.zzqc.zza(zzdq, zzit.zza(zzhk.zzet().zzdo() ? zzfg.zzc(zzhk.zzeu()) : zzfg.zzd(zzhk.zzet().zzd()), this.zzqc.zzeg()), zzhq);
                        } else {
                            zzid zzbw = zzg3.zzbw();
                            zzja zza2 = zzfg.zza(zzbw, zzhk.zzet());
                            if (zza2 == null && zzhk.zzet().zzf(zzbw)) {
                                zza2 = zzdq.zzd().zzm(zzbw);
                            }
                            if (zza2 != null) {
                                zzdq = this.zzqc.zza(zzdq, zzbw, zza2, zzg3.zzbx(), zzhp, zzhq);
                            } else if (zza2 == null && zzhk.zzer().zzd().zzk(zzbw)) {
                                zzdq = this.zzqc.zza(zzdq, zzbw, zzir.zzfv(), zzg3.zzbx(), zzhp, zzhq);
                            }
                            if (zzdq.zzd().isEmpty() && zzhk.zzet().zzdo()) {
                                zzja zzc = zzfg.zzc(zzhk.zzeu());
                                if (zzc.zzfk()) {
                                    zzdq = this.zzqc.zza(zzdq, zzit.zza(zzc, this.zzqc.zzeg()), zzhq);
                                }
                            }
                        }
                        if (!zzhk.zzet().zzdo()) {
                            if (zzfg.zzu(zzch.zzbt()) == null) {
                                z = false;
                                zza = zzhk.zza(zzdq, z, this.zzqc.zzex());
                                break;
                            }
                        }
                        z = true;
                        zza = zzhk.zza(zzdq, z, this.zzqc.zzex());
                    }
                }
                break;
            case 4:
                zzch zzg4 = zzfl.zzg();
                zzgu zzet2 = zzhk.zzet();
                zza = zza(zzhk.zzb(zzet2.zzdq(), zzet2.zzdo() || zzg4.isEmpty(), zzet2.zzdp()), zzg4, zzfg, zzqd, zzhq);
                break;
            default:
                String valueOf = String.valueOf(zzfl.zzcz());
                throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 19).append("Unknown operation: ").append(valueOf).toString());
        }
        ArrayList arrayList = new ArrayList(zzhq.zzev());
        zzgu zzer = zza.zzer();
        if (zzer.zzdo()) {
            boolean z2 = zzer.zzd().zzfk() || zzer.zzd().isEmpty();
            if (!arrayList.isEmpty() || !zzhk.zzer().zzdo() || ((z2 && !zzer.zzd().equals(zzhk.zzes())) || !zzer.zzd().zzfl().equals(zzhk.zzes().zzfl()))) {
                arrayList.add(zzgw.zza(zzer.zzdq()));
            }
        }
        return new zzho(zza, arrayList);
    }
}
