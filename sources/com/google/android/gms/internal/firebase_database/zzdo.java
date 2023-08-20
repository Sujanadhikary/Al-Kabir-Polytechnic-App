package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import java.util.HashMap;
import java.util.Map;

public final class zzdo {
    private static final zzdo zzkb = new zzdo();
    /* access modifiers changed from: private */
    public final Map<zzbz, Map<String, zzck>> zzkc = new HashMap();

    public static zzck zza(zzbz zzbz, zzdn zzdn, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        return zzkb.zzb(zzbz, zzdn, firebaseDatabase);
    }

    private final zzck zzb(zzbz zzbz, zzdn zzdn, FirebaseDatabase firebaseDatabase) throws DatabaseException {
        zzck zzck;
        zzbz.zzba();
        String str = zzdn.zzct;
        String str2 = zzdn.zzcu;
        String sb = new StringBuilder(String.valueOf(str).length() + 9 + String.valueOf(str2).length()).append("https://").append(str).append("/").append(str2).toString();
        synchronized (this.zzkc) {
            if (!this.zzkc.containsKey(zzbz)) {
                this.zzkc.put(zzbz, new HashMap());
            }
            Map map = this.zzkc.get(zzbz);
            if (!map.containsKey(sb)) {
                zzck = new zzck(zzdn, zzbz, firebaseDatabase);
                map.put(sb, zzck);
            } else {
                throw new IllegalStateException("createLocalRepo() called for existing repo.");
            }
        }
        return zzck;
    }

    public static void zzd(zzbz zzbz) {
        zzdo zzdo = zzkb;
        zzdt zzdt = zzbz.zzhh;
        if (zzdt != null) {
            zzdt.zzc(new zzdr(zzdo, zzbz));
        }
    }

    public static void zze(zzbz zzbz) {
        zzdo zzdo = zzkb;
        zzdt zzdt = zzbz.zzhh;
        if (zzdt != null) {
            zzdt.zzc(new zzds(zzdo, zzbz));
        }
    }

    public static void zzk(zzck zzck) {
        zzck.zzc((Runnable) new zzdp(zzck));
    }

    public static void zzl(zzck zzck) {
        zzck.zzc((Runnable) new zzdq(zzck));
    }
}
