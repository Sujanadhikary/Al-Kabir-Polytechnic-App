package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.firebase.auth.internal.zzp;

final class zzk implements zzdk<Object> {
    private final /* synthetic */ zzcb zzfh;

    zzk(zza zza, zzcb zzcb) {
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfh.zza((zzav) null);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
