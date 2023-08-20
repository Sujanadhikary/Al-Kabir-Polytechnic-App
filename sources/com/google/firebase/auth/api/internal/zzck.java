package com.google.firebase.auth.api.internal;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public interface zzck extends IInterface {
    void zza(zzax zzax, zzch zzch) throws RemoteException;

    void zza(zzbf zzbf, zzch zzch) throws RemoteException;

    void zza(EmailAuthCredential emailAuthCredential, zzch zzch) throws RemoteException;

    void zza(PhoneAuthCredential phoneAuthCredential, zzch zzch) throws RemoteException;

    void zza(zzch zzch) throws RemoteException;

    void zza(String str, zzbf zzbf, zzch zzch) throws RemoteException;

    @Deprecated
    void zza(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException;

    void zza(String str, PhoneAuthCredential phoneAuthCredential, zzch zzch) throws RemoteException;

    void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzch zzch) throws RemoteException;

    void zza(String str, zzch zzch) throws RemoteException;

    void zza(String str, String str2, zzch zzch) throws RemoteException;

    void zza(String str, String str2, String str3, zzch zzch) throws RemoteException;

    void zzb(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException;

    void zzb(String str, zzch zzch) throws RemoteException;

    void zzb(String str, String str2, zzch zzch) throws RemoteException;

    void zzc(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException;

    void zzc(String str, zzch zzch) throws RemoteException;

    void zzc(String str, String str2, zzch zzch) throws RemoteException;

    void zzd(String str, zzch zzch) throws RemoteException;

    void zzd(String str, String str2, zzch zzch) throws RemoteException;

    void zze(String str, zzch zzch) throws RemoteException;

    void zze(String str, String str2, zzch zzch) throws RemoteException;

    void zzf(String str, zzch zzch) throws RemoteException;

    void zzf(String str, String str2, zzch zzch) throws RemoteException;

    void zzg(String str, zzch zzch) throws RemoteException;

    void zzh(String str, zzch zzch) throws RemoteException;

    void zzi(String str, zzch zzch) throws RemoteException;

    void zzj(String str, zzch zzch) throws RemoteException;

    void zzk(String str, zzch zzch) throws RemoteException;
}
