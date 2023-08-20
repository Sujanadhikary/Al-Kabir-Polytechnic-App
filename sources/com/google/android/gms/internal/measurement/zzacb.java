package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzacb implements Cloneable {
    private Object value;
    private zzabz<?, ?> zzbxe;
    private List<zzacg> zzbxf = new ArrayList();

    zzacb() {
    }

    private final byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zza()];
        zza(zzabw.zzj(bArr));
        return bArr;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzvg */
    public final zzacb clone() {
        int i = 0;
        zzacb zzacb = new zzacb();
        try {
            zzacb.zzbxe = this.zzbxe;
            if (this.zzbxf == null) {
                zzacb.zzbxf = null;
            } else {
                zzacb.zzbxf.addAll(this.zzbxf);
            }
            if (this.value != null) {
                if (this.value instanceof zzace) {
                    zzacb.value = (zzace) ((zzace) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzacb.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzacb.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzacb.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzacb.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzacb.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzacb.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzacb.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzace[]) {
                    zzace[] zzaceArr = (zzace[]) this.value;
                    zzace[] zzaceArr2 = new zzace[zzaceArr.length];
                    zzacb.value = zzaceArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzaceArr.length) {
                            break;
                        }
                        zzaceArr2[i3] = (zzace) zzaceArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzacb;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzacb)) {
            return false;
        }
        zzacb zzacb = (zzacb) obj;
        if (this.value == null || zzacb.value == null) {
            if (this.zzbxf != null && zzacb.zzbxf != null) {
                return this.zzbxf.equals(zzacb.zzbxf);
            }
            try {
                return Arrays.equals(toByteArray(), zzacb.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.zzbxe == zzacb.zzbxe) {
            return !this.zzbxe.zzbwx.isArray() ? this.value.equals(zzacb.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzacb.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzacb.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzacb.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzacb.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzacb.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzacb.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzacb.value);
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
    public final int zza() {
        int i = 0;
        if (this.value != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            Object obj = this.value;
            if (!zzabz.zzbwy) {
                return zzabz.zzv(obj);
            }
            int length = Array.getLength(obj);
            for (int i2 = 0; i2 < length; i2++) {
                if (Array.get(obj, i2) != null) {
                    i += zzabz.zzv(Array.get(obj, i2));
                }
            }
            return i;
        }
        Iterator<zzacg> it = this.zzbxf.iterator();
        while (true) {
            int i3 = i;
            if (!it.hasNext()) {
                return i3;
            }
            zzacg next = it.next();
            i = next.zzbrc.length + zzabw.zzas(next.tag) + 0 + i3;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzabw zzabw) throws IOException {
        if (this.value != null) {
            zzabz<?, ?> zzabz = this.zzbxe;
            Object obj = this.value;
            if (zzabz.zzbwy) {
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    Object obj2 = Array.get(obj, i);
                    if (obj2 != null) {
                        zzabz.zza(obj2, zzabw);
                    }
                }
                return;
            }
            zzabz.zza(obj, zzabw);
            return;
        }
        for (zzacg next : this.zzbxf) {
            zzabw.zzar(next.tag);
            zzabw.zzk(next.zzbrc);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzacg zzacg) throws IOException {
        Object zzi;
        if (this.zzbxf != null) {
            this.zzbxf.add(zzacg);
            return;
        }
        if (this.value instanceof zzace) {
            byte[] bArr = zzacg.zzbrc;
            zzabv zza = zzabv.zza(bArr, 0, bArr.length);
            int zzuy = zza.zzuy();
            if (zzuy != bArr.length - zzabw.zzao(zzuy)) {
                throw zzacd.zzvh();
            }
            zzi = ((zzace) this.value).zzb(zza);
        } else if (this.value instanceof zzace[]) {
            zzace[] zzaceArr = (zzace[]) this.zzbxe.zzi(Collections.singletonList(zzacg));
            zzace[] zzaceArr2 = (zzace[]) this.value;
            zzi = (zzace[]) Arrays.copyOf(zzaceArr2, zzaceArr2.length + zzaceArr.length);
            System.arraycopy(zzaceArr, 0, zzi, zzaceArr2.length, zzaceArr.length);
        } else {
            zzi = this.zzbxe.zzi(Collections.singletonList(zzacg));
        }
        this.zzbxe = this.zzbxe;
        this.value = zzi;
        this.zzbxf = null;
    }

    /* access modifiers changed from: package-private */
    public final <T> T zzb(zzabz<?, T> zzabz) {
        if (this.value == null) {
            this.zzbxe = zzabz;
            this.value = zzabz.zzi(this.zzbxf);
            this.zzbxf = null;
        } else if (!this.zzbxe.equals(zzabz)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }
}
