package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzl implements Runnable {
    private final /* synthetic */ FirebaseAuth zzem;

    zzl(FirebaseAuth firebaseAuth) {
        this.zzem = firebaseAuth;
    }

    public final void run() {
        for (FirebaseAuth.AuthStateListener onAuthStateChanged : this.zzem.zzeb) {
            onAuthStateChanged.onAuthStateChanged(this.zzem);
        }
    }
}
