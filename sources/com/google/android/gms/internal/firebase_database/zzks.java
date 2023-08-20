package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public final class zzks {
    private static final Pattern zzut = Pattern.compile("[\\[\\]\\.#$]");
    private static final Pattern zzuu = Pattern.compile("[\\[\\]\\.#\\$\\/\\u0000-\\u001F\\u007F]");

    public static void zzab(String str) throws DatabaseException {
        if (!(!zzut.matcher(str).find())) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 101).append("Invalid Firebase Database path: ").append(str).append(". Firebase Database paths must not contain '.', '#', '$', '[', or ']'").toString());
        }
    }

    public static void zzac(String str) throws DatabaseException {
        if (str.startsWith(".info")) {
            zzab(str.substring(5));
        } else if (str.startsWith("/.info")) {
            zzab(str.substring(6));
        } else {
            zzab(str);
        }
    }

    public static void zzad(String str) throws DatabaseException {
        if (str != null) {
            if (!(str.equals(".info") || !zzuu.matcher(str).find())) {
                throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
            }
        }
    }

    public static void zzan(zzch zzch) throws DatabaseException {
        zzid zzbw = zzch.zzbw();
        if (!(zzbw == null || !zzbw.zzfg().startsWith("."))) {
            String valueOf = String.valueOf(zzch.toString());
            throw new DatabaseException(valueOf.length() != 0 ? "Invalid write location: ".concat(valueOf) : new String("Invalid write location: "));
        }
    }

    public static Map<zzch, zzja> zzb(zzch zzch, Map<String, Object> map) throws DatabaseException {
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            zzch zzch2 = new zzch((String) next.getKey());
            Object value = next.getValue();
            zzfb.zza(zzch.zzh(zzch2), value);
            String zzfg = !zzch2.isEmpty() ? zzch2.zzbz().zzfg() : "";
            if (zzfg.equals(".sv") || zzfg.equals(".value")) {
                String valueOf = String.valueOf(zzch2);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf).length() + 40 + String.valueOf(zzfg).length()).append("Path '").append(valueOf).append("' contains disallowed child name: ").append(zzfg).toString());
            }
            zzja zzc = zzfg.equals(".priority") ? zzjg.zzc(zzch2, value) : zzjd.zza(value, zzir.zzfv());
            zzg(value);
            treeMap.put(zzch2, zzc);
        }
        zzch zzch3 = null;
        Iterator it = treeMap.keySet().iterator();
        while (true) {
            zzch zzch4 = zzch3;
            if (!it.hasNext()) {
                return treeMap;
            }
            zzch3 = (zzch) it.next();
            zzkq.zzf(zzch4 == null || zzch4.compareTo(zzch3) < 0);
            if (zzch4 != null && zzch4.zzi(zzch3)) {
                String valueOf2 = String.valueOf(zzch4);
                String valueOf3 = String.valueOf(zzch3);
                throw new DatabaseException(new StringBuilder(String.valueOf(valueOf2).length() + 42 + String.valueOf(valueOf3).length()).append("Path '").append(valueOf2).append("' is an ancestor of '").append(valueOf3).append("' in an update.").toString());
            }
        }
    }

    public static void zzg(Object obj) {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (!map.containsKey(".sv")) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!(str != null && str.length() > 0 && (str.equals(".value") || str.equals(".priority") || (!str.startsWith(".") && !zzuu.matcher(str).find())))) {
                        throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 68).append("Invalid key: ").append(str).append(". Keys must not contain '/', '.', '#', '$', '[', or ']'").toString());
                    }
                    zzg(entry.getValue());
                }
            }
        } else if (obj instanceof List) {
            for (Object zzg : (List) obj) {
                zzg(zzg);
            }
        } else if ((obj instanceof Double) || (obj instanceof Float)) {
            double doubleValue = ((Double) obj).doubleValue();
            if (Double.isInfinite(doubleValue) || Double.isNaN(doubleValue)) {
                throw new DatabaseException("Invalid value: Value cannot be NaN, Inf or -Inf.");
            }
        }
    }
}
