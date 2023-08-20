package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzfu extends AbstractList<String> implements zzdq, RandomAccess {
    /* access modifiers changed from: private */
    public final zzdq zzwa;

    public zzfu(zzdq zzdq) {
        this.zzwa = zzdq;
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzwa.get(i);
    }

    public final Object getRaw(int i) {
        return this.zzwa.getRaw(i);
    }

    public final Iterator<String> iterator() {
        return new zzfw(this);
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzfv(this, i);
    }

    public final int size() {
        return this.zzwa.size();
    }

    public final void zzc(zzbu zzbu) {
        throw new UnsupportedOperationException();
    }

    public final List<?> zzel() {
        return this.zzwa.zzel();
    }

    public final zzdq zzem() {
        return this;
    }
}
