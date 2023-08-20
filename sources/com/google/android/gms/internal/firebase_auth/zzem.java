package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzem<T> implements zzex<T> {
    private final zzeh zzti;
    private final boolean zztj;
    private final zzfr<?, ?> zzts;
    private final zzcp<?> zztt;

    private zzem(zzfr<?, ?> zzfr, zzcp<?> zzcp, zzeh zzeh) {
        this.zzts = zzfr;
        this.zztj = zzcp.zze(zzeh);
        this.zztt = zzcp;
        this.zzti = zzeh;
    }

    static <T> zzem<T> zza(zzfr<?, ?> zzfr, zzcp<?> zzcp, zzeh zzeh) {
        return new zzem<>(zzfr, zzcp, zzeh);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzts.zzr(t).equals(this.zzts.zzr(t2))) {
            return false;
        }
        if (this.zztj) {
            return this.zztt.zzc(t).equals(this.zztt.zzc(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzts.zzr(t).hashCode();
        return this.zztj ? (hashCode * 53) + this.zztt.zzc(t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzti.zzdx().zzdz();
    }

    public final void zza(T t, zzew zzew, zzco zzco) throws IOException {
        boolean z;
        zzfr<?, ?> zzfr = this.zzts;
        zzcp<?> zzcp = this.zztt;
        Object zzs = zzfr.zzs(t);
        zzcs<?> zzd = zzcp.zzd(t);
        do {
            try {
                if (zzew.zzcx() == Integer.MAX_VALUE) {
                    zzfr.zzf(t, zzs);
                    return;
                }
                int tag = zzew.getTag();
                if (tag == 11) {
                    zzbu zzbu = null;
                    int i = 0;
                    Object obj = null;
                    while (zzew.zzcx() != Integer.MAX_VALUE) {
                        int tag2 = zzew.getTag();
                        if (tag2 == 16) {
                            i = zzew.zzci();
                            obj = zzcp.zza(zzco, this.zzti, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzcp.zza(zzew, obj, zzco, zzd);
                            } else {
                                zzbu = zzew.zzch();
                            }
                        } else if (!zzew.zzcy()) {
                            break;
                        }
                    }
                    if (zzew.getTag() != 12) {
                        throw zzdh.zzee();
                    } else if (zzbu != null) {
                        if (obj != null) {
                            zzcp.zza(zzbu, obj, zzco, zzd);
                        } else {
                            zzfr.zza(zzs, i, zzbu);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzcp.zza(zzco, this.zzti, tag >>> 3);
                    if (zza != null) {
                        zzcp.zza(zzew, zza, zzco, zzd);
                    } else {
                        z = zzfr.zza(zzs, zzew);
                        continue;
                    }
                } else {
                    z = zzew.zzcy();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzfr.zzf(t, zzs);
            }
        } while (z);
    }

    public final void zza(T t, zzgl zzgl) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zztt.zzc(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzcu zzcu = (zzcu) next.getKey();
            if (zzcu.zzdr() != zzgk.MESSAGE || zzcu.zzds() || zzcu.zzdt()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzdm) {
                zzgl.zza(zzcu.zzdp(), (Object) ((zzdm) next).zzek().zzbl());
            } else {
                zzgl.zza(zzcu.zzdp(), next.getValue());
            }
        }
        zzfr<?, ?> zzfr = this.zzts;
        zzfr.zzc(zzfr.zzr(t), zzgl);
    }

    public final void zzc(T t, T t2) {
        zzez.zza(this.zzts, t, t2);
        if (this.zztj) {
            zzez.zza(this.zztt, t, t2);
        }
    }

    public final void zze(T t) {
        this.zzts.zze(t);
        this.zztt.zze((Object) t);
    }

    public final int zzo(T t) {
        zzfr<?, ?> zzfr = this.zzts;
        int zzt = zzfr.zzt(zzfr.zzr(t)) + 0;
        return this.zztj ? zzt + this.zztt.zzc(t).zzdo() : zzt;
    }

    public final boolean zzp(T t) {
        return this.zztt.zzc(t).isInitialized();
    }
}
