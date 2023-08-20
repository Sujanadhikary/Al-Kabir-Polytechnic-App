package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzj extends zzgp<zzj> {
    public String zzad = "";
    public String zzae = "";
    public String zzaf = "";

    public zzj() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzae = zzgm.readString();
                    continue;
                case 18:
                    this.zzaf = zzgm.readString();
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
        if (this.zzae != null && !this.zzae.equals("")) {
            zzgn.zza(1, this.zzae);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(2, this.zzaf);
        }
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(3, this.zzad);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzae != null && !this.zzae.equals("")) {
            zzb += zzgn.zzb(1, this.zzae);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(2, this.zzaf);
        }
        return (this.zzad == null || this.zzad.equals("")) ? zzb : zzb + zzgn.zzb(3, this.zzad);
    }
}
