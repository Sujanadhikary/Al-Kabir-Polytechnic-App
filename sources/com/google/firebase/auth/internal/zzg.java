package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzd;

public final class zzg implements Parcelable.Creator<zzf> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzd zzd = null;
        zzd zzd2 = null;
        zzk zzk = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzk = (zzk) SafeParcelReader.createParcelable(parcel, readHeader, zzk.CREATOR);
                    break;
                case 2:
                    zzd2 = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                case 3:
                    zzd = (zzd) SafeParcelReader.createParcelable(parcel, readHeader, zzd.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzf(zzk, zzd2, zzd);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzf[i];
    }
}
