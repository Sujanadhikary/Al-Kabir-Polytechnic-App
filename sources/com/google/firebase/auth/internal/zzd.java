package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "DefaultAdditionalUserInfoCreator")
public final class zzd implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(getter = "isNewUser", mo8007id = 3)
    private boolean zzai;
    @SafeParcelable.Field(getter = "getRawUserInfo", mo8007id = 2)
    private final String zzdd;
    @SafeParcelable.Field(getter = "getProviderId", mo8007id = 1)
    private final String zzj;
    private Map<String, Object> zzkm;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(mo8010id = 1) String str, @SafeParcelable.Param(mo8010id = 2) String str2, @SafeParcelable.Param(mo8010id = 3) boolean z) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zzj = str;
        this.zzdd = str2;
        this.zzkm = zzy.zzai(str2);
        this.zzai = z;
    }

    public zzd(boolean z) {
        this.zzai = z;
        this.zzdd = null;
        this.zzj = null;
        this.zzkm = null;
    }

    public final int describeContents() {
        return 0;
    }

    @Nullable
    public final Map<String, Object> getProfile() {
        return this.zzkm;
    }

    @Nullable
    public final String getProviderId() {
        return this.zzj;
    }

    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.zzj)) {
            return (String) this.zzkm.get(FirebaseAnalytics.Event.LOGIN);
        }
        if ("twitter.com".equals(this.zzj)) {
            return (String) this.zzkm.get("screen_name");
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzdd, false);
        SafeParcelWriter.writeBoolean(parcel, 3, isNewUser());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
