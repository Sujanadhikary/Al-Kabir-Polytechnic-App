package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;

final class zzag implements zzdk<zzao> {
    private final /* synthetic */ zzdk zzge;

    zzag(zza zza, zzdk zzdk) {
        this.zzge = zzdk;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzge.onSuccess((zzao) obj);
    }

    public final void zzc(@Nullable String str) {
        this.zzge.zzc(str);
    }
}
