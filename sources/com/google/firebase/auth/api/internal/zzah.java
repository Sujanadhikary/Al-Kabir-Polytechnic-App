package com.google.firebase.auth.api.internal;

import android.support.annotation.GuardedBy;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseError;

public abstract class zzah {
    private static Logger zzdv = new Logger("BiChannelGoogleApi", "FirebaseAuth: ");
    @GuardedBy("this")
    private zzai zzgf;

    private final GoogleApi zzc(zzam zzam) {
        zzai zzv = zzv();
        if (zzv.zzgi.zzd(zzam)) {
            Logger logger = zzdv;
            String valueOf = String.valueOf(zzv.zzgh);
            logger.mo8047w(new StringBuilder(String.valueOf(valueOf).length() + 43).append("getGoogleApiForMethod() returned Fallback: ").append(valueOf).toString(), new Object[0]);
            return zzv.zzgh;
        }
        Logger logger2 = zzdv;
        String valueOf2 = String.valueOf(zzv.zzgg);
        logger2.mo8047w(new StringBuilder(String.valueOf(valueOf2).length() + 38).append("getGoogleApiForMethod() returned Gms: ").append(valueOf2).toString(), new Object[0]);
        return zzv.zzgg;
    }

    private final zzai zzv() {
        zzai zzai;
        synchronized (this) {
            if (this.zzgf == null) {
                this.zzgf = zzu();
            }
            zzai = this.zzgf;
        }
        return zzai;
    }

    public final <TResult, A extends Api.AnyClient> Task<TResult> zza(zzam<A, TResult> zzam) {
        GoogleApi zzc = zzc(zzam);
        return zzc == null ? Tasks.forException(zzce.zzb(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable"))) : zzc.doRead(zzam);
    }

    public final <TResult, A extends Api.AnyClient> Task<TResult> zzb(zzam<A, TResult> zzam) {
        GoogleApi zzc = zzc(zzam);
        return zzc == null ? Tasks.forException(zzce.zzb(new Status(FirebaseError.ERROR_INTERNAL_ERROR, "Unable to connect to GoogleApi instance - Google Play Services may be unavailable"))) : zzc.doWrite(zzam);
    }

    /* access modifiers changed from: package-private */
    public abstract zzai zzu();
}
