package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class zzeb<K, V> extends LinkedHashMap<K, V> {
    private static final zzeb zzsz;
    private boolean zzlx = true;

    static {
        zzeb zzeb = new zzeb();
        zzsz = zzeb;
        zzeb.zzlx = false;
    }

    private zzeb() {
    }

    private zzeb(Map<K, V> map) {
        super(map);
    }

    public static <K, V> zzeb<K, V> zzeq() {
        return zzsz;
    }

    private final void zzes() {
        if (!this.zzlx) {
            throw new UnsupportedOperationException();
        }
    }

    private static int zzh(Object obj) {
        if (obj instanceof byte[]) {
            return zzdd.hashCode((byte[]) obj);
        }
        if (!(obj instanceof zzde)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        zzes();
        super.clear();
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r3 = 1
            r4 = 0
            boolean r0 = r7 instanceof java.util.Map
            if (r0 == 0) goto L_0x0062
            java.util.Map r7 = (java.util.Map) r7
            if (r6 == r7) goto L_0x0060
            int r0 = r6.size()
            int r1 = r7.size()
            if (r0 == r1) goto L_0x0019
            r0 = r4
        L_0x0015:
            if (r0 == 0) goto L_0x0062
            r0 = r3
        L_0x0018:
            return r0
        L_0x0019:
            java.util.Set r0 = r6.entrySet()
            java.util.Iterator r5 = r0.iterator()
        L_0x0021:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0060
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            boolean r1 = r7.containsKey(r1)
            if (r1 != 0) goto L_0x0039
            r0 = r4
            goto L_0x0015
        L_0x0039:
            java.lang.Object r1 = r0.getValue()
            java.lang.Object r0 = r0.getKey()
            java.lang.Object r2 = r7.get(r0)
            boolean r0 = r1 instanceof byte[]
            if (r0 == 0) goto L_0x005b
            boolean r0 = r2 instanceof byte[]
            if (r0 == 0) goto L_0x005b
            r0 = r1
            byte[] r0 = (byte[]) r0
            r1 = r2
            byte[] r1 = (byte[]) r1
            boolean r0 = java.util.Arrays.equals(r0, r1)
        L_0x0057:
            if (r0 != 0) goto L_0x0021
            r0 = r4
            goto L_0x0015
        L_0x005b:
            boolean r0 = r1.equals(r2)
            goto L_0x0057
        L_0x0060:
            r0 = r3
            goto L_0x0015
        L_0x0062:
            r0 = r4
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzeb.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i = 0;
        Iterator it = entrySet().iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            Map.Entry entry = (Map.Entry) it.next();
            i = (zzh(entry.getValue()) ^ zzh(entry.getKey())) + i2;
        }
    }

    public final boolean isMutable() {
        return this.zzlx;
    }

    public final V put(K k, V v) {
        zzes();
        zzdd.checkNotNull(k);
        zzdd.checkNotNull(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzes();
        for (Object next : map.keySet()) {
            zzdd.checkNotNull(next);
            zzdd.checkNotNull(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzes();
        return super.remove(obj);
    }

    public final void zza(zzeb<K, V> zzeb) {
        zzes();
        if (!zzeb.isEmpty()) {
            putAll(zzeb);
        }
    }

    public final void zzbp() {
        this.zzlx = false;
    }

    public final zzeb<K, V> zzer() {
        return isEmpty() ? new zzeb<>() : new zzeb<>(this);
    }
}
