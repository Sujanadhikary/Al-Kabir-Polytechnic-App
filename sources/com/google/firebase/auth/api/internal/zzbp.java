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
final class zzbp extends zzcy<AuthResult, zza> {
    @NonNull
    private final String zzdf;

    public zzbp(@NonNull String str) {
        super(2);
        this.zzdf = Preconditions.checkNotEmpty(str, "token cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzb(this.zzdf, this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
