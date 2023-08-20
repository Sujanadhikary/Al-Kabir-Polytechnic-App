package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzby extends zzcy<Void, zza> {
    @NonNull
    private final UserProfileChangeRequest zzha;

    public zzby(UserProfileChangeRequest userProfileChangeRequest) {
        super(2);
        this.zzha = (UserProfileChangeRequest) Preconditions.checkNotNull(userProfileChangeRequest, "request cannot be null");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhx.zzo(), this.zzha, (zzch) this.zzhw);
    }

    public final void zzz() {
        ((zza) this.zzhz).zza(this.zzig, zzao.zza(this.zzdz, this.zzih));
        zzb(null);
    }
}
