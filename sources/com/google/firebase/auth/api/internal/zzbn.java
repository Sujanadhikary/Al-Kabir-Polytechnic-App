package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbn extends zzcy<AuthResult, zza> {
    public zzbn() {
        super(2);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih, true);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
