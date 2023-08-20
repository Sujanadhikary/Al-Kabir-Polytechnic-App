package com.google.android.gms.internal.firebase_database;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

final class zzki extends ScheduledThreadPoolExecutor {
    private final /* synthetic */ zzkh zzuk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzki(zzkh zzkh, int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.zzuk = zzkh;
    }

    /* access modifiers changed from: protected */
    public final void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th == null && (runnable instanceof Future)) {
            Future future = (Future) runnable;
            try {
                if (future.isDone()) {
                    future.get();
                }
            } catch (CancellationException e) {
            } catch (ExecutionException e2) {
                th = e2.getCause();
            } catch (InterruptedException e3) {
                Thread.currentThread().interrupt();
            }
        }
        if (th != null) {
            this.zzuk.zza(th);
        }
    }
}
