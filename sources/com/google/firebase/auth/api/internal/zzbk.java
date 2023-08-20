package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbk extends zzcy<Void, zza> {
    @NonNull
    private String zzdf;
    @Nullable
    private ActionCodeSettings zzgx;

    public zzbk(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        super(6);
        this.zzdf = Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zzgx = actionCodeSettings;
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzb(this.zzdf, this.zzgx, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzb(null);
    }
}
