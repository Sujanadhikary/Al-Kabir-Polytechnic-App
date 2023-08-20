package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzab;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.internal.zzp;
import com.google.firebase.auth.zzd;

final class zzf implements zzdk<zzab> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzf(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzab zzab = (zzab) obj;
        this.zzfi.zza(new zzao(zzab.zzan(), zzab.getIdToken(), Long.valueOf(zzab.zzao()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzab.isNewUser()), (zzd) null, this.zzfh, this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
