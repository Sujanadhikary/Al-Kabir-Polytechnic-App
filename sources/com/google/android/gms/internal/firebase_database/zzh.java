package com.google.android.gms.internal.firebase_database;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzh extends WeakReference<Throwable> {
    private final int zzj;

    public zzh(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, (ReferenceQueue) null);
        if (th == null) {
            throw new NullPointerException("The referent cannot be null");
        }
        this.zzj = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzh zzh = (zzh) obj;
        return this.zzj == zzh.zzj && get() == zzh.get();
    }

    public final int hashCode() {
        return this.zzj;
    }
}
