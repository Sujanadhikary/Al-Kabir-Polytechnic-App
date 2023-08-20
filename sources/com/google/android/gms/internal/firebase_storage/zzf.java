package com.google.android.gms.internal.firebase_storage;

import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.FirebaseApp;
import java.util.Random;

public final class zzf {
    private static zzh zzds = new zzi();
    private static Clock zzdt = DefaultClock.getInstance();
    private static Random zzdu = new Random();
    private long zzdv;
    private volatile boolean zzdw;
    private FirebaseApp zzp;

    public zzf(FirebaseApp firebaseApp, long j) {
        this.zzp = firebaseApp;
        this.zzdv = j;
    }

    public static boolean zze(int i) {
        return (i >= 500 && i < 600) || i == -2 || i == 429 || i == 408;
    }

    public final void cancel() {
        this.zzdw = true;
    }

    public final void reset() {
        this.zzdw = false;
    }

    public final void zza(@NonNull zzq zzq, boolean z) {
        Preconditions.checkNotNull(zzq);
        long elapsedRealtime = zzdt.elapsedRealtime() + this.zzdv;
        if (z) {
            zzq.zza(zzk.zza(this.zzp), this.zzp.getApplicationContext());
        } else {
            zzq.zzg(zzk.zza(this.zzp));
        }
        int i = 1000;
        while (zzdt.elapsedRealtime() + ((long) i) <= elapsedRealtime && !zzq.zzaa() && zze(zzq.getResultCode())) {
            try {
                zzds.zzf(zzdu.nextInt(250) + i);
                if (i < 30000) {
                    if (zzq.getResultCode() != -2) {
                        i <<= 1;
                        Log.w("ExponenentialBackoff", "network error occurred, backing off/sleeping.");
                    } else {
                        Log.w("ExponenentialBackoff", "network unavailable, sleeping.");
                        i = 1000;
                    }
                }
                if (!this.zzdw) {
                    zzq.reset();
                    if (z) {
                        zzq.zza(zzk.zza(this.zzp), this.zzp.getApplicationContext());
                    } else {
                        zzq.zzg(zzk.zza(this.zzp));
                    }
                } else {
                    return;
                }
            } catch (InterruptedException e) {
                Log.w("ExponenentialBackoff", "thread interrupted during exponential backoff.");
                Thread.currentThread().interrupt();
                return;
            }
        }
    }
}
