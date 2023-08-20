package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzv;

final class zzm implements zza, zzv {
    private final /* synthetic */ FirebaseAuth zzem;

    zzm(FirebaseAuth firebaseAuth) {
        this.zzem = firebaseAuth;
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zzem.signOut();
        }
    }

    public final void zza(@NonNull zzao zzao, @NonNull FirebaseUser firebaseUser) {
        this.zzem.zza(firebaseUser, zzao, true);
    }
}
