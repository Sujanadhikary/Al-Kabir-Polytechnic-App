package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzcu;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzcs<FieldDescriptorType extends zzcu<FieldDescriptorType>> {
    private static final zzcs zznx = new zzcs(true);
    private final zzfa<FieldDescriptorType, Object> zznu = zzfa.zzat(16);
    private boolean zznv;
    private boolean zznw = false;

    private zzcs() {
    }

    private zzcs(boolean z) {
        zzbp();
    }

    static int zza(zzgf zzgf, int i, Object obj) {
        int i2;
        int zzz = zzci.zzz(i);
        if (zzgf == zzgf.GROUP) {
            zzdd.zzf((zzeh) obj);
            i2 = zzz << 1;
        } else {
            i2 = zzz;
        }
        return i2 + zzb(zzgf, obj);
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zznu.get(fielddescriptortype);
        return obj instanceof zzdk ? zzdk.zzej() : obj;
    }

    static void zza(zzci zzci, zzgf zzgf, int i, Object obj) throws IOException {
        if (zzgf == zzgf.GROUP) {
            zzdd.zzf((zzeh) obj);
            zzci.zzb(i, 3);
            ((zzeh) obj).zzb(zzci);
            zzci.zzb(i, 4);
            return;
        }
        zzci.zzb(i, zzgf.zzhc());
        switch (zzgf) {
            case DOUBLE:
                zzci.zza(((Double) obj).doubleValue());
                return;
            case FLOAT:
                zzci.zza(((Float) obj).floatValue());
                return;
            case INT64:
                zzci.zza(((Long) obj).longValue());
                return;
            case UINT64:
                zzci.zza(((Long) obj).longValue());
                return;
            case INT32:
                zzci.zzv(((Integer) obj).intValue());
                return;
            case FIXED64:
                zzci.zzc(((Long) obj).longValue());
                return;
            case FIXED32:
                zzci.zzy(((Integer) obj).intValue());
                return;
            case BOOL:
                zzci.zzg(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((zzeh) obj).zzb(zzci);
                return;
            case MESSAGE:
                zzci.zzb((zzeh) obj);
                return;
            case STRING:
                if (obj instanceof zzbu) {
                    zzci.zza((zzbu) obj);
                    return;
                } else {
                    zzci.zzal((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof zzbu) {
                    zzci.zza((zzbu) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzci.zze(bArr, 0, bArr.length);
                return;
            case UINT32:
                zzci.zzw(((Integer) obj).intValue());
                return;
            case SFIXED32:
                zzci.zzy(((Integer) obj).intValue());
                return;
            case SFIXED64:
                zzci.zzc(((Long) obj).longValue());
                return;
            case SINT32:
                zzci.zzx(((Integer) obj).intValue());
                return;
            case SINT64:
                zzci.zzb(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof zzde) {
                    zzci.zzv(((zzde) obj).zzdp());
                    return;
                } else {
                    zzci.zzv(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
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
            boolean r0 = r7.zzds()
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
            com.google.android.gms.internal.firebase_auth.zzgf r5 = r7.zzdq()
            zza((com.google.android.gms.internal.firebase_auth.zzgf) r5, (java.lang.Object) r4)
            goto L_0x0024
        L_0x0034:
            com.google.android.gms.internal.firebase_auth.zzgf r0 = r7.zzdq()
            zza((com.google.android.gms.internal.firebase_auth.zzgf) r0, (java.lang.Object) r8)
            r1 = r8
        L_0x003c:
            boolean r0 = r1 instanceof com.google.android.gms.internal.firebase_auth.zzdk
            if (r0 == 0) goto L_0x0043
            r0 = 1
            r6.zznw = r0
        L_0x0043:
            com.google.android.gms.internal.firebase_auth.zzfa<FieldDescriptorType, java.lang.Object> r0 = r6.zznu
            r0.put(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcs.zza(com.google.android.gms.internal.firebase_auth.zzcu, java.lang.Object):void");
    }

    private static void zza(zzgf zzgf, Object obj) {
        boolean z = false;
        zzdd.checkNotNull(obj);
        switch (zzgf.zzhb()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if ((obj instanceof zzbu) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case ENUM:
                if ((obj instanceof Integer) || (obj instanceof zzde)) {
                    z = true;
                    break;
                }
            case MESSAGE:
                if ((obj instanceof zzeh) || (obj instanceof zzdk)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static int zzb(zzcu<?> zzcu, Object obj) {
        int i = 0;
        zzgf zzdq = zzcu.zzdq();
        int zzdp = zzcu.zzdp();
        if (!zzcu.zzds()) {
            return zza(zzdq, zzdp, obj);
        }
        if (zzcu.zzdt()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzdq, zzb);
            }
            return zzci.zzah(i) + zzci.zzz(zzdp) + i;
        }
        for (Object zza : (List) obj) {
            i += zza(zzdq, zzdp, zza);
        }
        return i;
    }

    private static int zzb(zzgf zzgf, Object obj) {
        switch (zzgf) {
            case DOUBLE:
                return zzci.zzb(((Double) obj).doubleValue());
            case FLOAT:
                return zzci.zzb(((Float) obj).floatValue());
            case INT64:
                return zzci.zzd(((Long) obj).longValue());
            case UINT64:
                return zzci.zze(((Long) obj).longValue());
            case INT32:
                return zzci.zzaa(((Integer) obj).intValue());
            case FIXED64:
                return zzci.zzg(((Long) obj).longValue());
            case FIXED32:
                return zzci.zzad(((Integer) obj).intValue());
            case BOOL:
                return zzci.zzh(((Boolean) obj).booleanValue());
            case GROUP:
                return zzci.zzd((zzeh) obj);
            case MESSAGE:
                return obj instanceof zzdk ? zzci.zza((zzdo) (zzdk) obj) : zzci.zzc((zzeh) obj);
            case STRING:
                return obj instanceof zzbu ? zzci.zzb((zzbu) obj) : zzci.zzam((String) obj);
            case BYTES:
                return obj instanceof zzbu ? zzci.zzb((zzbu) obj) : zzci.zzc((byte[]) obj);
            case UINT32:
                return zzci.zzab(((Integer) obj).intValue());
            case SFIXED32:
                return zzci.zzae(((Integer) obj).intValue());
            case SFIXED64:
                return zzci.zzh(((Long) obj).longValue());
            case SINT32:
                return zzci.zzac(((Integer) obj).intValue());
            case SINT64:
                return zzci.zzf(((Long) obj).longValue());
            case ENUM:
                return obj instanceof zzde ? zzci.zzaf(((zzde) obj).zzdp()) : zzci.zzaf(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        zzcu zzcu = (zzcu) entry.getKey();
        if (zzcu.zzdr() == zzgk.MESSAGE) {
            if (zzcu.zzds()) {
                for (zzeh isInitialized : (List) entry.getValue()) {
                    if (!isInitialized.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzeh) {
                    if (!((zzeh) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzdk) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzcu zzcu = (zzcu) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdk) {
            value = zzdk.zzej();
        }
        if (zzcu.zzds()) {
            Object zza = zza(zzcu);
            if (zza == null) {
                zza = new ArrayList();
            }
            for (Object zzf : (List) value) {
                ((List) zza).add(zzf(zzf));
            }
            this.zznu.put(zzcu, zza);
        } else if (zzcu.zzdr() == zzgk.MESSAGE) {
            Object zza2 = zza(zzcu);
            if (zza2 == null) {
                this.zznu.put(zzcu, zzf(value));
            } else {
                this.zznu.put(zzcu, zza2 instanceof zzen ? zzcu.zza((zzen) zza2, (zzen) value) : zzcu.zza(((zzeh) zza2).zzdw(), (zzeh) value).zzea());
            }
        } else {
            this.zznu.put(zzcu, zzf(value));
        }
    }

    private static int zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzcu zzcu = (zzcu) entry.getKey();
        Object value = entry.getValue();
        return (zzcu.zzdr() != zzgk.MESSAGE || zzcu.zzds() || zzcu.zzdt()) ? zzb((zzcu<?>) zzcu, value) : value instanceof zzdk ? zzci.zzb(((zzcu) entry.getKey()).zzdp(), (zzdo) (zzdk) value) : zzci.zzd(((zzcu) entry.getKey()).zzdp(), (zzeh) value);
    }

    public static <T extends zzcu<T>> zzcs<T> zzdm() {
        return zznx;
    }

    private static Object zzf(Object obj) {
        if (obj instanceof zzen) {
            return ((zzen) obj).zzez();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzcs zzcs = new zzcs();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zznu.zzgg()) {
                break;
            }
            Map.Entry<FieldDescriptorType, Object> zzau = this.zznu.zzau(i2);
            zzcs.zza((zzcu) zzau.getKey(), zzau.getValue());
            i = i2 + 1;
        }
        for (Map.Entry next : this.zznu.zzgh()) {
            zzcs.zza((zzcu) next.getKey(), next.getValue());
        }
        zzcs.zznw = this.zznw;
        return zzcs;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        return this.zznw ? new zzdn(this.zznu.zzgi().iterator()) : this.zznu.zzgi().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcs)) {
            return false;
        }
        return this.zznu.equals(((zzcs) obj).zznu);
    }

    public final int hashCode() {
        return this.zznu.hashCode();
    }

    /* access modifiers changed from: package-private */
    public final boolean isEmpty() {
        return this.zznu.isEmpty();
    }

    public final boolean isImmutable() {
        return this.zznv;
    }

    public final boolean isInitialized() {
        for (int i = 0; i < this.zznu.zzgg(); i++) {
            if (!zzb(this.zznu.zzau(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb : this.zznu.zzgh()) {
            if (!zzb(zzb)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        return this.zznw ? new zzdn(this.zznu.entrySet().iterator()) : this.zznu.entrySet().iterator();
    }

    public final void zza(zzcs<FieldDescriptorType> zzcs) {
        for (int i = 0; i < zzcs.zznu.zzgg(); i++) {
            zzc(zzcs.zznu.zzau(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzc : zzcs.zznu.zzgh()) {
            zzc(zzc);
        }
    }

    public final void zzbp() {
        if (!this.zznv) {
            this.zznu.zzbp();
            this.zznv = true;
        }
    }

    public final int zzdn() {
        int i = 0;
        for (int i2 = 0; i2 < this.zznu.zzgg(); i2++) {
            Map.Entry<FieldDescriptorType, Object> zzau = this.zznu.zzau(i2);
            i += zzb((zzcu<?>) (zzcu) zzau.getKey(), zzau.getValue());
        }
        for (Map.Entry next : this.zznu.zzgh()) {
            i += zzb((zzcu<?>) (zzcu) next.getKey(), next.getValue());
        }
        return i;
    }

    public final int zzdo() {
        int i = 0;
        for (int i2 = 0; i2 < this.zznu.zzgg(); i2++) {
            i += zzd(this.zznu.zzau(i2));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzd : this.zznu.zzgh()) {
            i += zzd(zzd);
        }
        return i;
    }
}
