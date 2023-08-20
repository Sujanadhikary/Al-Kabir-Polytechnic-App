package com.google.android.gms.internal.firebase_auth;

final class zzbx extends zzcb {
    private final int zzmg;
    private final int zzmh;

    zzbx(byte[] bArr, int i, int i2) {
        super(bArr);
        zzb(i, i + i2, bArr.length);
        this.zzmg = i;
        this.zzmh = i2;
    }

    public final int size() {
        return this.zzmh;
    }

    /* access modifiers changed from: protected */
    public final int zzbw() {
        return this.zzmg;
    }

    public final byte zzj(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzmj[this.zzmg + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuilder(22).append("Index < 0: ").append(i).toString());
        }
        throw new ArrayIndexOutOfBoundsException(new StringBuilder(40).append("Index > length: ").append(i).append(", ").append(size).toString());
    }
}
