package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.internal.firebase_auth.zzah;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzaq;
import com.google.android.gms.internal.firebase_auth.zzas;
import com.google.firebase.auth.zzd;
import java.util.List;

final class zzi implements zzdk<zzah> {
    private final /* synthetic */ zzcb zzfh;
    private final /* synthetic */ zzdj zzfk;
    private final /* synthetic */ String zzfo;
    private final /* synthetic */ String zzfp;
    private final /* synthetic */ Boolean zzfq;
    private final /* synthetic */ zzd zzfr;
    private final /* synthetic */ zzao zzfs;

    zzi(zza zza, zzdj zzdj, String str, String str2, Boolean bool, zzd zzd, zzcb zzcb, zzao zzao) {
        this.zzfk = zzdj;
        this.zzfo = str;
        this.zzfp = str2;
        this.zzfq = bool;
        this.zzfr = zzd;
        this.zzfh = zzcb;
        this.zzfs = zzao;
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        boolean z = false;
        List<zzaj> zzaq = ((zzah) obj).zzaq();
        if (zzaq == null || zzaq.isEmpty()) {
            this.zzfk.zzc("No users.");
            return;
        }
        zzaj zzaj = zzaq.get(0);
        zzas zzas = zzaj.zzas();
        List<zzaq> zzar = zzas != null ? zzas.zzar() : null;
        if (zzar != null && !zzar.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzfo)) {
                int i = 0;
                while (true) {
                    if (i >= zzar.size()) {
                        break;
                    } else if (zzar.get(i).getProviderId().equals(this.zzfo)) {
                        zzar.get(i).zzt(this.zzfp);
                        break;
                    } else {
                        i++;
                    }
                }
            } else {
                zzar.get(0).zzt(this.zzfp);
            }
        }
        if (this.zzfq != null) {
            zzaj.zzd(this.zzfq.booleanValue());
        } else {
            if (zzaj.getLastSignInTimestamp() - zzaj.getCreationTimestamp() < 1000) {
                z = true;
            }
            zzaj.zzd(z);
        }
        zzaj.zzb(this.zzfr);
        this.zzfh.zza(this.zzfs, zzaj);
    }

    public final void zzc(@Nullable String str) {
        this.zzfk.zzc(str);
    }
}
