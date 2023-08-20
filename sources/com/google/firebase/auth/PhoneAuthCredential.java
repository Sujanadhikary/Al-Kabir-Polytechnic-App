package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "PhoneAuthCredentialCreator")
public class PhoneAuthCredential extends AuthCredential implements Cloneable {
    public static final Parcelable.Creator<PhoneAuthCredential> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getPhoneNumber", mo8007id = 4)
    private String zzbb;
    @SafeParcelable.Field(getter = "getAutoCreate", mo8007id = 5)
    private boolean zzcd;
    @SafeParcelable.Field(getter = "getSessionInfo", mo8007id = 1)
    private String zzeu;
    @SafeParcelable.Field(getter = "getSmsCode", mo8007id = 2)
    private String zzev;
    @SafeParcelable.Field(getter = "getHasVerificationProof", mo8007id = 3)
    private boolean zzew;
    @SafeParcelable.Field(getter = "getTemporaryProof", mo8007id = 6)
    private String zzex;

    @SafeParcelable.Constructor
    PhoneAuthCredential(@Nullable @SafeParcelable.Param(mo8010id = 1) String str, @Nullable @SafeParcelable.Param(mo8010id = 2) String str2, @SafeParcelable.Param(mo8010id = 3) boolean z, @Nullable @SafeParcelable.Param(mo8010id = 4) String str3, @SafeParcelable.Param(mo8010id = 5) boolean z2, @Nullable @SafeParcelable.Param(mo8010id = 6) String str4) {
        Preconditions.checkArgument((z && !TextUtils.isEmpty(str3)) || (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)), "Cannot create PhoneAuthCredential without either verificationProof, sessionInfo, ortemprary proof.");
        this.zzeu = str;
        this.zzev = str2;
        this.zzew = z;
        this.zzbb = str3;
        this.zzcd = z2;
        this.zzex = str4;
    }

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new PhoneAuthCredential(this.zzeu, getSmsCode(), this.zzew, this.zzbb, this.zzcd, this.zzex);
    }

    @NonNull
    public String getProvider() {
        return "phone";
    }

    public String getSignInMethod() {
        return "phone";
    }

    @Nullable
    public String getSmsCode() {
        return this.zzev;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzeu, false);
        SafeParcelWriter.writeString(parcel, 2, getSmsCode(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzew);
        SafeParcelWriter.writeString(parcel, 4, this.zzbb, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcd);
        SafeParcelWriter.writeString(parcel, 6, this.zzex, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PhoneAuthCredential zzb(boolean z) {
        this.zzcd = false;
        return this;
    }
}
