package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zziv implements Runnable {
    private final /* synthetic */ zzdz zzane;
    private final /* synthetic */ boolean zzanz;
    private final /* synthetic */ zzii zzape;
    private final /* synthetic */ AtomicReference zzapf;

    zziv(zzii zzii, AtomicReference atomicReference, zzdz zzdz, boolean z) {
        this.zzape = zzii;
        this.zzapf = atomicReference;
        this.zzane = zzdz;
        this.zzanz = z;
    }

    /* JADX INFO: finally extract failed */
    public final void run() {
        synchronized (this.zzapf) {
            try {
                zzey zzd = this.zzape.zzaoy;
                if (zzd == null) {
                    this.zzape.zzge().zzim().log("Failed to get user properties");
                    this.zzapf.notify();
                    return;
                }
                this.zzapf.set(zzd.zza(this.zzane, this.zzanz));
                this.zzape.zzcu();
                this.zzapf.notify();
            } catch (RemoteException e) {
                this.zzape.zzge().zzim().zzg("Failed to get user properties", e);
                this.zzapf.notify();
            } catch (Throwable th) {
                this.zzapf.notify();
                throw th;
            }
        }
    }
}
