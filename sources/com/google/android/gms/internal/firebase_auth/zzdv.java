package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdv extends zzbq<Long> implements zzdg<Long>, RandomAccess {
    private static final zzdv zzsq;
    private int size;
    private long[] zzsr;

    static {
        zzdv zzdv = new zzdv();
        zzsq = zzdv;
        zzdv.zzbp();
    }

    zzdv() {
        this(new long[10], 0);
    }

    private zzdv(long[] jArr, int i) {
        this.zzsr = jArr;
        this.size = i;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    private final String zzh(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    private final void zzk(int i, long j) {
        zzbq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        if (this.size < this.zzsr.length) {
            System.arraycopy(this.zzsr, i, this.zzsr, i + 1, this.size - i);
        } else {
            long[] jArr = new long[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzsr, 0, jArr, 0, i);
            System.arraycopy(this.zzsr, i, jArr, i + 1, this.size - i);
            this.zzsr = jArr;
        }
        this.zzsr[i] = j;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzbq();
        zzdd.checkNotNull(collection);
        if (!(collection instanceof zzdv)) {
            return super.addAll(collection);
        }
        zzdv zzdv = (zzdv) collection;
        if (zzdv.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzdv.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzdv.size;
        if (i > this.zzsr.length) {
            this.zzsr = Arrays.copyOf(this.zzsr, i);
        }
        System.arraycopy(zzdv.zzsr, 0, this.zzsr, this.size, zzdv.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdv)) {
            return super.equals(obj);
        }
        zzdv zzdv = (zzdv) obj;
        if (this.size != zzdv.size) {
            return false;
        }
        long[] jArr = zzdv.zzsr;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsr[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        zzg(i);
        return this.zzsr[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdd.zzk(this.zzsr[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzg(i);
        long j = this.zzsr[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzsr, i + 1, this.zzsr, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzsr[i]))) {
                System.arraycopy(this.zzsr, i + 1, this.zzsr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbq();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzsr, i2, this.zzsr, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzbq();
        zzg(i);
        long j = this.zzsr[i];
        this.zzsr[i] = longValue;
        return Long.valueOf(j);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i >= this.size) {
            return new zzdv(Arrays.copyOf(this.zzsr, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final void zzl(long j) {
        zzk(this.size, j);
    }
}
