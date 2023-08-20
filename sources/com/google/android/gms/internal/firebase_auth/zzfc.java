package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzfc implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzvl;
    private final /* synthetic */ zzfa zzvm;

    private zzfc(zzfa zzfa) {
        this.zzvm = zzfa;
        this.pos = this.zzvm.zzvg.size();
    }

    /* synthetic */ zzfc(zzfa zzfa, zzfb zzfb) {
        this(zzfa);
    }

    private final Iterator<Map.Entry<K, V>> zzgl() {
        if (this.zzvl == null) {
            this.zzvl = this.zzvm.zzvj.entrySet().iterator();
        }
        return this.zzvl;
    }

    public final boolean hasNext() {
        return (this.pos > 0 && this.pos <= this.zzvm.zzvg.size()) || zzgl().hasNext();
    }

    public final /* synthetic */ Object next() {
        if (zzgl().hasNext()) {
            return (Map.Entry) zzgl().next();
        }
        List zzb = this.zzvm.zzvg;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
