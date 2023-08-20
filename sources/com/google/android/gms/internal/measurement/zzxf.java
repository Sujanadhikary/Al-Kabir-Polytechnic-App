package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzxf {
    private final ConcurrentHashMap<zzxg, List<Throwable>> zzboa = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzbob = new ReferenceQueue<>();

    zzxf() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzbob.poll();
        while (poll != null) {
            this.zzboa.remove(poll);
            poll = this.zzbob.poll();
        }
        return this.zzboa.get(new zzxg(th, (ReferenceQueue<Throwable>) null));
    }
}
