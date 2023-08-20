package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.firebase_database.zzb;
import com.google.android.gms.internal.firebase_database.zzc;
import java.util.List;

public abstract class zzx extends zzb implements zzw {
    public zzx() {
        super("com.google.firebase.database.connection.idl.IPersistentConnectionDelegate");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((List<String>) parcel.createStringArrayList(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzc.zza(parcel), parcel.readLong());
                break;
            case 2:
                zza((List<String>) parcel.createStringArrayList(), (List<zzak>) parcel.createTypedArrayList(zzak.CREATOR), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readLong());
                break;
            case 3:
                zzaa();
                break;
            case 4:
                onDisconnect();
                break;
            case 5:
                zzb(zzc.zza(parcel));
                break;
            case 6:
                zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
