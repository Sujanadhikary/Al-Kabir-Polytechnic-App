package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzgs implements Cloneable {
    private Object value;
    private zzgq<?, ?> zzyt;
    private List<zzgx> zzyu = new ArrayList();

    zzgs() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzb()];
        zza(zzgn.zzf(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzhg */
    public final zzgs clone() {
        int i = 0;
        zzgs zzgs = new zzgs();
        try {
            zzgs.zzyt = this.zzyt;
            if (this.zzyu == null) {
                zzgs.zzyu = null;
            } else {
                zzgs.zzyu.addAll(this.zzyu);
            }
            if (this.value != null) {
                if (this.value instanceof zzgv) {
                    zzgs.value = (zzgv) ((zzgv) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzgs.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzgs.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzgs.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzgs.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzgs.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzgs.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzgs.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzgv[]) {
                    zzgv[] zzgvArr = (zzgv[]) this.value;
                    zzgv[] zzgvArr2 = new zzgv[zzgvArr.length];
                    zzgs.value = zzgvArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzgvArr.length) {
                            break;
                        }
                        zzgvArr2[i3] = (zzgv) zzgvArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzgs;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgs)) {
            return false;
        }
        zzgs zzgs = (zzgs) obj;
        if (this.value == null || zzgs.value == null) {
            if (this.zzyu != null && zzgs.zzyu != null) {
                return this.zzyu.equals(zzgs.zzyu);
            }
            try {
                return Arrays.equals(toByteArray(), zzgs.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzyt == zzgs.zzyt) {
            return !this.zzyt.zzyo.isArray() ? this.value.equals(zzgs.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzgs.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzgs.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzgs.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzgs.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzgs.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzgs.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzgs.value);
        } else {
            return false;
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgn zzgn) throws IOException {
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        for (zzgx next : this.zzyu) {
            zzgn.zzba(next.tag);
            zzgn.zzg(next.zzmj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgx zzgx) throws IOException {
        if (this.zzyu != null) {
            this.zzyu.add(zzgx);
        } else if (this.value instanceof zzgv) {
            byte[] bArr = zzgx.zzmj;
            zzgm zzi = zzgm.zzi(bArr, 0, bArr.length);
            int zzcr = zzi.zzcr();
            if (zzcr != bArr.length - zzgn.zzaa(zzcr)) {
                throw zzgu.zzhh();
            }
            zzgv zza = ((zzgv) this.value).zza(zzi);
            this.zzyt = this.zzyt;
            this.value = zza;
            this.zzyu = null;
        } else if (this.value instanceof zzgv[]) {
            Collections.singletonList(zzgx);
            throw new NoSuchMethodError();
        } else {
            Collections.singletonList(zzgx);
            throw new NoSuchMethodError();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzb() {
        int i = 0;
        if (this.value != null) {
            throw new NoSuchMethodError();
        }
        Iterator<zzgx> it = this.zzyu.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            zzgx next = it.next();
            i = next.zzmj.length + zzgn.zzah(next.tag) + 0 + i2;
        }
    }
}
