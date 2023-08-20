package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.firebase.auth.internal.zzp;
import java.util.List;

final class zzu implements zzdk<zzah> {
    private final /* synthetic */ zzdk zzfw;
    private final /* synthetic */ zzao zzfz;
    private final /* synthetic */ zzt zzga;

    zzu(zzt zzt, zzdk zzdk, zzao zzao) {
        this.zzga = zzt;
        this.zzfw = zzdk;
        this.zzfz = zzao;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        List<zzaj> zzaq = ((zzah) obj).zzaq();
        if (zzaq == null || zzaq.isEmpty()) {
            this.zzfw.zzc("No users.");
            return;
        }
        zzaz zzaz = new zzaz();
        zzaz.zzv(this.zzfz.zzau()).zzaa(this.zzga.zzfy);
        this.zzga.zzfi.zza(this.zzga.zzfh, this.zzfz, zzaq.get(0), zzaz, (zzdj) this.zzfw);
    }

    public final void zzc(@Nullable String str) {
        this.zzga.zzfh.onFailure(zzp.zzaf(str));
    }
}
