package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SafeParcelable.Class(creator = "CreateAuthUriResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzx extends AbstractSafeParcelable implements zzcg<zzx, zzg.zza> {
    public static final Parcelable.Creator<zzx> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getProviderId", mo8007id = 4)
    private String zzj;
    @SafeParcelable.Field(getter = "isForExistingProvider", mo8007id = 5)
    private boolean zzja;
    @SafeParcelable.Field(getter = "getStringList", mo8007id = 6)
    private zzbd zzjb;
    @SafeParcelable.Field(getter = "getSignInMethods", mo8007id = 7)
    private List<String> zzjc;
    @SafeParcelable.Field(getter = "getAuthUri", mo8007id = 2)
    private String zzv;
    @SafeParcelable.Field(getter = "isRegistered", mo8007id = 3)
    private boolean zzx;

    public zzx() {
        this.zzjb = zzbd.zzbb();
    }

    @SafeParcelable.Constructor
    public zzx(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) boolean z, @SafeParcelable.Param(mo8010id = 4) String str2, @SafeParcelable.Param(mo8010id = 5) boolean z2, @SafeParcelable.Param(mo8010id = 6) zzbd zzbd, @SafeParcelable.Param(mo8010id = 7) List<String> list) {
        this.zzv = str;
        this.zzx = z;
        this.zzj = str2;
        this.zzja = z2;
        this.zzjb = zzbd == null ? zzbd.zzbb() : zzbd.zza(zzbd);
        this.zzjc = list;
    }

    @Nullable
    public final List<String> getAllProviders() {
        return this.zzjb.zzba();
    }

    @Nullable
    public final List<String> getSignInMethods() {
        return this.zzjc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzv, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzx);
        SafeParcelWriter.writeString(parcel, 4, this.zzj, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzja);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzjb, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzjc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zza zza = (zzg.zza) zzgv;
        this.zzv = Strings.emptyToNull(zza.zzv);
        this.zzx = zza.zzx;
        this.zzj = Strings.emptyToNull(zza.zzj);
        this.zzja = zza.zzy;
        this.zzjb = zza.zzw == null ? zzbd.zzbb() : new zzbd(1, Arrays.asList(zza.zzw));
        this.zzjc = zza.zzaa == null ? new ArrayList<>(0) : Arrays.asList(zza.zzaa);
        return this;
    }

    public final Class<zzg.zza> zzae() {
        return zzg.zza.class;
    }
}
