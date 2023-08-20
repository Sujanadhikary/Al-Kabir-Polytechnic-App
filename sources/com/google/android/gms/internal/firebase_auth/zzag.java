package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzag implements zzdp<zzk> {
    private String zzad;

    public zzag(String str) {
        this.zzad = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzgv zzam() {
        zzk zzk = new zzk();
        zzk.zzad = this.zzad;
        return zzk;
    }
}
