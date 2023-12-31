package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.InvocationTargetException;

public final class zzef extends zzhg {
    @NonNull
    private zzeh zzaet = zzeg.zzaeu;
    private Boolean zzxz;

    zzef(zzgl zzgl) {
        super(zzgl);
    }

    public static long zzhh() {
        return zzew.zzahl.get().longValue();
    }

    public static long zzhi() {
        return zzew.zzagl.get().longValue();
    }

    public static boolean zzhk() {
        return zzew.zzagh.get().booleanValue();
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final long zza(String str, @NonNull zzex<Long> zzex) {
        if (str == null) {
            return zzex.get().longValue();
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            return zzex.get().longValue();
        }
        try {
            return zzex.get(Long.valueOf(Long.parseLong(zze))).longValue();
        } catch (NumberFormatException e) {
            return zzex.get().longValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(@NonNull zzeh zzeh) {
        this.zzaet = zzeh;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    @WorkerThread
    public final int zzar(@Size(min = 1) String str) {
        return zzb(str, zzew.zzagw);
    }

    /* access modifiers changed from: package-private */
    @Nullable
    @VisibleForTesting
    public final Boolean zzas(@Size(min = 1) String str) {
        Preconditions.checkNotEmpty(str);
        try {
            if (getContext().getPackageManager() == null) {
                zzge().zzim().log("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(getContext().getPackageName(), 128);
            if (applicationInfo == null) {
                zzge().zzim().log("Failed to load metadata: ApplicationInfo is null");
                return null;
            } else if (applicationInfo.metaData == null) {
                zzge().zzim().log("Failed to load metadata: Metadata bundle is null");
                return null;
            } else if (applicationInfo.metaData.containsKey(str)) {
                return Boolean.valueOf(applicationInfo.metaData.getBoolean(str));
            } else {
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            zzge().zzim().zzg("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final boolean zzat(String str) {
        return "1".equals(this.zzaet.zze(str, "gaia_collection_enabled"));
    }

    public final boolean zzau(String str) {
        return "1".equals(this.zzaet.zze(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzav(String str) {
        return zzd(str, zzew.zzahu);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzaw(String str) {
        return zzd(str, zzew.zzahw);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzax(String str) {
        return zzd(str, zzew.zzahx);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzay(String str) {
        return zzd(str, zzew.zzahy);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzaz(String str) {
        return zzd(str, zzew.zzahz);
    }

    @WorkerThread
    public final int zzb(String str, @NonNull zzex<Integer> zzex) {
        if (str == null) {
            return zzex.get().intValue();
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            return zzex.get().intValue();
        }
        try {
            return zzex.get(Integer.valueOf(Integer.parseInt(zze))).intValue();
        } catch (NumberFormatException e) {
            return zzex.get().intValue();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzba(String str) {
        return zzd(str, zzew.zzaic);
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    @WorkerThread
    public final double zzc(String str, @NonNull zzex<Double> zzex) {
        if (str == null) {
            return zzex.get().doubleValue();
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        if (TextUtils.isEmpty(zze)) {
            return zzex.get().doubleValue();
        }
        try {
            return zzex.get(Double.valueOf(Double.parseDouble(zze))).doubleValue();
        } catch (NumberFormatException e) {
            return zzex.get().doubleValue();
        }
    }

    @WorkerThread
    public final boolean zzd(String str, @NonNull zzex<Boolean> zzex) {
        if (str == null) {
            return zzex.get().booleanValue();
        }
        String zze = this.zzaet.zze(str, zzex.getKey());
        return TextUtils.isEmpty(zze) ? zzex.get().booleanValue() : zzex.get(Boolean.valueOf(Boolean.parseBoolean(zze))).booleanValue();
    }

    public final boolean zzds() {
        if (this.zzxz == null) {
            synchronized (this) {
                if (this.zzxz == null) {
                    ApplicationInfo applicationInfo = getContext().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzxz = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzxz == null) {
                        this.zzxz = Boolean.TRUE;
                        zzge().zzim().log("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzxz.booleanValue();
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

    public final boolean zzhg() {
        Boolean zzas = zzas("firebase_analytics_collection_deactivated");
        return zzas != null && zzas.booleanValue();
    }

    public final String zzhj() {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{"debug.firebase.analytics.app", ""});
        } catch (ClassNotFoundException e) {
            zzge().zzim().zzg("Could not find SystemProperties class", e);
        } catch (NoSuchMethodException e2) {
            zzge().zzim().zzg("Could not find SystemProperties.get() method", e2);
        } catch (IllegalAccessException e3) {
            zzge().zzim().zzg("Could not access SystemProperties.get()", e3);
        } catch (InvocationTargetException e4) {
            zzge().zzim().zzg("SystemProperties.get() threw an exception", e4);
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzhl() {
        return zzd(zzfv().zzah(), zzew.zzahp);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzhm() {
        String zzah = zzfv().zzah();
        zzex<String> zzex = zzew.zzahq;
        return zzah == null ? zzex.get() : zzex.get(this.zzaet.zze(zzah, zzex.getKey()));
    }
}
