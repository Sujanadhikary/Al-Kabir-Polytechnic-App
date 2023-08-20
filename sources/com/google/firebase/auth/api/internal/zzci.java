package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.PhoneAuthCredential;

public abstract class zzci extends zzb implements zzch {
    public zzci() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb((zzao) zzc.zza(parcel, zzao.CREATOR));
                break;
            case 2:
                zza((zzao) zzc.zza(parcel, zzao.CREATOR), (zzaj) zzc.zza(parcel, zzaj.CREATOR));
                break;
            case 3:
                zza((zzx) zzc.zza(parcel, zzx.CREATOR));
                break;
            case 4:
                zza((zzav) zzc.zza(parcel, zzav.CREATOR));
                break;
            case 5:
                onFailure((Status) zzc.zza(parcel, Status.CREATOR));
                break;
            case 6:
                zzaa();
                break;
            case 7:
                zzab();
                break;
            case 8:
                zzd(parcel.readString());
                break;
            case 9:
                zze(parcel.readString());
                break;
            case 10:
                onVerificationCompleted((PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                break;
            case 11:
                zzf(parcel.readString());
                break;
            case 12:
                zza((Status) zzc.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                break;
            case 13:
                zzac();
                break;
            default:
                return false;
        }
        return true;
    }
}
