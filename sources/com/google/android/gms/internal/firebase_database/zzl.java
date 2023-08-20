package com.google.android.gms.internal.firebase_database;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

final class zzl implements OnFailureListener {
    private final /* synthetic */ zzbr zzbe;

    zzl(zzk zzk, zzbr zzbr) {
        this.zzbe = zzbr;
    }

    public final void onFailure(@NonNull Exception exc) {
        if ((exc instanceof FirebaseApiNotAvailableException) || (exc instanceof FirebaseNoSignedInUserException)) {
            this.zzbe.zzf((String) null);
        } else {
            this.zzbe.onError(exc.getMessage());
        }
    }
}
