package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_database.zzah;
import com.google.android.gms.internal.firebase_database.zzib;
import java.io.File;
import java.util.List;

@SafeParcelable.Class(creator = "ConnectionConfigCreator")
@SafeParcelable.Reserved({1})
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zze();
    @SafeParcelable.Field(mo8007id = 5)
    final boolean zzcp;
    @SafeParcelable.Field(mo8007id = 7)
    final String zzcr;
    @SafeParcelable.Field(mo8007id = 8)
    final String zzcs;
    @SafeParcelable.Field(mo8007id = 2)
    final zzi zzfk;
    @SafeParcelable.Field(mo8007id = 3)
    final int zzfl;
    @SafeParcelable.Field(mo8007id = 4)
    final List<String> zzfm;
    @SafeParcelable.Field(mo8007id = 6)
    final String zzfn;

    public zzc(zzah zzah, zzib zzib, List<String> list, boolean z, String str, String str2, File file) {
        int i;
        switch (zzd.zzfo[zzib.ordinal()]) {
            case 1:
                i = 1;
                break;
            case 2:
                i = 2;
                break;
            case 3:
                i = 3;
                break;
            case 4:
                i = 4;
                break;
            default:
                i = 0;
                break;
        }
        this.zzfk = new zzi(zzah.getHost(), zzah.getNamespace(), zzah.isSecure());
        this.zzfl = i;
        this.zzfm = null;
        this.zzcp = z;
        this.zzfn = str;
        this.zzcr = str2;
        this.zzcs = file.getAbsolutePath();
    }

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(mo8010id = 2) zzi zzi, @SafeParcelable.Param(mo8010id = 3) int i, @SafeParcelable.Param(mo8010id = 4) List<String> list, @SafeParcelable.Param(mo8010id = 5) boolean z, @SafeParcelable.Param(mo8010id = 6) String str, @SafeParcelable.Param(mo8010id = 7) String str2, @SafeParcelable.Param(mo8010id = 8) String str3) {
        this.zzfk = zzi;
        this.zzfl = i;
        this.zzfm = list;
        this.zzcp = z;
        this.zzfn = str;
        this.zzcr = str2;
        this.zzcs = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzfk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzfl);
        SafeParcelWriter.writeStringList(parcel, 4, this.zzfm, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzcp);
        SafeParcelWriter.writeString(parcel, 6, this.zzfn, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzcr, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzcs, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
