package com.google.android.gms.internal.measurement;

class zzzc extends zzzb {
    protected final byte[] zzbrc;

    zzzc(byte[] bArr) {
        this.zzbrc = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyw)) {
            return false;
        }
        if (size() != ((zzyw) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzzc)) {
            return obj.equals(this);
        }
        int zzsx = zzsx();
        int zzsx2 = ((zzzc) obj).zzsx();
        if (zzsx == 0 || zzsx2 == 0 || zzsx == zzsx2) {
            return zza((zzzc) obj, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzbrc.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzzr.zza(i, this.zzbrc, zzsy(), i3);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzyw zzyw, int i, int i2) {
        if (i2 > zzyw.size()) {
            throw new IllegalArgumentException(new StringBuilder(40).append("Length too large: ").append(i2).append(size()).toString());
        } else if (i2 > zzyw.size()) {
            throw new IllegalArgumentException(new StringBuilder(59).append("Ran off end of other: 0, ").append(i2).append(", ").append(zzyw.size()).toString());
        } else if (!(zzyw instanceof zzzc)) {
            return zzyw.zzb(0, i2).equals(zzb(0, i2));
        } else {
            zzzc zzzc = (zzzc) zzyw;
            byte[] bArr = this.zzbrc;
            byte[] bArr2 = zzzc.zzbrc;
            int zzsy = zzsy() + i2;
            int zzsy2 = zzsy();
            int zzsy3 = zzzc.zzsy();
            while (zzsy2 < zzsy) {
                if (bArr[zzsy2] != bArr2[zzsy3]) {
                    return false;
                }
                zzsy2++;
                zzsy3++;
            }
            return true;
        }
    }

    public byte zzae(int i) {
        return this.zzbrc[i];
    }

    public final zzyw zzb(int i, int i2) {
        int zzb = zzb(0, i2, size());
        return zzb == 0 ? zzyw.zzbqx : new zzyz(this.zzbrc, zzsy(), zzb);
    }

    /* access modifiers changed from: protected */
    public int zzsy() {
        return 0;
    }
}
