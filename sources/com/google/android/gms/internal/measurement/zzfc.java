package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzfc extends zzhh {
    private final zzfd zzaig = new zzfd(this, getContext(), "google_app_measurement_local.db");
    private boolean zzaih;

    zzfc(zzgl zzgl) {
        super(zzgl);
    }

    @WorkerThread
    @VisibleForTesting
    private final SQLiteDatabase getWritableDatabase() throws SQLiteException {
        if (this.zzaih) {
            return null;
        }
        SQLiteDatabase writableDatabase = this.zzaig.getWritableDatabase();
        if (writableDatabase != null) {
            return writableDatabase;
        }
        this.zzaih = true;
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00cf, code lost:
        r6 = r6 + 1;
     */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(int r14, byte[] r15) {
        /*
            r13 = this;
            r13.zzab()
            boolean r0 = r13.zzaih
            if (r0 == 0) goto L_0x0009
            r0 = 0
        L_0x0008:
            return r0
        L_0x0009:
            android.content.ContentValues r7 = new android.content.ContentValues
            r7.<init>()
            java.lang.String r0 = "type"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r7.put(r0, r1)
            java.lang.String r0 = "entry"
            r7.put(r0, r15)
            r1 = 5
            r0 = 0
            r6 = r0
            r0 = r1
        L_0x0020:
            r1 = 5
            if (r6 >= r1) goto L_0x0119
            r3 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r13.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            if (r3 != 0) goto L_0x0035
            r1 = 1
            r13.zzaih = r1     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            if (r3 == 0) goto L_0x0033
            r3.close()
        L_0x0033:
            r0 = 0
            goto L_0x0008
        L_0x0035:
            r3.beginTransaction()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r4 = 0
            java.lang.String r1 = "select count(1) from messages"
            r8 = 0
            android.database.Cursor r2 = r3.rawQuery(r1, r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            if (r2 == 0) goto L_0x004e
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            if (r1 == 0) goto L_0x004e
            r1 = 0
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
        L_0x004e:
            r8 = 100000(0x186a0, double:4.94066E-319)
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x009b
            com.google.android.gms.internal.measurement.zzfg r1 = r13.zzge()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            java.lang.String r8 = "Data loss, local db full"
            r1.log(r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r8 = 100000(0x186a0, double:4.94066E-319)
            long r4 = r8 - r4
            r8 = 1
            long r4 = r4 + r8
            java.lang.String r1 = "messages"
            java.lang.String r8 = "rowid in (select rowid from messages order by rowid asc limit ?)"
            r9 = 1
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r10 = 0
            java.lang.String r11 = java.lang.Long.toString(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r9[r10] = r11     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            int r1 = r3.delete(r1, r8, r9)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            long r8 = (long) r1     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            int r1 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x009b
            com.google.android.gms.internal.measurement.zzfg r1 = r13.zzge()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            java.lang.String r10 = "Different delete count than expected in local db. expected, received, difference"
            java.lang.Long r11 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            java.lang.Long r12 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            long r4 = r4 - r8
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r1.zzd(r10, r11, r12, r4)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
        L_0x009b:
            java.lang.String r1 = "messages"
            r4 = 0
            r3.insertOrThrow(r1, r4, r7)     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r3.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            r3.endTransaction()     // Catch:{ SQLiteFullException -> 0x00b4, SQLiteDatabaseLockedException -> 0x00d4, SQLiteException -> 0x00e6 }
            if (r2 == 0) goto L_0x00ac
            r2.close()
        L_0x00ac:
            if (r3 == 0) goto L_0x00b1
            r3.close()
        L_0x00b1:
            r0 = 1
            goto L_0x0008
        L_0x00b4:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r4 = r13.zzge()     // Catch:{ all -> 0x010d }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ all -> 0x010d }
            java.lang.String r5 = "Error writing entry to local database"
            r4.zzg(r5, r1)     // Catch:{ all -> 0x010d }
            r1 = 1
            r13.zzaih = r1     // Catch:{ all -> 0x010d }
            if (r2 == 0) goto L_0x00ca
            r2.close()
        L_0x00ca:
            if (r3 == 0) goto L_0x00cf
            r3.close()
        L_0x00cf:
            int r1 = r6 + 1
            r6 = r1
            goto L_0x0020
        L_0x00d4:
            r1 = move-exception
            long r4 = (long) r0
            android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x010d }
            int r0 = r0 + 20
            if (r2 == 0) goto L_0x00e0
            r2.close()
        L_0x00e0:
            if (r3 == 0) goto L_0x00cf
            r3.close()
            goto L_0x00cf
        L_0x00e6:
            r1 = move-exception
            if (r3 == 0) goto L_0x00f2
            boolean r4 = r3.inTransaction()     // Catch:{ all -> 0x010d }
            if (r4 == 0) goto L_0x00f2
            r3.endTransaction()     // Catch:{ all -> 0x010d }
        L_0x00f2:
            com.google.android.gms.internal.measurement.zzfg r4 = r13.zzge()     // Catch:{ all -> 0x010d }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ all -> 0x010d }
            java.lang.String r5 = "Error writing entry to local database"
            r4.zzg(r5, r1)     // Catch:{ all -> 0x010d }
            r1 = 1
            r13.zzaih = r1     // Catch:{ all -> 0x010d }
            if (r2 == 0) goto L_0x0107
            r2.close()
        L_0x0107:
            if (r3 == 0) goto L_0x00cf
            r3.close()
            goto L_0x00cf
        L_0x010d:
            r0 = move-exception
            if (r2 == 0) goto L_0x0113
            r2.close()
        L_0x0113:
            if (r3 == 0) goto L_0x0118
            r3.close()
        L_0x0118:
            throw r0
        L_0x0119:
            com.google.android.gms.internal.measurement.zzfg r0 = r13.zzge()
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzip()
            java.lang.String r1 = "Failed to write entry to local database"
            r0.log(r1)
            r0 = 0
            goto L_0x0008
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zza(int, byte[]):boolean");
    }

    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public final void resetAnalyticsData() {
        zzab();
        try {
            int delete = getWritableDatabase().delete("messages", (String) null, (String[]) null) + 0;
            if (delete > 0) {
                zzge().zzit().zzg("Reset local analytics data. records", Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzge().zzim().zzg("Error resetting local analytics data. error", e);
        }
    }

    public final boolean zza(zzeu zzeu) {
        Parcel obtain = Parcel.obtain();
        zzeu.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(0, marshall);
        }
        zzge().zzip().log("Event is too long for local database. Sending event directly to service");
        return false;
    }

    public final boolean zza(zzjx zzjx) {
        Parcel obtain = Parcel.obtain();
        zzjx.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length <= 131072) {
            return zza(1, marshall);
        }
        zzge().zzip().log("User property too long for local database. Sending directly to service");
        return false;
    }

    public final /* bridge */ /* synthetic */ void zzab() {
        super.zzab();
    }

    public final /* bridge */ /* synthetic */ Clock zzbt() {
        return super.zzbt();
    }

    public final boolean zzc(zzed zzed) {
        zzgb();
        byte[] zza = zzka.zza((Parcelable) zzed);
        if (zza.length <= 131072) {
            return zza(2, zza);
        }
        zzge().zzip().log("Conditional user property too long for local database. Sending directly to service");
        return false;
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

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x00b6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00ec A[SYNTHETIC, Splitter:B:66:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x013a  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x013f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable> zzp(int r15) {
        /*
            r14 = this;
            r14.zzab()
            boolean r0 = r14.zzaih
            if (r0 == 0) goto L_0x0009
            r0 = 0
        L_0x0008:
            return r0
        L_0x0009:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            android.content.Context r0 = r14.getContext()
            java.lang.String r1 = "google_app_measurement_local.db"
            java.io.File r0 = r0.getDatabasePath(r1)
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0020
            r0 = r10
            goto L_0x0008
        L_0x0020:
            r9 = 5
            r0 = 0
            r12 = r0
        L_0x0023:
            r0 = 5
            if (r12 >= r0) goto L_0x01dd
            r1 = 0
            r11 = 0
            android.database.sqlite.SQLiteDatabase r0 = r14.getWritableDatabase()     // Catch:{ SQLiteFullException -> 0x0215, SQLiteDatabaseLockedException -> 0x020c, SQLiteException -> 0x0201, all -> 0x01ed }
            if (r0 != 0) goto L_0x0038
            r1 = 1
            r14.zzaih = r1     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            if (r0 == 0) goto L_0x0036
            r0.close()
        L_0x0036:
            r0 = 0
            goto L_0x0008
        L_0x0038:
            r0.beginTransaction()     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            java.lang.String r1 = "messages"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            r3 = 1
            java.lang.String r4 = "type"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            r3 = 2
            java.lang.String r4 = "entry"
            r2[r3] = r4     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid asc"
            r8 = 100
            java.lang.String r8 = java.lang.Integer.toString(r8)     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteFullException -> 0x021a, SQLiteDatabaseLockedException -> 0x0210, SQLiteException -> 0x0205, all -> 0x01f1 }
            r4 = -1
        L_0x0061:
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            if (r1 == 0) goto L_0x01a5
            r1 = 0
            long r4 = r2.getLong(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r1 = 1
            int r1 = r2.getInt(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r3 = 2
            byte[] r6 = r2.getBlob(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            if (r1 != 0) goto L_0x0111
            android.os.Parcel r3 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r1 = 0
            int r7 = r6.length     // Catch:{ ParseException -> 0x00bc }
            r3.unmarshall(r6, r1, r7)     // Catch:{ ParseException -> 0x00bc }
            r1 = 0
            r3.setDataPosition(r1)     // Catch:{ ParseException -> 0x00bc }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzeu> r1 = com.google.android.gms.internal.measurement.zzeu.CREATOR     // Catch:{ ParseException -> 0x00bc }
            java.lang.Object r1 = r1.createFromParcel(r3)     // Catch:{ ParseException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzeu r1 = (com.google.android.gms.internal.measurement.zzeu) r1     // Catch:{ ParseException -> 0x00bc }
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            goto L_0x0061
        L_0x0096:
            r1 = move-exception
            r13 = r1
            r1 = r2
            r2 = r0
            r0 = r13
        L_0x009b:
            com.google.android.gms.internal.measurement.zzfg r3 = r14.zzge()     // Catch:{ all -> 0x01f8 }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x01f8 }
            java.lang.String r4 = "Error reading entries from local database"
            r3.zzg(r4, r0)     // Catch:{ all -> 0x01f8 }
            r0 = 1
            r14.zzaih = r0     // Catch:{ all -> 0x01f8 }
            if (r1 == 0) goto L_0x00b0
            r1.close()
        L_0x00b0:
            if (r2 == 0) goto L_0x0220
            r2.close()
            r0 = r9
        L_0x00b6:
            int r1 = r12 + 1
            r12 = r1
            r9 = r0
            goto L_0x0023
        L_0x00bc:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r1 = r14.zzge()     // Catch:{ all -> 0x00e1 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ all -> 0x00e1 }
            java.lang.String r6 = "Failed to load event from local database"
            r1.log(r6)     // Catch:{ all -> 0x00e1 }
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            goto L_0x0061
        L_0x00ce:
            r1 = move-exception
            r1 = r0
        L_0x00d0:
            long r4 = (long) r9
            android.os.SystemClock.sleep(r4)     // Catch:{ all -> 0x01fe }
            int r0 = r9 + 20
            if (r2 == 0) goto L_0x00db
            r2.close()
        L_0x00db:
            if (r1 == 0) goto L_0x00b6
            r1.close()
            goto L_0x00b6
        L_0x00e1:
            r1 = move-exception
            r3.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x00e6:
            r1 = move-exception
            r13 = r1
            r1 = r0
            r0 = r13
        L_0x00ea:
            if (r1 == 0) goto L_0x00f5
            boolean r3 = r1.inTransaction()     // Catch:{ all -> 0x01fe }
            if (r3 == 0) goto L_0x00f5
            r1.endTransaction()     // Catch:{ all -> 0x01fe }
        L_0x00f5:
            com.google.android.gms.internal.measurement.zzfg r3 = r14.zzge()     // Catch:{ all -> 0x01fe }
            com.google.android.gms.internal.measurement.zzfi r3 = r3.zzim()     // Catch:{ all -> 0x01fe }
            java.lang.String r4 = "Error reading entries from local database"
            r3.zzg(r4, r0)     // Catch:{ all -> 0x01fe }
            r0 = 1
            r14.zzaih = r0     // Catch:{ all -> 0x01fe }
            if (r2 == 0) goto L_0x010a
            r2.close()
        L_0x010a:
            if (r1 == 0) goto L_0x0220
            r1.close()
            r0 = r9
            goto L_0x00b6
        L_0x0111:
            r3 = 1
            if (r1 != r3) goto L_0x015b
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r3 = 0
            r1 = 0
            int r8 = r6.length     // Catch:{ ParseException -> 0x0143 }
            r7.unmarshall(r6, r1, r8)     // Catch:{ ParseException -> 0x0143 }
            r1 = 0
            r7.setDataPosition(r1)     // Catch:{ ParseException -> 0x0143 }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzjx> r1 = com.google.android.gms.internal.measurement.zzjx.CREATOR     // Catch:{ ParseException -> 0x0143 }
            java.lang.Object r1 = r1.createFromParcel(r7)     // Catch:{ ParseException -> 0x0143 }
            com.google.android.gms.internal.measurement.zzjx r1 = (com.google.android.gms.internal.measurement.zzjx) r1     // Catch:{ ParseException -> 0x0143 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x012d:
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            goto L_0x0061
        L_0x0134:
            r1 = move-exception
            r13 = r1
            r1 = r0
            r0 = r13
        L_0x0138:
            if (r2 == 0) goto L_0x013d
            r2.close()
        L_0x013d:
            if (r1 == 0) goto L_0x0142
            r1.close()
        L_0x0142:
            throw r0
        L_0x0143:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r1 = r14.zzge()     // Catch:{ all -> 0x0156 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ all -> 0x0156 }
            java.lang.String r6 = "Failed to load user property from local database"
            r1.log(r6)     // Catch:{ all -> 0x0156 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r1 = r3
            goto L_0x012d
        L_0x0156:
            r1 = move-exception
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x015b:
            r3 = 2
            if (r1 != r3) goto L_0x0196
            android.os.Parcel r7 = android.os.Parcel.obtain()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r3 = 0
            r1 = 0
            int r8 = r6.length     // Catch:{ ParseException -> 0x017e }
            r7.unmarshall(r6, r1, r8)     // Catch:{ ParseException -> 0x017e }
            r1 = 0
            r7.setDataPosition(r1)     // Catch:{ ParseException -> 0x017e }
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzed> r1 = com.google.android.gms.internal.measurement.zzed.CREATOR     // Catch:{ ParseException -> 0x017e }
            java.lang.Object r1 = r1.createFromParcel(r7)     // Catch:{ ParseException -> 0x017e }
            com.google.android.gms.internal.measurement.zzed r1 = (com.google.android.gms.internal.measurement.zzed) r1     // Catch:{ ParseException -> 0x017e }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x0177:
            if (r1 == 0) goto L_0x0061
            r10.add(r1)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            goto L_0x0061
        L_0x017e:
            r1 = move-exception
            com.google.android.gms.internal.measurement.zzfg r1 = r14.zzge()     // Catch:{ all -> 0x0191 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ all -> 0x0191 }
            java.lang.String r6 = "Failed to load user property from local database"
            r1.log(r6)     // Catch:{ all -> 0x0191 }
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r1 = r3
            goto L_0x0177
        L_0x0191:
            r1 = move-exception
            r7.recycle()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            throw r1     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x0196:
            com.google.android.gms.internal.measurement.zzfg r1 = r14.zzge()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            java.lang.String r3 = "Unknown record type in local database"
            r1.log(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            goto L_0x0061
        L_0x01a5:
            java.lang.String r1 = "messages"
            java.lang.String r3 = "rowid <= ?"
            r6 = 1
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r7 = 0
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r6[r7] = r4     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            int r1 = r0.delete(r1, r3, r6)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            int r3 = r10.size()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            if (r1 >= r3) goto L_0x01ca
            com.google.android.gms.internal.measurement.zzfg r1 = r14.zzge()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            com.google.android.gms.internal.measurement.zzfi r1 = r1.zzim()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            java.lang.String r3 = "Fewer entries removed from local database than expected"
            r1.log(r3)     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
        L_0x01ca:
            r0.setTransactionSuccessful()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            r0.endTransaction()     // Catch:{ SQLiteFullException -> 0x0096, SQLiteDatabaseLockedException -> 0x00ce, SQLiteException -> 0x00e6, all -> 0x0134 }
            if (r2 == 0) goto L_0x01d5
            r2.close()
        L_0x01d5:
            if (r0 == 0) goto L_0x01da
            r0.close()
        L_0x01da:
            r0 = r10
            goto L_0x0008
        L_0x01dd:
            com.google.android.gms.internal.measurement.zzfg r0 = r14.zzge()
            com.google.android.gms.internal.measurement.zzfi r0 = r0.zzip()
            java.lang.String r1 = "Failed to read events from database in reasonable time"
            r0.log(r1)
            r0 = 0
            goto L_0x0008
        L_0x01ed:
            r0 = move-exception
            r2 = r11
            goto L_0x0138
        L_0x01f1:
            r1 = move-exception
            r2 = r11
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x0138
        L_0x01f8:
            r0 = move-exception
            r13 = r1
            r1 = r2
            r2 = r13
            goto L_0x0138
        L_0x01fe:
            r0 = move-exception
            goto L_0x0138
        L_0x0201:
            r0 = move-exception
            r2 = r11
            goto L_0x00ea
        L_0x0205:
            r1 = move-exception
            r2 = r11
            r13 = r1
            r1 = r0
            r0 = r13
            goto L_0x00ea
        L_0x020c:
            r0 = move-exception
            r2 = r11
            goto L_0x00d0
        L_0x0210:
            r1 = move-exception
            r2 = r11
            r1 = r0
            goto L_0x00d0
        L_0x0215:
            r0 = move-exception
            r2 = r1
            r1 = r11
            goto L_0x009b
        L_0x021a:
            r1 = move-exception
            r2 = r0
            r0 = r1
            r1 = r11
            goto L_0x009b
        L_0x0220:
            r0 = r9
            goto L_0x00b6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfc.zzp(int):java.util.List");
    }
}
