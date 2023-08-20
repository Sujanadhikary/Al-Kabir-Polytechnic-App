package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzbl implements zzdp<zzs> {
    private String zzaf;
    private String zzbg;
    private boolean zzbr = true;

    public zzbl(@NonNull String str, @NonNull String str2) {
        this.zzaf = Preconditions.checkNotEmpty(str);
        this.zzbg = Preconditions.checkNotEmpty(str2);
    }

    public final /* synthetic */ zzgv zzam() {
        zzs zzs = new zzs();
        zzs.zzaf = this.zzaf;
        zzs.zzbg = this.zzbg;
        zzs.zzbr = this.zzbr;
        return zzs;
    }
}
