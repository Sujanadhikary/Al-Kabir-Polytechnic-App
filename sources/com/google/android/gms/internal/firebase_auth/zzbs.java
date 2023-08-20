package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzbs extends zzbq<Boolean> implements zzdg<Boolean>, RandomAccess {
    private static final zzbs zzma;
    private int size;
    private boolean[] zzmb;

    static {
        zzbs zzbs = new zzbs();
        zzma = zzbs;
        zzbs.zzbp();
    }

    zzbs() {
        this(new boolean[10], 0);
    }

    private zzbs(boolean[] zArr, int i) {
        this.zzmb = zArr;
        this.size = i;
    }

    private final void zza(int i, boolean z) {
        zzbq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        if (this.size < this.zzmb.length) {
            System.arraycopy(this.zzmb, i, this.zzmb, i + 1, this.size - i);
        } else {
            boolean[] zArr = new boolean[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzmb, 0, zArr, 0, i);
            System.arraycopy(this.zzmb, i, zArr, i + 1, this.size - i);
            this.zzmb = zArr;
        }
        this.zzmb[i] = z;
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
        zza(i, ((Boolean) obj).booleanValue());
    }

    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbq();
        zzdd.checkNotNull(collection);
        if (!(collection instanceof zzbs)) {
            return super.addAll(collection);
        }
        zzbs zzbs = (zzbs) collection;
        if (zzbs.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzbs.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzbs.size;
        if (i > this.zzmb.length) {
            this.zzmb = Arrays.copyOf(this.zzmb, i);
        }
        System.arraycopy(zzbs.zzmb, 0, this.zzmb, this.size, zzbs.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final void addBoolean(boolean z) {
        zza(this.size, z);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbs)) {
            return super.equals(obj);
        }
        zzbs zzbs = (zzbs) obj;
        if (this.size != zzbs.size) {
            return false;
        }
        boolean[] zArr = zzbs.zzmb;
        for (int i = 0; i < this.size; i++) {
            if (this.zzmb[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Boolean.valueOf(this.zzmb[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzdd.zzi(this.zzmb[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzg(i);
        boolean z = this.zzmb[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzmb, i + 1, this.zzmb, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Boolean.valueOf(this.zzmb[i]))) {
                System.arraycopy(this.zzmb, i + 1, this.zzmb, i, this.size - i);
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
        System.arraycopy(this.zzmb, i2, this.zzmb, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzbq();
        zzg(i);
        boolean z = this.zzmb[i];
        this.zzmb[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i >= this.size) {
            return new zzbs(Arrays.copyOf(this.zzmb, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
