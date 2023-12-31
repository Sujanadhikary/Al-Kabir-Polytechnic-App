package com.google.android.gms.internal.ads;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzbd extends zzbfc<zzbd> {
    private Long zzgl = null;
    private Integer zzgm = null;
    private Boolean zzgn = null;
    private int[] zzgo = zzbfl.zzeby;
    private Long zzgp = null;

    public zzbd() {
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    break;
                case 8:
                    this.zzgl = Long.valueOf(zzbez.zzacd());
                    continue;
                case 16:
                    this.zzgm = Integer.valueOf(zzbez.zzacc());
                    continue;
                case MotionEventCompat.AXIS_DISTANCE:
                    this.zzgn = Boolean.valueOf(zzbez.zzabq());
                    continue;
                case 32:
                    int zzb = zzbfl.zzb(zzbez, 32);
                    int length = this.zzgo == null ? 0 : this.zzgo.length;
                    int[] iArr = new int[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzgo, 0, iArr, 0, length);
                    }
                    while (length < iArr.length - 1) {
                        iArr[length] = zzbez.zzacc();
                        zzbez.zzabk();
                        length++;
                    }
                    iArr[length] = zzbez.zzacc();
                    this.zzgo = iArr;
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    int zzbr = zzbez.zzbr(zzbez.zzacc());
                    int position = zzbez.getPosition();
                    int i = 0;
                    while (zzbez.zzagn() > 0) {
                        zzbez.zzacc();
                        i++;
                    }
                    zzbez.zzdc(position);
                    int length2 = this.zzgo == null ? 0 : this.zzgo.length;
                    int[] iArr2 = new int[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzgo, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length) {
                        iArr2[length2] = zzbez.zzacc();
                        length2++;
                    }
                    this.zzgo = iArr2;
                    zzbez.zzbs(zzbr);
                    continue;
                case MotionEventCompat.AXIS_GENERIC_9:
                    this.zzgp = Long.valueOf(zzbez.zzacd());
                    continue;
                default:
                    if (!zzbd.super.zza(zzbez, zzabk)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzgl != null) {
            zzbfa.zzi(1, this.zzgl.longValue());
        }
        if (this.zzgm != null) {
            zzbfa.zzm(2, this.zzgm.intValue());
        }
        if (this.zzgn != null) {
            zzbfa.zzf(3, this.zzgn.booleanValue());
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            for (int zzm : this.zzgo) {
                zzbfa.zzm(4, zzm);
            }
        }
        if (this.zzgp != null) {
            zzbfa.zza(5, this.zzgp.longValue());
        }
        zzbd.super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = zzbd.super.zzr();
        if (this.zzgl != null) {
            zzr += zzbfa.zzd(1, this.zzgl.longValue());
        }
        if (this.zzgm != null) {
            zzr += zzbfa.zzq(2, this.zzgm.intValue());
        }
        if (this.zzgn != null) {
            this.zzgn.booleanValue();
            zzr += zzbfa.zzcd(3) + 1;
        }
        if (this.zzgo != null && this.zzgo.length > 0) {
            int i = 0;
            for (int zzce : this.zzgo) {
                i += zzbfa.zzce(zzce);
            }
            zzr = zzr + i + (this.zzgo.length * 1);
        }
        return this.zzgp != null ? zzr + zzbfa.zze(5, this.zzgp.longValue()) : zzr;
    }
}
