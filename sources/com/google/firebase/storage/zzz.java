package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

final class zzz implements Runnable {
    private final /* synthetic */ Object zzcp;
    private final /* synthetic */ zzx zzcq;
    private final /* synthetic */ StorageTask.ProvideError zzcr;

    zzz(zzx zzx, Object obj, StorageTask.ProvideError provideError) {
        this.zzcq = zzx;
        this.zzcp = obj;
        this.zzcr = provideError;
    }

    public final void run() {
        this.zzcq.zzco.zza(this.zzcp, this.zzcr);
    }
}
