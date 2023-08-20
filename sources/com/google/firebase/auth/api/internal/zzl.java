package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.firebase.auth.internal.zzp;

final class zzl implements zzdk<Object> {
    private final /* synthetic */ zzcb zzfh;

    zzl(zza zza, zzcb zzcb) {
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfh.zzab();
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
