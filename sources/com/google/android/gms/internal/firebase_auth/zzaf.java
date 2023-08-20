package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzaf implements zzdp<zzhb> {
    private String zzjh;
    private String zzji;
    @Nullable
    private final String zzjj;

    public zzaf(String str) {
        this(str, (String) null);
    }

    private zzaf(String str, @Nullable String str2) {
        this.zzjh = zzae.REFRESH_TOKEN.toString();
        this.zzji = Preconditions.checkNotEmpty(str);
        this.zzjj = null;
    }

    public final /* synthetic */ zzgv zzam() {
        zzhb zzhb = new zzhb();
        zzhb.zzjh = this.zzjh;
        zzhb.zzag = this.zzji;
        zzhb.zzjj = null;
        return zzhb;
    }
}
