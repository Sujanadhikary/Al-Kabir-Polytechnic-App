package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzap extends zzcy<Void, zza> {
    @NonNull
    private final String zzgq;

    public zzap(@NonNull String str) {
        super(7);
        this.zzgq = Preconditions.checkNotEmpty(str, "code cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzj(this.zzgq, this.zzhw);
    }

    public final void zzz() {
        zzb(null);
    }
}
