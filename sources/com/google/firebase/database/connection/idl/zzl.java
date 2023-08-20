package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_database.zzb;
import com.google.android.gms.internal.firebase_database.zzc;

public abstract class zzl extends zzb implements zzk {
    public zzl() {
        super("com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzn zzp;
        if (i != 1) {
            return false;
        }
        boolean zza = zzc.zza(parcel);
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder == null) {
            zzp = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IGetTokenCallback");
            zzp = queryLocalInterface instanceof zzn ? (zzn) queryLocalInterface : new zzp(readStrongBinder);
        }
        zza(zza, zzp);
        parcel2.writeNoException();
        return true;
    }
}
