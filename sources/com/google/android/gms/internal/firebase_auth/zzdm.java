package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

final class zzdm<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzdk> zzsf;

    private zzdm(Map.Entry<K, zzdk> entry) {
        this.zzsf = entry;
    }

    public final K getKey() {
        return this.zzsf.getKey();
    }

    public final Object getValue() {
        if (this.zzsf.getValue() == null) {
            return null;
        }
        return zzdk.zzej();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzeh) {
            return this.zzsf.getValue().zzi((zzeh) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzdk zzek() {
        return this.zzsf.getValue();
    }
}
