package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GassRequestParcelCreator")
public final class zzatt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzatt> CREATOR = new zzatu();
    @SafeParcelable.Field(mo8007id = 2)
    private final String packageName;
    @SafeParcelable.VersionField(mo8013id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo8007id = 3)
    private final String zzdhd;

    @SafeParcelable.Constructor
    zzatt(@SafeParcelable.Param(mo8010id = 1) int i, @SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.zzdhd = str2;
    }

    public zzatt(String str, String str2) {
        this(1, str, str2);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdhd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
