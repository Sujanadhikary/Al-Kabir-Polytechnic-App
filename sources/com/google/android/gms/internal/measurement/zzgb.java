package com.google.android.gms.internal.measurement;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;

public final class zzgb {
    private final zzge zzala;

    public zzgb(zzge zzge) {
        Preconditions.checkNotNull(zzge);
        this.zzala = zzge;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r1 = r1.getReceiverInfo(new android.content.ComponentName(r4, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zza(android.content.Context r4) {
        /*
            r0 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001f }
            if (r1 != 0) goto L_0x000b
        L_0x000a:
            return r0
        L_0x000b:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x001f }
            java.lang.String r3 = "com.google.android.gms.measurement.AppMeasurementReceiver"
            r2.<init>(r4, r3)     // Catch:{ NameNotFoundException -> 0x001f }
            r3 = 0
            android.content.pm.ActivityInfo r1 = r1.getReceiverInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x001f }
            if (r1 == 0) goto L_0x000a
            boolean r1 = r1.enabled     // Catch:{ NameNotFoundException -> 0x001f }
            if (r1 == 0) goto L_0x000a
            r0 = 1
            goto L_0x000a
        L_0x001f:
            r1 = move-exception
            goto L_0x000a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgb.zza(android.content.Context):boolean");
    }

    @MainThread
    public final void onReceive(Context context, Intent intent) {
        zzgl zzg = zzgl.zzg(context);
        zzfg zzge = zzg.zzge();
        if (intent == null) {
            zzge.zzip().log("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzge.zzit().zzg("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzge.zzit().log("Starting wakeful intent.");
            this.zzala.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            try {
                zzg.zzgd().zzc((Runnable) new zzgc(this, zzg, zzge));
            } catch (Exception e) {
                zzge.zzip().zzg("Install Referrer Reporter encountered a problem", e);
            }
            BroadcastReceiver.PendingResult doGoAsync = this.zzala.doGoAsync();
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzge.zzit().log("Install referrer extras are null");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            zzge.zzir().zzg("Install referrer extras are", stringExtra);
            if (!stringExtra.contains("?")) {
                String valueOf = String.valueOf(stringExtra);
                stringExtra = valueOf.length() != 0 ? "?".concat(valueOf) : new String("?");
            }
            Bundle zza = zzg.zzgb().zza(Uri.parse(stringExtra));
            if (zza == null) {
                zzge.zzit().log("No campaign defined in install referrer broadcast");
                if (doGoAsync != null) {
                    doGoAsync.finish();
                    return;
                }
                return;
            }
            long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzge.zzip().log("Install referrer is missing timestamp");
            }
            zzg.zzgd().zzc((Runnable) new zzgd(this, zzg, longExtra, zza, context, zzge, doGoAsync));
        }
    }
}
