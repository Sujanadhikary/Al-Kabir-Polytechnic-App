package com.google.android.gms.internal.firebase_database;

public final class zzkn<T, U> {
    private final T first;
    private final U second;

    public zzkn(T t, U u) {
        this.first = t;
        this.second = u;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzkn zzkn = (zzkn) obj;
        if (this.first == null ? zzkn.first != null : !this.first.equals(zzkn.first)) {
            return false;
        }
        if (this.second != null) {
            if (this.second.equals(zzkn.second)) {
                return true;
            }
        } else if (zzkn.second == null) {
            return true;
        }
        return false;
    }

    public final T getFirst() {
        return this.first;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (this.first != null ? this.first.hashCode() : 0) * 31;
        if (this.second != null) {
            i = this.second.hashCode();
        }
        return hashCode + i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.first);
        String valueOf2 = String.valueOf(this.second);
        return new StringBuilder(String.valueOf(valueOf).length() + 7 + String.valueOf(valueOf2).length()).append("Pair(").append(valueOf).append(",").append(valueOf2).append(")").toString();
    }

    public final U zzgv() {
        return this.second;
    }
}
