package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzar extends zzcy<Void, zza> {
    @NonNull
    private final String zzay;
    @NonNull
    private final String zzgq;

    public zzar(@NonNull String str, @NonNull String str2) {
        super(4);
        this.zzgq = Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zzay = Preconditions.checkNotEmpty(str2, "new password cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzf(this.zzgq, this.zzay, this.zzhw);
    }

    public final void zzz() {
        zzb(null);
    }
}
