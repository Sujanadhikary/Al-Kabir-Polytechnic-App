package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;

class zzcb extends zzca {
    protected final byte[] zzmj;

    zzcb(byte[] bArr) {
        this.zzmj = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzbu)) {
            return false;
        }
        if (size() != ((zzbu) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzcb)) {
            return obj.equals(this);
        }
        int zzbv = zzbv();
        int zzbv2 = ((zzcb) obj).zzbv();
        if (zzbv == 0 || zzbv2 == 0 || zzbv == zzbv2) {
            return zza((zzcb) obj, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzmj.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzdd.zza(i, this.zzmj, zzbw(), i3);
    }

    public final zzbu zza(int i, int i2) {
        int zzb = zzb(0, i2, size());
        return zzb == 0 ? zzbu.zzmc : new zzbx(this.zzmj, zzbw(), zzb);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzmj, zzbw(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbt zzbt) throws IOException {
        zzbt.zza(this.zzmj, zzbw(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzbu zzbu, int i, int i2) {
        if (i2 > zzbu.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        } else if (i2 > zzbu.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzbu.size()).toString());
        } else if (!(zzbu instanceof zzcb)) {
            return zzbu.zza(0, i2).equals(zza(0, i2));
        } else {
            zzcb zzcb = (zzcb) zzbu;
            byte[] bArr = this.zzmj;
            byte[] bArr2 = zzcb.zzmj;
            int zzbw = zzbw() + i2;
            int zzbw2 = zzbw();
            int zzbw3 = zzcb.zzbw();
            while (zzbw2 < zzbw) {
                if (bArr[zzbw2] != bArr2[zzbw3]) {
                    return false;
                }
                zzbw2++;
                zzbw3++;
            }
            return true;
        }
    }

    public final boolean zzbu() {
        int zzbw = zzbw();
        return zzfz.zzf(this.zzmj, zzbw, size() + zzbw);
    }

    /* access modifiers changed from: protected */
    public int zzbw() {
        return 0;
    }

    public byte zzj(int i) {
        return this.zzmj[i];
    }
}
