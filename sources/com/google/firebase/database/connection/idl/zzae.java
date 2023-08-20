package com.google.firebase.database.connection.idl;

import android.os.RemoteException;

final class zzae implements com.google.android.gms.internal.firebase_database.zzae {
    private final /* synthetic */ zzn zzfy;

    zzae(zzad zzad, zzn zzn) {
        this.zzfy = zzn;
    }

    public final void onError(String str) {
        try {
            this.zzfy.onError(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final void zzf(String str) {
        try {
            this.zzfy.zzf(str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
