package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbh;
import com.google.firebase.FirebaseError;

final class zzr implements zzdk<zzbh> {
    private final /* synthetic */ zzdk zzfw;
    private final /* synthetic */ zzq zzfx;

    zzr(zzq zzq, zzdk zzdk) {
        this.zzfx = zzq;
        this.zzfw = zzdk;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzbh zzbh = (zzbh) obj;
        if (zzbh.zzbc()) {
            this.zzfx.zzfh.onFailure(new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL));
            return;
        }
        this.zzfx.zzfi.zza(new zzao(zzbh.zzan(), zzbh.getIdToken(), Long.valueOf(zzbh.zzao()), "Bearer"), zzbh.getRawUserInfo(), zzbh.getProviderId(), Boolean.valueOf(zzbh.isNewUser()), zzbh.zzat(), this.zzfx.zzfh, this.zzfw);
    }

    public final void zzc(@Nullable String str) {
        this.zzfw.zzc(str);
    }
}
