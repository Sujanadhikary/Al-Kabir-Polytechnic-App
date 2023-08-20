package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import java.io.IOException;

public final class zzg {

    public static final class zza extends zzgp<zza> {
        public String[] zzaa = zzgy.EMPTY_STRING_ARRAY;
        public String zzj = "";
        private String zzr = "";
        private String zzu = "";
        public String zzv = "";
        public String[] zzw = zzgy.EMPTY_STRING_ARRAY;
        public boolean zzx = false;
        public boolean zzy = false;
        private boolean zzz = false;

        public zza() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzv = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        int zzb = zzgy.zzb(zzgm, 26);
                        int length = this.zzw == null ? 0 : this.zzw.length;
                        String[] strArr = new String[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzw, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzgm.readString();
                            zzgm.zzbz();
                            length++;
                        }
                        strArr[length] = zzgm.readString();
                        this.zzw = strArr;
                        continue;
                    case 32:
                        this.zzx = zzgm.zzcf();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        this.zzj = zzgm.readString();
                        continue;
                    case 48:
                        this.zzy = zzgm.zzcf();
                        continue;
                    case 56:
                        this.zzz = zzgm.zzcf();
                        continue;
                    case 66:
                        this.zzr = zzgm.readString();
                        continue;
                    case 74:
                        int zzb2 = zzgy.zzb(zzgm, 74);
                        int length2 = this.zzaa == null ? 0 : this.zzaa.length;
                        String[] strArr2 = new String[(zzb2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzaa, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzgm.readString();
                            zzgm.zzbz();
                            length2++;
                        }
                        strArr2[length2] = zzgm.readString();
                        this.zzaa = strArr2;
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
            zzgn.zza(1, this.zzu);
            if (this.zzv != null && !this.zzv.equals("")) {
                zzgn.zza(2, this.zzv);
            }
            if (this.zzw != null && this.zzw.length > 0) {
                for (String str : this.zzw) {
                    if (str != null) {
                        zzgn.zza(3, str);
                    }
                }
            }
            if (this.zzx) {
                zzgn.zzb(4, this.zzx);
            }
            if (this.zzj != null && !this.zzj.equals("")) {
                zzgn.zza(5, this.zzj);
            }
            if (this.zzy) {
                zzgn.zzb(6, this.zzy);
            }
            if (this.zzz) {
                zzgn.zzb(7, this.zzz);
            }
            if (this.zzr != null && !this.zzr.equals("")) {
                zzgn.zza(8, this.zzr);
            }
            if (this.zzaa != null && this.zzaa.length > 0) {
                for (String str2 : this.zzaa) {
                    if (str2 != null) {
                        zzgn.zza(9, str2);
                    }
                }
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzv != null && !this.zzv.equals("")) {
                zzb += zzgn.zzb(2, this.zzv);
            }
            if (this.zzw != null && this.zzw.length > 0) {
                int i = 0;
                int i2 = 0;
                for (String str : this.zzw) {
                    if (str != null) {
                        i2++;
                        i += zzgn.zzam(str);
                    }
                }
                zzb = zzb + i + (i2 * 1);
            }
            if (this.zzx) {
                zzb += zzgn.zzz(4) + 1;
            }
            if (this.zzj != null && !this.zzj.equals("")) {
                zzb += zzgn.zzb(5, this.zzj);
            }
            if (this.zzy) {
                zzb += zzgn.zzz(6) + 1;
            }
            if (this.zzz) {
                zzb += zzgn.zzz(7) + 1;
            }
            if (this.zzr != null && !this.zzr.equals("")) {
                zzb += zzgn.zzb(8, this.zzr);
            }
            if (this.zzaa == null || this.zzaa.length <= 0) {
                return zzb;
            }
            int i3 = 0;
            int i4 = 0;
            for (String str2 : this.zzaa) {
                if (str2 != null) {
                    i4++;
                    i3 += zzgn.zzam(str2);
                }
            }
            return zzb + i3 + (i4 * 1);
        }
    }

    public static final class zzb extends zzgp<zzb> {
        public String zzab = "";
        public String zzad = "";
        public String zzaf = "";
        public String zzag = "";
        public long zzah = 0;
        public boolean zzai = false;
        private String zzu = "";

