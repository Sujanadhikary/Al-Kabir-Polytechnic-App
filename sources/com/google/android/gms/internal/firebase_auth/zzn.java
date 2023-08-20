package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzn extends zzgp<zzn> {
    public String zzbb = "";
    private String zzbc = "";
    private String zzbd = "";
    private String zzbe = "";

    public zzn() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzbb = zzgm.readString();
                    continue;
                case 18:
                    this.zzbc = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzbd = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzbe = zzgm.readString();
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
        if (this.zzbb != null && !this.zzbb.equals("")) {
            zzgn.zza(1, this.zzbb);
        }
        if (this.zzbc != null && !this.zzbc.equals("")) {
            zzgn.zza(2, this.zzbc);
        }
        if (this.zzbd != null && !this.zzbd.equals("")) {
            zzgn.zza(3, this.zzbd);
        }
        if (this.zzbe != null && !this.zzbe.equals("")) {
            zzgn.zza(4, this.zzbe);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzbb != null && !this.zzbb.equals("")) {
            zzb += zzgn.zzb(1, this.zzbb);
        }
        if (this.zzbc != null && !this.zzbc.equals("")) {
            zzb += zzgn.zzb(2, this.zzbc);
        }
        if (this.zzbd != null && !this.zzbd.equals("")) {
            zzb += zzgn.zzb(3, this.zzbd);
        }
        return (this.zzbe == null || this.zzbe.equals("")) ? zzb : zzb + zzgn.zzb(4, this.zzbe);
    }
}
