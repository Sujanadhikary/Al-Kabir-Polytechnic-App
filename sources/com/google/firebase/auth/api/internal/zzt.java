package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.internal.zzp;

final class zzt implements zzdk<zzao> {
    final /* synthetic */ zzcb zzfh;
    final /* synthetic */ zza zzfi;
    final /* synthetic */ String zzfy;

    zzt(zza zza, String str, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfy = str;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzao zzao = (zzao) obj;
        this.zzfi.zzfg.zza(new zzag(zzao.zzau()), (zzdk<zzah>) new zzu(this, this, zzao));
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
