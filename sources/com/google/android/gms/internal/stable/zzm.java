package com.google.android.gms.internal.stable;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzm {
    private final ConcurrentHashMap<zzn, List<Throwable>> zzahj = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzahk = new ReferenceQueue<>();

    zzm() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzahk.poll();
        while (poll != null) {
            this.zzahj.remove(poll);
            poll = this.zzahk.poll();
        }
        List<Throwable> list = this.zzahj.get(new zzn(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzahj.putIfAbsent(new zzn(th, this.zzahk), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
