package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

public final class zzb implements Parcelable.Creator<zza> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        ArrayList<String> arrayList = null;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        ArrayList<String> arrayList2 = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 3:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zza(arrayList2, arrayList);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zza[i];
    }
}
