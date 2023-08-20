package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.firebase.auth.internal.zzp;

final class zzd implements zzdk<zzbm> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;

    zzd(zza zza, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzbm zzbm = (zzbm) obj;
        this.zzfi.zza(new zzao(zzbm.zzan(), zzbm.getIdToken(), Long.valueOf(zzbm.zzao()), "Bearer"), (String) null, (String) null, false, (com.google.firebase.auth.zzd) null, this.zzfh, this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
