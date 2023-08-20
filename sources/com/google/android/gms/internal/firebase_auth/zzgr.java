package com.google.android.gms.internal.firebase_auth;

public final class zzgr implements Cloneable {
    private static final zzgs zzyp = new zzgs();
    private int mSize;
    private boolean zzyq;
    private int[] zzyr;
    private zzgs[] zzys;

    zzgr() {
        this(10);
    }

    private zzgr(int i) {
        this.zzyq = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzyr = new int[idealIntArraySize];
        this.zzys = new zzgs[idealIntArraySize];
        this.mSize = 0;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            } else if (i2 <= (1 << i3) - 12) {
                i2 = (1 << i3) - 12;
                break;
            } else {
                i3++;
            }
        }
        return i2 / 4;
    }

    private final int zzbd(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.zzyr[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzgr zzgr = new zzgr(i);
        System.arraycopy(this.zzyr, 0, zzgr.zzyr, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            if (this.zzys[i2] != null) {
                zzgr.zzys[i2] = (zzgs) this.zzys[i2].clone();
            }
        }
        zzgr.mSize = i;
        return zzgr;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgr)) {
            return false;
        }
        zzgr zzgr = (zzgr) obj;
        if (this.mSize != zzgr.mSize) {
            return false;
        }
        int[] iArr = this.zzyr;
        int[] iArr2 = zzgr.zzyr;
        int i = this.mSize;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzgs[] zzgsArr = this.zzys;
            zzgs[] zzgsArr2 = zzgr.zzys;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzgsArr[i4].equals(zzgsArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzyr[i2]) * 31) + this.zzys[i2].hashCode();
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzgs zzgs) {
        int zzbd = zzbd(i);
        if (zzbd >= 0) {
            this.zzys[zzbd] = zzgs;
            return;
        }
        int i2 = zzbd ^ -1;
        if (i2 >= this.mSize || this.zzys[i2] != zzyp) {
            if (this.mSize >= this.zzyr.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzgs[] zzgsArr = new zzgs[idealIntArraySize];
                System.arraycopy(this.zzyr, 0, iArr, 0, this.zzyr.length);
                System.arraycopy(this.zzys, 0, zzgsArr, 0, this.zzys.length);
                this.zzyr = iArr;
                this.zzys = zzgsArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.zzyr, i2, this.zzyr, i2 + 1, this.mSize - i2);
                System.arraycopy(this.zzys, i2, this.zzys, i2 + 1, this.mSize - i2);
            }
            this.zzyr[i2] = i;
            this.zzys[i2] = zzgs;
            this.mSize++;
            return;
        }
        this.zzyr[i2] = i;
        this.zzys[i2] = zzgs;
    }

    /* access modifiers changed from: package-private */
    public final zzgs zzbb(int i) {
        int zzbd = zzbd(i);
        if (zzbd < 0 || this.zzys[zzbd] == zzyp) {
            return null;
        }
        return this.zzys[zzbd];
    }

    /* access modifiers changed from: package-private */
    public final zzgs zzbc(int i) {
        return this.zzys[i];
    }
}
