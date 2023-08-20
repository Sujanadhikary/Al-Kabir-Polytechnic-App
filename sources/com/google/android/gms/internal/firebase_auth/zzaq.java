package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProviderUserInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 8)
    private String zzaf;
    @SafeParcelable.Field(getter = "getPhoneNumber", mo8007id = 7)
    private String zzbb;
    @SafeParcelable.Field(getter = "getDisplayName", mo8007id = 3)
    private String zzbf;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo8007id = 4)
    private String zzbp;
    @SafeParcelable.Field(getter = "getFederatedId", mo8007id = 2)
    private String zzce;
    @SafeParcelable.Field(getter = "getRawUserInfo", mo8007id = 6)
    private String zzdd;
    @SafeParcelable.Field(getter = "getProviderId", mo8007id = 5)
    private String zzj;

    public zzaq() {
    }

    @SafeParcelable.Constructor
    zzaq(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) String str3, @SafeParcelable.Param(mo8010id = 5) String str4, @SafeParcelable.Param(mo8010id = 6) String str5, @SafeParcelable.Param(mo8010id = 7) String str6, @SafeParcelable.Param(mo8010id = 8) String str7) {
        this.zzce = str;
        this.zzbf = str2;
        this.zzbp = str3;
        this.zzj = str4;
        this.zzdd = str5;
        this.zzbb = str6;
        this.zzaf = str7;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbf;
    }

    @Nullable
    public final String getEmail() {
        return this.zzaf;
    }

    public final String getPhoneNumber() {
        return this.zzbb;
    }

    @Nullable
    public final Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.zzbp)) {
            return Uri.parse(this.zzbp);
        }
        return null;
    }

    public final String getProviderId() {
        return this.zzj;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzdd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzce, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbf, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbp, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzj, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzdd, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzbb, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzaf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzax() {
        return this.zzce;
    }

    public final void zzt(String str) {
        this.zzdd = str;
    }
}
