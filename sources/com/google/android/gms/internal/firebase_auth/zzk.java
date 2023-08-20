package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzk extends zzgp<zzk> {
    private long zzac = 0;
    public String zzad = "";
    private String[] zzaj = zzgy.EMPTY_STRING_ARRAY;
    private String[] zzak = zzgy.EMPTY_STRING_ARRAY;

    public zzk() {
        this.zzyw = -1;
    }

    public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 10:
                    this.zzad = zzgm.readString();
                    continue;
                case 18:
                    int zzb = zzgy.zzb(zzgm, 18);
                    int length = this.zzaj == null ? 0 : this.zzaj.length;
                    String[] strArr = new String[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzaj, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzgm.readString();
                        zzgm.zzbz();
                        length++;
                    }
                    strArr[length] = zzgm.readString();
                    this.zzaj = strArr;
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    int zzb2 = zzgy.zzb(zzgm, 26);
                    int length2 = this.zzak == null ? 0 : this.zzak.length;
                    String[] strArr2 = new String[(zzb2 + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzak, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = zzgm.readString();
                        zzgm.zzbz();
                        length2++;
                    }
                    strArr2[length2] = zzgm.readString();
                    this.zzak = strArr2;
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
        if (this.zzad != null && !this.zzad.equals("")) {
            zzgn.zza(1, this.zzad);
        }
        if (this.zzaj != null && this.zzaj.length > 0) {
            for (String str : this.zzaj) {
                if (str != null) {
                    zzgn.zza(2, str);
                }
            }
        }
        if (this.zzak != null && this.zzak.length > 0) {
            for (String str2 : this.zzak) {
                if (str2 != null) {
                    zzgn.zza(3, str2);
                }
            }
        }
        if (this.zzac != 0) {
            zzgn.zzi(4, this.zzac);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzad != null && !this.zzad.equals("")) {
            zzb += zzgn.zzb(1, this.zzad);
        }
        if (this.zzaj != null && this.zzaj.length > 0) {
            int i = 0;
            int i2 = 0;
            for (String str : this.zzaj) {
                if (str != null) {
                    i2++;
                    i += zzgn.zzam(str);
                }
            }
            zzb = zzb + i + (i2 * 1);
        }
        if (this.zzak != null && this.zzak.length > 0) {
            int i3 = 0;
            int i4 = 0;
            for (String str2 : this.zzak) {
                if (str2 != null) {
                    i4++;
                    i3 += zzgn.zzam(str2);
                }
            }
            zzb = zzb + i3 + (i4 * 1);
        }
        return this.zzac != 0 ? zzb + zzgn.zzd(4, this.zzac) : zzb;
    }
}
