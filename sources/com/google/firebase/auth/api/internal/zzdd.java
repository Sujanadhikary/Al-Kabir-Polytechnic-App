package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzdd implements zzdh {
    private final /* synthetic */ PhoneAuthCredential zzit;

    zzdd(zzdb zzdb, PhoneAuthCredential phoneAuthCredential) {
        this.zzit = phoneAuthCredential;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationCompleted(this.zzit);
    }
}
