package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzo extends zzgp<zzo> {
    private String zzab = "";
    private long zzac = 0;
    public String zzad = "";
    public String zzae = "";
    public String zzaf = "";
    public String zzbf = "";
    public String zzbg = "";
    private String[] zzbh = zzgy.EMPTY_STRING_ARRAY;
    private boolean zzbi = false;
    private boolean zzbj = false;
    private String zzbk = "";
    private String zzbl = "";
    private zzfo zzbm;
    private boolean zzbn = false;
    private String zzbo = "";
    public String zzbp = "";
    public int[] zzbq = zzgy.zzzb;
    public boolean zzbr = false;
    public String[] zzbs = zzgy.EMPTY_STRING_ARRAY;
    private long zzbt = 0;
    private long zzbu = 0;

    public zzo() {
        this.zzyw = -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzo zza(zzgm zzgm) throws IOException {
        while (true) {
            int zzbz = zzgm.zzbz();
            switch (zzbz) {
                case 0:
                    break;
                case 18:
                    this.zzad = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_SCROLL:
                    this.zzab = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3:
                    this.zzbf = zzgm.readString();
                    continue;
                case MotionEventCompat.AXIS_GENERIC_11:
                    this.zzaf = zzgm.readString();
                    continue;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    this.zzbg = zzgm.readString();
                    continue;
                case 58:
                    int zzb = zzgy.zzb(zzgm, 58);
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
                case 66:
                    this.zzae = zzgm.readString();
                    continue;
                case 72:
                    this.zzbi = zzgm.zzcf();
                    continue;
                case 80:
                    this.zzbj = zzgm.zzcf();
                    continue;
                case 90:
                    this.zzbk = zzgm.readString();
                    continue;
                case 98:
                    this.zzbl = zzgm.readString();
                    continue;
                case 106:
                    this.zzbm = (zzfo) zzgm.zza(zzfo.zzgo());
                    continue;
                case 112:
                    this.zzbn = zzgm.zzcf();
                    continue;
                case 122:
                    this.zzbo = zzgm.readString();
                    continue;
                case 128:
                    this.zzac = zzgm.zzcs();
                    continue;
                case 138:
                    this.zzbp = zzgm.readString();
                    continue;
                case 144:
                    int zzb2 = zzgy.zzb(zzgm, 144);
                    int[] iArr = new int[zzb2];
                    int i = 0;
                    for (int i2 = 0; i2 < zzb2; i2++) {
                        if (i2 != 0) {
                            zzgm.zzbz();
                        }
                        int position = zzgm.getPosition();
                        try {
                            iArr[i] = zze.zza(zzgm.zzcr());
                            i++;
                        } catch (IllegalArgumentException e) {
                            zzgm.zzay(position);
                            zza(zzgm, zzbz);
                        }
                    }
                    if (i != 0) {
                        int length2 = this.zzbq == null ? 0 : this.zzbq.length;
                        if (length2 != 0 || i != iArr.length) {
                            int[] iArr2 = new int[(length2 + i)];
                            if (length2 != 0) {
                                System.arraycopy(this.zzbq, 0, iArr2, 0, length2);
                            }
                            System.arraycopy(iArr, 0, iArr2, length2, i);
                            this.zzbq = iArr2;
                            break;
                        } else {
                            this.zzbq = iArr;
                            break;
                        }
                    } else {
                        continue;
                    }
                case 146:
                    int zzo = zzgm.zzo(zzgm.zzcr());
                    int position2 = zzgm.getPosition();
                    int i3 = 0;
                    while (zzgm.zzhd() > 0) {
                        try {
                            zze.zza(zzgm.zzcr());
                            i3++;
                        } catch (IllegalArgumentException e2) {
                        }
                    }
                    if (i3 != 0) {
                        zzgm.zzay(position2);
                        int length3 = this.zzbq == null ? 0 : this.zzbq.length;
                        int[] iArr3 = new int[(i3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.zzbq, 0, iArr3, 0, length3);
                        }
                        while (zzgm.zzhd() > 0) {
                            int position3 = zzgm.getPosition();
                            try {
                                iArr3[length3] = zze.zza(zzgm.zzcr());
                                length3++;
                            } catch (IllegalArgumentException e3) {
                                zzgm.zzay(position3);
                                zza(zzgm, 144);
                            }
                        }
                        this.zzbq = iArr3;
                    }
                    zzgm.zzp(zzo);
                    continue;
                case 152:
                    this.zzbr = zzgm.zzcf();
                    continue;
                case 162:
                    int zzb3 = zzgy.zzb(zzgm, 162);
                    int length4 = this.zzbs == null ? 0 : this.zzbs.length;
                    String[] strArr2 = new String[(zzb3 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbs, 0, strArr2, 0, length4);
                    }
                    while (length4 < strArr2.length - 1) {
                        strArr2[length4] = zzgm.readString();
                        zzgm.zzbz();
                        length4++;
                    }
                    strArr2[length4] = zzgm.readString();
                    this.zzbs = strArr2;
                    continue;
                case 168:
                    this.zzbt = zzgm.zzcs();
                    continue;
                case 176:
                    this.zzbu = zzgm.zzcs();
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
            zzgn.zza(2, this.zzad);
        }
        if (this.zzab != null && !this.zzab.equals("")) {
            zzgn.zza(3, this.zzab);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzgn.zza(4, this.zzbf);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzgn.zza(5, this.zzaf);
        }
        if (this.zzbg != null && !this.zzbg.equals("")) {
            zzgn.zza(6, this.zzbg);
        }
        if (this.zzbh != null && this.zzbh.length > 0) {
            for (String str : this.zzbh) {
                if (str != null) {
                    zzgn.zza(7, str);
                }
            }
        }
        if (this.zzae != null && !this.zzae.equals("")) {
            zzgn.zza(8, this.zzae);
        }
        if (this.zzbi) {
            zzgn.zzb(9, this.zzbi);
        }
        if (this.zzbj) {
            zzgn.zzb(10, this.zzbj);
        }
        if (this.zzbk != null && !this.zzbk.equals("")) {
            zzgn.zza(11, this.zzbk);
        }
        if (this.zzbl != null && !this.zzbl.equals("")) {
            zzgn.zza(12, this.zzbl);
        }
        if (this.zzbm != null) {
            zzgn.zze(13, this.zzbm);
        }
        if (this.zzbn) {
            zzgn.zzb(14, this.zzbn);
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzgn.zza(15, this.zzbo);
        }
        if (this.zzac != 0) {
            zzgn.zzi(16, this.zzac);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzgn.zza(17, this.zzbp);
        }
        if (this.zzbq != null && this.zzbq.length > 0) {
            for (int zzc : this.zzbq) {
                zzgn.zzc(18, zzc);
            }
        }
        if (this.zzbr) {
            zzgn.zzb(19, this.zzbr);
        }
        if (this.zzbs != null && this.zzbs.length > 0) {
            for (String str2 : this.zzbs) {
                if (str2 != null) {
                    zzgn.zza(20, str2);
                }
            }
        }
        if (this.zzbt != 0) {
            zzgn.zzi(21, this.zzbt);
        }
        if (this.zzbu != 0) {
            zzgn.zzi(22, this.zzbu);
        }
        super.zza(zzgn);
    }

    /* access modifiers changed from: protected */
    public final int zzb() {
        int zzb = super.zzb();
        if (this.zzad != null && !this.zzad.equals("")) {
            zzb += zzgn.zzb(2, this.zzad);
        }
        if (this.zzab != null && !this.zzab.equals("")) {
            zzb += zzgn.zzb(3, this.zzab);
        }
        if (this.zzbf != null && !this.zzbf.equals("")) {
            zzb += zzgn.zzb(4, this.zzbf);
        }
        if (this.zzaf != null && !this.zzaf.equals("")) {
            zzb += zzgn.zzb(5, this.zzaf);
        }
        if (this.zzbg != null && !this.zzbg.equals("")) {
            zzb += zzgn.zzb(6, this.zzbg);
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
        if (this.zzae != null && !this.zzae.equals("")) {
            zzb += zzgn.zzb(8, this.zzae);
        }
        if (this.zzbi) {
            zzb += zzgn.zzz(9) + 1;
        }
        if (this.zzbj) {
            zzb += zzgn.zzz(10) + 1;
        }
        if (this.zzbk != null && !this.zzbk.equals("")) {
            zzb += zzgn.zzb(11, this.zzbk);
        }
        if (this.zzbl != null && !this.zzbl.equals("")) {
            zzb += zzgn.zzb(12, this.zzbl);
        }
        if (this.zzbm != null) {
            zzb += zzci.zzc(13, (zzeh) this.zzbm);
        }
        if (this.zzbn) {
            zzb += zzgn.zzz(14) + 1;
        }
        if (this.zzbo != null && !this.zzbo.equals("")) {
            zzb += zzgn.zzb(15, this.zzbo);
        }
        if (this.zzac != 0) {
            zzb += zzgn.zzd(16, this.zzac);
        }
        if (this.zzbp != null && !this.zzbp.equals("")) {
            zzb += zzgn.zzb(17, this.zzbp);
        }
        if (this.zzbq != null && this.zzbq.length > 0) {
            int i3 = 0;
            for (int zzaa : this.zzbq) {
                i3 += zzgn.zzaa(zzaa);
            }
            zzb = zzb + i3 + (this.zzbq.length * 2);
        }
        if (this.zzbr) {
            zzb += zzgn.zzz(19) + 1;
        }
        if (this.zzbs != null && this.zzbs.length > 0) {
            int i4 = 0;
            int i5 = 0;
            for (String str2 : this.zzbs) {
                if (str2 != null) {
                    i5++;
                    i4 += zzgn.zzam(str2);
                }
            }
            zzb = zzb + i4 + (i5 * 2);
        }
        if (this.zzbt != 0) {
            zzb += zzgn.zzd(21, this.zzbt);
        }
        return this.zzbu != 0 ? zzb + zzgn.zzd(22, this.zzbu) : zzb;
    }
}
