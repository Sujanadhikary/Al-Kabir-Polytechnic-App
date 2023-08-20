package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzcy extends zzbq<Float> implements zzdg<Float>, RandomAccess {
    private static final zzcy zzqn;
    private int size;
    private float[] zzqo;

    static {
        zzcy zzcy = new zzcy();
        zzqn = zzcy;
        zzcy.zzbp();
    }

    zzcy() {
        this(new float[10], 0);
    }

    private zzcy(float[] fArr, int i) {
        this.zzqo = fArr;
        this.size = i;
    }

    private final void zzc(int i, float f) {
        zzbq();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzh(i));
        }
        if (this.size < this.zzqo.length) {
            System.arraycopy(this.zzqo, i, this.zzqo, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzqo, 0, fArr, 0, i);
            System.arraycopy(this.zzqo, i, fArr, i + 1, this.size - i);
            this.zzqo = fArr;
        }
        this.zzqo[i] = f;
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
        zzc(i, ((Float) obj).floatValue());
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzbq();
        zzdd.checkNotNull(collection);
        if (!(collection instanceof zzcy)) {
            return super.addAll(collection);
        }
        zzcy zzcy = (zzcy) collection;
        if (zzcy.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzcy.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzcy.size;
        if (i > this.zzqo.length) {
            this.zzqo = Arrays.copyOf(this.zzqo, i);
        }
        System.arraycopy(zzcy.zzqo, 0, this.zzqo, this.size, zzcy.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcy)) {
            return super.equals(obj);
        }
        zzcy zzcy = (zzcy) obj;
        if (this.size != zzcy.size) {
            return false;
        }
        float[] fArr = zzcy.zzqo;
        for (int i = 0; i < this.size; i++) {
            if (this.zzqo[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final /* synthetic */ Object get(int i) {
        zzg(i);
        return Float.valueOf(this.zzqo[i]);
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzqo[i2]);
        }
        return i;
    }

    public final /* synthetic */ Object remove(int i) {
        zzbq();
        zzg(i);
        float f = this.zzqo[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzqo, i + 1, this.zzqo, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final boolean remove(Object obj) {
        zzbq();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzqo[i]))) {
                System.arraycopy(this.zzqo, i + 1, this.zzqo, i, this.size - i);
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
        System.arraycopy(this.zzqo, i2, this.zzqo, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzbq();
        zzg(i);
        float f = this.zzqo[i];
        this.zzqo[i] = floatValue;
        return Float.valueOf(f);
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    public final /* synthetic */ zzdg zzi(int i) {
        if (i >= this.size) {
            return new zzcy(Arrays.copyOf(this.zzqo, i), this.size);
        }
        throw new IllegalArgumentException();
    }
}
