package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbi extends zzcy<Void, zza> {
    @NonNull
    private final PhoneAuthCredential zzgt;

    public zzbi(@NonNull PhoneAuthCredential phoneAuthCredential) {
        super(2);
        Preconditions.checkNotNull(phoneAuthCredential, "credential cannot be null");
        this.zzgt = phoneAuthCredential.zzb(false);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzgt, (zzch) this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        if (this.zzhx.getUid().equalsIgnoreCase(zzb.getUid())) {
            ((zza) this.zzhz).zza(this.zzig, zzb);
            zzb(null);
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }
}
