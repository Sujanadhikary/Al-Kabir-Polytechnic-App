package com.google.android.gms.internal.measurement;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeoutException;

final class zzho implements Callable<String> {
    private final /* synthetic */ zzhk zzanw;

    zzho(zzhk zzhk) {
        this.zzanw = zzhk;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zzja = this.zzanw.zzgf().zzja();
        if (zzja == null) {
            zzhk zzfu = this.zzanw.zzfu();
            if (zzfu.zzgd().zzjk()) {
                zzfu.zzge().zzim().log("Cannot retrieve app instance id from analytics worker thread");
                zzja = null;
            } else {
                zzfu.zzgd();
                if (zzgg.isMainThread()) {
                    zzfu.zzge().zzim().log("Cannot retrieve app instance id from main thread");
                    zzja = null;
                } else {
                    long elapsedRealtime = zzfu.zzbt().elapsedRealtime();
                    zzja = zzfu.zzae(120000);
                    long elapsedRealtime2 = zzfu.zzbt().elapsedRealtime() - elapsedRealtime;
                    if (zzja == null && elapsedRealtime2 < 120000) {
                        zzja = zzfu.zzae(120000 - elapsedRealtime2);
                    }
                }
            }
            if (zzja == null) {
                throw new TimeoutException();
            }
            this.zzanw.zzgf().zzbr(zzja);
        }
        return zzja;
    }
}
