package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

final class zzde implements zzdh {
    private final /* synthetic */ String zzis;

    zzde(zzdb zzdb, String str) {
        this.zzis = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeAutoRetrievalTimeOut(this.zzis);
    }
}
