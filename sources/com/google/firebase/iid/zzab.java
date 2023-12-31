package com.google.firebase.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzab<T> {
    final int what;
    final int zzbr;
    final TaskCompletionSource<T> zzbs = new TaskCompletionSource<>();
    final Bundle zzbt;

    zzab(int i, int i2, Bundle bundle) {
        this.zzbr = i;
        this.what = i2;
        this.zzbt = bundle;
    }

    /* access modifiers changed from: package-private */
    public final void finish(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 16 + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2).toString());
        }
        this.zzbs.setResult(t);
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzbr;
        return new StringBuilder(55).append("Request { what=").append(i).append(" id=").append(i2).append(" oneWay=").append(zzw()).append("}").toString();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzac zzac) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(zzac);
            Log.d("MessengerIpcClient", new StringBuilder(String.valueOf(valueOf).length() + 14 + String.valueOf(valueOf2).length()).append("Failing ").append(valueOf).append(" with ").append(valueOf2).toString());
        }
        this.zzbs.setException(zzac);
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(Bundle bundle);

    /* access modifiers changed from: package-private */
    public abstract boolean zzw();
}
