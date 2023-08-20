package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
public final class zzjx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjx> CREATOR = new zzjy();
    @SafeParcelable.Field(mo8007id = 2)
    public final String name;
    @SafeParcelable.Field(mo8007id = 7)
    public final String origin;
    @SafeParcelable.Field(mo8007id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo8007id = 6)
    private final String zzajf;
    @SafeParcelable.Field(mo8007id = 3)
    public final long zzaqz;
    @SafeParcelable.Field(mo8007id = 4)
    private final Long zzara;
    @SafeParcelable.Field(mo8007id = 5)
    private final Float zzarb;
    @SafeParcelable.Field(mo8007id = 8)
    private final Double zzarc;

    @SafeParcelable.Constructor
    zzjx(@SafeParcelable.Param(mo8010id = 1) int i, @SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) long j, @SafeParcelable.Param(mo8010id = 4) Long l, @SafeParcelable.Param(mo8010id = 5) Float f, @SafeParcelable.Param(mo8010id = 6) String str2, @SafeParcelable.Param(mo8010id = 7) String str3, @SafeParcelable.Param(mo8010id = 8) Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.zzaqz = j;
        this.zzara = l;
        this.zzarb = null;
        if (i == 1) {
            this.zzarc = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.zzarc = d;
        }
        this.zzajf = str2;
        this.origin = str3;
    }

    zzjx(zzjz zzjz) {
        this(zzjz.name, zzjz.zzaqz, zzjz.value, zzjz.origin);
    }

    zzjx(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaqz = j;
        this.origin = str2;
        if (obj == null) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
        } else if (obj instanceof Long) {
            this.zzara = (Long) obj;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
        } else if (obj instanceof String) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = (String) obj;
        } else if (obj instanceof Double) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = (Double) obj;
            this.zzajf = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object getValue() {
        if (this.zzara != null) {
            return this.zzara;
        }
        if (this.zzarc != null) {
            return this.zzarc;
        }
        if (this.zzajf != null) {
            return this.zzajf;
        }
        return null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaqz);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzara, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, (Float) null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajf, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzarc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
