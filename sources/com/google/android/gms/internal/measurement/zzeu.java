package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EventParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzeu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeu> CREATOR = new zzev();
    @SafeParcelable.Field(mo8007id = 2)
    public final String name;
    @SafeParcelable.Field(mo8007id = 4)
    public final String origin;
    @SafeParcelable.Field(mo8007id = 3)
    public final zzer zzafq;
    @SafeParcelable.Field(mo8007id = 5)
    public final long zzagb;

    zzeu(zzeu zzeu, long j) {
        Preconditions.checkNotNull(zzeu);
        this.name = zzeu.name;
        this.zzafq = zzeu.zzafq;
        this.origin = zzeu.origin;
        this.zzagb = j;
    }

    @SafeParcelable.Constructor
    public zzeu(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) zzer zzer, @SafeParcelable.Param(mo8010id = 4) String str2, @SafeParcelable.Param(mo8010id = 5) long j) {
        this.name = str;
        this.zzafq = zzer;
        this.origin = str2;
        this.zzagb = j;
    }

    public final String toString() {
        String str = this.origin;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        return new StringBuilder(String.valueOf(str).length() + 21 + String.valueOf(str2).length() + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzafq, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzagb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
