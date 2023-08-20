package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbh extends zzcy<AuthResult, zza> {
    @NonNull
    private final String zzaf;
    @NonNull
    private final String zzbg;

    public zzbh(@NonNull String str, @NonNull String str2) {
        super(2);
        this.zzaf = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzbg = Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzd(this.zzaf, this.zzbg, this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        if (this.zzhx.getUid().equalsIgnoreCase(zzb.getUid())) {
            ((zza) this.zzhz).zza(this.zzig, zzb);
            zzb(new zzf(zzb));
            return;
        }
        zzc(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }
}
