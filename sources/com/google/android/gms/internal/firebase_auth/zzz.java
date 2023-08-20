package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzz implements zzdp<zzi> {
    private String zzad;

    public zzz(@NonNull String str) {
        this.zzad = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzgv zzam() {
        zzi zzi = new zzi();
        zzi.zzad = this.zzad;
        return zzi;
    }
}
