package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzfj extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzfa zzvm;

    private zzfj(zzfa zzfa) {
        this.zzvm = zzfa;
    }

    /* synthetic */ zzfj(zzfa zzfa, zzfb zzfb) {
        this(zzfa);
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzvm.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    public void clear() {
        this.zzvm.clear();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzvm.get(entry.getKey());
        Object value = entry.getValue();
        return obj2 == value || (obj2 != null && obj2.equals(value));
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzfi(this.zzvm, (zzfb) null);
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzvm.remove(entry.getKey());
        return true;
    }

    public int size() {
        return this.zzvm.size();
    }
}
