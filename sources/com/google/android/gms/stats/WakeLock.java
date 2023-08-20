package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public class WakeLock {
    private static ScheduledExecutorService zzaeg;
    private static Configuration zzaeh = new zza();
    private final PowerManager.WakeLock zzadv;
    private WorkSource zzadw;
    private String zzadx;
    private final int zzady;
    private final String zzadz;
    private final String zzaea;
    private final String zzaeb;
    private boolean zzaec;
    private final Map<String, Integer[]> zzaed;
    private int zzaee;
    private AtomicInteger zzaef;
    private final Context zzjp;

    public interface Configuration {
        long getMaximumTimeout(String str, String str2);

        boolean isWorkChainsEnabled();
    }

    public class HeldLock {
        private boolean zzaek;
        /* access modifiers changed from: private */
        public Future zzael;
        private final String zzaem;

        private HeldLock(String str) {
            this.zzaek = true;
            this.zzaem = str;
        }

        /* synthetic */ HeldLock(WakeLock wakeLock, String str, zza zza) {
            this(str);
        }

        public void finalize() {
            if (this.zzaek) {
                String valueOf = String.valueOf(this.zzaem);
                Log.e("WakeLock", valueOf.length() != 0 ? "HeldLock finalized while still holding the WakeLock! Reason: ".concat(valueOf) : new String("HeldLock finalized while still holding the WakeLock! Reason: "));
                release(0);
            }
        }

        public void release() {
            release(0);
        }

        public synchronized void release(int i) {
            if (this.zzaek) {
                this.zzaek = false;
                if (this.zzael != null) {
                    this.zzael.cancel(false);
                    this.zzael = null;
                }
                WakeLock.this.zzc(this.zzaem, i);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, @Nonnull String str) {
        this(context, i, str, (String) null, context == null ? null : context.getPackageName());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2) {
        this(context, i, str, str2, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3) {
        this(context, i, str, str2, str3, (String) null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public WakeLock(Context context, int i, @Nonnull String str, @Nullable String str2, @Nonnull String str3, @Nullable String str4) {
        this.zzaec = true;
        this.zzaed = new HashMap();
        this.zzaef = new AtomicInteger(0);
        Preconditions.checkNotEmpty(str, "Wake lock name can NOT be empty");
        this.zzady = i;
        this.zzaea = str2;
        this.zzaeb = str4;
        this.zzjp = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.zzadz = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.zzadz = str;
        }
        this.zzadv = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            str3 = Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3;
            if (!zzaeh.isWorkChainsEnabled() || str3 == null || str4 == null) {
                this.zzadw = WorkSourceUtil.fromPackage(context, str3);
            } else {
                Log.d("WakeLock", new StringBuilder(String.valueOf(str3).length() + 42 + String.valueOf(str4).length()).append("Using experimental Pi WorkSource chains: ").append(str3).append(",").append(str4).toString());
                this.zzadx = str3;
                this.zzadw = WorkSourceUtil.fromPackageAndModuleExperimentalPi(context, str3, str4);
            }
            addWorkSource(this.zzadw);
        }
        if (zzaeg == null) {
            zzaeg = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    public static void setConfiguration(Configuration configuration) {
        zzaeh = configuration;
    }

    private final void zza(WorkSource workSource) {
        try {
            this.zzadv.setWorkSource(workSource);
        } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            Log.wtf("WakeLock", e.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        if (r0 == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r12.zzaee == 0) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.zzadv, r6), 7, r12.zzadz, r6, r12.zzaeb, r12.zzady, zzdo(), r14);
        r12.zzaee++;
     */
    @android.annotation.SuppressLint({"WakelockTimeout"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zza(java.lang.String r13, long r14) {
        /*
            r12 = this;
            r1 = 1
            r2 = 0
            java.lang.String r6 = r12.zzn((java.lang.String) r13)
            monitor-enter(r12)
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r12.zzaed     // Catch:{ all -> 0x00b9 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x0013
            int r0 = r12.zzaee     // Catch:{ all -> 0x00b9 }
            if (r0 <= 0) goto L_0x0023
        L_0x0013:
            android.os.PowerManager$WakeLock r0 = r12.zzadv     // Catch:{ all -> 0x00b9 }
            boolean r0 = r0.isHeld()     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x0023
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r12.zzaed     // Catch:{ all -> 0x00b9 }
            r0.clear()     // Catch:{ all -> 0x00b9 }
            r0 = 0
            r12.zzaee = r0     // Catch:{ all -> 0x00b9 }
        L_0x0023:
            boolean r0 = r12.zzaec     // Catch:{ all -> 0x00b9 }
            if (r0 == 0) goto L_0x0044
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r12.zzaed     // Catch:{ all -> 0x00b9 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x00b9 }
            java.lang.Integer[] r0 = (java.lang.Integer[]) r0     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x00a7
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r12.zzaed     // Catch:{ all -> 0x00b9 }
            r2 = 1
            java.lang.Integer[] r2 = new java.lang.Integer[r2]     // Catch:{ all -> 0x00b9 }
            r3 = 0
            r4 = 1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x00b9 }
            r2[r3] = r4     // Catch:{ all -> 0x00b9 }
            r0.put(r6, r2)     // Catch:{ all -> 0x00b9 }
            r0 = r1
        L_0x0042:
            if (r0 != 0) goto L_0x004c
        L_0x0044:
            boolean r0 = r12.zzaec     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x006d
            int r0 = r12.zzaee     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x006d
        L_0x004c:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x00b9 }
            android.content.Context r2 = r12.zzjp     // Catch:{ all -> 0x00b9 }
            android.os.PowerManager$WakeLock r0 = r12.zzadv     // Catch:{ all -> 0x00b9 }
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey((android.os.PowerManager.WakeLock) r0, (java.lang.String) r6)     // Catch:{ all -> 0x00b9 }
            r4 = 7
            java.lang.String r5 = r12.zzadz     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = r12.zzaeb     // Catch:{ all -> 0x00b9 }
            int r8 = r12.zzady     // Catch:{ all -> 0x00b9 }
            java.util.List r9 = r12.zzdo()     // Catch:{ all -> 0x00b9 }
            r10 = r14
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x00b9 }
            int r0 = r12.zzaee     // Catch:{ all -> 0x00b9 }
            int r0 = r0 + 1
            r12.zzaee = r0     // Catch:{ all -> 0x00b9 }
        L_0x006d:
            monitor-exit(r12)     // Catch:{ all -> 0x00b9 }
            android.os.PowerManager$WakeLock r0 = r12.zzadv
            r0.acquire()
            r0 = 0
            int r0 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x00a6
            java.util.concurrent.ScheduledExecutorService r0 = zzaeg
            com.google.android.gms.stats.zzb r1 = new com.google.android.gms.stats.zzb
            r1.<init>(r12)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastIceCreamSandwich()
            if (r0 != 0) goto L_0x00a6
            boolean r0 = r12.zzaec
            if (r0 == 0) goto L_0x00a6
            java.lang.String r1 = "WakeLock"
            java.lang.String r2 = "Do not acquire with timeout on reference counted wakeLocks before ICS. wakelock: "
            java.lang.String r0 = r12.zzadz
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x00bc
            java.lang.String r0 = r2.concat(r0)
        L_0x00a3:
            android.util.Log.wtf(r1, r0)
        L_0x00a6:
            return
        L_0x00a7:
            r1 = 0
            r3 = 0
            r3 = r0[r3]     // Catch:{ all -> 0x00b9 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00b9 }
            int r3 = r3 + 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00b9 }
            r0[r1] = r3     // Catch:{ all -> 0x00b9 }
            r0 = r2
            goto L_0x0042
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b9 }
            throw r0
        L_0x00bc:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x00a3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zza(java.lang.String, long):void");
    }

    private final void zzb(String str, int i) {
        if (this.zzaef.decrementAndGet() < 0) {
            Log.e("WakeLock", "release without a matched acquire!");
        }
        zzc(str, i);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        if (r9.zzaee == 1) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r9.zzjp, com.google.android.gms.common.stats.StatsUtils.getEventKey(r9.zzadv, r5), 8, r9.zzadz, r5, r9.zzaeb, r9.zzady, zzdo());
        r9.zzaee--;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0016, code lost:
        if (r0 == false) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(java.lang.String r10, int r11) {
        /*
            r9 = this;
            r2 = 1
            r1 = 0
            java.lang.String r5 = r9.zzn((java.lang.String) r10)
            monitor-enter(r9)
            boolean r0 = r9.zzaec     // Catch:{ all -> 0x0068 }
            if (r0 == 0) goto L_0x0018
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r9.zzaed     // Catch:{ all -> 0x0068 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ all -> 0x0068 }
            java.lang.Integer[] r0 = (java.lang.Integer[]) r0     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x0046
            r0 = r1
        L_0x0016:
            if (r0 != 0) goto L_0x0020
        L_0x0018:
            boolean r0 = r9.zzaec     // Catch:{ all -> 0x0068 }
            if (r0 != 0) goto L_0x0041
            int r0 = r9.zzaee     // Catch:{ all -> 0x0068 }
            if (r0 != r2) goto L_0x0041
        L_0x0020:
            com.google.android.gms.common.stats.WakeLockTracker r0 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch:{ all -> 0x0068 }
            android.content.Context r1 = r9.zzjp     // Catch:{ all -> 0x0068 }
            android.os.PowerManager$WakeLock r2 = r9.zzadv     // Catch:{ all -> 0x0068 }
            java.lang.String r2 = com.google.android.gms.common.stats.StatsUtils.getEventKey((android.os.PowerManager.WakeLock) r2, (java.lang.String) r5)     // Catch:{ all -> 0x0068 }
            r3 = 8
            java.lang.String r4 = r9.zzadz     // Catch:{ all -> 0x0068 }
            java.lang.String r6 = r9.zzaeb     // Catch:{ all -> 0x0068 }
            int r7 = r9.zzady     // Catch:{ all -> 0x0068 }
            java.util.List r8 = r9.zzdo()     // Catch:{ all -> 0x0068 }
            r0.registerEvent(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0068 }
            int r0 = r9.zzaee     // Catch:{ all -> 0x0068 }
            int r0 = r0 + -1
            r9.zzaee = r0     // Catch:{ all -> 0x0068 }
        L_0x0041:
            monitor-exit(r9)     // Catch:{ all -> 0x0068 }
            r9.zzn((int) r11)
            return
        L_0x0046:
            r3 = 0
            r3 = r0[r3]     // Catch:{ all -> 0x0068 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0068 }
            if (r3 != r2) goto L_0x0056
            java.util.Map<java.lang.String, java.lang.Integer[]> r0 = r9.zzaed     // Catch:{ all -> 0x0068 }
            r0.remove(r5)     // Catch:{ all -> 0x0068 }
            r0 = r2
            goto L_0x0016
        L_0x0056:
            r3 = 0
            r4 = 0
            r4 = r0[r4]     // Catch:{ all -> 0x0068 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0068 }
            int r4 = r4 + -1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0068 }
            r0[r3] = r4     // Catch:{ all -> 0x0068 }
            r0 = r1
            goto L_0x0016
        L_0x0068:
            r0 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x0068 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.zzc(java.lang.String, int):void");
    }

    private final List<String> zzdo() {
        List<String> names = WorkSourceUtil.getNames(this.zzadw);
        if (this.zzadx == null) {
            return names;
        }
        ArrayList arrayList = new ArrayList(names);
        arrayList.add(this.zzadx);
        return arrayList;
    }

    private final String zzn(String str) {
        return this.zzaec ? !TextUtils.isEmpty(str) ? str : this.zzaea : this.zzaea;
    }

    /* access modifiers changed from: private */
    public final void zzn(int i) {
        if (this.zzadv.isHeld()) {
            try {
                if (Build.VERSION.SDK_INT < 21 || i <= 0) {
                    this.zzadv.release();
                } else {
                    this.zzadv.release(i);
                }
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.zzadz).concat(" was already released!"), e);
                    return;
                }
                throw e;
            }
        }
    }

    public void acquire() {
        this.zzaef.incrementAndGet();
        zza((String) null, 0);
    }

    public void acquire(long j) {
        this.zzaef.incrementAndGet();
        zza((String) null, j);
    }

    public void acquire(String str) {
        this.zzaef.incrementAndGet();
        zza(str, 0);
    }

    public void acquire(String str, long j) {
        this.zzaef.incrementAndGet();
        zza(str, j);
    }

    public HeldLock acquireLock(long j, String str) {
        long min = Math.min(j, zzaeh.getMaximumTimeout(this.zzadz, str));
        HeldLock heldLock = new HeldLock(this, str, (zza) null);
        zza(str, 0);
        Future unused = heldLock.zzael = zzaeg.schedule(new zzc(new WeakReference(heldLock)), min, TimeUnit.MILLISECONDS);
        return heldLock;
    }

    public void addWorkSource(WorkSource workSource) {
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            if (this.zzadw != null) {
                this.zzadw.add(workSource);
            } else {
                this.zzadw = workSource;
            }
            zza(this.zzadw);
        }
    }

    public PowerManager.WakeLock getWakeLock() {
        return this.zzadv;
    }

    public boolean isHeld() {
        return this.zzadv.isHeld();
    }

    public void release() {
        zzb((String) null, 0);
    }

    public void release(int i) {
        zzb((String) null, i);
    }

    public void release(String str) {
        zzb(str, 0);
    }

    public void release(String str, int i) {
        zzb(str, i);
    }

    public void removeWorkSource(WorkSource workSource) {
        if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            try {
                if (this.zzadw != null) {
                    this.zzadw.remove(workSource);
                }
                zza(this.zzadw);
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.e("WakeLock", e.toString());
            }
        }
    }

    public void setReferenceCounted(boolean z) {
        this.zzadv.setReferenceCounted(z);
        this.zzaec = z;
    }

    public void setWorkSource(WorkSource workSource) {
        if (WorkSourceUtil.hasWorkSourcePermission(this.zzjp)) {
            zza(workSource);
            this.zzadw = workSource;
            this.zzadx = null;
        }
    }
}
