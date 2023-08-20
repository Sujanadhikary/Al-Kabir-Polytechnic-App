package com.google.android.gms.internal.firebase_database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzhq {
    private final Map<zzid, zzgw> zzqh = new HashMap();

    public final void zza(zzgw zzgw) {
        zzgz zzdt = zzgw.zzdt();
        zzid zzds = zzgw.zzds();
        if (this.zzqh.containsKey(zzds)) {
            zzgw zzgw2 = this.zzqh.get(zzds);
            zzgz zzdt2 = zzgw2.zzdt();
            if (zzdt == zzgz.CHILD_ADDED && zzdt2 == zzgz.CHILD_REMOVED) {
                this.zzqh.put(zzgw.zzds(), zzgw.zza(zzds, zzgw.zzdq(), zzgw2.zzdq()));
            } else if (zzdt == zzgz.CHILD_REMOVED && zzdt2 == zzgz.CHILD_ADDED) {
                this.zzqh.remove(zzds);
            } else if (zzdt == zzgz.CHILD_REMOVED && zzdt2 == zzgz.CHILD_CHANGED) {
                this.zzqh.put(zzds, zzgw.zzb(zzds, zzgw2.zzdv()));
            } else if (zzdt == zzgz.CHILD_CHANGED && zzdt2 == zzgz.CHILD_ADDED) {
                this.zzqh.put(zzds, zzgw.zza(zzds, zzgw.zzdq()));
            } else if (zzdt == zzgz.CHILD_CHANGED && zzdt2 == zzgz.CHILD_CHANGED) {
                this.zzqh.put(zzds, zzgw.zza(zzds, zzgw.zzdq(), zzgw2.zzdv()));
            } else {
                String valueOf = String.valueOf(zzgw);
                String valueOf2 = String.valueOf(zzgw2);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 48 + String.valueOf(valueOf2).length()).append("Illegal combination of changes: ").append(valueOf).append(" occurred after ").append(valueOf2).toString());
            }
        } else {
            this.zzqh.put(zzgw.zzds(), zzgw);
        }
    }

    public final List<zzgw> zzev() {
        return new ArrayList(this.zzqh.values());
    }
}
