package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzo;

@VisibleForTesting
final class zzau extends zzcy<ProviderQueryResult, zza> {
    @NonNull
    private final String zzaf;

    public zzau(@NonNull String str) {
        super(3);
        this.zzaf = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzc(this.zzaf, this.zzhw);
    }

    public final void zzz() {
        zzb(new zzo(this.zzii));
    }
}
