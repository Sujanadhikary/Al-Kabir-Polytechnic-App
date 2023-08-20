package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.api.internal.zzdp;

@SafeParcelable.Class(creator = "SendVerificationCodeRequestCreator")
public final class zzax extends AbstractSafeParcelable implements zzdp<zzn> {
    public static final Parcelable.Creator<zzax> CREATOR = new zzay();
    @SafeParcelable.Field(getter = "getPhoneNumber", mo8007id = 1)
    private final String zzbb;
    @SafeParcelable.Field(getter = "getTimeoutInSeconds", mo8007id = 2)
    private final long zzjw;
    @SafeParcelable.Field(getter = "getForceNewSmsVerificationSession", mo8007id = 3)
    private final boolean zzjx;
    @SafeParcelable.Field(getter = "getLanguageHeader", mo8007id = 4)
    private final String zzjy;

    @SafeParcelable.Constructor
    public zzax(@SafeParcelable.Param(mo8010id = 1) String str, @SafeParcelable.Param(mo8010id = 2) long j, @SafeParcelable.Param(mo8010id = 3) boolean z, @SafeParcelable.Param(mo8010id = 4) String str2) {
        this.zzbb = str;
        this.zzjw = j;
        this.zzjx = z;
        this.zzjy = str2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzbb, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzjw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzjx);
        SafeParcelWriter.writeString(parcel, 4, this.zzjy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzgv zzam() {
        zzn zzn = new zzn();
        zzn.zzbb = this.zzbb;
        return zzn;
    }
}
