package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzjg;

public final class zzjc<T extends Context & zzjg> {
    private final T zzabm;

    public zzjc(T t) {
        Preconditions.checkNotNull(t);
        this.zzabm = t;
    }

    public static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        return Build.VERSION.SDK_INT >= 24 ? zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService") : zzka.zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    private final void zzb(Runnable runnable) {
        zzgl zzg = zzgl.zzg(this.zzabm);
        zzg.zzgd().zzc((Runnable) new zzjf(this, zzg, runnable));
    }

    private final zzfg zzge() {
        return zzgl.zzg(this.zzabm).zzge();
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        if (intent == null) {
            zzge().zzim().log("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgn(zzgl.zzg(this.zzabm));
        }
        zzge().zzip().zzg("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final void onCreate() {
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void onDestroy() {
        zzgl.zzg(this.zzabm).zzge().zzit().log("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final void onRebind(Intent intent) {
        if (intent == null) {
            zzge().zzim().log("onRebind called with null intent");
            return;
        }
        zzge().zzit().zzg("onRebind called. action", intent.getAction());
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        if (intent == null) {
            zzge.zzip().log("AppMeasurementService started with null intent");
        } else {
            String action = intent.getAction();
            zzge.zzit().zze("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
            if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
                zzb(new zzjd(this, i2, zzge, intent));
            }
        }
        return 2;
    }

    @TargetApi(24)
    @MainThread
    public final boolean onStartJob(JobParameters jobParameters) {
        zzfg zzge = zzgl.zzg(this.zzabm).zzge();
        String string = jobParameters.getExtras().getString("action");
        zzge.zzit().zzg("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zzb(new zzje(this, zzge, jobParameters));
        return true;
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        if (intent == null) {
            zzge().zzim().log("onUnbind called with null intent");
        } else {
            zzge().zzit().zzg("onUnbind called for intent. action", intent.getAction());
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzfg zzfg, Intent intent) {
        if (((zzjg) this.zzabm).callServiceStopSelfResult(i)) {
            zzfg.zzit().zzg("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzge().zzit().log("Completed wakeful intent.");
            ((zzjg) this.zzabm).zzb(intent);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzfg zzfg, JobParameters jobParameters) {
        zzfg.zzit().log("AppMeasurementJobService processed last upload request.");
        ((zzjg) this.zzabm).zza(jobParameters, false);
    }
}
