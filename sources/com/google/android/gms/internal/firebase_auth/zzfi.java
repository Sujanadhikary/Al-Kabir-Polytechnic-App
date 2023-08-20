package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzfi implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzvl;
    private final /* synthetic */ zzfa zzvm;
    private boolean zzvq;

    private zzfi(zzfa zzfa) {
        this.zzvm = zzfa;
        this.pos = -1;
    }

    /* synthetic */ zzfi(zzfa zzfa, zzfb zzfb) {
        this(zzfa);
    }

    private final Iterator<Map.Entry<K, V>> zzgl() {
        if (this.zzvl == null) {
            this.zzvl = this.zzvm.zzvh.entrySet().iterator();
        }
        return this.zzvl;
    }

    public final boolean hasNext() {
        return this.pos + 1 < this.zzvm.zzvg.size() || (!this.zzvm.zzvh.isEmpty() && zzgl().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzvq = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzvm.zzvg.size() ? (Map.Entry) this.zzvm.zzvg.get(this.pos) : (Map.Entry) zzgl().next();
    }

    public final void remove() {
        if (!this.zzvq) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzvq = false;
        this.zzvm.zzgj();
        if (this.pos < this.zzvm.zzvg.size()) {
            zzfa zzfa = this.zzvm;
            int i = this.pos;
            this.pos = i - 1;
            Object unused = zzfa.zzav(i);
            return;
        }
        zzgl().remove();
    }
}
