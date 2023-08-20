package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzd;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
public final class zzf implements AuthResult {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getUser", mo8007id = 1)
    private zzk zzkn;
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", mo8007id = 2)
    private zzd zzko;
    @SafeParcelable.Field(getter = "getOAuthCredential", mo8007id = 3)
    private zzd zzkp;

    public zzf(@NonNull zzk zzk) {
        this.zzkn = (zzk) Preconditions.checkNotNull(zzk);
        List<zzh> zzbd = this.zzkn.zzbd();
        this.zzko = null;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zzbd.size()) {
                break;
            }
            if (!TextUtils.isEmpty(zzbd.get(i2).getRawUserInfo())) {
                this.zzko = new zzd(zzbd.get(i2).getProviderId(), zzbd.get(i2).getRawUserInfo(), zzk.isNewUser());
            }
            i = i2 + 1;
        }
        if (this.zzko == null) {
            this.zzko = new zzd(zzk.isNewUser());
        }
        this.zzkp = zzk.zzat();
    }

    @SafeParcelable.Constructor
    zzf(@SafeParcelable.Param(mo8010id = 1) zzk zzk, @SafeParcelable.Param(mo8010id = 2) zzd zzd, @SafeParcelable.Param(mo8010id = 3) zzd zzd2) {
        this.zzkn = zzk;
        this.zzko = zzd;
        this.zzkp = zzd2;
    }

    public final int describeContents() {
        return 0;
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzko;
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zzkn;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzkp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
