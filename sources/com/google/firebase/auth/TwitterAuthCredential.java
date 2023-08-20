package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzbf;

@SafeParcelable.Class(creator = "TwitterAuthCredentialCreator")
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzv();
    @SafeParcelable.Field(getter = "getToken", mo8007id = 1)
    private String zzdf;
    @SafeParcelable.Field(getter = "getSecret", mo8007id = 2)
    private String zzfa;

    @SafeParcelable.Constructor
    TwitterAuthCredential(@SafeParcelable.Param(mo8010id = 1) @NonNull String str, @SafeParcelable.Param(mo8010id = 2) @NonNull String str2) {
        this.zzdf = Preconditions.checkNotEmpty(str);
        this.zzfa = Preconditions.checkNotEmpty(str2);
    }

    public static zzbf zza(@NonNull TwitterAuthCredential twitterAuthCredential) {
        Preconditions.checkNotNull(twitterAuthCredential);
        return new zzbf((String) null, twitterAuthCredential.zzdf, twitterAuthCredential.getProvider(), (String) null, twitterAuthCredential.zzfa);
    }

    public String getProvider() {
        return "twitter.com";
    }

    public String getSignInMethod() {
        return "twitter.com";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdf, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzfa, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
