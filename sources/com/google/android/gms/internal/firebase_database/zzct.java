package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

final class zzct implements Runnable {
    private final /* synthetic */ DataSnapshot zzir;
    private final /* synthetic */ zzdl zziu;

    zzct(zzcs zzcs, zzdl zzdl, DataSnapshot dataSnapshot) {
        this.zziu = zzdl;
        this.zzir = dataSnapshot;
    }

    public final void run() {
        this.zziu.zzjj.onComplete((DatabaseError) null, true, this.zzir);
    }
}
