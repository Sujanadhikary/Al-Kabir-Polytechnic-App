package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;

@SafeParcelable.Class(creator = "VerifyCustomTokenResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzbj extends AbstractSafeParcelable implements zzcg<zzbj, zzg.zzh> {
    public static final Parcelable.Creator<zzbj> CREATOR = new zzbk();
    @SafeParcelable.Field(getter = "getIdToken", mo8007id = 2)
    private String zzad;
    @SafeParcelable.Field(getter = "getRefreshToken", mo8007id = 3)
    private String zzag;
    @SafeParcelable.Field(getter = "getExpiresIn", mo8007id = 4)
    private long zzah;
    @SafeParcelable.Field(getter = "isNewUser", mo8007id = 5)
    private boolean zzai;

    public zzbj() {
    }

    @SafeParcelable.Constructor
    zzbj(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) long j, @SafeParcelable.Param(mo8010id = 5) boolean z) {
        this.zzad = str;
        this.zzag = str2;
        this.zzah = j;
        this.zzai = z;
    }

    public final String getIdToken() {
        return this.zzad;
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzad, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzag, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzah);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzai);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zzh zzh = (zzg.zzh) zzgv;
        this.zzad = Strings.emptyToNull(zzh.zzad);
        this.zzag = Strings.emptyToNull(zzh.zzag);
        this.zzah = zzh.zzah;
        this.zzai = zzh.zzai;
        return this;
    }

    public final Class<zzg.zzh> zzae() {
        return zzg.zzh.class;
    }

    @NonNull
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }
}
