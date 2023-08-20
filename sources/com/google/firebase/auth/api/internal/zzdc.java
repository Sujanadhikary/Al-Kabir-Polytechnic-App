package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

final class zzdc implements zzdh {
    private final /* synthetic */ String zzis;

    zzdc(zzdb zzdb, String str) {
        this.zzis = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zzis, PhoneAuthProvider.ForceResendingToken.zzq());
    }
}
