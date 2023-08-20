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

@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
public class zzd extends zzs {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getIdToken", mo8007id = 2)
    private final String zzad;
    @SafeParcelable.Field(getter = "getAccessToken", mo8007id = 3)
    private final String zzdt;
    @SafeParcelable.Field(getter = "getWebSignInCredential", mo8007id = 4)
    private final zzbf zzdu;
    @SafeParcelable.Field(getter = "getProvider", mo8007id = 1)
    private final String zzj;

    @SafeParcelable.Constructor
    zzd(@SafeParcelable.Param(mo8010id = 1) @NonNull String str, @Nullable @SafeParcelable.Param(mo8010id = 2) String str2, @Nullable @SafeParcelable.Param(mo8010id = 3) String str3, @Nullable @SafeParcelable.Param(mo8010id = 4) zzbf zzbf) {
        this.zzj = str;
        this.zzad = str2;
        this.zzdt = str3;
        this.zzdu = zzbf;
    }

    public static zzbf zza(@NonNull zzd zzd) {
        Preconditions.checkNotNull(zzd);
        return zzd.zzdu != null ? zzd.zzdu : new zzbf(zzd.zzad, zzd.zzdt, zzd.getProvider(), (String) null, (String) null);
    }

    public static zzd zza(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId"), str2, str3, (zzbf) null);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public String getProvider() {
        return this.zzj;
    }

    public String getSignInMethod() {
        return this.zzj;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdt, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdu, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
