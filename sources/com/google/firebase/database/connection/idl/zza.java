package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_database.zzag;
import com.google.android.gms.internal.firebase_database.zzy;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "CompoundHashParcelableCreator")
@SafeParcelable.Reserved({1})
final class zza extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.Field(mo8007id = 2)
    private final List<String> zzbz;
    @SafeParcelable.Field(mo8007id = 3)
    private final List<String> zzca;

    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(mo8010id = 2) List<String> list, @SafeParcelable.Param(mo8010id = 3) List<String> list2) {
        this.zzbz = list;
        this.zzca = list2;
    }

    public static zzy zza(zza zza) {
        ArrayList arrayList = new ArrayList(zza.zzbz.size());
        for (String zzg : zza.zzbz) {
            arrayList.add(zzag.zzg(zzg));
        }
        return new zzy(arrayList, zza.zzca);
    }

    public static zza zza(zzy zzy) {
        List<List<String>> zzo = zzy.zzo();
        ArrayList arrayList = new ArrayList(zzo.size());
        for (List<String> zzb : zzo) {
            arrayList.add(zzag.zzb(zzb));
        }
        return new zza(arrayList, zzy.zzp());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzbz, false);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzca, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
