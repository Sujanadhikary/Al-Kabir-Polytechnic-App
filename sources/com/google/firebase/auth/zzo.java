package com.google.firebase.auth;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

final class zzo implements Continuation<GetTokenResult, Task<Void>> {
    private final /* synthetic */ FirebaseUser zzes;

    zzo(FirebaseUser firebaseUser) {
        this.zzes = firebaseUser;
    }

    public final /* synthetic */ Object then(@NonNull Task task) throws Exception {
        return FirebaseAuth.getInstance(this.zzes.zzm()).zza((ActionCodeSettings) null, ((GetTokenResult) task.getResult()).getToken());
    }
}
