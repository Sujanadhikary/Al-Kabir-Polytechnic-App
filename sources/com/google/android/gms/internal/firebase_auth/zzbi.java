package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzbi implements zzdp<zzr> {
    private boolean zzbr = true;
    private String zzdf;

    public zzbi(@NonNull String str) {
        this.zzdf = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzgv zzam() {
        zzr zzr = new zzr();
        zzr.zzdf = this.zzdf;
        zzr.zzbr = this.zzbr;
        return zzr;
    }
}
