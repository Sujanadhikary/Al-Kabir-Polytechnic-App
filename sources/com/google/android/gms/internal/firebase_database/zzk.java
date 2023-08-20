package com.google.android.gms.internal.firebase_database;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.FirebaseApp;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzk implements zzbq {
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzbc;
    private final FirebaseApp zzbd;

    public zzk(@NonNull FirebaseApp firebaseApp, @NonNull ScheduledExecutorService scheduledExecutorService) {
        this.zzbd = firebaseApp;
        this.zzbc = scheduledExecutorService;
    }

    public final void zza(zzbs zzbs) {
        this.zzbd.addIdTokenListener(new zzn(this, zzbs));
    }

    public final void zza(boolean z, @NonNull zzbr zzbr) {
        this.zzbd.getToken(z).addOnSuccessListener((Executor) this.zzbc, new zzm(this, zzbr)).addOnFailureListener((Executor) this.zzbc, (OnFailureListener) new zzl(this, zzbr));
    }
}
