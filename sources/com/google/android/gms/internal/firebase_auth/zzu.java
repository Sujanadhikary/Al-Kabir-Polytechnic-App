package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;
import java.util.Arrays;

public final class zzu extends zzgp<zzu> {
    private static volatile zzu[] zzdj;
    private int version = 0;
    public String zzab = "";
    public String zzaf = "";
    public String zzbb = "";
    public String zzbf = "";
    private String[] zzbh = zzgy.EMPTY_STRING_ARRAY;
    public boolean zzbi = false;
    public String zzbp = "";
    public long zzbt = 0;
    public long zzbu = 0;
    public zzt[] zzbv = zzt.zzc();
    private boolean zzbx = false;
    private String zzcj = "";
    private String zzck = "";
    private String zzcl = "";
    private String zzdc = "";
    private byte[] zzdk = zzgy.zzzh;
    private byte[] zzdl = zzgy.zzzh;
    private long zzdm = 0;
    private long zzdn = 0;
    private boolean zzdo = false;
    public String zzdp = "";

    public zzu() {
        this.zzyw = -1;
    }

    public static zzu[] zzd() {
        if (zzdj == null) {
            synchronized (zzgt.zzyv) {
                if (zzdj == null) {
                    zzdj = new zzu[0];
                }
            }
        }
        return zzdj;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzab = zzgm.readString();
                    continue;
                case 18:
                    this.zzaf = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzbf = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    int zzb = zzgy.zzb(zzgm, 34);
                    int length = this.zzbh == null ? 0 : this.zzbh.length;
                    String[] strArr = new String[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzbh, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzgm.readString();
                        zzgm.zzbz();
                        length++;
                    }
                    strArr[length] = zzgm.readString();
                    this.zzbh = strArr;
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzcj = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzbp = zzgm.readString();
                    continue;
                case 58:
                    this.zzck = zzgm.readString();
                    continue;
                case 66:
                    this.zzcl = zzgm.readString();
                    continue;
                case 74:
                    this.zzdk = zzgm.readBytes();
                    continue;
                case 82:
                    this.zzdl = zzgm.readBytes();
                    continue;
                case 88:
                    this.version = zzgm.zzcr();
                    continue;
                case 96:
                    this.zzbi = zzgm.zzcf();
                    continue;
                case 104:
                    this.zzdm = zzgm.zzcs();
                    continue;
                case 114:
                    int zzb2 = zzgy.zzb(zzgm, 114);
                    int length2 = this.zzbv == null ? 0 : this.zzbv.length;
                    zzt[] zztArr = new zzt[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbv, 0, zztArr, 0, length2);
                    }
                    while (length2 < zztArr.length - 1) {
                        zztArr[length2] = new zzt();
                        zzgm.zzb(zztArr[length2]);
                        zzgm.zzbz();
                        length2++;
                    }
                    zztArr[length2] = new zzt();
                    zzgm.zzb(zztArr[length2]);
                    this.zzbv = zztArr;
                    continue;
                case 120:
                    this.zzdn = zzgm.zzcs();
                    continue;
                case 128:
                    this.zzbx = zzgm.zzcf();
                    continue;
                case 136:
                    this.zzbt = zzgm.zzcs();
                    continue;
                case 144:
                    this.zzbu = zzgm.zzcs();
                    continue;
                case 154:
                    this.zzdc = zzgm.readString();
                    continue;
                case 160:
                    this.zzdo = zzgm.zzcf();
                    continue;
                case 170:
                    this.zzdp = zzgm.readString();
                    continue;
                case 178:
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
        if (this.zzab != null && !this.zzab.equals("")) {
            zzgn.zza(1, this.zzab);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(2, this.zzaf);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzgn.zza(3, this.zzbf);
        }
        if (this.zzbh != null && this.zzbh.length > 0) {
            for (String str : this.zzbh) {
                if (str != null) {
                    zzgn.zza(4, str);
                }
            }
        }
        if (this.zzcj != null && !this.zzcj.equals("")) {
            zzgn.zza(5, this.zzcj);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzgn.zza(6, this.zzbp);
        }
        if (this.zzck != null && !this.zzck.equals("")) {
            zzgn.zza(7, this.zzck);
        }
        if (this.zzcl != null && !this.zzcl.equals("")) {
            zzgn.zza(8, this.zzcl);
        }
        if (!Arrays.equals(this.zzdk, zzgy.zzzh)) {
            zzgn.zza(9, this.zzdk);
        }
        if (!Arrays.equals(this.zzdl, zzgy.zzzh)) {
            zzgn.zza(10, this.zzdl);
        }
        if (this.version != 0) {
            zzgn.zzc(11, this.version);
        }
        if (this.zzbi) {
            zzgn.zzb(12, this.zzbi);
        }
        if (this.zzdm != 0) {
            zzgn.zzi(13, this.zzdm);
        }
        if (this.zzbv != null && this.zzbv.length > 0) {
            for (zzt zzt : this.zzbv) {
                if (zzt != null) {
                    zzgn.zza(14, (zzgv) zzt);
                }
            }
        }
        if (this.zzdn != 0) {
            zzgn.zzi(15, this.zzdn);
        }
        if (this.zzbx) {
            zzgn.zzb(16, this.zzbx);
        }
        if (this.zzbt != 0) {
            zzgn.zzi(17, this.zzbt);
        }
        if (this.zzbu != 0) {
            zzgn.zzi(18, this.zzbu);
        }
        if (this.zzdc != null && !this.zzdc.equals("")) {
            zzgn.zza(19, this.zzdc);
        }
        if (this.zzdo) {
            zzgn.zzb(20, this.zzdo);
        }
        if (this.zzdp != null && !this.zzdp.equals("")) {
            zzgn.zza(21, this.zzdp);
        }
        if (this.zzbb != null && !this.zzbb.equals("")) {
            zzgn.zza(22, this.zzbb);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzab != null && !this.zzab.equals("")) {
            zzb += zzgn.zzb(1, this.zzab);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(2, this.zzaf);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzb += zzgn.zzb(3, this.zzbf);
        }
        if (this.zzbh != null && this.zzbh.length > 0) {
            int i = 0;
            int i2 = 0;
            for (String str : this.zzbh) {
                if (str != null) {
                    i2++;
                    i += zzgn.zzam(str);
                }
            }
            zzb = zzb + i + (i2 * 1);
        }
        if (this.zzcj != null && !this.zzcj.equals("")) {
            zzb += zzgn.zzb(5, this.zzcj);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzb += zzgn.zzb(6, this.zzbp);
        }
        if (this.zzck != null && !this.zzck.equals("")) {
            zzb += zzgn.zzb(7, this.zzck);
        }
        if (this.zzcl != null && !this.zzcl.equals("")) {
            zzb += zzgn.zzb(8, this.zzcl);
        }
        if (!Arrays.equals(this.zzdk, zzgy.zzzh)) {
            zzb += zzgn.zzb(9, this.zzdk);
        }
        if (!Arrays.equals(this.zzdl, zzgy.zzzh)) {
            zzb += zzgn.zzb(10, this.zzdl);
        }
        if (this.version != 0) {
            zzb += zzgn.zzg(11, this.version);
        }
        if (this.zzbi) {
            zzb += zzgn.zzz(12) + 1;
        }
        if (this.zzdm != 0) {
            zzb += zzgn.zzd(13, this.zzdm);
        }
        if (this.zzbv != null && this.zzbv.length > 0) {
            for (zzt zzt : this.zzbv) {
                if (zzt != null) {
                    zzb += zzgn.zzb(14, (zzgv) zzt);
                }
            }
        }
        if (this.zzdn != 0) {
            zzb += zzgn.zzd(15, this.zzdn);
        }
        if (this.zzbx) {
            zzb += zzgn.zzz(16) + 1;
        }
        if (this.zzbt != 0) {
            zzb += zzgn.zzd(17, this.zzbt);
        }
        if (this.zzbu != 0) {
            zzb += zzgn.zzd(18, this.zzbu);
        }
        if (this.zzdc != null && !this.zzdc.equals("")) {
            zzb += zzgn.zzb(19, this.zzdc);
        }
        if (this.zzdo) {
            zzb += zzgn.zzz(20) + 1;
        }
        if (this.zzdp != null && !this.zzdp.equals("")) {
            zzb += zzgn.zzb(21, this.zzdp);
        }
        return (this.zzbb == null || this.zzbb.equals("")) ? zzb : zzb + zzgn.zzb(22, this.zzbb);
    }
}
