package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaz;

final class zzp implements zzdk<zzao> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ String zzft;
    private final /* synthetic */ String zzfu;

    zzp(zza zza, String str, String str2, zzcb zzcb) {
        this.zzfi = zza;
        this.zzft = str;
        this.zzfu = str2;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzao zzao = (zzao) obj;
        zzaz zzaz = new zzaz();
        zzaz.zzv(zzao.zzau()).zzw(this.zzft).zzx(this.zzfu);
        this.zzfi.zza(this.zzfh, zzao, zzaz, (zzdj) this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(com.google.firebase.auth.internal.zzp.zzaf(str));
    }
}
