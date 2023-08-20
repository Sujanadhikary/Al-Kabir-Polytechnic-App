package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzj implements Runnable {
    private final /* synthetic */ FirebaseAuth zzem;
    private final /* synthetic */ FirebaseAuth.AuthStateListener zzen;

    zzj(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzem = firebaseAuth;
        this.zzen = authStateListener;
    }

    public final void run() {
        this.zzen.onAuthStateChanged(this.zzem);
    }
}
