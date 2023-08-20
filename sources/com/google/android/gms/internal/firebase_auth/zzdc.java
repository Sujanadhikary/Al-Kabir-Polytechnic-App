package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdc extends zzbq<Integer> implements zzdg<Integer>, RandomAccess {
    private static final zzdc zzrm;
    private int size;
    private int[] zzrn;

    static {
        zzdc zzdc = new zzdc();
        zzrm = zzdc;
        zzdc.zzbp();
    }

    zzdc() {
        this(new int[10], 0);
    }

    private zzdc(int[] iArr, int i) {
        this.zzrn = iArr;
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

    private final void zzo(int i, int i2) {
        zzbq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        if (this.size < this.zzrn.length) {
            System.arraycopy(this.zzrn, i, this.zzrn, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzrn, 0, iArr, 0, i);
            System.arraycopy(this.zzrn, i, iArr, i + 1, this.size - i);
            this.zzrn = iArr;
        }
        this.zzrn[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzo(i, ((Integer) obj).intValue());
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbq();
        zzdd.checkNotNull(collection);
        if (!(collection instanceof zzdc)) {
            return super.addAll(collection);
        }
        zzdc zzdc = (zzdc) collection;
        if (zzdc.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzdc.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzdc.size;
        if (i > this.zzrn.length) {
            this.zzrn = Arrays.copyOf(this.zzrn, i);
        }
        System.arraycopy(zzdc.zzrn, 0, this.zzrn, this.size, zzdc.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdc)) {
            return super.equals(obj);
        }
        zzdc zzdc = (zzdc) obj;
        if (this.size != zzdc.size) {
            return false;
        }
        int[] iArr = zzdc.zzrn;
        for (int i = 0; i < this.size; i++) {
            if (this.zzrn[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        zzg(i);
        return this.zzrn[i];
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzrn[i2];
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzg(i);
        int i2 = this.zzrn[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzrn, i + 1, this.zzrn, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzrn[i]))) {
                System.arraycopy(this.zzrn, i + 1, this.zzrn, i, this.size - i);
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
        System.arraycopy(this.zzrn, i2, this.zzrn, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzbq();
        zzg(i);
        int i2 = this.zzrn[i];
        this.zzrn[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final int size() {
        return this.size;
    }

    public final void zzak(int i) {
        zzo(this.size, i);
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i >= this.size) {
            return new zzdc(Arrays.copyOf(this.zzrn, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
