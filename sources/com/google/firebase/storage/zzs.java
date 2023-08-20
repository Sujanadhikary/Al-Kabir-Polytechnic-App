package com.google.firebase.storage;

final class zzs implements Runnable {
    private final /* synthetic */ StorageTask zzbg;

    zzs(StorageTask storageTask) {
        this.zzbg = storageTask;
    }

    public final void run() {
        try {
            this.zzbg.run();
        } finally {
            this.zzbg.zzk();
        }
    }
}
