package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzfd extends zzfj {
    private final /* synthetic */ zzfa zzvm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzfd(zzfa zzfa) {
        super(zzfa, (zzfb) null);
        this.zzvm = zzfa;
    }

    /* synthetic */ zzfd(zzfa zzfa, zzfb zzfb) {
        this(zzfa);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzfc(this.zzvm, (zzfb) null);
    }
}
