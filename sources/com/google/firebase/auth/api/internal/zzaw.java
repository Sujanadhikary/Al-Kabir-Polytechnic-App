package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
final class zzaw extends zzcy<GetTokenResult, zza> {
    @NonNull
    private final String zzag;

    public zzaw(@NonNull String str) {
        super(1);
        this.zzag = Preconditions.checkNotEmpty(str, "refresh token cannot be null");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzag, (zzch) this.zzhw);
    }

    public final void zzz() {
        if (TextUtils.isEmpty(this.zzig.zzan())) {
            this.zzig.zzr(this.zzag);
        }
        ((zza) this.zzhz).zza(this.zzig, this.zzhx);
        zzb(zzx.zzag(this.zzig.zzau()));
    }
}
