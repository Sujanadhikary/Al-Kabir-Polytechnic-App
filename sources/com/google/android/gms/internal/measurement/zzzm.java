package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzzo;
import java.util.Iterator;
import java.util.Map;

final class zzzm<FieldDescriptorType extends zzzo<FieldDescriptorType>> {
    private static final zzzm zzbru = new zzzm(true);
    private boolean zzbls;
    private final zzaay<FieldDescriptorType, Object> zzbrs = zzaay.zzag(16);
    private boolean zzbrt = false;

    private zzzm() {
    }

    private zzzm(boolean z) {
        if (!this.zzbls) {
            this.zzbrs.zzrg();
            this.zzbls = true;
        }
    }

    private static void zza(zzabp zzabp, Object obj) {
        boolean z = false;
        zzzr.checkNotNull(obj);
        switch (zzzn.zzbrv[zzabp.zzuv().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzyw) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzzs)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzaal) || (obj instanceof zzzu)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(FieldDescriptorType r7, java.lang.Object r8) {
        /*
            r6 = this;
            boolean r0 = r7.zztk()
            if (r0 == 0) goto L_0x0034
            boolean r0 = r8 instanceof java.util.List
            if (r0 != 0) goto L_0x0012
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Wrong object type used with protocol message reflection."
            r0.<init>(r1)
            throw r0
        L_0x0012:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r8 = (java.util.List) r8
            r1.addAll(r8)
            r0 = r1
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r3 = r0.size()
            r2 = 0
        L_0x0024:
            if (r2 >= r3) goto L_0x003c
            java.lang.Object r4 = r0.get(r2)
            int r2 = r2 + 1
            com.google.android.gms.internal.measurement.zzabp r5 = r7.zztj()
            zza((com.google.android.gms.internal.measurement.zzabp) r5, (java.lang.Object) r4)
            goto L_0x0024
        L_0x0034:
            com.google.android.gms.internal.measurement.zzabp r0 = r7.zztj()
            zza((com.google.android.gms.internal.measurement.zzabp) r0, (java.lang.Object) r8)
            r1 = r8
        L_0x003c:
            boolean r0 = r1 instanceof com.google.android.gms.internal.measurement.zzzu
            if (r0 == 0) goto L_0x0043
            r0 = 1
            r6.zzbrt = r0
        L_0x0043:
            com.google.android.gms.internal.measurement.zzaay<FieldDescriptorType, java.lang.Object> r0 = r6.zzbrs
            r0.put(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzzm.zza(com.google.android.gms.internal.measurement.zzzo, java.lang.Object):void");
    }

    public static <T extends zzzo<T>> zzzm<T> zzti() {
        return zzbru;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzzm zzzm = new zzzm();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzbrs.zzuj()) {
                break;
            }
            Map.Entry<FieldDescriptorType, Object> zzah = this.zzbrs.zzah(i2);
            zzzm.zza((zzzo) zzah.getKey(), zzah.getValue());
            i = i2 + 1;
        }
        for (Map.Entry next : this.zzbrs.zzuk()) {
            zzzm.zza((zzzo) next.getKey(), next.getValue());
        }
        zzzm.zzbrt = this.zzbrt;
        return zzzm;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzzm)) {
            return false;
        }
        return this.zzbrs.equals(((zzzm) obj).zzbrs);
    }

    public final int hashCode() {
        return this.zzbrs.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzbrt ? new zzzx(this.zzbrs.entrySet().iterator()) : this.zzbrs.entrySet().iterator();
    }
}
