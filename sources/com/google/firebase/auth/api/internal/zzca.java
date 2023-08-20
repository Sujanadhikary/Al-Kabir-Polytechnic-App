package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzax;
import com.google.firebase.auth.PhoneAuthProvider;

@VisibleForTesting
final class zzca extends zzcy<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzax zzhb;

    public zzca(zzax zzax) {
        super(8);
        this.zzhb = (zzax) Preconditions.checkNotNull(zzax);
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zza(this.zzhb, (zzch) this.zzhw);
    }

    public final void zzz() {
    }
}
