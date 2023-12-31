package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GoogleSignInOptionsExtensionCreator")
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new GoogleSignInOptionsExtensionCreator();
    @SafeParcelable.Field(getter = "getBundle", mo8007id = 3)
    private Bundle mBundle;
    @SafeParcelable.VersionField(mo8013id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getType", mo8007id = 2)
    private int zzac;

    @SafeParcelable.Constructor
    GoogleSignInOptionsExtensionParcelable(@SafeParcelable.Param(mo8010id = 1) int i, @GoogleSignInOptionsExtension.TypeId @SafeParcelable.Param(mo8010id = 2) int i2, @SafeParcelable.Param(mo8010id = 3) Bundle bundle) {
        this.versionCode = i;
        this.zzac = i2;
        this.mBundle = bundle;
    }

    public GoogleSignInOptionsExtensionParcelable(GoogleSignInOptionsExtension googleSignInOptionsExtension) {
        this(1, googleSignInOptionsExtension.getExtensionType(), googleSignInOptionsExtension.toBundle());
    }

    public Bundle getBundle() {
        return this.mBundle;
    }

    @GoogleSignInOptionsExtension.TypeId
    public int getType() {
        return this.zzac;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeBundle(parcel, 3, getBundle(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
