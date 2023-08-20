package com.google.android.gms.internal.firebase_database;

public final class zzdn {
    public String zzct;
    public String zzcu;
    public boolean zzcv;
    public String zzka;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzdn zzdn = (zzdn) obj;
        if (this.zzcv != zzdn.zzcv || !this.zzct.equals(zzdn.zzct)) {
            return false;
        }
        return this.zzcu.equals(zzdn.zzcu);
    }

    public final int hashCode() {
        return (((this.zzcv ? 1 : 0) + (this.zzct.hashCode() * 31)) * 31) + this.zzcu.hashCode();
    }

    public final String toString() {
        String str = this.zzcv ? "s" : "";
        String str2 = this.zzct;
        return new StringBuilder(String.valueOf(str).length() + 7 + String.valueOf(str2).length()).append("http").append(str).append("://").append(str2).toString();
    }
}
