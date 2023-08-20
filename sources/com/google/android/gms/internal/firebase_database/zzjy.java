package com.google.android.gms.internal.firebase_database;

import android.util.Base64;
import java.net.URI;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

final class zzjy {
    private String protocol = null;
    private URI zztd = null;
    private String zztt = null;
    private Map<String, String> zztu = null;

    public zzjy(URI uri, String str, Map<String, String> map) {
        this.zztd = uri;
        this.protocol = null;
        this.zztu = map;
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) ((int) ((Math.random() * 255.0d) + 0.0d));
        }
        this.zztt = Base64.encodeToString(bArr, 2);
    }

    public final byte[] zzgo() {
        String concat;
        String str;
        String path = this.zztd.getPath();
        String query = this.zztd.getQuery();
        String valueOf = String.valueOf(path);
        if (query == null) {
            concat = "";
        } else {
            String valueOf2 = String.valueOf(query);
            concat = valueOf2.length() != 0 ? "?".concat(valueOf2) : new String("?");
        }
        String valueOf3 = String.valueOf(concat);
        String concat2 = valueOf3.length() != 0 ? valueOf.concat(valueOf3) : new String(valueOf);
        String host = this.zztd.getHost();
        if (this.zztd.getPort() != -1) {
            String valueOf4 = String.valueOf(host);
            host = new StringBuilder(String.valueOf(valueOf4).length() + 12).append(valueOf4).append(":").append(this.zztd.getPort()).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Host", host);
        linkedHashMap.put("Upgrade", "websocket");
        linkedHashMap.put("Connection", "Upgrade");
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.zztt);
        if (this.protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.protocol);
        }
        if (this.zztu != null) {
            for (String next : this.zztu.keySet()) {
                if (!linkedHashMap.containsKey(next)) {
                    linkedHashMap.put(next, this.zztu.get(next));
                }
            }
        }
        String valueOf5 = String.valueOf(new StringBuilder(String.valueOf(concat2).length() + 15).append("GET ").append(concat2).append(" HTTP/1.1\r\n").toString());
        String str2 = new String();
        Iterator it = linkedHashMap.keySet().iterator();
        while (true) {
            str = str2;
            if (!it.hasNext()) {
                break;
            }
            String str3 = (String) it.next();
            String valueOf6 = String.valueOf(str);
            String str4 = (String) linkedHashMap.get(str3);
            str2 = new StringBuilder(String.valueOf(valueOf6).length() + 4 + String.valueOf(str3).length() + String.valueOf(str4).length()).append(valueOf6).append(str3).append(": ").append(str4).append("\r\n").toString();
        }
        String valueOf7 = String.valueOf(str);
        String concat3 = String.valueOf(valueOf7.length() != 0 ? valueOf5.concat(valueOf7) : new String(valueOf5)).concat("\r\n");
        byte[] bArr = new byte[concat3.getBytes().length];
        System.arraycopy(concat3.getBytes(), 0, bArr, 0, concat3.getBytes().length);
        return bArr;
    }
}
