package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zzab implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzaa zzlr;

    zzab(zzaa zzaa) {
        this.zzlr = zzaa;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            boolean unused = this.zzlr.zzlq = true;
            this.zzlr.cancel();
            return;
        }
        boolean unused2 = this.zzlr.zzlq = false;
        if (this.zzlr.zzbj()) {
            this.zzlr.zzlp.zzbf();
        }
    }
}
