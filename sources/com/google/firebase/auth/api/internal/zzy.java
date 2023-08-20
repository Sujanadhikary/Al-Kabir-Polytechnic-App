package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzz;
import com.google.firebase.auth.internal.zzp;

final class zzy implements zzdk<zzao> {
    final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzy(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfi.zzfg.zza(new zzz(((zzao) obj).zzau()), (zzdk<Void>) new zzz(this, this));
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
