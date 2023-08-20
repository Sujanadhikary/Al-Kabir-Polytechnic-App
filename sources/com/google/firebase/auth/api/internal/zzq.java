package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.android.gms.internal.firebase_auth.zzbh;
import com.google.firebase.auth.internal.zzp;

final class zzq implements zzdk<zzao> {
    final /* synthetic */ zzcb zzfh;
    final /* synthetic */ zza zzfi;
    private final /* synthetic */ zzbf zzfv;

    zzq(zza zza, zzbf zzbf, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfv = zzbf;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfv.zzac(((zzao) obj).zzau());
        this.zzfi.zzfg.zza(this.zzfv, (zzdk<zzbh>) new zzr(this, this));
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
