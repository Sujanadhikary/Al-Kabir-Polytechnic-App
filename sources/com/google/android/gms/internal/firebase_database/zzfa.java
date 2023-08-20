package com.google.android.gms.internal.firebase_database;

public final class zzfa {
    private final zzch zzap;
    private final long zzls;
    private final zzja zzlt;
    private final zzbv zzlu;
    private final boolean zzlv;

    public zzfa(long j, zzch zzch, zzbv zzbv) {
        this.zzls = j;
        this.zzap = zzch;
        this.zzlt = null;
        this.zzlu = zzbv;
        this.zzlv = true;
    }

    public zzfa(long j, zzch zzch, zzja zzja, boolean z) {
        this.zzls = j;
        this.zzap = zzch;
        this.zzlt = zzja;
        this.zzlu = null;
        this.zzlv = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzfa zzfa = (zzfa) obj;
        if (this.zzls != zzfa.zzls) {
            return false;
        }
        if (!this.zzap.equals(zzfa.zzap)) {
            return false;
        }
        if (this.zzlv != zzfa.zzlv) {
            return false;
        }
        if (this.zzlt == null ? zzfa.zzlt != null : !this.zzlt.equals(zzfa.zzlt)) {
            return false;
        }
        if (this.zzlu != null) {
            if (this.zzlu.equals(zzfa.zzlu)) {
                return true;
            }
        } else if (zzfa.zzlu == null) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.zzlt != null ? this.zzlt.hashCode() : 0) + (((((Long.valueOf(this.zzls).hashCode() * 31) + Boolean.valueOf(this.zzlv).hashCode()) * 31) + this.zzap.hashCode()) * 31)) * 31;
        if (this.zzlu != null) {
            i = this.zzlu.hashCode();
        }
        return hashCode + i;
    }

    public final boolean isVisible() {
        return this.zzlv;
    }

    public final String toString() {
        long j = this.zzls;
        String valueOf = String.valueOf(this.zzap);
        boolean z = this.zzlv;
        String valueOf2 = String.valueOf(this.zzlt);
        String valueOf3 = String.valueOf(this.zzlu);
        return new StringBuilder(String.valueOf(valueOf).length() + 78 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append("UserWriteRecord{id=").append(j).append(" path=").append(valueOf).append(" visible=").append(z).append(" overwrite=").append(valueOf2).append(" merge=").append(valueOf3).append("}").toString();
    }

    public final long zzcn() {
        return this.zzls;
    }

    public final zzja zzco() {
        if (this.zzlt != null) {
            return this.zzlt;
        }
        throw new IllegalArgumentException("Can't access overwrite when write is a merge!");
    }

    public final zzbv zzcp() {
        if (this.zzlu != null) {
            return this.zzlu;
        }
        throw new IllegalArgumentException("Can't access merge when write is an overwrite!");
    }

    public final boolean zzcq() {
        return this.zzlt != null;
    }

    public final zzch zzg() {
        return this.zzap;
    }
}
