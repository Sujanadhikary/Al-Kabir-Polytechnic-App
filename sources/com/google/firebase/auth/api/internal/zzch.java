package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.PhoneAuthCredential;

public interface zzch extends IInterface {
    void onFailure(Status status) throws RemoteException;

    void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException;

    void zza(zzao zzao, zzaj zzaj) throws RemoteException;

    void zza(zzav zzav) throws RemoteException;

    void zza(zzx zzx) throws RemoteException;

    void zzaa() throws RemoteException;

    void zzab() throws RemoteException;

    void zzac() throws RemoteException;

    void zzb(zzao zzao) throws RemoteException;

    void zzd(String str) throws RemoteException;

    void zze(String str) throws RemoteException;

    void zzf(String str) throws RemoteException;
}
