package com.google.android.gms.internal.firebase_database;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

final class zzem implements Callable<List<? extends zzgy>> {
    private final /* synthetic */ long zzjh;
    private final /* synthetic */ boolean zzkx;
    private final /* synthetic */ zzee zzlb;
    private final /* synthetic */ boolean zzll;
    private final /* synthetic */ zzkf zzlm;

    zzem(zzee zzee, boolean z, long j, boolean z2, zzkf zzkf) {
        this.zzlb = zzee;
        this.zzkx = z;
        this.zzjh = j;
        this.zzll = z2;
        this.zzlm = zzkf;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzgj zzgj;
        if (this.zzkx) {
            this.zzlb.zzkp.zza(this.zzjh);
        }
        zzfa zzk = this.zzlb.zzkr.zzk(this.zzjh);
        boolean zzl = this.zzlb.zzkr.zzl(this.zzjh);
        if (zzk.isVisible() && !this.zzll) {
            Map<String, Object> zza = zzdu.zza(this.zzlm);
            if (zzk.zzcq()) {
                this.zzlb.zzkp.zzk(zzk.zzg(), zzdu.zza(zzk.zzco(), zza));
            } else {
                this.zzlb.zzkp.zzc(zzk.zzg(), zzdu.zza(zzk.zzcp(), zza));
            }
        }
        if (!zzl) {
            return Collections.emptyList();
        }
        zzgj zzdl = zzgj.zzdl();
        if (!zzk.zzcq()) {
            Iterator<Map.Entry<zzch, zzja>> it = zzk.zzcp().iterator();
            while (true) {
                zzgj = zzdl;
                if (!it.hasNext()) {
                    break;
                }
                zzdl = zzgj.zzb((zzch) it.next().getKey(), true);
            }
        } else {
            zzgj = zzdl.zzb(zzch.zzbt(), true);
        }
        return this.zzlb.zza((zzfl) new zzfi(zzk.zzg(), zzgj, this.zzll));
    }
}
