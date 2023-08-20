package com.google.android.gms.internal.firebase_database;

public final class zzex {
    private final long zzlq;

    public zzex(long j) {
        this.zzlq = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzlq == ((zzex) obj).zzlq;
    }

    public final int hashCode() {
        return (int) (this.zzlq ^ (this.zzlq >>> 32));
    }

    public final String toString() {
        return new StringBuilder(35).append("Tag{tagNumber=").append(this.zzlq).append('}').toString();
    }

    public final long zzcm() {
        return this.zzlq;
    }
}
