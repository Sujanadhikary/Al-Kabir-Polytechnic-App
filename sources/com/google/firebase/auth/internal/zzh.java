package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzv;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultAuthUserInfoCreator")
public final class zzh extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();
    @Nullable
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 5)
    private String zzaf;
    @Nullable
    @SafeParcelable.Field(getter = "getPhoneNumber", mo8007id = 6)
    private String zzbb;
    @Nullable
    @SafeParcelable.Field(getter = "getDisplayName", mo8007id = 3)
    private String zzbf;
    @Nullable
    @SafeParcelable.Field(getter = "getPhotoUrlString", mo8007id = 4)
    private String zzbp;
    @Nullable
    @SafeParcelable.Field(getter = "getRawUserInfo", mo8007id = 8)
    private String zzdd;
    @Nullable
    private Uri zzfd;
    @SafeParcelable.Field(getter = "getProviderId", mo8007id = 2)
    @NonNull
    private String zzj;
    @SafeParcelable.Field(getter = "isEmailVerified", mo8007id = 7)
    private boolean zzjl;
    @SafeParcelable.Field(getter = "getUid", mo8007id = 1)
    @NonNull
    private String zzkq;

    public zzh(@NonNull zzaj zzaj, @NonNull String str) {
        Preconditions.checkNotNull(zzaj);
        Preconditions.checkNotEmpty(str);
        this.zzkq = Preconditions.checkNotEmpty(zzaj.getLocalId());
        this.zzj = str;
        this.zzaf = zzaj.getEmail();
        this.zzbf = zzaj.getDisplayName();
        Uri photoUri = zzaj.getPhotoUri();
        if (photoUri != null) {
            this.zzbp = photoUri.toString();
            this.zzfd = photoUri;
        }
        this.zzjl = zzaj.isEmailVerified();
        this.zzdd = null;
        this.zzbb = zzaj.getPhoneNumber();
    }

    public zzh(@NonNull zzaq zzaq) {
        Preconditions.checkNotNull(zzaq);
        this.zzkq = zzaq.zzax();
        this.zzj = Preconditions.checkNotEmpty(zzaq.getProviderId());
        this.zzbf = zzaq.getDisplayName();
        Uri photoUri = zzaq.getPhotoUri();
        if (photoUri != null) {
            this.zzbp = photoUri.toString();
            this.zzfd = photoUri;
        }
        this.zzaf = zzaq.getEmail();
        this.zzbb = zzaq.getPhoneNumber();
        this.zzjl = false;
        this.zzdd = zzaq.getRawUserInfo();
    }

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzh(@SafeParcelable.Param(mo8010id = 1) @NonNull String str, @SafeParcelable.Param(mo8010id = 2) @NonNull String str2, @Nullable @SafeParcelable.Param(mo8010id = 3) String str3, @Nullable @SafeParcelable.Param(mo8010id = 4) String str4, @Nullable @SafeParcelable.Param(mo8010id = 5) String str5, @Nullable @SafeParcelable.Param(mo8010id = 6) String str6, @SafeParcelable.Param(mo8010id = 7) boolean z, @Nullable @SafeParcelable.Param(mo8010id = 8) String str7) {
        this.zzkq = str;
        this.zzj = str2;
        this.zzaf = str3;
        this.zzbb = str4;
        this.zzbf = str5;
        this.zzbp = str6;
        if (!TextUtils.isEmpty(this.zzbp)) {
            this.zzfd = Uri.parse(this.zzbp);
        }
        this.zzjl = z;
        this.zzdd = str7;
    }

    @Nullable
    public static zzh zzad(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzh(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzv((Throwable) e);
        }
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbf;
    }

    @Nullable
    public final String getEmail() {
        return this.zzaf;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzbb;
    }

    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzbp) && this.zzfd == null) {
            this.zzfd = Uri.parse(this.zzbp);
        }
        return this.zzfd;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzj;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzdd;
    }

    @NonNull
    public final String getUid() {
        return this.zzkq;
    }

    public final boolean isEmailVerified() {
        return this.zzjl;
    }

    @Nullable
    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zzkq);
            jSONObject.putOpt("providerId", this.zzj);
            jSONObject.putOpt("displayName", this.zzbf);
            jSONObject.putOpt("photoUrl", this.zzbp);
            jSONObject.putOpt("email", this.zzaf);
            jSONObject.putOpt("phoneNumber", this.zzbb);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzjl));
            jSONObject.putOpt("rawUserInfo", this.zzdd);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzv((Throwable) e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbp, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzdd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
