package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzau implements zzdp<zzm> {
    @Nullable
    private final String zzay;
    private final String zzgq;

    public zzau(@NonNull String str, @Nullable String str2) {
        this.zzgq = Preconditions.checkNotEmpty(str);
        this.zzay = str2;
    }

    public final /* synthetic */ zzgv zzam() {
        zzm zzm = new zzm();
        zzm.zzae = this.zzgq;
        zzm.zzay = this.zzay;
        return zzm;
    }
}
