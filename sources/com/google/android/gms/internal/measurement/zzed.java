package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConditionalUserPropertyParcelCreator")
public final class zzed extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzed> CREATOR = new zzee();
    @SafeParcelable.Field(mo8007id = 6)
    public boolean active;
    @SafeParcelable.Field(mo8007id = 5)
    public long creationTimestamp;
    @SafeParcelable.Field(mo8007id = 3)
    public String origin;
    @SafeParcelable.Field(mo8007id = 2)
    public String packageName;
    @SafeParcelable.Field(mo8007id = 11)
    public long timeToLive;
    @SafeParcelable.Field(mo8007id = 7)
    public String triggerEventName;
    @SafeParcelable.Field(mo8007id = 9)
    public long triggerTimeout;
    @SafeParcelable.Field(mo8007id = 4)
    public zzjx zzaep;
    @SafeParcelable.Field(mo8007id = 8)
    public zzeu zzaeq;
    @SafeParcelable.Field(mo8007id = 10)
    public zzeu zzaer;
    @SafeParcelable.Field(mo8007id = 12)
    public zzeu zzaes;

    zzed(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        this.packageName = zzed.packageName;
        this.origin = zzed.origin;
        this.zzaep = zzed.zzaep;
        this.creationTimestamp = zzed.creationTimestamp;
        this.active = zzed.active;
        this.triggerEventName = zzed.triggerEventName;
        this.zzaeq = zzed.zzaeq;
        this.triggerTimeout = zzed.triggerTimeout;
        this.zzaer = zzed.zzaer;
        this.timeToLive = zzed.timeToLive;
        this.zzaes = zzed.zzaes;
    }

    @SafeParcelable.Constructor
    zzed(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) zzjx zzjx, @SafeParcelable.Param(mo8010id = 5) long j, @SafeParcelable.Param(mo8010id = 6) boolean z, @SafeParcelable.Param(mo8010id = 7) String str3, @SafeParcelable.Param(mo8010id = 8) zzeu zzeu, @SafeParcelable.Param(mo8010id = 9) long j2, @SafeParcelable.Param(mo8010id = 10) zzeu zzeu2, @SafeParcelable.Param(mo8010id = 11) long j3, @SafeParcelable.Param(mo8010id = 12) zzeu zzeu3) {
        this.packageName = str;
        this.origin = str2;
        this.zzaep = zzjx;
        this.creationTimestamp = j;
        this.active = z;
        this.triggerEventName = str3;
        this.zzaeq = zzeu;
        this.triggerTimeout = j2;
        this.zzaer = zzeu2;
        this.timeToLive = j3;
        this.zzaes = zzeu3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.origin, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzaep, i, false);
        SafeParcelWriter.writeLong(parcel, 5, this.creationTimestamp);
        SafeParcelWriter.writeBoolean(parcel, 6, this.active);
        SafeParcelWriter.writeString(parcel, 7, this.triggerEventName, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzaeq, i, false);
        SafeParcelWriter.writeLong(parcel, 9, this.triggerTimeout);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzaer, i, false);
        SafeParcelWriter.writeLong(parcel, 11, this.timeToLive);
        SafeParcelWriter.writeParcelable(parcel, 12, this.zzaes, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
