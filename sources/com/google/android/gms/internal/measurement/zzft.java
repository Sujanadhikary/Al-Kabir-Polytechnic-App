package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzft {
    private boolean value;
    private final boolean zzako = true;
    private boolean zzakp;
    private final /* synthetic */ zzfr zzakq;
    private final String zzny;

    public zzft(zzfr zzfr, String str, boolean z) {
        this.zzakq = zzfr;
        Preconditions.checkNotEmpty(str);
        this.zzny = str;
    }

    @WorkerThread
    public final boolean get() {
        if (!this.zzakp) {
            this.zzakp = true;
            this.value = this.zzakq.zziy().getBoolean(this.zzny, this.zzako);
        }
        return this.value;
    }

    @WorkerThread
    public final void set(boolean z) {
        SharedPreferences.Editor edit = this.zzakq.zziy().edit();
        edit.putBoolean(this.zzny, z);
        edit.apply();
        this.value = z;
    }
}
