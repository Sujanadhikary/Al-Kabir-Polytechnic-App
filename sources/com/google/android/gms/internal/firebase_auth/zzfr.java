package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

abstract class zzfr<T, B> {
    zzfr() {
    }

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, zzbu zzbu);

    /* access modifiers changed from: package-private */
    public abstract void zza(B b, int i, T t);

    /* access modifiers changed from: package-private */
    public abstract void zza(T t, zzgl zzgl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract boolean zza(zzew zzew);

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0039 A[LOOP:0: B:9:0x0039->B:12:0x0046, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(B r7, com.google.android.gms.internal.firebase_auth.zzew r8) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            int r1 = r8.getTag()
            int r2 = r1 >>> 3
            r1 = r1 & 7
            switch(r1) {
                case 0: goto L_0x0011;
                case 1: goto L_0x0021;
                case 2: goto L_0x0029;
                case 3: goto L_0x0031;
                case 4: goto L_0x005b;
                case 5: goto L_0x0019;
                default: goto L_0x000c;
            }
        L_0x000c:
            com.google.android.gms.internal.firebase_auth.zzdi r0 = com.google.android.gms.internal.firebase_auth.zzdh.zzef()
            throw r0
        L_0x0011:
            long r4 = r8.zzcb()
            r6.zza(r7, (int) r2, (long) r4)
        L_0x0018:
            return r0
        L_0x0019:
            int r1 = r8.zzce()
            r6.zzc(r7, r2, r1)
            goto L_0x0018
        L_0x0021:
            long r4 = r8.zzcd()
            r6.zzb(r7, r2, r4)
            goto L_0x0018
        L_0x0029:
            com.google.android.gms.internal.firebase_auth.zzbu r1 = r8.zzch()
            r6.zza(r7, (int) r2, (com.google.android.gms.internal.firebase_auth.zzbu) r1)
            goto L_0x0018
        L_0x0031:
            java.lang.Object r1 = r6.zzgq()
            int r3 = r2 << 3
            r3 = r3 | 4
        L_0x0039:
            int r4 = r8.zzcx()
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0048
            boolean r4 = r6.zza(r1, (com.google.android.gms.internal.firebase_auth.zzew) r8)
            if (r4 != 0) goto L_0x0039
        L_0x0048:
            int r4 = r8.getTag()
            if (r3 == r4) goto L_0x0053
            com.google.android.gms.internal.firebase_auth.zzdh r0 = com.google.android.gms.internal.firebase_auth.zzdh.zzee()
            throw r0
        L_0x0053:
            java.lang.Object r1 = r6.zzl(r1)
            r6.zza(r7, (int) r2, r1)
            goto L_0x0018
        L_0x005b:
            r0 = 0
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzfr.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzew):boolean");
    }

    /* access modifiers changed from: package-private */
    public abstract void zzb(B b, int i, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzc(B b, int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzc(T t, zzgl zzgl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj);

    /* access modifiers changed from: package-private */
    public abstract void zze(Object obj, T t);

    /* access modifiers changed from: package-private */
    public abstract void zzf(Object obj, B b);

    /* access modifiers changed from: package-private */
    public abstract T zzg(T t, T t2);

    /* access modifiers changed from: package-private */
    public abstract B zzgq();

    /* access modifiers changed from: package-private */
    public abstract T zzl(B b);

    /* access modifiers changed from: package-private */
    public abstract int zzo(T t);

    /* access modifiers changed from: package-private */
    public abstract T zzr(Object obj);

    /* access modifiers changed from: package-private */
    public abstract B zzs(Object obj);

    /* access modifiers changed from: package-private */
    public abstract int zzt(T t);
}
