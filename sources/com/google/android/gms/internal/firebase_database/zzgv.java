package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;

public final class zzgv implements zzgy {
    private final zzch zzap;
    private final zzce zzop;
    private final DatabaseError zzoq;

    public zzgv(zzce zzce, DatabaseError databaseError, zzch zzch) {
        this.zzop = zzce;
        this.zzap = zzch;
        this.zzoq = databaseError;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzap);
        return new StringBuilder(String.valueOf(valueOf).length() + 7).append(valueOf).append(":CANCEL").toString();
    }

    public final void zzdr() {
        this.zzop.zza(this.zzoq);
    }
}
