package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.firebase.auth.internal.zzp;

final class zzae implements zzdk<zzao> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ String zzfu;

    zzae(zza zza, String str, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfu = str;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzao zzao = (zzao) obj;
        String zzau = zzao.zzau();
        zzaz zzaz = new zzaz();
        zzaz.zzv(zzau).zzx(this.zzfu);
        this.zzfi.zza(this.zzfh, zzao, zzaz, (zzdj) this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
