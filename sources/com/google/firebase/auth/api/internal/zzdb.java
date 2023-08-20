package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzaj;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzav;
import com.google.android.gms.internal.firebase_auth.zzx;
import com.google.firebase.auth.PhoneAuthCredential;

final class zzdb extends zzci {
    final /* synthetic */ zzcy zzir;

    private zzdb(zzcy zzcy) {
        this.zzir = zzcy;
    }

    private final void zza(zzdh zzdh) {
        this.zzir.zzie.execute(new zzdg(this, zzdh));
    }

    public final void onFailure(@NonNull Status status) throws RemoteException {
        if (this.zzir.zzhv == 8) {
            boolean unused = this.zzir.zzim = true;
            this.zzir.zzin = false;
            zza((zzdh) new zzdf(this, status));
            return;
        }
        this.zzir.zzd(status);
        this.zzir.zzc(status);
    }

    public final void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        boolean unused = this.zzir.zzim = true;
        this.zzir.zzin = true;
        zza((zzdh) new zzdd(this, phoneAuthCredential));
    }

    public final void zza(@NonNull Status status, @NonNull PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        if (this.zzir.zzif != null) {
            boolean unused = this.zzir.zzim = true;
            this.zzir.zzif.zza(status, phoneAuthCredential);
            return;
        }
        onFailure(status);
    }

    public final void zza(@NonNull zzao zzao, @NonNull zzaj zzaj) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 2, new StringBuilder(37).append("Unexpected response type: ").append(this.zzir.zzhv).toString());
        this.zzir.zzig = zzao;
        this.zzir.zzih = zzaj;
        this.zzir.zzak();
    }

    public final void zza(@Nullable zzav zzav) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 4, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzij = zzav;
        this.zzir.zzak();
    }

    public final void zza(@NonNull zzx zzx) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 3, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzii = zzx;
        this.zzir.zzak();
    }

    public final void zzaa() throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 5, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzak();
    }

    public final void zzab() throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 6, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzak();
    }

    public final void zzac() throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 9, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzak();
    }

    public final void zzb(@NonNull zzao zzao) throws RemoteException {
        boolean z = true;
        if (this.zzir.zzhv != 1) {
            z = false;
        }
        Preconditions.checkState(z, new StringBuilder(37).append("Unexpected response type: ").append(this.zzir.zzhv).toString());
        this.zzir.zzig = zzao;
        this.zzir.zzak();
    }

    public final void zzd(@NonNull String str) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 7, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzik = str;
        this.zzir.zzak();
    }

    public final void zze(@NonNull String str) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzeu = str;
        zza((zzdh) new zzdc(this, str));
    }

    public final void zzf(@NonNull String str) throws RemoteException {
        Preconditions.checkState(this.zzir.zzhv == 8, new StringBuilder(36).append("Unexpected response type ").append(this.zzir.zzhv).toString());
        this.zzir.zzeu = str;
        boolean unused = this.zzir.zzim = true;
        this.zzir.zzin = true;
        zza((zzdh) new zzde(this, str));
    }
}
