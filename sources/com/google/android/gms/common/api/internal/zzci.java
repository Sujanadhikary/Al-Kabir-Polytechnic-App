package com.google.android.gms.common.api.internal;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;

final class zzci implements Runnable {
    private final /* synthetic */ Result zzmk;
    private final /* synthetic */ zzch zzml;

    zzci(zzch zzch, Result result) {
        this.zzml = zzch;
        this.zzmk = result;
    }

    @WorkerThread
    public final void run() {
        try {
            BasePendingResult.zzez.set(true);
            this.zzml.zzmi.sendMessage(this.zzml.zzmi.obtainMessage(0, this.zzml.zzmd.onSuccess(this.zzmk)));
            BasePendingResult.zzez.set(false);
            zzch.zzb(this.zzmk);
            GoogleApiClient googleApiClient = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient != null) {
                googleApiClient.zzb(this.zzml);
            }
        } catch (RuntimeException e) {
            this.zzml.zzmi.sendMessage(this.zzml.zzmi.obtainMessage(1, e));
            BasePendingResult.zzez.set(false);
            zzch.zzb(this.zzmk);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zzb(this.zzml);
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            BasePendingResult.zzez.set(false);
            zzch.zzb(this.zzmk);
            GoogleApiClient googleApiClient3 = (GoogleApiClient) this.zzml.zzfc.get();
            if (googleApiClient3 != null) {
                googleApiClient3.zzb(this.zzml);
            }
            throw th2;
        }
    }
}
