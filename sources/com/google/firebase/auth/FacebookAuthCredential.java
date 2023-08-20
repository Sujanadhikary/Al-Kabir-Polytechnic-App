package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzbf;

@SafeParcelable.Class(creator = "FacebookAuthCredentialCreator")
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getAccessToken", mo8007id = 1)
    private final String zzdt;

    @SafeParcelable.Constructor
    FacebookAuthCredential(@SafeParcelable.Param(mo8010id = 1) @NonNull String str) {
        this.zzdt = Preconditions.checkNotEmpty(str);
    }

    public static zzbf zza(@NonNull FacebookAuthCredential facebookAuthCredential) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzbf((String) null, facebookAuthCredential.zzdt, facebookAuthCredential.getProvider(), (String) null, (String) null);
    }

    public String getProvider() {
        return "facebook.com";
    }

    public String getSignInMethod() {
        return "facebook.com";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
