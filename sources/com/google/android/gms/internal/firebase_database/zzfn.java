package com.google.android.gms.internal.firebase_database;

public final class zzfn {
    public static final zzfn zzmu = new zzfn(zzfo.User, (zzhe) null, false);
    public static final zzfn zzmv = new zzfn(zzfo.Server, (zzhe) null, false);
    private final zzfo zzmw;
    private final zzhe zzmx;
    private final boolean zzmy;

    private zzfn(zzfo zzfo, zzhe zzhe, boolean z) {
        this.zzmw = zzfo;
        this.zzmx = zzhe;
        this.zzmy = z;
    }

    public static zzfn zzc(zzhe zzhe) {
        return new zzfn(zzfo.Server, zzhe, true);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzmw);
        String valueOf2 = String.valueOf(this.zzmx);
        return new StringBuilder(String.valueOf(valueOf).length() + 52 + String.valueOf(valueOf2).length()).append("OperationSource{source=").append(valueOf).append(", queryParams=").append(valueOf2).append(", tagged=").append(this.zzmy).append('}').toString();
    }

    public final boolean zzda() {
        return this.zzmw == zzfo.User;
    }

    public final boolean zzdb() {
        return this.zzmy;
    }

    public final zzhe zzdc() {
        return this.zzmx;
    }
}
