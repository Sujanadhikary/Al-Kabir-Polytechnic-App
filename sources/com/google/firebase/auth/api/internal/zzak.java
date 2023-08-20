package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;

@VisibleForTesting
final class zzak implements zzan {
    private final int zzgk;
    private final int zzgl;
    private final Map<String, Integer> zzgm;
    private final boolean zzgn = true;

    public zzak(int i, int i2, @NonNull Map<String, Integer> map, boolean z) {
        this.zzgk = i;
        this.zzgl = i2;
        this.zzgm = (Map) Preconditions.checkNotNull(map);
    }

    public final boolean zzd(zzam zzam) {
        if (!this.zzgn) {
            return true;
        }
        if (this.zzgl <= this.zzgk) {
            return false;
        }
        Integer num = this.zzgm.get(zzam.zzx());
        if (num == null) {
            return false;
        }
        return num.intValue() > this.zzgk && this.zzgl >= num.intValue();
    }
}
