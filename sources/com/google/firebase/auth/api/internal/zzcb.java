package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzx;

public final class zzcb {
    private final Logger zzdv;
    private final zzch zzhc;

    public zzcb(@NonNull zzch zzch, @NonNull Logger logger) {
        this.zzhc = (zzch) Preconditions.checkNotNull(zzch);
        this.zzdv = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void onFailure(@NonNull Status status) {
        try {
            this.zzhc.onFailure(status);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending failure result.", e, new Object[0]);
        }
    }

    public final void zza(@NonNull zzao zzao, @NonNull zzaj zzaj) {
        try {
            this.zzhc.zza(zzao, zzaj);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending get token and account info user response", e, new Object[0]);
        }
    }

    public final void zza(@Nullable zzav zzav) {
        try {
            this.zzhc.zza(zzav);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending password reset response.", e, new Object[0]);
        }
    }

    public final void zza(@NonNull zzx zzx) {
        try {
            this.zzhc.zza(zzx);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending create auth uri response.", e, new Object[0]);
        }
    }

    public final void zzaa() {
        try {
            this.zzhc.zzaa();
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending delete account response.", e, new Object[0]);
        }
    }

    public final void zzab() {
        try {
            this.zzhc.zzab();
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending email verification response.", e, new Object[0]);
        }
    }

    public final void zzac() {
        try {
            this.zzhc.zzac();
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when setting FirebaseUI Version", e, new Object[0]);
        }
    }

    public final void zzb(@NonNull zzao zzao) {
        try {
            this.zzhc.zzb(zzao);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending token result.", e, new Object[0]);
        }
    }

    public final void zzd(@NonNull String str) {
        try {
            this.zzhc.zzd(str);
        } catch (RemoteException e) {
            this.zzdv.mo8035e("RemoteException when sending set account info response.", e, new Object[0]);
        }
    }
}
