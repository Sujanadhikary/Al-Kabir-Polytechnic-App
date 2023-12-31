package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

public final class zzxd {
    private static final zzxe zzbnx;
    private static final int zzbny;

    static final class zza extends zzxe {
        zza() {
        }

        public final void zza(Throwable th, PrintStream printStream) {
            th.printStackTrace(printStream);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0019  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    static {
        /*
            r2 = 1
            r1 = 0
            java.lang.Integer r0 = zzsd()     // Catch:{ Throwable -> 0x0075 }
            if (r0 == 0) goto L_0x001d
            int r1 = r0.intValue()     // Catch:{ Throwable -> 0x002e }
            r3 = 19
            if (r1 < r3) goto L_0x001d
            com.google.android.gms.internal.measurement.zzxi r1 = new com.google.android.gms.internal.measurement.zzxi     // Catch:{ Throwable -> 0x002e }
            r1.<init>()     // Catch:{ Throwable -> 0x002e }
        L_0x0015:
            zzbnx = r1
            if (r0 != 0) goto L_0x0070
            r0 = r2
        L_0x001a:
            zzbny = r0
            return
        L_0x001d:
            java.lang.String r1 = "com.google.devtools.build.android.desugar.runtime.twr_disable_mimic"
            boolean r1 = java.lang.Boolean.getBoolean(r1)     // Catch:{ Throwable -> 0x002e }
            if (r1 != 0) goto L_0x0068
            r1 = r2
        L_0x0026:
            if (r1 == 0) goto L_0x006a
            com.google.android.gms.internal.measurement.zzxh r1 = new com.google.android.gms.internal.measurement.zzxh     // Catch:{ Throwable -> 0x002e }
            r1.<init>()     // Catch:{ Throwable -> 0x002e }
            goto L_0x0015
        L_0x002e:
            r1 = move-exception
        L_0x002f:
            java.io.PrintStream r3 = java.lang.System.err
            java.lang.Class<com.google.android.gms.internal.measurement.zzxd$zza> r4 = com.google.android.gms.internal.measurement.zzxd.zza.class
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = java.lang.String.valueOf(r4)
            int r5 = r5.length()
            int r5 = r5 + 132
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "An error has occured when initializing the try-with-resources desuguring strategy. The default strategy "
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r5 = "will be used. The error is: "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
            java.io.PrintStream r3 = java.lang.System.err
            r1.printStackTrace(r3)
            com.google.android.gms.internal.measurement.zzxd$zza r1 = new com.google.android.gms.internal.measurement.zzxd$zza
            r1.<init>()
            goto L_0x0015
        L_0x0068:
            r1 = 0
            goto L_0x0026
        L_0x006a:
            com.google.android.gms.internal.measurement.zzxd$zza r1 = new com.google.android.gms.internal.measurement.zzxd$zza     // Catch:{ Throwable -> 0x002e }
            r1.<init>()     // Catch:{ Throwable -> 0x002e }
            goto L_0x0015
        L_0x0070:
            int r0 = r0.intValue()
            goto L_0x001a
        L_0x0075:
            r0 = move-exception
            r7 = r0
            r0 = r1
            r1 = r7
            goto L_0x002f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzxd.<clinit>():void");
    }

    public static void zza(Throwable th, PrintStream printStream) {
        zzbnx.zza(th, printStream);
    }

    private static Integer zzsd() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get((Object) null);
        } catch (Exception e) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e.printStackTrace(System.err);
            return null;
        }
    }
}
