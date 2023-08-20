package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzbf;

@SafeParcelable.Class(creator = "GoogleAuthCredentialCreator")
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getIdToken", mo8007id = 1)
    private final String zzad;
    @SafeParcelable.Field(getter = "getAccessToken", mo8007id = 2)
    private final String zzdt;

    @SafeParcelable.Constructor
    GoogleAuthCredential(@Nullable @SafeParcelable.Param(mo8010id = 1) String str, @Nullable @SafeParcelable.Param(mo8010id = 2) String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.zzad = zza(str, "idToken");
        this.zzdt = zza(str2, "accessToken");
    }

    public static zzbf zza(@NonNull GoogleAuthCredential googleAuthCredential) {
        Preconditions.checkNotNull(googleAuthCredential);
        return new zzbf(googleAuthCredential.zzad, googleAuthCredential.zzdt, googleAuthCredential.getProvider(), (String) null, (String) null);
    }

    private static String zza(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    public String getProvider() {
        return "google.com";
    }

    public String getSignInMethod() {
        return "google.com";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
