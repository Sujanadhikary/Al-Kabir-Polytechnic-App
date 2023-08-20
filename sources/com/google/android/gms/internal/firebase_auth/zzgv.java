package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public abstract class zzgv {
    protected volatile int zzyw = -1;

    public static final void zza(zzgv zzgv, byte[] bArr, int i, int i2) {
        try {
            zzgn zzj = zzgn.zzj(bArr, 0, i2);
            zzgv.zza(zzj);
            zzj.zzhe();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzgv> T zzb(T t, byte[] bArr, int i, int i2) throws zzgu {
        try {
            zzgm zzi = zzgm.zzi(bArr, 0, i2);
            t.zza(zzi);
            zzi.zzl(0);
            return t;
        } catch (zzgu e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzgw.zzc(this);
    }

    public abstract zzgv zza(zzgm zzgm) throws IOException;

    public void zza(zzgn zzgn) throws IOException {
    }

    /* access modifiers changed from: protected */
    public int zzb() {
        return 0;
    }

    public final int zzdn() {
        int zzb = zzb();
        this.zzyw = zzb;
        return zzb;
    }

    /* renamed from: zzhf */
    public zzgv clone() throws CloneNotSupportedException {
        return (zzgv) super.clone();
    }
}
