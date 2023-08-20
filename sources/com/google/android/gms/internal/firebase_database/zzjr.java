package com.google.android.gms.internal.firebase_database;

import android.support.annotation.Nullable;
import java.io.IOException;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzjr {
    private static final AtomicInteger zzsy = new AtomicInteger(0);
    private static final Charset zzsz = Charset.forName("UTF-8");
    private static ThreadFactory zztj = Executors.defaultThreadFactory();
    private static zzjq zztk = new zzjs();
    private final zzhz zzbs;
    @Nullable
    private final String zzcs;
    private volatile int zzta = zzjv.zztn;
    private volatile Socket zztb = null;
    private zzjw zztc = null;
    private final URI zztd;
    private final zzka zzte;
    private final zzkb zztf;
    private final zzjy zztg;
    private final int zzth = zzsy.incrementAndGet();
    private final Thread zzti = zztj.newThread(new zzjt(this));

    public zzjr(zzaf zzaf, URI uri, String str, Map<String, String> map) {
        this.zztd = uri;
        this.zzcs = zzaf.zzw();
        this.zzbs = new zzhz(zzaf.zzq(), "WebSocket", new StringBuilder(14).append("sk_").append(this.zzth).toString());
        this.zztg = new zzjy(uri, (String) null, map);
        this.zzte = new zzka(this);
        this.zztf = new zzkb(this, "TubeSock", this.zzth);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa A[Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.net.Socket createSocket() {
        /*
            r7 = this;
            r4 = -1
            java.net.URI r0 = r7.zztd
            java.lang.String r1 = r0.getScheme()
            java.net.URI r0 = r7.zztd
            java.lang.String r3 = r0.getHost()
            java.net.URI r0 = r7.zztd
            int r0 = r0.getPort()
            if (r1 == 0) goto L_0x0070
            java.lang.String r2 = "ws"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0070
            if (r0 != r4) goto L_0x0144
            r0 = 80
            r1 = r0
        L_0x0022:
            java.net.Socket r0 = new java.net.Socket     // Catch:{ UnknownHostException -> 0x0028, IOException -> 0x0046 }
            r0.<init>(r3, r1)     // Catch:{ UnknownHostException -> 0x0028, IOException -> 0x0046 }
        L_0x0027:
            return r0
        L_0x0028:
            r0 = move-exception
            r1 = r0
            com.google.android.gms.internal.firebase_database.zzjx r2 = new com.google.android.gms.internal.firebase_database.zzjx
            java.lang.String r4 = "unknown host: "
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x0040
            java.lang.String r0 = r4.concat(r0)
        L_0x003c:
            r2.<init>(r0, r1)
            throw r2
        L_0x0040:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            goto L_0x003c
        L_0x0046:
            r0 = move-exception
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx
            java.net.URI r2 = r7.zztd
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 31
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "error while creating socket to "
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0070:
            if (r1 == 0) goto L_0x0128
            java.lang.String r2 = "wss"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x0128
            if (r0 != r4) goto L_0x007e
            r0 = 443(0x1bb, float:6.21E-43)
        L_0x007e:
            r2 = 0
            java.lang.String r1 = r7.zzcs     // Catch:{ IOException -> 0x00eb }
            if (r1 == 0) goto L_0x00f6
            android.net.SSLSessionCache r1 = new android.net.SSLSessionCache     // Catch:{ IOException -> 0x00eb }
            java.io.File r4 = new java.io.File     // Catch:{ IOException -> 0x00eb }
            java.lang.String r5 = r7.zzcs     // Catch:{ IOException -> 0x00eb }
            r4.<init>(r5)     // Catch:{ IOException -> 0x00eb }
            r1.<init>(r4)     // Catch:{ IOException -> 0x00eb }
        L_0x008f:
            r2 = 60000(0xea60, float:8.4078E-41)
            javax.net.ssl.SSLSocketFactory r1 = android.net.SSLCertificateSocketFactory.getDefault(r2, r1)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.net.Socket r0 = r1.createSocket(r3, r0)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            javax.net.ssl.SSLSocket r0 = (javax.net.ssl.SSLSocket) r0     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            javax.net.ssl.HostnameVerifier r1 = javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier()     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            javax.net.ssl.SSLSession r2 = r0.getSession()     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            boolean r1 = r1.verify(r3, r2)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            if (r1 != 0) goto L_0x0027
            com.google.android.gms.internal.firebase_database.zzjx r0 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.net.URI r1 = r7.zztd     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            int r2 = r2.length()     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            int r2 = r2 + 39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            r4.<init>(r2)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.lang.String r2 = "Error while verifying secure socket to "
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            java.lang.String r1 = r1.toString()     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            r0.<init>(r1)     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
            throw r0     // Catch:{ UnknownHostException -> 0x00d3, IOException -> 0x00fe }
        L_0x00d3:
            r0 = move-exception
            r1 = r0
            com.google.android.gms.internal.firebase_database.zzjx r2 = new com.google.android.gms.internal.firebase_database.zzjx
            java.lang.String r4 = "unknown host: "
            java.lang.String r0 = java.lang.String.valueOf(r3)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x00f8
            java.lang.String r0 = r4.concat(r0)
        L_0x00e7:
            r2.<init>(r0, r1)
            throw r2
        L_0x00eb:
            r1 = move-exception
            com.google.android.gms.internal.firebase_database.zzhz r4 = r7.zzbs
            java.lang.String r5 = "Failed to initialize SSL session cache"
            r6 = 0
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r4.zza(r5, r1, r6)
        L_0x00f6:
            r1 = r2
            goto L_0x008f
        L_0x00f8:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4)
            goto L_0x00e7
        L_0x00fe:
            r0 = move-exception
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx
            java.net.URI r2 = r7.zztd
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r3 = java.lang.String.valueOf(r2)
            int r3 = r3.length()
            int r3 = r3 + 38
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "error while creating secure socket to "
            java.lang.StringBuilder r3 = r4.append(r3)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x0128:
            com.google.android.gms.internal.firebase_database.zzjx r2 = new com.google.android.gms.internal.firebase_database.zzjx
            java.lang.String r3 = "unsupported protocol: "
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            if (r1 == 0) goto L_0x013e
            java.lang.String r0 = r3.concat(r0)
        L_0x013a:
            r2.<init>(r0)
            throw r2
        L_0x013e:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L_0x013a
        L_0x0144:
            r1 = r0
            goto L_0x0022
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_database.zzjr.createSocket():java.net.Socket");
    }

    static ThreadFactory getThreadFactory() {
        return zztj;
    }

    private final synchronized void zza(byte b, byte[] bArr) {
        if (this.zzta != zzjv.zztp) {
            this.zztc.zza(new zzjx("error while sending data: not connected"));
        } else {
            try {
                this.zztf.zza(b, true, bArr);
            } catch (IOException e) {
                this.zztc.zza(new zzjx("Failed to send frame", e));
                close();
            }
        }
        return;
    }

    static zzjq zzgi() {
        return zztk;
    }

    private final synchronized void zzgl() {
        if (this.zzta != zzjv.zztr) {
            this.zzte.zzgp();
            this.zztf.zzgr();
            if (this.zztb != null) {
                try {
                    this.zztb.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.zzta = zzjv.zztr;
            this.zztc.onClose();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r7 = new java.io.DataInputStream(r1.getInputStream());
        r8 = r1.getOutputStream();
        r8.write(r12.zztg.zzgo());
        r2 = new java.util.ArrayList();
        r5 = 0;
        r6 = new byte[1000];
        r1 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        if (r1 != false) goto L_0x00eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0057, code lost:
        r9 = r7.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x005c, code lost:
        if (r9 != -1) goto L_0x0089;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0065, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx("Connection closed before handshake was complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r6[r5] = (byte) r9;
        r5 = r5 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0094, code lost:
        if (r6[r5 - 1] != 10) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x009c, code lost:
        if (r6[r5 - 2] != 13) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009e, code lost:
        r5 = new java.lang.String(r6, zzsz);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00af, code lost:
        if (r5.trim().equals("") == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00b1, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b2, code lost:
        r6 = new byte[1000];
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b9, code lost:
        r2.add(r5.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00c6, code lost:
        if (r5 != 1000) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:?, code lost:
        r1 = java.lang.String.valueOf(new java.lang.String(r6, zzsz));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00db, code lost:
        if (r1.length() == 0) goto L_0x00e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00dd, code lost:
        r1 = "Unexpected long line in handshake: ".concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00e4, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00e5, code lost:
        r1 = new java.lang.String("Unexpected long line in handshake: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00eb, code lost:
        r1 = java.lang.Integer.parseInt(((java.lang.String) r2.get(0)).substring(9, 12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0100, code lost:
        if (r1 != 407) goto L_0x010a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0109, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx("connection failed: proxy authentication not supported");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x010c, code lost:
        if (r1 != 404) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0115, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx("connection failed: 404 not found");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0118, code lost:
        if (r1 == 101) goto L_0x0135;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0134, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx(new java.lang.StringBuilder(50).append("connection failed: unknown status code ").append(r1).toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0135, code lost:
        r2.remove(0);
        r4 = new java.util.HashMap();
        r1 = r2;
        r5 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0146, code lost:
        if (r3 >= r5) goto L_0x0161;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0148, code lost:
        r2 = r1.get(r3);
        r3 = r3 + 1;
        r2 = ((java.lang.String) r2).split(": ", 2);
        r4.put(r2[0], r2[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0175, code lost:
        if (((java.lang.String) r4.get("Upgrade")).toLowerCase(java.util.Locale.US).equals("websocket") != false) goto L_0x017f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x017e, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx("connection failed: missing header field in server handshake: Upgrade");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0193, code lost:
        if (((java.lang.String) r4.get("Connection")).toLowerCase(java.util.Locale.US).equals("upgrade") != false) goto L_0x019d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x019c, code lost:
        throw new com.google.android.gms.internal.firebase_database.zzjx("connection failed: missing header field in server handshake: Connection");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019d, code lost:
        r12.zztf.zza(r8);
        r12.zzte.zza(r7);
        r12.zzta = com.google.android.gms.internal.firebase_database.zzjv.zztp;
        r12.zztf.zzgt().start();
        r12.zztc.zzav();
        r12.zzte.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01be, code lost:
        close();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzgn() {
        /*
            r12 = this;
            r4 = 1
            r11 = 1000(0x3e8, float:1.401E-42)
            r3 = 0
            java.net.Socket r1 = r12.createSocket()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            monitor-enter(r12)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r12.zztb = r1     // Catch:{ all -> 0x0025 }
            int r2 = r12.zzta     // Catch:{ all -> 0x0025 }
            int r5 = com.google.android.gms.internal.firebase_database.zzjv.zztr     // Catch:{ all -> 0x0025 }
            if (r2 != r5) goto L_0x0032
            java.net.Socket r1 = r12.zztb     // Catch:{ IOException -> 0x001e }
            r1.close()     // Catch:{ IOException -> 0x001e }
            r1 = 0
            r12.zztb = r1     // Catch:{ all -> 0x0025 }
            monitor-exit(r12)     // Catch:{ all -> 0x0025 }
            r12.close()
        L_0x001d:
            return
        L_0x001e:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0025 }
            r2.<init>(r1)     // Catch:{ all -> 0x0025 }
            throw r2     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0025 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x0028:
            r1 = move-exception
            com.google.android.gms.internal.firebase_database.zzjw r2 = r12.zztc     // Catch:{ all -> 0x00c1 }
            r2.zza((com.google.android.gms.internal.firebase_database.zzjx) r1)     // Catch:{ all -> 0x00c1 }
            r12.close()
            goto L_0x001d
        L_0x0032:
            monitor-exit(r12)     // Catch:{ all -> 0x0025 }
            java.io.DataInputStream r7 = new java.io.DataInputStream     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.io.InputStream r2 = r1.getInputStream()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r7.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.io.OutputStream r8 = r1.getOutputStream()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzjy r1 = r12.zztg     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            byte[] r1 = r1.zzgo()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r8.write(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1 = 1000(0x3e8, float:1.401E-42)
            byte[] r1 = new byte[r1]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r2.<init>()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r5 = r3
            r6 = r1
            r1 = r3
        L_0x0055:
            if (r1 != 0) goto L_0x00eb
            int r9 = r7.read()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r10 = -1
            if (r9 != r10) goto L_0x0089
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "Connection closed before handshake was complete"
            r1.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x0066:
            r1 = move-exception
            com.google.android.gms.internal.firebase_database.zzjw r3 = r12.zztc     // Catch:{ all -> 0x00c1 }
            com.google.android.gms.internal.firebase_database.zzjx r4 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ all -> 0x00c1 }
            java.lang.String r5 = "error while connecting: "
            java.lang.String r2 = r1.getMessage()     // Catch:{ all -> 0x00c1 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x00c1 }
            int r6 = r2.length()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x01c3
            java.lang.String r2 = r5.concat(r2)     // Catch:{ all -> 0x00c1 }
        L_0x007f:
            r4.<init>(r2, r1)     // Catch:{ all -> 0x00c1 }
            r3.zza((com.google.android.gms.internal.firebase_database.zzjx) r4)     // Catch:{ all -> 0x00c1 }
            r12.close()
            goto L_0x001d
        L_0x0089:
            byte r9 = (byte) r9
            r6[r5] = r9     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            int r5 = r5 + 1
            int r9 = r5 + -1
            byte r9 = r6[r9]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r10 = 10
            if (r9 != r10) goto L_0x00c6
            int r9 = r5 + -2
            byte r9 = r6[r9]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r10 = 13
            if (r9 != r10) goto L_0x00c6
            java.lang.String r5 = new java.lang.String     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.nio.charset.Charset r9 = zzsz     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r5.<init>(r6, r9)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r6 = r5.trim()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r9 = ""
            boolean r6 = r6.equals(r9)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            if (r6 == 0) goto L_0x00b9
            r1 = r4
        L_0x00b2:
            r5 = 1000(0x3e8, float:1.401E-42)
            byte[] r5 = new byte[r5]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r6 = r5
            r5 = r3
            goto L_0x0055
        L_0x00b9:
            java.lang.String r5 = r5.trim()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r2.add(r5)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            goto L_0x00b2
        L_0x00c1:
            r1 = move-exception
            r12.close()
            throw r1
        L_0x00c6:
            if (r5 != r11) goto L_0x0055
            java.lang.String r1 = new java.lang.String     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.nio.charset.Charset r2 = zzsz     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.<init>(r6, r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzjx r2 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r3 = "Unexpected long line in handshake: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            int r4 = r1.length()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            if (r4 == 0) goto L_0x00e5
            java.lang.String r1 = r3.concat(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x00e1:
            r2.<init>(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r2     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x00e5:
            java.lang.String r1 = new java.lang.String     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.<init>(r3)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            goto L_0x00e1
        L_0x00eb:
            r1 = 0
            java.lang.Object r1 = r2.get(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r4 = 9
            r5 = 12
            java.lang.String r1 = r1.substring(r4, r5)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r4 = 407(0x197, float:5.7E-43)
            if (r1 != r4) goto L_0x010a
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "connection failed: proxy authentication not supported"
            r1.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x010a:
            r4 = 404(0x194, float:5.66E-43)
            if (r1 != r4) goto L_0x0116
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "connection failed: 404 not found"
            r1.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x0116:
            r4 = 101(0x65, float:1.42E-43)
            if (r1 == r4) goto L_0x0135
            com.google.android.gms.internal.firebase_database.zzjx r2 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r3 = 50
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r4.<init>(r3)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r3 = "connection failed: unknown status code "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = r1.toString()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r2.<init>(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r2     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x0135:
            r1 = 0
            r2.remove(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r4.<init>()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r0 = r2
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1 = r0
            int r5 = r1.size()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x0146:
            if (r3 >= r5) goto L_0x0161
            java.lang.Object r2 = r1.get(r3)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            int r3 = r3 + 1
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r6 = ": "
            r9 = 2
            java.lang.String[] r2 = r2.split(r6, r9)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r6 = 0
            r6 = r2[r6]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r9 = 1
            r2 = r2[r9]     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r4.put(r6, r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            goto L_0x0146
        L_0x0161:
            java.lang.String r1 = "Upgrade"
            java.lang.Object r1 = r4.get(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = r1.toLowerCase(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "websocket"
            boolean r1 = r1.equals(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            if (r1 != 0) goto L_0x017f
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "connection failed: missing header field in server handshake: Upgrade"
            r1.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x017f:
            java.lang.String r1 = "Connection"
            java.lang.Object r1 = r4.get(r1)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r1 = r1.toLowerCase(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "upgrade"
            boolean r1 = r1.equals(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            if (r1 != 0) goto L_0x019d
            com.google.android.gms.internal.firebase_database.zzjx r1 = new com.google.android.gms.internal.firebase_database.zzjx     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.String r2 = "connection failed: missing header field in server handshake: Connection"
            r1.<init>(r2)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            throw r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
        L_0x019d:
            com.google.android.gms.internal.firebase_database.zzkb r1 = r12.zztf     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.zza((java.io.OutputStream) r8)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzka r1 = r12.zzte     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.zza(r7)     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            int r1 = com.google.android.gms.internal.firebase_database.zzjv.zztp     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r12.zzta = r1     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzkb r1 = r12.zztf     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            java.lang.Thread r1 = r1.zzgt()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.start()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzjw r1 = r12.zztc     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.zzav()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            com.google.android.gms.internal.firebase_database.zzka r1 = r12.zzte     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r1.run()     // Catch:{ zzjx -> 0x0028, IOException -> 0x0066 }
            r12.close()
            goto L_0x001d
        L_0x01c3:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x00c1 }
            r2.<init>(r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x007f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_database.zzjr.zzgn():void");
    }

    public final synchronized void close() {
        switch (zzju.zztm[this.zzta - 1]) {
            case 1:
                this.zzta = zzjv.zztr;
                break;
            case 2:
                zzgl();
                break;
            case 3:
                try {
                    this.zzta = zzjv.zztq;
                    this.zztf.zzgr();
                    this.zztf.zza((byte) 8, true, new byte[0]);
                    break;
                } catch (IOException e) {
                    this.zztc.zza(new zzjx("Failed to send close frame", e));
                    break;
                }
        }
        return;
    }

    public final synchronized void connect() {
        if (this.zzta != zzjv.zztn) {
            this.zztc.zza(new zzjx("connect() already called"));
            close();
        } else {
            zztk.zza(this.zzti, new StringBuilder(26).append("TubeSockReader-").append(this.zzth).toString());
            this.zzta = zzjv.zzto;
            this.zzti.start();
        }
    }

    public final void zza(zzjw zzjw) {
        this.zztc = zzjw;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjx zzjx) {
        this.zztc.zza(zzjx);
        if (this.zzta == zzjv.zztp) {
            close();
        }
        zzgl();
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(byte[] bArr) {
        zza((byte) 10, bArr);
    }

    /* access modifiers changed from: package-private */
    public final zzjw zzgj() {
        return this.zztc;
    }

    /* access modifiers changed from: package-private */
    public final void zzgk() {
        zzgl();
    }

    public final void zzgm() throws InterruptedException {
        if (this.zztf.zzgt().getState() != Thread.State.NEW) {
            this.zztf.zzgt().join();
        }
        this.zzti.join();
    }

    public final synchronized void zzm(String str) {
        zza((byte) 1, str.getBytes(zzsz));
    }
}
