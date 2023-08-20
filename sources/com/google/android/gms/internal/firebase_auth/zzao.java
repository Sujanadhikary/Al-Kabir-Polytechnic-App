package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzha;
import com.google.firebase.auth.api.internal.zzcg;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GetTokenResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzao extends AbstractSafeParcelable implements zzcg<zzao, zzha.zza> {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    @SafeParcelable.Field(getter = "getRefreshToken", mo8007id = 2)
    private String zzag;
    @SafeParcelable.Field(getter = "getAccessToken", mo8007id = 3)
    private String zzdt;
    @SafeParcelable.Field(getter = "getExpiresIn", mo8007id = 4)
    private Long zzjs;
    @SafeParcelable.Field(getter = "getTokenType", mo8007id = 5)
    private String zzjt;
    @SafeParcelable.Field(getter = "getIssuedAt", mo8007id = 6)
    private Long zzju;

    public zzao() {
        this.zzju = Long.valueOf(System.currentTimeMillis());
    }

    public zzao(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    @SafeParcelable.Constructor
    zzao(@SafeParcelable.Param(mo8010id = 2) String str, @SafeParcelable.Param(mo8010id = 3) String str2, @SafeParcelable.Param(mo8010id = 4) Long l, @SafeParcelable.Param(mo8010id = 5) String str3, @SafeParcelable.Param(mo8010id = 6) Long l2) {
        this.zzag = str;
        this.zzdt = str2;
        this.zzjs = l;
        this.zzjt = str3;
        this.zzju = l2;
    }

    public static zzao zzs(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzao zzao = new zzao();
            zzao.zzag = jSONObject.optString("refresh_token", (String) null);
            zzao.zzdt = jSONObject.optString("access_token", (String) null);
            zzao.zzjs = Long.valueOf(jSONObject.optLong("expires_in"));
            zzao.zzjt = jSONObject.optString("token_type", (String) null);
            zzao.zzju = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzao;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new zzv((Throwable) e);
        }
    }

    public final boolean isValid() {
        return DefaultClock.getInstance().currentTimeMillis() + 300000 < this.zzju.longValue() + (this.zzjs.longValue() * 1000);
    }

    public final String toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzag);
            jSONObject.put("access_token", this.zzdt);
            jSONObject.put("expires_in", this.zzjs);
            jSONObject.put("token_type", this.zzjt);
            jSONObject.put("issued_at", this.zzju);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new zzv((Throwable) e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzag, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdt, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zzao()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zzjt, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zzju.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzha.zza zza = (zzha.zza) zzgv;
        this.zzag = Strings.emptyToNull(zza.zzag);
        this.zzdt = Strings.emptyToNull(zza.zzdt);
        this.zzjs = Long.valueOf(zza.zzah);
        this.zzjt = Strings.emptyToNull(zza.zzjt);
        this.zzju = Long.valueOf(System.currentTimeMillis());
        return this;
    }

    public final Class<zzha.zza> zzae() {
        return zzha.zza.class;
    }

    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        if (this.zzjs == null) {
            return 0;
        }
        return this.zzjs.longValue();
    }

    public final String zzau() {
        return this.zzdt;
    }

    @Nullable
    public final String zzav() {
        return this.zzjt;
    }

    public final long zzaw() {
        return this.zzju.longValue();
    }

    public final void zzr(@NonNull String str) {
        this.zzag = Preconditions.checkNotEmpty(str);
    }
}
