package com.google.android.gms.internal.firebase_storage;

import android.app.Activity;
import android.support.annotation.NonNull;

final class zzd {
    @NonNull
    private final Activity zzdj;
    @NonNull
    private final Runnable zzdk;
    @NonNull
    private final Object zzdl;

    public zzd(@NonNull Activity activity, @NonNull Runnable runnable, @NonNull Object obj) {
        this.zzdj = activity;
        this.zzdk = runnable;
        this.zzdl = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzd)) {
            return false;
        }
        zzd zzd = (zzd) obj;
        return zzd.zzdl.equals(this.zzdl) && zzd.zzdk == this.zzdk && zzd.zzdj == this.zzdj;
    }

    @NonNull
    public final Activity getActivity() {
        return this.zzdj;
    }

    public final int hashCode() {
        return this.zzdl.hashCode();
    }

    @NonNull
    public final Runnable zzj() {
        return this.zzdk;
    }

    @NonNull
    public final Object zzt() {
        return this.zzdl;
    }
}
