package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseException;

public final class zzjg {
    public static zzja zzc(zzch zzch, Object obj) {
        String str;
        zzja zza = zzjd.zza(obj, zzir.zzfv());
        if (zza instanceof zziy) {
            zza = new zziq(Double.valueOf((double) ((Long) zza.getValue()).longValue()), zzir.zzfv());
        }
        if (zzl(zza)) {
            return zza;
        }
        if (zzch != null) {
            String valueOf = String.valueOf(zzch);
            str = new StringBuilder(String.valueOf(valueOf).length() + 7).append("Path '").append(valueOf).append("'").toString();
        } else {
            str = "Node";
        }
        throw new DatabaseException(String.valueOf(str).concat(" contains invalid priority: Must be a string, double, ServerValue, or null"));
    }

    public static boolean zzl(zzja zzja) {
        return zzja.zzfl().isEmpty() && (zzja.isEmpty() || (zzja instanceof zziq) || (zzja instanceof zzji) || (zzja instanceof zzip));
    }
}
