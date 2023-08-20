package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbv extends zzcy<Void, zza> {
    @NonNull
    private final String zzaf;

    public zzbv(String str) {
        super(2);
        this.zzaf = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhx.zzo(), this.zzaf, (zzch) this.zzhw);
    }

    public final void zzz() {
        ((zza) this.zzhz).zza(this.zzig, zzao.zza(this.zzdz, this.zzih));
        zzb(null);
    }
}
