package com.google.firebase.iid;

import android.content.Intent;
import android.support.annotation.WorkerThread;
import android.util.Log;

public class FirebaseInstanceIdService extends zzb {
    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public final Intent zzb(Intent intent) {
        return zzan.zzad().zzco.poll();
    }

    public final void zzd(Intent intent) {
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            onTokenRefresh();
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(stringExtra).length() + 21 + String.valueOf(valueOf).length()).append("Received command: ").append(stringExtra).append(" - ").append(valueOf).toString());
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.getInstance().zzk();
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId.getInstance().zzl();
            }
        }
    }
}
