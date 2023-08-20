package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class zzbu implements Serializable, Iterable<Byte> {
    public static final zzbu zzmc = new zzcb(zzdd.EMPTY_BYTE_ARRAY);
    private static final zzby zzmd = (zzbr.zzbr() ? new zzcc((zzbv) null) : new zzbw((zzbv) null));
    private int zzme = 0;

    zzbu() {
    }

    static zzbu zza(byte[] bArr) {
        return new zzcb(bArr);
    }

    public static zzbu zzak(String str) {
        return new zzcb(str.getBytes(zzdd.UTF_8));
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(new StringBuilder(32).append("Beginning index: ").append(i).append(" < 0").toString());
        } else if (i2 < i) {
            throw new IndexOutOfBoundsException(new StringBuilder(66).append("Beginning index larger than ending index: ").append(i).append(", ").append(i2).toString());
        } else {
            throw new IndexOutOfBoundsException(new StringBuilder(37).append("End index: ").append(i2).append(" >= ").append(i3).toString());
        }
    }

    public static zzbu zzb(byte[] bArr, int i, int i2) {
        return new zzcb(zzmd.zzc(bArr, i, i2));
    }

    static zzbz zzk(int i) {
        return new zzbz(i, (zzbv) null);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzme;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzme = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzbv(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzbu zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzbt zzbt) throws IOException;

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzdd.UTF_8);
    }

    public abstract boolean zzbu();

    /* access modifiers changed from: protected */
    public final int zzbv() {
        return this.zzme;
    }

    public abstract byte zzj(int i);
}
