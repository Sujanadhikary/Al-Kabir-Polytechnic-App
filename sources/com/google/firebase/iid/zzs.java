package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.VisibleForTesting;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

public final class zzs {
    @GuardedBy("MessengerIpcClient.class")
    private static zzs zzbf;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzbg;
    @GuardedBy("this")
    private zzu zzbh = new zzu(this);
    @GuardedBy("this")
    private int zzbi = 1;
    /* access modifiers changed from: private */
    public final Context zzz;

    @VisibleForTesting
    private zzs(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzbg = scheduledExecutorService;
        this.zzz = context.getApplicationContext();
    }

    private final synchronized <T> Task<T> zza(zzab<T> zzab) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzab);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 9).append("Queueing ").append(valueOf).toString());
        }
        if (!this.zzbh.zzb(zzab)) {
            this.zzbh = new zzu(this);
            this.zzbh.zzb(zzab);
        }
        return zzab.zzbs.getTask();
    }

    public static synchronized zzs zzc(Context context) {
        zzs zzs;
        synchronized (zzs.class) {
            if (zzbf == null) {
                zzbf = new zzs(context, Executors.newSingleThreadScheduledExecutor());
            }
            zzs = zzbf;
        }
        return zzs;
    }

    private final synchronized int zzs() {
        int i;
        i = this.zzbi;
        this.zzbi = i + 1;
        return i;
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new zzaa(zzs(), 2, bundle));
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new zzad(zzs(), 1, bundle));
    }
}
