package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public abstract class zzcd {
    private static volatile boolean zzmp;
    int zzmk;
    int zzml;
    private int zzmm;
    zzcg zzmn;
    private boolean zzmo;

    static {
        zzmp = false;
        zzmp = true;
    }

    private zzcd() {
        this.zzml = 100;
        this.zzmm = Integer.MAX_VALUE;
        this.zzmo = false;
    }

    static zzcd zza(byte[] bArr, int i, int i2, boolean z) {
        zzcf zzcf = new zzcf(bArr, i, i2, false);
        try {
            zzcf.zzo(i2);
            return zzcf;
        } catch (zzdh e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static zzcd zzd(byte[] bArr, int i, int i2) {
        return zza(bArr, i, i2, false);
    }

    public abstract double readDouble() throws IOException;

    public abstract float readFloat() throws IOException;

    public abstract String readString() throws IOException;

    public abstract <T extends zzeh> T zza(zzer<T> zzer, zzco zzco) throws IOException;

    public abstract int zzbz() throws IOException;

    public abstract long zzca() throws IOException;

    public abstract long zzcb() throws IOException;

    public abstract int zzcc() throws IOException;

    public abstract long zzcd() throws IOException;

    public abstract int zzce() throws IOException;

    public abstract boolean zzcf() throws IOException;

    public abstract String zzcg() throws IOException;

    public abstract zzbu zzch() throws IOException;

    public abstract int zzci() throws IOException;

    public abstract int zzcj() throws IOException;

    public abstract int zzck() throws IOException;

    public abstract long zzcl() throws IOException;

    public abstract int zzcm() throws IOException;

    public abstract long zzcn() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract long zzco() throws IOException;

    public abstract boolean zzcp() throws IOException;

    public abstract int zzcq();

    public abstract void zzl(int i) throws zzdh;

    public abstract boolean zzm(int i) throws IOException;

    public final int zzn(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuilder(47).append("Recursion limit cannot be negative: ").append(i).toString());
        }
        int i2 = this.zzml;
        this.zzml = i;
        return i2;
    }

    public abstract int zzo(int i) throws zzdh;

    public abstract void zzp(int i);

    public abstract void zzq(int i) throws IOException;
}
