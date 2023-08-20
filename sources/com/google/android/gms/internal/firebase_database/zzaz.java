package com.google.android.gms.internal.firebase_database;

import java.util.Map;

final class zzaz {
    private String zzek;
    /* access modifiers changed from: private */
    public zzbb zzel;
    private Map<String, Object> zzeq;
    private boolean zzer;

    private zzaz(String str, Map<String, Object> map, zzbb zzbb) {
        this.zzek = str;
        this.zzeq = map;
        this.zzel = zzbb;
    }

    /* synthetic */ zzaz(String str, Map map, zzbb zzbb, zzam zzam) {
        this(str, map, zzbb);
    }

    public final String getAction() {
        return this.zzek;
    }

    public final zzbb zzai() {
        return this.zzel;
    }

    public final Map<String, Object> zzam() {
        return this.zzeq;
    }

    public final void zzan() {
        this.zzer = true;
    }

    public final boolean zzao() {
        return this.zzer;
    }
}
