package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbj;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.zzd;

final class zzm implements zzdk<zzbj> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzm(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzbj zzbj = (zzbj) obj;
        this.zzfi.zza(new zzao(zzbj.zzan(), zzbj.getIdToken(), Long.valueOf(zzbj.zzao()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzbj.isNewUser()), (zzd) null, this.zzfh, this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
