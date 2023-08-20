package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzp implements OnCompleteListener<TResult> {
    private final /* synthetic */ StorageTask zzbg;
    private final /* synthetic */ Continuation zzbh;
    final /* synthetic */ TaskCompletionSource zzbi;

    zzp(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource) {
        this.zzbg = storageTask;
        this.zzbh = continuation;
        this.zzbi = taskCompletionSource;
    }

    public final void onComplete(@NonNull Task<TResult> task) {
        try {
            Task task2 = (Task) this.zzbh.then(this.zzbg);
            if (this.zzbi.getTask().isComplete()) {
                return;
            }
            if (task2 == null) {
                this.zzbi.setException(new NullPointerException("Continuation returned null"));
                return;
            }
            task2.addOnSuccessListener(new zzq(this));
            task2.addOnFailureListener(new zzr(this));
        } catch (RuntimeExecutionException e) {
            if (e.getCause() instanceof Exception) {
                this.zzbi.setException((Exception) e.getCause());
            } else {
                this.zzbi.setException(e);
            }
        } catch (Exception e2) {
            this.zzbi.setException(e2);
        }
    }
}
