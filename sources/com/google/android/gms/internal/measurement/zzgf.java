package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.support.annotation.WorkerThread;
import android.support.p000v4.internal.view.SupportMenu;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.Map;

public final class zzgf extends zzjq implements zzeh {
    @VisibleForTesting
    private static int zzalf = SupportMenu.USER_MASK;
    @VisibleForTesting
    private static int zzalg = 2;
    private final Map<String, Map<String, String>> zzalh = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzali = new ArrayMap();
    private final Map<String, Map<String, Boolean>> zzalj = new ArrayMap();
    private final Map<String, zzkk> zzalk = new ArrayMap();
    private final Map<String, Map<String, Integer>> zzall = new ArrayMap();
    private final Map<String, String> zzalm = new ArrayMap();

    zzgf(zzjr zzjr) {
        super(zzjr);
    }

    @WorkerThread
    private final zzkk zza(String str, byte[] bArr) {
        if (bArr == null) {
            return new zzkk();
        }
        zzabv zza = zzabv.zza(bArr, 0, bArr.length);
        zzkk zzkk = new zzkk();
        try {
            zzkk.zzb(zza);
            zzge().zzit().zze("Parsed config. version, gmp_app_id", zzkk.zzasp, zzkk.zzadm);
            return zzkk;
        } catch (IOException e) {
            zzge().zzip().zze("Unable to merge remote config. appId", zzfg.zzbm(str), e);
            return new zzkk();
        }
    }

    private static Map<String, String> zza(zzkk zzkk) {
        ArrayMap arrayMap = new ArrayMap();
        if (!(zzkk == null || zzkk.zzasr == null)) {
            for (zzkl zzkl : zzkk.zzasr) {
                if (zzkl != null) {
                    arrayMap.put(zzkl.zzny, zzkl.value);
                }
            }
        }
        return arrayMap;
    }

    private final void zza(String str, zzkk zzkk) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        if (!(zzkk == null || zzkk.zzass == null)) {
            for (zzkj zzkj : zzkk.zzass) {
                if (TextUtils.isEmpty(zzkj.name)) {
                    zzge().zzip().log("EventConfig contained null event name");
                } else {
                    String zzak = AppMeasurement.Event.zzak(zzkj.name);
                    if (!TextUtils.isEmpty(zzak)) {
                        zzkj.name = zzak;
                    }
                    arrayMap.put(zzkj.name, zzkj.zzasm);
                    arrayMap2.put(zzkj.name, zzkj.zzasn);
                    if (zzkj.zzaso != null) {
                        if (zzkj.zzaso.intValue() < zzalg || zzkj.zzaso.intValue() > zzalf) {
                            zzge().zzip().zze("Invalid sampling rate. Event name, sample rate", zzkj.name, zzkj.zzaso);
                        } else {
                            arrayMap3.put(zzkj.name, zzkj.zzaso);
                        }
                    }
                }
            }
        }
        this.zzali.put(str, arrayMap);
        this.zzalj.put(str, arrayMap2);
        this.zzall.put(str, arrayMap3);
    }

    @WorkerThread
    private final void zzbt(String str) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        if (this.zzalk.get(str) == null) {
            byte[] zzbe = zzix().zzbe(str);
            if (zzbe == null) {
                this.zzalh.put(str, (Object) null);
                this.zzali.put(str, (Object) null);
                this.zzalj.put(str, (Object) null);
                this.zzalk.put(str, (Object) null);
                this.zzalm.put(str, (Object) null);
                this.zzall.put(str, (Object) null);
                return;
            }
            zzkk zza = zza(str, zzbe);
            this.zzalh.put(str, zza(zza));
            zza(str, zza);
            this.zzalk.put(str, zza);
            this.zzalm.put(str, (Object) null);
        }
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final boolean zza(String str, byte[] bArr, String str2) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzkk zza = zza(str, bArr);
        if (zza == null) {
            return false;
        }
        zza(str, zza);
        this.zzalk.put(str, zza);
        this.zzalm.put(str, str2);
        this.zzalh.put(str, zza(zza));
        zzeb zziw = zziw();
        zzkd[] zzkdArr = zza.zzast;
        Preconditions.checkNotNull(zzkdArr);
        for (zzkd zzkd : zzkdArr) {
            for (zzke zzke : zzkd.zzarn) {
                String zzak = AppMeasurement.Event.zzak(zzke.zzarq);
                if (zzak != null) {
                    zzke.zzarq = zzak;
                }
                for (zzkf zzkf : zzke.zzarr) {
                    String zzak2 = AppMeasurement.Param.zzak(zzkf.zzary);
                    if (zzak2 != null) {
                        zzkf.zzary = zzak2;
                    }
                }
            }
            for (zzkh zzkh : zzkd.zzarm) {
                String zzak3 = AppMeasurement.UserProperty.zzak(zzkh.zzasf);
                if (zzak3 != null) {
                    zzkh.zzasf = zzak3;
                }
            }
        }
        zziw.zzix().zza(str, zzkdArr);
        try {
            zza.zzast = null;
            byte[] bArr2 = new byte[zza.zzvm()];
            zza.zza(zzabw.zzb(bArr2, 0, bArr2.length));
            bArr = bArr2;
        } catch (IOException e) {
            zzge().zzip().zze("Unable to serialize reduced-size config. Storing full config instead. appId", zzfg.zzbm(str), e);
        }
        zzei zzix = zzix();
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) zzix.getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzix.zzge().zzim().zzg("Failed to update remote config (got 0). appId", zzfg.zzbm(str));
            }
        } catch (SQLiteException e2) {
            zzix.zzge().zzim().zze("Error storing remote config. appId", zzfg.zzbm(str), e2);
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final zzkk zzbu(String str) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        zzbt(str);
        return this.zzalk.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzbv(String str) {
        zzab();
        return this.zzalm.get(str);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zzbw(String str) {
        zzab();
        this.zzalm.put(str, (Object) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzbx(String str) {
        zzab();
        this.zzalk.remove(str);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzby(String str) {
        return "1".equals(zze(str, "measurement.upload.blacklist_internal"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzbz(String str) {
        return "1".equals(zze(str, "measurement.upload.blacklist_public"));
    }

    @WorkerThread
    public final String zze(String str, String str2) {
        zzab();
        zzbt(str);
        Map map = this.zzalh.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
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

    public final /* bridge */ /* synthetic */ zzeb zziw() {
        return super.zziw();
    }

    public final /* bridge */ /* synthetic */ zzei zzix() {
        return super.zzix();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzn(String str, String str2) {
        zzab();
        zzbt(str);
        if (zzby(str) && zzka.zzci(str2)) {
            return true;
        }
        if (zzbz(str) && zzka.zzcc(str2)) {
            return true;
        }
        Map map = this.zzali.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzo(String str, String str2) {
        zzab();
        zzbt(str);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(str2)) {
            return true;
        }
        Map map = this.zzalj.get(str);
        if (map == null) {
            return false;
        }
        Boolean bool = (Boolean) map.get(str2);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final int zzp(String str, String str2) {
        zzab();
        zzbt(str);
        Map map = this.zzall.get(str);
        if (map == null) {
            return 1;
        }
        Integer num = (Integer) map.get(str2);
        if (num == null) {
            return 1;
        }
        return num.intValue();
    }
}
