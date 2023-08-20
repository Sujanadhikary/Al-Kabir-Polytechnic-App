package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseNetworkException;

final class zzt implements OnFailureListener {
    private final /* synthetic */ zzs zzli;

    zzt(zzs zzs) {
        this.zzli = zzs;
    }

    public final void onFailure(@NonNull Exception exc) {
        if (exc instanceof FirebaseNetworkException) {
            zzr.zzdv.mo8045v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            this.zzli.zzlh.zzbg();
        }
    }
}
