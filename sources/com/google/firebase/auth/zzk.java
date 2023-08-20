package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.internal.InternalTokenResult;

final class zzk implements Runnable {
    private final /* synthetic */ FirebaseAuth zzem;
    private final /* synthetic */ InternalTokenResult zzeo;

    zzk(FirebaseAuth firebaseAuth, InternalTokenResult internalTokenResult) {
        this.zzem = firebaseAuth;
        this.zzeo = internalTokenResult;
    }

    public final void run() {
        this.zzem.zzdz.notifyIdTokenListeners(this.zzeo);
        for (FirebaseAuth.IdTokenListener onIdTokenChanged : this.zzem.zzea) {
            onIdTokenChanged.onIdTokenChanged(this.zzem);
        }
    }
}
