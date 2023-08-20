package com.google.android.gms.internal.firebase_database;

import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzdu {
    public static zzbv zza(zzbv zzbv, Map<String, Object> map) {
        zzbv zzbf = zzbv.zzbf();
        Iterator<Map.Entry<zzch, zzja>> it = zzbv.iterator();
        while (true) {
            zzbv zzbv2 = zzbf;
            if (!it.hasNext()) {
                return zzbv2;
            }
            Map.Entry next = it.next();
            zzbf = zzbv2.zze((zzch) next.getKey(), zza((zzja) next.getValue(), map));
        }
    }

    public static zzja zza(zzja zzja, Map<String, Object> map) {
        Object value = zzja.zzfl().getValue();
        if (value instanceof Map) {
            Map map2 = (Map) value;
            if (map2.containsKey(".sv")) {
                value = map.get((String) map2.get(".sv"));
            }
        }
        zzja zzc = zzjg.zzc((zzch) null, value);
        if (zzja.zzfk()) {
            Object value2 = zzja.getValue();
            if (value2 instanceof Map) {
                Map map3 = (Map) value2;
                if (map3.containsKey(".sv")) {
                    String str = (String) map3.get(".sv");
                    if (map.containsKey(str)) {
                        value2 = map.get(str);
                    }
                }
            }
            return (!value2.equals(zzja.getValue()) || !zzc.equals(zzja.zzfl())) ? zzjd.zza(value2, zzc) : zzja;
        } else if (zzja.isEmpty()) {
            return zzja;
        } else {
            zzif zzif = (zzif) zzja;
            zzdx zzdx = new zzdx(zzif);
            zzif.zza((zzii) new zzdw(map, zzdx), false);
            return !zzdx.zzcg().zzfl().equals(zzc) ? zzdx.zzcg().zzf(zzc) : zzdx.zzcg();
        }
    }

    public static Map<String, Object> zza(zzkf zzkf) {
        HashMap hashMap = new HashMap();
        hashMap.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzkf.millis()));
        return hashMap;
    }
}
