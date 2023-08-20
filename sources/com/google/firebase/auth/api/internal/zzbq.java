package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;

@VisibleForTesting
final class zzbq extends zzcy<AuthResult, zza> {
    @NonNull
    private String zzaf;
    @NonNull
    private String zzbg;

    public zzbq(String str, String str2) {
        super(2);
        this.zzaf = Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zzbg = Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzd(this.zzaf, this.zzbg, this.zzhw);
    }

    public final void zzz() {
        zzk zzb = zzao.zza(this.zzdz, this.zzih);
        ((zza) this.zzhz).zza(this.zzig, zzb);
        zzb(new zzf(zzb));
    }
}
