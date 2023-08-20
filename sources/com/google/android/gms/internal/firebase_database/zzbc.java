package com.google.android.gms.internal.firebase_database;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class zzbc {
    private static long zzev = 0;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzbc;
    /* access modifiers changed from: private */
    public final zzhz zzbs;
    /* access modifiers changed from: private */
    public zzbg zzew;
    /* access modifiers changed from: private */
    public boolean zzex = false;
    private boolean zzey = false;
    private long zzez = 0;
    private zzbp zzfa;
    private zzbf zzfb;
    private ScheduledFuture<?> zzfc;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> zzfd;
    private final zzaf zzfe;

    public zzbc(zzaf zzaf, zzah zzah, String str, zzbf zzbf, String str2) {
        this.zzfe = zzaf;
        this.zzbc = zzaf.zzs();
        this.zzfb = zzbf;
        long j = zzev;
        zzev = 1 + j;
        this.zzbs = new zzhz(zzaf.zzq(), "WebSocket", new StringBuilder(23).append("ws_").append(j).toString());
        str = str == null ? zzah.getHost() : str;
        boolean isSecure = zzah.isSecure();
        String namespace = zzah.getNamespace();
        String str3 = isSecure ? "wss" : "ws";
        String sb = new StringBuilder(String.valueOf(str3).length() + 15 + String.valueOf(str).length() + String.valueOf(namespace).length()).append(str3).append("://").append(str).append("/.ws?ns=").append(namespace).append("&v=5").toString();
        if (str2 != null) {
            String valueOf = String.valueOf(sb);
            sb = new StringBuilder(String.valueOf(valueOf).length() + 4 + String.valueOf(str2).length()).append(valueOf).append("&ls=").append(str2).toString();
        }
        URI create = URI.create(sb);
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", this.zzfe.zzv());
        this.zzew = new zzbh(this, new zzjr(this.zzfe, create, (String) null, hashMap), (zzbd) null);
    }

    private final void shutdown() {
        this.zzey = true;
        this.zzfb.zza(this.zzex);
    }

    /* access modifiers changed from: private */
    public final void zzas() {
        if (!this.zzey) {
            if (this.zzfc != null) {
                this.zzfc.cancel(false);
                if (this.zzbs.zzfa()) {
                    this.zzbs.zza(new StringBuilder(48).append("Reset keepAlive. Remaining: ").append(this.zzfc.getDelay(TimeUnit.MILLISECONDS)).toString(), (Throwable) null, new Object[0]);
                }
            } else if (this.zzbs.zzfa()) {
                this.zzbs.zza("Reset keepAlive", (Throwable) null, new Object[0]);
            }
            this.zzfc = this.zzbc.schedule(new zzbe(this), 45000, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: private */
    public final void zzat() {
        if (!this.zzey) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("closing itself", (Throwable) null, new Object[0]);
            }
            shutdown();
        }
        this.zzew = null;
        if (this.zzfc != null) {
            this.zzfc.cancel(false);
        }
    }

    /* access modifiers changed from: private */
    public final void zzau() {
        if (!this.zzex && !this.zzey) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("timed out on connect", (Throwable) null, new Object[0]);
            }
            this.zzew.close();
        }
    }

    private final void zzb(int i) {
        this.zzez = (long) i;
        this.zzfa = new zzbp();
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(new StringBuilder(41).append("HandleNewFrameCount: ").append(this.zzez).toString(), (Throwable) null, new Object[0]);
        }
    }

    private final void zzj(String str) {
        this.zzfa.zzn(str);
        this.zzez--;
        if (this.zzez == 0) {
            try {
                this.zzfa.zzba();
                Map<String, Object> zzv = zzke.zzv(this.zzfa.toString());
                this.zzfa = null;
                if (this.zzbs.zzfa()) {
                    zzhz zzhz = this.zzbs;
                    String valueOf = String.valueOf(zzv);
                    zzhz.zza(new StringBuilder(String.valueOf(valueOf).length() + 36).append("handleIncomingFrame complete frame: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
                }
                this.zzfb.zza(zzv);
            } catch (IOException e) {
                IOException iOException = e;
                zzhz zzhz2 = this.zzbs;
                String valueOf2 = String.valueOf(this.zzfa.toString());
                zzhz2.zza(valueOf2.length() != 0 ? "Error parsing frame: ".concat(valueOf2) : new String("Error parsing frame: "), (Throwable) iOException);
                close();
                shutdown();
            } catch (ClassCastException e2) {
                ClassCastException classCastException = e2;
                zzhz zzhz3 = this.zzbs;
                String valueOf3 = String.valueOf(this.zzfa.toString());
                zzhz3.zza(valueOf3.length() != 0 ? "Error parsing frame (cast error): ".concat(valueOf3) : new String("Error parsing frame (cast error): "), (Throwable) classCastException);
                close();
                shutdown();
            }
        }
    }

    private final String zzk(String str) {
        if (str.length() <= 6) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt > 0) {
                    zzb(parseInt);
                }
                return null;
            } catch (NumberFormatException e) {
            }
        }
        zzb(1);
        return str;
    }

    /* access modifiers changed from: private */
    public final void zzl(String str) {
        if (!this.zzey) {
            zzas();
            if (this.zzfa != null) {
                zzj(str);
                return;
            }
            String zzk = zzk(str);
            if (zzk != null) {
                zzj(zzk);
            }
        }
    }

    public final void close() {
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("websocket is being closed", (Throwable) null, new Object[0]);
        }
        this.zzey = true;
        this.zzew.close();
        if (this.zzfd != null) {
            this.zzfd.cancel(true);
        }
        if (this.zzfc != null) {
            this.zzfc.cancel(true);
        }
    }

    public final void open() {
        this.zzew.connect();
        this.zzfd = this.zzbc.schedule(new zzbd(this), 30000, TimeUnit.MILLISECONDS);
    }

    public final void zze(Map<String, Object> map) {
        String[] strArr;
        zzas();
        try {
            String zze = zzke.zze(map);
            if (zze.length() <= 16384) {
                strArr = new String[]{zze};
            } else {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < zze.length(); i += 16384) {
                    arrayList.add(zze.substring(i, Math.min(i + 16384, zze.length())));
                }
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            if (strArr.length > 1) {
                this.zzew.zzm(new StringBuilder(11).append(strArr.length).toString());
            }
            for (String zzm : strArr) {
                this.zzew.zzm(zzm);
            }
        } catch (IOException e) {
            IOException iOException = e;
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(map.toString());
            zzhz.zza(valueOf.length() != 0 ? "Failed to serialize message: ".concat(valueOf) : new String("Failed to serialize message: "), (Throwable) iOException);
            shutdown();
        }
    }
}
