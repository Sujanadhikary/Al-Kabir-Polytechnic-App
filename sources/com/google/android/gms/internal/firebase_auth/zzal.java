package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoUserListCreator")
@SafeParcelable.Reserved({1})
public final class zzal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzal> CREATOR = new zzam();
    @SafeParcelable.Field(getter = "getUsers", mo8007id = 2)
    private List<zzaj> zzjq;

    public zzal() {
        this.zzjq = new ArrayList();
    }

    @SafeParcelable.Constructor
    zzal(@SafeParcelable.Param(mo8010id = 2) List<zzaj> list) {
        this.zzjq = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }

    public static zzal zza(zzal zzal) {
        List<zzaj> list = zzal.zzjq;
        zzal zzal2 = new zzal();
        if (list != null && !list.isEmpty()) {
            zzal2.zzjq.addAll(list);
        }
        return zzal2;
    }

    public static zzal zza(zzg.zzc zzc) {
        ArrayList arrayList = new ArrayList(zzc.zzal.length);
        for (zzu zzu : zzc.zzal) {
            arrayList.add(new zzaj(Strings.emptyToNull(zzu.zzab), Strings.emptyToNull(zzu.zzaf), zzu.zzbi, Strings.emptyToNull(zzu.zzbf), Strings.emptyToNull(zzu.zzbp), zzas.zza(zzu.zzbv), Strings.emptyToNull(zzu.zzdp), Strings.emptyToNull(zzu.zzbb), zzu.zzbu, zzu.zzbt, false, (zzd) null));
        }
        return new zzal(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzjq, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<zzaj> zzaq() {
        return this.zzjq;
    }
}
