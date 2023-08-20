package com.google.android.gms.internal.firebase_database;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

final class zzkr implements DatabaseReference.CompletionListener {
    private final /* synthetic */ TaskCompletionSource zzus;

    zzkr(TaskCompletionSource taskCompletionSource) {
        this.zzus = taskCompletionSource;
    }

    public final void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
        if (databaseError != null) {
            this.zzus.setException(databaseError.toException());
        } else {
            this.zzus.setResult(null);
        }
    }
}
