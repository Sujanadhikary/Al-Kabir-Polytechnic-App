package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.android.gms.internal.firebase_auth.zzba;
import java.util.ArrayList;
import java.util.List;

final class zzh implements zzdk<zzba> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zza zzfi;
    private final /* synthetic */ zzdj zzfk;
    private final /* synthetic */ zzao zzfl;
    private final /* synthetic */ zzaz zzfm;
    private final /* synthetic */ zzaj zzfn;

    zzh(zza zza, zzaz zzaz, zzaj zzaj, zzcb zzcb, zzao zzao, zzdj zzdj) {
        this.zzfi = zza;
        this.zzfm = zzaz;
        this.zzfn = zzaj;
        this.zzfh = zzcb;
        this.zzfl = zzao;
        this.zzfk = zzdj;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzba zzba = (zzba) obj;
        if (this.zzfm.zzu("EMAIL")) {
            this.zzfn.zzl((String) null);
        } else if (this.zzfm.getEmail() != null) {
            this.zzfn.zzl(this.zzfm.getEmail());
        }
        if (this.zzfm.zzu("DISPLAY_NAME")) {
            this.zzfn.zzm((String) null);
        } else if (this.zzfm.getDisplayName() != null) {
            this.zzfn.zzm(this.zzfm.getDisplayName());
        }
        if (this.zzfm.zzu("PHOTO_URL")) {
            this.zzfn.zzn((String) null);
        } else if (this.zzfm.zzr() != null) {
            this.zzfn.zzn(this.zzfm.zzr());
        }
        if (!TextUtils.isEmpty(this.zzfm.getPassword())) {
            this.zzfn.zzo(Base64Utils.encode("redacted".getBytes()));
        }
        List zzar = zzba.zzar();
        if (zzar == null) {
            zzar = new ArrayList();
        }
        this.zzfn.zzb((List<zzaq>) zzar);
        this.zzfh.zza(zza.zza(this.zzfl, zzba), this.zzfn);
    }

    public final void zzc(@Nullable String str) {
        this.zzfk.zzc(str);
    }
}
