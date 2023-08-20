package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.internal.zzp;

final class zzj implements zzdk<zzx> {
    private final /* synthetic */ zzcb zzfh;

    zzj(zza zza, zzcb zzcb) {
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfh.zza((zzx) obj);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
