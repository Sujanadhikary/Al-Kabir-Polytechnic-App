package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzbf;

@SafeParcelable.Class(creator = "PlayGamesAuthCredentialCreator")
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzu();
    @SafeParcelable.Field(getter = "getServerAuthCode", mo8007id = 1)
    private final String zzez;

    @SafeParcelable.Constructor
    PlayGamesAuthCredential(@SafeParcelable.Param(mo8010id = 1) @NonNull String str) {
        this.zzez = Preconditions.checkNotEmpty(str);
    }

    public static zzbf zza(@NonNull PlayGamesAuthCredential playGamesAuthCredential) {
        Preconditions.checkNotNull(playGamesAuthCredential);
        return new zzbf((String) null, (String) null, playGamesAuthCredential.getProvider(), (String) null, (String) null, playGamesAuthCredential.zzez);
    }

    public String getProvider() {
        return "playgames.google.com";
    }

    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzez, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
