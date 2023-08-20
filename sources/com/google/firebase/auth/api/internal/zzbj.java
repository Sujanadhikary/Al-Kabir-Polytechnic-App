package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbj extends zzcy<Void, zza> {
    public zzbj() {
        super(2);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzf(this.zzhx.zzo(), this.zzhw);
    }

    public final void zzz() {
        ((zza) this.zzhz).zza(this.zzig, zzao.zza(this.zzdz, this.zzih, this.zzhx.isAnonymous()));
        zzb(null);
    }
}
