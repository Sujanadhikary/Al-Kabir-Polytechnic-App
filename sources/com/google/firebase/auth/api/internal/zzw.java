package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import java.util.List;

final class zzw implements zzdk<zzah> {
    private final /* synthetic */ zzdk zzfw;
    private final /* synthetic */ zzao zzfz;
    private final /* synthetic */ zzv zzgb;

    zzw(zzv zzv, zzdk zzdk, zzao zzao) {
        this.zzgb = zzv;
        this.zzfw = zzdk;
        this.zzfz = zzao;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        List<zzaj> zzaq = ((zzah) obj).zzaq();
        if (zzaq == null || zzaq.isEmpty()) {
            this.zzfw.zzc("No users");
        } else {
            this.zzgb.zzfh.zza(this.zzfz, zzaq.get(0));
        }
    }

    public final void zzc(@Nullable String str) {
        this.zzfw.zzc(str);
    }
}
