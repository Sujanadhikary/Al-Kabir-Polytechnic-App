package com.google.android.gms.internal.firebase_auth;

final class zzbz {
    private final byte[] buffer;
    private final zzci zzmi;

    private zzbz(int i) {
        this.buffer = new byte[i];
        this.zzmi = zzci.zzb(this.buffer);
    }

    /* synthetic */ zzbz(int i, zzbv zzbv) {
        this(i);
    }

    public final zzbu zzbx() {
        if (this.zzmi.zzcz() == 0) {
            return new zzcb(this.buffer);
        }
        throw new IllegalStateException("Did not write as much data as expected.");
    }

    public final zzci zzby() {
        return this.zzmi;
    }
}
