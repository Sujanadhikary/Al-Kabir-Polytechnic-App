package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzkr extends zzaby<zzkr> {
    public long[] zzauk = zzach.zzbxm;
    public long[] zzaul = zzach.zzbxm;

    public zzkr() {
        this.zzbww = null;
        this.zzbxh = -1;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzkr)) {
            return false;
        }
        zzkr zzkr = (zzkr) obj;
        if (!zzacc.equals(this.zzauk, zzkr.zzauk)) {
            return false;
        }
        if (!zzacc.equals(this.zzaul, zzkr.zzaul)) {
            return false;
        }
        return (this.zzbww == null || this.zzbww.isEmpty()) ? zzkr.zzbww == null || zzkr.zzbww.isEmpty() : this.zzbww.equals(zzkr.zzbww);
    }

    public final int hashCode() {
        return ((this.zzbww == null || this.zzbww.isEmpty()) ? 0 : this.zzbww.hashCode()) + ((((((getClass().getName().hashCode() + 527) * 31) + zzacc.hashCode(this.zzauk)) * 31) + zzacc.hashCode(this.zzaul)) * 31);
    }

    /* access modifiers changed from: protected */
    public final int zza() {
        int i;
        int zza = super.zza();
        if (this.zzauk == null || this.zzauk.length <= 0) {
            i = zza;
        } else {
            int i2 = 0;
            for (long zzao : this.zzauk) {
                i2 += zzabw.zzao(zzao);
            }
            i = zza + i2 + (this.zzauk.length * 1);
        }
        if (this.zzaul == null || this.zzaul.length <= 0) {
            return i;
        }
        int i3 = 0;
        for (long zzao2 : this.zzaul) {
            i3 += zzabw.zzao(zzao2);
        }
        return i + i3 + (this.zzaul.length * 1);
    }

    public final void zza(zzabw zzabw) throws IOException {
        if (this.zzauk != null && this.zzauk.length > 0) {
            for (long zza : this.zzauk) {
                zzabw.zza(1, zza);
            }
        }
        if (this.zzaul != null && this.zzaul.length > 0) {
            for (long zza2 : this.zzaul) {
                zzabw.zza(2, zza2);
            }
        }
        super.zza(zzabw);
    }

    public final /* synthetic */ zzace zzb(zzabv zzabv) throws IOException {
        while (true) {
            int zzuw = zzabv.zzuw();
            switch (zzuw) {
                case 0:
                    break;
                case 8:
                    int zzb = zzach.zzb(zzabv, 8);
                    int length = this.zzauk == null ? 0 : this.zzauk.length;
                    long[] jArr = new long[(zzb + length)];
                    if (length != 0) {
                        System.arraycopy(this.zzauk, 0, jArr, 0, length);
                    }
                    while (length < jArr.length - 1) {
                        jArr[length] = zzabv.zzuz();
                        zzabv.zzuw();
                        length++;
                    }
                    jArr[length] = zzabv.zzuz();
                    this.zzauk = jArr;
                    continue;
                case 10:
                    int zzaf = zzabv.zzaf(zzabv.zzuy());
                    int position = zzabv.getPosition();
                    int i = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        i++;
                    }
                    zzabv.zzam(position);
                    int length2 = this.zzauk == null ? 0 : this.zzauk.length;
                    long[] jArr2 = new long[(i + length2)];
                    if (length2 != 0) {
                        System.arraycopy(this.zzauk, 0, jArr2, 0, length2);
                    }
                    while (length2 < jArr2.length) {
                        jArr2[length2] = zzabv.zzuz();
                        length2++;
                    }
                    this.zzauk = jArr2;
                    zzabv.zzal(zzaf);
                    continue;
                case 16:
                    int zzb2 = zzach.zzb(zzabv, 16);
                    int length3 = this.zzaul == null ? 0 : this.zzaul.length;
                    long[] jArr3 = new long[(zzb2 + length3)];
                    if (length3 != 0) {
                        System.arraycopy(this.zzaul, 0, jArr3, 0, length3);
                    }
                    while (length3 < jArr3.length - 1) {
                        jArr3[length3] = zzabv.zzuz();
                        zzabv.zzuw();
                        length3++;
                    }
                    jArr3[length3] = zzabv.zzuz();
                    this.zzaul = jArr3;
                    continue;
                case 18:
                    int zzaf2 = zzabv.zzaf(zzabv.zzuy());
                    int position2 = zzabv.getPosition();
                    int i2 = 0;
                    while (zzabv.zzvc() > 0) {
                        zzabv.zzuz();
                        i2++;
                    }
                    zzabv.zzam(position2);
                    int length4 = this.zzaul == null ? 0 : this.zzaul.length;
                    long[] jArr4 = new long[(i2 + length4)];
                    if (length4 != 0) {
                        System.arraycopy(this.zzaul, 0, jArr4, 0, length4);
                    }
                    while (length4 < jArr4.length) {
                        jArr4[length4] = zzabv.zzuz();
                        length4++;
                    }
                    this.zzaul = jArr4;
                    zzabv.zzal(zzaf2);
                    continue;
                default:
                    if (!super.zza(zzabv, zzuw)) {
                        break;
                    } else {
                        continue;
                    }
            }
        }
        return this;
    }
}
