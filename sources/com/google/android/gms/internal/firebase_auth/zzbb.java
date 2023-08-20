package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzbb implements zzdp<zzp> {
    private String zzaf;
    private String zzbf;
    private String zzbg;
    private boolean zzbr;

    public zzbb() {
        this.zzbr = true;
    }

    public zzbb(@NonNull String str, @NonNull String str2, @Nullable String str3) {
        this.zzaf = Preconditions.checkNotEmpty(str);
        this.zzbg = Preconditions.checkNotEmpty(str2);
        this.zzbf = null;
        this.zzbr = true;
    }

    public final /* synthetic */ zzgv zzam() {
        zzp zzp = new zzp();
        zzp.zzaf = this.zzaf;
        zzp.zzbg = this.zzbg;
        zzp.zzbf = null;
        return zzp;
    }
}
