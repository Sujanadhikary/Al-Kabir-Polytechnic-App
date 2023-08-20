package com.google.firebase.storage;

import com.google.android.gms.internal.firebase_storage.zzk;
import com.google.android.gms.internal.firebase_storage.zzq;

final class zzad implements Runnable {
    private final /* synthetic */ zzq zzdd;
    private final /* synthetic */ UploadTask zzde;

    zzad(UploadTask uploadTask, zzq zzq) {
        this.zzde = uploadTask;
        this.zzdd = zzq;
    }

    public final void run() {
        this.zzdd.zza(zzk.zza(this.zzde.zzd.getStorage().getApp()), this.zzde.zzd.getStorage().getApp().getApplicationContext());
    }
}
