package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbv implements Iterator {
    private final int limit = this.zzmf.size();
    private int position = 0;
    private final /* synthetic */ zzbu zzmf;

    zzbv(zzbu zzbu) {
        this.zzmf = zzbu;
    }

    private final byte nextByte() {
        try {
            zzbu zzbu = this.zzmf;
            int i = this.position;
            this.position = i + 1;
            return zzbu.zzj(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
