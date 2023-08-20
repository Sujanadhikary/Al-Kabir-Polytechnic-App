package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzg;
import com.google.firebase.auth.api.internal.zzcg;
import com.google.firebase.auth.zzd;

public final class zzbh implements zzcg<zzbh, zzg.C0440zzg> {
    private String zzab;
    private String zzad;
    private String zzaf;
    private String zzag;
    private long zzah;
    private boolean zzai;
    private String zzbf;
    private String zzbp;
    private String zzdd;
    private String zzj;
    private boolean zzkg;
    private boolean zzkh;
    private String zzki;
    private String zzkj;

    public final String getIdToken() {
        return this.zzad;
    }

    public final String getProviderId() {
        return this.zzj;
    }

    public final String getRawUserInfo() {
        return this.zzdd;
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public final /* synthetic */ zzcg zza(zzgv zzgv) {
        zzg.C0440zzg zzg = (zzg.C0440zzg) zzgv;
        this.zzkg = zzg.zzcs;
        this.zzkh = zzg.zzcz;
        this.zzad = Strings.emptyToNull(zzg.zzad);
        this.zzag = Strings.emptyToNull(zzg.zzag);
        this.zzah = zzg.zzah;
        this.zzab = Strings.emptyToNull(zzg.zzab);
        this.zzaf = Strings.emptyToNull(zzg.zzaf);
        this.zzbf = Strings.emptyToNull(zzg.zzbf);
        this.zzbp = Strings.emptyToNull(zzg.zzbp);
        this.zzj = Strings.emptyToNull(zzg.zzj);
        this.zzdd = Strings.emptyToNull(zzg.zzdd);
        this.zzai = zzg.zzai;
        this.zzki = zzg.zzcv;
        this.zzkj = zzg.zzdb;
        return this;
    }

    public final Class<zzg.C0440zzg> zzae() {
        return zzg.C0440zzg.class;
    }

    @Nullable
    public final String zzan() {
        return this.zzag;
    }

    public final long zzao() {
        return this.zzah;
    }

    @Nullable
    public final zzd zzat() {
        if (!TextUtils.isEmpty(this.zzki) || !TextUtils.isEmpty(this.zzkj)) {
            return zzd.zza(this.zzj, this.zzkj, this.zzki);
        }
        return null;
    }

    public final boolean zzbc() {
        return this.zzkg;
    }
}
