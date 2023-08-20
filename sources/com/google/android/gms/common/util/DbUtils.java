package com.google.android.gms.common.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.io.File;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class DbUtils {
    private DbUtils() {
    }

    public static void clearDatabase(SQLiteDatabase sQLiteDatabase) {
        zza(sQLiteDatabase, "table", "sqlite_sequence", "android_metadata");
        zza(sQLiteDatabase, "trigger", new String[0]);
        zza(sQLiteDatabase, "view", new String[0]);
    }

    public static long countCurrentRowBytes(Cursor cursor) {
        return countCurrentRowBytes(cursor, Charset.forName("UTF-8"));
    }

    public static long countCurrentRowBytes(Cursor cursor, Charset charset) {
        long j = 0;
        for (int i = 0; i < cursor.getColumnCount(); i++) {
            switch (cursor.getType(i)) {
                case 0:
                case 1:
                case 2:
                    j += 4;
                    break;
                case 3:
                    j += (long) cursor.getString(i).getBytes(charset).length;
                    break;
                case 4:
                    j += (long) cursor.getBlob(i).length;
                    break;
            }
        }
        return j;
    }

    public static long getDatabaseSize(Context context, String str) {
        try {
            File databasePath = context.getDatabasePath(str);
            if (databasePath != null) {
                return databasePath.length();
            }
        } catch (SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.w("DbUtils", valueOf.length() != 0 ? "Failed to get db size for ".concat(valueOf) : new String("Failed to get db size for "));
        }
        return 0;
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i) {
        return getIntegerFromCursor(cursor, i, (Integer) null);
    }

    @Nullable
    public static Integer getIntegerFromCursor(Cursor cursor, int i, @Nullable Integer num) {
        return (i < 0 || cursor.isNull(i)) ? num : Integer.valueOf(cursor.getInt(i));
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i) {
        return getLongFromCursor(cursor, i, (Long) null);
    }

    @Nullable
    public static Long getLongFromCursor(Cursor cursor, int i, @Nullable Long l) {
        return (i < 0 || cursor.isNull(i)) ? l : Long.valueOf(cursor.getLong(i));
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i) {
        return getStringFromCursor(cursor, i, (String) null);
    }

    @Nullable
    public static String getStringFromCursor(Cursor cursor, int i, @Nullable String str) {
        return (i < 0 || cursor.isNull(i)) ? str : cursor.getString(i);
    }

    public static void putIntegerIntoContentValues(ContentValues contentValues, String str, @Nullable Integer num) {
        if (num != null) {
            contentValues.put(str, num);
        } else {
            contentValues.putNull(str);
        }
    }

    public static void putLongIntoContentValues(ContentValues contentValues, String str, @Nullable Long l) {
        if (l != null) {
            contentValues.put(str, l);
        } else {
            contentValues.putNull(str);
        }
    }

    public static void putStringIntoContentValues(ContentValues contentValues, String str, @Nullable String str2) {
        if (str2 != null) {
            contentValues.put(str, str2);
        } else {
            contentValues.putNull(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0086, code lost:
        r5 = r0;
        r0 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        r0 = th;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(android.database.sqlite.SQLiteDatabase r8, java.lang.String r9, java.lang.String... r10) {
        /*
            r4 = 1
            r5 = 0
            r6 = 0
            java.lang.String r0 = "table"
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = "view"
            boolean r0 = r0.equals(r9)
            if (r0 != 0) goto L_0x001b
            java.lang.String r0 = "trigger"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0090
        L_0x001b:
            r0 = r4
        L_0x001c:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            java.lang.String r1 = "SQLITE_MASTER"
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.String r0 = "name"
            r2[r6] = r0
            java.lang.String r3 = "type == ?"
            java.lang.String[] r4 = new java.lang.String[r4]
            r4[r6] = r9
            r0 = r8
            r6 = r5
            r7 = r5
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)
            java.util.Set r0 = com.google.android.gms.common.util.CollectionUtils.setOf((T[]) r10)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
        L_0x0038:
            boolean r1 = r2.moveToNext()     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            if (r1 == 0) goto L_0x0092
            r1 = 0
            java.lang.String r1 = r2.getString(r1)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            boolean r3 = r0.contains(r1)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            if (r3 != 0) goto L_0x0038
            java.lang.String r3 = java.lang.String.valueOf(r9)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            int r3 = r3.length()     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            int r3 = r3 + 8
            java.lang.String r4 = java.lang.String.valueOf(r1)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            int r4 = r4.length()     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            r4.<init>(r3)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.String r3 = "DROP "
            java.lang.StringBuilder r3 = r4.append(r3)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.String r4 = " '"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.String r3 = "'"
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            java.lang.String r1 = r1.toString()     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            r8.execSQL(r1)     // Catch:{ Throwable -> 0x0083, all -> 0x00a1 }
            goto L_0x0038
        L_0x0083:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r1 = move-exception
            r5 = r0
            r0 = r1
        L_0x0088:
            if (r2 == 0) goto L_0x008f
            if (r5 == 0) goto L_0x009d
            r2.close()     // Catch:{ Throwable -> 0x0098 }
        L_0x008f:
            throw r0
        L_0x0090:
            r0 = r6
            goto L_0x001c
        L_0x0092:
            if (r2 == 0) goto L_0x0097
            r2.close()
        L_0x0097:
            return
        L_0x0098:
            r1 = move-exception
            com.google.android.gms.internal.stable.zzk.zza(r5, r1)
            goto L_0x008f
        L_0x009d:
            r2.close()
            goto L_0x008f
        L_0x00a1:
            r0 = move-exception
            goto L_0x0088
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DbUtils.zza(android.database.sqlite.SQLiteDatabase, java.lang.String, java.lang.String[]):void");
    }
}
