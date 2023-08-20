package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.internal.zzp;

final class zzb implements zzdk<zzao> {
    private final /* synthetic */ zzcb zzfh;

    zzb(zza zza, zzcb zzcb) {
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfh.zzb((zzao) obj);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
