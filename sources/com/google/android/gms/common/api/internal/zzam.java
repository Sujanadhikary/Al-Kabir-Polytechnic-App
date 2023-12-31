package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

final class zzam extends zzat {
    final /* synthetic */ zzaj zzhv;
    private final Map<Api.Client, zzal> zzhx;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzam(zzaj zzaj, Map<Api.Client, zzal> map) {
        super(zzaj, (zzak) null);
        this.zzhv = zzaj;
        this.zzhx = map;
    }

    @WorkerThread
    public final void zzaq() {
        int i = 0;
        GoogleApiAvailabilityCache googleApiAvailabilityCache = new GoogleApiAvailabilityCache(this.zzhv.zzgk);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client next : this.zzhx.keySet()) {
            if (!next.requiresGooglePlayServices() || this.zzhx.get(next).zzfo) {
                arrayList2.add(next);
            } else {
                arrayList.add(next);
            }
        }
        int i2 = -1;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = arrayList;
            int size = arrayList3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList3.get(i3);
                i3++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, (Api.Client) obj);
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            ArrayList arrayList4 = arrayList2;
            int size2 = arrayList4.size();
            while (i < size2) {
                Object obj2 = arrayList4.get(i);
                i++;
                i2 = googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, (Api.Client) obj2);
                if (i2 == 0) {
                    break;
                }
            }
        }
        int i4 = i2;
        if (i4 != 0) {
            this.zzhv.zzhf.zza((zzbe) new zzan(this, this.zzhv, new ConnectionResult(i4, (PendingIntent) null)));
            return;
        }
        if (this.zzhv.zzhp) {
            this.zzhv.zzhn.connect();
        }
        for (Api.Client next2 : this.zzhx.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = this.zzhx.get(next2);
            if (!next2.requiresGooglePlayServices() || googleApiAvailabilityCache.getClientAvailability(this.zzhv.mContext, next2) == 0) {
                next2.connect(connectionProgressReportCallbacks);
            } else {
                this.zzhv.zzhf.zza((zzbe) new zzao(this, this.zzhv, connectionProgressReportCallbacks));
            }
        }
    }
}
