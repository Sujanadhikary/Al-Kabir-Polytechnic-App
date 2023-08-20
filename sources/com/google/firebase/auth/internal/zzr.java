package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApp;

public final class zzr {
    /* access modifiers changed from: private */
    public static Logger zzdv = new Logger("TokenRefresher", "FirebaseAuth:");
    @VisibleForTesting
    private Handler handler;
    private final FirebaseApp zzdz;
    @VisibleForTesting
    volatile long zzlc;
    @VisibleForTesting
    volatile long zzld;
    @VisibleForTesting
    private long zzle;
    @VisibleForTesting
    private HandlerThread zzlf = new HandlerThread("TokenRefresher", 10);
    @VisibleForTesting
    private Runnable zzlg;

    public zzr(@NonNull FirebaseApp firebaseApp) {
        zzdv.mo8045v("Initializing TokenRefresher", new Object[0]);
        this.zzdz = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzlf.start();
        this.handler = new Handler(this.zzlf.getLooper());
        this.zzlg = new zzs(this, this.zzdz.getName());
        this.zzle = 300000;
    }

    public final void cancel() {
        this.handler.removeCallbacks(this.zzlg);
    }

    public final void zzbf() {
        zzdv.mo8045v(new StringBuilder(43).append("Scheduling refresh for ").append(this.zzlc - this.zzle).toString(), new Object[0]);
        cancel();
        this.zzld = Math.max((this.zzlc - DefaultClock.getInstance().currentTimeMillis()) - this.zzle, 0) / 1000;
        this.handler.postDelayed(this.zzlg, this.zzld * 1000);
    }

    /* access modifiers changed from: package-private */
    public final void zzbg() {
        long j;
        switch ((int) this.zzld) {
            case 30:
            case 60:
            case 120:
            case 240:
            case 480:
                j = 2 * this.zzld;
                break;
            case 960:
                j = 960;
                break;
            default:
                j = 30;
                break;
        }
        this.zzld = j;
        this.zzlc = DefaultClock.getInstance().currentTimeMillis() + (this.zzld * 1000);
        zzdv.mo8045v(new StringBuilder(43).append("Scheduling refresh for ").append(this.zzlc).toString(), new Object[0]);
        this.handler.postDelayed(this.zzlg, this.zzld * 1000);
    }
}
