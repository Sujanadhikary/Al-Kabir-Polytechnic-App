package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;
import java.io.IOException;
import java.util.Arrays;

public final class zzfs {
    private static final zzfs zzvy = new zzfs(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzlx;
    private int zzqs;
    private Object[] zzte;
    private int[] zzvz;

    private zzfs() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfs(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzqs = -1;
        this.count = i;
        this.zzvz = iArr;
        this.zzte = objArr;
        this.zzlx = z;
    }

    static zzfs zza(zzfs zzfs, zzfs zzfs2) {
        int i = zzfs.count + zzfs2.count;
        int[] copyOf = Arrays.copyOf(zzfs.zzvz, i);
        System.arraycopy(zzfs2.zzvz, 0, copyOf, zzfs.count, zzfs2.count);
        Object[] copyOf2 = Arrays.copyOf(zzfs.zzte, i);
        System.arraycopy(zzfs2.zzte, 0, copyOf2, zzfs.count, zzfs2.count);
        return new zzfs(i, copyOf, copyOf2, true);
    }

    private static void zzb(int i, Object obj, zzgl zzgl) throws IOException {
        int i2 = i >>> 3;
        switch (i & 7) {
            case 0:
                zzgl.zzi(i2, ((Long) obj).longValue());
                return;
            case 1:
                zzgl.zzc(i2, ((Long) obj).longValue());
                return;
            case 2:
                zzgl.zza(i2, (zzbu) obj);
                return;
            case 3:
                if (zzgl.zzdc() == zzdb.zze.zzrj) {
                    zzgl.zzai(i2);
                    ((zzfs) obj).zzb(zzgl);
                    zzgl.zzaj(i2);
                    return;
                }
                zzgl.zzaj(i2);
                ((zzfs) obj).zzb(zzgl);
                zzgl.zzai(i2);
                return;
            case 5:
                zzgl.zzf(i2, ((Integer) obj).intValue());
                return;
            default:
                throw new RuntimeException(zzdh.zzef());
        }
    }

    public static zzfs zzgr() {
        return zzvy;
    }

    static zzfs zzgs() {
        return new zzfs();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfs = (zzfs) obj;
        if (this.count == zzfs.count) {
            int[] iArr = this.zzvz;
            int[] iArr2 = zzfs.zzvz;
            int i = this.count;
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
                Object[] objArr = this.zzte;
                Object[] objArr2 = zzfs.zzte;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
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
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        int i2 = (this.count + 527) * 31;
        int[] iArr = this.zzvz;
        int i3 = this.count;
        int i4 = 17;
        for (int i5 = 0; i5 < i3; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzte;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i = (i * 31) + objArr[i8].hashCode();
        }
        return i6 + i;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgl zzgl) throws IOException {
        if (zzgl.zzdc() == zzdb.zze.zzrk) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzgl.zza(this.zzvz[i] >>> 3, this.zzte[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzgl.zza(this.zzvz[i2] >>> 3, this.zzte[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzek.zza(sb, i, String.valueOf(this.zzvz[i2] >>> 3), this.zzte[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (!this.zzlx) {
            throw new UnsupportedOperationException();
        }
        if (this.count == this.zzvz.length) {
            int i2 = (this.count < 4 ? 8 : this.count >> 1) + this.count;
            this.zzvz = Arrays.copyOf(this.zzvz, i2);
            this.zzte = Arrays.copyOf(this.zzte, i2);
        }
        this.zzvz[this.count] = i;
        this.zzte[this.count] = obj;
        this.count++;
    }

    public final void zzb(zzgl zzgl) throws IOException {
        if (this.count != 0) {
            if (zzgl.zzdc() == zzdb.zze.zzrj) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzvz[i], this.zzte[i], zzgl);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzvz[i2], this.zzte[i2], zzgl);
            }
        }
    }

    public final void zzbp() {
        this.zzlx = false;
    }

    public final int zzdn() {
        int zzdn;
        int i = this.zzqs;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                int i3 = this.zzvz[i2];
                int i4 = i3 >>> 3;
                switch (i3 & 7) {
                    case 0:
                        zzdn = zzci.zze(i4, ((Long) this.zzte[i2]).longValue());
                        break;
                    case 1:
                        zzdn = zzci.zzg(i4, ((Long) this.zzte[i2]).longValue());
                        break;
                    case 2:
                        zzdn = zzci.zzc(i4, (zzbu) this.zzte[i2]);
                        break;
                    case 3:
                        zzdn = ((zzfs) this.zzte[i2]).zzdn() + (zzci.zzz(i4) << 1);
                        break;
                    case 5:
                        zzdn = zzci.zzj(i4, ((Integer) this.zzte[i2]).intValue());
                        break;
                    default:
                        throw new IllegalStateException(zzdh.zzef());
                }
                i += zzdn;
            }
            this.zzqs = i;
        }
        return i;
    }

    public final int zzgt() {
        int i = this.zzqs;
        if (i == -1) {
            i = 0;
            for (int i2 = 0; i2 < this.count; i2++) {
                i += zzci.zzd(this.zzvz[i2] >>> 3, (zzbu) this.zzte[i2]);
            }
            this.zzqs = i;
        }
        return i;
    }
}
