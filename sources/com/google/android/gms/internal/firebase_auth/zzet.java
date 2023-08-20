package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;

final class zzet implements zzef {
    private final String info;
    private final zzeh zzti;
    private final zzeu zzua;

    zzet(zzeh zzeh, String str, Object[] objArr) {
        this.zzti = zzeh;
        this.info = str;
        this.zzua = new zzeu(zzeh.getClass(), str, objArr);
    }

    public final int getFieldCount() {
        return this.zzua.zzud;
    }

    public final int zzew() {
        return (this.zzua.flags & 1) == 1 ? zzdb.zze.zzrg : zzdb.zze.zzrh;
    }

    public final boolean zzex() {
        return (this.zzua.flags & 2) == 2;
    }

    public final zzeh zzey() {
        return this.zzti;
    }

    /* access modifiers changed from: package-private */
    public final zzeu zzfe() {
        return this.zzua;
    }

    public final int zzff() {
        return this.zzua.zztf;
    }

    public final int zzfg() {
        return this.zzua.zztg;
    }

    public final int zzfh() {
        return this.zzua.zzug;
    }

    public final int zzfi() {
        return this.zzua.zzui;
    }

    /* access modifiers changed from: package-private */
    public final int[] zzfj() {
        return this.zzua.zztn;
    }

    public final int zzfk() {
        return this.zzua.zzuh;
    }

    public final int zzfl() {
        return this.zzua.zzth;
    }
}
