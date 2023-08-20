package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;

public final class zzab implements zzcg<zzab, zzg.zzb> {
    private String zzab;
    private String zzad;
    private String zzaf;
    private String zzag;
    private long zzah;
    private boolean zzai;

    @NonNull
    public final String getIdToken() {
        return this.zzad;
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zzb zzb = (zzg.zzb) zzgv;
        this.zzab = Strings.emptyToNull(zzb.zzab);
        this.zzaf = Strings.emptyToNull(zzb.zzaf);
        this.zzad = Strings.emptyToNull(zzb.zzad);
        this.zzag = Strings.emptyToNull(zzb.zzag);
        this.zzai = zzb.zzai;
        this.zzah = zzb.zzah;
        return this;
    }

    public final Class<zzg.zzb> zzae() {
        return zzg.zzb.class;
    }

    @NonNull
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }
}
