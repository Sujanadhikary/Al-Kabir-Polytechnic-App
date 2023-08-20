package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzc;

@VisibleForTesting
final class zzaq extends zzcy<ActionCodeResult, zza> {
    @NonNull
    private final String zzgq;

    public zzaq(@NonNull String str) {
        super(4);
        this.zzgq = Preconditions.checkNotEmpty(str, "code cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzi(this.zzgq, this.zzhw);
    }

    public final void zzz() {
        zzb(new zzc(this.zzij));
    }
}
