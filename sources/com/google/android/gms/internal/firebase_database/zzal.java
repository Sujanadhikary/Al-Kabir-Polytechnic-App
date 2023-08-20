package com.google.android.gms.internal.firebase_database;

import android.support.p000v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class zzal implements zzaa, zzaj {
    private static long zzcb = 0;
    private final ScheduledExecutorService zzbc;
    /* access modifiers changed from: private */
    public final zzhz zzbs;
    private final zzah zzcc;
    /* access modifiers changed from: private */
    public final zzad zzcn;
    /* access modifiers changed from: private */
    public final zzak zzcw;
    private String zzcx;
    private HashSet<String> zzcy = new HashSet<>();
    private boolean zzcz = true;
    private long zzda;
    /* access modifiers changed from: private */
    public zzz zzdb;
    /* access modifiers changed from: private */
    public zzav zzdc = zzav.Disconnected;
    private long zzdd = 0;
    private long zzde = 0;
    private Map<Long, zzau> zzdf;
    private List<zzax> zzdg;
    /* access modifiers changed from: private */
    public Map<Long, zzaz> zzdh;
    /* access modifiers changed from: private */
    public Map<zzaw, zzay> zzdi;
    /* access modifiers changed from: private */
    public String zzdj;
    /* access modifiers changed from: private */
    public boolean zzdk;
    private final zzaf zzdl;
    /* access modifiers changed from: private */
    public final zzbm zzdm;
    private String zzdn;
    /* access modifiers changed from: private */
    public long zzdo = 0;
    /* access modifiers changed from: private */
    public int zzdp = 0;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> zzdq = null;
    private long zzdr;
    private boolean zzds;

    public zzal(zzaf zzaf, zzah zzah, zzak zzak) {
        this.zzcw = zzak;
        this.zzdl = zzaf;
        this.zzbc = zzaf.zzs();
        this.zzcn = zzaf.zzr();
        this.zzcc = zzah;
        this.zzdi = new HashMap();
        this.zzdf = new HashMap();
        this.zzdh = new HashMap();
        this.zzdg = new ArrayList();
        this.zzdm = new zzbo(this.zzbc, zzaf.zzq(), "ConnectionRetryHelper").zzh(1000).zza(1.3d).zzi(30000).zzb(0.7d).zzaz();
        long j = zzcb;
        zzcb = 1 + j;
        this.zzbs = new zzhz(zzaf.zzq(), "PersistentConnection", new StringBuilder(23).append("pc_").append(j).toString());
        this.zzdn = null;
        zzag();
    }

    private final boolean isIdle() {
        return this.zzdi.isEmpty() && this.zzdf.isEmpty() && !this.zzds && this.zzdh.isEmpty();
    }

    /* access modifiers changed from: private */
    public final zzay zza(zzaw zzaw) {
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(zzaw);
            zzhz.zza(new StringBuilder(String.valueOf(valueOf).length() + 15).append("removing query ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzdi.containsKey(zzaw)) {
            zzay zzay = this.zzdi.get(zzaw);
            this.zzdi.remove(zzaw);
            zzag();
            return zzay;
        } else if (!this.zzbs.zzfa()) {
            return null;
        } else {
            zzhz zzhz2 = this.zzbs;
            String valueOf2 = String.valueOf(zzaw);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf2).length() + 64).append("Trying to remove listener for QuerySpec ").append(valueOf2).append(" but no listener exists.").toString(), (Throwable) null, new Object[0]);
            return null;
        }
    }

    private final void zza(zzay zzay) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzag.zzb((List<String>) zzay.zzaj().zzei));
        Long zzak = zzay.zzak();
        if (zzak != null) {
            hashMap.put("q", zzay.zzen.zzej);
            hashMap.put("t", zzak);
        }
        zzai zzal = zzay.zzal();
        hashMap.put("h", zzal.zzx());
        if (zzal.zzy()) {
            zzy zzz = zzal.zzz();
            ArrayList arrayList = new ArrayList();
            for (List<String> zzb : zzz.zzo()) {
                arrayList.add(zzag.zzb(zzb));
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("hs", zzz.zzp());
            hashMap2.put("ps", arrayList);
            hashMap.put("ch", hashMap2);
        }
        zza("q", (Map<String, Object>) hashMap, (zzau) new zzar(this, zzay));
    }

    private final void zza(String str, List<String> list, Object obj, zzbb zzbb) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzag.zzb(list));
        hashMap.put("d", obj);
        zza(str, (Map<String, Object>) hashMap, (zzau) new zzao(this, zzbb));
    }

    private final void zza(String str, List<String> list, Object obj, String str2, zzbb zzbb) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", zzag.zzb(list));
        hashMap.put("d", obj);
        if (str2 != null) {
            hashMap.put("h", str2);
        }
        long j = this.zzdd;
        this.zzdd = 1 + j;
        this.zzdh.put(Long.valueOf(j), new zzaz(str, hashMap, zzbb, (zzam) null));
        if (zzac()) {
            zze(j);
        }
        this.zzdr = System.currentTimeMillis();
        zzag();
    }

    private final void zza(String str, Map<String, Object> map, zzau zzau) {
        zza(str, false, map, zzau);
    }

    private final void zza(String str, boolean z, Map<String, Object> map, zzau zzau) {
        long j = this.zzde;
        this.zzde = 1 + j;
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(j));
        hashMap.put("a", str);
        hashMap.put("b", map);
        this.zzdb.zza(hashMap, z);
        this.zzdf.put(Long.valueOf(j), zzau);
    }

    /* access modifiers changed from: private */
    public final void zza(List<String> list, zzaw zzaw) {
        if (list.contains("no_index")) {
            String valueOf = String.valueOf(zzaw.zzej.get("i"));
            String sb = new StringBuilder(String.valueOf(valueOf).length() + 14).append("\".indexOn\": \"").append(valueOf).append('\"').toString();
            zzhz zzhz = this.zzbs;
            String zzb = zzag.zzb((List<String>) zzaw.zzei);
            zzhz.zzb(new StringBuilder(String.valueOf(sb).length() + 175 + String.valueOf(zzb).length()).append("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '").append(sb).append("' at ").append(zzb).append(" to your security and Firebase Database rules for better performance").toString(), (Throwable) null);
        }
    }

    private final boolean zzab() {
        return this.zzdc == zzav.Authenticating || this.zzdc == zzav.Connected;
    }

    private final boolean zzac() {
        return this.zzdc == zzav.Connected;
    }

    private final boolean zzad() {
        return this.zzcy.size() == 0;
    }

    /* access modifiers changed from: private */
    public final void zzae() {
        if (zzad()) {
            zzag.zza(this.zzdc == zzav.Disconnected, "Not in disconnected state: %s", this.zzdc);
            boolean z = this.zzdk;
            this.zzbs.zza("Scheduling connection attempt", (Throwable) null, new Object[0]);
            this.zzdk = false;
            this.zzdm.zzb(new zzam(this, z));
        }
    }

    /* access modifiers changed from: private */
    public final void zzaf() {
        int i = 0;
        zzag.zza(this.zzdc == zzav.Connected, "Should be connected if we're restoring state, but we are: %s", this.zzdc);
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("Restoring outstanding listens", (Throwable) null, new Object[0]);
        }
        for (zzay next : this.zzdi.values()) {
            if (this.zzbs.zzfa()) {
                zzhz zzhz = this.zzbs;
                String valueOf = String.valueOf(next.zzaj());
                zzhz.zza(new StringBuilder(String.valueOf(valueOf).length() + 17).append("Restoring listen ").append(valueOf).toString(), (Throwable) null, new Object[0]);
            }
            zza(next);
        }
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("Restoring writes.", (Throwable) null, new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.zzdh.keySet());
        Collections.sort(arrayList);
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zze(((Long) obj).longValue());
        }
        for (zzax next2 : this.zzdg) {
            zza(next2.getAction(), next2.getPath(), next2.getData(), next2.zzai());
        }
        this.zzdg.clear();
    }

    /* access modifiers changed from: private */
    public final void zzag() {
        if (isIdle()) {
            if (this.zzdq != null) {
                this.zzdq.cancel(false);
            }
            this.zzdq = this.zzbc.schedule(new zzat(this), 60000, TimeUnit.MILLISECONDS);
        } else if (isInterrupted("connection_idle")) {
            zzag.zza(!isIdle(), "", new Object[0]);
            resume("connection_idle");
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzah() {
        return isIdle() && System.currentTimeMillis() > this.zzdr + 60000;
    }

    static /* synthetic */ long zzc(zzal zzal) {
        long j = zzal.zzdo;
        zzal.zzdo = 1 + j;
        return j;
    }

    private final void zzc(boolean z) {
        zzag.zza(zzab(), "Must be connected to send auth, but was: %s", this.zzdc);
        zzag.zza(this.zzdj != null, "Auth token must be set to authenticate!", new Object[0]);
        zzap zzap = new zzap(this, z);
        HashMap hashMap = new HashMap();
        zzkd zzu = zzkd.zzu(this.zzdj);
        if (zzu != null) {
            hashMap.put("cred", zzu.getToken());
            if (zzu.zzgu() != null) {
                hashMap.put("authvar", zzu.zzgu());
            }
            zza("gauth", true, (Map<String, Object>) hashMap, (zzau) zzap);
            return;
        }
        hashMap.put("cred", this.zzdj);
        zza("auth", true, (Map<String, Object>) hashMap, (zzau) zzap);
    }

    private final void zze(long j) {
        zzaz zzaz = this.zzdh.get(Long.valueOf(j));
        zzbb zzai = zzaz.zzai();
        String action = zzaz.getAction();
        zzaz.zzan();
        zza(action, zzaz.zzam(), (zzau) new zzaq(this, action, j, zzaz, zzai));
    }

    static /* synthetic */ int zzj(zzal zzal) {
        int i = zzal.zzdp;
        zzal.zzdp = i + 1;
        return i;
    }

    public final void initialize() {
        zzae();
    }

    public final void interrupt(String str) {
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(str);
            zzhz.zza(valueOf.length() != 0 ? "Connection interrupted for: ".concat(valueOf) : new String("Connection interrupted for: "), (Throwable) null, new Object[0]);
        }
        this.zzcy.add(str);
        if (this.zzdb != null) {
            this.zzdb.close();
            this.zzdb = null;
        } else {
            this.zzdm.cancel();
            this.zzdc = zzav.Disconnected;
        }
        this.zzdm.zzax();
    }

    public final boolean isInterrupted(String str) {
        return this.zzcy.contains(str);
    }

    public final void purgeOutstandingWrites() {
        for (zzaz next : this.zzdh.values()) {
            if (next.zzel != null) {
                next.zzel.zzb("write_canceled", (String) null);
            }
        }
        for (zzax next2 : this.zzdg) {
            if (next2.zzel != null) {
                next2.zzel.zzb("write_canceled", (String) null);
            }
        }
        this.zzdh.clear();
        this.zzdg.clear();
        if (!zzab()) {
            this.zzds = false;
        }
        zzag();
    }

    public final void refreshAuthToken() {
        this.zzbs.zza("Auth token refresh requested", (Throwable) null, new Object[0]);
        interrupt("token_refresh");
        resume("token_refresh");
    }

    public final void resume(String str) {
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(str);
            zzhz.zza(valueOf.length() != 0 ? "Connection no longer interrupted for: ".concat(valueOf) : new String("Connection no longer interrupted for: "), (Throwable) null, new Object[0]);
        }
        this.zzcy.remove(str);
        if (zzad() && this.zzdc == zzav.Disconnected) {
            zzae();
        }
    }

    public final void shutdown() {
        interrupt("shutdown");
    }

    public final void zza(long j, String str) {
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("onReady", (Throwable) null, new Object[0]);
        }
        this.zzda = System.currentTimeMillis();
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("handling timestamp", (Throwable) null, new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(j - System.currentTimeMillis()));
        this.zzcw.zzc(hashMap);
        if (this.zzcz) {
            HashMap hashMap2 = new HashMap();
            if (this.zzdl.zzt()) {
                hashMap2.put("persistence.android.enabled", 1);
            }
            String valueOf = String.valueOf(this.zzdl.zzu().replace('.', '-'));
            hashMap2.put(valueOf.length() != 0 ? "sdk.android.".concat(valueOf) : new String("sdk.android."), 1);
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("Sending first connection stats", (Throwable) null, new Object[0]);
            }
            if (!hashMap2.isEmpty()) {
                HashMap hashMap3 = new HashMap();
                hashMap3.put("c", hashMap2);
                zza("s", (Map<String, Object>) hashMap3, (zzau) new zzas(this));
            } else if (this.zzbs.zzfa()) {
                this.zzbs.zza("Not sending stats because stats are empty", (Throwable) null, new Object[0]);
            }
        }
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("calling restore state", (Throwable) null, new Object[0]);
        }
        zzag.zza(this.zzdc == zzav.Connecting, "Wanted to restore auth, but was in wrong state: %s", this.zzdc);
        if (this.zzdj == null) {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("Not restoring auth because token is null.", (Throwable) null, new Object[0]);
            }
            this.zzdc = zzav.Connected;
            zzaf();
        } else {
            if (this.zzbs.zzfa()) {
                this.zzbs.zza("Restoring auth.", (Throwable) null, new Object[0]);
            }
            this.zzdc = zzav.Authenticating;
            zzc(true);
        }
        this.zzcz = false;
        this.zzdn = str;
        this.zzcw.zzaa();
    }

    public final void zza(List<String> list, zzbb zzbb) {
        if (zzac()) {
            zza("oc", list, (Object) null, zzbb);
        } else {
            this.zzdg.add(new zzax("oc", list, (Object) null, zzbb, (zzam) null));
        }
        zzag();
    }

    public final void zza(List<String> list, Object obj, zzbb zzbb) {
        zza("p", list, obj, (String) null, zzbb);
    }

    public final void zza(List<String> list, Object obj, String str, zzbb zzbb) {
        zza("p", list, obj, str, zzbb);
    }

    public final void zza(List<String> list, Map<String, Object> map) {
        zzaw zzaw = new zzaw(list, map);
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(zzaw);
            zzhz.zza(new StringBuilder(String.valueOf(valueOf).length() + 15).append("unlistening on ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        zzay zza = zza(zzaw);
        if (zza != null && zzab()) {
            HashMap hashMap = new HashMap();
            hashMap.put("p", zzag.zzb((List<String>) zza.zzen.zzei));
            Long zzak = zza.zzak();
            if (zzak != null) {
                hashMap.put("q", zza.zzaj().zzej);
                hashMap.put("t", zzak);
            }
            zza("n", (Map<String, Object>) hashMap, (zzau) null);
        }
        zzag();
    }

    public final void zza(List<String> list, Map<String, Object> map, zzai zzai, Long l, zzbb zzbb) {
        zzaw zzaw = new zzaw(list, map);
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(zzaw);
            zzhz.zza(new StringBuilder(String.valueOf(valueOf).length() + 13).append("Listening on ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        zzag.zza(!this.zzdi.containsKey(zzaw), "listen() called twice for same QuerySpec.", new Object[0]);
        if (this.zzbs.zzfa()) {
            zzhz zzhz2 = this.zzbs;
            String valueOf2 = String.valueOf(zzaw);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf2).length() + 21).append("Adding listen query: ").append(valueOf2).toString(), (Throwable) null, new Object[0]);
        }
        zzay zzay = new zzay(zzbb, zzaw, l, zzai, (zzam) null);
        this.zzdi.put(zzaw, zzay);
        if (zzab()) {
            zza(zzay);
        }
        zzag();
    }

    public final void zza(List<String> list, Map<String, Object> map, zzbb zzbb) {
        zza("m", list, (Object) map, (String) null, zzbb);
    }

    public final void zzb(zzab zzab) {
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(zzab.name());
            zzhz.zza(valueOf.length() != 0 ? "Got on disconnect due to ".concat(valueOf) : new String("Got on disconnect due to "), (Throwable) null, new Object[0]);
        }
        this.zzdc = zzav.Disconnected;
        this.zzdb = null;
        this.zzds = false;
        this.zzdf.clear();
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Long, zzaz>> it = this.zzdh.entrySet().iterator();
        while (it.hasNext()) {
            zzaz zzaz = (zzaz) it.next().getValue();
            if (zzaz.zzam().containsKey("h") && zzaz.zzao()) {
                arrayList.add(zzaz);
                it.remove();
            }
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            ((zzaz) obj).zzai().zzb("disconnected", (String) null);
        }
        if (zzad()) {
            boolean z = this.zzda > 0 ? System.currentTimeMillis() - this.zzda > 30000 : false;
            if (zzab == zzab.SERVER_RESET || z) {
                this.zzdm.zzax();
            }
            zzae();
        }
        this.zzda = 0;
        this.zzcw.onDisconnect();
    }

    public final void zzb(List<String> list, Object obj, zzbb zzbb) {
        this.zzds = true;
        if (zzac()) {
            zza("o", list, obj, zzbb);
        } else {
            this.zzdg.add(new zzax("o", list, obj, zzbb, (zzam) null));
        }
        zzag();
    }

    public final void zzb(List<String> list, Map<String, Object> map, zzbb zzbb) {
        this.zzds = true;
        if (zzac()) {
            zza("om", list, (Object) map, zzbb);
        } else {
            this.zzdg.add(new zzax("om", list, map, zzbb, (zzam) null));
        }
        zzag();
    }

    public final void zzb(Map<String, Object> map) {
        if (map.containsKey("r")) {
            zzau remove = this.zzdf.remove(Long.valueOf((long) ((Integer) map.get("r")).intValue()));
            if (remove != null) {
                remove.zzd((Map) map.get("b"));
            }
        } else if (map.containsKey("error")) {
        } else {
            if (map.containsKey("a")) {
                String str = (String) map.get("a");
                Map map2 = (Map) map.get("b");
                if (this.zzbs.zzfa()) {
                    zzhz zzhz = this.zzbs;
                    String valueOf = String.valueOf(map2);
                    zzhz.zza(new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(valueOf).length()).append("handleServerMessage: ").append(str).append(" ").append(valueOf).toString(), (Throwable) null, new Object[0]);
                }
                if (str.equals("d") || str.equals("m")) {
                    boolean equals = str.equals("m");
                    String str2 = (String) map2.get("p");
                    Object obj = map2.get("d");
                    Long zzb = zzag.zzb(map2.get("t"));
                    if (!equals || !(obj instanceof Map) || ((Map) obj).size() != 0) {
                        this.zzcw.zza(zzag.zzg(str2), obj, equals, zzb);
                    } else if (this.zzbs.zzfa()) {
                        zzhz zzhz2 = this.zzbs;
                        String valueOf2 = String.valueOf(str2);
                        zzhz2.zza(valueOf2.length() != 0 ? "ignoring empty merge for path ".concat(valueOf2) : new String("ignoring empty merge for path "), (Throwable) null, new Object[0]);
                    }
                } else if (str.equals("rm")) {
                    String str3 = (String) map2.get("p");
                    List<String> zzg = zzag.zzg(str3);
                    Object obj2 = map2.get("d");
                    Long zzb2 = zzag.zzb(map2.get("t"));
                    ArrayList arrayList = new ArrayList();
                    for (Map map3 : (List) obj2) {
                        String str4 = (String) map3.get("s");
                        String str5 = (String) map3.get("e");
                        arrayList.add(new zzba(str4 != null ? zzag.zzg(str4) : null, str5 != null ? zzag.zzg(str5) : null, map3.get("m")));
                    }
                    if (!arrayList.isEmpty()) {
                        this.zzcw.zza(zzg, arrayList, zzb2);
                    } else if (this.zzbs.zzfa()) {
                        zzhz zzhz3 = this.zzbs;
                        String valueOf3 = String.valueOf(str3);
                        zzhz3.zza(valueOf3.length() != 0 ? "Ignoring empty range merge for path ".concat(valueOf3) : new String("Ignoring empty range merge for path "), (Throwable) null, new Object[0]);
                    }
                } else if (str.equals("c")) {
                    List<String> zzg2 = zzag.zzg((String) map2.get("p"));
                    if (this.zzbs.zzfa()) {
                        zzhz zzhz4 = this.zzbs;
                        String valueOf4 = String.valueOf(zzg2);
                        zzhz4.zza(new StringBuilder(String.valueOf(valueOf4).length() + 29).append("removing all listens at path ").append(valueOf4).toString(), (Throwable) null, new Object[0]);
                    }
                    ArrayList arrayList2 = new ArrayList();
                    for (Map.Entry next : this.zzdi.entrySet()) {
                        zzay zzay = (zzay) next.getValue();
                        if (((zzaw) next.getKey()).zzei.equals(zzg2)) {
                            arrayList2.add(zzay);
                        }
                    }
                    ArrayList arrayList3 = arrayList2;
                    int size = arrayList3.size();
                    int i = 0;
                    while (i < size) {
                        Object obj3 = arrayList3.get(i);
                        i++;
                        this.zzdi.remove(((zzay) obj3).zzaj());
                    }
                    zzag();
                    ArrayList arrayList4 = arrayList2;
                    int size2 = arrayList4.size();
                    int i2 = 0;
                    while (i2 < size2) {
                        Object obj4 = arrayList4.get(i2);
                        i2++;
                        ((zzay) obj4).zzem.zzb("permission_denied", (String) null);
                    }
                } else if (str.equals("ac")) {
                    String str6 = (String) map2.get("s");
                    String str7 = (String) map2.get("d");
                    this.zzbs.zza(new StringBuilder(String.valueOf(str6).length() + 23 + String.valueOf(str7).length()).append("Auth token revoked: ").append(str6).append(" (").append(str7).append(")").toString(), (Throwable) null, new Object[0]);
                    this.zzdj = null;
                    this.zzdk = true;
                    this.zzcw.zzb(false);
                    this.zzdb.close();
                } else if (str.equals("sd")) {
                    this.zzbs.info((String) map2.get(NotificationCompat.CATEGORY_MESSAGE));
                } else if (this.zzbs.zzfa()) {
                    zzhz zzhz5 = this.zzbs;
                    String valueOf5 = String.valueOf(str);
                    zzhz5.zza(valueOf5.length() != 0 ? "Unrecognized action from server: ".concat(valueOf5) : new String("Unrecognized action from server: "), (Throwable) null, new Object[0]);
                }
            } else if (this.zzbs.zzfa()) {
                zzhz zzhz6 = this.zzbs;
                String valueOf6 = String.valueOf(map);
                zzhz6.zza(new StringBuilder(String.valueOf(valueOf6).length() + 26).append("Ignoring unknown message: ").append(valueOf6).toString(), (Throwable) null, new Object[0]);
            }
        }
    }

    public final void zzd(String str) {
        this.zzcx = str;
    }

    public final void zze(String str) {
        if (this.zzbs.zzfa()) {
            zzhz zzhz = this.zzbs;
            String valueOf = String.valueOf(str);
            zzhz.zza(valueOf.length() != 0 ? "Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ".concat(valueOf) : new String("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: "), (Throwable) null, new Object[0]);
        }
        interrupt("server_kill");
    }

    public final void zzh(String str) {
        this.zzbs.zza("Auth token refreshed.", (Throwable) null, new Object[0]);
        this.zzdj = str;
        if (!zzab()) {
            return;
        }
        if (str != null) {
            zzc(false);
            return;
        }
        zzag.zza(zzab(), "Must be connected to send unauth.", new Object[0]);
        zzag.zza(this.zzdj == null, "Auth token must not be set.", new Object[0]);
        zza("unauth", (Map<String, Object>) Collections.emptyMap(), (zzau) null);
    }

    public final void zzi(String str) {
        zzag.zza(this.zzdc == zzav.GettingToken, "Trying to open network connection while in the wrong state: %s", this.zzdc);
        if (str == null) {
            this.zzcw.zzb(false);
        }
        this.zzdj = str;
        this.zzdc = zzav.Connecting;
        this.zzdb = new zzz(this.zzdl, this.zzcc, this.zzcx, this, this.zzdn);
        this.zzdb.open();
    }
}
