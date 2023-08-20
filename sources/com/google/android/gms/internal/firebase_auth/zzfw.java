package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;

final class zzfw implements Iterator<String> {
    private final /* synthetic */ zzfu zzwd;
    private Iterator<String> zzwe = this.zzwd.zzwa.iterator();

    zzfw(zzfu zzfu) {
        this.zzwd = zzfu;
    }

    public final boolean hasNext() {
        return this.zzwe.hasNext();
    }

    public final /* synthetic */ Object next() {
        return this.zzwe.next();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
