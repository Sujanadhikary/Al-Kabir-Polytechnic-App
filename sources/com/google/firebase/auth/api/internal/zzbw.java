package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbw extends zzcy<Void, zza> {
    @NonNull
    private final String zzbg;

    public zzbw(@NonNull String str) {
        super(2);
        this.zzbg = Preconditions.checkNotEmpty(str, "password cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzb(this.zzhx.zzo(), this.zzbg, (zzch) this.zzhw);
    }

    public final void zzz() {
        ((zza) this.zzhz).zza(this.zzig, zzao.zza(this.zzdz, this.zzih));
        zzb(null);
    }
}
