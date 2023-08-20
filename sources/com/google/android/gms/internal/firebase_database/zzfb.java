package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzfb {
    private final List<String> zzlw = new ArrayList();
    private int zzlx = 0;

    private zzfb(zzch zzch) throws DatabaseException {
        Iterator<zzid> it = zzch.iterator();
        while (it.hasNext()) {
            this.zzlw.add(it.next().zzfg());
        }
        this.zzlx = Math.max(1, this.zzlw.size());
        for (int i = 0; i < this.zzlw.size(); i++) {
            this.zzlx = zza(this.zzlw.get(i)) + this.zzlx;
        }
        zzcs();
    }

    private static int zza(CharSequence charSequence) {
        int i = 0;
        int length = charSequence.length();
        int i2 = 0;
        while (i < length) {
            char charAt = charSequence.charAt(i);
            if (charAt <= 127) {
                i2++;
            } else if (charAt <= 2047) {
                i2 += 2;
            } else if (Character.isHighSurrogate(charAt)) {
                i2 += 4;
                i++;
            } else {
                i2 += 3;
            }
            i++;
        }
        return i2;
    }

    public static void zza(zzch zzch, Object obj) throws DatabaseException {
        new zzfb(zzch).zzc(obj);
    }

    private final void zzc(Object obj) throws DatabaseException {
        if (obj instanceof Map) {
            Map map = (Map) obj;
            for (String str : map.keySet()) {
                if (!str.startsWith(".")) {
                    zzs(str);
                    zzc(map.get(str));
                    zzcr();
                }
            }
        } else if (obj instanceof List) {
            List list = (List) obj;
            for (int i = 0; i < list.size(); i++) {
                zzs(Integer.toString(i));
                zzc(list.get(i));
                zzcr();
            }
        }
    }

    private final String zzcr() {
        String remove = this.zzlw.remove(this.zzlw.size() - 1);
        this.zzlx -= zza(remove);
        if (this.zzlw.size() > 0) {
            this.zzlx--;
        }
        return remove;
    }

    private final void zzcs() throws DatabaseException {
        String sb;
        if (this.zzlx > 768) {
            throw new DatabaseException(new StringBuilder(56).append("Data has a key path longer than 768 bytes (").append(this.zzlx).append(").").toString());
        } else if (this.zzlw.size() > 32) {
            String valueOf = String.valueOf("Path specified exceeds the maximum depth that can be written (32) or object contains a cycle ");
            if (this.zzlw.size() == 0) {
                sb = "";
            } else {
                List<String> list = this.zzlw;
                StringBuilder sb2 = new StringBuilder();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    if (i2 > 0) {
                        sb2.append("/");
                    }
                    sb2.append(list.get(i2));
                    i = i2 + 1;
                }
                String sb3 = sb2.toString();
                sb = new StringBuilder(String.valueOf(sb3).length() + 10).append("in path '").append(sb3).append("'").toString();
            }
            String valueOf2 = String.valueOf(sb);
            throw new DatabaseException(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        }
    }

    private final void zzs(String str) throws DatabaseException {
        if (this.zzlw.size() > 0) {
            this.zzlx++;
        }
        this.zzlw.add(str);
        this.zzlx += zza(str);
        zzcs();
    }
}
