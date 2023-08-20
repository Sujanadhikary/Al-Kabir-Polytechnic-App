package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzaz extends zzcy<AuthResult, zza> implements zzda {
    @NonNull
    private final PhoneAuthCredential zzgt;

    public zzaz(@NonNull PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzgt = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        this.zzif = this;
    }

    public final void zza(@NonNull Status status, @NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zzhv == 2, new StringBuilder(36).append("Unexpected response type ").append(this.zzhv).toString());
        this.zzin = false;
        this.zzil = phoneAuthCredential;
        if (this.zzia != null) {
            this.zzia.zza(status);
        }
        zzc(status);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhx.zzo(), this.zzgt, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
