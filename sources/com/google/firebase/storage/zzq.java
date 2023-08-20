package com.google.firebase.storage;

import com.google.android.gms.tasks.OnSuccessListener;

final class zzq implements OnSuccessListener<TContinuationResult> {
    private final /* synthetic */ zzp zzbj;

    zzq(zzp zzp) {
        this.zzbj = zzp;
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzbj.zzbi.setResult(tcontinuationresult);
    }
}
