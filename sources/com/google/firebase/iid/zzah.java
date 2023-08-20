package com.google.firebase.iid;

import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

final class zzah {
    @GuardedBy("this")
    private final Map<Pair<String, String>, TaskCompletionSource<String>> zzca = new ArrayMap();

    zzah() {
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.android.gms.tasks.TaskCompletionSource<java.lang.String>, com.google.android.gms.tasks.TaskCompletionSource] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zza(com.google.android.gms.tasks.TaskCompletionSource<java.lang.String> r2) throws java.io.IOException {
        /*
            com.google.android.gms.tasks.Task r0 = r2.getTask()     // Catch:{ ExecutionException -> 0x000b, InterruptedException -> 0x0024 }
            java.lang.Object r0 = com.google.android.gms.tasks.Tasks.await(r0)     // Catch:{ ExecutionException -> 0x000b, InterruptedException -> 0x0024 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ ExecutionException -> 0x000b, InterruptedException -> 0x0024 }
            return r0
        L_0x000b:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            boolean r1 = r0 instanceof java.io.IOException
            if (r1 == 0) goto L_0x0017
            java.io.IOException r0 = (java.io.IOException) r0
            throw r0
        L_0x0017:
            boolean r1 = r0 instanceof java.lang.RuntimeException
            if (r1 == 0) goto L_0x001e
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0
            throw r0
        L_0x001e:
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r0)
            throw r1
        L_0x0024:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzah.zza(com.google.android.gms.tasks.TaskCompletionSource):java.lang.String");
    }

    private static String zza(zzak zzak, TaskCompletionSource<String> taskCompletionSource) throws IOException {
        try {
            String zzp = zzak.zzp();
            taskCompletionSource.setResult(zzp);
            return zzp;
        } catch (IOException | RuntimeException e) {
            taskCompletionSource.setException(e);
            throw e;
        }
    }

    private final synchronized zzak zzb(String str, String str2, zzak zzak) {
        zzak zzaj;
        Pair pair = new Pair(str, str2);
        TaskCompletionSource taskCompletionSource = this.zzca.get(pair);
        if (taskCompletionSource != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Joining ongoing request for: ").append(valueOf).toString());
            }
            zzaj = new zzai(taskCompletionSource);
        } else {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf2 = String.valueOf(pair);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf2).length() + 24).append("Making new request for: ").append(valueOf2).toString());
            }
            TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            this.zzca.put(pair, taskCompletionSource2);
            zzaj = new zzaj(this, zzak, taskCompletionSource2, pair);
        }
        return zzaj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zza(zzak zzak, TaskCompletionSource taskCompletionSource, Pair pair) throws IOException {
        try {
            String zza = zza(zzak, taskCompletionSource);
            synchronized (this) {
                this.zzca.remove(pair);
            }
            return zza;
        } catch (Throwable th) {
            synchronized (this) {
                this.zzca.remove(pair);
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zza(String str, String str2, zzak zzak) throws IOException {
        return zzb(str, str2, zzak).zzp();
    }
}
