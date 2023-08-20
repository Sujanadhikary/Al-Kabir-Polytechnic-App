package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.BlockingQueue;

final class zzgk extends Thread {
    private final /* synthetic */ zzgg zzalz;
    private final Object zzamc = new Object();
    private final BlockingQueue<zzgj<?>> zzamd;

    public zzgk(zzgg zzgg, String str, BlockingQueue<zzgj<?>> blockingQueue) {
        this.zzalz = zzgg;
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(blockingQueue);
        this.zzamd = blockingQueue;
        setName(str);
    }

    private final void zza(InterruptedException interruptedException) {
        this.zzalz.zzge().zzip().zzg(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x008b, code lost:
        r1 = r6.zzalz.zzalu;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r6.zzalz.zzalv.release();
        r6.zzalz.zzalu.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00aa, code lost:
        if (r6 != r6.zzalz.zzalo) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00ac, code lost:
        com.google.android.gms.internal.measurement.zzgk unused = r6.zzalz.zzalo = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b2, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00c2, code lost:
        if (r6 != r6.zzalz.zzalp) goto L_0x00ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00c4, code lost:
        com.google.android.gms.internal.measurement.zzgk unused = r6.zzalz.zzalp = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        r6.zzalz.zzge().zzim().log("Current scheduler thread is neither worker nor network");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r6 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            if (r1 != 0) goto L_0x0015
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ InterruptedException -> 0x0010 }
            java.util.concurrent.Semaphore r0 = r0.zzalv     // Catch:{ InterruptedException -> 0x0010 }
            r0.acquire()     // Catch:{ InterruptedException -> 0x0010 }
            r0 = 1
            r1 = r0
            goto L_0x0002
        L_0x0010:
            r0 = move-exception
            r6.zza(r0)
            goto L_0x0002
        L_0x0015:
            int r0 = android.os.Process.myTid()     // Catch:{ all -> 0x0033 }
            int r2 = android.os.Process.getThreadPriority(r0)     // Catch:{ all -> 0x0033 }
        L_0x001d:
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.measurement.zzgj<?>> r0 = r6.zzamd     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.measurement.zzgj r0 = (com.google.android.gms.internal.measurement.zzgj) r0     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0060
            boolean r1 = r0.zzamb     // Catch:{ all -> 0x0033 }
            if (r1 == 0) goto L_0x005d
            r1 = r2
        L_0x002c:
            android.os.Process.setThreadPriority(r1)     // Catch:{ all -> 0x0033 }
            r0.run()     // Catch:{ all -> 0x0033 }
            goto L_0x001d
        L_0x0033:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzgg r1 = r6.zzalz
            java.lang.Object r1 = r1.zzalu
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            java.util.concurrent.Semaphore r2 = r2.zzalv     // Catch:{ all -> 0x00f4 }
            r2.release()     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            java.lang.Object r2 = r2.zzalu     // Catch:{ all -> 0x00f4 }
            r2.notifyAll()     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzgk r2 = r2.zzalo     // Catch:{ all -> 0x00f4 }
            if (r6 != r2) goto L_0x00e4
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            r3 = 0
            com.google.android.gms.internal.measurement.zzgk unused = r2.zzalo = null     // Catch:{ all -> 0x00f4 }
        L_0x005b:
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            throw r0
        L_0x005d:
            r1 = 10
            goto L_0x002c
        L_0x0060:
            java.lang.Object r1 = r6.zzamc     // Catch:{ all -> 0x0033 }
            monitor-enter(r1)     // Catch:{ all -> 0x0033 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.measurement.zzgj<?>> r0 = r6.zzamd     // Catch:{ all -> 0x00b9 }
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x007a
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00b9 }
            boolean r0 = r0.zzalw     // Catch:{ all -> 0x00b9 }
            if (r0 != 0) goto L_0x007a
            java.lang.Object r0 = r6.zzamc     // Catch:{ InterruptedException -> 0x00b4 }
            r4 = 30000(0x7530, double:1.4822E-319)
            r0.wait(r4)     // Catch:{ InterruptedException -> 0x00b4 }
        L_0x007a:
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x0033 }
            java.lang.Object r1 = r0.zzalu     // Catch:{ all -> 0x0033 }
            monitor-enter(r1)     // Catch:{ all -> 0x0033 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.internal.measurement.zzgj<?>> r0 = r6.zzamd     // Catch:{ all -> 0x00e1 }
            java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00e1 }
            if (r0 != 0) goto L_0x00de
            monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz
            java.lang.Object r1 = r0.zzalu
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            java.util.concurrent.Semaphore r0 = r0.zzalv     // Catch:{ all -> 0x00cb }
            r0.release()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            java.lang.Object r0 = r0.zzalu     // Catch:{ all -> 0x00cb }
            r0.notifyAll()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzgk r0 = r0.zzalo     // Catch:{ all -> 0x00cb }
            if (r6 != r0) goto L_0x00bc
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            r2 = 0
            com.google.android.gms.internal.measurement.zzgk unused = r0.zzalo = null     // Catch:{ all -> 0x00cb }
        L_0x00b2:
            monitor-exit(r1)     // Catch:{ all -> 0x00cb }
            return
        L_0x00b4:
            r0 = move-exception
            r6.zza(r0)     // Catch:{ all -> 0x00b9 }
            goto L_0x007a
        L_0x00b9:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b9 }
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x00bc:
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzgk r0 = r0.zzalp     // Catch:{ all -> 0x00cb }
            if (r6 != r0) goto L_0x00ce
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            r2 = 0
            com.google.android.gms.internal.measurement.zzgk unused = r0.zzalp = null     // Catch:{ all -> 0x00cb }
            goto L_0x00b2
        L_0x00cb:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00cb }
            throw r0
        L_0x00ce:
            com.google.android.gms.internal.measurement.zzgg r0 = r6.zzalz     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzfg r0 = r0.zzge()     // Catch:{ all -> 0x00cb }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzim()     // Catch:{ all -> 0x00cb }
            java.lang.String r2 = "Current scheduler thread is neither worker nor network"
            r0.log(r2)     // Catch:{ all -> 0x00cb }
            goto L_0x00b2
        L_0x00de:
            monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
            goto L_0x001d
        L_0x00e1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
            throw r0     // Catch:{ all -> 0x0033 }
        L_0x00e4:
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzgk r2 = r2.zzalp     // Catch:{ all -> 0x00f4 }
            if (r6 != r2) goto L_0x00f7
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            r3 = 0
            com.google.android.gms.internal.measurement.zzgk unused = r2.zzalp = null     // Catch:{ all -> 0x00f4 }
            goto L_0x005b
        L_0x00f4:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f4 }
            throw r0
        L_0x00f7:
            com.google.android.gms.internal.measurement.zzgg r2 = r6.zzalz     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzfg r2 = r2.zzge()     // Catch:{ all -> 0x00f4 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00f4 }
            java.lang.String r3 = "Current scheduler thread is neither worker nor network"
            r2.log(r3)     // Catch:{ all -> 0x00f4 }
            goto L_0x005b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgk.run():void");
    }

    public final void zzjn() {
        synchronized (this.zzamc) {
            this.zzamc.notifyAll();
        }
    }
}
