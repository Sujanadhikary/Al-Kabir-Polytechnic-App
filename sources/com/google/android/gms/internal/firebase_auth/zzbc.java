package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;

public final class zzbc implements zzcg<zzbc, zzg.zzf> {
    private String zzad;
    private String zzaf;
    private String zzag;
    private long zzah;
    private String zzbf;

    public final String getIdToken() {
        return this.zzad;
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zzf zzf = (zzg.zzf) zzgv;
        this.zzad = Strings.emptyToNull(zzf.zzad);
        this.zzbf = Strings.emptyToNull(zzf.zzbf);
        this.zzaf = Strings.emptyToNull(zzf.zzaf);
        this.zzag = Strings.emptyToNull(zzf.zzag);
        this.zzah = zzf.zzah;
        return this;
    }

    public final Class<zzg.zzf> zzae() {
        return zzg.zzf.class;
    }

    @NonNull
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }
}
