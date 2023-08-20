package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.PhoneAuthCredential;

public final class zzcj extends zza implements zzch {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void onFailure(Status status) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) status);
        transactOneway(5, obtainAndWriteInterfaceToken);
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) phoneAuthCredential);
        transactOneway(10, obtainAndWriteInterfaceToken);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) status);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) phoneAuthCredential);
        transactOneway(12, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzao zzao, zzaj zzaj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzao);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzaj);
        transactOneway(2, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzav zzav) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzav);
        transactOneway(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzx zzx) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzx);
        transactOneway(3, obtainAndWriteInterfaceToken);
    }

    public final void zzaa() throws RemoteException {
        transactOneway(6, obtainAndWriteInterfaceToken());
    }

    public final void zzab() throws RemoteException {
        transactOneway(7, obtainAndWriteInterfaceToken());
    }

    public final void zzac() throws RemoteException {
        transactOneway(13, obtainAndWriteInterfaceToken());
    }

    public final void zzb(zzao zzao) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzao);
        transactOneway(1, obtainAndWriteInterfaceToken);
    }

    public final void zzd(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        transactOneway(8, obtainAndWriteInterfaceToken);
    }

    public final void zze(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        transactOneway(9, obtainAndWriteInterfaceToken);
    }

    public final void zzf(String str) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        transactOneway(11, obtainAndWriteInterfaceToken);
    }
}
