package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbf;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzb;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbd extends zzcy<AuthResult, zza> {
    @NonNull
    private final zzbf zzgs;

    public zzbd(@NonNull AuthCredential authCredential) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zzgs = zzb.zza(authCredential).zze(false);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzgs, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        if (this.zzhx.getUid().equalsIgnoreCase(zzb.getUid())) {
            ((zza) this.zzhz).zza(this.zzig, zzb);
            zzb(new zzf(zzb));
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }
}
