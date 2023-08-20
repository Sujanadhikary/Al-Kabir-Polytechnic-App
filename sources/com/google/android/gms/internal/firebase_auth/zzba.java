package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;
import java.util.List;

public final class zzba implements zzcg<zzba, zzg.zze> {
    private String zzad;
    private String zzaf;
    private String zzag;
    private long zzah;
    private String zzbf;
    private String zzbg;
    private String zzbp;
    private zzas zzjm;
    private Boolean zzkb;

    @Nullable
    public final String getEmail() {
        return this.zzaf;
    }

    @Nullable
    public final String getIdToken() {
        return this.zzad;
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.zze zze = (zzg.zze) zzgv;
        this.zzaf = Strings.emptyToNull(zze.zzaf);
        this.zzbg = Strings.emptyToNull(zze.zzbw);
        this.zzkb = Boolean.valueOf(zze.zzbi);
        this.zzbf = Strings.emptyToNull(zze.zzbf);
        this.zzbp = Strings.emptyToNull(zze.zzbp);
        this.zzjm = zzas.zza(zze.zzbv);
        this.zzad = Strings.emptyToNull(zze.zzad);
        this.zzag = Strings.emptyToNull(zze.zzag);
        this.zzah = zze.zzah;
        return this;
    }

    public final Class<zzg.zze> zzae() {
        return zzg.zze.class;
    }

    @Nullable
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }

    public final List<zzaq> zzar() {
        if (this.zzjm != null) {
            return this.zzjm.zzar();
        }
        return null;
    }
}
