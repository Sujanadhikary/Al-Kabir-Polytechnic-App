package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

final class zzz implements zzdk<Void> {
    private final /* synthetic */ zzdk zzfw;
    private final /* synthetic */ zzy zzgc;

    zzz(zzy zzy, zzdk zzdk) {
        this.zzgc = zzy;
        this.zzfw = zzdk;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        this.zzgc.zzfh.zzaa();
    }

    public final void zzc(@Nullable String str) {
        this.zzfw.zzc(str);
    }
}
