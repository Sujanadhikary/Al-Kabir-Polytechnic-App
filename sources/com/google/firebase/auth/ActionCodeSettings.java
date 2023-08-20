package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ActionCodeSettingsCreator")
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zzb();
    @SafeParcelable.Field(getter = "getUrl", mo8007id = 1)
    private final String url;
    @SafeParcelable.Field(getter = "getRequestType", mo8007id = 9)
    private int zzam;
    @SafeParcelable.Field(getter = "getAndroidPackageName", mo8007id = 4)
    private final String zzau;
    @SafeParcelable.Field(getter = "getAndroidInstallApp", mo8007id = 5)
    private final boolean zzav;
    @SafeParcelable.Field(getter = "getAndroidMinimumVersion", mo8007id = 6)
    private final String zzaw;
    @SafeParcelable.Field(getter = "canHandleCodeInApp", mo8007id = 7)
    private final boolean zzax;
    @SafeParcelable.Field(getter = "getIOSBundle", mo8007id = 2)
    private final String zzdq;
    @SafeParcelable.Field(getter = "getIOSAppStoreId", mo8007id = 3)
    private final String zzdr;
    @SafeParcelable.Field(getter = "getLocaleHeader", mo8007id = 8)
    private String zzds;

    public static class Builder {
        /* access modifiers changed from: private */
        public String url;
        /* access modifiers changed from: private */
        public String zzau;
        /* access modifiers changed from: private */
        public boolean zzav;
        /* access modifiers changed from: private */
        public String zzaw;
        /* access modifiers changed from: private */
        public boolean zzax;
        /* access modifiers changed from: private */
        public String zzdq;

        private Builder() {
            this.zzax = false;
        }

        public ActionCodeSettings build() {
            return new ActionCodeSettings(this);
        }

        public Builder setAndroidPackageName(@NonNull String str, boolean z, @Nullable String str2) {
            this.zzau = str;
            this.zzav = z;
            this.zzaw = str2;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzax = z;
            return this;
        }

        public Builder setIOSBundleId(@NonNull String str) {
            this.zzdq = str;
            return this;
        }

        public Builder setUrl(@NonNull String str) {
            this.url = str;
            return this;
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.url = builder.url;
        this.zzdq = builder.zzdq;
        this.zzdr = null;
        this.zzau = builder.zzau;
        this.zzav = builder.zzav;
        this.zzaw = builder.zzaw;
        this.zzax = builder.zzax;
    }

    @SafeParcelable.Constructor
    ActionCodeSettings(@SafeParcelable.Param(mo8010id = 1) String str, @SafeParcelable.Param(mo8010id = 2) String str2, @SafeParcelable.Param(mo8010id = 3) String str3, @SafeParcelable.Param(mo8010id = 4) String str4, @SafeParcelable.Param(mo8010id = 5) boolean z, @SafeParcelable.Param(mo8010id = 6) String str5, @SafeParcelable.Param(mo8010id = 7) boolean z2, @SafeParcelable.Param(mo8010id = 8) String str6, @SafeParcelable.Param(mo8010id = 9) int i) {
        this.url = str;
        this.zzdq = str2;
        this.zzdr = str3;
        this.zzau = str4;
        this.zzav = z;
        this.zzaw = str5;
        this.zzax = z2;
        this.zzds = str6;
        this.zzam = i;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public boolean canHandleCodeInApp() {
        return this.zzax;
    }

    public boolean getAndroidInstallApp() {
        return this.zzav;
    }

    public String getAndroidMinimumVersion() {
        return this.zzaw;
    }

    public String getAndroidPackageName() {
        return this.zzau;
    }

    public String getIOSBundle() {
        return this.zzdq;
    }

    public final int getRequestType() {
        return this.zzam;
    }

    public String getUrl() {
        return this.url;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUrl(), false);
        SafeParcelWriter.writeString(parcel, 2, getIOSBundle(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdr, false);
        SafeParcelWriter.writeString(parcel, 4, getAndroidPackageName(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getAndroidInstallApp());
        SafeParcelWriter.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, canHandleCodeInApp());
        SafeParcelWriter.writeString(parcel, 8, this.zzds, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzam);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zza(@NonNull String str) {
        this.zzds = str;
    }

    public final void zzb(@NonNull int i) {
        this.zzam = i;
    }

    public final String zze() {
        return this.zzdr;
    }
}
