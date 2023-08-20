package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzaa;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzp;

final class zze implements zzdk<zzao> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ EmailAuthCredential zzfj;

    zze(zza zza, EmailAuthCredential emailAuthCredential, zzcb zzcb) {
        this.zzfi = zza;
        this.zzfj = emailAuthCredential;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzfi.zza(new zzaa(this.zzfj, ((zzao) obj).zzau()), this.zzfh);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
