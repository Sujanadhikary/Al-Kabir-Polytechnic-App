package com.google.android.gms.internal.measurement;

import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

@WorkerThread
final class zzfo implements Runnable {
    private final String packageName;
    private final URL url;
    private final byte[] zzajl;
    private final zzfm zzajm;
    private final Map<String, String> zzajn;
    private final /* synthetic */ zzfk zzajo;

    public zzfo(zzfk zzfk, String str, URL url2, byte[] bArr, Map<String, String> map, zzfm zzfm) {
        this.zzajo = zzfk;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url2);
        Preconditions.checkNotNull(zzfm);
        this.url = url2;
        this.zzajl = bArr;
        this.zzajm = zzfm;
        this.packageName = str;
        this.zzajn = map;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00e3 A[SYNTHETIC, Splitter:B:36:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            r4 = 0
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo
            r0.zzfs()
            r3 = 0
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo     // Catch:{ IOException -> 0x0124, all -> 0x00dc }
            java.net.URL r1 = r13.url     // Catch:{ IOException -> 0x0124, all -> 0x00dc }
            java.net.HttpURLConnection r2 = r0.zzb((java.net.URL) r1)     // Catch:{ IOException -> 0x0124, all -> 0x00dc }
            java.util.Map<java.lang.String, java.lang.String> r0 = r13.zzajn     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            if (r0 == 0) goto L_0x005d
            java.util.Map<java.lang.String, java.lang.String> r0 = r13.zzajn     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.util.Iterator r5 = r0.iterator()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
        L_0x001d:
            boolean r0 = r5.hasNext()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r5.next()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.Object r1 = r0.getKey()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r2.addRequestProperty(r1, r0)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            goto L_0x001d
        L_0x0039:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r0 = r4
            r1 = r2
        L_0x003e:
            if (r0 == 0) goto L_0x0043
            r0.close()     // Catch:{ IOException -> 0x00c4 }
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.disconnect()
        L_0x0048:
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo
            com.google.android.gms.internal.measurement.zzgg r0 = r0.zzgd()
            com.google.android.gms.internal.measurement.zzfn r5 = new com.google.android.gms.internal.measurement.zzfn
            java.lang.String r6 = r13.packageName
            com.google.android.gms.internal.measurement.zzfm r7 = r13.zzajm
            r10 = r4
            r12 = r4
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r0.zzc((java.lang.Runnable) r5)
        L_0x005c:
            return
        L_0x005d:
            byte[] r0 = r13.zzajl     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            if (r0 == 0) goto L_0x009d
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            com.google.android.gms.internal.measurement.zzka r0 = r0.zzgb()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            byte[] r1 = r13.zzajl     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            byte[] r1 = r0.zza((byte[]) r1)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            com.google.android.gms.internal.measurement.zzfg r0 = r0.zzge()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzit()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.String r5 = "Uploading data. size"
            int r6 = r1.length     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r0.zzg(r5, r6)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r0 = 1
            r2.setDoOutput(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.lang.String r0 = "Content-Encoding"
            java.lang.String r5 = "gzip"
            r2.addRequestProperty(r0, r5)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            int r0 = r1.length     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r2.connect()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.io.OutputStream r0 = r2.getOutputStream()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            r0.write(r1)     // Catch:{ IOException -> 0x012b, all -> 0x011c }
            r0.close()     // Catch:{ IOException -> 0x012b, all -> 0x011c }
        L_0x009d:
            int r3 = r2.getResponseCode()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            java.util.Map r6 = r2.getHeaderFields()     // Catch:{ IOException -> 0x0039, all -> 0x0117 }
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo     // Catch:{ IOException -> 0x0131, all -> 0x0120 }
            byte[] r5 = com.google.android.gms.internal.measurement.zzfk.zzb((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0131, all -> 0x0120 }
            if (r2 == 0) goto L_0x00b0
            r2.disconnect()
        L_0x00b0:
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo
            com.google.android.gms.internal.measurement.zzgg r8 = r0.zzgd()
            com.google.android.gms.internal.measurement.zzfn r0 = new com.google.android.gms.internal.measurement.zzfn
            java.lang.String r1 = r13.packageName
            com.google.android.gms.internal.measurement.zzfm r2 = r13.zzajm
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r8.zzc((java.lang.Runnable) r0)
            goto L_0x005c
        L_0x00c4:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfk r2 = r13.zzajo
            com.google.android.gms.internal.measurement.zzfg r2 = r2.zzge()
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()
            java.lang.String r3 = "Error closing HTTP compressed POST connection output stream. appId"
            java.lang.String r5 = r13.packageName
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r5)
            r2.zze(r3, r5, r0)
            goto L_0x0043
        L_0x00dc:
            r0 = move-exception
            r8 = r0
            r6 = r4
            r2 = r4
            r0 = r4
        L_0x00e1:
            if (r0 == 0) goto L_0x00e6
            r0.close()     // Catch:{ IOException -> 0x0100 }
        L_0x00e6:
            if (r2 == 0) goto L_0x00eb
            r2.disconnect()
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzfk r0 = r13.zzajo
            com.google.android.gms.internal.measurement.zzgg r9 = r0.zzgd()
            com.google.android.gms.internal.measurement.zzfn r0 = new com.google.android.gms.internal.measurement.zzfn
            java.lang.String r1 = r13.packageName
            com.google.android.gms.internal.measurement.zzfm r2 = r13.zzajm
            r5 = r4
            r7 = r4
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zzc((java.lang.Runnable) r0)
            throw r8
        L_0x0100:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfk r1 = r13.zzajo
            com.google.android.gms.internal.measurement.zzfg r1 = r1.zzge()
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()
            java.lang.String r5 = "Error closing HTTP compressed POST connection output stream. appId"
            java.lang.String r7 = r13.packageName
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfg.zzbm(r7)
            r1.zze(r5, r7, r0)
            goto L_0x00e6
        L_0x0117:
            r0 = move-exception
            r8 = r0
            r6 = r4
            r0 = r4
            goto L_0x00e1
        L_0x011c:
            r1 = move-exception
            r8 = r1
            r6 = r4
            goto L_0x00e1
        L_0x0120:
            r0 = move-exception
            r8 = r0
            r0 = r4
            goto L_0x00e1
        L_0x0124:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r0 = r4
            r1 = r4
            goto L_0x003e
        L_0x012b:
            r9 = move-exception
            r11 = r4
            r8 = r3
            r1 = r2
            goto L_0x003e
        L_0x0131:
            r9 = move-exception
            r11 = r6
            r8 = r3
            r0 = r4
            r1 = r2
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfo.run():void");
    }
}
