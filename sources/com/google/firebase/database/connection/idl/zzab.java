package com.google.firebase.database.connection.idl;

import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.firebase_database.zzak;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzab extends zzx {
    private final /* synthetic */ zzak zzfv;

    zzab(zzak zzak) {
        this.zzfv = zzak;
    }

    public final void onDisconnect() {
        this.zzfv.onDisconnect();
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zzfv.zzc((Map) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(List<String> list, IObjectWrapper iObjectWrapper, boolean z, long j) {
        this.zzfv.zza(list, ObjectWrapper.unwrap(iObjectWrapper), z, IPersistentConnectionImpl.zzf(j));
    }

    public final void zza(List<String> list, List<zzak> list2, IObjectWrapper iObjectWrapper, long j) {
        List list3 = (List) ObjectWrapper.unwrap(iObjectWrapper);
        ArrayList arrayList = new ArrayList(list2.size());
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list2.size()) {
                arrayList.add(zzak.zza(list2.get(i2), list3.get(i2)));
                i = i2 + 1;
            } else {
                this.zzfv.zza(list, arrayList, IPersistentConnectionImpl.zzf(j));
                return;
            }
        }
    }

    public final void zzaa() {
        this.zzfv.zzaa();
    }

    public final void zzb(boolean z) {
        this.zzfv.zzb(z);
    }
}
