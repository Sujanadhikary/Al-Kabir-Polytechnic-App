package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcl extends zzbq<Double> implements zzdg<Double>, RandomAccess {
    private static final zzcl zznk;
    private int size;
    private double[] zznl;

    static {
        zzcl zzcl = new zzcl();
        zznk = zzcl;
        zzcl.zzbp();
    }

    zzcl() {
        this(new double[10], 0);
    }

    private zzcl(double[] dArr, int i) {
        this.zznl = dArr;
        this.size = i;
    }

    private final void zzc(int i, double d) {
        zzbq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        if (this.size < this.zznl.length) {
            System.arraycopy(this.zznl, i, this.zznl, i + 1, this.size - i);
        } else {
            double[] dArr = new double[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zznl, 0, dArr, 0, i);
            System.arraycopy(this.zznl, i, dArr, i + 1, this.size - i);
            this.zznl = dArr;
        }
        this.zznl[i] = d;
        this.size++;
        this.modCount++;
    }

    private final void zzg(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
    }

    private final String zzh(int i) {
        return new StringBuilder(35).append("Index:").append(i).append(", Size:").append(this.size).toString();
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Double) obj).doubleValue());
    }

    public final boolean addAll(Collection<? extends Double> collection) {
        zzbq();
        zzdd.checkNotNull(collection);
        if (!(collection instanceof zzcl)) {
            return super.addAll(collection);
        }
        zzcl zzcl = (zzcl) collection;
        if (zzcl.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzcl.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzcl.size;
        if (i > this.zznl.length) {
            this.zznl = Arrays.copyOf(this.zznl, i);
        }
        System.arraycopy(zzcl.zznl, 0, this.zznl, this.size, zzcl.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcl)) {
            return super.equals(obj);
        }
        zzcl zzcl = (zzcl) obj;
        if (this.size != zzcl.size) {
            return false;
        }
        double[] dArr = zzcl.zznl;
        for (int i = 0; i < this.size; i++) {
            if (this.zznl[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Double.valueOf(this.zznl[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdd.zzk(Double.doubleToLongBits(this.zznl[i2]));
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzg(i);
        double d = this.zznl[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zznl, i + 1, this.zznl, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Double.valueOf(this.zznl[i]))) {
                System.arraycopy(this.zznl, i + 1, this.zznl, i, this.size - i);
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
        System.arraycopy(this.zznl, i2, this.zznl, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzbq();
        zzg(i);
        double d = this.zznl[i];
        this.zznl[i] = doubleValue;
        return Double.valueOf(d);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(double d) {
        zzc(this.size, d);
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i >= this.size) {
            return new zzcl(Arrays.copyOf(this.zznl, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
