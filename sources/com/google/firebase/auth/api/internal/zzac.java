package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzp;

final class zzac implements zzdk<zzao> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ UserProfileChangeRequest zzgd;

    zzac(zza zza, UserProfileChangeRequest userProfileChangeRequest, zzcb zzcb) {
        this.zzfi = zza;
        this.zzgd = userProfileChangeRequest;
        this.zzfh = zzcb;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzao zzao = (zzao) obj;
        zzaz zzaz = new zzaz();
        zzaz.zzv(zzao.zzau());
        if (this.zzgd.zzs() || this.zzgd.getDisplayName() != null) {
            zzaz.zzy(this.zzgd.getDisplayName());
        }
        if (this.zzgd.zzt() || this.zzgd.getPhotoUri() != null) {
            zzaz.zzz(this.zzgd.zzr());
        }
        this.zzfi.zza(this.zzfh, zzao, zzaz, (zzdj) this);
    }

    public final void zzc(@Nullable String str) {
        this.zzfh.onFailure(zzp.zzaf(str));
    }
}
