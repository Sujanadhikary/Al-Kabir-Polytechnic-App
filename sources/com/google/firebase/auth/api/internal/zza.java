package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzaa;
import com.google.android.gms.internal.firebase_auth.zzab;
import com.google.android.gms.internal.firebase_auth.zzaf;
import com.google.android.gms.internal.firebase_auth.zzag;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzan;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzau;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzaz;
import com.google.android.gms.internal.firebase_auth.zzba;
import com.google.android.gms.internal.firebase_auth.zzbb;
import com.google.android.gms.internal.firebase_auth.zzbc;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.android.gms.internal.firebase_auth.zzbh;
import com.google.android.gms.internal.firebase_auth.zzbi;
import com.google.android.gms.internal.firebase_auth.zzbj;
import com.google.android.gms.internal.firebase_auth.zzbl;
import com.google.android.gms.internal.firebase_auth.zzbm;
import com.google.android.gms.internal.firebase_auth.zzw;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.zzd;

public final class zza {
    /* access modifiers changed from: private */
    public final zzdi zzfg;

    public zza(@NonNull zzdi zzdi) {
        this.zzfg = (zzdi) Preconditions.checkNotNull(zzdi);
    }

    /* access modifiers changed from: private */
    public static zzao zza(@NonNull zzao zzao, @NonNull zzba zzba) {
        Preconditions.checkNotNull(zzao);
        Preconditions.checkNotNull(zzba);
        String idToken = zzba.getIdToken();
        String zzan = zzba.zzan();
        return (TextUtils.isEmpty(idToken) || TextUtils.isEmpty(zzan)) ? zzao : new zzao(zzan, idToken, Long.valueOf(zzba.zzao()), zzao.zzav());
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzaa zzaa, @NonNull zzcb zzcb) {
        Preconditions.checkNotNull(zzaa);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(zzaa, (zzdk<zzab>) new zzf(this, zzcb));
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzao zzao, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zzd zzd, @NonNull zzcb zzcb, @NonNull zzdj zzdj) {
        Preconditions.checkNotNull(zzao);
        Preconditions.checkNotNull(zzdj);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzag(zzao.zzau()), (zzdk<zzah>) new zzi(this, zzdj, str2, str, bool, zzd, zzcb, zzao));
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzcb zzcb, @NonNull zzao zzao, @NonNull zzaj zzaj, @NonNull zzaz zzaz, @NonNull zzdj zzdj) {
        Preconditions.checkNotNull(zzcb);
        Preconditions.checkNotNull(zzao);
        Preconditions.checkNotNull(zzaj);
        Preconditions.checkNotNull(zzaz);
        Preconditions.checkNotNull(zzdj);
        this.zzfg.zza(zzaz, (zzdk<zzba>) new zzh(this, zzaz, zzaj, zzcb, zzao, zzdj));
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzcb zzcb, @NonNull zzao zzao, @NonNull zzaz zzaz, @NonNull zzdj zzdj) {
        Preconditions.checkNotNull(zzcb);
        Preconditions.checkNotNull(zzao);
        Preconditions.checkNotNull(zzaz);
        Preconditions.checkNotNull(zzdj);
        this.zzfg.zza(new zzag(zzao.zzau()), (zzdk<zzah>) new zzg(this, zzdj, zzcb, zzao, zzaz));
    }

    private final void zza(@NonNull String str, @NonNull zzdk<zzao> zzdk) {
        Preconditions.checkNotNull(zzdk);
        Preconditions.checkNotEmpty(str);
        zzao zzs = zzao.zzs(str);
        if (zzs.isValid()) {
            zzdk.onSuccess(zzs);
            return;
        }
        this.zzfg.zza(new zzaf(zzs.zzan()), (zzdk<zzao>) new zzag(this, zzdk));
    }

    public final void zza(@NonNull zzbf zzbf, @NonNull zzcb zzcb) {
        Preconditions.checkNotNull(zzbf);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(zzbf, (zzdk<zzbh>) new zzx(this, zzcb));
    }

    public final void zza(@NonNull EmailAuthCredential emailAuthCredential, @NonNull zzcb zzcb) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzcb);
        if (emailAuthCredential.zzh()) {
            zza(emailAuthCredential.zzg(), (zzdk<zzao>) new zze(this, emailAuthCredential, zzcb));
        } else {
            zza(new zzaa(emailAuthCredential, (String) null), zzcb);
        }
    }

    public final void zza(@NonNull zzcb zzcb) {
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzbb(), (zzdk<zzbc>) new zzab(this, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull zzbf zzbf, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzbf);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzq(this, zzbf, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zzan zzan = new zzan(actionCodeSettings.getRequestType());
        zzan.zzp(str);
        zzan.zza(actionCodeSettings);
        this.zzfg.zza(zzan, (zzdk<Object>) new zzk(this, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzac(this, userProfileChangeRequest, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzaf(str), (zzdk<zzao>) new zzb(this, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzad(this, str2, zzcb));
    }

    public final void zza(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzcb);
        zza(str3, (zzdk<zzao>) new zzp(this, str, str2, zzcb));
    }

    public final void zzb(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zzan zzan = new zzan(4);
        zzan.zzq(str);
        if (actionCodeSettings != null) {
            zzan.zza(actionCodeSettings);
        }
        this.zzfg.zza(zzan, (zzdk<Object>) new zzl(this, zzcb));
    }

    public final void zzb(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzbi(str), (zzdk<zzbj>) new zzm(this, zzcb));
    }

    public final void zzb(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzae(this, str2, zzcb));
    }

    public final void zzc(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zzaz zzaz = new zzaz();
        zzaz.zzab(str);
        this.zzfg.zza(zzaz, (zzdk<zzba>) new zzaf(this, zzcb));
    }

    public final void zzc(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzbb(str, str2, (String) null), (zzdk<zzbc>) new zzc(this, zzcb));
    }

    public final void zzd(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzw(str), (zzdk<zzx>) new zzj(this, zzcb));
    }

    public final void zzd(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzbl(str, str2), (zzdk<zzbm>) new zzd(this, zzcb));
    }

    public final void zze(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzau(str, (String) null), (zzdk<zzav>) new zzn(this, zzcb));
    }

    public final void zze(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zza(new zzau(str, str2), (zzdk<zzav>) new zzo(this, zzcb));
    }

    public final void zzf(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzs(this, zzcb));
    }

    public final void zzf(@NonNull String str, @NonNull String str2, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzcb);
        zza(str2, (zzdk<zzao>) new zzt(this, str, zzcb));
    }

    public final void zzg(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzv(this, zzcb));
    }

    public final void zzh(@NonNull String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzcb);
        zza(str, (zzdk<zzao>) new zzy(this, zzcb));
    }

    public final void zzi(@Nullable String str, @NonNull zzcb zzcb) {
        Preconditions.checkNotNull(zzcb);
        this.zzfg.zzb(str, new zzaa(this, zzcb));
    }
}
