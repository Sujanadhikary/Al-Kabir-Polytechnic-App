package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzd;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoUserCreator")
@SafeParcelable.Reserved({1})
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new zzak();
    @SafeParcelable.Field(getter = "getLocalId", mo8007id = 2)
    private String zzab;
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 3)
    private String zzaf;
    @SafeParcelable.Field(getter = "isNewUser", mo8007id = 12)
    private boolean zzai;
    @SafeParcelable.Field(getter = "getPhoneNumber", mo8007id = 9)
    private String zzbb;
    @SafeParcelable.Field(getter = "getDisplayName", mo8007id = 5)
    private String zzbf;
    @SafeParcelable.Field(getter = "getPassword", mo8007id = 8)
    private String zzbg;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo8007id = 6)
    private String zzbp;
    @SafeParcelable.Field(getter = "isEmailVerified", mo8007id = 4)
    private boolean zzjl;
    @SafeParcelable.Field(getter = "getProviderInfoList", mo8007id = 7)
    private zzas zzjm;
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo8007id = 10)
    private long zzjn;
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", mo8007id = 11)
    private long zzjo;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", mo8007id = 13)
    private zzd zzjp;

    public zzaj() {
        this.zzjm = new zzas();
    }

    @SafeParcelable.Constructor
    public zzaj(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) boolean z, @SafeParcelable.Param(mo8010id = 5) String str3, @SafeParcelable.Param(mo8010id = 6) String str4, @SafeParcelable.Param(mo8010id = 7) zzas zzas, @SafeParcelable.Param(mo8010id = 8) String str5, @SafeParcelable.Param(mo8010id = 9) String str6, @SafeParcelable.Param(mo8010id = 10) long j, @SafeParcelable.Param(mo8010id = 11) long j2, @SafeParcelable.Param(mo8010id = 12) boolean z2, @SafeParcelable.Param(mo8010id = 13) zzd zzd) {
        this.zzab = str;
        this.zzaf = str2;
        this.zzjl = z;
        this.zzbf = str3;
        this.zzbp = str4;
        this.zzjm = zzas == null ? new zzas() : zzas.zza(zzas);
        this.zzbg = str5;
        this.zzbb = str6;
        this.zzjn = j;
        this.zzjo = j2;
        this.zzai = z2;
        this.zzjp = zzd;
    }

    public final long getCreationTimestamp() {
        return this.zzjn;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzbf;
    }

    @Nullable
    public final String getEmail() {
        return this.zzaf;
    }

    public final long getLastSignInTimestamp() {
        return this.zzjo;
    }

    @NonNull
    public final String getLocalId() {
        return this.zzab;
    }

    @Nullable
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

    public final boolean isEmailVerified() {
        return this.zzjl;
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzab, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzaf, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzjl);
        SafeParcelWriter.writeString(parcel, 5, this.zzbf, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbp, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzjm, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzbg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzbb, false);
        SafeParcelWriter.writeLong(parcel, 10, this.zzjn);
        SafeParcelWriter.writeLong(parcel, 11, this.zzjo);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzai);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzjp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final List<zzaq> zzar() {
        return this.zzjm.zzar();
    }

    public final zzas zzas() {
        return this.zzjm;
    }

    @Nullable
    public final zzd zzat() {
        return this.zzjp;
    }

    @NonNull
    public final zzaj zzb(zzd zzd) {
        this.zzjp = zzd;
        return this;
    }

    @NonNull
    public final zzaj zzb(@NonNull List<zzaq> list) {
        Preconditions.checkNotNull(list);
        this.zzjm = new zzas();
        this.zzjm.zzar().addAll(list);
        return this;
    }

    public final zzaj zzd(boolean z) {
        this.zzai = z;
        return this;
    }

    @NonNull
    public final zzaj zzl(@Nullable String str) {
        this.zzaf = str;
        return this;
    }

    @NonNull
    public final zzaj zzm(@Nullable String str) {
        this.zzbf = str;
        return this;
    }

    @NonNull
    public final zzaj zzn(@Nullable String str) {
        this.zzbp = str;
        return this;
    }

    @NonNull
    public final zzaj zzo(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        this.zzbg = str;
        return this;
    }
}
