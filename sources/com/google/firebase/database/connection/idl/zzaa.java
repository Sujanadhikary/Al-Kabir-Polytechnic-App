package com.google.firebase.database.connection.idl;

import android.os.RemoteException;
import com.google.android.gms.internal.firebase_database.zzbb;

final class zzaa implements zzbb {
    private final /* synthetic */ zzah zzfu;

    zzaa(zzah zzah) {
        this.zzfu = zzah;
    }

    public final void zzb(String str, String str2) {
        try {
            this.zzfu.zzb(str, str2);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
