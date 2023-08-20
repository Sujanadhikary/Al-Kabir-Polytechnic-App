package com.google.android.gms.internal.ads;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzbe extends zzbfc<zzbe> {
    public byte[] data = null;
    public byte[] zzgq = null;
    public byte[] zzgr = null;
    public byte[] zzgs = null;

    public zzbe() {
        this.zzebt = -1;
    }

    public final /* synthetic */ zzbfi zza(zzbez zzbez) throws IOException {
        while (true) {
            int zzabk = zzbez.zzabk();
            switch (zzabk) {
                case 0:
                    break;
                case 10:
                    this.data = zzbez.readBytes();
                    continue;
                case 18:
                    this.zzgq = zzbez.readBytes();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzgr = zzbez.readBytes();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzgs = zzbez.readBytes();
                    continue;
                default:
                    if (!zzbe.super.zza(zzbez, zzabk)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }

    public final void zza(zzbfa zzbfa) throws IOException {
        if (this.data != null) {
            zzbfa.zza(1, this.data);
        }
        if (this.zzgq != null) {
            zzbfa.zza(2, this.zzgq);
        }
        if (this.zzgr != null) {
            zzbfa.zza(3, this.zzgr);
        }
        if (this.zzgs != null) {
            zzbfa.zza(4, this.zzgs);
        }
        zzbe.super.zza(zzbfa);
    }

    /* access modifiers changed from: protected */
    public final int zzr() {
        int zzr = zzbe.super.zzr();
        if (this.data != null) {
            zzr += zzbfa.zzb(1, this.data);
        }
        if (this.zzgq != null) {
            zzr += zzbfa.zzb(2, this.zzgq);
        }
        if (this.zzgr != null) {
            zzr += zzbfa.zzb(3, this.zzgr);
        }
        return this.zzgs != null ? zzr + zzbfa.zzb(4, this.zzgs) : zzr;
    }
}
