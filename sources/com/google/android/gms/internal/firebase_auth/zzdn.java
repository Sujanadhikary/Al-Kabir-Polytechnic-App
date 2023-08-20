package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzdn<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzsg;

    public zzdn(Iterator<Map.Entry<K, Object>> it) {
        this.zzsg = it;
    }

    public final boolean hasNext() {
        return this.zzsg.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzsg.next();
        return next.getValue() instanceof zzdk ? new zzdm(next) : next;
    }

    public final void remove() {
        this.zzsg.remove();
    }
}
