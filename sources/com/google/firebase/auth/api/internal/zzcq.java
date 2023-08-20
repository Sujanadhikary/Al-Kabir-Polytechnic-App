package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

public final class zzcq {
    private String zzhj;

    public zzcq(@NonNull String str) {
        this.zzhj = Preconditions.checkNotEmpty(str);
    }

    public final zzcp zzaf() {
        return new zzcp(this.zzhj, (zzco) null);
    }
}
