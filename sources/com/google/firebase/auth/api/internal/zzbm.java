package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzbm extends zzcy<Void, zza> {
    private String zzgy;

    public zzbm(String str) {
        super(9);
        this.zzgy = str;
    }

    public final void zzy() throws RemoteException {
        this.zzhy.zzk(this.zzgy, this.zzhw);
    }

    public final void zzz() {
        zzb(null);
    }
}
