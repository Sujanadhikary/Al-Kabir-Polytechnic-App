package com.google.firebase.database.collection;

import java.util.Iterator;

final class zzg implements Iterator<zzh> {
    private int zzy = (this.zzz.length - 1);
    private final /* synthetic */ zzf zzz;

    zzg(zzf zzf) {
        this.zzz = zzf;
    }

    public final boolean hasNext() {
        return this.zzy >= 0;
    }

    public final /* synthetic */ Object next() {
        boolean z = true;
        zzh zzh = new zzh();
        if ((this.zzz.value & ((long) (1 << this.zzy))) != 0) {
            z = false;
        }
        zzh.zzaa = z;
        zzh.zzab = (int) Math.pow(2.0d, (double) this.zzy);
        this.zzy--;
        return zzh;
    }

    public final void remove() {
    }
}
