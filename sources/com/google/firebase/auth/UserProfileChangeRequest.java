package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserProfileChangeRequestCreator")
@SafeParcelable.Reserved({1})
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzw();
    @SafeParcelable.Field(getter = "getDisplayName", mo8007id = 2)
    private String zzbf;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo8007id = 3)
    private String zzbp;
    @SafeParcelable.Field(getter = "shouldRemoveDisplayName", mo8007id = 4)
    private boolean zzfb;
    @SafeParcelable.Field(getter = "shouldRemovePhotoUri", mo8007id = 5)
    private boolean zzfc;
    private Uri zzfd;

    public static class Builder {
        private String zzbf;
        private boolean zzfb;
        private boolean zzfc;
        private Uri zzfd;

        public UserProfileChangeRequest build() {
            return new UserProfileChangeRequest(this.zzbf, this.zzfd == null ? null : this.zzfd.toString(), this.zzfb, this.zzfc);
        }

        public Builder setDisplayName(@Nullable String str) {
            if (str == null) {
                this.zzfb = true;
            } else {
                this.zzbf = str;
            }
            return this;
        }

        public Builder setPhotoUri(@Nullable Uri uri) {
            if (uri == null) {
                this.zzfc = true;
            } else {
                this.zzfd = uri;
            }
            return this;
        }
    }

    @SafeParcelable.Constructor
    UserProfileChangeRequest(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) boolean z, @SafeParcelable.Param(mo8010id = 5) boolean z2) {
        this.zzbf = str;
        this.zzbp = str2;
        this.zzfb = z;
        this.zzfc = z2;
        this.zzfd = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzbf;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.zzfd;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzbp, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzfb);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzfc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzr() {
        return this.zzbp;
    }

    public final boolean zzs() {
        return this.zzfb;
    }

    public final boolean zzt() {
        return this.zzfc;
    }
}
