package com.google.firebase.database.connection.idl;

import android.os.RemoteException;
import com.google.android.gms.internal.firebase_database.zzai;
import com.google.android.gms.internal.firebase_database.zzy;

final class zzz implements zzai {
    private final /* synthetic */ zzq zzft;

    zzz(IPersistentConnectionImpl iPersistentConnectionImpl, zzq zzq) {
        this.zzft = zzq;
    }

    public final String zzx() {
        try {
            return this.zzft.zzx();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final boolean zzy() {
        try {
            return this.zzft.zzy();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public final zzy zzz() {
        try {
            return zza.zza(this.zzft.zzaw());
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
