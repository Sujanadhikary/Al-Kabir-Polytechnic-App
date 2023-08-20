package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbu extends zzcy<AuthResult, zza> {
    @NonNull
    private String provider;

    public zzbu(@NonNull String str) {
        super(2);
        this.provider = Preconditions.checkNotEmpty(str, "provider cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zze(this.provider, this.zzhx.zzo(), this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
