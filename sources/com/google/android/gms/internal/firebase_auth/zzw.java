package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzw implements zzdp<zzh> {
    private String zzg;
    private String zzh = "http://localhost";

    public zzw(@NonNull String str) {
        this.zzg = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzgv zzam() {
        zzh zzh2 = new zzh();
        zzh2.zzg = this.zzg;
        zzh2.zzh = this.zzh;
        return zzh2;
    }
}
