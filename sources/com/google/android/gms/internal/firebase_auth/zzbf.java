package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.api.internal.zzdp;

@SafeParcelable.Class(creator = "VerifyAssertionRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzbf extends AbstractSafeParcelable implements zzdp<zzq> {
    public static final Parcelable.Creator<zzbf> CREATOR = new zzbg();
    @SafeParcelable.Field(getter = "getIdToken", mo8007id = 4)
    private String zzad;
    @Nullable
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 7)
    private String zzaf;
    @SafeParcelable.Field(getter = "getReturnSecureToken", mo8007id = 10)
    private boolean zzbr;
    @SafeParcelable.Field(getter = "getRequestUri", mo8007id = 2)
    private String zzby;
    @SafeParcelable.Field(getter = "getPostBody", mo8007id = 8)
    private String zzbz;
    @SafeParcelable.Field(getter = "getAutoCreate", mo8007id = 11)
    private boolean zzcd;
    @SafeParcelable.Field(getter = "getOauthTokenSecret", mo8007id = 9)
    private String zzda;
    @SafeParcelable.Field(getter = "getAccessToken", mo8007id = 5)
    private String zzdt;
    @SafeParcelable.Field(getter = "getProviderId", mo8007id = 6)
    private String zzj;
    @SafeParcelable.Field(getter = "getCurrentIdToken", mo8007id = 3)
    private String zzkd;
    @SafeParcelable.Field(getter = "getAuthCode", mo8007id = 12)
    private String zzke;
    @SafeParcelable.Field(getter = "getIdpResponseUrl", mo8007id = 14)
    private String zzkf;
    @SafeParcelable.Field(getter = "getSessionId", mo8007id = 13)
    private String zzr;

    public zzbf() {
        this.zzbr = true;
        this.zzcd = true;
    }

    public zzbf(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5) {
        this(str, str2, str3, (String) null, str5, (String) null);
    }

    public zzbf(@Nullable String str, @Nullable String str2, String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.zzby = "http://localhost";
        this.zzad = str;
        this.zzdt = str2;
        this.zzda = str5;
        this.zzke = str6;
        this.zzbr = true;
        if (!TextUtils.isEmpty(this.zzad) || !TextUtils.isEmpty(this.zzdt) || !TextUtils.isEmpty(this.zzke)) {
            this.zzj = Preconditions.checkNotEmpty(str3);
            this.zzaf = null;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzad)) {
                sb.append("id_token=").append(this.zzad).append("&");
            }
            if (!TextUtils.isEmpty(this.zzdt)) {
                sb.append("access_token=").append(this.zzdt).append("&");
            }
            if (!TextUtils.isEmpty(this.zzaf)) {
                sb.append("identifier=").append(this.zzaf).append("&");
            }
            if (!TextUtils.isEmpty(this.zzda)) {
                sb.append("oauth_token_secret=").append(this.zzda).append("&");
            }
            if (!TextUtils.isEmpty(this.zzke)) {
                sb.append("code=").append(this.zzke).append("&");
            }
            sb.append("providerId=").append(this.zzj);
            this.zzbz = sb.toString();
            this.zzcd = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    @SafeParcelable.Constructor
    zzbf(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) String str3, @SafeParcelable.Param(mo8010id = 5) String str4, @SafeParcelable.Param(mo8010id = 6) String str5, @SafeParcelable.Param(mo8010id = 7) String str6, @SafeParcelable.Param(mo8010id = 8) String str7, @SafeParcelable.Param(mo8010id = 9) String str8, @SafeParcelable.Param(mo8010id = 10) boolean z, @SafeParcelable.Param(mo8010id = 11) boolean z2, @SafeParcelable.Param(mo8010id = 12) String str9, @SafeParcelable.Param(mo8010id = 13) String str10, @SafeParcelable.Param(mo8010id = 14) String str11) {
        this.zzby = str;
        this.zzkd = str2;
        this.zzad = str3;
        this.zzdt = str4;
        this.zzj = str5;
        this.zzaf = str6;
        this.zzbz = str7;
        this.zzda = str8;
        this.zzbr = z;
        this.zzcd = z2;
        this.zzke = str9;
        this.zzr = str10;
        this.zzkf = str11;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzby, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzkd, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzdt, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzj, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzaf, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbz, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzda, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbr);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzcd);
        SafeParcelWriter.writeString(parcel, 12, this.zzke, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzr, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzkf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzbf zzac(@NonNull String str) {
        this.zzkd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final /* synthetic */ zzgv zzam() {
        zzq zzq = new zzq();
        zzq.zzad = this.zzkd;
        zzq.zzby = this.zzby;
        zzq.zzbz = this.zzbz;
        zzq.zzbr = this.zzbr;
        zzq.zzcd = this.zzcd;
        if (!TextUtils.isEmpty(this.zzr)) {
            zzq.zzr = this.zzr;
        }
        if (!TextUtils.isEmpty(this.zzkf)) {
            zzq.zzby = this.zzkf;
        }
        return zzq;
    }

    public final zzbf zze(boolean z) {
        this.zzcd = false;
        return this;
    }
}
