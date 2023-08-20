package com.google.android.gms.internal.firebase_database;

public final class zziz {
    private static final zziz zzsh = new zziz(zzid.zzfc(), zzir.zzfv());
    private static final zziz zzsi = new zziz(zzid.zzfd(), zzja.zzsj);
    private final zzid zzoh;
    private final zzja zzry;

    public zziz(zzid zzid, zzja zzja) {
        this.zzoh = zzid;
        this.zzry = zzja;
    }

    public static zziz zzgc() {
        return zzsh;
    }

    public static zziz zzgd() {
        return zzsi;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zziz zziz = (zziz) obj;
        if (!this.zzoh.equals(zziz.zzoh)) {
            return false;
        }
        return this.zzry.equals(zziz.zzry);
    }

    public final int hashCode() {
        return (this.zzoh.hashCode() * 31) + this.zzry.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzoh);
        String valueOf2 = String.valueOf(this.zzry);
        return new StringBuilder(String.valueOf(valueOf).length() + 23 + String.valueOf(valueOf2).length()).append("NamedNode{name=").append(valueOf).append(", node=").append(valueOf2).append('}').toString();
    }

    public final zzja zzd() {
        return this.zzry;
    }

    public final zzid zzge() {
        return this.zzoh;
    }
}
