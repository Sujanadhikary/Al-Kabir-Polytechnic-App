package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;

abstract class zzat implements Runnable {
    private final /* synthetic */ zzaj zzhv;

    private zzat(zzaj zzaj) {
        this.zzhv = zzaj;
    }

    /* synthetic */ zzat(zzaj zzaj, zzak zzak) {
        this(zzaj);
    }

    @WorkerThread
    public void run() {
        this.zzhv.zzga.lock();
        try {
            if (!Thread.interrupted()) {
                zzaq();
                this.zzhv.zzga.unlock();
            }
        } catch (RuntimeException e) {
            this.zzhv.zzhf.zzb(e);
        } finally {
            this.zzhv.zzga.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public abstract void zzaq();
}
