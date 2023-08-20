package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzba extends zzcy<AuthResult, zza> {
    @NonNull
    private final EmailAuthCredential zzgr;

    public zzba(@NonNull EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zzgr = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzgr.zza(this.zzhx), (zzch) this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
