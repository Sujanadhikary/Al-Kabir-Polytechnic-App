package com.google.android.gms.common.logging;

import android.annotation.SuppressLint;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.GmsLogger;
import java.util.Locale;

public class Logger {
    private final String mTag;
    private final String zzud;
    private final GmsLogger zzvd;
    private final int zzve;

    private Logger(String str, String str2) {
        this.zzud = str2;
        this.mTag = str;
        this.zzvd = new GmsLogger(str);
        int i = 2;
        while (7 >= i && !Log.isLoggable(this.mTag, i)) {
            i++;
        }
        this.zzve = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Logger(java.lang.String r7, java.lang.String... r8) {
        /*
            r6 = this;
            int r0 = r8.length
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
        L_0x0005:
            r6.<init>((java.lang.String) r7, (java.lang.String) r0)
            return
        L_0x0009:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r0 = 91
            r1.append(r0)
            int r2 = r8.length
            r0 = 0
        L_0x0015:
            if (r0 >= r2) goto L_0x002b
            r3 = r8[r0]
            int r4 = r1.length()
            r5 = 1
            if (r4 <= r5) goto L_0x0025
            java.lang.String r4 = ","
            r1.append(r4)
        L_0x0025:
            r1.append(r3)
            int r0 = r0 + 1
            goto L_0x0015
        L_0x002b:
            r0 = 93
            java.lang.StringBuilder r0 = r1.append(r0)
            r2 = 32
            r0.append(r2)
            java.lang.String r0 = r1.toString()
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.logging.Logger.<init>(java.lang.String, java.lang.String[]):void");
    }

    /* renamed from: d */
    public void mo8033d(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr), th);
        }
    }

    /* renamed from: d */
    public void mo8034d(String str, @Nullable Object... objArr) {
        if (isLoggable(3)) {
            Log.d(this.mTag, format(str, objArr));
        }
    }

    /* renamed from: e */
    public void mo8035e(String str, Throwable th, @Nullable Object... objArr) {
        Log.e(this.mTag, format(str, objArr), th);
    }

    /* renamed from: e */
    public void mo8036e(String str, @Nullable Object... objArr) {
        Log.e(this.mTag, format(str, objArr));
    }

    public String elidePii(Object obj) {
        boolean canLogPii = this.zzvd.canLogPii();
        if (obj == null) {
            return "<NULL>";
        }
        String trim = obj.toString().trim();
        if (trim.isEmpty()) {
            return "<EMPTY>";
        }
        if (canLogPii) {
            return trim;
        }
        return String.format("<ELLIDED:%s>", new Object[]{Integer.valueOf(trim.hashCode())});
    }

    /* access modifiers changed from: protected */
    public String format(String str, @Nullable Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            str = String.format(Locale.US, str, objArr);
        }
        return this.zzud.concat(str);
    }

    public String getTag() {
        return this.mTag;
    }

    /* renamed from: i */
    public void mo8040i(String str, Throwable th, @Nullable Object... objArr) {
        Log.i(this.mTag, format(str, objArr), th);
    }

    /* renamed from: i */
    public void mo8041i(String str, @Nullable Object... objArr) {
        Log.i(this.mTag, format(str, objArr));
    }

    public boolean isLoggable(int i) {
        return this.zzve <= i;
    }

    public boolean isPiiLoggable() {
        return this.zzvd.canLogPii();
    }

    /* renamed from: v */
    public void mo8044v(String str, Throwable th, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr), th);
        }
    }

    /* renamed from: v */
    public void mo8045v(String str, @Nullable Object... objArr) {
        if (isLoggable(2)) {
            Log.v(this.mTag, format(str, objArr));
        }
    }

    /* renamed from: w */
    public void mo8046w(String str, Throwable th, @Nullable Object... objArr) {
        Log.w(this.mTag, format(str, objArr), th);
    }

    /* renamed from: w */
    public void mo8047w(String str, @Nullable Object... objArr) {
        Log.w(this.mTag, format(str, objArr));
    }

    /* renamed from: w */
    public void mo8048w(Throwable th) {
        Log.w(this.mTag, th);
    }

    public void wtf(String str, Throwable th, @Nullable Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr), th);
    }

    @SuppressLint({"WtfWithoutException"})
    public void wtf(String str, @Nullable Object... objArr) {
        Log.wtf(this.mTag, format(str, objArr));
    }

    public void wtf(Throwable th) {
        Log.wtf(this.mTag, th);
    }
}
