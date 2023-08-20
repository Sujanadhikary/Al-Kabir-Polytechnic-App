package com.google.android.gms.internal.firebase_database;

import java.util.Iterator;
import java.util.Map;

final class zzij implements Iterator<zziz> {
    private final Iterator<Map.Entry<zzid, zzja>> zzrj;

    public zzij(Iterator<Map.Entry<zzid, zzja>> it) {
        this.zzrj = it;
    }

    public final boolean hasNext() {
        return this.zzrj.hasNext();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzrj.next();
        return new zziz((zzid) next.getKey(), (zzja) next.getValue());
    }

    public final void remove() {
        this.zzrj.remove();
    }
}
