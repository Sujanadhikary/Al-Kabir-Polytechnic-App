package com.google.android.gms.internal.firebase_database;

import java.util.HashMap;
import java.util.Map;

final class zzz implements zzbf {
    private static long zzcb = 0;
    private final zzhz zzbs;
    private zzah zzcc;
    private zzbc zzcd;
    private zzaa zzce;
    private int zzcf = zzac.zzcj;

    public zzz(zzaf zzaf, zzah zzah, String str, zzaa zzaa, String str2) {
        long j = zzcb;
        zzcb = 1 + j;
        this.zzcc = zzah;
        this.zzce = zzaa;
        this.zzbs = new zzhz(zzaf.zzq(), "Connection", new StringBuilder(25).append("conn_").append(j).toString());
        this.zzcd = new zzbc(zzaf, zzah, str, this, str2);
    }

    private final void zza(zzab zzab) {
        if (this.zzcf != zzac.zzcl) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("closing realtime connection", (Throwable) null, new Object[0]);
            }
            this.zzcf = zzac.zzcl;
            if (this.zzcd != null) {
                this.zzcd.close();
                this.zzcd = null;
            }
            this.zzce.zzb(zzab);
        }
    }

    public final void close() {
        zza(zzab.OTHER);
    }

    public final void open() {
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("Opening a connection", (Throwable) null, new Object[0]);
        }
        this.zzcd.open();
    }

    public final void zza(Map<String, Object> map) {
        try {
            String str = (String) map.get("t");
            if (str == null) {
                if (this.zzbs.zzfa()) {
                    zzhz zzhz = this.zzbs;
                    String valueOf = String.valueOf(map.toString());
                    zzhz.zza(valueOf.length() != 0 ? "Failed to parse server message: missing message type:".concat(valueOf) : new String("Failed to parse server message: missing message type:"), (Throwable) null, new Object[0]);
                }
                zza(zzab.OTHER);
            } else if (str.equals("d")) {
                Map map2 = (Map) map.get("d");
                if (this.zzbs.zzfa()) {
                    zzhz zzhz2 = this.zzbs;
                    String valueOf2 = String.valueOf(map2.toString());
                    zzhz2.zza(valueOf2.length() != 0 ? "received data message: ".concat(valueOf2) : new String("received data message: "), (Throwable) null, new Object[0]);
                }
                this.zzce.zzb((Map<String, Object>) map2);
            } else if (str.equals("c")) {
                Map map3 = (Map) map.get("d");
                if (this.zzbs.zzfa()) {
                    zzhz zzhz3 = this.zzbs;
                    String valueOf3 = String.valueOf(map3.toString());
                    zzhz3.zza(valueOf3.length() != 0 ? "Got control message: ".concat(valueOf3) : new String("Got control message: "), (Throwable) null, new Object[0]);
                }
                try {
                    String str2 = (String) map3.get("t");
                    if (str2 == null) {
                        if (this.zzbs.zzfa()) {
                            zzhz zzhz4 = this.zzbs;
                            String valueOf4 = String.valueOf(map3.toString());
                            zzhz4.zza(valueOf4.length() != 0 ? "Got invalid control message: ".concat(valueOf4) : new String("Got invalid control message: "), (Throwable) null, new Object[0]);
                        }
                        zza(zzab.OTHER);
                    } else if (str2.equals("s")) {
                        String str3 = (String) map3.get("d");
                        if (this.zzbs.zzfa()) {
                            this.zzbs.zza("Connection shutdown command received. Shutting down...", (Throwable) null, new Object[0]);
                        }
                        this.zzce.zze(str3);
                        zza(zzab.OTHER);
                    } else if (str2.equals("r")) {
                        String str4 = (String) map3.get("d");
                        if (this.zzbs.zzfa()) {
                            zzhz zzhz5 = this.zzbs;
                            String host = this.zzcc.getHost();
                            zzhz5.zza(new StringBuilder(String.valueOf(host).length() + 62 + String.valueOf(str4).length()).append("Got a reset; killing connection to ").append(host).append("; Updating internalHost to ").append(str4).toString(), (Throwable) null, new Object[0]);
                        }
                        this.zzce.zzd(str4);
                        zza(zzab.SERVER_RESET);
                    } else if (str2.equals("h")) {
                        Map map4 = (Map) map3.get("d");
                        long longValue = ((Long) map4.get("ts")).longValue();
                        this.zzce.zzd((String) map4.get("h"));
                        String str5 = (String) map4.get("s");
                        if (this.zzcf == zzac.zzcj) {
                            if (this.zzbs.zzfa()) {
                                this.zzbs.zza("realtime connection established", (Throwable) null, new Object[0]);
                            }
                            this.zzcf = zzac.zzck;
                            this.zzce.zza(longValue, str5);
                        }
                    } else if (this.zzbs.zzfa()) {
                        zzhz zzhz6 = this.zzbs;
                        String valueOf5 = String.valueOf(str2);
                        zzhz6.zza(valueOf5.length() != 0 ? "Ignoring unknown control message: ".concat(valueOf5) : new String("Ignoring unknown control message: "), (Throwable) null, new Object[0]);
                    }
                } catch (ClassCastException e) {
                    if (this.zzbs.zzfa()) {
                        zzhz zzhz7 = this.zzbs;
                        String valueOf6 = String.valueOf(e.toString());
                        zzhz7.zza(valueOf6.length() != 0 ? "Failed to parse control message: ".concat(valueOf6) : new String("Failed to parse control message: "), (Throwable) null, new Object[0]);
                    }
                    zza(zzab.OTHER);
                }
            } else if (this.zzbs.zzfa()) {
                zzhz zzhz8 = this.zzbs;
                String valueOf7 = String.valueOf(str);
                zzhz8.zza(valueOf7.length() != 0 ? "Ignoring unknown server message type: ".concat(valueOf7) : new String("Ignoring unknown server message type: "), (Throwable) null, new Object[0]);
            }
        } catch (ClassCastException e2) {
            if (this.zzbs.zzfa()) {
                zzhz zzhz9 = this.zzbs;
                String valueOf8 = String.valueOf(e2.toString());
                zzhz9.zza(valueOf8.length() != 0 ? "Failed to parse server message: ".concat(valueOf8) : new String("Failed to parse server message: "), (Throwable) null, new Object[0]);
            }
            zza(zzab.OTHER);
        }
    }

    public final void zza(Map<String, Object> map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("t", "d");
        hashMap.put("d", map);
        if (this.zzcf != zzac.zzck) {
            this.zzbs.zza("Tried to send on an unconnected connection", (Throwable) null, new Object[0]);
            return;
        }
        if (z) {
            this.zzbs.zza("Sending data (contents hidden)", (Throwable) null, new Object[0]);
        } else {
            this.zzbs.zza("Sending data: %s", (Throwable) null, hashMap);
        }
        this.zzcd.zze((Map<String, Object>) hashMap);
    }

    public final void zza(boolean z) {
        this.zzcd = null;
        if (z || this.zzcf != zzac.zzcj) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("Realtime connection lost", (Throwable) null, new Object[0]);
            }
        } else if (this.zzbs.zzfa()) {
            this.zzbs.zza("Realtime connection failed", (Throwable) null, new Object[0]);
        }
        zza(zzab.OTHER);
    }
}
