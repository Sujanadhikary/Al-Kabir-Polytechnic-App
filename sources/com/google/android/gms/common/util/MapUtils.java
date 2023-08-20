package com.google.android.gms.common.util;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {
    public static <K, V> K getKeyFromMap(Map<K, V> map, K k) {
        if (map.containsKey(k)) {
            for (K next : map.keySet()) {
                if (next.equals(k)) {
                    return next;
                }
            }
        }
        return null;
    }

    public static void writeStringMapToJson(StringBuilder sb, HashMap<String, String> hashMap) {
        boolean z;
        sb.append("{");
        boolean z2 = true;
        for (String next : hashMap.keySet()) {
            if (!z2) {
                sb.append(",");
                z = z2;
            } else {
                z = false;
            }
            String str = hashMap.get(next);
            sb.append("\"").append(next).append("\":");
            if (str == null) {
                sb.append("null");
                z2 = z;
            } else {
                sb.append("\"").append(str).append("\"");
                z2 = z;
            }
        }
        sb.append("}");
    }
}
