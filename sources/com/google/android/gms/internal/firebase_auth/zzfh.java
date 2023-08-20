package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

final class zzfh implements Comparable<zzfh>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzfa zzvm;
    private final K zzvp;

    zzfh(zzfa zzfa, K k, V v) {
        this.zzvm = zzfa;
        this.zzvp = k;
        this.value = v;
    }

    zzfh(zzfa zzfa, Map.Entry<K, V> entry) {
        this(zzfa, (Comparable) entry.getKey(), entry.getValue());
    }

    private static boolean equals(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzfh) obj).getKey());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzvp, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final /* synthetic */ Object getKey() {
        return this.zzvp;
    }

    public final V getValue() {
        return this.value;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzvp == null ? 0 : this.zzvp.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final V setValue(V v) {
        this.zzvm.zzgj();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzvp);
        String valueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }
}
