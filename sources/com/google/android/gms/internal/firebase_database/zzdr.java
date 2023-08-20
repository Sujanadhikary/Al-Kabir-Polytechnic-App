package com.google.android.gms.internal.firebase_database;

import java.util.Map;

final class zzdr implements Runnable {
    private final /* synthetic */ zzbz zzkd;
    private final /* synthetic */ zzdo zzke;

    zzdr(zzdo zzdo, zzbz zzbz) {
        this.zzke = zzdo;
        this.zzkd = zzbz;
    }

    public final void run() {
        synchronized (this.zzke.zzkc) {
            if (this.zzke.zzkc.containsKey(this.zzkd)) {
                boolean z = true;
                for (zzck zzck : ((Map) this.zzke.zzkc.get(this.zzkd)).values()) {
                    zzck.interrupt();
                    z = z && !zzck.zzcd();
                }
                if (z) {
                    this.zzkd.stop();
                }
            }
        }
    }
}
