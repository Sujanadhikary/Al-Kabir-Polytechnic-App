package com.google.android.gms.internal.measurement;

final class zzyz extends zzzc {
    private final int zzbra;
    private final int zzbrb;

    zzyz(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzbra = i;
        this.zzbrb = i2;
    }

    public final int size() {
        return this.zzbrb;
    }

    public final byte zzae(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzbrc[this.zzbra + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
    }

    /* access modifiers changed from: protected */
    public final int zzsy() {
        return this.zzbra;
    }
}
