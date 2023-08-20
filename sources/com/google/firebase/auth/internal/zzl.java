package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;

public final class zzl implements Parcelable.Creator<zzk> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        boolean z = false;
        zzd zzd = null;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzm zzm = null;
        boolean z2 = false;
        String str = null;
        ArrayList<String> arrayList = null;
        ArrayList<zzh> arrayList2 = null;
        String str2 = null;
        String str3 = null;
        zzh zzh = null;
        zzao zzao = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzao = (zzao) SafeParcelReader.createParcelable(parcel, readHeader, zzao.CREATOR);
                    break;
                case 2:
                    zzh = (zzh) SafeParcelReader.createParcelable(parcel, readHeader, zzh.CREATOR);
                    break;
                case 3:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, zzh.CREATOR);
                    break;
                case 6:
                    arrayList = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 7:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    z2 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    zzm = (zzm) SafeParcelReader.createParcelable(parcel, readHeader, zzm.CREATOR);
                    break;
                case 10:
                    z = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzk(zzao, zzh, str3, str2, arrayList2, arrayList, str, z2, zzm, z, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzk[i];
    }
}
