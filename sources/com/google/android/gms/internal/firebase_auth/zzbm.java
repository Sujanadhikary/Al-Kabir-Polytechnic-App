package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;

public final class zzbm implements zzcg<zzbm, zzg.zzi> {
    private String zzab;
    private String zzad;
    private String zzaf;
    private String zzag;
    private long zzah;
    private String zzbf;
    private String zzbp;

    @NonNull
    public final String getIdToken() {
        return this.zzad;
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zzi zzi = (zzg.zzi) zzgv;
        this.zzab = Strings.emptyToNull(zzi.zzab);
        this.zzaf = Strings.emptyToNull(zzi.zzaf);
        this.zzbf = Strings.emptyToNull(zzi.zzbf);
        this.zzad = Strings.emptyToNull(zzi.zzad);
        this.zzbp = Strings.emptyToNull(zzi.zzbp);
        this.zzag = Strings.emptyToNull(zzi.zzag);
        this.zzah = zzi.zzah;
        return this;
    }

    public final Class<zzg.zzi> zzae() {
        return zzg.zzi.class;
    }

    @NonNull
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }
}
