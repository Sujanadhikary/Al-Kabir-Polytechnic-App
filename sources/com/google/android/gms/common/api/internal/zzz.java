package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zzz implements OnCompleteListener<Map<zzh<?>, String>> {
    private final /* synthetic */ zzw zzgu;
    private SignInConnectionListener zzgv;

    zzz(zzw zzw, SignInConnectionListener signInConnectionListener) {
        this.zzgu = zzw;
        this.zzgv = signInConnectionListener;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        this.zzgv.onComplete();
    }

    public final void onComplete(@NonNull Task<Map<zzh<?>, String>> task) {
        this.zzgu.zzga.lock();
        try {
            if (!this.zzgu.zzgp) {
                this.zzgv.onComplete();
                return;
            }
            if (task.isSuccessful()) {
                Map unused = this.zzgu.zzgr = new ArrayMap(this.zzgu.zzgh.size());
                for (zzv zzm : this.zzgu.zzgh.values()) {
                    this.zzgu.zzgr.put(zzm.zzm(), ConnectionResult.RESULT_SUCCESS);
                }
            } else if (task.getException() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.getException();
                if (this.zzgu.zzgn) {
                    Map unused2 = this.zzgu.zzgr = new ArrayMap(this.zzgu.zzgh.size());
                    for (zzv zzv : this.zzgu.zzgh.values()) {
                        zzh zzm2 = zzv.zzm();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(zzv);
                        if (this.zzgu.zza((zzv<?>) zzv, connectionResult)) {
                            this.zzgu.zzgr.put(zzm2, new ConnectionResult(16));
                        } else {
                            this.zzgu.zzgr.put(zzm2, connectionResult);
                        }
                    }
                } else {
                    Map unused3 = this.zzgu.zzgr = availabilityException.zzl();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                Map unused4 = this.zzgu.zzgr = Collections.emptyMap();
            }
            if (this.zzgu.isConnected()) {
                this.zzgu.zzgq.putAll(this.zzgu.zzgr);
                if (this.zzgu.zzai() == null) {
                    this.zzgu.zzag();
                    this.zzgu.zzah();
                    this.zzgu.zzgl.signalAll();
                }
            }
            this.zzgv.onComplete();
            this.zzgu.zzga.unlock();
        } finally {
            this.zzgu.zzga.unlock();
        }
    }
}
