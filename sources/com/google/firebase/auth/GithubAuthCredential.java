package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzbf;

@SafeParcelable.Class(creator = "GithubAuthCredentialCreator")
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzq();
    @SafeParcelable.Field(getter = "getToken", mo8007id = 1)
    private String zzdf;

    @SafeParcelable.Constructor
    GithubAuthCredential(@SafeParcelable.Param(mo8010id = 1) @NonNull String str) {
        this.zzdf = Preconditions.checkNotEmpty(str);
    }

    public static zzbf zza(@NonNull GithubAuthCredential githubAuthCredential) {
        Preconditions.checkNotNull(githubAuthCredential);
        return new zzbf((String) null, githubAuthCredential.zzdf, githubAuthCredential.getProvider(), (String) null, (String) null);
    }

    public String getProvider() {
        return "github.com";
    }

    public String getSignInMethod() {
        return "github.com";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzdf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
