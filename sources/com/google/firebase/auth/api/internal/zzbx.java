package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbx extends zzcy<Void, zza> {
    @NonNull
    private final PhoneAuthCredential zzgt;

    public zzbx(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zzgt = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhx.zzo(), this.zzgt, (zzch) this.zzhw);
    }

    public final void zzz() {
        ((zza) this.zzhz).zza(this.zzig, zzao.zza(this.zzdz, this.zzih));
        zzb(null);
    }
}
