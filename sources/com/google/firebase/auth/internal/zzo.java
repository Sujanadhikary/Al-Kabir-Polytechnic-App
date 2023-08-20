package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.ProviderQueryResult;
import java.util.List;

public final class zzo implements ProviderQueryResult {
    private List<String> zzlb;

    public zzo(@NonNull zzx zzx) {
        Preconditions.checkNotNull(zzx);
        this.zzlb = zzx.getAllProviders();
    }

    @Nullable
    public final List<String> getProviders() {
        return this.zzlb;
    }
}
