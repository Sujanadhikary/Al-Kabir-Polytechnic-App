package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzc;

@VisibleForTesting
final class zzbz extends zzcy<String, zza> {
    @NonNull
    private final String zzgq;

    public zzbz(@NonNull String str) {
        super(4);
        this.zzgq = Preconditions.checkNotEmpty(str, "code cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzi(this.zzgq, this.zzhw);
    }

    public final void zzz() {
        if (new zzc(this.zzij).getOperation() != 0) {
            zzc(new Status(FirebaseError.ERROR_INTERNAL_ERROR));
        } else {
            zzb(this.zzij.getEmail());
        }
    }
}
