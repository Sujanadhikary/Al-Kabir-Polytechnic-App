package com.google.android.gms.internal.firebase_database;

final class zzay {
    /* access modifiers changed from: private */
    public final zzbb zzem;
    /* access modifiers changed from: private */
    public final zzaw zzen;
    private final zzai zzeo;
    private final Long zzep;

    private zzay(zzbb zzbb, zzaw zzaw, Long l, zzai zzai) {
        this.zzem = zzbb;
        this.zzen = zzaw;
        this.zzeo = zzai;
        this.zzep = l;
    }

    /* synthetic */ zzay(zzbb zzbb, zzaw zzaw, Long l, zzai zzai, zzam zzam) {
        this(zzbb, zzaw, l, zzai);
    }

    public final String toString() {
        String zzaw = this.zzen.toString();
        String valueOf = String.valueOf(this.zzep);
        return new StringBuilder(String.valueOf(zzaw).length() + 8 + String.valueOf(valueOf).length()).append(zzaw).append(" (Tag: ").append(valueOf).append(")").toString();
    }

    public final zzaw zzaj() {
        return this.zzen;
    }

    public final Long zzak() {
        return this.zzep;
    }

    public final zzai zzal() {
        return this.zzeo;
    }
}
