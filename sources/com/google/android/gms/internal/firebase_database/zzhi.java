package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class zzhi {
    private final zzhh zzpd;
    private final zzhl zzpu;
    private zzhk zzpv;
    private final List<zzce> zzpw = new ArrayList();
    private final zzha zzpx;

    public zzhi(zzhh zzhh, zzhk zzhk) {
        this.zzpd = zzhh;
        zzhr zzhr = new zzhr(zzhh.zzeg());
        zzht zzem = zzhh.zzen().zzem();
        this.zzpu = new zzhl(zzem);
        zzgu zzet = zzhk.zzet();
        zzgu zzer = zzhk.zzer();
        zzit zza = zzit.zza(zzir.zzfv(), zzhh.zzeg());
        zzit zza2 = zzhr.zza(zza, zzet.zzdq(), (zzhq) null);
        zzit zza3 = zzem.zza(zza, zzer.zzdq(), (zzhq) null);
        this.zzpv = new zzhk(new zzgu(zza3, zzer.zzdo(), zzem.zzex()), new zzgu(zza2, zzet.zzdo(), false));
        this.zzpx = new zzha(zzhh);
    }

    private final List<zzgx> zza(List<zzgw> list, zzit zzit, zzce zzce) {
        List<zzce> asList;
        if (zzce == null) {
            asList = this.zzpw;
        } else {
            asList = Arrays.asList(new zzce[]{zzce});
        }
        return this.zzpx.zza(list, zzit, asList);
    }

    public final boolean isEmpty() {
        return this.zzpw.isEmpty();
    }

    public final List<zzgy> zza(zzce zzce, DatabaseError databaseError) {
        ArrayList emptyList;
        if (databaseError != null) {
            ArrayList arrayList = new ArrayList();
            zzch zzg = this.zzpd.zzg();
            for (zzce zzgv : this.zzpw) {
                arrayList.add(new zzgv(zzgv, databaseError, zzg));
            }
            emptyList = arrayList;
        } else {
            emptyList = Collections.emptyList();
        }
        if (zzce != null) {
            int i = 0;
            int i2 = -1;
            while (true) {
                if (i >= this.zzpw.size()) {
                    i = i2;
                    break;
                }
                zzce zzce2 = this.zzpw.get(i);
                if (zzce2.zzc(zzce)) {
                    if (zzce2.zzbs()) {
                        break;
                    }
                    i2 = i;
                }
                i++;
            }
            if (i != -1) {
                this.zzpw.remove(i);
                this.zzpw.get(i).zzbr();
            }
        } else {
            for (zzce zzbr : this.zzpw) {
                zzbr.zzbr();
            }
            this.zzpw.clear();
        }
        return emptyList;
    }

    public final zzhj zzb(zzfl zzfl, zzfg zzfg, zzja zzja) {
        if (zzfl.zzcz() == zzfm.Merge) {
            zzfl.zzcy().zzdc();
        }
        zzho zza = this.zzpu.zza(this.zzpv, zzfl, zzfg, zzja);
        this.zzpv = zza.zzpv;
        return new zzhj(zza(zza.zzpz, zza.zzpv.zzer().zzdq(), (zzce) null), zza.zzpz);
    }

    public final void zzb(zzce zzce) {
        this.zzpw.add(zzce);
    }

    public final zzhh zzeo() {
        return this.zzpd;
    }

    public final zzja zzep() {
        return this.zzpv.zzet().zzd();
    }

    public final zzja zzeq() {
        return this.zzpv.zzer().zzd();
    }

    public final List<zzgx> zzk(zzce zzce) {
        zzgu zzer = this.zzpv.zzer();
        ArrayList arrayList = new ArrayList();
        for (zziz zziz : zzer.zzd()) {
            arrayList.add(zzgw.zzc(zziz.zzge(), zziz.zzd()));
        }
        if (zzer.zzdo()) {
            arrayList.add(zzgw.zza(zzer.zzdq()));
        }
        return zza(arrayList, zzer.zzdq(), zzce);
    }

    public final zzja zzr(zzch zzch) {
        zzja zzeu = this.zzpv.zzeu();
        if (zzeu == null || (!this.zzpd.zzek() && (zzch.isEmpty() || zzeu.zzm(zzch.zzbw()).isEmpty()))) {
            return null;
        }
        return zzeu.zzam(zzch);
    }
}
