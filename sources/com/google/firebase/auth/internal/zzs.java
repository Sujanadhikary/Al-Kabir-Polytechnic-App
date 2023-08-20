package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;

final class zzs implements Runnable {
    private final String zzkt;
    final /* synthetic */ zzr zzlh;

    zzs(@NonNull zzr zzr, String str) {
        this.zzlh = zzr;
        this.zzkt = Preconditions.checkNotEmpty(str);
    }

    public final void run() {
        FirebaseApp instance = FirebaseApp.getInstance(this.zzkt);
        FirebaseAuth instance2 = FirebaseAuth.getInstance(instance);
        zzw.initialize(instance.getApplicationContext());
        if (instance2.getCurrentUser() != null && zzw.zzll.get().booleanValue()) {
            Task<GetTokenResult> accessToken = instance2.getAccessToken(true);
            zzr.zzdv.mo8045v("Token refreshing started", new Object[0]);
            accessToken.addOnFailureListener(new zzt(this));
        }
    }
}
