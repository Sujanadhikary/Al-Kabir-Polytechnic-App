package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzi implements Runnable {
    private final /* synthetic */ FirebaseAuth.IdTokenListener zzel;
    private final /* synthetic */ FirebaseAuth zzem;

    zzi(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzem = firebaseAuth;
        this.zzel = idTokenListener;
    }

    public final void run() {
        this.zzel.onIdTokenChanged(this.zzem);
    }
}
