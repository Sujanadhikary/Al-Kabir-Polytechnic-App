package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzhb extends zzgp<zzhb> {
    public String zzag = "";
    private String zzgq = "";
    public String zzjh = "";
    public String zzjj = "";
    private String zzzi = "";

    public zzhb() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzjh = zzgm.readString();
                    continue;
                case 18:
                    this.zzgq = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzag = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzjj = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzzi = zzgm.readString();
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
        if (this.zzjh != null && !this.zzjh.equals("")) {
            zzgn.zza(1, this.zzjh);
        }
        if (this.zzgq != null && !this.zzgq.equals("")) {
            zzgn.zza(2, this.zzgq);
        }
        if (this.zzag != null && !this.zzag.equals("")) {
            zzgn.zza(3, this.zzag);
        }
        if (this.zzjj != null && !this.zzjj.equals("")) {
            zzgn.zza(4, this.zzjj);
        }
        if (this.zzzi != null && !this.zzzi.equals("")) {
            zzgn.zza(5, this.zzzi);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzjh != null && !this.zzjh.equals("")) {
            zzb += zzgn.zzb(1, this.zzjh);
        }
        if (this.zzgq != null && !this.zzgq.equals("")) {
            zzb += zzgn.zzb(2, this.zzgq);
        }
        if (this.zzag != null && !this.zzag.equals("")) {
            zzb += zzgn.zzb(3, this.zzag);
        }
        if (this.zzjj != null && !this.zzjj.equals("")) {
            zzb += zzgn.zzb(4, this.zzjj);
        }
        return (this.zzzi == null || this.zzzi.equals("")) ? zzb : zzb + zzgn.zzb(5, this.zzzi);
    }
}
