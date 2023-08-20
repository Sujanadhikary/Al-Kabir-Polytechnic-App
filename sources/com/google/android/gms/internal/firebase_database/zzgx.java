package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DataSnapshot;

public final class zzgx implements zzgy {
    private final zzce zzop;
    private final zzgz zzor;
    private final DataSnapshot zzov;
    private final String zzow;

    public zzgx(zzgz zzgz, zzce zzce, DataSnapshot dataSnapshot, String str) {
        this.zzor = zzgz;
        this.zzop = zzce;
        this.zzov = dataSnapshot;
        this.zzow = str;
    }

    private final zzch zzg() {
        zzch zzg = this.zzov.getRef().zzg();
        return this.zzor == zzgz.VALUE ? zzg : zzg.zzby();
    }

    public final String toString() {
        if (this.zzor == zzgz.VALUE) {
            String valueOf = String.valueOf(zzg());
            String valueOf2 = String.valueOf(this.zzor);
            String valueOf3 = String.valueOf(this.zzov.getValue(true));
            return new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length()).append(valueOf).append(": ").append(valueOf2).append(": ").append(valueOf3).toString();
        }
        String valueOf4 = String.valueOf(zzg());
        String valueOf5 = String.valueOf(this.zzor);
        String key = this.zzov.getKey();
        String valueOf6 = String.valueOf(this.zzov.getValue(true));
        return new StringBuilder(String.valueOf(valueOf4).length() + 10 + String.valueOf(valueOf5).length() + String.valueOf(key).length() + String.valueOf(valueOf6).length()).append(valueOf4).append(": ").append(valueOf5).append(": { ").append(key).append(": ").append(valueOf6).append(" }").toString();
    }

    public final void zzdr() {
        this.zzop.zza(this);
    }

    public final zzgz zzdt() {
        return this.zzor;
    }

    public final DataSnapshot zzdw() {
        return this.zzov;
    }

    public final String zzdx() {
        return this.zzow;
    }
}
