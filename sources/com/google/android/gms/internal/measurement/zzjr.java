package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzjr implements zzec {
    private zzgl zzacw;
    zzgf zzaqa;
    zzfk zzaqb;
    private zzei zzaqc;
    private zzfp zzaqd;
    private zzjn zzaqe;
    private zzeb zzaqf;
    private boolean zzaqg;
    @VisibleForTesting
    private long zzaqh;
    private List<Runnable> zzaqi;
    private int zzaqj;
    private int zzaqk;
    private boolean zzaql;
    private boolean zzaqm;
    private boolean zzaqn;
    private FileLock zzaqo;
    private FileChannel zzaqp;
    private List<Long> zzaqq;
    private List<Long> zzaqr;
    long zzaqs;
    private boolean zzvo = false;

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            } else if (read == -1) {
                return 0;
            } else {
                zzge().zzip().zzg("Unexpected data length. Bytes read", Integer.valueOf(read));
                return 0;
            }
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to read from channel", e);
            return 0;
        }
    }

    private final zzdz zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j) {
        String str3;
        String str4 = "Unknown";
        String str5 = "Unknown";
        int i = Integer.MIN_VALUE;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            zzge().zzim().log("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException e) {
            zzge().zzim().zzg("Error retrieving installer package name. appId", zzfg.zzbm(str));
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                str3 = !TextUtils.isEmpty(applicationLabel) ? applicationLabel.toString() : "Unknown";
                try {
                    str5 = packageInfo.versionName;
                    i = packageInfo.versionCode;
                } catch (PackageManager.NameNotFoundException e2) {
                    zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), str3);
                    return null;
                }
            }
            long j2 = 0;
            if (zzgg().zzba(str)) {
                j2 = j;
            }
            return new zzdz(str, str2, str5, (long) i, str4, 12451, zzgb().zzd(context, str), (String) null, z, false, "", 0, j2, 0, z2, z3, false);
        } catch (PackageManager.NameNotFoundException e3) {
            str3 = "Unknown";
            zzge().zzim().zze("Error retrieving newly installed package info. appId, appName", zzfg.zzbm(str), str3);
            return null;
        }
    }

    private static void zza(zzjq zzjq) {
        if (zzjq == null) {
            throw new IllegalStateException("Upload component not created");
        } else if (!zzjq.isInitialized()) {
            String valueOf = String.valueOf(zzjq.getClass());
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 27).append("Component not initialized: ").append(valueOf).toString());
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzab();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzge().zzim().log("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzge().zzim().zzg("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzge().zzim().zzg("Failed to write to channel", e);
            return false;
        }
    }

    private final boolean zza(String str, zzeu zzeu) {
        long longValue;
        zzjz zzjz;
        String string = zzeu.zzafq.getString(FirebaseAnalytics.Param.CURRENCY);
        if (FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzeu.name)) {
            double doubleValue = zzeu.zzafq.zzbh(FirebaseAnalytics.Param.VALUE).doubleValue() * 1000000.0d;
            if (doubleValue == 0.0d) {
                doubleValue = ((double) zzeu.zzafq.getLong(FirebaseAnalytics.Param.VALUE).longValue()) * 1000000.0d;
            }
            if (doubleValue > 9.223372036854776E18d || doubleValue < -9.223372036854776E18d) {
                zzge().zzip().zze("Data lost. Currency value is too big. appId", zzfg.zzbm(str), Double.valueOf(doubleValue));
                return false;
            }
            longValue = Math.round(doubleValue);
        } else {
            longValue = zzeu.zzafq.getLong(FirebaseAnalytics.Param.VALUE).longValue();
        }
        if (!TextUtils.isEmpty(string)) {
            String upperCase = string.toUpperCase(Locale.US);
            if (upperCase.matches("[A-Z]{3}")) {
                String valueOf = String.valueOf("_ltv_");
                String valueOf2 = String.valueOf(upperCase);
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                zzjz zzh = zzix().zzh(str, concat);
                if (zzh == null || !(zzh.value instanceof Long)) {
                    zzei zzix = zzix();
                    int zzb = zzgg().zzb(str, zzew.zzahm) - 1;
                    Preconditions.checkNotEmpty(str);
                    zzix.zzab();
                    zzix.zzch();
                    try {
                        zzix.getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(zzb)});
                    } catch (SQLiteException e) {
                        zzix.zzge().zzim().zze("Error pruning currencies. appId", zzfg.zzbm(str), e);
                    }
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(longValue));
                } else {
                    zzjz = new zzjz(str, zzeu.origin, concat, zzbt().currentTimeMillis(), Long.valueOf(longValue + ((Long) zzh.value).longValue()));
                }
                if (!zzix().zza(zzjz)) {
                    zzge().zzim().zzd("Too many unique user properties are set. Ignoring user property. appId", zzfg.zzbm(str), zzga().zzbl(zzjz.name), zzjz.value);
                    zzgb().zza(str, 9, (String) null, (String) null, 0);
                }
            }
        }
        return true;
    }

    private final zzkm[] zza(String str, zzks[] zzksArr, zzkn[] zzknArr) {
        Preconditions.checkNotEmpty(str);
        return zziw().zza(str, zzknArr, zzksArr);
    }

    @WorkerThread
    private final void zzb(zzdy zzdy) {
        ArrayMap arrayMap;
        zzab();
        if (TextUtils.isEmpty(zzdy.getGmpAppId())) {
            zzb(zzdy.zzah(), 204, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String gmpAppId = zzdy.getGmpAppId();
        String appInstanceId = zzdy.getAppInstanceId();
        Uri.Builder builder = new Uri.Builder();
        Uri.Builder encodedAuthority = builder.scheme(zzew.zzagm.get()).encodedAuthority(zzew.zzagn.get());
        String valueOf = String.valueOf(gmpAppId);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", appInstanceId).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "12451");
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            zzge().zzit().zzg("Fetching remote configuration", zzdy.zzah());
            zzkk zzbu = zzkm().zzbu(zzdy.zzah());
            String zzbv = zzkm().zzbv(zzdy.zzah());
            if (zzbu == null || TextUtils.isEmpty(zzbv)) {
                arrayMap = null;
            } else {
                ArrayMap arrayMap2 = new ArrayMap();
                arrayMap2.put("If-Modified-Since", zzbv);
                arrayMap = arrayMap2;
            }
            this.zzaql = true;
            zzfk zzkn = zzkn();
            String zzah = zzdy.zzah();
            zzjt zzjt = new zzjt(this);
            zzkn.zzab();
            zzkn.zzch();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(zzjt);
            zzkn.zzgd().zzd((Runnable) new zzfo(zzkn, zzah, url, (byte[]) null, arrayMap, zzjt));
        } catch (MalformedURLException e) {
            zzge().zzim().zze("Failed to parse config URL. Not fetching. appId", zzfg.zzbm(zzdy.zzah()), uri);
        }
    }

    @WorkerThread
    private final Boolean zzc(zzdy zzdy) {
        try {
            if (zzdy.zzgm() != -2147483648L) {
                if (zzdy.zzgm() == ((long) Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(getContext()).getPackageInfo(zzdy.zzah(), 0).versionName;
                if (zzdy.zzag() != null && zzdy.zzag().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    @WorkerThread
    private final void zzc(zzeu zzeu, zzdz zzdz) {
        zzeq zzac;
        zzep zzep;
        zzkq zzkq;
        boolean z;
        zzdy zzbc;
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        long nanoTime = System.nanoTime();
        zzab();
        zzkq();
        String str = zzdz.packageName;
        zzgb();
        if (zzka.zzd(zzeu, zzdz)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
            } else if (zzkm().zzn(str, zzeu.name)) {
                zzge().zzip().zze("Dropping blacklisted event. appId", zzfg.zzbm(str), zzga().zzbj(zzeu.name));
                boolean z2 = zzkm().zzby(str) || zzkm().zzbz(str);
                if (!z2 && !"_err".equals(zzeu.name)) {
                    zzgb().zza(str, 11, "_ev", zzeu.name, 0);
                }
                if (z2 && (zzbc = zzix().zzbc(str)) != null) {
                    if (Math.abs(zzbt().currentTimeMillis() - Math.max(zzbc.zzgs(), zzbc.zzgr())) > zzew.zzahh.get().longValue()) {
                        zzge().zzis().log("Fetching config for blacklisted app");
                        zzb(zzbc);
                    }
                }
            } else {
                if (zzge().isLoggable(2)) {
                    zzge().zzit().zzg("Logging event", zzga().zzb(zzeu));
                }
                zzix().beginTransaction();
                try {
                    zzg(zzdz);
                    if (("_iap".equals(zzeu.name) || FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                    boolean zzcc = zzka.zzcc(zzeu.name);
                    boolean equals = "_err".equals(zzeu.name);
                    zzej zza = zzix().zza(zzkr(), str, true, zzcc, false, equals, false);
                    long intValue = zza.zzafe - ((long) zzew.zzags.get().intValue());
                    if (intValue > 0) {
                        if (intValue % 1000 == 1) {
                            zzge().zzim().zze("Data loss. Too many events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafe));
                        }
                        zzix().setTransactionSuccessful();
                        zzix().endTransaction();
                        return;
                    }
                    if (zzcc) {
                        long intValue2 = zza.zzafd - ((long) zzew.zzagu.get().intValue());
                        if (intValue2 > 0) {
                            if (intValue2 % 1000 == 1) {
                                zzge().zzim().zze("Data loss. Too many public events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafd));
                            }
                            zzgb().zza(str, 16, "_ev", zzeu.name, 0);
                            zzix().setTransactionSuccessful();
                            zzix().endTransaction();
                            return;
                        }
                    }
                    if (equals) {
                        long max = zza.zzafg - ((long) Math.max(0, Math.min(1000000, zzgg().zzb(zzdz.packageName, zzew.zzagt))));
                        if (max > 0) {
                            if (max == 1) {
                                zzge().zzim().zze("Too many error events logged. appId, count", zzfg.zzbm(str), Long.valueOf(zza.zzafg));
                            }
                            zzix().setTransactionSuccessful();
                            zzix().endTransaction();
                            return;
                        }
                    }
                    Bundle zzif = zzeu.zzafq.zzif();
                    zzgb().zza(zzif, "_o", (Object) zzeu.origin);
                    if (zzgb().zzcj(str)) {
                        zzgb().zza(zzif, "_dbg", (Object) 1L);
                        zzgb().zza(zzif, "_r", (Object) 1L);
                    }
                    long zzbd = zzix().zzbd(str);
                    if (zzbd > 0) {
                        zzge().zzip().zze("Data lost. Too many events stored on disk, deleted. appId", zzfg.zzbm(str), Long.valueOf(zzbd));
                    }
                    zzep zzep2 = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, 0, zzif);
                    zzeq zzf = zzix().zzf(str, zzep2.name);
                    if (zzf != null) {
                        zzep zza2 = zzep2.zza(this.zzacw, zzf.zzaft);
                        zzac = zzf.zzac(zza2.timestamp);
                        zzep = zza2;
                    } else if (zzix().zzbg(str) < 500 || !zzcc) {
                        zzac = new zzeq(str, zzep2.name, 0, 0, zzep2.timestamp, 0, (Long) null, (Long) null, (Boolean) null);
                        zzep = zzep2;
                    } else {
                        zzge().zzim().zzd("Too many event names used, ignoring event. appId, name, supported count", zzfg.zzbm(str), zzga().zzbj(zzep2.name), 500);
                        zzgb().zza(str, 8, (String) null, (String) null, 0);
                        zzix().endTransaction();
                        return;
                    }
                    zzix().zza(zzac);
                    zzab();
                    zzkq();
                    Preconditions.checkNotNull(zzep);
                    Preconditions.checkNotNull(zzdz);
                    Preconditions.checkNotEmpty(zzep.zzti);
                    Preconditions.checkArgument(zzep.zzti.equals(zzdz.packageName));
                    zzkq = new zzkq();
                    zzkq.zzath = 1;
                    zzkq.zzatp = "android";
                    zzkq.zzti = zzdz.packageName;
                    zzkq.zzadt = zzdz.zzadt;
                    zzkq.zzth = zzdz.zzth;
                    zzkq.zzaub = zzdz.zzads == -2147483648L ? null : Integer.valueOf((int) zzdz.zzads);
                    zzkq.zzatt = Long.valueOf(zzdz.zzadu);
                    zzkq.zzadm = zzdz.zzadm;
                    zzkq.zzatx = zzdz.zzadv == 0 ? null : Long.valueOf(zzdz.zzadv);
                    Pair<String, Boolean> zzbo = zzgf().zzbo(zzdz.packageName);
                    if (zzbo == null || TextUtils.isEmpty((CharSequence) zzbo.first)) {
                        if (!zzfw().zzf(getContext()) && zzdz.zzadz) {
                            String string = Settings.Secure.getString(getContext().getContentResolver(), "android_id");
                            if (string == null) {
                                zzge().zzip().zzg("null secure ID. appId", zzfg.zzbm(zzkq.zzti));
                                string = "null";
                            } else if (string.isEmpty()) {
                                zzge().zzip().zzg("empty secure ID. appId", zzfg.zzbm(zzkq.zzti));
                            }
                            zzkq.zzaue = string;
                        }
                    } else if (zzdz.zzady) {
                        zzkq.zzatv = (String) zzbo.first;
                        zzkq.zzatw = (Boolean) zzbo.second;
                    }
                    zzfw().zzch();
                    zzkq.zzatr = Build.MODEL;
                    zzfw().zzch();
                    zzkq.zzatq = Build.VERSION.RELEASE;
                    zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                    zzkq.zzafn = zzfw().zzid();
                    zzkq.zzatu = null;
                    zzkq.zzatk = null;
                    zzkq.zzatl = null;
                    zzkq.zzatm = null;
                    zzkq.zzaug = Long.valueOf(zzdz.zzadx);
                    if (this.zzacw.isEnabled() && zzef.zzhk()) {
                        zzkq.zzauh = null;
                    }
                    zzdy zzbc2 = zzix().zzbc(zzdz.packageName);
                    if (zzbc2 == null) {
                        zzbc2 = new zzdy(this.zzacw, zzdz.packageName);
                        zzbc2.zzal(this.zzacw.zzfv().zzii());
                        zzbc2.zzao(zzdz.zzado);
                        zzbc2.zzam(zzdz.zzadm);
                        zzbc2.zzan(zzgf().zzbp(zzdz.packageName));
                        zzbc2.zzr(0);
                        zzbc2.zzm(0);
                        zzbc2.zzn(0);
                        zzbc2.setAppVersion(zzdz.zzth);
                        zzbc2.zzo(zzdz.zzads);
                        zzbc2.zzap(zzdz.zzadt);
                        zzbc2.zzp(zzdz.zzadu);
                        zzbc2.zzq(zzdz.zzadv);
                        zzbc2.setMeasurementEnabled(zzdz.zzadw);
                        zzbc2.zzaa(zzdz.zzadx);
                        zzix().zza(zzbc2);
                    }
                    zzkq.zzadl = zzbc2.getAppInstanceId();
                    zzkq.zzado = zzbc2.zzgj();
                    List<zzjz> zzbb = zzix().zzbb(zzdz.packageName);
                    zzkq.zzatj = new zzks[zzbb.size()];
                    for (int i = 0; i < zzbb.size(); i++) {
                        zzks zzks = new zzks();
                        zzkq.zzatj[i] = zzks;
                        zzks.name = zzbb.get(i).name;
                        zzks.zzaun = Long.valueOf(zzbb.get(i).zzaqz);
                        zzgb().zza(zzks, zzbb.get(i).value);
                    }
                    long zza3 = zzix().zza(zzkq);
                    zzei zzix = zzix();
                    if (zzep.zzafq != null) {
                        Iterator<String> it = zzep.zzafq.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if ("_r".equals(it.next())) {
                                    z = true;
                                    break;
                                }
                            } else {
                                boolean zzo = zzkm().zzo(zzep.zzti, zzep.name);
                                zzej zza4 = zzix().zza(zzkr(), zzep.zzti, false, false, false, false, false);
                                if (zzo) {
                                    if (zza4.zzafh < ((long) zzgg().zzar(zzep.zzti))) {
                                        z = true;
                                    }
                                }
                            }
                        }
                    }
                    z = false;
                    if (zzix.zza(zzep, zza3, z)) {
                        this.zzaqh = 0;
                    }
                    zzix().setTransactionSuccessful();
                    if (zzge().isLoggable(2)) {
                        zzge().zzit().zzg("Event recorded", zzga().zza(zzep));
                    }
                    zzix().endTransaction();
                    zzku();
                    zzge().zzit().zzg("Background event processing time, ms", Long.valueOf(((System.nanoTime() - nanoTime) + 500000) / 1000000));
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to insert raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
                } catch (Throwable th) {
                    zzix().endTransaction();
                    throw th;
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0375, code lost:
        if (com.google.android.gms.internal.measurement.zzka.zzcl(r12.name) != false) goto L_0x0377;
     */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0350 A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0354 A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x053d A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0093 A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0096 A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:380:0x0bb2 A[Catch:{ IOException -> 0x02b5, all -> 0x01b8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:390:0x0bd7  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzd(java.lang.String r31, long r32) {
        /*
            r30 = this;
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()
            r2.beginTransaction()
            com.google.android.gms.internal.measurement.zzjv r21 = new com.google.android.gms.internal.measurement.zzjv     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r0 = r21
            r1 = r30
            r0.<init>(r1, r2)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r14 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r4 = 0
            r0 = r30
            long r0 = r0.zzaqs     // Catch:{ all -> 0x01b8 }
            r16 = r0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r21)     // Catch:{ all -> 0x01b8 }
            r14.zzab()     // Catch:{ all -> 0x01b8 }
            r14.zzch()     // Catch:{ all -> 0x01b8 }
            r3 = 0
            android.database.sqlite.SQLiteDatabase r2 = r14.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0bc6 }
            r5 = 0
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            if (r5 == 0) goto L_0x01c1
            r6 = -1
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x015a
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x0bc6 }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 1
            java.lang.String r7 = java.lang.String.valueOf(r32)     // Catch:{ SQLiteException -> 0x0bc6 }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = r5
        L_0x0049:
            r8 = -1
            int r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x0167
            java.lang.String r5 = "rowid <= ? and "
        L_0x0051:
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0bc6 }
            int r7 = r7 + 148
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0bc6 }
            r8.<init>(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0bc6 }
            android.database.Cursor r3 = r2.rawQuery(r5, r6)     // Catch:{ SQLiteException -> 0x0bc6 }
            boolean r5 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0bc6 }
            if (r5 != 0) goto L_0x016b
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
        L_0x0083:
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0093
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0354
        L_0x0093:
            r2 = 1
        L_0x0094:
            if (r2 != 0) goto L_0x0bb2
            r17 = 0
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r0 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            r22 = r0
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            int r2 = r2.size()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzkn[] r2 = new com.google.android.gms.internal.measurement.zzkn[r2]     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzati = r2     // Catch:{ all -> 0x01b8 }
            r13 = 0
            r14 = 0
            com.google.android.gms.internal.measurement.zzef r2 = r30.zzgg()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.String r3 = r0.zzti     // Catch:{ all -> 0x01b8 }
            boolean r18 = r2.zzav(r3)     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r16 = r2
        L_0x00be:
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            int r2 = r2.size()     // Catch:{ all -> 0x01b8 }
            r0 = r16
            if (r0 >= r2) goto L_0x05c0
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            r0 = r16
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x01b8 }
            r0 = r2
            com.google.android.gms.internal.measurement.zzkn r0 = (com.google.android.gms.internal.measurement.zzkn) r0     // Catch:{ all -> 0x01b8 }
            r12 = r0
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.zzn(r3, r4)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x035a
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Dropping blacklisted raw event. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfe r5 = r30.zzga()     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r12.name     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = r5.zzbj(r6)     // Catch:{ all -> 0x01b8 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.zzby(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x012b
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.zzbz(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0357
        L_0x012b:
            r2 = 1
        L_0x012c:
            if (r2 != 0) goto L_0x0be6
            java.lang.String r2 = "_err"
            java.lang.String r3 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0be6
            com.google.android.gms.internal.measurement.zzka r2 = r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            r4 = 11
            java.lang.String r5 = "_ev"
            java.lang.String r6 = r12.name     // Catch:{ all -> 0x01b8 }
            r7 = 0
            r2.zza((java.lang.String) r3, (int) r4, (java.lang.String) r5, (java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x01b8 }
            r2 = r14
            r4 = r13
            r5 = r17
        L_0x0150:
            int r6 = r16 + 1
            r16 = r6
            r14 = r2
            r13 = r4
            r17 = r5
            goto L_0x00be
        L_0x015a:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r32)     // Catch:{ SQLiteException -> 0x0bc6 }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = r5
            goto L_0x0049
        L_0x0167:
            java.lang.String r5 = ""
            goto L_0x0051
        L_0x016b:
            r5 = 0
            java.lang.String r4 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            r5 = 1
            java.lang.String r5 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            r3.close()     // Catch:{ SQLiteException -> 0x0bc6 }
            r13 = r5
            r11 = r3
            r12 = r4
        L_0x017b:
            java.lang.String r3 = "raw_events_metadata"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r5 = 0
            java.lang.String r6 = "metadata"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 0
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 1
            r6[r7] = r13     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "2"
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            boolean r3 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            if (r3 != 0) goto L_0x022b
            com.google.android.gms.internal.measurement.zzfg r2 = r14.zzge()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            java.lang.String r3 = "Raw event metadata record is missing. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r2.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            if (r11 == 0) goto L_0x0083
            r11.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x01b8:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzei r3 = r30.zzix()
            r3.endTransaction()
            throw r2
        L_0x01c1:
            r6 = -1
            int r5 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r5 == 0) goto L_0x0212
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 0
            r7 = 0
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 1
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x0bc6 }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = r5
        L_0x01d6:
            r8 = -1
            int r5 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r5 == 0) goto L_0x021b
            java.lang.String r5 = " and rowid <= ?"
        L_0x01de:
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            int r7 = r7.length()     // Catch:{ SQLiteException -> 0x0bc6 }
            int r7 = r7 + 84
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0bc6 }
            r8.<init>(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r7 = "select metadata_fingerprint from raw_events where app_id = ?"
            java.lang.StringBuilder r7 = r8.append(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.StringBuilder r5 = r7.append(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r7 = " order by rowid limit 1;"
            java.lang.StringBuilder r5 = r5.append(r7)     // Catch:{ SQLiteException -> 0x0bc6 }
            java.lang.String r5 = r5.toString()     // Catch:{ SQLiteException -> 0x0bc6 }
            android.database.Cursor r3 = r2.rawQuery(r5, r6)     // Catch:{ SQLiteException -> 0x0bc6 }
            boolean r5 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0bc6 }
            if (r5 != 0) goto L_0x021e
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x0212:
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = 0
            r7 = 0
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x0bc6 }
            r6 = r5
            goto L_0x01d6
        L_0x021b:
            java.lang.String r5 = ""
            goto L_0x01de
        L_0x021e:
            r5 = 0
            java.lang.String r5 = r3.getString(r5)     // Catch:{ SQLiteException -> 0x0bc6 }
            r3.close()     // Catch:{ SQLiteException -> 0x0bc6 }
            r13 = r5
            r11 = r3
            r12 = r4
            goto L_0x017b
        L_0x022b:
            r3 = 0
            byte[] r3 = r11.getBlob(r3)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r4 = 0
            int r5 = r3.length     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            com.google.android.gms.internal.measurement.zzabv r3 = com.google.android.gms.internal.measurement.zzabv.zza(r3, r4, r5)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            com.google.android.gms.internal.measurement.zzkq r4 = new com.google.android.gms.internal.measurement.zzkq     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r4.zzb(r3)     // Catch:{ IOException -> 0x02b5 }
            boolean r3 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            if (r3 == 0) goto L_0x0255
            com.google.android.gms.internal.measurement.zzfg r3 = r14.zzge()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzip()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            java.lang.String r5 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3.zzg(r5, r6)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        L_0x0255:
            r11.close()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r0 = r21
            r0.zzb(r4)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r4 = -1
            int r3 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x02ce
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r3 = 3
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3 = 1
            r6[r3] = r13     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3 = 2
            java.lang.String r4 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r6[r3] = r4     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
        L_0x0275:
            java.lang.String r3 = "raw_events"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 0
            java.lang.String r8 = "rowid"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 1
            java.lang.String r8 = "name"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 2
            java.lang.String r8 = "timestamp"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 3
            java.lang.String r8 = "data"
            r4[r7] = r8     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0bc9 }
            if (r2 != 0) goto L_0x02f5
            com.google.android.gms.internal.measurement.zzfg r2 = r14.zzge()     // Catch:{ SQLiteException -> 0x0bc9 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ SQLiteException -> 0x0bc9 }
            java.lang.String r4 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x0bc9 }
            r2.zzg(r4, r5)     // Catch:{ SQLiteException -> 0x0bc9 }
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x02b5:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzfg r3 = r14.zzge()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3.zze(r4, r5, r2)     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            if (r11 == 0) goto L_0x0083
            r11.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x02ce:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r3 = 2
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3 = 0
            r6[r3] = r12     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            r3 = 1
            r6[r3] = r13     // Catch:{ SQLiteException -> 0x02da, all -> 0x0bc2 }
            goto L_0x0275
        L_0x02da:
            r2 = move-exception
            r3 = r11
            r4 = r12
        L_0x02dd:
            com.google.android.gms.internal.measurement.zzfg r5 = r14.zzge()     // Catch:{ all -> 0x034d }
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzim()     // Catch:{ all -> 0x034d }
            java.lang.String r6 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x034d }
            r5.zze(r6, r4, r2)     // Catch:{ all -> 0x034d }
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x02f5:
            r2 = 0
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x0bc9 }
            r2 = 3
            byte[] r2 = r3.getBlob(r2)     // Catch:{ SQLiteException -> 0x0bc9 }
            r6 = 0
            int r7 = r2.length     // Catch:{ SQLiteException -> 0x0bc9 }
            com.google.android.gms.internal.measurement.zzabv r2 = com.google.android.gms.internal.measurement.zzabv.zza(r2, r6, r7)     // Catch:{ SQLiteException -> 0x0bc9 }
            com.google.android.gms.internal.measurement.zzkn r6 = new com.google.android.gms.internal.measurement.zzkn     // Catch:{ SQLiteException -> 0x0bc9 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0bc9 }
            r6.zzb(r2)     // Catch:{ IOException -> 0x032e }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x0bc9 }
            r6.name = r2     // Catch:{ SQLiteException -> 0x0bc9 }
            r2 = 2
            long r8 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x0bc9 }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x0bc9 }
            r6.zzatb = r2     // Catch:{ SQLiteException -> 0x0bc9 }
            r0 = r21
            boolean r2 = r0.zza(r4, r6)     // Catch:{ SQLiteException -> 0x0bc9 }
            if (r2 != 0) goto L_0x0340
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x032e:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzfg r4 = r14.zzge()     // Catch:{ SQLiteException -> 0x0bc9 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ SQLiteException -> 0x0bc9 }
            java.lang.String r5 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x0bc9 }
            r4.zze(r5, r6, r2)     // Catch:{ SQLiteException -> 0x0bc9 }
        L_0x0340:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0bc9 }
            if (r2 != 0) goto L_0x02f5
            if (r3 == 0) goto L_0x0083
            r3.close()     // Catch:{ all -> 0x01b8 }
            goto L_0x0083
        L_0x034d:
            r2 = move-exception
        L_0x034e:
            if (r3 == 0) goto L_0x0353
            r3.close()     // Catch:{ all -> 0x01b8 }
        L_0x0353:
            throw r2     // Catch:{ all -> 0x01b8 }
        L_0x0354:
            r2 = 0
            goto L_0x0094
        L_0x0357:
            r2 = 0
            goto L_0x012c
        L_0x035a:
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r19 = r2.zzo(r3, r4)     // Catch:{ all -> 0x01b8 }
            if (r19 != 0) goto L_0x0377
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = com.google.android.gms.internal.measurement.zzka.zzcl(r2)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0590
        L_0x0377:
            r4 = 0
            r3 = 0
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0382
            r2 = 0
            com.google.android.gms.internal.measurement.zzko[] r2 = new com.google.android.gms.internal.measurement.zzko[r2]     // Catch:{ all -> 0x01b8 }
            r12.zzata = r2     // Catch:{ all -> 0x01b8 }
        L_0x0382:
            com.google.android.gms.internal.measurement.zzko[] r6 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r7 = r6.length     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r5 = r2
        L_0x0387:
            if (r5 >= r7) goto L_0x03be
            r2 = r6[r5]     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = "_c"
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x01b8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x03a9
            r8 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01b8 }
            r2.zzate = r4     // Catch:{ all -> 0x01b8 }
            r2 = 1
            r29 = r3
            r3 = r2
            r2 = r29
        L_0x03a3:
            int r4 = r5 + 1
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x0387
        L_0x03a9:
            java.lang.String r8 = "_r"
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x01b8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x0be2
            r8 = 1
            java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01b8 }
            r2.zzate = r3     // Catch:{ all -> 0x01b8 }
            r2 = 1
            r3 = r4
            goto L_0x03a3
        L_0x03be:
            if (r4 != 0) goto L_0x03fe
            if (r19 == 0) goto L_0x03fe
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzit()     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "Marking event as conversion"
            com.google.android.gms.internal.measurement.zzfe r5 = r30.zzga()     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r12.name     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = r5.zzbj(r6)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r4, r5)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r4 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r4 = r4.length     // Catch:{ all -> 0x01b8 }
            int r4 = r4 + 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = (com.google.android.gms.internal.measurement.zzko[]) r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko r4 = new com.google.android.gms.internal.measurement.zzko     // Catch:{ all -> 0x01b8 }
            r4.<init>()     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = "_c"
            r4.name = r5     // Catch:{ all -> 0x01b8 }
            r6 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            r4.zzate = r5     // Catch:{ all -> 0x01b8 }
            int r5 = r2.length     // Catch:{ all -> 0x01b8 }
            int r5 = r5 + -1
            r2[r5] = r4     // Catch:{ all -> 0x01b8 }
            r12.zzata = r2     // Catch:{ all -> 0x01b8 }
        L_0x03fe:
            if (r3 != 0) goto L_0x043c
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzit()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Marking event as real-time"
            com.google.android.gms.internal.measurement.zzfe r4 = r30.zzga()     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = r12.name     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzbj(r5)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r3 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            int r3 = r3 + 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = (com.google.android.gms.internal.measurement.zzko[]) r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko r3 = new com.google.android.gms.internal.measurement.zzko     // Catch:{ all -> 0x01b8 }
            r3.<init>()     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "_r"
            r3.name = r4     // Catch:{ all -> 0x01b8 }
            r4 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01b8 }
            r3.zzate = r4     // Catch:{ all -> 0x01b8 }
            int r4 = r2.length     // Catch:{ all -> 0x01b8 }
            int r4 = r4 + -1
            r2[r4] = r3     // Catch:{ all -> 0x01b8 }
            r12.zzata = r2     // Catch:{ all -> 0x01b8 }
        L_0x043c:
            r2 = 1
            com.google.android.gms.internal.measurement.zzei r3 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            long r4 = r30.zzkr()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r6 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x01b8 }
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            com.google.android.gms.internal.measurement.zzej r3 = r3.zza(r4, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01b8 }
            long r4 = r3.zzafh     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzef r3 = r30.zzgg()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r6 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r6.zzti     // Catch:{ all -> 0x01b8 }
            int r3 = r3.zzar(r6)     // Catch:{ all -> 0x01b8 }
            long r6 = (long) r3     // Catch:{ all -> 0x01b8 }
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 <= 0) goto L_0x0bde
            r2 = 0
        L_0x046a:
            com.google.android.gms.internal.measurement.zzko[] r3 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            if (r2 >= r3) goto L_0x049b
            java.lang.String r3 = "_r"
            com.google.android.gms.internal.measurement.zzko[] r4 = r12.zzata     // Catch:{ all -> 0x01b8 }
            r4 = r4[r2]     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.name     // Catch:{ all -> 0x01b8 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x01b8 }
            if (r3 == 0) goto L_0x0506
            com.google.android.gms.internal.measurement.zzko[] r3 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            int r3 = r3 + -1
            com.google.android.gms.internal.measurement.zzko[] r3 = new com.google.android.gms.internal.measurement.zzko[r3]     // Catch:{ all -> 0x01b8 }
            if (r2 <= 0) goto L_0x048d
            com.google.android.gms.internal.measurement.zzko[] r4 = r12.zzata     // Catch:{ all -> 0x01b8 }
            r5 = 0
            r6 = 0
            java.lang.System.arraycopy(r4, r5, r3, r6, r2)     // Catch:{ all -> 0x01b8 }
        L_0x048d:
            int r4 = r3.length     // Catch:{ all -> 0x01b8 }
            if (r2 >= r4) goto L_0x0499
            com.google.android.gms.internal.measurement.zzko[] r4 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r5 = r2 + 1
            int r6 = r3.length     // Catch:{ all -> 0x01b8 }
            int r6 = r6 - r2
            java.lang.System.arraycopy(r4, r5, r3, r2, r6)     // Catch:{ all -> 0x01b8 }
        L_0x0499:
            r12.zzata = r3     // Catch:{ all -> 0x01b8 }
        L_0x049b:
            java.lang.String r2 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = com.google.android.gms.internal.measurement.zzka.zzcc(r2)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0590
            if (r19 == 0) goto L_0x0590
            com.google.android.gms.internal.measurement.zzei r3 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            long r4 = r30.zzkr()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r2 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r2.zzti     // Catch:{ all -> 0x01b8 }
            r7 = 0
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 0
            com.google.android.gms.internal.measurement.zzej r2 = r3.zza(r4, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x01b8 }
            long r2 = r2.zzaff     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzef r4 = r30.zzgg()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r5 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = r5.zzti     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzex<java.lang.Integer> r6 = com.google.android.gms.internal.measurement.zzew.zzagv     // Catch:{ all -> 0x01b8 }
            int r4 = r4.zzb(r5, r6)     // Catch:{ all -> 0x01b8 }
            long r4 = (long) r4     // Catch:{ all -> 0x01b8 }
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x0590
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Too many conversions. Not logging as conversion. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
            r4 = 0
            r3 = 0
            com.google.android.gms.internal.measurement.zzko[] r6 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r7 = r6.length     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r5 = r2
        L_0x04f1:
            if (r5 >= r7) goto L_0x051b
            r2 = r6[r5]     // Catch:{ all -> 0x01b8 }
            java.lang.String r8 = "_c"
            java.lang.String r9 = r2.name     // Catch:{ all -> 0x01b8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x050a
            r3 = r4
        L_0x0500:
            int r4 = r5 + 1
            r5 = r4
            r4 = r3
            r3 = r2
            goto L_0x04f1
        L_0x0506:
            int r2 = r2 + 1
            goto L_0x046a
        L_0x050a:
            java.lang.String r8 = "_err"
            java.lang.String r2 = r2.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = r8.equals(r2)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0bda
            r2 = 1
            r29 = r3
            r3 = r2
            r2 = r29
            goto L_0x0500
        L_0x051b:
            if (r4 == 0) goto L_0x0568
            if (r3 == 0) goto L_0x0568
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            r4 = 1
            com.google.android.gms.internal.measurement.zzko[] r4 = new com.google.android.gms.internal.measurement.zzko[r4]     // Catch:{ all -> 0x01b8 }
            r5 = 0
            r4[r5] = r3     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r2 = com.google.android.gms.common.util.ArrayUtils.removeAll((T[]) r2, (T[]) r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = (com.google.android.gms.internal.measurement.zzko[]) r2     // Catch:{ all -> 0x01b8 }
            r12.zzata = r2     // Catch:{ all -> 0x01b8 }
            r5 = r17
        L_0x0531:
            if (r18 == 0) goto L_0x0bd7
            java.lang.String r2 = "_e"
            java.lang.String r3 = r12.name     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0bd7
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0546
            com.google.android.gms.internal.measurement.zzko[] r2 = r12.zzata     // Catch:{ all -> 0x01b8 }
            int r2 = r2.length     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0593
        L_0x0546:
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Engagement event does not contain any parameters. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
            r2 = r14
        L_0x055e:
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r6 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r4 = r13 + 1
            r6[r13] = r12     // Catch:{ all -> 0x01b8 }
            goto L_0x0150
        L_0x0568:
            if (r3 == 0) goto L_0x0579
            java.lang.String r2 = "_err"
            r3.name = r2     // Catch:{ all -> 0x01b8 }
            r4 = 10
            java.lang.Long r2 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01b8 }
            r3.zzate = r2     // Catch:{ all -> 0x01b8 }
            r5 = r17
            goto L_0x0531
        L_0x0579:
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Did not find conversion parameter. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
        L_0x0590:
            r5 = r17
            goto L_0x0531
        L_0x0593:
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "_et"
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzka.zzb(r12, r2)     // Catch:{ all -> 0x01b8 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x05b9
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Engagement event does not include duration. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
            r2 = r14
            goto L_0x055e
        L_0x05b9:
            long r2 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            long r14 = r14 + r2
            r2 = r14
            goto L_0x055e
        L_0x05c0:
            r0 = r21
            java.util.List<com.google.android.gms.internal.measurement.zzkn> r2 = r0.zzaqx     // Catch:{ all -> 0x01b8 }
            int r2 = r2.size()     // Catch:{ all -> 0x01b8 }
            if (r13 >= r2) goto L_0x05d8
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r2 = r0.zzati     // Catch:{ all -> 0x01b8 }
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r13)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzkn[] r2 = (com.google.android.gms.internal.measurement.zzkn[]) r2     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzati = r2     // Catch:{ all -> 0x01b8 }
        L_0x05d8:
            if (r18 == 0) goto L_0x0687
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.String r3 = r0.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "_lte"
            com.google.android.gms.internal.measurement.zzjz r8 = r2.zzh(r3, r4)     // Catch:{ all -> 0x01b8 }
            if (r8 == 0) goto L_0x05ee
            java.lang.Object r2 = r8.value     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0763
        L_0x05ee:
            com.google.android.gms.internal.measurement.zzjz r2 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.String r3 = r0.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "auto"
            java.lang.String r5 = "_lte"
            com.google.android.gms.common.util.Clock r6 = r30.zzbt()     // Catch:{ all -> 0x01b8 }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x01b8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x01b8 }
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ all -> 0x01b8 }
            r4 = r2
        L_0x0608:
            com.google.android.gms.internal.measurement.zzks r5 = new com.google.android.gms.internal.measurement.zzks     // Catch:{ all -> 0x01b8 }
            r5.<init>()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "_lte"
            r5.name = r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.common.util.Clock r2 = r30.zzbt()     // Catch:{ all -> 0x01b8 }
            long r2 = r2.currentTimeMillis()     // Catch:{ all -> 0x01b8 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            r5.zzaun = r2     // Catch:{ all -> 0x01b8 }
            java.lang.Object r2 = r4.value     // Catch:{ all -> 0x01b8 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01b8 }
            r5.zzate = r2     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r3 = 0
        L_0x0627:
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r6 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            int r6 = r6.length     // Catch:{ all -> 0x01b8 }
            if (r3 >= r6) goto L_0x0645
            java.lang.String r6 = "_lte"
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r7 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            r7 = r7[r3]     // Catch:{ all -> 0x01b8 }
            java.lang.String r7 = r7.name     // Catch:{ all -> 0x01b8 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x01b8 }
            if (r6 == 0) goto L_0x0788
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r2 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            r2[r3] = r5     // Catch:{ all -> 0x01b8 }
            r2 = 1
        L_0x0645:
            if (r2 != 0) goto L_0x066b
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r2 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r3 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            int r3 = r3 + 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzks[] r2 = (com.google.android.gms.internal.measurement.zzks[]) r2     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzatj = r2     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r2 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzks[] r3 = r3.zzatj     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            int r3 = r3 + -1
            r2[r3] = r5     // Catch:{ all -> 0x01b8 }
        L_0x066b:
            r2 = 0
            int r2 = (r14 > r2 ? 1 : (r14 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0687
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r2.zza((com.google.android.gms.internal.measurement.zzjz) r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzis()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Updated lifetime engagement user property with value. Value"
            java.lang.Object r4 = r4.value     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
        L_0x0687:
            r0 = r22
            java.lang.String r2 = r0.zzti     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzks[] r3 = r0.zzatj     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r4 = r0.zzati     // Catch:{ all -> 0x01b8 }
            r0 = r30
            com.google.android.gms.internal.measurement.zzkm[] r2 = r0.zza(r2, r3, r4)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzaua = r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzef r2 = r30.zzgg()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.zzau(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x09c6
            java.util.HashMap r23 = new java.util.HashMap     // Catch:{ all -> 0x01b8 }
            r23.<init>()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r2 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r2 = r2.length     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzkn[] r0 = new com.google.android.gms.internal.measurement.zzkn[r2]     // Catch:{ all -> 0x01b8 }
            r24 = r0
            r18 = 0
            com.google.android.gms.internal.measurement.zzka r2 = r30.zzgb()     // Catch:{ all -> 0x01b8 }
            java.security.SecureRandom r25 = r2.zzlc()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r0 = r0.zzati     // Catch:{ all -> 0x01b8 }
            r26 = r0
            r0 = r26
            int r0 = r0.length     // Catch:{ all -> 0x01b8 }
            r27 = r0
            r2 = 0
            r19 = r2
        L_0x06d3:
            r0 = r19
            r1 = r27
            if (r0 >= r1) goto L_0x098d
            r28 = r26[r19]     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "_ep"
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x078c
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "_en"
            r0 = r28
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzka.zzb(r0, r2)     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x01b8 }
            r0 = r23
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = (com.google.android.gms.internal.measurement.zzeq) r3     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x0711
            com.google.android.gms.internal.measurement.zzei r3 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zzf(r4, r2)     // Catch:{ all -> 0x01b8 }
            r0 = r23
            r0.put(r2, r3)     // Catch:{ all -> 0x01b8 }
        L_0x0711:
            java.lang.Long r2 = r3.zzafv     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0989
            java.lang.Long r2 = r3.zzafw     // Catch:{ all -> 0x01b8 }
            long r4 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            r6 = 1
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 <= 0) goto L_0x0734
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r2 = r0.zzata     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "_sr"
            java.lang.Long r5 = r3.zzafw     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzko[]) r2, (java.lang.String) r4, (java.lang.Object) r5)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            r0.zzata = r2     // Catch:{ all -> 0x01b8 }
        L_0x0734:
            java.lang.Boolean r2 = r3.zzafx     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0757
            java.lang.Boolean r2 = r3.zzafx     // Catch:{ all -> 0x01b8 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0757
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r2 = r0.zzata     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "_efs"
            r4 = 1
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzko[]) r2, (java.lang.String) r3, (java.lang.Object) r4)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            r0.zzata = r2     // Catch:{ all -> 0x01b8 }
        L_0x0757:
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01b8 }
        L_0x075b:
            int r3 = r19 + 1
            r19 = r3
            r18 = r2
            goto L_0x06d3
        L_0x0763:
            com.google.android.gms.internal.measurement.zzjz r2 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.String r3 = r0.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "auto"
            java.lang.String r5 = "_lte"
            com.google.android.gms.common.util.Clock r6 = r30.zzbt()     // Catch:{ all -> 0x01b8 }
            long r6 = r6.currentTimeMillis()     // Catch:{ all -> 0x01b8 }
            java.lang.Object r8 = r8.value     // Catch:{ all -> 0x01b8 }
            java.lang.Long r8 = (java.lang.Long) r8     // Catch:{ all -> 0x01b8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x01b8 }
            long r8 = r8 + r14
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x01b8 }
            r2.<init>(r3, r4, r5, r6, r8)     // Catch:{ all -> 0x01b8 }
            r4 = r2
            goto L_0x0608
        L_0x0788:
            int r3 = r3 + 1
            goto L_0x0627
        L_0x078c:
            r2 = 1
            java.lang.String r4 = "_dbg"
            r6 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x079d
            if (r5 != 0) goto L_0x07d0
        L_0x079d:
            r3 = 0
        L_0x079e:
            if (r3 != 0) goto L_0x0bd3
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            int r2 = r2.zzp(r3, r4)     // Catch:{ all -> 0x01b8 }
            r20 = r2
        L_0x07b4:
            if (r20 > 0) goto L_0x080f
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Sample rate must be positive. event, rate"
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r20)     // Catch:{ all -> 0x01b8 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x01b8 }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01b8 }
            goto L_0x075b
        L_0x07d0:
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r6 = r0.zzata     // Catch:{ all -> 0x01b8 }
            int r7 = r6.length     // Catch:{ all -> 0x01b8 }
            r3 = 0
        L_0x07d6:
            if (r3 >= r7) goto L_0x080d
            r8 = r6[r3]     // Catch:{ all -> 0x01b8 }
            java.lang.String r9 = r8.name     // Catch:{ all -> 0x01b8 }
            boolean r9 = r4.equals(r9)     // Catch:{ all -> 0x01b8 }
            if (r9 == 0) goto L_0x080a
            boolean r3 = r5 instanceof java.lang.Long     // Catch:{ all -> 0x01b8 }
            if (r3 == 0) goto L_0x07ee
            java.lang.Long r3 = r8.zzate     // Catch:{ all -> 0x01b8 }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x0806
        L_0x07ee:
            boolean r3 = r5 instanceof java.lang.String     // Catch:{ all -> 0x01b8 }
            if (r3 == 0) goto L_0x07fa
            java.lang.String r3 = r8.zzajf     // Catch:{ all -> 0x01b8 }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x0806
        L_0x07fa:
            boolean r3 = r5 instanceof java.lang.Double     // Catch:{ all -> 0x01b8 }
            if (r3 == 0) goto L_0x0808
            java.lang.Double r3 = r8.zzarc     // Catch:{ all -> 0x01b8 }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x01b8 }
            if (r3 == 0) goto L_0x0808
        L_0x0806:
            r3 = 1
            goto L_0x079e
        L_0x0808:
            r3 = 0
            goto L_0x079e
        L_0x080a:
            int r3 = r3 + 1
            goto L_0x07d6
        L_0x080d:
            r3 = 0
            goto L_0x079e
        L_0x080f:
            r0 = r28
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x01b8 }
            r0 = r23
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r2 = (com.google.android.gms.internal.measurement.zzeq) r2     // Catch:{ all -> 0x01b8 }
            if (r2 != 0) goto L_0x0bd0
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = r2.zzf(r3, r4)     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x0869
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Event being bundled has no eventAggregate. appId, eventName"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x01b8 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = new com.google.android.gms.internal.measurement.zzeq     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r2 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r2.zzti     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x01b8 }
            r6 = 1
            r8 = 1
            r0 = r28
            java.lang.Long r2 = r0.zzatb     // Catch:{ all -> 0x01b8 }
            long r10 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            r12 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16)     // Catch:{ all -> 0x01b8 }
        L_0x0869:
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "_eid"
            r0 = r28
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzka.zzb(r0, r2)     // Catch:{ all -> 0x01b8 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x08aa
            r4 = 1
        L_0x0879:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x01b8 }
            r5 = 1
            r0 = r20
            if (r0 != r5) goto L_0x08ac
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01b8 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01b8 }
            if (r4 == 0) goto L_0x075b
            java.lang.Long r4 = r3.zzafv     // Catch:{ all -> 0x01b8 }
            if (r4 != 0) goto L_0x0898
            java.lang.Long r4 = r3.zzafw     // Catch:{ all -> 0x01b8 }
            if (r4 != 0) goto L_0x0898
            java.lang.Boolean r4 = r3.zzafx     // Catch:{ all -> 0x01b8 }
            if (r4 == 0) goto L_0x075b
        L_0x0898:
            r4 = 0
            r5 = 0
            r6 = 0
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01b8 }
            goto L_0x075b
        L_0x08aa:
            r4 = 0
            goto L_0x0879
        L_0x08ac:
            r0 = r25
            r1 = r20
            int r5 = r0.nextInt(r1)     // Catch:{ all -> 0x01b8 }
            if (r5 != 0) goto L_0x08fc
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r2 = r0.zzata     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = "_sr"
            r0 = r20
            long r6 = (long) r0     // Catch:{ all -> 0x01b8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzko[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            r0.zzata = r2     // Catch:{ all -> 0x01b8 }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01b8 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01b8 }
            if (r4 == 0) goto L_0x08e5
            r4 = 0
            r0 = r20
            long r6 = (long) r0     // Catch:{ all -> 0x01b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            r6 = 0
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01b8 }
        L_0x08e5:
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.Long r5 = r0.zzatb     // Catch:{ all -> 0x01b8 }
            long r6 = r5.longValue()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zzad(r6)     // Catch:{ all -> 0x01b8 }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01b8 }
            goto L_0x075b
        L_0x08fc:
            long r6 = r3.zzafu     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.Long r5 = r0.zzatb     // Catch:{ all -> 0x01b8 }
            long r8 = r5.longValue()     // Catch:{ all -> 0x01b8 }
            long r6 = r8 - r6
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x01b8 }
            r8 = 86400000(0x5265c00, double:4.2687272E-316)
            int r5 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x0974
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r2 = r0.zzata     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = "_efs"
            r6 = 1
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzko[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            r0.zzata = r2     // Catch:{ all -> 0x01b8 }
            r30.zzgb()     // Catch:{ all -> 0x01b8 }
            r0 = r28
            com.google.android.gms.internal.measurement.zzko[] r2 = r0.zzata     // Catch:{ all -> 0x01b8 }
            java.lang.String r5 = "_sr"
            r0 = r20
            long r6 = (long) r0     // Catch:{ all -> 0x01b8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzko[] r2 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzko[]) r2, (java.lang.String) r5, (java.lang.Object) r6)     // Catch:{ all -> 0x01b8 }
            r0 = r28
            r0.zzata = r2     // Catch:{ all -> 0x01b8 }
            int r2 = r18 + 1
            r24[r18] = r28     // Catch:{ all -> 0x01b8 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01b8 }
            if (r4 == 0) goto L_0x095d
            r4 = 0
            r0 = r20
            long r6 = (long) r0     // Catch:{ all -> 0x01b8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            r6 = 1
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zza(r4, r5, r6)     // Catch:{ all -> 0x01b8 }
        L_0x095d:
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            r0 = r28
            java.lang.Long r5 = r0.zzatb     // Catch:{ all -> 0x01b8 }
            long r6 = r5.longValue()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r3 = r3.zzad(r6)     // Catch:{ all -> 0x01b8 }
            r0 = r23
            r0.put(r4, r3)     // Catch:{ all -> 0x01b8 }
            goto L_0x075b
        L_0x0974:
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01b8 }
            if (r4 == 0) goto L_0x0989
            r0 = r28
            java.lang.String r4 = r0.name     // Catch:{ all -> 0x01b8 }
            r5 = 0
            r6 = 0
            com.google.android.gms.internal.measurement.zzeq r2 = r3.zza(r2, r5, r6)     // Catch:{ all -> 0x01b8 }
            r0 = r23
            r0.put(r4, r2)     // Catch:{ all -> 0x01b8 }
        L_0x0989:
            r2 = r18
            goto L_0x075b
        L_0x098d:
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r2 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r2 = r2.length     // Catch:{ all -> 0x01b8 }
            r0 = r18
            if (r0 >= r2) goto L_0x09a4
            r0 = r24
            r1 = r18
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r0, r1)     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzkn[] r2 = (com.google.android.gms.internal.measurement.zzkn[]) r2     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzati = r2     // Catch:{ all -> 0x01b8 }
        L_0x09a4:
            java.util.Set r2 = r23.entrySet()     // Catch:{ all -> 0x01b8 }
            java.util.Iterator r3 = r2.iterator()     // Catch:{ all -> 0x01b8 }
        L_0x09ac:
            boolean r2 = r3.hasNext()     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x09c6
            java.lang.Object r2 = r3.next()     // Catch:{ all -> 0x01b8 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r4 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzeq r2 = (com.google.android.gms.internal.measurement.zzeq) r2     // Catch:{ all -> 0x01b8 }
            r4.zza((com.google.android.gms.internal.measurement.zzeq) r2)     // Catch:{ all -> 0x01b8 }
            goto L_0x09ac
        L_0x09c6:
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzatl = r2     // Catch:{ all -> 0x01b8 }
            r2 = -9223372036854775808
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzatm = r2     // Catch:{ all -> 0x01b8 }
            r2 = 0
        L_0x09de:
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r3 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r3 = r3.length     // Catch:{ all -> 0x01b8 }
            if (r2 >= r3) goto L_0x0a1e
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r3 = r0.zzati     // Catch:{ all -> 0x01b8 }
            r3 = r3[r2]     // Catch:{ all -> 0x01b8 }
            java.lang.Long r4 = r3.zzatb     // Catch:{ all -> 0x01b8 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.Long r6 = r0.zzatl     // Catch:{ all -> 0x01b8 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x01b8 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0a03
            java.lang.Long r4 = r3.zzatb     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzatl = r4     // Catch:{ all -> 0x01b8 }
        L_0x0a03:
            java.lang.Long r4 = r3.zzatb     // Catch:{ all -> 0x01b8 }
            long r4 = r4.longValue()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.Long r6 = r0.zzatm     // Catch:{ all -> 0x01b8 }
            long r6 = r6.longValue()     // Catch:{ all -> 0x01b8 }
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x0a1b
            java.lang.Long r3 = r3.zzatb     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzatm = r3     // Catch:{ all -> 0x01b8 }
        L_0x0a1b:
            int r2 = r2 + 1
            goto L_0x09de
        L_0x0a1e:
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r2 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r6 = r2.zzti     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzdy r7 = r2.zzbc(r6)     // Catch:{ all -> 0x01b8 }
            if (r7 != 0) goto L_0x0ab9
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Bundling raw events w/o app info. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
        L_0x0a45:
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r2 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r2 = r2.length     // Catch:{ all -> 0x01b8 }
            if (r2 <= 0) goto L_0x0a81
            com.google.android.gms.internal.measurement.zzgf r2 = r30.zzkm()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r3 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = r3.zzti     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzkk r2 = r2.zzbu(r3)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0a60
            java.lang.Long r3 = r2.zzasp     // Catch:{ all -> 0x01b8 }
            if (r3 != 0) goto L_0x0b3e
        L_0x0a60:
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r2 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = r2.zzadm     // Catch:{ all -> 0x01b8 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x01b8 }
            if (r2 == 0) goto L_0x0b25
            r2 = -1
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzauf = r2     // Catch:{ all -> 0x01b8 }
        L_0x0a76:
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r1 = r17
            r2.zza((com.google.android.gms.internal.measurement.zzkq) r0, (boolean) r1)     // Catch:{ all -> 0x01b8 }
        L_0x0a81:
            com.google.android.gms.internal.measurement.zzei r4 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r0 = r21
            java.util.List<java.lang.Long> r5 = r0.zzaqw     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5)     // Catch:{ all -> 0x01b8 }
            r4.zzab()     // Catch:{ all -> 0x01b8 }
            r4.zzch()     // Catch:{ all -> 0x01b8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = "rowid in ("
            r7.<init>(r2)     // Catch:{ all -> 0x01b8 }
            r2 = 0
            r3 = r2
        L_0x0a9b:
            int r2 = r5.size()     // Catch:{ all -> 0x01b8 }
            if (r3 >= r2) goto L_0x0b46
            if (r3 == 0) goto L_0x0aa8
            java.lang.String r2 = ","
            r7.append(r2)     // Catch:{ all -> 0x01b8 }
        L_0x0aa8:
            java.lang.Object r2 = r5.get(r3)     // Catch:{ all -> 0x01b8 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x01b8 }
            long r8 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            r7.append(r8)     // Catch:{ all -> 0x01b8 }
            int r2 = r3 + 1
            r3 = r2
            goto L_0x0a9b
        L_0x0ab9:
            r0 = r22
            com.google.android.gms.internal.measurement.zzkn[] r2 = r0.zzati     // Catch:{ all -> 0x01b8 }
            int r2 = r2.length     // Catch:{ all -> 0x01b8 }
            if (r2 <= 0) goto L_0x0a45
            long r2 = r7.zzgl()     // Catch:{ all -> 0x01b8 }
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0b21
            java.lang.Long r4 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
        L_0x0ace:
            r0 = r22
            r0.zzato = r4     // Catch:{ all -> 0x01b8 }
            long r4 = r7.zzgk()     // Catch:{ all -> 0x01b8 }
            r8 = 0
            int r8 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r8 != 0) goto L_0x0bcd
        L_0x0adc:
            r4 = 0
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0b23
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x01b8 }
        L_0x0ae6:
            r0 = r22
            r0.zzatn = r2     // Catch:{ all -> 0x01b8 }
            r7.zzgt()     // Catch:{ all -> 0x01b8 }
            long r2 = r7.zzgq()     // Catch:{ all -> 0x01b8 }
            int r2 = (int) r2     // Catch:{ all -> 0x01b8 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzaty = r2     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.Long r2 = r0.zzatl     // Catch:{ all -> 0x01b8 }
            long r2 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            r7.zzm(r2)     // Catch:{ all -> 0x01b8 }
            r0 = r22
            java.lang.Long r2 = r0.zzatm     // Catch:{ all -> 0x01b8 }
            long r2 = r2.longValue()     // Catch:{ all -> 0x01b8 }
            r7.zzn(r2)     // Catch:{ all -> 0x01b8 }
            java.lang.String r2 = r7.zzhb()     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzaek = r2     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r2.zza((com.google.android.gms.internal.measurement.zzdy) r7)     // Catch:{ all -> 0x01b8 }
            goto L_0x0a45
        L_0x0b21:
            r4 = 0
            goto L_0x0ace
        L_0x0b23:
            r2 = 0
            goto L_0x0ae6
        L_0x0b25:
            com.google.android.gms.internal.measurement.zzfg r2 = r30.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "Did not find measurement config or missing version info. appId"
            r0 = r21
            com.google.android.gms.internal.measurement.zzkq r4 = r0.zzaqv     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = r4.zzti     // Catch:{ all -> 0x01b8 }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r4)     // Catch:{ all -> 0x01b8 }
            r2.zzg(r3, r4)     // Catch:{ all -> 0x01b8 }
            goto L_0x0a76
        L_0x0b3e:
            java.lang.Long r2 = r2.zzasp     // Catch:{ all -> 0x01b8 }
            r0 = r22
            r0.zzauf = r2     // Catch:{ all -> 0x01b8 }
            goto L_0x0a76
        L_0x0b46:
            java.lang.String r2 = ")"
            r7.append(r2)     // Catch:{ all -> 0x01b8 }
            android.database.sqlite.SQLiteDatabase r2 = r4.getWritableDatabase()     // Catch:{ all -> 0x01b8 }
            java.lang.String r3 = "raw_events"
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01b8 }
            r8 = 0
            int r2 = r2.delete(r3, r7, r8)     // Catch:{ all -> 0x01b8 }
            int r3 = r5.size()     // Catch:{ all -> 0x01b8 }
            if (r2 == r3) goto L_0x0b79
            com.google.android.gms.internal.measurement.zzfg r3 = r4.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x01b8 }
            int r5 = r5.size()     // Catch:{ all -> 0x01b8 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x01b8 }
            r3.zze(r4, r2, r5)     // Catch:{ all -> 0x01b8 }
        L_0x0b79:
            com.google.android.gms.internal.measurement.zzei r3 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            android.database.sqlite.SQLiteDatabase r2 = r3.getWritableDatabase()     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r5 = 2
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0b9f }
            r7 = 0
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0b9f }
            r7 = 1
            r5[r7] = r6     // Catch:{ SQLiteException -> 0x0b9f }
            r2.execSQL(r4, r5)     // Catch:{ SQLiteException -> 0x0b9f }
        L_0x0b8f:
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()
            r2.endTransaction()
            r2 = 1
        L_0x0b9e:
            return r2
        L_0x0b9f:
            r2 = move-exception
            com.google.android.gms.internal.measurement.zzfg r3 = r3.zzge()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x01b8 }
            java.lang.String r4 = "Failed to remove unused event metadata. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r6)     // Catch:{ all -> 0x01b8 }
            r3.zze(r4, r5, r2)     // Catch:{ all -> 0x01b8 }
            goto L_0x0b8f
        L_0x0bb2:
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()     // Catch:{ all -> 0x01b8 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x01b8 }
            com.google.android.gms.internal.measurement.zzei r2 = r30.zzix()
            r2.endTransaction()
            r2 = 0
            goto L_0x0b9e
        L_0x0bc2:
            r2 = move-exception
            r3 = r11
            goto L_0x034e
        L_0x0bc6:
            r2 = move-exception
            goto L_0x02dd
        L_0x0bc9:
            r2 = move-exception
            r4 = r12
            goto L_0x02dd
        L_0x0bcd:
            r2 = r4
            goto L_0x0adc
        L_0x0bd0:
            r3 = r2
            goto L_0x0869
        L_0x0bd3:
            r20 = r2
            goto L_0x07b4
        L_0x0bd7:
            r2 = r14
            goto L_0x055e
        L_0x0bda:
            r2 = r3
            r3 = r4
            goto L_0x0500
        L_0x0bde:
            r17 = r2
            goto L_0x049b
        L_0x0be2:
            r2 = r3
            r3 = r4
            goto L_0x03a3
        L_0x0be6:
            r2 = r14
            r4 = r13
            r5 = r17
            goto L_0x0150
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjr.zzd(java.lang.String, long):boolean");
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final zzdy zzg(zzdz zzdz) {
        boolean z = true;
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzdy zzbc = zzix().zzbc(zzdz.packageName);
        String zzbp = zzgf().zzbp(zzdz.packageName);
        boolean z2 = false;
        if (zzbc == null) {
            zzdy zzdy = new zzdy(this.zzacw, zzdz.packageName);
            zzdy.zzal(this.zzacw.zzfv().zzii());
            zzdy.zzan(zzbp);
            zzbc = zzdy;
            z2 = true;
        } else if (!zzbp.equals(zzbc.zzgi())) {
            zzbc.zzan(zzbp);
            zzbc.zzal(this.zzacw.zzfv().zzii());
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzadm) && !zzdz.zzadm.equals(zzbc.getGmpAppId())) {
            zzbc.zzam(zzdz.zzadm);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzado) && !zzdz.zzado.equals(zzbc.zzgj())) {
            zzbc.zzao(zzdz.zzado);
            z2 = true;
        }
        if (!(zzdz.zzadu == 0 || zzdz.zzadu == zzbc.zzgo())) {
            zzbc.zzp(zzdz.zzadu);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzth) && !zzdz.zzth.equals(zzbc.zzag())) {
            zzbc.setAppVersion(zzdz.zzth);
            z2 = true;
        }
        if (zzdz.zzads != zzbc.zzgm()) {
            zzbc.zzo(zzdz.zzads);
            z2 = true;
        }
        if (zzdz.zzadt != null && !zzdz.zzadt.equals(zzbc.zzgn())) {
            zzbc.zzap(zzdz.zzadt);
            z2 = true;
        }
        if (zzdz.zzadv != zzbc.zzgp()) {
            zzbc.zzq(zzdz.zzadv);
            z2 = true;
        }
        if (zzdz.zzadw != zzbc.isMeasurementEnabled()) {
            zzbc.setMeasurementEnabled(zzdz.zzadw);
            z2 = true;
        }
        if (!TextUtils.isEmpty(zzdz.zzaek) && !zzdz.zzaek.equals(zzbc.zzha())) {
            zzbc.zzaq(zzdz.zzaek);
            z2 = true;
        }
        if (zzdz.zzadx != zzbc.zzhc()) {
            zzbc.zzaa(zzdz.zzadx);
            z2 = true;
        }
        if (zzdz.zzady != zzbc.zzhd()) {
            zzbc.zzd(zzdz.zzady);
            z2 = true;
        }
        if (zzdz.zzadz != zzbc.zzhe()) {
            zzbc.zze(zzdz.zzadz);
        } else {
            z = z2;
        }
        if (z) {
            zzix().zza(zzbc);
        }
        return zzbc;
    }

    private final zzgf zzkm() {
        zza((zzjq) this.zzaqa);
        return this.zzaqa;
    }

    private final zzfp zzko() {
        if (this.zzaqd != null) {
            return this.zzaqd;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjn zzkp() {
        zza((zzjq) this.zzaqe);
        return this.zzaqe;
    }

    private final long zzkr() {
        long currentTimeMillis = zzbt().currentTimeMillis();
        zzfr zzgf = zzgf();
        zzgf.zzch();
        zzgf.zzab();
        long j = zzgf.zzajy.get();
        if (j == 0) {
            j = 1 + ((long) zzgf.zzgb().zzlc().nextInt(86400000));
            zzgf.zzajy.set(j);
        }
        return ((((j + currentTimeMillis) / 1000) / 60) / 60) / 24;
    }

    private final boolean zzkt() {
        zzab();
        zzkq();
        return zzix().zzhs() || !TextUtils.isEmpty(zzix().zzhn());
    }

    @WorkerThread
    private final void zzku() {
        long max;
        long j;
        zzab();
        zzkq();
        if (zzky()) {
            if (this.zzaqh > 0) {
                long abs = 3600000 - Math.abs(zzbt().elapsedRealtime() - this.zzaqh);
                if (abs > 0) {
                    zzge().zzit().zzg("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    zzko().unregister();
                    zzkp().cancel();
                    return;
                }
                this.zzaqh = 0;
            }
            if (!this.zzacw.zzjv() || !zzkt()) {
                zzge().zzit().log("Nothing to upload or uploading impossible");
                zzko().unregister();
                zzkp().cancel();
                return;
            }
            long currentTimeMillis = zzbt().currentTimeMillis();
            long max2 = Math.max(0, zzew.zzahi.get().longValue());
            boolean z = zzix().zzht() || zzix().zzho();
            if (z) {
                String zzhj = zzgg().zzhj();
                max = (TextUtils.isEmpty(zzhj) || ".none.".equals(zzhj)) ? Math.max(0, zzew.zzahc.get().longValue()) : Math.max(0, zzew.zzahd.get().longValue());
            } else {
                max = Math.max(0, zzew.zzahb.get().longValue());
            }
            long j2 = zzgf().zzaju.get();
            long j3 = zzgf().zzajv.get();
            long max3 = Math.max(zzix().zzhq(), zzix().zzhr());
            if (max3 == 0) {
                j = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long max4 = Math.max(currentTimeMillis - Math.abs(j2 - currentTimeMillis), abs3);
                j = abs2 + max2;
                if (z && max4 > 0) {
                    j = Math.min(abs2, max4) + max;
                }
                if (!zzgb().zza(max4, max)) {
                    j = max4 + max;
                }
                if (abs3 != 0 && abs3 >= abs2) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= Math.min(20, Math.max(0, zzew.zzahk.get().intValue()))) {
                            j = 0;
                            break;
                        }
                        j += (1 << i2) * Math.max(0, zzew.zzahj.get().longValue());
                        if (j > abs3) {
                            break;
                        }
                        i = i2 + 1;
                    }
                }
            }
            if (j == 0) {
                zzge().zzit().log("Next upload time is 0");
                zzko().unregister();
                zzkp().cancel();
            } else if (!zzkn().zzex()) {
                zzge().zzit().log("No network");
                zzko().zzeu();
                zzkp().cancel();
            } else {
                long j4 = zzgf().zzajw.get();
                long max5 = Math.max(0, zzew.zzagz.get().longValue());
                long max6 = !zzgb().zza(j4, max5) ? Math.max(j, max5 + j4) : j;
                zzko().unregister();
                long currentTimeMillis2 = max6 - zzbt().currentTimeMillis();
                if (currentTimeMillis2 <= 0) {
                    currentTimeMillis2 = Math.max(0, zzew.zzahe.get().longValue());
                    zzgf().zzaju.set(zzbt().currentTimeMillis());
                }
                zzge().zzit().zzg("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
                zzkp().zzh(currentTimeMillis2);
            }
        }
    }

    @WorkerThread
    private final void zzkv() {
        zzab();
        if (this.zzaql || this.zzaqm || this.zzaqn) {
            zzge().zzit().zzd("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzaql), Boolean.valueOf(this.zzaqm), Boolean.valueOf(this.zzaqn));
            return;
        }
        zzge().zzit().log("Stopping uploading service(s)");
        if (this.zzaqi != null) {
            for (Runnable run : this.zzaqi) {
                run.run();
            }
            this.zzaqi.clear();
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzkw() {
        zzab();
        try {
            this.zzaqp = new RandomAccessFile(new File(getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.zzaqo = this.zzaqp.tryLock();
            if (this.zzaqo != null) {
                zzge().zzit().log("Storage concurrent access okay");
                return true;
            }
            zzge().zzim().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzge().zzim().zzg("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzge().zzim().zzg("Failed to access storage lock file", e2);
        }
    }

    @WorkerThread
    private final boolean zzky() {
        zzab();
        zzkq();
        return this.zzaqg;
    }

    public Context getContext() {
        return this.zzacw.getContext();
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void start() {
        zzab();
        zzix().zzhp();
        if (zzgf().zzaju.get() == 0) {
            zzgf().zzaju.set(zzbt().currentTimeMillis());
        }
        zzku();
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzei zzix;
        zzab();
        zzkq();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaqm = false;
                zzkv();
                throw th2;
            }
        }
        List<Long> list = this.zzaqq;
        this.zzaqq = null;
        if ((i == 200 || i == 204) && th == null) {
            try {
                zzgf().zzaju.set(zzbt().currentTimeMillis());
                zzgf().zzajv.set(0);
                zzku();
                zzge().zzit().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zzix().beginTransaction();
                try {
                    for (Long next : list) {
                        try {
                            zzix = zzix();
                            long longValue = next.longValue();
                            zzix.zzab();
                            zzix.zzch();
                            if (zzix.getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zzix.zzge().zzim().zzg("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzaqr == null || !this.zzaqr.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zzix().setTransactionSuccessful();
                    zzix().endTransaction();
                    this.zzaqr = null;
                    if (!zzkn().zzex() || !zzkt()) {
                        this.zzaqs = -1;
                        zzku();
                    } else {
                        zzks();
                    }
                    this.zzaqh = 0;
                } catch (Throwable th3) {
                    zzix().endTransaction();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                zzge().zzim().zzg("Database error while trying to delete uploaded bundles", e3);
                this.zzaqh = zzbt().elapsedRealtime();
                zzge().zzit().zzg("Disable upload, time", Long.valueOf(this.zzaqh));
            }
        } else {
            zzge().zzit().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (i == 503 || i == 429) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            if (zzgg().zzax(str)) {
                zzix().zzc(list);
            }
            zzku();
        }
        this.zzaqm = false;
        zzkv();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgl zzgl) {
        this.zzacw = zzgl;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzjw zzjw) {
        zzab();
        zzei zzei = new zzei(this.zzacw);
        zzei.zzm();
        this.zzaqc = zzei;
        zzgg().zza(this.zzaqa);
        zzeb zzeb = new zzeb(this.zzacw);
        zzeb.zzm();
        this.zzaqf = zzeb;
        zzjn zzjn = new zzjn(this.zzacw);
        zzjn.zzm();
        this.zzaqe = zzjn;
        this.zzaqd = new zzfp(this.zzacw);
        if (this.zzaqj != this.zzaqk) {
            zzge().zzim().zze("Not all upload components initialized", Integer.valueOf(this.zzaqj), Integer.valueOf(this.zzaqk));
        }
        this.zzvo = true;
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzeu zzeu, @Size(min = 1) String str) {
        long j;
        zzks zzks;
        zzkq();
        zzab();
        zzgl.zzfr();
        Preconditions.checkNotNull(zzeu);
        Preconditions.checkNotEmpty(str);
        zzkp zzkp = new zzkp();
        zzix().beginTransaction();
        try {
            zzdy zzbc = zzix().zzbc(str);
            if (zzbc == null) {
                zzge().zzis().zzg("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzbc.isMeasurementEnabled()) {
                zzge().zzis().zzg("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzix().endTransaction();
                return bArr;
            } else {
                if (("_iap".equals(zzeu.name) || FirebaseAnalytics.Event.ECOMMERCE_PURCHASE.equals(zzeu.name)) && !zza(str, zzeu)) {
                    zzge().zzip().zzg("Failed to handle purchase event at single event bundle creation. appId", zzfg.zzbm(str));
                }
                boolean zzav = zzgg().zzav(str);
                Long l = 0L;
                if (zzav && "_e".equals(zzeu.name)) {
                    if (zzeu.zzafq == null || zzeu.zzafq.size() == 0) {
                        zzge().zzip().zzg("The engagement event does not contain any parameters. appId", zzfg.zzbm(str));
                    } else if (zzeu.zzafq.getLong("_et") == null) {
                        zzge().zzip().zzg("The engagement event does not include duration. appId", zzfg.zzbm(str));
                    } else {
                        l = zzeu.zzafq.getLong("_et");
                    }
                }
                zzkq zzkq = new zzkq();
                zzkp.zzatf = new zzkq[]{zzkq};
                zzkq.zzath = 1;
                zzkq.zzatp = "android";
                zzkq.zzti = zzbc.zzah();
                zzkq.zzadt = zzbc.zzgn();
                zzkq.zzth = zzbc.zzag();
                long zzgm = zzbc.zzgm();
                zzkq.zzaub = zzgm == -2147483648L ? null : Integer.valueOf((int) zzgm);
                zzkq.zzatt = Long.valueOf(zzbc.zzgo());
                zzkq.zzadm = zzbc.getGmpAppId();
                zzkq.zzatx = Long.valueOf(zzbc.zzgp());
                if (this.zzacw.isEnabled() && zzef.zzhk() && zzgg().zzat(zzkq.zzti)) {
                    zzkq.zzauh = null;
                }
                Pair<String, Boolean> zzbo = zzgf().zzbo(zzbc.zzah());
                if (zzbc.zzhd() && zzbo != null && !TextUtils.isEmpty((CharSequence) zzbo.first)) {
                    zzkq.zzatv = (String) zzbo.first;
                    zzkq.zzatw = (Boolean) zzbo.second;
                }
                zzfw().zzch();
                zzkq.zzatr = Build.MODEL;
                zzfw().zzch();
                zzkq.zzatq = Build.VERSION.RELEASE;
                zzkq.zzats = Integer.valueOf((int) zzfw().zzic());
                zzkq.zzafn = zzfw().zzid();
                zzkq.zzadl = zzbc.getAppInstanceId();
                zzkq.zzado = zzbc.zzgj();
                List<zzjz> zzbb = zzix().zzbb(zzbc.zzah());
                zzkq.zzatj = new zzks[zzbb.size()];
                zzjz zzjz = null;
                if (zzav) {
                    zzjz zzh = zzix().zzh(zzkq.zzti, "_lte");
                    zzjz = (zzh == null || zzh.value == null) ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), l) : l.longValue() > 0 ? new zzjz(zzkq.zzti, "auto", "_lte", zzbt().currentTimeMillis(), Long.valueOf(((Long) zzh.value).longValue() + l.longValue())) : zzh;
                }
                zzks zzks2 = null;
                int i = 0;
                while (i < zzbb.size()) {
                    zzks zzks3 = new zzks();
                    zzkq.zzatj[i] = zzks3;
                    zzks3.name = zzbb.get(i).name;
                    zzks3.zzaun = Long.valueOf(zzbb.get(i).zzaqz);
                    zzgb().zza(zzks3, zzbb.get(i).value);
                    if (!zzav || !"_lte".equals(zzks3.name)) {
                        zzks = zzks2;
                    } else {
                        zzks3.zzate = (Long) zzjz.value;
                        zzks3.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                        zzks = zzks3;
                    }
                    i++;
                    zzks2 = zzks;
                }
                if (zzav && zzks2 == null) {
                    zzks zzks4 = new zzks();
                    zzks4.name = "_lte";
                    zzks4.zzaun = Long.valueOf(zzbt().currentTimeMillis());
                    zzks4.zzate = (Long) zzjz.value;
                    zzkq.zzatj = (zzks[]) Arrays.copyOf(zzkq.zzatj, zzkq.zzatj.length + 1);
                    zzkq.zzatj[zzkq.zzatj.length - 1] = zzks4;
                }
                if (l.longValue() > 0) {
                    zzix().zza(zzjz);
                }
                Bundle zzif = zzeu.zzafq.zzif();
                if ("_iap".equals(zzeu.name)) {
                    zzif.putLong("_c", 1);
                    zzge().zzis().log("Marking in-app purchase as real-time");
                    zzif.putLong("_r", 1);
                }
                zzif.putString("_o", zzeu.origin);
                if (zzgb().zzcj(zzkq.zzti)) {
                    zzgb().zza(zzif, "_dbg", (Object) 1L);
                    zzgb().zza(zzif, "_r", (Object) 1L);
                }
                zzeq zzf = zzix().zzf(str, zzeu.name);
                if (zzf == null) {
                    zzix().zza(new zzeq(str, zzeu.name, 1, 0, zzeu.zzagb, 0, (Long) null, (Long) null, (Boolean) null));
                    j = 0;
                } else {
                    j = zzf.zzaft;
                    zzix().zza(zzf.zzac(zzeu.zzagb).zzie());
                }
                zzep zzep = new zzep(this.zzacw, zzeu.origin, str, zzeu.name, zzeu.zzagb, j, zzif);
                zzkn zzkn = new zzkn();
                zzkq.zzati = new zzkn[]{zzkn};
                zzkn.zzatb = Long.valueOf(zzep.timestamp);
                zzkn.name = zzep.name;
                zzkn.zzatc = Long.valueOf(zzep.zzafp);
                zzkn.zzata = new zzko[zzep.zzafq.size()];
                Iterator<String> it = zzep.zzafq.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzko zzko = new zzko();
                    zzkn.zzata[i2] = zzko;
                    zzko.name = next;
                    zzgb().zza(zzko, zzep.zzafq.get(next));
                    i2++;
                }
                zzkq.zzaua = zza(zzbc.zzah(), zzkq.zzatj, zzkq.zzati);
                zzkq.zzatl = zzkn.zzatb;
                zzkq.zzatm = zzkn.zzatb;
                long zzgl = zzbc.zzgl();
                zzkq.zzato = zzgl != 0 ? Long.valueOf(zzgl) : null;
                long zzgk = zzbc.zzgk();
                if (zzgk != 0) {
                    zzgl = zzgk;
                }
                zzkq.zzatn = zzgl != 0 ? Long.valueOf(zzgl) : null;
                zzbc.zzgt();
                zzkq.zzaty = Integer.valueOf((int) zzbc.zzgq());
                zzkq.zzatu = 12451L;
                zzkq.zzatk = Long.valueOf(zzbt().currentTimeMillis());
                zzkq.zzatz = Boolean.TRUE;
                zzbc.zzm(zzkq.zzatl.longValue());
                zzbc.zzn(zzkq.zzatm.longValue());
                zzix().zza(zzbc);
                zzix().setTransactionSuccessful();
                zzix().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzkp.zzvm()];
                    zzabw zzb = zzabw.zzb(bArr2, 0, bArr2.length);
                    zzkp.zza(zzb);
                    zzb.zzve();
                    return zzgb().zza(bArr2);
                } catch (IOException e) {
                    zzge().zzim().zze("Data loss. Failed to bundle and serialize. appId", zzfg.zzbm(str), e);
                    return null;
                }
            }
        } finally {
            zzix().endTransaction();
        }
    }

    @WorkerThread
    public void zzab() {
        zzgd().zzab();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzed zzed, zzdz zzdz) {
        boolean z = true;
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.origin);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzed zzed2 = new zzed(zzed);
            zzed2.active = false;
            zzix().beginTransaction();
            try {
                zzed zzi = zzix().zzi(zzed2.packageName, zzed2.zzaep.name);
                if (zzi != null && !zzi.origin.equals(zzed2.origin)) {
                    zzge().zzip().zzd("Updating a conditional user property with different origin. name, origin, origin (from DB)", zzga().zzbl(zzed2.zzaep.name), zzed2.origin, zzi.origin);
                }
                if (zzi != null && zzi.active) {
                    zzed2.origin = zzi.origin;
                    zzed2.creationTimestamp = zzi.creationTimestamp;
                    zzed2.triggerTimeout = zzi.triggerTimeout;
                    zzed2.triggerEventName = zzi.triggerEventName;
                    zzed2.zzaer = zzi.zzaer;
                    zzed2.active = zzi.active;
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzi.zzaep.zzaqz, zzed2.zzaep.getValue(), zzi.zzaep.origin);
                    z = false;
                } else if (TextUtils.isEmpty(zzed2.triggerEventName)) {
                    zzed2.zzaep = new zzjx(zzed2.zzaep.name, zzed2.creationTimestamp, zzed2.zzaep.getValue(), zzed2.zzaep.origin);
                    zzed2.active = true;
                } else {
                    z = false;
                }
                if (zzed2.active) {
                    zzjx zzjx = zzed2.zzaep;
                    zzjz zzjz = new zzjz(zzed2.packageName, zzed2.origin, zzjx.name, zzjx.zzaqz, zzjx.getValue());
                    if (zzix().zza(zzjz)) {
                        zzge().zzis().zzd("User property updated immediately", zzed2.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                    } else {
                        zzge().zzim().zzd("(2)Too many active user properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                    }
                    if (z && zzed2.zzaer != null) {
                        zzc(new zzeu(zzed2.zzaer, zzed2.creationTimestamp), zzdz);
                    }
                }
                if (zzix().zza(zzed2)) {
                    zzge().zzis().zzd("Conditional property added", zzed2.packageName, zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                } else {
                    zzge().zzim().zzd("Too many conditional properties, ignoring", zzfg.zzbm(zzed2.packageName), zzga().zzbl(zzed2.zzaep.name), zzed2.zzaep.getValue());
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzeu zzeu, zzdz zzdz) {
        List<zzed> zzb;
        List<zzed> zzb2;
        List<zzed> zzb3;
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzab();
        zzkq();
        String str = zzdz.packageName;
        long j = zzeu.zzagb;
        zzgb();
        if (zzka.zzd(zzeu, zzdz)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzix().beginTransaction();
            try {
                zzei zzix = zzix();
                Preconditions.checkNotEmpty(str);
                zzix.zzab();
                zzix.zzch();
                if (j < 0) {
                    zzix.zzge().zzip().zze("Invalid time querying timed out conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    zzb = Collections.emptyList();
                } else {
                    zzb = zzix.zzb("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzed next : zzb) {
                    if (next != null) {
                        zzge().zzis().zzd("User property timed out", next.packageName, zzga().zzbl(next.zzaep.name), next.zzaep.getValue());
                        if (next.zzaeq != null) {
                            zzc(new zzeu(next.zzaeq, j), zzdz);
                        }
                        zzix().zzj(str, next.zzaep.name);
                    }
                }
                zzei zzix2 = zzix();
                Preconditions.checkNotEmpty(str);
                zzix2.zzab();
                zzix2.zzch();
                if (j < 0) {
                    zzix2.zzge().zzip().zze("Invalid time querying expired conditional properties", zzfg.zzbm(str), Long.valueOf(j));
                    zzb2 = Collections.emptyList();
                } else {
                    zzb2 = zzix2.zzb("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(zzb2.size());
                for (zzed next2 : zzb2) {
                    if (next2 != null) {
                        zzge().zzis().zzd("User property expired", next2.packageName, zzga().zzbl(next2.zzaep.name), next2.zzaep.getValue());
                        zzix().zzg(str, next2.zzaep.name);
                        if (next2.zzaes != null) {
                            arrayList.add(next2.zzaes);
                        }
                        zzix().zzj(str, next2.zzaep.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzc(new zzeu((zzeu) obj, j), zzdz);
                }
                zzei zzix3 = zzix();
                String str2 = zzeu.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzix3.zzab();
                zzix3.zzch();
                if (j < 0) {
                    zzix3.zzge().zzip().zzd("Invalid time querying triggered conditional properties", zzfg.zzbm(str), zzix3.zzga().zzbj(str2), Long.valueOf(j));
                    zzb3 = Collections.emptyList();
                } else {
                    zzb3 = zzix3.zzb("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(zzb3.size());
                for (zzed next3 : zzb3) {
                    if (next3 != null) {
                        zzjx zzjx = next3.zzaep;
                        zzjz zzjz = new zzjz(next3.packageName, next3.origin, zzjx.name, j, zzjx.getValue());
                        if (zzix().zza(zzjz)) {
                            zzge().zzis().zzd("User property triggered", next3.packageName, zzga().zzbl(zzjz.name), zzjz.value);
                        } else {
                            zzge().zzim().zzd("Too many active user properties, ignoring", zzfg.zzbm(next3.packageName), zzga().zzbl(zzjz.name), zzjz.value);
                        }
                        if (next3.zzaer != null) {
                            arrayList3.add(next3.zzaer);
                        }
                        next3.zzaep = new zzjx(zzjz);
                        next3.active = true;
                        zzix().zza(next3);
                    }
                }
                zzc(zzeu, zzdz);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzc(new zzeu((zzeu) obj2, j), zzdz);
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzjq zzjq) {
        this.zzaqj++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzjx zzjx, zzdz zzdz) {
        int i = 0;
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            int zzcf = zzgb().zzcf(zzjx.name);
            if (zzcf != 0) {
                zzgb();
                String zza = zzka.zza(zzjx.name, 24, true);
                if (zzjx.name != null) {
                    i = zzjx.name.length();
                }
                zzgb().zza(zzdz.packageName, zzcf, "_ev", zza, i);
                return;
            }
            int zzi = zzgb().zzi(zzjx.name, zzjx.getValue());
            if (zzi != 0) {
                zzgb();
                String zza2 = zzka.zza(zzjx.name, 24, true);
                Object value = zzjx.getValue();
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i = String.valueOf(value).length();
                }
                zzgb().zza(zzdz.packageName, zzi, "_ev", zza2, i);
                return;
            }
            Object zzj = zzgb().zzj(zzjx.name, zzjx.getValue());
            if (zzj != null) {
                zzjz zzjz = new zzjz(zzdz.packageName, zzjx.origin, zzjx.name, zzjx.zzaqz, zzj);
                zzge().zzis().zze("Setting user property", zzga().zzbl(zzjz.name), zzj);
                zzix().beginTransaction();
                try {
                    zzg(zzdz);
                    boolean zza3 = zzix().zza(zzjz);
                    zzix().setTransactionSuccessful();
                    if (zza3) {
                        zzge().zzis().zze("User property set", zzga().zzbl(zzjz.name), zzjz.value);
                    } else {
                        zzge().zzim().zze("Too many unique user properties are set. Ignoring user property", zzga().zzbl(zzjz.name), zzjz.value);
                        zzgb().zza(zzdz.packageName, 9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzix().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = true;
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(str);
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzaql = false;
                zzkv();
                throw th2;
            }
        }
        zzge().zzit().zzg("onConfigFetched. Response size", Integer.valueOf(bArr.length));
        zzix().beginTransaction();
        zzdy zzbc = zzix().zzbc(str);
        boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
        if (zzbc == null) {
            zzge().zzip().zzg("App does not exist in onConfigFetched. appId", zzfg.zzbm(str));
        } else if (z2 || i == 404) {
            List list = map != null ? map.get("Last-Modified") : null;
            String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
            if (i == 404 || i == 304) {
                if (zzkm().zzbu(str) == null && !zzkm().zza(str, (byte[]) null, (String) null)) {
                    zzix().endTransaction();
                    this.zzaql = false;
                    zzkv();
                    return;
                }
            } else if (!zzkm().zza(str, bArr, str2)) {
                zzix().endTransaction();
                this.zzaql = false;
                zzkv();
                return;
            }
            zzbc.zzs(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            if (i == 404) {
                zzge().zziq().zzg("Config not found. Using empty config. appId", str);
            } else {
                zzge().zzit().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            }
            if (!zzkn().zzex() || !zzkt()) {
                zzku();
            } else {
                zzks();
            }
        } else {
            zzbc.zzt(zzbt().currentTimeMillis());
            zzix().zza(zzbc);
            zzge().zzit().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
            zzkm().zzbw(str);
            zzgf().zzajv.set(zzbt().currentTimeMillis());
            if (!(i == 503 || i == 429)) {
                z = false;
            }
            if (z) {
                zzgf().zzajw.set(zzbt().currentTimeMillis());
            }
            zzku();
        }
        zzix().setTransactionSuccessful();
        zzix().endTransaction();
        this.zzaql = false;
        zzkv();
    }

    public Clock zzbt() {
        return this.zzacw.zzbt();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzed zzed, zzdz zzdz) {
        Preconditions.checkNotNull(zzed);
        Preconditions.checkNotEmpty(zzed.packageName);
        Preconditions.checkNotNull(zzed.zzaep);
        Preconditions.checkNotEmpty(zzed.zzaep.name);
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzed zzi = zzix().zzi(zzed.packageName, zzed.zzaep.name);
                if (zzi != null) {
                    zzge().zzis().zze("Removing conditional user property", zzed.packageName, zzga().zzbl(zzed.zzaep.name));
                    zzix().zzj(zzed.packageName, zzed.zzaep.name);
                    if (zzi.active) {
                        zzix().zzg(zzed.packageName, zzed.zzaep.name);
                    }
                    if (zzed.zzaes != null) {
                        Bundle bundle = null;
                        if (zzed.zzaes.zzafq != null) {
                            bundle = zzed.zzaes.zzafq.zzif();
                        }
                        zzc(zzgb().zza(zzed.zzaes.name, bundle, zzi.origin, zzed.zzaes.zzagb, true, false), zzdz);
                    }
                } else {
                    zzge().zzip().zze("Conditional user property doesn't exist", zzfg.zzbm(zzed.packageName), zzga().zzbl(zzed.zzaep.name));
                }
                zzix().setTransactionSuccessful();
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzeu zzeu, String str) {
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping event", str);
            return;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null) {
            if (!"_ui".equals(zzeu.name)) {
                zzge().zzip().zzg("Could not find package. appId", zzfg.zzbm(str));
            }
        } else if (!zzc.booleanValue()) {
            zzge().zzim().zzg("App version does not match; dropping event. appId", zzfg.zzbm(str));
            return;
        }
        zzeu zzeu2 = zzeu;
        zzb(zzeu2, new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(zzjx zzjx, zzdz zzdz) {
        zzab();
        zzkq();
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            zzge().zzis().zzg("Removing user property", zzga().zzbl(zzjx.name));
            zzix().beginTransaction();
            try {
                zzg(zzdz);
                zzix().zzg(zzdz.packageName, zzjx.name);
                zzix().setTransactionSuccessful();
                zzge().zzis().zzg("User property removed", zzga().zzbl(zzjx.name));
            } finally {
                zzix().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzdz zzcb(String str) {
        zzdy zzbc = zzix().zzbc(str);
        if (zzbc == null || TextUtils.isEmpty(zzbc.zzag())) {
            zzge().zzis().zzg("No app data available; dropping", str);
            return null;
        }
        Boolean zzc = zzc(zzbc);
        if (zzc == null || zzc.booleanValue()) {
            return new zzdz(str, zzbc.getGmpAppId(), zzbc.zzag(), zzbc.zzgm(), zzbc.zzgn(), zzbc.zzgo(), zzbc.zzgp(), (String) null, zzbc.isMeasurementEnabled(), false, zzbc.zzgj(), zzbc.zzhc(), 0, 0, zzbc.zzhd(), zzbc.zzhe(), false);
        }
        zzge().zzim().zzg("App version does not match; dropping. appId", zzfg.zzbm(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzd(zzdz zzdz) {
        if (this.zzaqq != null) {
            this.zzaqr = new ArrayList();
            this.zzaqr.addAll(this.zzaqq);
        }
        zzei zzix = zzix();
        String str = zzdz.packageName;
        Preconditions.checkNotEmpty(str);
        zzix.zzab();
        zzix.zzch();
        try {
            SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("main_event_params", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + 0 + writableDatabase.delete("events", "app_id=?", strArr) + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("queue", "app_id=?", strArr) + writableDatabase.delete("audience_filter_values", "app_id=?", strArr);
            if (delete > 0) {
                zzix.zzge().zzit().zze("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzix.zzge().zzim().zze("Error resetting analytics data. appId, error", zzfg.zzbm(str), e);
        }
        zzdz zza = zza(getContext(), zzdz.packageName, zzdz.zzadm, zzdz.zzadw, zzdz.zzady, zzdz.zzadz, zzdz.zzaem);
        if (!zzgg().zzaz(zzdz.packageName) || zzdz.zzadw) {
            zzf(zza);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zze(zzdz zzdz) {
        zzab();
        zzkq();
        Preconditions.checkNotEmpty(zzdz.packageName);
        zzg(zzdz);
    }

    @WorkerThread
    public final void zzf(zzdz zzdz) {
        int i;
        zzdy zzbc;
        ApplicationInfo applicationInfo;
        zzei zzix;
        String zzah;
        zzab();
        zzkq();
        Preconditions.checkNotNull(zzdz);
        Preconditions.checkNotEmpty(zzdz.packageName);
        if (!TextUtils.isEmpty(zzdz.zzadm)) {
            zzdy zzbc2 = zzix().zzbc(zzdz.packageName);
            if (zzbc2 != null && TextUtils.isEmpty(zzbc2.getGmpAppId()) && !TextUtils.isEmpty(zzdz.zzadm)) {
                zzbc2.zzs(0);
                zzix().zza(zzbc2);
                zzkm().zzbx(zzdz.packageName);
            }
            if (!zzdz.zzadw) {
                zzg(zzdz);
                return;
            }
            long j = zzdz.zzaem;
            if (j == 0) {
                j = zzbt().currentTimeMillis();
            }
            int i2 = zzdz.zzaen;
            if (i2 == 0 || i2 == 1) {
                i = i2;
            } else {
                zzge().zzip().zze("Incorrect app type, assuming installed app. appId, appType", zzfg.zzbm(zzdz.packageName), Integer.valueOf(i2));
                i = 0;
            }
            zzix().beginTransaction();
            try {
                zzbc = zzix().zzbc(zzdz.packageName);
                if (!(zzbc == null || zzbc.getGmpAppId() == null || zzbc.getGmpAppId().equals(zzdz.zzadm))) {
                    zzge().zzip().zzg("New GMP App Id passed in. Removing cached database data. appId", zzfg.zzbm(zzbc.zzah()));
                    zzix = zzix();
                    zzah = zzbc.zzah();
                    zzix.zzch();
                    zzix.zzab();
                    Preconditions.checkNotEmpty(zzah);
                    SQLiteDatabase writableDatabase = zzix.getWritableDatabase();
                    String[] strArr = {zzah};
                    int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("conditional_properties", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
                    if (delete > 0) {
                        zzix.zzge().zzit().zze("Deleted application data. app, records", zzah, Integer.valueOf(delete));
                    }
                    zzbc = null;
                }
            } catch (SQLiteException e) {
                zzix.zzge().zzim().zze("Error deleting application data. appId, error", zzfg.zzbm(zzah), e);
            } catch (Throwable th) {
                zzix().endTransaction();
                throw th;
            }
            if (zzbc != null) {
                if (zzbc.zzgm() != -2147483648L) {
                    if (zzbc.zzgm() != zzdz.zzads) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", zzbc.zzag());
                        zzb(new zzeu("_au", new zzer(bundle), "auto", j), zzdz);
                    }
                } else if (zzbc.zzag() != null && !zzbc.zzag().equals(zzdz.zzth)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", zzbc.zzag());
                    zzb(new zzeu("_au", new zzer(bundle2), "auto", j), zzdz);
                }
            }
            zzg(zzdz);
            zzeq zzeq = null;
            if (i == 0) {
                zzeq = zzix().zzf(zzdz.packageName, "_f");
            } else if (i == 1) {
                zzeq = zzix().zzf(zzdz.packageName, "_v");
            }
            if (zzeq == null) {
                long j2 = (1 + (j / 3600000)) * 3600000;
                if (i == 0) {
                    zzb(new zzjx("_fot", j, Long.valueOf(j2), "auto"), zzdz);
                    zzab();
                    zzkq();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1);
                    bundle3.putLong("_r", 1);
                    bundle3.putLong("_uwa", 0);
                    bundle3.putLong("_pfo", 0);
                    bundle3.putLong("_sys", 0);
                    bundle3.putLong("_sysu", 0);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle3.putLong("_dac", 1);
                    }
                    if (getContext().getPackageManager() == null) {
                        zzge().zzim().zzg("PackageManager is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName));
                    } else {
                        PackageInfo packageInfo = null;
                        try {
                            packageInfo = Wrappers.packageManager(getContext()).getPackageInfo(zzdz.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            zzge().zzim().zze("Package info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e2);
                        }
                        if (packageInfo != null) {
                            if (packageInfo.firstInstallTime != 0) {
                                boolean z = false;
                                if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                    bundle3.putLong("_uwa", 1);
                                } else {
                                    z = true;
                                }
                                zzb(new zzjx("_fi", j, Long.valueOf(z ? 1 : 0), "auto"), zzdz);
                            }
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(getContext()).getApplicationInfo(zzdz.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            zzge().zzim().zze("Application info is null, first open report might be inaccurate. appId", zzfg.zzbm(zzdz.packageName), e3);
                            applicationInfo = null;
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle3.putLong("_sys", 1);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle3.putLong("_sysu", 1);
                            }
                        }
                    }
                    zzei zzix2 = zzix();
                    String str = zzdz.packageName;
                    Preconditions.checkNotEmpty(str);
                    zzix2.zzab();
                    zzix2.zzch();
                    long zzm = zzix2.zzm(str, "first_open_count");
                    if (zzm >= 0) {
                        bundle3.putLong("_pfo", zzm);
                    }
                    zzb(new zzeu("_f", new zzer(bundle3), "auto", j), zzdz);
                } else if (i == 1) {
                    zzb(new zzjx("_fvt", j, Long.valueOf(j2), "auto"), zzdz);
                    zzab();
                    zzkq();
                    Bundle bundle4 = new Bundle();
                    bundle4.putLong("_c", 1);
                    bundle4.putLong("_r", 1);
                    if (zzgg().zzaz(zzdz.packageName) && zzdz.zzaeo) {
                        bundle4.putLong("_dac", 1);
                    }
                    zzb(new zzeu("_v", new zzer(bundle4), "auto", j), zzdz);
                }
                Bundle bundle5 = new Bundle();
                bundle5.putLong("_et", 1);
                zzb(new zzeu("_e", new zzer(bundle5), "auto", j), zzdz);
            } else if (zzdz.zzael) {
                zzb(new zzeu("_cd", new zzer(new Bundle()), "auto", j), zzdz);
            }
            zzix().setTransactionSuccessful();
            zzix().endTransaction();
        }
    }

    public zzeo zzfw() {
        return this.zzacw.zzfw();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzg(Runnable runnable) {
        zzab();
        if (this.zzaqi == null) {
            this.zzaqi = new ArrayList();
        }
        this.zzaqi.add(runnable);
    }

    public zzfe zzga() {
        return this.zzacw.zzga();
    }

    public zzka zzgb() {
        return this.zzacw.zzgb();
    }

    public zzgg zzgd() {
        return this.zzacw.zzgd();
    }

    public zzfg zzge() {
        return this.zzacw.zzge();
    }

    public zzfr zzgf() {
        return this.zzacw.zzgf();
    }

    public zzef zzgg() {
        return this.zzacw.zzgg();
    }

    public final String zzh(zzdz zzdz) {
        try {
            return (String) zzgd().zzb(new zzju(this, zzdz)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            zzge().zzim().zze("Failed to get app instance id. appId", zzfg.zzbm(zzdz.packageName), e);
            return null;
        }
    }

    public final zzeb zziw() {
        zza((zzjq) this.zzaqf);
        return this.zzaqf;
    }

    public final zzei zzix() {
        zza((zzjq) this.zzaqc);
        return this.zzaqc;
    }

    public final zzfk zzkn() {
        zza((zzjq) this.zzaqb);
        return this.zzaqb;
    }

    /* access modifiers changed from: package-private */
    public final void zzkq() {
        if (!this.zzvo) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    @WorkerThread
    public final void zzks() {
        String zzhn;
        zzdy zzbc;
        String str;
        List<Pair<zzkq, Long>> list;
        String str2;
        zzab();
        zzkq();
        this.zzaqn = true;
        try {
            Boolean zzkf = this.zzacw.zzfx().zzkf();
            if (zzkf == null) {
                zzge().zzip().log("Upload data called on the client side before use of service was decided");
                this.zzaqn = false;
                zzkv();
            } else if (zzkf.booleanValue()) {
                zzge().zzim().log("Upload called in the client side when service should be used");
                this.zzaqn = false;
                zzkv();
            } else if (this.zzaqh > 0) {
                zzku();
                this.zzaqn = false;
                zzkv();
            } else {
                zzab();
                if (this.zzaqq != null) {
                    zzge().zzit().log("Uploading requested multiple times");
                    this.zzaqn = false;
                    zzkv();
                } else if (!zzkn().zzex()) {
                    zzge().zzit().log("Network not connected, ignoring upload request");
                    zzku();
                    this.zzaqn = false;
                    zzkv();
                } else {
                    long currentTimeMillis = zzbt().currentTimeMillis();
                    zzd((String) null, currentTimeMillis - zzef.zzhi());
                    long j = zzgf().zzaju.get();
                    if (j != 0) {
                        zzge().zzis().zzg("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
                    }
                    zzhn = zzix().zzhn();
                    if (!TextUtils.isEmpty(zzhn)) {
                        if (this.zzaqs == -1) {
                            this.zzaqs = zzix().zzhu();
                        }
                        List<Pair<zzkq, Long>> zzb = zzix().zzb(zzhn, zzgg().zzb(zzhn, zzew.zzago), Math.max(0, zzgg().zzb(zzhn, zzew.zzagp)));
                        if (!zzb.isEmpty()) {
                            Iterator<Pair<zzkq, Long>> it = zzb.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    str = null;
                                    break;
                                }
                                zzkq zzkq = (zzkq) it.next().first;
                                if (!TextUtils.isEmpty(zzkq.zzatv)) {
                                    str = zzkq.zzatv;
                                    break;
                                }
                            }
                            if (str != null) {
                                int i = 0;
                                while (true) {
                                    if (i >= zzb.size()) {
                                        break;
                                    }
                                    zzkq zzkq2 = (zzkq) zzb.get(i).first;
                                    if (!TextUtils.isEmpty(zzkq2.zzatv) && !zzkq2.zzatv.equals(str)) {
                                        list = zzb.subList(0, i);
                                        break;
                                    }
                                    i++;
                                }
                            }
                            list = zzb;
                            zzkp zzkp = new zzkp();
                            zzkp.zzatf = new zzkq[list.size()];
                            ArrayList arrayList = new ArrayList(list.size());
                            boolean z = zzef.zzhk() && zzgg().zzat(zzhn);
                            for (int i2 = 0; i2 < zzkp.zzatf.length; i2++) {
                                zzkp.zzatf[i2] = (zzkq) list.get(i2).first;
                                arrayList.add((Long) list.get(i2).second);
                                zzkp.zzatf[i2].zzatu = 12451L;
                                zzkp.zzatf[i2].zzatk = Long.valueOf(currentTimeMillis);
                                zzkp.zzatf[i2].zzatz = false;
                                if (!z) {
                                    zzkp.zzatf[i2].zzauh = null;
                                }
                            }
                            String zza = zzge().isLoggable(2) ? zzga().zza(zzkp) : null;
                            byte[] zzb2 = zzgb().zzb(zzkp);
                            str2 = zzew.zzagy.get();
                            URL url = new URL(str2);
                            Preconditions.checkArgument(!arrayList.isEmpty());
                            if (this.zzaqq != null) {
                                zzge().zzim().log("Set uploading progress before finishing the previous upload");
                            } else {
                                this.zzaqq = new ArrayList(arrayList);
                            }
                            zzgf().zzajv.set(currentTimeMillis);
                            String str3 = "?";
                            if (zzkp.zzatf.length > 0) {
                                str3 = zzkp.zzatf[0].zzti;
                            }
                            zzge().zzit().zzd("Uploading data. app, uncompressed size, data", str3, Integer.valueOf(zzb2.length), zza);
                            this.zzaqm = true;
                            zzfk zzkn = zzkn();
                            zzjs zzjs = new zzjs(this, zzhn);
                            zzkn.zzab();
                            zzkn.zzch();
                            Preconditions.checkNotNull(url);
                            Preconditions.checkNotNull(zzb2);
                            Preconditions.checkNotNull(zzjs);
                            zzkn.zzgd().zzd((Runnable) new zzfo(zzkn, zzhn, url, zzb2, (Map<String, String>) null, zzjs));
                        }
                    } else {
                        this.zzaqs = -1;
                        String zzab = zzix().zzab(currentTimeMillis - zzef.zzhi());
                        if (!TextUtils.isEmpty(zzab) && (zzbc = zzix().zzbc(zzab)) != null) {
                            zzb(zzbc);
                        }
                    }
                    this.zzaqn = false;
                    zzkv();
                }
            }
        } catch (MalformedURLException e) {
            zzge().zzim().zze("Failed to parse upload URL. Not uploading. appId", zzfg.zzbm(zzhn), str2);
        } catch (Throwable th) {
            this.zzaqn = false;
            zzkv();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzkx() {
        zzab();
        zzkq();
        if (!this.zzaqg) {
            zzge().zzir().log("This instance being marked as an uploader");
            zzab();
            zzkq();
            if (zzky() && zzkw()) {
                int zza = zza(this.zzaqp);
                int zzij = this.zzacw.zzfv().zzij();
                zzab();
                if (zza > zzij) {
                    zzge().zzim().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                } else if (zza < zzij) {
                    if (zza(zzij, this.zzaqp)) {
                        zzge().zzit().zze("Storage version upgraded. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    } else {
                        zzge().zzim().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza), Integer.valueOf(zzij));
                    }
                }
            }
            this.zzaqg = true;
            zzku();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzkz() {
        this.zzaqk++;
    }

    /* access modifiers changed from: package-private */
    public final zzgl zzla() {
        return this.zzacw;
    }

    public final void zzm(boolean z) {
        zzku();
    }
}
