package com.google.android.gms.internal.firebase_auth;

import java.util.ListIterator;

final class zzfv implements ListIterator<String> {
    private ListIterator<String> zzwb = this.zzwd.zzwa.listIterator(this.zzwc);
    private final /* synthetic */ int zzwc;
    private final /* synthetic */ zzfu zzwd;

    zzfv(zzfu zzfu, int i) {
        this.zzwd = zzfu;
        this.zzwc = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzwb.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzwb.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzwb.next();
    }

    public final int nextIndex() {
        return this.zzwb.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzwb.previous();
    }

    public final int previousIndex() {
        return this.zzwb.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
