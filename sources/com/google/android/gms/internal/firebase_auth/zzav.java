package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;

@SafeParcelable.Class(creator = "ResetPasswordResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzav extends AbstractSafeParcelable implements zzcg<zzav, zzg.zzd> {
    public static final Parcelable.Creator<zzav> CREATOR = new zzaw();
    @SafeParcelable.Field(getter = "getEmail", mo8007id = 2)
    private String zzaf;
    @SafeParcelable.Field(getter = "getNewEmail", mo8007id = 3)
    private String zzaq;
    @SafeParcelable.Field(getter = "getRequestType", mo8007id = 4)
    private String zzjr;

    public zzav() {
    }

    @SafeParcelable.Constructor
    zzav(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) String str3) {
        this.zzaf = str;
        this.zzaq = str2;
        this.zzjr = str3;
    }

    public final String getEmail() {
        return this.zzaf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzaf, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzaq, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzjr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        String str;
        zzg.zzd zzd = (zzg.zzd) zzgv;
        this.zzaf = Strings.emptyToNull(zzd.zzaf);
        this.zzaq = Strings.emptyToNull(zzd.zzaq);
        switch (zzd.zzba) {
            case 1:
                str = "PASSWORD_RESET";
                break;
            case 4:
                str = "VERIFY_EMAIL";
                break;
            default:
                str = null;
                break;
        }
        this.zzjr = str;
        return this;
    }

    public final Class<zzg.zzd> zzae() {
        return zzg.zzd.class;
    }

    public final String zzay() {
        return this.zzaq;
    }

    public final String zzaz() {
        return this.zzjr;
    }
}
