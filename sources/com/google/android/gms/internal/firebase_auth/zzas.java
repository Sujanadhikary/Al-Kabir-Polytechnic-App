package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ProviderUserInfoListCreator")
@SafeParcelable.Reserved({1})
public final class zzas extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzas> CREATOR = new zzat();
    @SafeParcelable.Field(getter = "getProviderUserInfos", mo8007id = 2)
    private List<zzaq> zzjv;

    public zzas() {
        this.zzjv = new ArrayList();
    }

    @SafeParcelable.Constructor
    zzas(@SafeParcelable.Param(mo8010id = 2) List<zzaq> list) {
        if (list == null || list.isEmpty()) {
            this.zzjv = Collections.emptyList();
        } else {
            this.zzjv = Collections.unmodifiableList(list);
        }
    }

    public static zzas zza(zzas zzas) {
        List<zzaq> list = zzas.zzjv;
        zzas zzas2 = new zzas();
        if (list != null) {
            zzas2.zzjv.addAll(list);
        }
        return zzas2;
    }

    public static zzas zza(zzt[] zztArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= zztArr.length) {
                return new zzas(arrayList);
            }
            zzt zzt = zztArr[i2];
            arrayList.add(new zzaq(Strings.emptyToNull(zzt.zzce), Strings.emptyToNull(zzt.zzbf), Strings.emptyToNull(zzt.zzbp), Strings.emptyToNull(zzt.zzj), (String) null, Strings.emptyToNull(zzt.zzbb), Strings.emptyToNull(zzt.zzaf)));
            i = i2 + 1;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzjv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzaq> zzar() {
        return this.zzjv;
    }
}
