package com.google.android.gms.internal.firebase_auth;

public class zzdo {
    private static final zzco zzlw = zzco.zzdh();
    private zzbu zzsh;
    private volatile zzeh zzsi;
    private volatile zzbu zzsj;

    private final zzeh zzh(zzeh zzeh) {
        if (this.zzsi == null) {
            synchronized (this) {
                if (this.zzsi == null) {
                    try {
                        this.zzsi = zzeh;
                        this.zzsj = zzbu.zzmc;
                    } catch (zzdh e) {
                        this.zzsi = zzeh;
                        this.zzsj = zzbu.zzmc;
                    }
                }
            }
        }
        return this.zzsi;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzdo)) {
            return false;
        }
        zzdo zzdo = (zzdo) obj;
        zzeh zzeh = this.zzsi;
        zzeh zzeh2 = zzdo.zzsi;
        return (zzeh == null && zzeh2 == null) ? zzbl().equals(zzdo.zzbl()) : (zzeh == null || zzeh2 == null) ? zzeh != null ? zzeh.equals(zzdo.zzh(zzeh.zzdy())) : zzh(zzeh2.zzdy()).equals(zzeh2) : zzeh.equals(zzeh2);
    }

    public int hashCode() {
        return 1;
    }

    public final zzbu zzbl() {
        if (this.zzsj != null) {
            return this.zzsj;
        }
        synchronized (this) {
            if (this.zzsj != null) {
                zzbu zzbu = this.zzsj;
                return zzbu;
            }
            if (this.zzsi == null) {
                this.zzsj = zzbu.zzmc;
            } else {
                this.zzsj = this.zzsi.zzbl();
            }
            zzbu zzbu2 = this.zzsj;
            return zzbu2;
        }
    }

    public final int zzdn() {
        if (this.zzsj != null) {
            return this.zzsj.size();
        }
        if (this.zzsi != null) {
            return this.zzsi.zzdn();
        }
        return 0;
    }

    public final zzeh zzi(zzeh zzeh) {
        zzeh zzeh2 = this.zzsi;
        this.zzsh = null;
        this.zzsj = null;
        this.zzsi = zzeh;
        return zzeh2;
    }
}
