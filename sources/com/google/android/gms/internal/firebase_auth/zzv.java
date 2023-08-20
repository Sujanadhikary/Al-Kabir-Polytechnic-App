package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

public class zzv extends RuntimeException {
    private zzad zzfe;

    public zzv(zzad zzad) {
        this.zzfe = (zzad) Preconditions.checkNotNull(zzad);
    }

    public zzv(Throwable th) {
        super(th);
    }

    @Nullable
    public final String getErrorMessage() {
        zzac zzap = this.zzfe != null ? this.zzfe.zzap() : null;
        return zzap != null ? zzap.getErrorMessage() : getMessage();
    }
}
