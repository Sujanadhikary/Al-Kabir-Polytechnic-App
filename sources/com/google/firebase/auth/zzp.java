package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzp implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zzes;
    private final /* synthetic */ ActionCodeSettings zzet;

    zzp(FirebaseUser firebaseUser, ActionCodeSettings actionCodeSettings) {
        this.zzes = firebaseUser;
        this.zzet = actionCodeSettings;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzes.zzm()).zza(this.zzet, ((GetTokenResult) task.getResult()).getToken());
    }
}
