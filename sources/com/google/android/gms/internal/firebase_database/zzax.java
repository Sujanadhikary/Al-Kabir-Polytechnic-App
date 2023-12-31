package com.google.android.gms.internal.firebase_database;

import java.util.List;

final class zzax {
    private final Object data;
    private final List<String> zzei;
    private final String zzek;
    /* access modifiers changed from: private */
    public final zzbb zzel;

    private zzax(String str, List<String> list, Object obj, zzbb zzbb) {
        this.zzek = str;
        this.zzei = list;
        this.data = obj;
        this.zzel = zzbb;
    }

    /* synthetic */ zzax(String str, List list, Object obj, zzbb zzbb, zzam zzam) {
        this(str, list, obj, zzbb);
    }

    public final String getAction() {
        return this.zzek;
    }

    public final Object getData() {
        return this.data;
    }

    public final List<String> getPath() {
        return this.zzei;
    }

    public final zzbb zzai() {
        return this.zzel;
    }
}
