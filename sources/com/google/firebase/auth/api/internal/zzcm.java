package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public final class zzcm extends zza implements zzck {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(zzax zzax, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzax);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(22, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzbf zzbf, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzbf);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) emailAuthCredential);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(29, obtainAndWriteInterfaceToken);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) phoneAuthCredential);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(23, obtainAndWriteInterfaceToken);
    }

    public final void zza(zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(16, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, zzbf zzbf, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzbf);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) actionCodeSettings);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(25, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, PhoneAuthCredential phoneAuthCredential, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) phoneAuthCredential);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(24, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) userProfileChangeRequest);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
    }

    public final void zza(String str, String str2, String str3, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        obtainAndWriteInterfaceToken.writeString(str3);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
    }

    public final void zzb(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) actionCodeSettings);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(26, obtainAndWriteInterfaceToken);
    }

    public final void zzb(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
    }

    public final void zzb(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(6, obtainAndWriteInterfaceToken);
    }

    public final void zzc(String str, ActionCodeSettings actionCodeSettings, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) actionCodeSettings);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(28, obtainAndWriteInterfaceToken);
    }

    public final void zzc(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
    }

    public final void zzc(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
    }

    public final void zzd(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
    }

    public final void zzd(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
    }

    public final void zze(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
    }

    public final void zze(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(14, obtainAndWriteInterfaceToken);
    }

    public final void zzf(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(15, obtainAndWriteInterfaceToken);
    }

    public final void zzf(String str, String str2, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        obtainAndWriteInterfaceToken.writeString(str2);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(21, obtainAndWriteInterfaceToken);
    }

    public final void zzg(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(17, obtainAndWriteInterfaceToken);
    }

    public final void zzh(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(18, obtainAndWriteInterfaceToken);
    }

    public final void zzi(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(19, obtainAndWriteInterfaceToken);
    }

    public final void zzj(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(20, obtainAndWriteInterfaceToken);
    }

    public final void zzk(String str, zzch zzch) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) zzch);
        transactAndReadExceptionReturnVoid(27, obtainAndWriteInterfaceToken);
    }
}
