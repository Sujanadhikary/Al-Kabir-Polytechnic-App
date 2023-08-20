package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.firebase.auth.internal.zzp;

final class zzaf implements zzdk<zzba> {
    private final /* synthetic */ zzcb zzfh;

    zzaf(zza zza, zzcb zzcb) {
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfh.zzd(((zzba) obj).getEmail());
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
