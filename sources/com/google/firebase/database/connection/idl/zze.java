package com.google.firebase.database.connection.idl;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;
import java.util.List;

public final class zze implements Parcelable.Creator<zzc> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        String str = null;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str2 = null;
        String str3 = null;
        ArrayList<String> arrayList = null;
        int i = 0;
        zzi zzi = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    zzi = (zzi) SafeParcelReader.createParcelable(parcel, readHeader, zzi.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 5:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 7:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzc(zzi, i, (List<String>) arrayList, z, str3, str2, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzc[i];
    }
}
