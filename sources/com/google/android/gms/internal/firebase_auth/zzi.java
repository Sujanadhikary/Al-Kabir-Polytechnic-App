package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzi extends zzgp<zzi> {
    private String zzab = "";
    private long zzac = 0;
    public String zzad = "";

    public zzi() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzab = zzgm.readString();
                    continue;
                case 16:
                    this.zzac = zzgm.zzcs();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzad = zzgm.readString();
                    continue;
                default:
                    if (!super.zza(zzgm, zzbz)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzgn zzgn) throws IOException {
        if (this.zzab != null && !this.zzab.equals("")) {
            zzgn.zza(1, this.zzab);
        }
        if (this.zzac != 0) {
            zzgn.zzi(2, this.zzac);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(3, this.zzad);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzab != null && !this.zzab.equals("")) {
            zzb += zzgn.zzb(1, this.zzab);
        }
        if (this.zzac != 0) {
            zzb += zzgn.zzd(2, this.zzac);
        }
        return (this.zzad == null || this.zzad.equals("")) ? zzb : zzb + zzgn.zzb(3, this.zzad);
    }
}
