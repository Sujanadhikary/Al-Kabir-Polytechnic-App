package com.google.firebase.auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    private AuthCredential zzeq;

    public FirebaseAuthUserCollisionException(@NonNull String str, @NonNull String str2) {
        super(str, str2);
        this.zzeq = null;
    }

    public FirebaseAuthUserCollisionException(@NonNull String str, @NonNull String str2, @NonNull AuthCredential authCredential) {
        super(str, str2);
        this.zzeq = authCredential;
    }

    @Nullable
    public final AuthCredential getUpdatedCredential() {
        return this.zzeq;
    }
}
