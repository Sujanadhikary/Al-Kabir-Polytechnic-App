package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.support.annotation.GuardedBy;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzfg extends zzhh {
    /* access modifiers changed from: private */
    public long zzadu = -1;
    /* access modifiers changed from: private */
    public char zzaim = 0;
    @GuardedBy("this")
    private String zzain;
    private final zzfi zzaio = new zzfi(this, 6, false, false);
    private final zzfi zzaip = new zzfi(this, 6, true, false);
    private final zzfi zzaiq = new zzfi(this, 6, false, true);
    private final zzfi zzair = new zzfi(this, 5, false, false);
    private final zzfi zzais = new zzfi(this, 5, true, false);
    private final zzfi zzait = new zzfi(this, 5, false, true);
    private final zzfi zzaiu = new zzfi(this, 4, false, false);
    private final zzfi zzaiv = new zzfi(this, 3, false, false);
    private final zzfi zzaiw = new zzfi(this, 2, false, false);

    zzfg(zzgl zzgl) {
        super(zzgl);
    }

    @VisibleForTesting
    private static String zza(boolean z, Object obj) {
        StackTraceElement stackTraceElement;
        String className;
        if (obj == null) {
            return "";
        }
        Object valueOf = obj instanceof Integer ? Long.valueOf((long) ((Integer) obj).intValue()) : obj;
        if (valueOf instanceof Long) {
            if (!z) {
                return String.valueOf(valueOf);
            }
            if (Math.abs(((Long) valueOf).longValue()) < 100) {
                return String.valueOf(valueOf);
            }
            String str = String.valueOf(valueOf).charAt(0) == '-' ? "-" : "";
            String valueOf2 = String.valueOf(Math.abs(((Long) valueOf).longValue()));
            return new StringBuilder(String.valueOf(str).length() + 43 + String.valueOf(str).length()).append(str).append(Math.round(Math.pow(10.0d, (double) (valueOf2.length() - 1)))).append("...").append(str).append(Math.round(Math.pow(10.0d, (double) valueOf2.length()) - 1.0d)).toString();
        } else if (valueOf instanceof Boolean) {
            return String.valueOf(valueOf);
        } else {
            if (!(valueOf instanceof Throwable)) {
                return valueOf instanceof zzfj ? ((zzfj) valueOf).zzajf : z ? "-" : String.valueOf(valueOf);
            }
            Throwable th = (Throwable) valueOf;
            StringBuilder sb = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String zzbn = zzbn(AppMeasurement.class.getCanonicalName());
            String zzbn2 = zzbn(zzgl.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                    String zzbn3 = zzbn(className);
                    if (zzbn3.equals(zzbn) || zzbn3.equals(zzbn2)) {
                        sb.append(": ");
                        sb.append(stackTraceElement);
                    }
                }
                i++;
            }
            sb.append(": ");
            sb.append(stackTraceElement);
            return sb.toString();
        }
    }

    static String zza(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String zza = zza(z, obj);
        String zza2 = zza(z, obj2);
        String zza3 = zza(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(zza)) {
            sb.append(str2);
            sb.append(zza);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza2)) {
            sb.append(str2);
            sb.append(zza2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(zza3)) {
            sb.append(str2);
            sb.append(zza3);
        }
        return sb.toString();
    }

    protected static Object zzbm(String str) {
        if (str == null) {
            return null;
        }
        return new zzfj(str);
    }

    private static String zzbn(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf != -1 ? str.substring(0, lastIndexOf) : str;
    }

    private final String zziu() {
        String str;
        synchronized (this) {
            if (this.zzain == null) {
                this.zzain = zzew.zzagi.get();
            }
            str = this.zzain;
        }
        return str;
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean isLoggable(int i) {
        return Log.isLoggable(zziu(), i);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(int i, String str) {
        Log.println(i, zziu(), str);
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        int i2 = 0;
        if (!z && isLoggable(i)) {
            zza(i, zza(false, str, obj, obj2, obj3));
        }
        if (!z2 && i >= 5) {
            Preconditions.checkNotNull(str);
            zzgg zzjq = this.zzacw.zzjq();
            if (zzjq == null) {
                zza(6, "Scheduler not set. Not logging error/warn");
            } else if (!zzjq.isInitialized()) {
                zza(6, "Scheduler not initialized. Not logging error/warn");
            } else {
                if (i >= 0) {
                    i2 = i;
                }
                if (i2 >= 9) {
                    i2 = 8;
                }
                zzjq.zzc((Runnable) new zzfh(this, i2, str, obj, obj2, obj3));
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final /* bridge */ /* synthetic */ void zzfr() {
        super.zzfr();
    }

    public final /* bridge */ /* synthetic */ void zzfs() {
        super.zzfs();
    }

    public final /* bridge */ /* synthetic */ zzdu zzft() {
        return super.zzft();
    }

    public final /* bridge */ /* synthetic */ zzhk zzfu() {
        return super.zzfu();
    }

    public final /* bridge */ /* synthetic */ zzfb zzfv() {
        return super.zzfv();
    }

    public final /* bridge */ /* synthetic */ zzeo zzfw() {
        return super.zzfw();
    }

    public final /* bridge */ /* synthetic */ zzii zzfx() {
        return super.zzfx();
    }

    public final /* bridge */ /* synthetic */ zzif zzfy() {
        return super.zzfy();
    }

    public final /* bridge */ /* synthetic */ zzfc zzfz() {
        return super.zzfz();
    }

    public final /* bridge */ /* synthetic */ zzfe zzga() {
        return super.zzga();
    }

    public final /* bridge */ /* synthetic */ zzka zzgb() {
        return super.zzgb();
    }

    public final /* bridge */ /* synthetic */ zzjh zzgc() {
        return super.zzgc();
    }

    public final /* bridge */ /* synthetic */ zzgg zzgd() {
        return super.zzgd();
    }

    public final /* bridge */ /* synthetic */ zzfg zzge() {
        return super.zzge();
    }

    public final /* bridge */ /* synthetic */ zzfr zzgf() {
        return super.zzgf();
    }

    public final /* bridge */ /* synthetic */ zzef zzgg() {
        return super.zzgg();
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    public final zzfi zzim() {
        return this.zzaio;
    }

    public final zzfi zzin() {
        return this.zzaip;
    }

    public final zzfi zzio() {
        return this.zzaiq;
    }

    public final zzfi zzip() {
        return this.zzair;
    }

    public final zzfi zziq() {
        return this.zzait;
    }

    public final zzfi zzir() {
        return this.zzaiu;
    }

    public final zzfi zzis() {
        return this.zzaiv;
    }

    public final zzfi zzit() {
        return this.zzaiw;
    }

    public final String zziv() {
        Pair<String, Long> zzfi = zzgf().zzajt.zzfi();
        if (zzfi == null || zzfi == zzfr.zzajs) {
            return null;
        }
        String valueOf = String.valueOf(zzfi.second);
        String str = (String) zzfi.first;
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length()).append(valueOf).append(":").append(str).toString();
    }
}
