package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzck {
    public static final Status zzmm = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zzmn = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zzil;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zzmo = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zzcn zzmp = new zzcl(this);

    public zzck(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zzil = map;
    }

    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.internal.zzcn, com.google.android.gms.common.api.zzc, com.google.android.gms.common.api.internal.zzcl] */
    public final void release() {
        ? r7 = 0;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            basePendingResult.zza((zzcn) r7);
            if (basePendingResult.zzo() != null) {
                basePendingResult.setResultCallback(r7);
                IBinder serviceBrokerBinder = this.zzil.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zza((zzcn) new zzcm(basePendingResult, r7, serviceBrokerBinder, r7));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zza((zzcn) r7);
                    basePendingResult.cancel();
                    r7.remove(basePendingResult.zzo().intValue());
                } else {
                    zzcm zzcm = new zzcm(basePendingResult, r7, serviceBrokerBinder, r7);
                    basePendingResult.zza((zzcn) zzcm);
                    try {
                        serviceBrokerBinder.linkToDeath(zzcm, 0);
                    } catch (RemoteException e) {
                        basePendingResult.cancel();
                        r7.remove(basePendingResult.zzo().intValue());
                    }
                }
                this.zzmo.remove(basePendingResult);
            } else if (basePendingResult.zzw()) {
                this.zzmo.remove(basePendingResult);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(BasePendingResult<? extends Result> basePendingResult) {
        this.zzmo.add(basePendingResult);
        basePendingResult.zza(this.zzmp);
    }

    public final void zzce() {
        for (BasePendingResult zzb : (BasePendingResult[]) this.zzmo.toArray(zzmn)) {
            zzb.zzb(zzmm);
        }
    }
}
