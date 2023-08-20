package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzr extends zzgp<zzr> {
    private long zzac = 0;
    private String zzbo = "";
    public boolean zzbr = false;
    public String zzdf = "";

    public zzr() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzdf = zzgm.readString();
                    continue;
                case 18:
                    this.zzbo = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_DISTANCE:
                    this.zzbr = zzgm.zzcf();
                    continue;
                case 32:
                    this.zzac = zzgm.zzcs();
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
        if (this.zzdf != null && !this.zzdf.equals("")) {
            zzgn.zza(1, this.zzdf);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzgn.zza(2, this.zzbo);
        }
        if (this.zzbr) {
            zzgn.zzb(3, this.zzbr);
        }
        if (this.zzac != 0) {
            zzgn.zzi(4, this.zzac);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzdf != null && !this.zzdf.equals("")) {
            zzb += zzgn.zzb(1, this.zzdf);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzb += zzgn.zzb(2, this.zzbo);
        }
        if (this.zzbr) {
            zzb += zzgn.zzz(3) + 1;
        }
        return this.zzac != 0 ? zzb + zzgn.zzd(4, this.zzac) : zzb;
    }
}
