package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbs extends zzcy<AuthResult, zza> {
    private PhoneAuthCredential zzgt;

    public zzbs(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzgt = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzgt, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
