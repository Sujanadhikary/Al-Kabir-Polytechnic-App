package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;

public final class zzfo extends zzdb<zzfo, zza> implements zzej {
    /* access modifiers changed from: private */
    public static final zzfo zzvu = new zzfo();
    private static volatile zzer<zzfo> zzvv;
    private long zzvs;
    private int zzvt;

    public static final class zza extends zzdb.zza<zzfo, zza> implements zzej {
        private zza() {
            super(zzfo.zzvu);
        }

        /* synthetic */ zza(zzfp zzfp) {
            this();
        }
    }

    static {
        zzdb.zza(zzfo.class, zzvu);
    }

    private zzfo() {
    }

    public static zzer<zzfo> zzgo() {
        return (zzer) zzvu.zza(zzdb.zze.zzre, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        zzer zzer;
        switch (zzfp.zzvw[i - 1]) {
            case 1:
                return new zzfo();
            case 2:
                return new zza((zzfp) null);
            case 3:
                return new zzet(zzvu, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0003\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzvs", "zzvt"});
            case 4:
                return zzvu;
            case 5:
                zzer<zzfo> zzer2 = zzvv;
                if (zzer2 != null) {
                    return zzer2;
                }
                synchronized (zzfo.class) {
                    zzer = zzvv;
                    if (zzer == null) {
                        zzer = new zzdb.zzb(zzvu);
                        zzvv = zzer;
                    }
                }
                return zzer;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
