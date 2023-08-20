package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Iterator;

public abstract class zzyw implements Serializable, Iterable<Byte> {
    public static final zzyw zzbqx = new zzzc(zzzr.zzbsq);
    private static final zzza zzbqy = (zzyv.zzsv() ? new zzzd((zzyx) null) : new zzyy((zzyx) null));
    private int zzboc = 0;

    zzyw() {
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

    public static zzyw zzfi(String str) {
        return new zzzc(str.getBytes(zzzr.UTF_8));
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zzboc;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzboc = i;
        }
        return i;
    }

    public /* synthetic */ Iterator iterator() {
        return new zzyx(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract byte zzae(int i);

    public abstract zzyw zzb(int i, int i2);

    /* access modifiers changed from: protected */
    public final int zzsx() {
        return this.zzboc;
    }
}
