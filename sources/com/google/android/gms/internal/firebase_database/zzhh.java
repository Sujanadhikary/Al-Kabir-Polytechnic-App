package com.google.android.gms.internal.firebase_database;

public final class zzhh {
    private final zzch zzap;
    private final zzhe zzat;

    public zzhh(zzch zzch, zzhe zzhe) {
        this.zzap = zzch;
        this.zzat = zzhe;
    }

    public static zzhh zzal(zzch zzch) {
        return new zzhh(zzch, zzhe.zzpi);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhh zzhh = (zzhh) obj;
        if (!this.zzap.equals(zzhh.zzap)) {
            return false;
        }
        return this.zzat.equals(zzhh.zzat);
    }

    public final int hashCode() {
        return (this.zzap.hashCode() * 31) + this.zzat.hashCode();
    }

    public final boolean isDefault() {
        return this.zzat.isDefault();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzap);
        String valueOf2 = String.valueOf(this.zzat);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append(":").append(valueOf2).toString();
    }

    public final zzis zzeg() {
        return this.zzat.zzeg();
    }

    public final boolean zzek() {
        return this.zzat.zzek();
    }

    public final zzhe zzen() {
        return this.zzat;
    }

    public final zzch zzg() {
        return this.zzap;
    }
}
