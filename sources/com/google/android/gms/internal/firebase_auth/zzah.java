package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzah extends AbstractSafeParcelable implements zzcg<zzah, zzg.zzc> {
    public static final Parcelable.Creator<zzah> CREATOR = new zzai();
    @SafeParcelable.Field(getter = "getUserList", mo8007id = 2)
    private zzal zzjk;

    public zzah() {
    }

    @SafeParcelable.Constructor
    zzah(@SafeParcelable.Param(mo8010id = 2) zzal zzal) {
        this.zzjk = zzal == null ? new zzal() : zzal.zza(zzal);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzjk, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zzc zzc = (zzg.zzc) zzgv;
        if (zzc.zzal == null) {
            this.zzjk = null;
        } else {
            this.zzjk = zzal.zza(zzc);
        }
        return this;
    }

    public final Class<zzg.zzc> zzae() {
        return zzg.zzc.class;
    }

    public final List<zzaj> zzaq() {
        return this.zzjk.zzaq();
    }
}
