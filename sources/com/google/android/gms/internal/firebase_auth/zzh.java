package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzh extends zzgp<zzh> {
    public String zzg = "";
    public String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private String zzq = "";
    private String zzr = "";
    private String zzs = "";
    private zzf[] zzt = zzf.zza();

    public zzh() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzg = zzgm.readString();
                    continue;
                case 18:
                    this.zzh = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzi = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzj = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzk = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzl = zzgm.readString();
                    continue;
                case 58:
                    this.zzm = zzgm.readString();
                    continue;
                case 66:
                    this.zzn = zzgm.readString();
                    continue;
                case 74:
                    this.zzo = zzgm.readString();
                    continue;
                case 82:
                    this.zzp = zzgm.readString();
                    continue;
                case 90:
                    this.zzq = zzgm.readString();
                    continue;
                case 98:
                    this.zzr = zzgm.readString();
                    continue;
                case 106:
                    this.zzs = zzgm.readString();
                    continue;
                case 114:
                    int zzb = zzgy.zzb(zzgm, 114);
                    int length = this.zzt == null ? 0 : this.zzt.length;
                    zzf[] zzfArr = new zzf[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzt, 0, zzfArr, 0, length);
                    }
                    while (length < zzfArr.length - 1) {
                        zzfArr[length] = new zzf();
                        zzgm.zzb(zzfArr[length]);
                        zzgm.zzbz();
                        length++;
                    }
                    zzfArr[length] = new zzf();
                    zzgm.zzb(zzfArr[length]);
                    this.zzt = zzfArr;
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
        if (this.zzg != null && !this.zzg.equals("")) {
            zzgn.zza(1, this.zzg);
        }
        if (this.zzh != null && !this.zzh.equals("")) {
            zzgn.zza(2, this.zzh);
        }
        if (this.zzi != null && !this.zzi.equals("")) {
            zzgn.zza(3, this.zzi);
        }
        if (this.zzj != null && !this.zzj.equals("")) {
            zzgn.zza(4, this.zzj);
        }
        if (this.zzk != null && !this.zzk.equals("")) {
            zzgn.zza(5, this.zzk);
        }
        if (this.zzl != null && !this.zzl.equals("")) {
            zzgn.zza(6, this.zzl);
        }
        if (this.zzm != null && !this.zzm.equals("")) {
            zzgn.zza(7, this.zzm);
        }
        if (this.zzn != null && !this.zzn.equals("")) {
            zzgn.zza(8, this.zzn);
        }
        if (this.zzo != null && !this.zzo.equals("")) {
            zzgn.zza(9, this.zzo);
        }
        if (this.zzp != null && !this.zzp.equals("")) {
            zzgn.zza(10, this.zzp);
        }
        if (this.zzq != null && !this.zzq.equals("")) {
            zzgn.zza(11, this.zzq);
        }
        if (this.zzr != null && !this.zzr.equals("")) {
            zzgn.zza(12, this.zzr);
        }
        if (this.zzs != null && !this.zzs.equals("")) {
            zzgn.zza(13, this.zzs);
        }
        if (this.zzt != null && this.zzt.length > 0) {
            for (zzf zzf : this.zzt) {
                if (zzf != null) {
                    zzgn.zza(14, (zzgv) zzf);
                }
            }
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzg != null && !this.zzg.equals("")) {
            zzb += zzgn.zzb(1, this.zzg);
        }
        if (this.zzh != null && !this.zzh.equals("")) {
            zzb += zzgn.zzb(2, this.zzh);
        }
        if (this.zzi != null && !this.zzi.equals("")) {
            zzb += zzgn.zzb(3, this.zzi);
        }
        if (this.zzj != null && !this.zzj.equals("")) {
            zzb += zzgn.zzb(4, this.zzj);
        }
        if (this.zzk != null && !this.zzk.equals("")) {
            zzb += zzgn.zzb(5, this.zzk);
        }
        if (this.zzl != null && !this.zzl.equals("")) {
            zzb += zzgn.zzb(6, this.zzl);
        }
        if (this.zzm != null && !this.zzm.equals("")) {
            zzb += zzgn.zzb(7, this.zzm);
        }
        if (this.zzn != null && !this.zzn.equals("")) {
            zzb += zzgn.zzb(8, this.zzn);
        }
        if (this.zzo != null && !this.zzo.equals("")) {
            zzb += zzgn.zzb(9, this.zzo);
        }
        if (this.zzp != null && !this.zzp.equals("")) {
            zzb += zzgn.zzb(10, this.zzp);
        }
        if (this.zzq != null && !this.zzq.equals("")) {
            zzb += zzgn.zzb(11, this.zzq);
        }
        if (this.zzr != null && !this.zzr.equals("")) {
            zzb += zzgn.zzb(12, this.zzr);
        }
        if (this.zzs != null && !this.zzs.equals("")) {
            zzb += zzgn.zzb(13, this.zzs);
        }
        if (this.zzt == null || this.zzt.length <= 0) {
            return zzb;
        }
        int i = zzb;
        for (zzf zzf : this.zzt) {
            if (zzf != null) {
                i += zzgn.zzb(14, (zzgv) zzf);
            }
        }
        return i;
    }
}
