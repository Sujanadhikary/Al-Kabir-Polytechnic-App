package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzm extends zzgp<zzm> {
    public String zzae = "";
    private String zzaf = "";
    public String zzay = "";
    private String zzaz = "";

    public zzm() {
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
                    this.zzay = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzaz = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzaf = zzgm.readString();
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
        if (this.zzay != null && !this.zzay.equals("")) {
            zzgn.zza(2, this.zzay);
        }
        if (this.zzaz != null && !this.zzaz.equals("")) {
            zzgn.zza(3, this.zzaz);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(4, this.zzaf);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzae != null && !this.zzae.equals("")) {
            zzb += zzgn.zzb(1, this.zzae);
        }
        if (this.zzay != null && !this.zzay.equals("")) {
            zzb += zzgn.zzb(2, this.zzay);
        }
        if (this.zzaz != null && !this.zzaz.equals("")) {
            zzb += zzgn.zzb(3, this.zzaz);
        }
        return (this.zzaf == null || this.zzaf.equals("")) ? zzb : zzb + zzgn.zzb(4, this.zzaf);
    }
}
