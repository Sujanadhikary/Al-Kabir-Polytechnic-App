package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

final class zzei extends zzjq {
    /* access modifiers changed from: private */
    public static final String[] zzaev = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaew = {FirebaseAnalytics.Param.ORIGIN, "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzaex = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaey = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzaez = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzafa = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzel zzafb = new zzel(this, getContext(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzjm zzafc = new zzjm(zzbt());

    zzei(zzjr zzjr) {
        super(zzjr);
    }

    @WorkerThread
    private final long zza(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        switch (type) {
            case 0:
                zzge().zzim().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzge().zzim().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzge().zzim().zzg("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
        }
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase) {
        if (zzfg == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzfg.zzip().log("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzfg.zzip().log("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzfg.zzip().log("Failed to turn on database read permission for owner");
        }
        if (!file.setWritable(true, true)) {
            zzfg.zzip().log("Failed to turn on database write permission for owner");
        }
    }

    @WorkerThread
    static void zza(zzfg zzfg, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzfg == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!zza(zzfg, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        if (zzfg == null) {
            try {
                throw new IllegalArgumentException("Monitor must not be null");
            } catch (SQLiteException e) {
                zzfg.zzim().zzg("Failed to verify columns on table that was just created", str);
                throw e;
            }
        } else {
            Set<String> zzb = zzb(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!zzb.remove(str4)) {
                    throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length()).append("Table ").append(str).append(" is missing required column: ").append(str4).toString());
                }
            }
            if (strArr != null) {
                for (int i = 0; i < strArr.length; i += 2) {
                    if (!zzb.remove(strArr[i])) {
                        sQLiteDatabase.execSQL(strArr[i + 1]);
                    }
                }
            }
            if (!zzb.isEmpty()) {
                zzfg.zzip().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zza(com.google.android.gms.internal.measurement.zzfg r10, android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r8 = 0
            r9 = 0
            if (r10 != 0) goto L_0x000c
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Monitor must not be null"
            r0.<init>(r1)
            throw r0
        L_0x000c:
            java.lang.String r1 = "SQLITE_MASTER"
            r0 = 1
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
            r0 = 0
            java.lang.String r3 = "name"
            r2[r0] = r3     // Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
            java.lang.String r3 = "name=?"
            r0 = 1
            java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
            r0 = 0
            r4[r0] = r12     // Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
            r5 = 0
            r6 = 0
            r7 = 0
            r0 = r11
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0030, all -> 0x0042 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x004c }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            r0 = move-exception
            r1 = r9
        L_0x0032:
            com.google.android.gms.internal.measurement.zzfi r2 = r10.zzip()     // Catch:{ all -> 0x0049 }
            java.lang.String r3 = "Error querying for table"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x0049 }
            if (r1 == 0) goto L_0x0040
            r1.close()
        L_0x0040:
            r0 = r8
            goto L_0x002f
        L_0x0042:
            r0 = move-exception
        L_0x0043:
            if (r9 == 0) goto L_0x0048
            r9.close()
        L_0x0048:
            throw r0
        L_0x0049:
            r0 = move-exception
            r9 = r1
            goto L_0x0043
        L_0x004c:
            r0 = move-exception
            goto L_0x0032
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(com.google.android.gms.internal.measurement.zzfg, android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzke zzke) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzke);
        if (TextUtils.isEmpty(zzke.zzarq)) {
            zzge().zzip().zzd("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzke.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[zzke.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzke.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzke.zzarp);
            contentValues.put("event_name", zzke.zzarq);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                    zzge().zzim().zzg("Failed to insert event filter (got -1). appId", zzfg.zzbm(str));
                }
                return true;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing event filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize event filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzkh zzkh) {
        zzch();
        zzab();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzkh);
        if (TextUtils.isEmpty(zzkh.zzasf)) {
            zzge().zzip().zzd("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zzfg.zzbm(str), Integer.valueOf(i), String.valueOf(zzkh.zzarp));
            return false;
        }
        try {
            byte[] bArr = new byte[zzkh.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkh.zza(zzb);
            zzb.zzve();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzkh.zzarp);
            contentValues.put("property_name", zzkh.zzasf);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert property filter (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing property filter. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Configuration loss. Failed to serialize property filter. appId", zzfg.zzbm(str), e2);
            return false;
        }
    }

    private final boolean zza(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzch();
        zzab();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zza = zza("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzgg().zzb(str, zzew.zzahn)));
            if (zza <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            String sb = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            return writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(sb).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(sb).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzge().zzim().zze("Database error querying filters. appId", zzfg.zzbm(str), e);
            return false;
        }
    }

    @WorkerThread
    private static Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), (String[]) null);
        try {
            Collections.addAll(hashSet, rawQuery.getColumnNames());
            return hashSet;
        } finally {
            rawQuery.close();
        }
    }

    private final boolean zzhv() {
        return getContext().getDatabasePath("google_app_measurement.db").exists();
    }

    @WorkerThread
    public final void beginTransaction() {
        zzch();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public final void endTransaction() {
        zzch();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final SQLiteDatabase getWritableDatabase() {
        zzab();
        try {
            return this.zzafb.getWritableDatabase();
        } catch (SQLiteException e) {
            zzge().zzip().zzg("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public final void setTransactionSuccessful() {
        zzch();
        getWritableDatabase().setTransactionSuccessful();
    }

    public final long zza(zzkq zzkq) throws IOException {
        long zzc;
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            zzka zzgb = zzgb();
            Preconditions.checkNotNull(bArr);
            zzgb.zzab();
            MessageDigest messageDigest = zzka.getMessageDigest("MD5");
            if (messageDigest == null) {
                zzgb.zzge().zzim().log("Failed to get MD5");
                zzc = 0;
            } else {
                zzc = zzka.zzc(messageDigest.digest(bArr));
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzc));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
                return zzc;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event metadata. appId", zzfg.zzbm(zzkq.zzti), e);
                throw e;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event metadata. appId", zzfg.zzbm(zzkq.zzti), e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x008f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzkn, java.lang.Long> zza(java.lang.String r7, java.lang.Long r8) {
        /*
            r6 = this;
            r0 = 0
            r6.zzab()
            r6.zzch()
            android.database.sqlite.SQLiteDatabase r1 = r6.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            r4 = 0
            r3[r4] = r7     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            r4 = 1
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0075, all -> 0x008a }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0095 }
            if (r1 != 0) goto L_0x0037
            com.google.android.gms.internal.measurement.zzfg r1 = r6.zzge()     // Catch:{ SQLiteException -> 0x0095 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzit()     // Catch:{ SQLiteException -> 0x0095 }
            java.lang.String r3 = "Main event not found"
            r1.log(r3)     // Catch:{ SQLiteException -> 0x0095 }
            if (r2 == 0) goto L_0x0036
            r2.close()
        L_0x0036:
            return r0
        L_0x0037:
            r1 = 0
            byte[] r1 = r2.getBlob(r1)     // Catch:{ SQLiteException -> 0x0095 }
            r3 = 1
            long r4 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x0095 }
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0095 }
            r4 = 0
            int r5 = r1.length     // Catch:{ SQLiteException -> 0x0095 }
            com.google.android.gms.internal.measurement.zzabv r1 = com.google.android.gms.internal.measurement.zzabv.zza(r1, r4, r5)     // Catch:{ SQLiteException -> 0x0095 }
            com.google.android.gms.internal.measurement.zzkn r4 = new com.google.android.gms.internal.measurement.zzkn     // Catch:{ SQLiteException -> 0x0095 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0095 }
            r4.zzb(r1)     // Catch:{ IOException -> 0x005d }
            android.util.Pair r0 = android.util.Pair.create(r4, r3)     // Catch:{ SQLiteException -> 0x0095 }
            if (r2 == 0) goto L_0x0036
            r2.close()
            goto L_0x0036
        L_0x005d:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r3 = r6.zzge()     // Catch:{ SQLiteException -> 0x0095 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ SQLiteException -> 0x0095 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r7)     // Catch:{ SQLiteException -> 0x0095 }
            r3.zzd(r4, r5, r8, r1)     // Catch:{ SQLiteException -> 0x0095 }
            if (r2 == 0) goto L_0x0036
            r2.close()
            goto L_0x0036
        L_0x0075:
            r1 = move-exception
            r2 = r0
        L_0x0077:
            com.google.android.gms.internal.measurement.zzfg r3 = r6.zzge()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x0093 }
            java.lang.String r4 = "Error selecting main event"
            r3.zzg(r4, r1)     // Catch:{ all -> 0x0093 }
            if (r2 == 0) goto L_0x0036
            r2.close()
            goto L_0x0036
        L_0x008a:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x008d:
            if (r2 == 0) goto L_0x0092
            r2.close()
        L_0x0092:
            throw r0
        L_0x0093:
            r0 = move-exception
            goto L_0x008d
        L_0x0095:
            r1 = move-exception
            goto L_0x0077
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0135  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzej zza(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            r11.zzab()
            r11.zzch()
            r0 = 1
            java.lang.String[] r10 = new java.lang.String[r0]
            r0 = 0
            r10[r0] = r14
            com.google.android.gms.internal.measurement.zzej r8 = new com.google.android.gms.internal.measurement.zzej
            r8.<init>()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            java.lang.String r1 = "apps"
            r2 = 6
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 0
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 1
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 2
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 3
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 4
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r3 = 5
            java.lang.String r4 = "daily_realtime_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r5 = 0
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0131 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x013b }
            if (r2 != 0) goto L_0x0069
            com.google.android.gms.internal.measurement.zzfg r0 = r11.zzge()     // Catch:{ SQLiteException -> 0x013b }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzip()     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r2 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r14)     // Catch:{ SQLiteException -> 0x013b }
            r0.zzg(r2, r3)     // Catch:{ SQLiteException -> 0x013b }
            if (r1 == 0) goto L_0x0067
            r1.close()
        L_0x0067:
            r0 = r8
        L_0x0068:
            return r0
        L_0x0069:
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0095
            r2 = 1
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.zzafe = r2     // Catch:{ SQLiteException -> 0x013b }
            r2 = 2
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.zzafd = r2     // Catch:{ SQLiteException -> 0x013b }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.zzaff = r2     // Catch:{ SQLiteException -> 0x013b }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.zzafg = r2     // Catch:{ SQLiteException -> 0x013b }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x013b }
            r8.zzafh = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x0095:
            if (r15 == 0) goto L_0x009e
            long r2 = r8.zzafe     // Catch:{ SQLiteException -> 0x013b }
            r4 = 1
            long r2 = r2 + r4
            r8.zzafe = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x009e:
            if (r16 == 0) goto L_0x00a7
            long r2 = r8.zzafd     // Catch:{ SQLiteException -> 0x013b }
            r4 = 1
            long r2 = r2 + r4
            r8.zzafd = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x00a7:
            if (r17 == 0) goto L_0x00b0
            long r2 = r8.zzaff     // Catch:{ SQLiteException -> 0x013b }
            r4 = 1
            long r2 = r2 + r4
            r8.zzaff = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x00b0:
            if (r18 == 0) goto L_0x00b9
            long r2 = r8.zzafg     // Catch:{ SQLiteException -> 0x013b }
            r4 = 1
            long r2 = r2 + r4
            r8.zzafg = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x00b9:
            if (r19 == 0) goto L_0x00c2
            long r2 = r8.zzafh     // Catch:{ SQLiteException -> 0x013b }
            r4 = 1
            long r2 = r2 + r4
            r8.zzafh = r2     // Catch:{ SQLiteException -> 0x013b }
        L_0x00c2:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x013b }
            r2.<init>()     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "day"
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "daily_public_events_count"
            long r4 = r8.zzafd     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "daily_events_count"
            long r4 = r8.zzafe     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "daily_conversions_count"
            long r4 = r8.zzaff     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "daily_error_events_count"
            long r4 = r8.zzafg     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "daily_realtime_events_count"
            long r4 = r8.zzafh     // Catch:{ SQLiteException -> 0x013b }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x013b }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x013b }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "app_id=?"
            r0.update(r3, r2, r4, r10)     // Catch:{ SQLiteException -> 0x013b }
            if (r1 == 0) goto L_0x0113
            r1.close()
        L_0x0113:
            r0 = r8
            goto L_0x0068
        L_0x0116:
            r0 = move-exception
            r1 = r9
        L_0x0118:
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ all -> 0x0139 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x0139 }
            java.lang.String r3 = "Error updating daily counts. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r14)     // Catch:{ all -> 0x0139 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x0139 }
            if (r1 == 0) goto L_0x012e
            r1.close()
        L_0x012e:
            r0 = r8
            goto L_0x0068
        L_0x0131:
            r0 = move-exception
            r1 = r9
        L_0x0133:
            if (r1 == 0) goto L_0x0138
            r1.close()
        L_0x0138:
            throw r0
        L_0x0139:
            r0 = move-exception
            goto L_0x0133
        L_0x013b:
            r0 = move-exception
            goto L_0x0118
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.measurement.zzej");
    }

    @WorkerThread
    public final void zza(zzdy zzdy) {
        Preconditions.checkNotNull(zzdy);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzdy.zzah());
        contentValues.put("app_instance_id", zzdy.getAppInstanceId());
        contentValues.put("gmp_app_id", zzdy.getGmpAppId());
        contentValues.put("resettable_device_id_hash", zzdy.zzgi());
        contentValues.put("last_bundle_index", Long.valueOf(zzdy.zzgq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzdy.zzgk()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzdy.zzgl()));
        contentValues.put("app_version", zzdy.zzag());
        contentValues.put("app_store", zzdy.zzgn());
        contentValues.put("gmp_version", Long.valueOf(zzdy.zzgo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzdy.zzgp()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzdy.isMeasurementEnabled()));
        contentValues.put("day", Long.valueOf(zzdy.zzgu()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzdy.zzgv()));
        contentValues.put("daily_events_count", Long.valueOf(zzdy.zzgw()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzdy.zzgx()));
        contentValues.put("config_fetched_time", Long.valueOf(zzdy.zzgr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzdy.zzgs()));
        contentValues.put("app_version_int", Long.valueOf(zzdy.zzgm()));
        contentValues.put("firebase_instance_id", zzdy.zzgj());
        contentValues.put("daily_error_events_count", Long.valueOf(zzdy.zzgz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzdy.zzgy()));
        contentValues.put("health_monitor_sample", zzdy.zzha());
        contentValues.put("android_id", Long.valueOf(zzdy.zzhc()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzdy.zzhd()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzdy.zzhe()));
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (((long) writableDatabase.update("apps", contentValues, "app_id = ?", new String[]{zzdy.zzah()})) == 0 && writableDatabase.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update app (got -1). appId", zzfg.zzbm(zzdy.zzah()));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing app. appId", zzfg.zzbm(zzdy.zzah()), e);
        }
    }

    @WorkerThread
    public final void zza(zzeq zzeq) {
        long j = null;
        Preconditions.checkNotNull(zzeq);
        zzab();
        zzch();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzeq.zzti);
        contentValues.put("name", zzeq.name);
        contentValues.put("lifetime_count", Long.valueOf(zzeq.zzafr));
        contentValues.put("current_bundle_count", Long.valueOf(zzeq.zzafs));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzeq.zzaft));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzeq.zzafu));
        contentValues.put("last_sampled_complex_event_id", zzeq.zzafv);
        contentValues.put("last_sampling_rate", zzeq.zzafw);
        if (zzeq.zzafx != null && zzeq.zzafx.booleanValue()) {
            j = 1L;
        }
        contentValues.put("last_exempt_from_sampling", j);
        try {
            if (getWritableDatabase().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update event aggregates (got -1). appId", zzfg.zzbm(zzeq.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing event aggregates. appId", zzfg.zzbm(zzeq.zzti), e);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        r8 = r3.zzarm;
        r9 = r8.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00a2, code lost:
        if (r2 >= r9) goto L_0x00c1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        if (r8[r2].zzarp != null) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00aa, code lost:
        zzge().zzip().zze("Property filter with no ID. Audience definition ignored. appId, audienceId", com.google.android.gms.internal.measurement.zzfg.zzbm(r13), r3.zzarl);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00be, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00c1, code lost:
        r8 = r3.zzarn;
        r9 = r8.length;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00c5, code lost:
        if (r2 >= r9) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00cd, code lost:
        if (zza(r13, r7, r8[r2]) != false) goto L_0x011a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00cf, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d0, code lost:
        if (r2 == false) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d2, code lost:
        r8 = r3.zzarm;
        r9 = r8.length;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d6, code lost:
        if (r3 >= r9) goto L_0x00e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00de, code lost:
        if (zza(r13, r7, r8[r3]) != false) goto L_0x011d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e0, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00e1, code lost:
        if (r2 != false) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00e3, code lost:
        zzch();
        zzab();
        com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13);
        r2 = getWritableDatabase();
        r2.delete("property_filters", "app_id=? and audience_id=?", new java.lang.String[]{r13, java.lang.String.valueOf(r7)});
        r2.delete("event_filters", "app_id=? and audience_id=?", new java.lang.String[]{r13, java.lang.String.valueOf(r7)});
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011a, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x011d, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x013c, code lost:
        r2 = true;
     */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r13, com.google.android.gms.internal.measurement.zzkd[] r14) {
        /*
            r12 = this;
            r4 = 1
            r0 = 0
            r12.zzch()
            r12.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            android.database.sqlite.SQLiteDatabase r5 = r12.getWritableDatabase()
            r5.beginTransaction()
            r12.zzch()     // Catch:{ all -> 0x0096 }
            r12.zzab()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)     // Catch:{ all -> 0x0096 }
            android.database.sqlite.SQLiteDatabase r1 = r12.getWritableDatabase()     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "property_filters"
            java.lang.String r3 = "app_id=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0096 }
            r7 = 0
            r6[r7] = r13     // Catch:{ all -> 0x0096 }
            r1.delete(r2, r3, r6)     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "event_filters"
            java.lang.String r3 = "app_id=?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ all -> 0x0096 }
            r7 = 0
            r6[r7] = r13     // Catch:{ all -> 0x0096 }
            r1.delete(r2, r3, r6)     // Catch:{ all -> 0x0096 }
            int r6 = r14.length     // Catch:{ all -> 0x0096 }
            r1 = r0
        L_0x003e:
            if (r1 >= r6) goto L_0x0120
            r3 = r14[r1]     // Catch:{ all -> 0x0096 }
            r12.zzch()     // Catch:{ all -> 0x0096 }
            r12.zzab()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzke[] r2 = r3.zzarn     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzkh[] r2 = r3.zzarm     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0096 }
            java.lang.Integer r2 = r3.zzarl     // Catch:{ all -> 0x0096 }
            if (r2 != 0) goto L_0x0070
            com.google.android.gms.internal.measurement.zzfg r2 = r12.zzge()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "Audience with no ID. appId"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13)     // Catch:{ all -> 0x0096 }
            r2.zzg(r3, r7)     // Catch:{ all -> 0x0096 }
        L_0x006d:
            int r1 = r1 + 1
            goto L_0x003e
        L_0x0070:
            java.lang.Integer r2 = r3.zzarl     // Catch:{ all -> 0x0096 }
            int r7 = r2.intValue()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzke[] r8 = r3.zzarn     // Catch:{ all -> 0x0096 }
            int r9 = r8.length     // Catch:{ all -> 0x0096 }
            r2 = r0
        L_0x007a:
            if (r2 >= r9) goto L_0x009e
            r10 = r8[r2]     // Catch:{ all -> 0x0096 }
            java.lang.Integer r10 = r10.zzarp     // Catch:{ all -> 0x0096 }
            if (r10 != 0) goto L_0x009b
            com.google.android.gms.internal.measurement.zzfg r2 = r12.zzge()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x0096 }
            java.lang.String r7 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13)     // Catch:{ all -> 0x0096 }
            java.lang.Integer r3 = r3.zzarl     // Catch:{ all -> 0x0096 }
            r2.zze(r7, r8, r3)     // Catch:{ all -> 0x0096 }
            goto L_0x006d
        L_0x0096:
            r0 = move-exception
            r5.endTransaction()
            throw r0
        L_0x009b:
            int r2 = r2 + 1
            goto L_0x007a
        L_0x009e:
            com.google.android.gms.internal.measurement.zzkh[] r8 = r3.zzarm     // Catch:{ all -> 0x0096 }
            int r9 = r8.length     // Catch:{ all -> 0x0096 }
            r2 = r0
        L_0x00a2:
            if (r2 >= r9) goto L_0x00c1
            r10 = r8[r2]     // Catch:{ all -> 0x0096 }
            java.lang.Integer r10 = r10.zzarp     // Catch:{ all -> 0x0096 }
            if (r10 != 0) goto L_0x00be
            com.google.android.gms.internal.measurement.zzfg r2 = r12.zzge()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzip()     // Catch:{ all -> 0x0096 }
            java.lang.String r7 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r13)     // Catch:{ all -> 0x0096 }
            java.lang.Integer r3 = r3.zzarl     // Catch:{ all -> 0x0096 }
            r2.zze(r7, r8, r3)     // Catch:{ all -> 0x0096 }
            goto L_0x006d
        L_0x00be:
            int r2 = r2 + 1
            goto L_0x00a2
        L_0x00c1:
            com.google.android.gms.internal.measurement.zzke[] r8 = r3.zzarn     // Catch:{ all -> 0x0096 }
            int r9 = r8.length     // Catch:{ all -> 0x0096 }
            r2 = r0
        L_0x00c5:
            if (r2 >= r9) goto L_0x013c
            r10 = r8[r2]     // Catch:{ all -> 0x0096 }
            boolean r10 = r12.zza((java.lang.String) r13, (int) r7, (com.google.android.gms.internal.measurement.zzke) r10)     // Catch:{ all -> 0x0096 }
            if (r10 != 0) goto L_0x011a
            r2 = r0
        L_0x00d0:
            if (r2 == 0) goto L_0x00e1
            com.google.android.gms.internal.measurement.zzkh[] r8 = r3.zzarm     // Catch:{ all -> 0x0096 }
            int r9 = r8.length     // Catch:{ all -> 0x0096 }
            r3 = r0
        L_0x00d6:
            if (r3 >= r9) goto L_0x00e1
            r10 = r8[r3]     // Catch:{ all -> 0x0096 }
            boolean r10 = r12.zza((java.lang.String) r13, (int) r7, (com.google.android.gms.internal.measurement.zzkh) r10)     // Catch:{ all -> 0x0096 }
            if (r10 != 0) goto L_0x011d
            r2 = r0
        L_0x00e1:
            if (r2 != 0) goto L_0x006d
            r12.zzch()     // Catch:{ all -> 0x0096 }
            r12.zzab()     // Catch:{ all -> 0x0096 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)     // Catch:{ all -> 0x0096 }
            android.database.sqlite.SQLiteDatabase r2 = r12.getWritableDatabase()     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "property_filters"
            java.lang.String r8 = "app_id=? and audience_id=?"
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x0096 }
            r10 = 0
            r9[r10] = r13     // Catch:{ all -> 0x0096 }
            r10 = 1
            java.lang.String r11 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0096 }
            r9[r10] = r11     // Catch:{ all -> 0x0096 }
            r2.delete(r3, r8, r9)     // Catch:{ all -> 0x0096 }
            java.lang.String r3 = "event_filters"
            java.lang.String r8 = "app_id=? and audience_id=?"
            r9 = 2
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x0096 }
            r10 = 0
            r9[r10] = r13     // Catch:{ all -> 0x0096 }
            r10 = 1
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0096 }
            r9[r10] = r7     // Catch:{ all -> 0x0096 }
            r2.delete(r3, r8, r9)     // Catch:{ all -> 0x0096 }
            goto L_0x006d
        L_0x011a:
            int r2 = r2 + 1
            goto L_0x00c5
        L_0x011d:
            int r3 = r3 + 1
            goto L_0x00d6
        L_0x0120:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0096 }
            r1.<init>()     // Catch:{ all -> 0x0096 }
            int r2 = r14.length     // Catch:{ all -> 0x0096 }
        L_0x0126:
            if (r0 >= r2) goto L_0x0132
            r3 = r14[r0]     // Catch:{ all -> 0x0096 }
            java.lang.Integer r3 = r3.zzarl     // Catch:{ all -> 0x0096 }
            r1.add(r3)     // Catch:{ all -> 0x0096 }
            int r0 = r0 + 1
            goto L_0x0126
        L_0x0132:
            r12.zza((java.lang.String) r13, (java.util.List<java.lang.Integer>) r1)     // Catch:{ all -> 0x0096 }
            r5.setTransactionSuccessful()     // Catch:{ all -> 0x0096 }
            r5.endTransaction()
            return
        L_0x013c:
            r2 = r4
            goto L_0x00d0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zza(java.lang.String, com.google.android.gms.internal.measurement.zzkd[]):void");
    }

    @WorkerThread
    public final boolean zza(zzed zzed) {
        Preconditions.checkNotNull(zzed);
        zzab();
        zzch();
        if (zzh(zzed.packageName, zzed.zzaep.name) == null) {
            if (zza("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzed.packageName}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzed.packageName);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzed.origin);
        contentValues.put("name", zzed.zzaep.name);
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzed.zzaep.getValue());
        contentValues.put("active", Boolean.valueOf(zzed.active));
        contentValues.put("trigger_event_name", zzed.triggerEventName);
        contentValues.put("trigger_timeout", Long.valueOf(zzed.triggerTimeout));
        zzgb();
        contentValues.put("timed_out_event", zzka.zza((Parcelable) zzed.zzaeq));
        contentValues.put("creation_timestamp", Long.valueOf(zzed.creationTimestamp));
        zzgb();
        contentValues.put("triggered_event", zzka.zza((Parcelable) zzed.zzaer));
        contentValues.put("triggered_timestamp", Long.valueOf(zzed.zzaep.zzaqz));
        contentValues.put("time_to_live", Long.valueOf(zzed.timeToLive));
        zzgb();
        contentValues.put("expired_event", zzka.zza((Parcelable) zzed.zzaes));
        try {
            if (getWritableDatabase().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update conditional user property (got -1)", zzfg.zzbm(zzed.packageName));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing conditional user property", zzfg.zzbm(zzed.packageName), e);
        }
        return true;
    }

    public final boolean zza(zzep zzep, long j, boolean z) {
        zzab();
        zzch();
        Preconditions.checkNotNull(zzep);
        Preconditions.checkNotEmpty(zzep.zzti);
        zzkn zzkn = new zzkn();
        zzkn.zzatc = Long.valueOf(zzep.zzafp);
        zzkn.zzata = new zzko[zzep.zzafq.size()];
        Iterator<String> it = zzep.zzafq.iterator();
        int i = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzko zzko = new zzko();
            zzkn.zzata[i] = zzko;
            zzko.name = next;
            zzgb().zza(zzko, zzep.zzafq.get(next));
            i++;
        }
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving event, name, data size", zzga().zzbj(zzep.name), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzep.zzti);
            contentValues.put("name", zzep.name);
            contentValues.put(AppMeasurement.Param.TIMESTAMP, Long.valueOf(zzep.timestamp));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, bArr);
            contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("raw_events", (String) null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert raw event (got -1). appId", zzfg.zzbm(zzep.zzti));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing raw event. appId", zzfg.zzbm(zzep.zzti), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize event params/data. appId", zzfg.zzbm(zzep.zzti), e2);
            return false;
        }
    }

    @WorkerThread
    public final boolean zza(zzjz zzjz) {
        Preconditions.checkNotNull(zzjz);
        zzab();
        zzch();
        if (zzh(zzjz.zzti, zzjz.name) == null) {
            if (zzka.zzcc(zzjz.name)) {
                if (zza("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjz.zzti}) >= 25) {
                    return false;
                }
            } else {
                if (zza("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjz.zzti, zzjz.origin}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjz.zzti);
        contentValues.put(FirebaseAnalytics.Param.ORIGIN, zzjz.origin);
        contentValues.put("name", zzjz.name);
        contentValues.put("set_timestamp", Long.valueOf(zzjz.zzaqz));
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzjz.value);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzge().zzim().zzg("Failed to insert/update user property (got -1). appId", zzfg.zzbm(zzjz.zzti));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error storing user property. appId", zzfg.zzbm(zzjz.zzti), e);
        }
        return true;
    }

    @WorkerThread
    public final boolean zza(zzkq zzkq, boolean z) {
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkq);
        Preconditions.checkNotEmpty(zzkq.zzti);
        Preconditions.checkNotNull(zzkq.zzatm);
        zzhp();
        long currentTimeMillis = zzbt().currentTimeMillis();
        if (zzkq.zzatm.longValue() < currentTimeMillis - zzef.zzhh() || zzkq.zzatm.longValue() > zzef.zzhh() + currentTimeMillis) {
            zzge().zzip().zzd("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfg.zzbm(zzkq.zzti), Long.valueOf(currentTimeMillis), zzkq.zzatm);
        }
        try {
            byte[] bArr = new byte[zzkq.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkq.zza(zzb);
            zzb.zzve();
            byte[] zza = zzgb().zza(bArr);
            zzge().zzit().zzg("Saving bundle, size", Integer.valueOf(zza.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzkq.zzti);
            contentValues.put("bundle_end_timestamp", zzkq.zzatm);
            contentValues.put(DataBufferSafeParcelable.DATA_FIELD, zza);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzkq.zzauj != null) {
                contentValues.put("retry_count", zzkq.zzauj);
            }
            try {
                if (getWritableDatabase().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert bundle (got -1). appId", zzfg.zzbm(zzkq.zzti));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing bundle. appId", zzfg.zzbm(zzkq.zzti), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zze("Data loss. Failed to serialize bundle. appId", zzfg.zzbm(zzkq.zzti), e2);
            return false;
        }
    }

    public final boolean zza(String str, Long l, long j, zzkn zzkn) {
        zzab();
        zzch();
        Preconditions.checkNotNull(zzkn);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        try {
            byte[] bArr = new byte[zzkn.zzvm()];
            zzabw zzb = zzabw.zzb(bArr, 0, bArr.length);
            zzkn.zza(zzb);
            zzb.zzve();
            zzge().zzit().zze("Saving complex main event, appId, data size", zzga().zzbj(str), Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("event_id", l);
            contentValues.put("children_to_process", Long.valueOf(j));
            contentValues.put("main_event", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                    return true;
                }
                zzge().zzim().zzg("Failed to insert complex main event (got -1). appId", zzfg.zzbm(str));
                return false;
            } catch (SQLiteException e) {
                zzge().zzim().zze("Error storing complex main event. appId", zzfg.zzbm(str), e);
                return false;
            }
        } catch (IOException e2) {
            zzge().zzim().zzd("Data loss. Failed to serialize event params/data. appId, eventId", zzfg.zzbm(str), l, e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzab(long r8) {
        /*
            r7 = this;
            r0 = 0
            r7.zzab()
            r7.zzch()
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005f }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.internal.measurement.zzfg r1 = r7.zzge()     // Catch:{ SQLiteException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzit()     // Catch:{ SQLiteException -> 0x005f }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.log(r3)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return r0
        L_0x0034:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            com.google.android.gms.internal.measurement.zzfg r3 = r7.zzge()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzg(r4, r1)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x0054:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()
        L_0x005c:
            throw r0
        L_0x005d:
            r0 = move-exception
            goto L_0x0057
        L_0x005f:
            r1 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzab(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00fe  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzkq, java.lang.Long>> zzb(java.lang.String r12, int r13, int r14) {
        /*
            r11 = this;
            r10 = 0
            r1 = 1
            r9 = 0
            r11.zzab()
            r11.zzch()
            if (r13 <= 0) goto L_0x0053
            r0 = r1
        L_0x000c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            if (r14 <= 0) goto L_0x0055
        L_0x0011:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            java.lang.String r1 = "queue"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            r3 = 2
            java.lang.String r4 = "retry_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00dc, all -> 0x00fa }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            if (r0 != 0) goto L_0x0057
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            if (r2 == 0) goto L_0x0052
            r2.close()
        L_0x0052:
            return r0
        L_0x0053:
            r0 = r9
            goto L_0x000c
        L_0x0055:
            r1 = r9
            goto L_0x0011
        L_0x0057:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r3 = r9
        L_0x005d:
            r1 = 0
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r1 = 1
            byte[] r1 = r2.getBlob(r1)     // Catch:{ IOException -> 0x00b4 }
            com.google.android.gms.internal.measurement.zzka r6 = r11.zzgb()     // Catch:{ IOException -> 0x00b4 }
            byte[] r1 = r6.zzb((byte[]) r1)     // Catch:{ IOException -> 0x00b4 }
            boolean r6 = r0.isEmpty()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            if (r6 != 0) goto L_0x0079
            int r6 = r1.length     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            int r6 = r6 + r3
            if (r6 > r14) goto L_0x00ae
        L_0x0079:
            r6 = 0
            int r7 = r1.length     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            com.google.android.gms.internal.measurement.zzabv r6 = com.google.android.gms.internal.measurement.zzabv.zza(r1, r6, r7)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            com.google.android.gms.internal.measurement.zzkq r7 = new com.google.android.gms.internal.measurement.zzkq     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r7.zzb(r6)     // Catch:{ IOException -> 0x00c8 }
            r6 = 2
            boolean r6 = r2.isNull(r6)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            if (r6 != 0) goto L_0x0099
            r6 = 2
            int r6 = r2.getInt(r6)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r7.zzauj = r6     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        L_0x0099:
            int r1 = r1.length     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            int r1 = r1 + r3
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            android.util.Pair r3 = android.util.Pair.create(r7, r3)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
        L_0x00a6:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            if (r3 == 0) goto L_0x00ae
            if (r1 <= r14) goto L_0x010a
        L_0x00ae:
            if (r2 == 0) goto L_0x0052
            r2.close()
            goto L_0x0052
        L_0x00b4:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r4 = r11.zzge()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            java.lang.String r5 = "Failed to unzip queued bundle. appId"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r4.zze(r5, r6, r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r1 = r3
            goto L_0x00a6
        L_0x00c8:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r4 = r11.zzge()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            java.lang.String r5 = "Failed to merge queued bundle. appId"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r4.zze(r5, r6, r1)     // Catch:{ SQLiteException -> 0x0107, all -> 0x0102 }
            r1 = r3
            goto L_0x00a6
        L_0x00dc:
            r0 = move-exception
            r1 = r10
        L_0x00de:
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ all -> 0x0104 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x0104 }
            java.lang.String r3 = "Error querying bundles. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ all -> 0x0104 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x0104 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0104 }
            if (r1 == 0) goto L_0x0052
            r1.close()
            goto L_0x0052
        L_0x00fa:
            r0 = move-exception
            r2 = r10
        L_0x00fc:
            if (r2 == 0) goto L_0x0101
            r2.close()
        L_0x0101:
            throw r0
        L_0x0102:
            r0 = move-exception
            goto L_0x00fc
        L_0x0104:
            r0 = move-exception
            r2 = r1
            goto L_0x00fc
        L_0x0107:
            r0 = move-exception
            r1 = r2
            goto L_0x00de
        L_0x010a:
            r3 = r1
            goto L_0x005d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, int, int):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0102, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0106, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0107, code lost:
        r10 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0110, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0106 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:9:0x007c] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzjz> zzb(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzab()
            r11.zzch()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r1 = 3
            r0.<init>(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r0.add(r12)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r1 = "app_id=?"
            r3.<init>(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            boolean r1 = android.text.TextUtils.isEmpty(r13)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            if (r1 != 0) goto L_0x002d
            r0.add(r13)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r1 = " and origin=?"
            r3.append(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        L_0x002d:
            boolean r1 = android.text.TextUtils.isEmpty(r14)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            if (r1 != 0) goto L_0x0045
            java.lang.String r1 = java.lang.String.valueOf(r14)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r2 = "*"
            java.lang.String r1 = r1.concat(r2)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r0.add(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r1 = " and name glob ?"
            r3.append(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
        L_0x0045:
            int r1 = r0.size()     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String[] r1 = new java.lang.String[r1]     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.Object[] r4 = r0.toArray(r1)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r1 = "user_attributes"
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r5 = 0
            java.lang.String r6 = "name"
            r2[r5] = r6     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r5 = 1
            java.lang.String r6 = "set_timestamp"
            r2[r5] = r6     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r5 = 2
            java.lang.String r6 = "value"
            r2[r5] = r6     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r5 = 3
            java.lang.String r6 = "origin"
            r2[r5] = r6     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "1001"
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x010c, all -> 0x00ff }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            if (r0 != 0) goto L_0x008a
            if (r7 == 0) goto L_0x0087
            r7.close()
        L_0x0087:
            r0 = r9
        L_0x0088:
            return r0
        L_0x0089:
            r13 = r2
        L_0x008a:
            int r0 = r9.size()     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            r1 = 1000(0x3e8, float:1.401E-42)
            if (r0 < r1) goto L_0x00ac
            com.google.android.gms.internal.measurement.zzfg r0 = r11.zzge()     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzim()     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            java.lang.String r1 = "Read more than the max allowed user properties, ignoring excess"
            r2 = 1000(0x3e8, float:1.401E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            r0.zzg(r1, r2)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
        L_0x00a5:
            if (r7 == 0) goto L_0x00aa
            r7.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0088
        L_0x00ac:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            r0 = 2
            java.lang.Object r6 = r11.zza((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            r0 = 3
            java.lang.String r2 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x010f, all -> 0x0106 }
            if (r6 != 0) goto L_0x00da
            com.google.android.gms.internal.measurement.zzfg r0 = r11.zzge()     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzim()     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            java.lang.String r1 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            r0.zzd(r1, r3, r2, r14)     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
        L_0x00d3:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            if (r0 != 0) goto L_0x0089
            goto L_0x00a5
        L_0x00da:
            com.google.android.gms.internal.measurement.zzjz r0 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x00e4, all -> 0x0106 }
            goto L_0x00d3
        L_0x00e4:
            r0 = move-exception
            r1 = r7
            r13 = r2
        L_0x00e7:
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ all -> 0x0109 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x0109 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ all -> 0x0109 }
            r2.zzd(r3, r4, r13, r0)     // Catch:{ all -> 0x0109 }
            if (r1 == 0) goto L_0x00fd
            r1.close()
        L_0x00fd:
            r0 = r10
            goto L_0x0088
        L_0x00ff:
            r0 = move-exception
        L_0x0100:
            if (r10 == 0) goto L_0x0105
            r10.close()
        L_0x0105:
            throw r0
        L_0x0106:
            r0 = move-exception
            r10 = r7
            goto L_0x0100
        L_0x0109:
            r0 = move-exception
            r10 = r1
            goto L_0x0100
        L_0x010c:
            r0 = move-exception
            r1 = r10
            goto L_0x00e7
        L_0x010f:
            r0 = move-exception
            r1 = r7
            goto L_0x00e7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzed> zzb(java.lang.String r24, java.lang.String[] r25) {
        /*
            r23 = this;
            r23.zzab()
            r23.zzch()
            java.util.ArrayList r20 = new java.util.ArrayList
            r20.<init>()
            r11 = 0
            android.database.sqlite.SQLiteDatabase r2 = r23.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 0
            java.lang.String r6 = "app_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 1
            java.lang.String r6 = "origin"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 2
            java.lang.String r6 = "name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 3
            java.lang.String r6 = "value"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 4
            java.lang.String r6 = "active"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 5
            java.lang.String r6 = "trigger_event_name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 6
            java.lang.String r6 = "trigger_timeout"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 7
            java.lang.String r6 = "timed_out_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 8
            java.lang.String r6 = "creation_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 9
            java.lang.String r6 = "triggered_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 10
            java.lang.String r6 = "triggered_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 11
            java.lang.String r6 = "time_to_live"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r5 = 12
            java.lang.String r6 = "expired_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1001"
            r5 = r24
            r6 = r25
            android.database.Cursor r21 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0146, all -> 0x0160 }
            boolean r2 = r21.moveToFirst()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            if (r2 != 0) goto L_0x0078
            if (r21 == 0) goto L_0x0075
            r21.close()
        L_0x0075:
            r2 = r20
        L_0x0077:
            return r2
        L_0x0078:
            int r2 = r20.size()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 < r3) goto L_0x009b
            com.google.android.gms.internal.measurement.zzfg r2 = r23.zzge()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            r4 = 1000(0x3e8, float:1.401E-42)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
        L_0x0093:
            if (r21 == 0) goto L_0x0098
            r21.close()
        L_0x0098:
            r2 = r20
            goto L_0x0077
        L_0x009b:
            r2 = 0
            r0 = r21
            java.lang.String r8 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 1
            r0 = r21
            java.lang.String r7 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 2
            r0 = r21
            java.lang.String r3 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 3
            r0 = r23
            r1 = r21
            java.lang.Object r6 = r0.zza((android.database.Cursor) r1, (int) r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 4
            r0 = r21
            int r2 = r0.getInt(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            if (r2 == 0) goto L_0x0143
            r11 = 1
        L_0x00c3:
            r2 = 5
            r0 = r21
            java.lang.String r12 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 6
            r0 = r21
            long r14 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzka r2 = r23.zzgb()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r4 = 7
            r0 = r21
            byte[] r4 = r0.getBlob(r4)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r5 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            android.os.Parcelable r13 = r2.zza((byte[]) r4, r5)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzeu r13 = (com.google.android.gms.internal.measurement.zzeu) r13     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 8
            r0 = r21
            long r9 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzka r2 = r23.zzgb()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r4 = 9
            r0 = r21
            byte[] r4 = r0.getBlob(r4)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r5 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            android.os.Parcelable r16 = r2.zza((byte[]) r4, r5)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzeu r16 = (com.google.android.gms.internal.measurement.zzeu) r16     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 10
            r0 = r21
            long r4 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2 = 11
            r0 = r21
            long r17 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzka r2 = r23.zzgb()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r19 = 12
            r0 = r21
            r1 = r19
            byte[] r19 = r0.getBlob(r1)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r22 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r0 = r19
            r1 = r22
            android.os.Parcelable r19 = r2.zza((byte[]) r0, r1)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzeu r19 = (com.google.android.gms.internal.measurement.zzeu) r19     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzjx r2 = new com.google.android.gms.internal.measurement.zzjx     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            com.google.android.gms.internal.measurement.zzed r5 = new com.google.android.gms.internal.measurement.zzed     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r6 = r8
            r8 = r2
            r5.<init>(r6, r7, r8, r9, r11, r12, r13, r14, r16, r17, r19)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            r0 = r20
            r0.add(r5)     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            boolean r2 = r21.moveToNext()     // Catch:{ SQLiteException -> 0x016f, all -> 0x0169 }
            if (r2 != 0) goto L_0x0078
            goto L_0x0093
        L_0x0143:
            r11 = 0
            goto L_0x00c3
        L_0x0146:
            r2 = move-exception
            r3 = r11
        L_0x0148:
            com.google.android.gms.internal.measurement.zzfg r4 = r23.zzge()     // Catch:{ all -> 0x016b }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ all -> 0x016b }
            java.lang.String r5 = "Error querying conditional user property value"
            r4.zzg(r5, r2)     // Catch:{ all -> 0x016b }
            java.util.List r2 = java.util.Collections.emptyList()     // Catch:{ all -> 0x016b }
            if (r3 == 0) goto L_0x0077
            r3.close()
            goto L_0x0077
        L_0x0160:
            r2 = move-exception
            r21 = r11
        L_0x0163:
            if (r21 == 0) goto L_0x0168
            r21.close()
        L_0x0168:
            throw r2
        L_0x0169:
            r2 = move-exception
            goto L_0x0163
        L_0x016b:
            r2 = move-exception
            r21 = r3
            goto L_0x0163
        L_0x016f:
            r2 = move-exception
            r3 = r21
            goto L_0x0148
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzb(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00aa  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzjz> zzbb(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzab()
            r11.zzch()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            java.lang.String r1 = "user_attributes"
            r2 = 4
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r3 = 1
            java.lang.String r4 = "origin"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r3 = 2
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r3 = 3
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = "1000"
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00b4, all -> 0x00a7 }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            if (r0 != 0) goto L_0x004b
            if (r7 == 0) goto L_0x0049
            r7.close()
        L_0x0049:
            r0 = r9
        L_0x004a:
            return r0
        L_0x004b:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            r0 = 1
            java.lang.String r2 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            if (r2 != 0) goto L_0x0059
            java.lang.String r2 = ""
        L_0x0059:
            r0 = 2
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            r0 = 3
            java.lang.Object r6 = r11.zza((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            if (r6 != 0) goto L_0x0083
            com.google.android.gms.internal.measurement.zzfg r0 = r11.zzge()     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzim()     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            java.lang.String r1 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r2 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            r0.zzg(r1, r2)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
        L_0x0076:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            if (r0 != 0) goto L_0x004b
            if (r7 == 0) goto L_0x0081
            r7.close()
        L_0x0081:
            r0 = r9
            goto L_0x004a
        L_0x0083:
            com.google.android.gms.internal.measurement.zzjz r0 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            r1 = r12
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            r9.add(r0)     // Catch:{ SQLiteException -> 0x008d, all -> 0x00ae }
            goto L_0x0076
        L_0x008d:
            r0 = move-exception
            r1 = r7
        L_0x008f:
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ all -> 0x00b1 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00b1 }
            java.lang.String r3 = "Error querying user properties. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ all -> 0x00b1 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x00b1 }
            if (r1 == 0) goto L_0x00a5
            r1.close()
        L_0x00a5:
            r0 = r10
            goto L_0x004a
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            if (r10 == 0) goto L_0x00ad
            r10.close()
        L_0x00ad:
            throw r0
        L_0x00ae:
            r0 = move-exception
            r10 = r7
            goto L_0x00a8
        L_0x00b1:
            r0 = move-exception
            r10 = r1
            goto L_0x00a8
        L_0x00b4:
            r0 = move-exception
            r1 = r10
            goto L_0x008f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbb(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x0225  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzdy zzbc(java.lang.String r12) {
        /*
            r11 = this;
            r8 = 0
            r10 = 1
            r9 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzab()
            r11.zzch()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            java.lang.String r1 = "apps"
            r2 = 25
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 0
            java.lang.String r4 = "app_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 1
            java.lang.String r4 = "gmp_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 2
            java.lang.String r4 = "resettable_device_id_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 3
            java.lang.String r4 = "last_bundle_index"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 4
            java.lang.String r4 = "last_bundle_start_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 5
            java.lang.String r4 = "last_bundle_end_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 6
            java.lang.String r4 = "app_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 7
            java.lang.String r4 = "app_store"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 8
            java.lang.String r4 = "gmp_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 9
            java.lang.String r4 = "dev_cert_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 10
            java.lang.String r4 = "measurement_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 11
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 12
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 13
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 14
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 15
            java.lang.String r4 = "config_fetched_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 16
            java.lang.String r4 = "failed_config_fetch_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 17
            java.lang.String r4 = "app_version_int"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 18
            java.lang.String r4 = "firebase_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 19
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 20
            java.lang.String r4 = "daily_realtime_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 21
            java.lang.String r4 = "health_monitor_sample"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 22
            java.lang.String r4 = "android_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 23
            java.lang.String r4 = "adid_reporting_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r3 = 24
            java.lang.String r4 = "ssaid_reporting_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0206, all -> 0x0221 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x022b }
            if (r0 != 0) goto L_0x00c0
            if (r1 == 0) goto L_0x00be
            r1.close()
        L_0x00be:
            r0 = r8
        L_0x00bf:
            return r0
        L_0x00c0:
            com.google.android.gms.internal.measurement.zzdy r0 = new com.google.android.gms.internal.measurement.zzdy     // Catch:{ SQLiteException -> 0x022b }
            com.google.android.gms.internal.measurement.zzjr r2 = r11.zzajp     // Catch:{ SQLiteException -> 0x022b }
            com.google.android.gms.internal.measurement.zzgl r2 = r2.zzla()     // Catch:{ SQLiteException -> 0x022b }
            r0.<init>(r2, r12)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzal(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzam(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 2
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzan(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzr(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzm(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzn(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 6
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.setAppVersion(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 7
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzap(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 8
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzp(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 9
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzq(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 10
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 != 0) goto L_0x012d
            r2 = 10
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x01ef
        L_0x012d:
            r2 = r10
        L_0x012e:
            r0.setMeasurementEnabled(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 11
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzu(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 12
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzv(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 13
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzw(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 14
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzx(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 15
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzs(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 16
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzt(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 17
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x01f2
            r2 = -2147483648(0xffffffff80000000, double:NaN)
        L_0x0172:
            r0.zzo(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 18
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzao(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 19
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzz(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 20
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzy(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 21
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzaq(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 22
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x01fb
            r2 = 0
        L_0x01a3:
            r0.zzaa(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 23
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 != 0) goto L_0x01b6
            r2 = 23
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x0202
        L_0x01b6:
            r2 = r10
        L_0x01b7:
            r0.zzd(r2)     // Catch:{ SQLiteException -> 0x022b }
            r2 = 24
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 != 0) goto L_0x01ca
            r2 = 24
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x0204
        L_0x01ca:
            r2 = r10
        L_0x01cb:
            r0.zze(r2)     // Catch:{ SQLiteException -> 0x022b }
            r0.zzgh()     // Catch:{ SQLiteException -> 0x022b }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x022b }
            if (r2 == 0) goto L_0x01e8
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ SQLiteException -> 0x022b }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x022b }
            java.lang.String r3 = "Got multiple records for app, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ SQLiteException -> 0x022b }
            r2.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x022b }
        L_0x01e8:
            if (r1 == 0) goto L_0x00bf
            r1.close()
            goto L_0x00bf
        L_0x01ef:
            r2 = r9
            goto L_0x012e
        L_0x01f2:
            r2 = 17
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x022b }
            long r2 = (long) r2     // Catch:{ SQLiteException -> 0x022b }
            goto L_0x0172
        L_0x01fb:
            r2 = 22
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x022b }
            goto L_0x01a3
        L_0x0202:
            r2 = r9
            goto L_0x01b7
        L_0x0204:
            r2 = r9
            goto L_0x01cb
        L_0x0206:
            r0 = move-exception
            r1 = r8
        L_0x0208:
            com.google.android.gms.internal.measurement.zzfg r2 = r11.zzge()     // Catch:{ all -> 0x0229 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x0229 }
            java.lang.String r3 = "Error querying app. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r12)     // Catch:{ all -> 0x0229 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x0229 }
            if (r1 == 0) goto L_0x021e
            r1.close()
        L_0x021e:
            r0 = r8
            goto L_0x00bf
        L_0x0221:
            r0 = move-exception
            r1 = r8
        L_0x0223:
            if (r1 == 0) goto L_0x0228
            r1.close()
        L_0x0228:
            throw r0
        L_0x0229:
            r0 = move-exception
            goto L_0x0223
        L_0x022b:
            r0 = move-exception
            goto L_0x0208
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbc(java.lang.String):com.google.android.gms.internal.measurement.zzdy");
    }

    public final long zzbd(String str) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzgg().zzb(str, zzew.zzagx))))});
        } catch (SQLiteException e) {
            zzge().zzim().zze("Error deleting over the limit events. appId", zzfg.zzbm(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0074  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzbe(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            r9.zzab()
            r9.zzch()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            java.lang.String r1 = "apps"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            r3 = 0
            java.lang.String r4 = "remote_config"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0056, all -> 0x0070 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x007a }
            if (r0 != 0) goto L_0x0034
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            r0 = r8
        L_0x0033:
            return r0
        L_0x0034:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x007a }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x007a }
            if (r2 == 0) goto L_0x0050
            com.google.android.gms.internal.measurement.zzfg r2 = r9.zzge()     // Catch:{ SQLiteException -> 0x007a }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x007a }
            java.lang.String r3 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ SQLiteException -> 0x007a }
            r2.zzg(r3, r4)     // Catch:{ SQLiteException -> 0x007a }
        L_0x0050:
            if (r1 == 0) goto L_0x0033
            r1.close()
            goto L_0x0033
        L_0x0056:
            r0 = move-exception
            r1 = r8
        L_0x0058:
            com.google.android.gms.internal.measurement.zzfg r2 = r9.zzge()     // Catch:{ all -> 0x0078 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x0078 }
            java.lang.String r3 = "Error querying remote config. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ all -> 0x0078 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x006e
            r1.close()
        L_0x006e:
            r0 = r8
            goto L_0x0033
        L_0x0070:
            r0 = move-exception
            r1 = r8
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()
        L_0x0077:
            throw r0
        L_0x0078:
            r0 = move-exception
            goto L_0x0072
        L_0x007a:
            r0 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbe(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzkr> zzbf(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            r9.zzch()
            r9.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            r3 = 1
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00a3, all -> 0x0099 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0080 }
            if (r0 != 0) goto L_0x0039
            if (r1 == 0) goto L_0x0037
            r1.close()
        L_0x0037:
            r0 = r8
        L_0x0038:
            return r0
        L_0x0039:
            android.support.v4.util.ArrayMap r0 = new android.support.v4.util.ArrayMap     // Catch:{ SQLiteException -> 0x0080 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0080 }
        L_0x003e:
            r2 = 0
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x0080 }
            r3 = 1
            byte[] r3 = r1.getBlob(r3)     // Catch:{ SQLiteException -> 0x0080 }
            r4 = 0
            int r5 = r3.length     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzabv r3 = com.google.android.gms.internal.measurement.zzabv.zza(r3, r4, r5)     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzkr r4 = new com.google.android.gms.internal.measurement.zzkr     // Catch:{ SQLiteException -> 0x0080 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0080 }
            r4.zzb(r3)     // Catch:{ IOException -> 0x0069 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0080 }
            r0.put(r2, r4)     // Catch:{ SQLiteException -> 0x0080 }
        L_0x005d:
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0080 }
            if (r2 != 0) goto L_0x003e
            if (r1 == 0) goto L_0x0038
            r1.close()
            goto L_0x0038
        L_0x0069:
            r3 = move-exception
            com.google.android.gms.internal.measurement.zzfg r4 = r9.zzge()     // Catch:{ SQLiteException -> 0x0080 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ SQLiteException -> 0x0080 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0080 }
            r4.zzd(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0080 }
            goto L_0x005d
        L_0x0080:
            r0 = move-exception
        L_0x0081:
            com.google.android.gms.internal.measurement.zzfg r2 = r9.zzge()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00a1 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ all -> 0x00a1 }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x00a1 }
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            r0 = r8
            goto L_0x0038
        L_0x0099:
            r0 = move-exception
            r1 = r8
        L_0x009b:
            if (r1 == 0) goto L_0x00a0
            r1.close()
        L_0x00a0:
            throw r0
        L_0x00a1:
            r0 = move-exception
            goto L_0x009b
        L_0x00a3:
            r0 = move-exception
            r1 = r8
            goto L_0x0081
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzbf(java.lang.String):java.util.Map");
    }

    public final long zzbg(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    @WorkerThread
    public final List<zzed> zzc(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzab();
        zzch();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat("*"));
            sb.append(" and name glob ?");
        }
        return zzb(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzc(List<Long> list) {
        zzab();
        zzch();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzhv()) {
            String join = TextUtils.join(",", list);
            String sb = new StringBuilder(String.valueOf(join).length() + 2).append("(").append(join).append(")").toString();
            if (zza(new StringBuilder(String.valueOf(sb).length() + 80).append("SELECT COUNT(1) FROM queue WHERE rowid IN ").append(sb).append(" AND retry_count =  2147483647 LIMIT 1").toString(), (String[]) null) > 0) {
                zzge().zzip().log("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                getWritableDatabase().execSQL(new StringBuilder(String.valueOf(sb).length() + 127).append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ").append(sb).append(" AND (retry_count IS NULL OR retry_count < 2147483647)").toString());
            } catch (SQLiteException e) {
                zzge().zzim().zzg("Error incrementing retry count. error", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x011b  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzeq zzf(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzab()
            r18.zzch()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r2 = r18.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            java.lang.String r3 = "events"
            r4 = 7
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 0
            java.lang.String r6 = "lifetime_count"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 1
            java.lang.String r6 = "current_bundle_count"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 2
            java.lang.String r6 = "last_fire_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 3
            java.lang.String r6 = "last_bundled_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 4
            java.lang.String r6 = "last_sampled_complex_event_id"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 5
            java.lang.String r6 = "last_sampling_rate"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r5 = 6
            java.lang.String r6 = "last_exempt_from_sampling"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            java.lang.String r5 = "app_id=? and name=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r7 = 0
            r6[r7] = r19     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r7 = 1
            r6[r7] = r20     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r17 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x00f1, all -> 0x0116 }
            boolean r2 = r17.moveToFirst()     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 != 0) goto L_0x0058
            if (r17 == 0) goto L_0x0056
            r17.close()
        L_0x0056:
            r3 = 0
        L_0x0057:
            return r3
        L_0x0058:
            r2 = 0
            r0 = r17
            long r6 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r2 = 1
            r0 = r17
            long r8 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r2 = 2
            r0 = r17
            long r10 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r2 = 3
            r0 = r17
            boolean r2 = r0.isNull(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 == 0) goto L_0x00cf
            r12 = 0
        L_0x0078:
            r2 = 4
            r0 = r17
            boolean r2 = r0.isNull(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 == 0) goto L_0x00d7
            r14 = 0
        L_0x0082:
            r2 = 5
            r0 = r17
            boolean r2 = r0.isNull(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 == 0) goto L_0x00e3
            r15 = 0
        L_0x008c:
            r16 = 0
            r2 = 6
            r0 = r17
            boolean r2 = r0.isNull(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 != 0) goto L_0x00a9
            r2 = 6
            r0 = r17
            long r2 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r4 = 1
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x00ef
            r2 = 1
        L_0x00a5:
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        L_0x00a9:
            com.google.android.gms.internal.measurement.zzeq r3 = new com.google.android.gms.internal.measurement.zzeq     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r4 = r19
            r5 = r20
            r3.<init>(r4, r5, r6, r8, r10, r12, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            boolean r2 = r17.moveToNext()     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            if (r2 == 0) goto L_0x00c9
            com.google.android.gms.internal.measurement.zzfg r2 = r18.zzge()     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            java.lang.String r4 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfg.zzbm(r19)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            r2.zzg(r4, r5)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
        L_0x00c9:
            if (r17 == 0) goto L_0x0057
            r17.close()
            goto L_0x0057
        L_0x00cf:
            r2 = 3
            r0 = r17
            long r12 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            goto L_0x0078
        L_0x00d7:
            r2 = 4
            r0 = r17
            long r2 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            java.lang.Long r14 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            goto L_0x0082
        L_0x00e3:
            r2 = 5
            r0 = r17
            long r2 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            java.lang.Long r15 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0125, all -> 0x011f }
            goto L_0x008c
        L_0x00ef:
            r2 = 0
            goto L_0x00a5
        L_0x00f1:
            r2 = move-exception
            r3 = r10
        L_0x00f3:
            com.google.android.gms.internal.measurement.zzfg r4 = r18.zzge()     // Catch:{ all -> 0x0121 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ all -> 0x0121 }
            java.lang.String r5 = "Error querying events. appId"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r19)     // Catch:{ all -> 0x0121 }
            com.google.android.gms.internal.measurement.zzfe r7 = r18.zzga()     // Catch:{ all -> 0x0121 }
            r0 = r20
            java.lang.String r7 = r7.zzbj(r0)     // Catch:{ all -> 0x0121 }
            r4.zzd(r5, r6, r7, r2)     // Catch:{ all -> 0x0121 }
            if (r3 == 0) goto L_0x0113
            r3.close()
        L_0x0113:
            r3 = 0
            goto L_0x0057
        L_0x0116:
            r2 = move-exception
            r17 = r10
        L_0x0119:
            if (r17 == 0) goto L_0x011e
            r17.close()
        L_0x011e:
            throw r2
        L_0x011f:
            r2 = move-exception
            goto L_0x0119
        L_0x0121:
            r2 = move-exception
            r17 = r3
            goto L_0x0119
        L_0x0125:
            r2 = move-exception
            r3 = r17
            goto L_0x00f3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzf(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzeq");
    }

    @WorkerThread
    public final void zzg(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            zzge().zzit().zzg("Deleted user attribute rows", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting user attribute. appId", zzfg.zzbm(str), zzga().zzbl(str2), e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x009c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzjz zzh(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r10)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            r9.zzab()
            r9.zzch()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r3 = 2
            java.lang.String r4 = "origin"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r5 = 1
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0077, all -> 0x0099 }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            if (r0 != 0) goto L_0x0044
            if (r7 == 0) goto L_0x0042
            r7.close()
        L_0x0042:
            r0 = r8
        L_0x0043:
            return r0
        L_0x0044:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            r0 = 1
            java.lang.Object r6 = r9.zza((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            r0 = 2
            java.lang.String r2 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzjz r0 = new com.google.android.gms.internal.measurement.zzjz     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            r1 = r10
            r3 = r11
            r0.<init>(r1, r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            boolean r1 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            if (r1 == 0) goto L_0x0071
            com.google.android.gms.internal.measurement.zzfg r1 = r9.zzge()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
            r1.zzg(r2, r3)     // Catch:{ SQLiteException -> 0x00a6, all -> 0x00a0 }
        L_0x0071:
            if (r7 == 0) goto L_0x0043
            r7.close()
            goto L_0x0043
        L_0x0077:
            r0 = move-exception
            r1 = r8
        L_0x0079:
            com.google.android.gms.internal.measurement.zzfg r2 = r9.zzge()     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00a3 }
            java.lang.String r3 = "Error querying user property. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r10)     // Catch:{ all -> 0x00a3 }
            com.google.android.gms.internal.measurement.zzfe r5 = r9.zzga()     // Catch:{ all -> 0x00a3 }
            java.lang.String r5 = r5.zzbl(r11)     // Catch:{ all -> 0x00a3 }
            r2.zzd(r3, r4, r5, r0)     // Catch:{ all -> 0x00a3 }
            if (r1 == 0) goto L_0x0097
            r1.close()
        L_0x0097:
            r0 = r8
            goto L_0x0043
        L_0x0099:
            r0 = move-exception
        L_0x009a:
            if (r8 == 0) goto L_0x009f
            r8.close()
        L_0x009f:
            throw r0
        L_0x00a0:
            r0 = move-exception
            r8 = r7
            goto L_0x009a
        L_0x00a3:
            r0 = move-exception
            r8 = r1
            goto L_0x009a
        L_0x00a6:
            r0 = move-exception
            r1 = r7
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzh(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzjz");
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzhn() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0023, all -> 0x0038 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0043 }
            if (r1 == 0) goto L_0x001d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0043 }
            if (r2 == 0) goto L_0x001c
            r2.close()
        L_0x001c:
            return r0
        L_0x001d:
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0023:
            r1 = move-exception
            r2 = r0
        L_0x0025:
            com.google.android.gms.internal.measurement.zzfg r3 = r5.zzge()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzg(r4, r1)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0038:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            throw r0
        L_0x0041:
            r0 = move-exception
            goto L_0x003b
        L_0x0043:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzhn():java.lang.String");
    }

    public final boolean zzho() {
        return zza("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzhp() {
        int delete;
        zzab();
        zzch();
        if (zzhv()) {
            long j = zzgf().zzajx.get();
            long elapsedRealtime = zzbt().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzew.zzahg.get().longValue()) {
                zzgf().zzajx.set(elapsedRealtime);
                zzab();
                zzch();
                if (zzhv() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzbt().currentTimeMillis()), String.valueOf(zzef.zzhh())})) > 0) {
                    zzge().zzit().zzg("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    @WorkerThread
    public final long zzhq() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public final long zzhr() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final boolean zzhs() {
        return zza("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzht() {
        return zza("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzhu() {
        long j = -1;
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (cursor.moveToFirst()) {
                j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
            } else if (cursor != null) {
                cursor.close();
            }
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x014d  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzed zzi(java.lang.String r22, java.lang.String r23) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r21.zzab()
            r21.zzch()
            r10 = 0
            android.database.sqlite.SQLiteDatabase r2 = r21.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            java.lang.String r3 = "conditional_properties"
            r4 = 11
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 0
            java.lang.String r6 = "origin"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 1
            java.lang.String r6 = "value"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 2
            java.lang.String r6 = "active"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 3
            java.lang.String r6 = "trigger_event_name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 4
            java.lang.String r6 = "trigger_timeout"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 5
            java.lang.String r6 = "timed_out_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 6
            java.lang.String r6 = "creation_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 7
            java.lang.String r6 = "triggered_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 8
            java.lang.String r6 = "triggered_timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 9
            java.lang.String r6 = "time_to_live"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r5 = 10
            java.lang.String r6 = "expired_event"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            java.lang.String r5 = "app_id=? and name=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r7 = 0
            r6[r7] = r22     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r7 = 1
            r6[r7] = r23     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r20 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ SQLiteException -> 0x0123, all -> 0x0148 }
            boolean r2 = r20.moveToFirst()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            if (r2 != 0) goto L_0x0070
            if (r20 == 0) goto L_0x006e
            r20.close()
        L_0x006e:
            r5 = 0
        L_0x006f:
            return r5
        L_0x0070:
            r2 = 0
            r0 = r20
            java.lang.String r7 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 1
            r0 = r21
            r1 = r20
            java.lang.Object r6 = r0.zza((android.database.Cursor) r1, (int) r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 2
            r0 = r20
            int r2 = r0.getInt(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            if (r2 == 0) goto L_0x0120
            r11 = 1
        L_0x008a:
            r2 = 3
            r0 = r20
            java.lang.String r12 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 4
            r0 = r20
            long r14 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzka r2 = r21.zzgb()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r3 = 5
            r0 = r20
            byte[] r3 = r0.getBlob(r3)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r4 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable r13 = r2.zza((byte[]) r3, r4)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzeu r13 = (com.google.android.gms.internal.measurement.zzeu) r13     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 6
            r0 = r20
            long r9 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzka r2 = r21.zzgb()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r3 = 7
            r0 = r20
            byte[] r3 = r0.getBlob(r3)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r4 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable r16 = r2.zza((byte[]) r3, r4)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzeu r16 = (com.google.android.gms.internal.measurement.zzeu) r16     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 8
            r0 = r20
            long r4 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2 = 9
            r0 = r20
            long r17 = r0.getLong(r2)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzka r2 = r21.zzgb()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r3 = 10
            r0 = r20
            byte[] r3 = r0.getBlob(r3)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r8 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            android.os.Parcelable r19 = r2.zza((byte[]) r3, r8)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzeu r19 = (com.google.android.gms.internal.measurement.zzeu) r19     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzjx r2 = new com.google.android.gms.internal.measurement.zzjx     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r3 = r23
            r2.<init>(r3, r4, r6, r7)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzed r5 = new com.google.android.gms.internal.measurement.zzed     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r6 = r22
            r8 = r2
            r5.<init>(r6, r7, r8, r9, r11, r12, r13, r14, r16, r17, r19)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            boolean r2 = r20.moveToNext()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            if (r2 == 0) goto L_0x0119
            com.google.android.gms.internal.measurement.zzfg r2 = r21.zzge()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            java.lang.String r3 = "Got multiple records for conditional property, expected one"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r22)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            com.google.android.gms.internal.measurement.zzfe r6 = r21.zzga()     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r0 = r23
            java.lang.String r6 = r6.zzbl(r0)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
            r2.zze(r3, r4, r6)     // Catch:{ SQLiteException -> 0x0157, all -> 0x0151 }
        L_0x0119:
            if (r20 == 0) goto L_0x006f
            r20.close()
            goto L_0x006f
        L_0x0120:
            r11 = 0
            goto L_0x008a
        L_0x0123:
            r2 = move-exception
            r3 = r10
        L_0x0125:
            com.google.android.gms.internal.measurement.zzfg r4 = r21.zzge()     // Catch:{ all -> 0x0153 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ all -> 0x0153 }
            java.lang.String r5 = "Error querying conditional property"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r22)     // Catch:{ all -> 0x0153 }
            com.google.android.gms.internal.measurement.zzfe r7 = r21.zzga()     // Catch:{ all -> 0x0153 }
            r0 = r23
            java.lang.String r7 = r7.zzbl(r0)     // Catch:{ all -> 0x0153 }
            r4.zzd(r5, r6, r7, r2)     // Catch:{ all -> 0x0153 }
            if (r3 == 0) goto L_0x0145
            r3.close()
        L_0x0145:
            r5 = 0
            goto L_0x006f
        L_0x0148:
            r2 = move-exception
            r20 = r10
        L_0x014b:
            if (r20 == 0) goto L_0x0150
            r20.close()
        L_0x0150:
            throw r2
        L_0x0151:
            r2 = move-exception
            goto L_0x014b
        L_0x0153:
            r2 = move-exception
            r20 = r3
            goto L_0x014b
        L_0x0157:
            r2 = move-exception
            r3 = r20
            goto L_0x0125
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzi(java.lang.String, java.lang.String):com.google.android.gms.internal.measurement.zzed");
    }

    @WorkerThread
    public final int zzj(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        try {
            return getWritableDatabase().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzge().zzim().zzd("Error deleting conditional property", zzfg.zzbm(str), zzga().zzbl(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzke>> zzk(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzch()
            r10.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x009a }
            r2 = 0
            int r3 = r0.length     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzabv r0 = com.google.android.gms.internal.measurement.zzabv.zza(r0, r2, r3)     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzke r2 = new com.google.android.gms.internal.measurement.zzke     // Catch:{ SQLiteException -> 0x009a }
            r2.<init>()     // Catch:{ SQLiteException -> 0x009a }
            r2.zzb(r0)     // Catch:{ IOException -> 0x0087 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x009a }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0077
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009a }
            r0.<init>()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x009a }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x009a }
        L_0x0077:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x009a }
        L_0x007a:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            r0 = r8
            goto L_0x0046
        L_0x0087:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfg r2 = r10.zzge()     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11)     // Catch:{ SQLiteException -> 0x009a }
            r2.zze(r3, r4, r0)     // Catch:{ SQLiteException -> 0x009a }
            goto L_0x007a
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            com.google.android.gms.internal.measurement.zzfg r2 = r10.zzge()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11)     // Catch:{ all -> 0x00bb }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x00b1
            r1.close()
        L_0x00b1:
            r0 = r9
            goto L_0x0046
        L_0x00b3:
            r0 = move-exception
            r1 = r9
        L_0x00b5:
            if (r1 == 0) goto L_0x00ba
            r1.close()
        L_0x00ba:
            throw r0
        L_0x00bb:
            r0 = move-exception
            goto L_0x00b5
        L_0x00bd:
            r0 = move-exception
            r1 = r9
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzk(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzkh>> zzl(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzch()
            r10.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r11)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00bd, all -> 0x00b3 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x009a }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x009a }
            r2 = 0
            int r3 = r0.length     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzabv r0 = com.google.android.gms.internal.measurement.zzabv.zza(r0, r2, r3)     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzkh r2 = new com.google.android.gms.internal.measurement.zzkh     // Catch:{ SQLiteException -> 0x009a }
            r2.<init>()     // Catch:{ SQLiteException -> 0x009a }
            r2.zzb(r0)     // Catch:{ IOException -> 0x0087 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x009a }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0077
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x009a }
            r0.<init>()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x009a }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x009a }
        L_0x0077:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x009a }
        L_0x007a:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x009a }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0085
            r1.close()
        L_0x0085:
            r0 = r8
            goto L_0x0046
        L_0x0087:
            r0 = move-exception
            com.google.android.gms.internal.measurement.zzfg r2 = r10.zzge()     // Catch:{ SQLiteException -> 0x009a }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ SQLiteException -> 0x009a }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11)     // Catch:{ SQLiteException -> 0x009a }
            r2.zze(r3, r4, r0)     // Catch:{ SQLiteException -> 0x009a }
            goto L_0x007a
        L_0x009a:
            r0 = move-exception
        L_0x009b:
            com.google.android.gms.internal.measurement.zzfg r2 = r10.zzge()     // Catch:{ all -> 0x00bb }
            com.google.android.gms.internal.measurement.zzfi r2 = r2.zzim()     // Catch:{ all -> 0x00bb }
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzfg.zzbm(r11)     // Catch:{ all -> 0x00bb }
            r2.zze(r3, r4, r0)     // Catch:{ all -> 0x00bb }
            if (r1 == 0) goto L_0x00b1
            r1.close()
        L_0x00b1:
            r0 = r9
            goto L_0x0046
        L_0x00b3:
            r0 = move-exception
            r1 = r9
        L_0x00b5:
            if (r1 == 0) goto L_0x00ba
            r1.close()
        L_0x00ba:
            throw r0
        L_0x00bb:
            r0 = move-exception
            goto L_0x00b5
        L_0x00bd:
            r0 = move-exception
            r1 = r9
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzei.zzl(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzm(String str, String str2) {
        SQLiteException e;
        long j;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzab();
        zzch();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            j = zza(new StringBuilder(String.valueOf(str2).length() + 32).append("select ").append(str2).append(" from app2 where app_id=?").toString(), new String[]{str}, -1);
            if (j == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (writableDatabase.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    zzge().zzim().zze("Failed to insert column (got -1). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                j = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + j));
                if (((long) writableDatabase.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzge().zzim().zze("Failed to update column (got 0). appId", zzfg.zzbm(str), str2);
                    writableDatabase.endTransaction();
                    return -1;
                }
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                try {
                    zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e);
                    return j;
                } finally {
                    writableDatabase.endTransaction();
                }
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzge().zzim().zzd("Error inserting column. appId", zzfg.zzbm(str), str2, e);
            return j;
        }
    }
}
