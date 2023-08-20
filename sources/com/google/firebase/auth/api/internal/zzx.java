package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbh;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zzp;

final class zzx implements zzdk<zzbh> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzx(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzbh zzbh = (zzbh) obj;
        if (zzbh.zzbc()) {
            this.zzfh.onFailure(new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL));
            return;
        }
        this.zzfi.zza(new zzao(zzbh.zzan(), zzbh.getIdToken(), Long.valueOf(zzbh.zzao()), "Bearer"), zzbh.getRawUserInfo(), zzbh.getProviderId(), Boolean.valueOf(zzbh.isNewUser()), zzbh.zzat(), this.zzfh, this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
