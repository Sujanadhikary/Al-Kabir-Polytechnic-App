package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaz;
import java.util.List;

final class zzg implements zzdk<zzah> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ zzdj zzfk;
    private final /* synthetic */ zzao zzfl;
    private final /* synthetic */ zzaz zzfm;

    zzg(zza zza, zzdj zzdj, zzcb zzcb, zzao zzao, zzaz zzaz) {
        this.zzfi = zza;
        this.zzfk = zzdj;
        this.zzfh = zzcb;
        this.zzfl = zzao;
        this.zzfm = zzaz;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        List<zzaj> zzaq = ((zzah) obj).zzaq();
        if (zzaq == null || zzaq.isEmpty()) {
            this.zzfk.zzc("No users");
        } else {
            this.zzfi.zza(this.zzfh, this.zzfl, zzaq.get(0), this.zzfm, this.zzfk);
        }
    }

    public final void zzc(@Nullable String str) {
        this.zzfk.zzc(str);
    }
}
