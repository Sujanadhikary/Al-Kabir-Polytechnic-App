package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzt extends zzgp<zzt> {
    private static volatile zzt[] zzdh;
    public String zzaf = "";
    public String zzbb = "";
    public String zzbf = "";
    public String zzbp = "";
    public String zzce = "";
    private String zzdc = "";
    private String zzdi = "";
    public String zzj = "";

    public zzt() {
        this.zzyw = -1;
    }

    public static zzt[] zzc() {
        if (zzdh == null) {
            synchronized (zzgt.zzyv) {
                if (zzdh == null) {
                    zzdh = new zzt[0];
                }
            }
        }
        return zzdh;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzj = zzgm.readString();
                    continue;
                case 18:
                    this.zzbf = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzbp = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzce = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzaf = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzdi = zzgm.readString();
                    continue;
                case 58:
                    this.zzdc = zzgm.readString();
                    continue;
                case 74:
                    this.zzbb = zzgm.readString();
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
        if (this.zzj != null && !this.zzj.equals("")) {
            zzgn.zza(1, this.zzj);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzgn.zza(2, this.zzbf);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzgn.zza(3, this.zzbp);
        }
        if (this.zzce != null && !this.zzce.equals("")) {
            zzgn.zza(4, this.zzce);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(5, this.zzaf);
        }
        if (this.zzdi != null && !this.zzdi.equals("")) {
            zzgn.zza(6, this.zzdi);
        }
        if (this.zzdc != null && !this.zzdc.equals("")) {
            zzgn.zza(7, this.zzdc);
        }
        if (this.zzbb != null && !this.zzbb.equals("")) {
            zzgn.zza(9, this.zzbb);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzj != null && !this.zzj.equals("")) {
            zzb += zzgn.zzb(1, this.zzj);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzb += zzgn.zzb(2, this.zzbf);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzb += zzgn.zzb(3, this.zzbp);
        }
        if (this.zzce != null && !this.zzce.equals("")) {
            zzb += zzgn.zzb(4, this.zzce);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(5, this.zzaf);
        }
        if (this.zzdi != null && !this.zzdi.equals("")) {
            zzb += zzgn.zzb(6, this.zzdi);
        }
        if (this.zzdc != null && !this.zzdc.equals("")) {
            zzb += zzgn.zzb(7, this.zzdc);
        }
        return (this.zzbb == null || this.zzbb.equals("")) ? zzb : zzb + zzgn.zzb(9, this.zzbb);
    }
}
