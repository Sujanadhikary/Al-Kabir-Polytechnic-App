package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;

@KeepForSdk
@SafeParcelable.Class(creator = "StatusCreator")
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zze();
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @KeepForSdk
    @VisibleForTesting
    public static final Status RESULT_SUCCESS = new Status(0);
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    private static final Status zzdq = new Status(17);
    @SafeParcelable.VersionField(mo8013id = 1000)
    private final int zzal;
    @SafeParcelable.Field(getter = "getStatusCode", mo8007id = 1)
    private final int zzam;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingIntent", mo8007id = 3)
    private final PendingIntent zzan;
    @Nullable
    @SafeParcelable.Field(getter = "getStatusMessage", mo8007id = 2)
    private final String zzao;

    @KeepForSdk
    public Status(int i) {
        this(i, (String) null);
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    Status(@SafeParcelable.Param(mo8010id = 1000) int i, @SafeParcelable.Param(mo8010id = 1) int i2, @Nullable @SafeParcelable.Param(mo8010id = 2) String str, @Nullable @SafeParcelable.Param(mo8010id = 3) PendingIntent pendingIntent) {
        this.zzal = i;
        this.zzam = i2;
        this.zzao = str;
        this.zzan = pendingIntent;
    }

    @KeepForSdk
    public Status(int i, @Nullable String str) {
        this(1, i, str, (PendingIntent) null);
    }

    @KeepForSdk
    public Status(int i, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.zzal == status.zzal && this.zzam == status.zzam && Objects.equal(this.zzao, status.zzao) && Objects.equal(this.zzan, status.zzan);
    }

    public final PendingIntent getResolution() {
        return this.zzan;
    }

    @KeepForSdk
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzam;
    }

    @Nullable
    public final String getStatusMessage() {
        return this.zzao;
    }

    @VisibleForTesting
    public final boolean hasResolution() {
        return this.zzan != null;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzal), Integer.valueOf(this.zzam), this.zzao, this.zzan);
    }

    public final boolean isCanceled() {
        return this.zzam == 16;
    }

    public final boolean isInterrupted() {
        return this.zzam == 14;
    }

    public final boolean isSuccess() {
        return this.zzam <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.zzan.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("statusCode", zzp()).add("resolution", this.zzan).toString();
    }

    @KeepForSdk
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzan, i, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zzal);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zzp() {
        return this.zzao != null ? this.zzao : CommonStatusCodes.getStatusCodeString(this.zzam);
    }
}
