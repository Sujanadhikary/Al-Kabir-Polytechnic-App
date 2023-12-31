package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfu {
    private long value;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final long zzakr;
    private final String zzny;

    public zzfu(zzfr zzfr, String str, long j) {
        this.zzakq = zzfr;
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
        this.zzakr = j;
    }

    @WorkerThread
    public final long get() {
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = this.zzakq.zziy().getLong(this.zzny, this.zzakr);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(long j) {
        SharedPreferences.Editor edit = this.zzakq.zziy().edit();
        edit.putLong(this.zzny, j);
        edit.apply();
        this.value = j;
    }
}
