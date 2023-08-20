package com.google.firebase.storage;

import com.google.firebase.storage.StorageTask;

final class zzaa implements Runnable {
    private final /* synthetic */ zzx zzcq;
    private final /* synthetic */ StorageTask.ProvideError zzcr;
    private final /* synthetic */ Object zzcs;

    zzaa(zzx zzx, Object obj, StorageTask.ProvideError provideError) {
        this.zzcq = zzx;
        this.zzcs = obj;
        this.zzcr = provideError;
    }

    public final void run() {
        this.zzcq.zzco.zza(this.zzcs, this.zzcr);
    }
}
