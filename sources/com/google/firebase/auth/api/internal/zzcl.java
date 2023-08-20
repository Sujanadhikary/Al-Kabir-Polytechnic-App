package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.p000v4.view.MotionEventCompat;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

public abstract class zzcl extends zzb implements zzck {
    public zzcl() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzch zzcj;
        zzch zzch = null;
        switch (i) {
            case 1:
                String readString = parcel.readString();
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder == null) {
                    zzcj = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzcj = queryLocalInterface instanceof zzch ? (zzch) queryLocalInterface : new zzcj(readStrongBinder);
                }
                zza(readString, zzcj);
                break;
            case 2:
                String readString2 = parcel.readString();
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface2 instanceof zzch ? (zzch) queryLocalInterface2 : new zzcj(readStrongBinder2);
                }
                zzb(readString2, zzch);
                break;
            case 3:
                zzbf zzbf = (zzbf) zzc.zza(parcel, zzbf.CREATOR);
                IBinder readStrongBinder3 = parcel.readStrongBinder();
                if (readStrongBinder3 != null) {
                    IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface3 instanceof zzch ? (zzch) queryLocalInterface3 : new zzcj(readStrongBinder3);
                }
                zza(zzbf, zzch);
                break;
            case 4:
                String readString3 = parcel.readString();
                UserProfileChangeRequest userProfileChangeRequest = (UserProfileChangeRequest) zzc.zza(parcel, UserProfileChangeRequest.CREATOR);
                IBinder readStrongBinder4 = parcel.readStrongBinder();
                if (readStrongBinder4 != null) {
                    IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface4 instanceof zzch ? (zzch) queryLocalInterface4 : new zzcj(readStrongBinder4);
                }
                zza(readString3, userProfileChangeRequest, zzch);
                break;
            case 5:
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                IBinder readStrongBinder5 = parcel.readStrongBinder();
                if (readStrongBinder5 != null) {
                    IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface5 instanceof zzch ? (zzch) queryLocalInterface5 : new zzcj(readStrongBinder5);
                }
                zza(readString4, readString5, zzch);
                break;
            case 6:
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                IBinder readStrongBinder6 = parcel.readStrongBinder();
                if (readStrongBinder6 != null) {
                    IInterface queryLocalInterface6 = readStrongBinder6.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface6 instanceof zzch ? (zzch) queryLocalInterface6 : new zzcj(readStrongBinder6);
                }
                zzb(readString6, readString7, zzch);
                break;
            case 7:
                String readString8 = parcel.readString();
                String readString9 = parcel.readString();
                IBinder readStrongBinder7 = parcel.readStrongBinder();
                if (readStrongBinder7 != null) {
                    IInterface queryLocalInterface7 = readStrongBinder7.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface7 instanceof zzch ? (zzch) queryLocalInterface7 : new zzcj(readStrongBinder7);
                }
                zzc(readString8, readString9, zzch);
                break;
            case 8:
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                IBinder readStrongBinder8 = parcel.readStrongBinder();
                if (readStrongBinder8 != null) {
                    IInterface queryLocalInterface8 = readStrongBinder8.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface8 instanceof zzch ? (zzch) queryLocalInterface8 : new zzcj(readStrongBinder8);
                }
                zzd(readString10, readString11, zzch);
                break;
            case 9:
                String readString12 = parcel.readString();
                IBinder readStrongBinder9 = parcel.readStrongBinder();
                if (readStrongBinder9 != null) {
                    IInterface queryLocalInterface9 = readStrongBinder9.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface9 instanceof zzch ? (zzch) queryLocalInterface9 : new zzcj(readStrongBinder9);
                }
                zzc(readString12, zzch);
                break;
            case 10:
                String readString13 = parcel.readString();
                IBinder readStrongBinder10 = parcel.readStrongBinder();
                if (readStrongBinder10 != null) {
                    IInterface queryLocalInterface10 = readStrongBinder10.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface10 instanceof zzch ? (zzch) queryLocalInterface10 : new zzcj(readStrongBinder10);
                }
                zzd(readString13, zzch);
                break;
            case 11:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                IBinder readStrongBinder11 = parcel.readStrongBinder();
                if (readStrongBinder11 != null) {
                    IInterface queryLocalInterface11 = readStrongBinder11.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface11 instanceof zzch ? (zzch) queryLocalInterface11 : new zzcj(readStrongBinder11);
                }
                zza(readString14, readString15, readString16, zzch);
                break;
            case 12:
                String readString17 = parcel.readString();
                zzbf zzbf2 = (zzbf) zzc.zza(parcel, zzbf.CREATOR);
                IBinder readStrongBinder12 = parcel.readStrongBinder();
                if (readStrongBinder12 != null) {
                    IInterface queryLocalInterface12 = readStrongBinder12.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface12 instanceof zzch ? (zzch) queryLocalInterface12 : new zzcj(readStrongBinder12);
                }
                zza(readString17, zzbf2, zzch);
                break;
            case 13:
                String readString18 = parcel.readString();
                IBinder readStrongBinder13 = parcel.readStrongBinder();
                if (readStrongBinder13 != null) {
                    IInterface queryLocalInterface13 = readStrongBinder13.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface13 instanceof zzch ? (zzch) queryLocalInterface13 : new zzcj(readStrongBinder13);
                }
                zze(readString18, zzch);
                break;
            case 14:
                String readString19 = parcel.readString();
                String readString20 = parcel.readString();
                IBinder readStrongBinder14 = parcel.readStrongBinder();
                if (readStrongBinder14 != null) {
                    IInterface queryLocalInterface14 = readStrongBinder14.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface14 instanceof zzch ? (zzch) queryLocalInterface14 : new zzcj(readStrongBinder14);
                }
                zze(readString19, readString20, zzch);
                break;
            case 15:
                String readString21 = parcel.readString();
                IBinder readStrongBinder15 = parcel.readStrongBinder();
                if (readStrongBinder15 != null) {
                    IInterface queryLocalInterface15 = readStrongBinder15.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface15 instanceof zzch ? (zzch) queryLocalInterface15 : new zzcj(readStrongBinder15);
                }
                zzf(readString21, zzch);
                break;
            case 16:
                IBinder readStrongBinder16 = parcel.readStrongBinder();
                if (readStrongBinder16 != null) {
                    IInterface queryLocalInterface16 = readStrongBinder16.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface16 instanceof zzch ? (zzch) queryLocalInterface16 : new zzcj(readStrongBinder16);
                }
                zza(zzch);
                break;
            case 17:
                String readString22 = parcel.readString();
                IBinder readStrongBinder17 = parcel.readStrongBinder();
                if (readStrongBinder17 != null) {
                    IInterface queryLocalInterface17 = readStrongBinder17.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface17 instanceof zzch ? (zzch) queryLocalInterface17 : new zzcj(readStrongBinder17);
                }
                zzg(readString22, zzch);
                break;
            case 18:
                String readString23 = parcel.readString();
                IBinder readStrongBinder18 = parcel.readStrongBinder();
                if (readStrongBinder18 != null) {
                    IInterface queryLocalInterface18 = readStrongBinder18.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface18 instanceof zzch ? (zzch) queryLocalInterface18 : new zzcj(readStrongBinder18);
                }
                zzh(readString23, zzch);
                break;
            case 19:
                String readString24 = parcel.readString();
                IBinder readStrongBinder19 = parcel.readStrongBinder();
                if (readStrongBinder19 != null) {
                    IInterface queryLocalInterface19 = readStrongBinder19.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface19 instanceof zzch ? (zzch) queryLocalInterface19 : new zzcj(readStrongBinder19);
                }
                zzi(readString24, zzch);
                break;
            case 20:
                String readString25 = parcel.readString();
                IBinder readStrongBinder20 = parcel.readStrongBinder();
                if (readStrongBinder20 != null) {
                    IInterface queryLocalInterface20 = readStrongBinder20.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface20 instanceof zzch ? (zzch) queryLocalInterface20 : new zzcj(readStrongBinder20);
                }
                zzj(readString25, zzch);
                break;
            case 21:
                String readString26 = parcel.readString();
                String readString27 = parcel.readString();
                IBinder readStrongBinder21 = parcel.readStrongBinder();
                if (readStrongBinder21 != null) {
                    IInterface queryLocalInterface21 = readStrongBinder21.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface21 instanceof zzch ? (zzch) queryLocalInterface21 : new zzcj(readStrongBinder21);
                }
                zzf(readString26, readString27, zzch);
                break;
            case MotionEventCompat.AXIS_GAS:
                zzax zzax = (zzax) zzc.zza(parcel, zzax.CREATOR);
                IBinder readStrongBinder22 = parcel.readStrongBinder();
                if (readStrongBinder22 != null) {
                    IInterface queryLocalInterface22 = readStrongBinder22.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface22 instanceof zzch ? (zzch) queryLocalInterface22 : new zzcj(readStrongBinder22);
                }
                zza(zzax, zzch);
                break;
            case 23:
                PhoneAuthCredential phoneAuthCredential = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder23 = parcel.readStrongBinder();
                if (readStrongBinder23 != null) {
                    IInterface queryLocalInterface23 = readStrongBinder23.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface23 instanceof zzch ? (zzch) queryLocalInterface23 : new zzcj(readStrongBinder23);
                }
                zza(phoneAuthCredential, zzch);
                break;
            case MotionEventCompat.AXIS_DISTANCE:
                String readString28 = parcel.readString();
                PhoneAuthCredential phoneAuthCredential2 = (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR);
                IBinder readStrongBinder24 = parcel.readStrongBinder();
                if (readStrongBinder24 != null) {
                    IInterface queryLocalInterface24 = readStrongBinder24.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface24 instanceof zzch ? (zzch) queryLocalInterface24 : new zzcj(readStrongBinder24);
                }
                zza(readString28, phoneAuthCredential2, zzch);
                break;
            case 25:
                String readString29 = parcel.readString();
                ActionCodeSettings actionCodeSettings = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder25 = parcel.readStrongBinder();
                if (readStrongBinder25 != null) {
                    IInterface queryLocalInterface25 = readStrongBinder25.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface25 instanceof zzch ? (zzch) queryLocalInterface25 : new zzcj(readStrongBinder25);
                }
                zza(readString29, actionCodeSettings, zzch);
                break;
            case MotionEventCompat.AXIS_SCROLL:
                String readString30 = parcel.readString();
                ActionCodeSettings actionCodeSettings2 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder26 = parcel.readStrongBinder();
                if (readStrongBinder26 != null) {
                    IInterface queryLocalInterface26 = readStrongBinder26.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface26 instanceof zzch ? (zzch) queryLocalInterface26 : new zzcj(readStrongBinder26);
                }
                zzb(readString30, actionCodeSettings2, zzch);
                break;
            case MotionEventCompat.AXIS_RELATIVE_X:
                String readString31 = parcel.readString();
                IBinder readStrongBinder27 = parcel.readStrongBinder();
                if (readStrongBinder27 != null) {
                    IInterface queryLocalInterface27 = readStrongBinder27.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface27 instanceof zzch ? (zzch) queryLocalInterface27 : new zzcj(readStrongBinder27);
                }
                zzk(readString31, zzch);
                break;
            case MotionEventCompat.AXIS_RELATIVE_Y:
                String readString32 = parcel.readString();
                ActionCodeSettings actionCodeSettings3 = (ActionCodeSettings) zzc.zza(parcel, ActionCodeSettings.CREATOR);
                IBinder readStrongBinder28 = parcel.readStrongBinder();
                if (readStrongBinder28 != null) {
                    IInterface queryLocalInterface28 = readStrongBinder28.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface28 instanceof zzch ? (zzch) queryLocalInterface28 : new zzcj(readStrongBinder28);
                }
                zzc(readString32, actionCodeSettings3, zzch);
                break;
            case 29:
                EmailAuthCredential emailAuthCredential = (EmailAuthCredential) zzc.zza(parcel, EmailAuthCredential.CREATOR);
                IBinder readStrongBinder29 = parcel.readStrongBinder();
                if (readStrongBinder29 != null) {
                    IInterface queryLocalInterface29 = readStrongBinder29.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
                    zzch = queryLocalInterface29 instanceof zzch ? (zzch) queryLocalInterface29 : new zzcj(readStrongBinder29);
                }
                zza(emailAuthCredential, zzch);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
