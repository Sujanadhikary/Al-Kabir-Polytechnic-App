package com.google.android.gms.internal.ads;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzay extends zzbfc<zzay> {
    public String zzcx;
    private String zzcy;
    private String zzcz;
    private String zzda;
    private String zzdb;

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    break;
                case 10:
                    this.zzcx = zzbez.readString();
                    continue;
                case 18:
                    this.zzcy = zzbez.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzcz = zzbez.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzda = zzbez.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzdb = zzbez.readString();
                    continue;
                default:
                    if (!zzay.super.zza(zzbez, zzabk)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzcx != null) {
            zzbfa.zzf(1, this.zzcx);
        }
        if (this.zzcy != null) {
            zzbfa.zzf(2, this.zzcy);
        }
        if (this.zzcz != null) {
            zzbfa.zzf(3, this.zzcz);
        }
        if (this.zzda != null) {
            zzbfa.zzf(4, this.zzda);
        }
        if (this.zzdb != null) {
            zzbfa.zzf(5, this.zzdb);
        }
        zzay.super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = zzay.super.zzr();
        if (this.zzcx != null) {
            zzr += zzbfa.zzg(1, this.zzcx);
        }
        if (this.zzcy != null) {
            zzr += zzbfa.zzg(2, this.zzcy);
        }
        if (this.zzcz != null) {
            zzr += zzbfa.zzg(3, this.zzcz);
        }
        if (this.zzda != null) {
            zzr += zzbfa.zzg(4, this.zzda);
        }
        return this.zzdb != null ? zzr + zzbfa.zzg(5, this.zzdb) : zzr;
    }
}
