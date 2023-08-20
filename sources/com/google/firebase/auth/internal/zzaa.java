package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.FirebaseApp;

public final class zzaa implements FirebaseApp.IdTokenListenersCountChangedListener {
    private volatile int zzlo;
    /* access modifiers changed from: private */
    public final zzr zzlp;
    /* access modifiers changed from: private */
    public volatile boolean zzlq;

    @VisibleForTesting
    private zzaa(@NonNull Context context, @NonNull zzr zzr) {
        this.zzlq = false;
        this.zzlo = 0;
        this.zzlp = zzr;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzab(this));
    }

    public zzaa(@NonNull FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzr(firebaseApp));
    }

    /* access modifiers changed from: private */
    public final boolean zzbj() {
        return this.zzlo > 0 && !this.zzlq;
    }

    public final void cancel() {
        this.zzlp.cancel();
    }

    public final void onListenerCountChanged(int i) {
        if (i > 0 && this.zzlo == 0) {
            this.zzlo = i;
            if (zzbj()) {
                this.zzlp.zzbf();
            }
        } else if (i == 0 && this.zzlo != 0) {
            this.zzlp.cancel();
        }
        this.zzlo = i;
    }

    public final void zzc(@NonNull zzao zzao) {
        if (zzao != null) {
            long zzao2 = zzao.zzao();
            if (zzao2 <= 0) {
                zzao2 = 3600;
            }
            long zzaw = (zzao2 * 1000) + zzao.zzaw();
            zzr zzr = this.zzlp;
            zzr.zzlc = zzaw;
            zzr.zzld = -1;
            if (zzbj()) {
                this.zzlp.zzbf();
            }
        }
    }
}
