package com.google.firebase.storage;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;

final class zzr implements OnFailureListener {
    private final /* synthetic */ zzp zzbj;

    zzr(zzp zzp) {
        this.zzbj = zzp;
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zzbj.zzbi.setException(exc);
    }
}
