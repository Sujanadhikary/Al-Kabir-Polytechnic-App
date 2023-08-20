package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzdf implements zzdh {
    private final /* synthetic */ Status zziu;

    zzdf(zzdb zzdb, Status status) {
        this.zziu = status;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzce.zzb(this.zziu));
    }
}
