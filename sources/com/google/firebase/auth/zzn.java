package com.google.firebase.auth;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.internal.zzu;

final class zzn implements zzu {
    private final /* synthetic */ FirebaseAuth zzem;
    private final /* synthetic */ FirebaseUser zzep;

    zzn(FirebaseAuth firebaseAuth, FirebaseUser firebaseUser) {
        this.zzem = firebaseAuth;
        this.zzep = firebaseUser;
    }

    public final void zza(Status status) {
        if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
            this.zzem.signOut();
        }
    }

    public final void zzl() {
        if (this.zzem.zzed.getUid().equalsIgnoreCase(this.zzep.getUid())) {
            this.zzem.zzj();
        }
    }
}