        public zzb() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzad = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzaf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        this.zzag = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_9:
                        this.zzah = zzgm.zzcs();
                        continue;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        this.zzab = zzgm.readString();
                        continue;
                    case 56:
                        this.zzai = zzgm.zzcf();
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
            zzgn.zza(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(2, this.zzad);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(3, this.zzaf);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(4, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(5, this.zzah);
            }
            if (this.zzab != null && !this.zzab.equals("")) {
                zzgn.zza(6, this.zzab);
            }
            if (this.zzai) {
                zzgn.zzb(7, this.zzai);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(2, this.zzad);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(3, this.zzaf);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(4, this.zzag);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(5, this.zzah);
            }
            if (this.zzab != null && !this.zzab.equals("")) {
                zzb += zzgn.zzb(6, this.zzab);
            }
            return this.zzai ? zzb + zzgn.zzz(7) + 1 : zzb;
        }
    }

    public static final class zzc extends zzgp<zzc> {
        public zzu[] zzal = zzu.zzd();
        private String zzu = "";

        public zzc() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        int zzb = zzgy.zzb(zzgm, 18);
                        int length = this.zzal == null ? 0 : this.zzal.length;
                        zzu[] zzuArr = new zzu[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzal, 0, zzuArr, 0, length);
                        }
                        while (length < zzuArr.length - 1) {
                            zzuArr[length] = new zzu();
                            zzgm.zzb(zzuArr[length]);
                            zzgm.zzbz();
                            length++;
                        }
                        zzuArr[length] = new zzu();
                        zzgm.zzb(zzuArr[length]);
                        this.zzal = zzuArr;
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
            zzgn.zza(1, this.zzu);
            if (this.zzal != null && this.zzal.length > 0) {
                for (zzu zzu2 : this.zzal) {
                    if (zzu2 != null) {
                        zzgn.zza(2, (zzgv) zzu2);
                    }
                }
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = zzgn.zzb(1, this.zzu) + super.zzb();
            if (this.zzal != null && this.zzal.length > 0) {
                for (zzu zzu2 : this.zzal) {
                    if (zzu2 != null) {
                        zzb += zzgn.zzb(2, (zzgv) zzu2);
                    }
                }
            }
            return zzb;
        }
    }

    public static final class zzd extends zzgp<zzd> {
        public String zzaf = "";
        public String zzaq = "";
        public int zzba = 0;
        private String zzu = "";

        public zzd() {
            this.zzyw = -1;
        }

        /* access modifiers changed from: private */
        /* renamed from: zzc */
        public final zzd zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzaf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzaq = zzgm.readString();
                        continue;
                    case 32:
                        int position = zzgm.getPosition();
                        try {
                            this.zzba = zzgz.zzbe(zzgm.zzcr());
                            continue;
                        } catch (IllegalArgumentException e) {
                            zzgm.zzay(position);
                            zza(zzgm, zzbz);
                            break;
                        }
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
            zzgn.zza(1, this.zzu);
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(2, this.zzaf);
            }
            if (this.zzaq != null && !this.zzaq.equals("")) {
                zzgn.zza(3, this.zzaq);
            }
            if (this.zzba != 0) {
                zzgn.zzc(4, this.zzba);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(2, this.zzaf);
            }
            if (this.zzaq != null && !this.zzaq.equals("")) {
                zzb += zzgn.zzb(3, this.zzaq);
            }
            return this.zzba != 0 ? zzb + zzgn.zzg(4, this.zzba) : zzb;
        }
    }

    public static final class zze extends zzgp<zze> {
        private String zzab = "";
        public String zzad = "";
        public String zzaf = "";
        public String zzag = "";
        public long zzah = 0;
        private String zzaq = "";
        public String zzbf = "";
        private String[] zzbh = zzgy.EMPTY_STRING_ARRAY;
        public boolean zzbi = false;
        public String zzbp = "";
        public zzt[] zzbv = zzt.zzc();
        public String zzbw = "";
        private String zzu = "";

        public zze() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzab = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzaf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        this.zzbf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        int zzb = zzgy.zzb(zzgm, 42);
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
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        this.zzad = zzgm.readString();
                        continue;
                    case 58:
                        int zzb2 = zzgy.zzb(zzgm, 58);
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
                    case 66:
                        this.zzaq = zzgm.readString();
                        continue;
                    case 74:
                        this.zzbp = zzgm.readString();
                        continue;
                    case 82:
                        this.zzag = zzgm.readString();
                        continue;
                    case 88:
                        this.zzah = zzgm.zzcs();
                        continue;
                    case 98:
                        this.zzbw = zzgm.readString();
                        continue;
                    case 104:
                        this.zzbi = zzgm.zzcf();
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
            zzgn.zza(1, this.zzu);
            if (this.zzab != null && !this.zzab.equals("")) {
                zzgn.zza(2, this.zzab);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(3, this.zzaf);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzgn.zza(4, this.zzbf);
            }
            if (this.zzbh != null && this.zzbh.length > 0) {
                for (String str : this.zzbh) {
                    if (str != null) {
                        zzgn.zza(5, str);
                    }
                }
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(6, this.zzad);
            }
            if (this.zzbv != null && this.zzbv.length > 0) {
                for (zzt zzt : this.zzbv) {
                    if (zzt != null) {
                        zzgn.zza(7, (zzgv) zzt);
                    }
                }
            }
            if (this.zzaq != null && !this.zzaq.equals("")) {
                zzgn.zza(8, this.zzaq);
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzgn.zza(9, this.zzbp);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(10, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(11, this.zzah);
            }
            if (this.zzbw != null && !this.zzbw.equals("")) {
                zzgn.zza(12, this.zzbw);
            }
            if (this.zzbi) {
                zzgn.zzb(13, this.zzbi);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzab != null && !this.zzab.equals("")) {
                zzb += zzgn.zzb(2, this.zzab);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(3, this.zzaf);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzb += zzgn.zzb(4, this.zzbf);
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
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(6, this.zzad);
            }
            if (this.zzbv != null && this.zzbv.length > 0) {
                for (zzt zzt : this.zzbv) {
                    if (zzt != null) {
                        zzb += zzgn.zzb(7, (zzgv) zzt);
                    }
                }
            }
            if (this.zzaq != null && !this.zzaq.equals("")) {
                zzb += zzgn.zzb(8, this.zzaq);
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzb += zzgn.zzb(9, this.zzbp);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(10, this.zzag);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(11, this.zzah);
            }
            if (this.zzbw != null && !this.zzbw.equals("")) {
                zzb += zzgn.zzb(12, this.zzbw);
            }
            return this.zzbi ? zzb + zzgn.zzz(13) + 1 : zzb;
        }
    }

    public static final class zzf extends zzgp<zzf> {
        private String zzab = "";
        public String zzad = "";
        public String zzaf = "";
        public String zzag = "";
        public long zzah = 0;
        public String zzbf = "";
        private String zzu = "";

        public zzf() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzad = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        this.zzbf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        this.zzaf = zzgm.readString();
                        continue;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        this.zzag = zzgm.readString();
                        continue;
                    case 56:
                        this.zzah = zzgm.zzcs();
                        continue;
                    case 66:
                        this.zzab = zzgm.readString();
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
            zzgn.zza(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(2, this.zzad);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzgn.zza(4, this.zzbf);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(5, this.zzaf);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(6, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(7, this.zzah);
            }
            if (this.zzab != null && !this.zzab.equals("")) {
                zzgn.zza(8, this.zzab);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(2, this.zzad);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzb += zzgn.zzb(4, this.zzbf);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(5, this.zzaf);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(6, this.zzag);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(7, this.zzah);
            }
            return (this.zzab == null || this.zzab.equals("")) ? zzb : zzb + zzgn.zzb(8, this.zzab);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase_auth.zzg$zzg  reason: collision with other inner class name */
    public static final class C0440zzg extends zzgp<C0440zzg> {
        public String zzab = "";
        public String zzad = "";
        public String zzaf = "";
        public String zzag = "";
        public long zzah = 0;
        public boolean zzai = false;
        public String zzbf = "";
        private boolean zzbi = false;
        public String zzbp = "";
        private String zzce = "";
        private String zzcf = "";
        private String zzcg = "";
        private String zzch = "";
        private String zzci = "";
        private String zzcj = "";
        private String zzck = "";
        private String zzcl = "";
        private String zzcm = "";
        private String zzcn = "";
        private String zzco = "";
        private boolean zzcp = false;
        private String zzcq = "";
        private String[] zzcr = zzgy.EMPTY_STRING_ARRAY;
        public boolean zzcs = false;
        private String zzct = "";
        private String zzcu = "";
        public String zzcv = "";
        private String zzcw = "";
        private long zzcx = 0;
        private String zzcy = "";
        public boolean zzcz = false;
        private String zzda = "";
        public String zzdb = "";
        private String zzdc = "";
        public String zzdd = "";
        private String zzde = "";
        public String zzj = "";
        private String zzl = "";
        private String zzn = "";

        public C0440zzg() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzce = zzgm.readString();
                        continue;
                    case 18:
                        this.zzj = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzaf = zzgm.readString();
                        continue;
                    case 32:
                        this.zzbi = zzgm.zzcf();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        this.zzcf = zzgm.readString();
                        continue;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        this.zzcg = zzgm.readString();
                        continue;
                    case 58:
                        this.zzch = zzgm.readString();
                        continue;
                    case 66:
                        this.zzci = zzgm.readString();
                        continue;
                    case 74:
                        this.zzcj = zzgm.readString();
                        continue;
                    case 82:
                        this.zzck = zzgm.readString();
                        continue;
                    case 90:
                        this.zzbp = zzgm.readString();
                        continue;
                    case 98:
                        this.zzcl = zzgm.readString();
                        continue;
                    case 106:
                        this.zzcm = zzgm.readString();
                        continue;
                    case 114:
                        this.zzl = zzgm.readString();
                        continue;
                    case 122:
                        this.zzcn = zzgm.readString();
                        continue;
                    case 130:
                        this.zzco = zzgm.readString();
                        continue;
                    case 138:
                        this.zzab = zzgm.readString();
                        continue;
                    case 144:
                        this.zzcp = zzgm.zzcf();
                        continue;
                    case 154:
                        this.zzbf = zzgm.readString();
                        continue;
                    case 162:
                        this.zzad = zzgm.readString();
                        continue;
                    case 170:
                        this.zzcq = zzgm.readString();
                        continue;
                    case 186:
                        this.zzn = zzgm.readString();
                        continue;
                    case 194:
                        int zzb = zzgy.zzb(zzgm, 194);
                        int length = this.zzcr == null ? 0 : this.zzcr.length;
                        String[] strArr = new String[(zzb + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzcr, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzgm.readString();
                            zzgm.zzbz();
                            length++;
                        }
                        strArr[length] = zzgm.readString();
                        this.zzcr = strArr;
                        continue;
                    case 200:
                        this.zzcs = zzgm.zzcf();
                        continue;
                    case 210:
                        this.zzct = zzgm.readString();
                        continue;
                    case 218:
                        this.zzcu = zzgm.readString();
                        continue;
                    case 226:
                        this.zzcv = zzgm.readString();
                        continue;
                    case 234:
                        this.zzcw = zzgm.readString();
                        continue;
                    case 240:
                        this.zzcx = zzgm.zzcs();
                        continue;
                    case 250:
                        this.zzcy = zzgm.readString();
                        continue;
                    case 256:
                        this.zzcz = zzgm.zzcf();
                        continue;
                    case 266:
                        this.zzda = zzgm.readString();
                        continue;
                    case 274:
                        this.zzag = zzgm.readString();
                        continue;
                    case 280:
                        this.zzah = zzgm.zzcs();
                        continue;
                    case 290:
                        this.zzdb = zzgm.readString();
                        continue;
                    case 298:
                        this.zzdc = zzgm.readString();
                        continue;
                    case 306:
                        this.zzdd = zzgm.readString();
                        continue;
                    case 314:
                        this.zzde = zzgm.readString();
                        continue;
                    case 320:
                        this.zzai = zzgm.zzcf();
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
            if (this.zzce != null && !this.zzce.equals("")) {
                zzgn.zza(1, this.zzce);
            }
            if (this.zzj != null && !this.zzj.equals("")) {
                zzgn.zza(2, this.zzj);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(3, this.zzaf);
            }
            if (this.zzbi) {
                zzgn.zzb(4, this.zzbi);
            }
            if (this.zzcf != null && !this.zzcf.equals("")) {
                zzgn.zza(5, this.zzcf);
            }
            if (this.zzcg != null && !this.zzcg.equals("")) {
                zzgn.zza(6, this.zzcg);
            }
            if (this.zzch != null && !this.zzch.equals("")) {
                zzgn.zza(7, this.zzch);
            }
            if (this.zzci != null && !this.zzci.equals("")) {
                zzgn.zza(8, this.zzci);
            }
            if (this.zzcj != null && !this.zzcj.equals("")) {
                zzgn.zza(9, this.zzcj);
            }
            if (this.zzck != null && !this.zzck.equals("")) {
                zzgn.zza(10, this.zzck);
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzgn.zza(11, this.zzbp);
            }
            if (this.zzcl != null && !this.zzcl.equals("")) {
                zzgn.zza(12, this.zzcl);
            }
            if (this.zzcm != null && !this.zzcm.equals("")) {
                zzgn.zza(13, this.zzcm);
            }
            if (this.zzl != null && !this.zzl.equals("")) {
                zzgn.zza(14, this.zzl);
            }
            if (this.zzcn != null && !this.zzcn.equals("")) {
                zzgn.zza(15, this.zzcn);
            }
            if (this.zzco != null && !this.zzco.equals("")) {
                zzgn.zza(16, this.zzco);
            }
            if (this.zzab != null && !this.zzab.equals("")) {
                zzgn.zza(17, this.zzab);
            }
            if (this.zzcp) {
                zzgn.zzb(18, this.zzcp);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzgn.zza(19, this.zzbf);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(20, this.zzad);
            }
            if (this.zzcq != null && !this.zzcq.equals("")) {
                zzgn.zza(21, this.zzcq);
            }
            if (this.zzn != null && !this.zzn.equals("")) {
                zzgn.zza(23, this.zzn);
            }
            if (this.zzcr != null && this.zzcr.length > 0) {
                for (String str : this.zzcr) {
                    if (str != null) {
                        zzgn.zza(24, str);
                    }
                }
            }
            if (this.zzcs) {
                zzgn.zzb(25, this.zzcs);
            }
            if (this.zzct != null && !this.zzct.equals("")) {
                zzgn.zza(26, this.zzct);
            }
            if (this.zzcu != null && !this.zzcu.equals("")) {
                zzgn.zza(27, this.zzcu);
            }
            if (this.zzcv != null && !this.zzcv.equals("")) {
                zzgn.zza(28, this.zzcv);
            }
            if (this.zzcw != null && !this.zzcw.equals("")) {
                zzgn.zza(29, this.zzcw);
            }
            if (this.zzcx != 0) {
                zzgn.zzi(30, this.zzcx);
            }
            if (this.zzcy != null && !this.zzcy.equals("")) {
                zzgn.zza(31, this.zzcy);
            }
            if (this.zzcz) {
                zzgn.zzb(32, this.zzcz);
            }
            if (this.zzda != null && !this.zzda.equals("")) {
                zzgn.zza(33, this.zzda);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(34, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(35, this.zzah);
            }
            if (this.zzdb != null && !this.zzdb.equals("")) {
                zzgn.zza(36, this.zzdb);
            }
            if (this.zzdc != null && !this.zzdc.equals("")) {
                zzgn.zza(37, this.zzdc);
            }
            if (this.zzdd != null && !this.zzdd.equals("")) {
                zzgn.zza(38, this.zzdd);
            }
            if (this.zzde != null && !this.zzde.equals("")) {
                zzgn.zza(39, this.zzde);
            }
            if (this.zzai) {
                zzgn.zzb(40, this.zzai);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb();
            if (this.zzce != null && !this.zzce.equals("")) {
                zzb += zzgn.zzb(1, this.zzce);
            }
            if (this.zzj != null && !this.zzj.equals("")) {
                zzb += zzgn.zzb(2, this.zzj);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(3, this.zzaf);
            }
            if (this.zzbi) {
                zzb += zzgn.zzz(4) + 1;
            }
            if (this.zzcf != null && !this.zzcf.equals("")) {
                zzb += zzgn.zzb(5, this.zzcf);
            }
            if (this.zzcg != null && !this.zzcg.equals("")) {
                zzb += zzgn.zzb(6, this.zzcg);
            }
            if (this.zzch != null && !this.zzch.equals("")) {
                zzb += zzgn.zzb(7, this.zzch);
            }
            if (this.zzci != null && !this.zzci.equals("")) {
                zzb += zzgn.zzb(8, this.zzci);
            }
            if (this.zzcj != null && !this.zzcj.equals("")) {
                zzb += zzgn.zzb(9, this.zzcj);
            }
            if (this.zzck != null && !this.zzck.equals("")) {
                zzb += zzgn.zzb(10, this.zzck);
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzb += zzgn.zzb(11, this.zzbp);
            }
            if (this.zzcl != null && !this.zzcl.equals("")) {
                zzb += zzgn.zzb(12, this.zzcl);
            }
            if (this.zzcm != null && !this.zzcm.equals("")) {
                zzb += zzgn.zzb(13, this.zzcm);
            }
            if (this.zzl != null && !this.zzl.equals("")) {
                zzb += zzgn.zzb(14, this.zzl);
            }
            if (this.zzcn != null && !this.zzcn.equals("")) {
                zzb += zzgn.zzb(15, this.zzcn);
            }
            if (this.zzco != null && !this.zzco.equals("")) {
                zzb += zzgn.zzb(16, this.zzco);
            }
            if (this.zzab != null && !this.zzab.equals("")) {
                zzb += zzgn.zzb(17, this.zzab);
            }
            if (this.zzcp) {
                zzb += zzgn.zzz(18) + 1;
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzb += zzgn.zzb(19, this.zzbf);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(20, this.zzad);
            }
            if (this.zzcq != null && !this.zzcq.equals("")) {
                zzb += zzgn.zzb(21, this.zzcq);
            }
            if (this.zzn != null && !this.zzn.equals("")) {
                zzb += zzgn.zzb(23, this.zzn);
            }
            if (this.zzcr != null && this.zzcr.length > 0) {
                int i = 0;
                int i2 = 0;
                for (String str : this.zzcr) {
                    if (str != null) {
                        i2++;
                        i += zzgn.zzam(str);
                    }
                }
                zzb = zzb + i + (i2 * 2);
            }
            if (this.zzcs) {
                zzb += zzgn.zzz(25) + 1;
            }
            if (this.zzct != null && !this.zzct.equals("")) {
                zzb += zzgn.zzb(26, this.zzct);
            }
            if (this.zzcu != null && !this.zzcu.equals("")) {
                zzb += zzgn.zzb(27, this.zzcu);
            }
            if (this.zzcv != null && !this.zzcv.equals("")) {
                zzb += zzgn.zzb(28, this.zzcv);
            }
            if (this.zzcw != null && !this.zzcw.equals("")) {
                zzb += zzgn.zzb(29, this.zzcw);
            }
            if (this.zzcx != 0) {
                zzb += zzgn.zzd(30, this.zzcx);
            }
            if (this.zzcy != null && !this.zzcy.equals("")) {
                zzb += zzgn.zzb(31, this.zzcy);
            }
            if (this.zzcz) {
                zzb += zzgn.zzz(32) + 1;
            }
            if (this.zzda != null && !this.zzda.equals("")) {
                zzb += zzgn.zzb(33, this.zzda);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(34, this.zzag);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(35, this.zzah);
            }
            if (this.zzdb != null && !this.zzdb.equals("")) {
                zzb += zzgn.zzb(36, this.zzdb);
            }
            if (this.zzdc != null && !this.zzdc.equals("")) {
                zzb += zzgn.zzb(37, this.zzdc);
            }
            if (this.zzdd != null && !this.zzdd.equals("")) {
                zzb += zzgn.zzb(38, this.zzdd);
            }
            if (this.zzde != null && !this.zzde.equals("")) {
                zzb += zzgn.zzb(39, this.zzde);
            }
            return this.zzai ? zzb + zzgn.zzz(40) + 1 : zzb;
        }
    }

    public static final class zzh extends zzgp<zzh> {
        public String zzad = "";
        public String zzag = "";
        public long zzah = 0;
        public boolean zzai = false;
        private String zzu = "";

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
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzad = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzag = zzgm.readString();
                        continue;
                    case 32:
                        this.zzah = zzgm.zzcs();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_9:
                        this.zzai = zzgm.zzcf();
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
            zzgn.zza(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(2, this.zzad);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(3, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(4, this.zzah);
            }
            if (this.zzai) {
                zzgn.zzb(5, this.zzai);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(2, this.zzad);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(3, this.zzag);
            }
            if (this.zzah != 0) {
                zzb += zzgn.zzd(4, this.zzah);
            }
            return this.zzai ? zzb + zzgn.zzz(5) + 1 : zzb;
        }
    }

    public static final class zzi extends zzgp<zzi> {
        public String zzab = "";
        public String zzad = "";
        public String zzaf = "";
        public String zzag = "";
        public long zzah = 0;
        public String zzbf = "";
        public String zzbp = "";
        private String zzcv = "";
        private long zzcx = 0;
        private String zzcy = "";
        private String zzu = "";
        private boolean zzx = false;

        public zzi() {
            this.zzyw = -1;
        }

        public final /* synthetic */ zzgv zza(zzgm zzgm) throws IOException {
            while (true) {
                int zzbz = zzgm.zzbz();
                switch (zzbz) {
                    case 0:
                        break;
                    case 10:
                        this.zzu = zzgm.readString();
                        continue;
                    case 18:
                        this.zzab = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_SCROLL:
                        this.zzaf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        this.zzbf = zzgm.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11:
                        this.zzad = zzgm.readString();
                        continue;
                    case 48:
                        this.zzx = zzgm.zzcf();
                        continue;
                    case 58:
                        this.zzbp = zzgm.readString();
                        continue;
                    case 66:
                        this.zzcv = zzgm.readString();
                        continue;
                    case 72:
                        this.zzcx = zzgm.zzcs();
                        continue;
                    case 82:
                        this.zzcy = zzgm.readString();
                        continue;
                    case 90:
                        this.zzag = zzgm.readString();
                        continue;
                    case 96:
                        this.zzah = zzgm.zzcs();
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
            zzgn.zza(1, this.zzu);
            if (this.zzab != null && !this.zzab.equals("")) {
                zzgn.zza(2, this.zzab);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzgn.zza(3, this.zzaf);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzgn.zza(4, this.zzbf);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzgn.zza(5, this.zzad);
            }
            if (this.zzx) {
                zzgn.zzb(6, this.zzx);
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzgn.zza(7, this.zzbp);
            }
            if (this.zzcv != null && !this.zzcv.equals("")) {
                zzgn.zza(8, this.zzcv);
            }
            if (this.zzcx != 0) {
                zzgn.zzi(9, this.zzcx);
            }
            if (this.zzcy != null && !this.zzcy.equals("")) {
                zzgn.zza(10, this.zzcy);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzgn.zza(11, this.zzag);
            }
            if (this.zzah != 0) {
                zzgn.zzi(12, this.zzah);
            }
            super.zza(zzgn);
        }

        /* access modifiers changed from: protected */
        public final int zzb() {
            int zzb = super.zzb() + zzgn.zzb(1, this.zzu);
            if (this.zzab != null && !this.zzab.equals("")) {
                zzb += zzgn.zzb(2, this.zzab);
            }
            if (this.zzaf != null && !this.zzaf.equals("")) {
                zzb += zzgn.zzb(3, this.zzaf);
            }
            if (this.zzbf != null && !this.zzbf.equals("")) {
                zzb += zzgn.zzb(4, this.zzbf);
            }
            if (this.zzad != null && !this.zzad.equals("")) {
                zzb += zzgn.zzb(5, this.zzad);
            }
            if (this.zzx) {
                zzb += zzgn.zzz(6) + 1;
            }
            if (this.zzbp != null && !this.zzbp.equals("")) {
                zzb += zzgn.zzb(7, this.zzbp);
            }
            if (this.zzcv != null && !this.zzcv.equals("")) {
                zzb += zzgn.zzb(8, this.zzcv);
            }
            if (this.zzcx != 0) {
                zzb += zzgn.zzd(9, this.zzcx);
            }
            if (this.zzcy != null && !this.zzcy.equals("")) {
                zzb += zzgn.zzb(10, this.zzcy);
            }
            if (this.zzag != null && !this.zzag.equals("")) {
                zzb += zzgn.zzb(11, this.zzag);
            }
            return this.zzah != 0 ? zzb + zzgn.zzd(12, this.zzah) : zzb;
        }
    }
}
