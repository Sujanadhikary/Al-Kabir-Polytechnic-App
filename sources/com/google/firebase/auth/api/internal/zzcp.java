package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;

public final class zzcp extends zzaj implements Api.ApiOptions.HasOptions {
    private final String zzhj;

    private zzcp(@NonNull String str) {
        this.zzhj = Preconditions.checkNotEmpty(str, "A valid API key must be provided");
    }

    /* synthetic */ zzcp(String str, zzco zzco) {
        this(str);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return new zzcq(this.zzhj).zzaf();
    }

    public final String getApiKey() {
        return this.zzhj;
    }

    public final /* synthetic */ zzaj zzw() {
        return (zzcp) clone();
    }
}
