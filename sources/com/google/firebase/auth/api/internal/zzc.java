package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.zzd;

final class zzc implements zzdk<zzbc> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzc(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzbc zzbc = (zzbc) obj;
        this.zzfi.zza(new zzao(zzbc.zzan(), zzbc.getIdToken(), Long.valueOf(zzbc.zzao()), "Bearer"), (String) null, (String) null, true, (zzd) null, this.zzfh, this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
