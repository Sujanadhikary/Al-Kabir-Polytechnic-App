package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.internal.view.SupportMenu;
import com.google.android.gms.internal.firebase_auth.zzdb;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzco {
    private static volatile boolean zznn = false;
    private static final Class<?> zzno = zzdg();
    private static volatile zzco zznp;
    static final zzco zznq = new zzco(true);
    private final Map<zza, zzdb.zzd<?, ?>> zznr;

    static final class zza {
        private final int number;
        private final Object object;

        zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return this.object == zza.object && this.number == zza.number;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * SupportMenu.USER_MASK) + this.number;
        }
    }

    zzco() {
        this.zznr = new HashMap();
    }

    private zzco(boolean z) {
        this.zznr = Collections.emptyMap();
    }

    static zzco zzdf() {
        return zzcz.zza(zzco.class);
    }

    private static Class<?> zzdg() {
        try {
            return Class.forName("com.google.protobuf.Extension");
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public static zzco zzdh() {
        return zzcn.zzde();
    }

    public static zzco zzdi() {
        zzco zzco = zznp;
        if (zzco == null) {
            synchronized (zzco.class) {
                zzco = zznp;
                if (zzco == null) {
                    zzco = zzcn.zzdf();
                    zznp = zzco;
                }
            }
        }
        return zzco;
    }

    public final <ContainingType extends zzeh> zzdb.zzd<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return this.zznr.get(new zza(containingtype, i));
    }
}
