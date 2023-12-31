package com.google.android.gms.internal.ads;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzaw extends zzbfc<zzaw> {
    private String stackTrace = null;
    public String zzco = null;
    public Long zzcp = null;
    private String zzcq = null;
    private String zzcr = null;
    private Long zzcs = null;
    private Long zzct = null;
    private String zzcu = null;
    private Long zzcv = null;
    private String zzcw = null;

    public zzaw() {
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    break;
                case 10:
                    this.zzco = zzbez.readString();
                    continue;
                case 16:
                    this.zzcp = Long.valueOf(zzbez.zzacd());
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.stackTrace = zzbez.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzcq = zzbez.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzcr = zzbez.readString();
                    continue;
                case 48:
                    this.zzcs = Long.valueOf(zzbez.zzacd());
                    continue;
                case 56:
                    this.zzct = Long.valueOf(zzbez.zzacd());
                    continue;
                case 66:
                    this.zzcu = zzbez.readString();
                    continue;
                case 72:
                    this.zzcv = Long.valueOf(zzbez.zzacd());
                    continue;
                case 82:
                    this.zzcw = zzbez.readString();
                    continue;
                default:
                    if (!zzaw.super.zza(zzbez, zzabk)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.zzco != null) {
            zzbfa.zzf(1, this.zzco);
        }
        if (this.zzcp != null) {
            zzbfa.zzi(2, this.zzcp.longValue());
        }
        if (this.stackTrace != null) {
            zzbfa.zzf(3, this.stackTrace);
        }
        if (this.zzcq != null) {
            zzbfa.zzf(4, this.zzcq);
        }
        if (this.zzcr != null) {
            zzbfa.zzf(5, this.zzcr);
        }
        if (this.zzcs != null) {
            zzbfa.zzi(6, this.zzcs.longValue());
        }
        if (this.zzct != null) {
            zzbfa.zzi(7, this.zzct.longValue());
        }
        if (this.zzcu != null) {
            zzbfa.zzf(8, this.zzcu);
        }
        if (this.zzcv != null) {
            zzbfa.zzi(9, this.zzcv.longValue());
        }
        if (this.zzcw != null) {
            zzbfa.zzf(10, this.zzcw);
        }
        zzaw.super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = zzaw.super.zzr();
        if (this.zzco != null) {
            zzr += zzbfa.zzg(1, this.zzco);
        }
        if (this.zzcp != null) {
            zzr += zzbfa.zzd(2, this.zzcp.longValue());
        }
        if (this.stackTrace != null) {
            zzr += zzbfa.zzg(3, this.stackTrace);
        }
        if (this.zzcq != null) {
            zzr += zzbfa.zzg(4, this.zzcq);
        }
        if (this.zzcr != null) {
            zzr += zzbfa.zzg(5, this.zzcr);
        }
        if (this.zzcs != null) {
            zzr += zzbfa.zzd(6, this.zzcs.longValue());
        }
        if (this.zzct != null) {
            zzr += zzbfa.zzd(7, this.zzct.longValue());
        }
        if (this.zzcu != null) {
            zzr += zzbfa.zzg(8, this.zzcu);
        }
        if (this.zzcv != null) {
            zzr += zzbfa.zzd(9, this.zzcv.longValue());
        }
        return this.zzcw != null ? zzr + zzbfa.zzg(10, this.zzcw) : zzr;
    }
}
