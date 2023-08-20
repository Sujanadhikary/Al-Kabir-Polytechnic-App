package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_database.zzb;
import com.google.android.gms.internal.firebase_database.zzc;

public abstract class zzr extends zzb implements zzq {
    public zzr() {
        super("com.google.firebase.database.connection.idl.IListenHashProvider");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zzx = zzx();
                parcel2.writeNoException();
                parcel2.writeString(zzx);
                break;
            case 2:
                boolean zzy = zzy();
                parcel2.writeNoException();
                zzc.zza(parcel2, zzy);
                break;
            case 3:
                zza zzaw = zzaw();
                parcel2.writeNoException();
                zzc.zzb(parcel2, zzaw);
                break;
            default:
                return false;
        }
        return true;
    }
}
