package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.p000v4.p002os.EnvironmentCompat;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.GoogleServices;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.wrappers.InstantApps;
import com.google.firebase.iid.FirebaseInstanceId;
import java.math.BigInteger;
import java.util.Locale;

public final class zzfb extends zzhh {
    private String zzadm;
    private String zzadt;
    private long zzadx;
    private int zzaen;
    private int zzaie;
    private long zzaif;
    private String zztg;
    private String zzth;
    private String zzti;

    zzfb(zzgl zzgl) {
        super(zzgl);
    }

    @WorkerThread
    private final String zzgj() {
        zzab();
        if (zzgg().zzay(this.zzti) && !this.zzacw.isEnabled()) {
            return null;
        }
        try {
            return FirebaseInstanceId.getInstance().getId();
        } catch (IllegalStateException e) {
            zzge().zzip().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: package-private */
    public final String getGmpAppId() {
        zzch();
        return this.zzadm;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    /* access modifiers changed from: package-private */
    public final String zzah() {
        zzch();
        return this.zzti;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzdz zzbi(String str) {
        zzab();
        String zzah = zzah();
        String gmpAppId = getGmpAppId();
        zzch();
        String str2 = this.zzth;
        long zzij = (long) zzij();
        zzch();
        String str3 = this.zzadt;
        zzch();
        zzab();
        if (this.zzaif == 0) {
            this.zzaif = this.zzacw.zzgb().zzd(getContext(), getContext().getPackageName());
        }
        long j = this.zzaif;
        boolean isEnabled = this.zzacw.isEnabled();
        boolean z = !zzgf().zzakn;
        String zzgj = zzgj();
        zzch();
        long zzjt = this.zzacw.zzjt();
        int zzik = zzik();
        Boolean zzas = zzgg().zzas("google_analytics_adid_collection_enabled");
        boolean booleanValue = Boolean.valueOf(zzas == null || zzas.booleanValue()).booleanValue();
        Boolean zzas2 = zzgg().zzas("google_analytics_ssaid_collection_enabled");
        return new zzdz(zzah, gmpAppId, str2, zzij, str3, 12451, j, str, isEnabled, z, zzgj, 0, zzjt, zzik, booleanValue, Boolean.valueOf(zzas2 == null || zzas2.booleanValue()).booleanValue(), zzgf().zzje());
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
        return true;
    }

    /* access modifiers changed from: protected */
    public final void zzih() {
        boolean z;
        int i = 1;
        String str = EnvironmentCompat.MEDIA_UNKNOWN;
        String str2 = "Unknown";
        int i2 = Integer.MIN_VALUE;
        String str3 = "Unknown";
        String packageName = getContext().getPackageName();
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzge().zzim().zzg("PackageManager is null, app identity information might be inaccurate. appId", zzfg.zzbm(packageName));
        } else {
            try {
                str = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException e) {
                zzge().zzim().zzg("Error retrieving app installer package name. appId", zzfg.zzbm(packageName));
            }
            if (str == null) {
                str = "manual_install";
            } else if ("com.android.vending".equals(str)) {
                str = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(getContext().getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        str3 = applicationLabel.toString();
                    }
                    str2 = packageInfo.versionName;
                    i2 = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                zzge().zzim().zze("Error retrieving package info. appId, appName", zzfg.zzbm(packageName), str3);
            }
        }
        this.zzti = packageName;
        this.zzadt = str;
        this.zzth = str2;
        this.zzaie = i2;
        this.zztg = str3;
        this.zzaif = 0;
        Status initialize = GoogleServices.initialize(getContext());
        boolean z2 = initialize != null && initialize.isSuccess();
        if (!z2) {
            if (initialize == null) {
                zzge().zzim().log("GoogleService failed to initialize (no status)");
            } else {
                zzge().zzim().zze("GoogleService failed to initialize, status", Integer.valueOf(initialize.getStatusCode()), initialize.getStatusMessage());
            }
        }
        if (z2) {
            Boolean zzas = zzgg().zzas("firebase_analytics_collection_enabled");
            if (zzgg().zzhg()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_deactivated=1");
                z = false;
            } else if (zzas != null && !zzas.booleanValue()) {
                zzge().zzir().log("Collection disabled with firebase_analytics_collection_enabled=0");
                z = false;
            } else if (zzas != null || !GoogleServices.isMeasurementExplicitlyDisabled()) {
                zzge().zzit().log("Collection enabled");
                z = true;
            } else {
                zzge().zzir().log("Collection disabled with google_app_measurement_enable=0");
                z = false;
            }
        } else {
            z = false;
        }
        this.zzadm = "";
        this.zzadx = 0;
        try {
            String googleAppId = GoogleServices.getGoogleAppId();
            if (TextUtils.isEmpty(googleAppId)) {
                googleAppId = "";
            }
            this.zzadm = googleAppId;
            if (z) {
                zzge().zzit().zze("App package, google app id", this.zzti, this.zzadm);
            }
        } catch (IllegalStateException e3) {
            zzge().zzim().zze("getGoogleAppId or isMeasurementEnabled failed with exception. appId", zzfg.zzbm(packageName), e3);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            if (!InstantApps.isInstantApp(getContext())) {
                i = 0;
            }
            this.zzaen = i;
            return;
        }
        this.zzaen = 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzii() {
        byte[] bArr = new byte[16];
        zzgb().zzlc().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final int zzij() {
        zzch();
        return this.zzaie;
    }

    /* access modifiers changed from: package-private */
    public final int zzik() {
        zzch();
        return this.zzaen;
    }
}
