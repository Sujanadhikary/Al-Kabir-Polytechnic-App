package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbl extends zzcy<Void, zza> {
    @NonNull
    private final String zzaf;
    @NonNull
    private final ActionCodeSettings zzgx;

    public zzbl(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        super(4);
        this.zzaf = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzgx = actionCodeSettings;
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzc(this.zzaf, this.zzgx, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzb(null);
    }
}
