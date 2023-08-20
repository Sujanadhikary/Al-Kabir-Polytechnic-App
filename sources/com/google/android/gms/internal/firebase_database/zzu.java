package com.google.android.gms.internal.firebase_database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DatabaseException;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzu implements zzfw {
    private static final Charset zzbq = Charset.forName("UTF-8");
    private final SQLiteDatabase zzbr;
    private final zzhz zzbs;
    private boolean zzbt;
    private long zzbu = 0;

    public zzu(Context context, zzbz zzbz, String str) {
        try {
            String encode = URLEncoder.encode(str, "utf-8");
            this.zzbs = zzbz.zzp("Persistence");
            this.zzbr = zza(context, encode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final int zza(String str, zzch zzch) {
        String zzc = zzc(zzch);
        String zzc2 = zzc(zzc);
        return this.zzbr.delete(str, "path >= ? AND path < ?", new String[]{zzc, zzc2});
    }

    private final Cursor zza(zzch zzch, String[] strArr) {
        String zzc = zzc(zzch);
        String zzc2 = zzc(zzc);
        String[] strArr2 = new String[(zzch.size() + 3)];
        int i = 0;
        StringBuilder sb = new StringBuilder("(");
        zzch zzch2 = zzch;
        while (!zzch2.isEmpty()) {
            sb.append("path");
            sb.append(" = ? OR ");
            strArr2[i] = zzc(zzch2);
            zzch2 = zzch2.zzby();
            i++;
        }
        sb.append("path");
        sb.append(" = ?)");
        strArr2[i] = zzc(zzch.zzbt());
        String valueOf = String.valueOf(sb.toString());
        String valueOf2 = String.valueOf(" OR (path > ? AND path < ?)");
        String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        strArr2[zzch.size() + 1] = zzc;
        strArr2[zzch.size() + 2] = zzc2;
        return this.zzbr.query("serverCache", strArr, concat, strArr2, (String) null, (String) null, "path");
    }

    private static SQLiteDatabase zza(Context context, String str) {
        try {
            SQLiteDatabase writableDatabase = new zzx(context, str).getWritableDatabase();
            writableDatabase.rawQuery("PRAGMA locking_mode = EXCLUSIVE", (String[]) null).close();
            writableDatabase.beginTransaction();
            writableDatabase.endTransaction();
            return writableDatabase;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private static zzja zza(byte[] bArr) {
        try {
            return zzjd.zza(zzke.zzw(new String(bArr, zzbq)), zzir.zzfv());
        } catch (IOException e) {
            IOException iOException = e;
            String valueOf = String.valueOf(new String(bArr, zzbq));
            throw new RuntimeException(valueOf.length() != 0 ? "Could not deserialize node: ".concat(valueOf) : new String("Could not deserialize node: "), iOException);
        }
    }

    private static String zza(zzch zzch, int i) {
        String valueOf = String.valueOf(zzc(zzch));
        String valueOf2 = String.valueOf(String.format(".part-%04d", new Object[]{Integer.valueOf(i)}));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private static String zza(Collection<Long> collection) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        Iterator<Long> it = collection.iterator();
        while (true) {
            boolean z2 = z;
            if (!it.hasNext()) {
                return sb.toString();
            }
            long longValue = it.next().longValue();
            if (!z2) {
                sb.append(",");
            }
            z = false;
            sb.append(longValue);
        }
    }

    private static List<byte[]> zza(byte[] bArr, int i) {
        int length = ((bArr.length - 1) / 262144) + 1;
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            int min = Math.min(262144, bArr.length - (i2 * 262144));
            byte[] bArr2 = new byte[min];
            System.arraycopy(bArr, i2 * 262144, bArr2, 0, min);
            arrayList.add(bArr2);
        }
        return arrayList;
    }

    private final void zza(zzch zzch, long j, String str, byte[] bArr) {
        int i = 0;
        zzn();
        this.zzbr.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        if (bArr.length >= 262144) {
            List<byte[]> zza = zza(bArr, 262144);
            while (true) {
                int i2 = i;
                if (i2 < zza.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("id", Long.valueOf(j));
                    contentValues.put("path", zzc(zzch));
                    contentValues.put(AppMeasurement.Param.TYPE, str);
                    contentValues.put("part", Integer.valueOf(i2));
                    contentValues.put("node", zza.get(i2));
                    this.zzbr.insertWithOnConflict("writes", (String) null, contentValues, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("id", Long.valueOf(j));
            contentValues2.put("path", zzc(zzch));
            contentValues2.put(AppMeasurement.Param.TYPE, str);
            contentValues2.put("part", (Integer) null);
            contentValues2.put("node", bArr);
            this.zzbr.insertWithOnConflict("writes", (String) null, contentValues2, 5);
        }
    }

    private final void zza(zzch zzch, zzch zzch2, zzgj<Long> zzgj, zzgj<Long> zzgj2, zzfx zzfx, List<zzkn<zzch, zzja>> list) {
        if (zzgj.getValue() != null) {
            int intValue = ((Integer) zzfx.zza(0, new zzv(this, zzgj2))).intValue();
            if (intValue > 0) {
                zzch zzh = zzch.zzh(zzch2);
                if (this.zzbs.zzfa()) {
                    this.zzbs.zza(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(intValue), zzh}), (Throwable) null, new Object[0]);
                }
                zzfx.zza(null, new zzw(this, zzgj2, list, zzch2, zzb(zzh)));
                return;
            }
            return;
        }
        Iterator<Map.Entry<zzid, zzgj<Long>>> it = zzgj.zzdm().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzid zzid = (zzid) next.getKey();
            zzfx zzd = zzfx.zzd((zzid) next.getKey());
            zzgj<Long> zze = zzgj2.zze(zzid);
            zza(zzch, zzch2.zza(zzid), (zzgj) next.getValue(), zze, zzd, list);
        }
    }

    private final void zza(zzch zzch, zzja zzja, boolean z) {
        int i;
        int i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (!z) {
            i2 = zza("serverCache", zzch);
            i = zzc(zzch, zzja);
        } else {
            Iterator it = zzja.iterator();
            i = 0;
            i2 = 0;
            while (it.hasNext()) {
                zziz zziz = (zziz) it.next();
                i2 += zza("serverCache", zzch.zza(zziz.zzge()));
                i = zzc(zzch.zza(zziz.zzge()), zziz.zzd()) + i;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), zzch.toString(), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    private static byte[] zza(Object obj) {
        try {
            return zzke.zze(obj).getBytes(zzbq);
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private static byte[] zza(List<byte[]> list) {
        int i = 0;
        for (byte[] length : list) {
            i = length.length + i;
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (byte[] next : list) {
            System.arraycopy(next, 0, bArr, i2, next.length);
            i2 = next.length + i2;
        }
        return bArr;
    }

    /* JADX INFO: finally extract failed */
    private final zzja zzb(zzch zzch) {
        zzja zza;
        int i;
        zzch zzch2;
        boolean z;
        zzja zzl;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor zza2 = zza(zzch, new String[]{"path", FirebaseAnalytics.Param.VALUE});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        long currentTimeMillis3 = System.currentTimeMillis();
        while (zza2.moveToNext()) {
            try {
                arrayList.add(zza2.getString(0));
                arrayList2.add(zza2.getBlob(1));
            } catch (Throwable th) {
                zza2.close();
                throw th;
            }
        }
        zza2.close();
        long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
        long currentTimeMillis5 = System.currentTimeMillis();
        zzja zzfv = zzir.zzfv();
        boolean z2 = false;
        HashMap hashMap = new HashMap();
        int i2 = 0;
        while (i2 < arrayList2.size()) {
            if (((String) arrayList.get(i2)).endsWith(".part-0000")) {
                String str = (String) arrayList.get(i2);
                zzch zzch3 = new zzch(str.substring(0, str.length() - 10));
                int i3 = i2 + 1;
                String zzc = zzc(zzch3);
                if (!((String) arrayList.get(i2)).startsWith(zzc)) {
                    throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
                }
                while (i3 < arrayList.size() && ((String) arrayList.get(i3)).equals(zza(zzch3, i3 - i2))) {
                    i3++;
                }
                if (i3 < arrayList.size()) {
                    String str2 = (String) arrayList.get(i3);
                    String valueOf = String.valueOf(zzc);
                    String valueOf2 = String.valueOf(".part-");
                    if (str2.startsWith(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf))) {
                        throw new IllegalStateException("Run did not finish with all parts");
                    }
                }
                int i4 = i3 - i2;
                if (this.zzbs.zzfa()) {
                    this.zzbs.zza(new StringBuilder(42).append("Loading split node with ").append(i4).append(" parts.").toString(), (Throwable) null, new Object[0]);
                }
                zza = zza(zza((List<byte[]>) arrayList2.subList(i2, i2 + i4)));
                i = (i2 + i4) - 1;
                zzch2 = zzch3;
            } else {
                zza = zza((byte[]) arrayList2.get(i2));
                i = i2;
                zzch2 = new zzch((String) arrayList.get(i2));
            }
            if (zzch2.zzbz() != null && zzch2.zzbz().zzfh()) {
                hashMap.put(zzch2, zza);
                z = z2;
                zzl = zzfv;
            } else if (zzch2.zzi(zzch)) {
                zzkq.zza(!z2, "Descendants of path must come after ancestors.");
                boolean z3 = z2;
                zzl = zza.zzam(zzch.zza(zzch2, zzch));
                z = z3;
            } else if (zzch.zzi(zzch2)) {
                z = true;
                zzl = zzfv.zzl(zzch.zza(zzch, zzch2), zza);
            } else {
                throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{zzch2, zzch}));
            }
            i2 = i + 1;
            zzfv = zzl;
            z2 = z;
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            zzfv = zzfv.zzl(zzch.zza(zzch, (zzch) entry.getKey()), (zzja) entry.getValue());
        }
        long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
        long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(arrayList2.size()), Integer.valueOf(zzkl.zzo(zzfv)), zzch, Long.valueOf(currentTimeMillis7), Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis4), Long.valueOf(currentTimeMillis6)}), (Throwable) null, new Object[0]);
        }
        return zzfv;
    }

    private final int zzc(zzch zzch, zzja zzja) {
        int i;
        int i2 = 0;
        long zzn = zzkl.zzn(zzja);
        if (!(zzja instanceof zzif) || zzn <= PlaybackStateCompat.ACTION_PREPARE) {
            zzd(zzch, zzja);
            return 1;
        }
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{zzch, Long.valueOf(zzn), 16384}), (Throwable) null, new Object[0]);
        }
        Iterator it = zzja.iterator();
        while (true) {
            i = i2;
            if (!it.hasNext()) {
                break;
            }
            zziz zziz = (zziz) it.next();
            i2 = zzc(zzch.zza(zziz.zzge()), zziz.zzd()) + i;
        }
        if (!zzja.zzfl().isEmpty()) {
            zzd(zzch.zza(zzid.zzfe()), zzja.zzfl());
            i++;
        }
        zzd(zzch, zzir.zzfv());
        return i + 1;
    }

    private static String zzc(zzch zzch) {
        return zzch.isEmpty() ? "/" : String.valueOf(zzch.toString()).concat("/");
    }

    private static String zzc(String str) {
        String substring = str.substring(0, str.length() - 1);
        return new StringBuilder(String.valueOf(substring).length() + 1).append(substring).append('0').toString();
    }

    private final void zzd(zzch zzch, zzja zzja) {
        int i = 0;
        byte[] zza = zza(zzja.getValue(true));
        if (zza.length >= 262144) {
            List<byte[]> zza2 = zza(zza, 262144);
            if (this.zzbs.zzfa()) {
                this.zzbs.zza(new StringBuilder(45).append("Saving huge leaf node with ").append(zza2.size()).append(" parts.").toString(), (Throwable) null, new Object[0]);
            }
            while (true) {
                int i2 = i;
                if (i2 < zza2.size()) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("path", zza(zzch, i2));
                    contentValues.put(FirebaseAnalytics.Param.VALUE, zza2.get(i2));
                    this.zzbr.insertWithOnConflict("serverCache", (String) null, contentValues, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("path", zzc(zzch));
            contentValues2.put(FirebaseAnalytics.Param.VALUE, zza);
            this.zzbr.insertWithOnConflict("serverCache", (String) null, contentValues2, 5);
        }
    }

    private final void zzn() {
        zzkq.zza(this.zzbt, "Transaction expected to already be in progress.");
    }

    public final void beginTransaction() {
        zzkq.zza(!this.zzbt, "runInTransaction called when an existing transaction is already in progress.");
        if (this.zzbs.zzfa()) {
            this.zzbs.zza("Starting transaction.", (Throwable) null, new Object[0]);
        }
        this.zzbr.beginTransaction();
        this.zzbt = true;
        this.zzbu = System.currentTimeMillis();
    }

    public final void endTransaction() {
        this.zzbr.endTransaction();
        this.zzbt = false;
        long currentTimeMillis = System.currentTimeMillis() - this.zzbu;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(currentTimeMillis)}), (Throwable) null, new Object[0]);
        }
    }

    public final void setTransactionSuccessful() {
        this.zzbr.setTransactionSuccessful();
    }

    public final zzja zza(zzch zzch) {
        return zzb(zzch);
    }

    public final Set<zzid> zza(Set<Long> set) {
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zza((Collection<Long>) set);
        Cursor query = this.zzbr.query(true, "trackedKeys", new String[]{"key"}, new StringBuilder(String.valueOf(zza).length() + 8).append("id IN (").append(zza).append(")").toString(), (String[]) null, (String) null, (String) null, (String) null, (String) null);
        HashSet hashSet = new HashSet();
        while (query.moveToNext()) {
            try {
                hashSet.add(zzid.zzt(query.getString(0)));
            } finally {
                query.close();
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(hashSet.size()), set.toString(), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
        return hashSet;
    }

    public final void zza(long j) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzbr.delete("writes", "id = ?", new String[]{String.valueOf(j)});
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(long j, Set<zzid> set) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        this.zzbr.delete("trackedKeys", "id = ?", new String[]{valueOf});
        for (zzid zzfg : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", zzfg.zzfg());
            this.zzbr.insertWithOnConflict("trackedKeys", (String) null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(set.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(long j, Set<zzid> set, Set<zzid> set2) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        String valueOf = String.valueOf(j);
        for (zzid zzfg : set2) {
            this.zzbr.delete("trackedKeys", "id = ? AND key = ?", new String[]{valueOf, zzfg.zzfg()});
        }
        for (zzid zzfg2 : set) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Long.valueOf(j));
            contentValues.put("key", zzfg2.zzfg());
            this.zzbr.insertWithOnConflict("trackedKeys", (String) null, contentValues, 5);
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(set.size()), Integer.valueOf(set2.size()), Long.valueOf(j), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(zzch zzch, zzbv zzbv) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<zzch, zzja>> it = zzbv.iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            i += zza("serverCache", zzch.zzh((zzch) next.getKey()));
            i2 = zzc(zzch.zzh((zzch) next.getKey()), (zzja) next.getValue()) + i2;
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(i2), Integer.valueOf(i), zzch.toString(), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(zzch zzch, zzbv zzbv, long j) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        zza(zzch, j, "m", zza((Object) zzbv.zzd(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(zzch zzch, zzfx zzfx) {
        if (zzfx.zzdh()) {
            zzn();
            long currentTimeMillis = System.currentTimeMillis();
            Cursor zza = zza(zzch, new String[]{"rowid", "path"});
            zzgj zzgj = new zzgj(null);
            zzgj zzgj2 = new zzgj(null);
            while (zza.moveToNext()) {
                long j = zza.getLong(0);
                zzch zzch2 = new zzch(zza.getString(1));
                if (!zzch.zzi(zzch2)) {
                    zzhz zzhz = this.zzbs;
                    String valueOf = String.valueOf(zzch);
                    String valueOf2 = String.valueOf(zzch2);
                    zzhz.zzb(new StringBuilder(String.valueOf(valueOf).length() + 67 + String.valueOf(valueOf2).length()).append("We are pruning at ").append(valueOf).append(" but we have data stored higher up at ").append(valueOf2).append(". Ignoring.").toString(), (Throwable) null);
                } else {
                    zzch zza2 = zzch.zza(zzch, zzch2);
                    if (zzfx.zzv(zza2)) {
                        zzgj = zzgj.zzb(zza2, Long.valueOf(j));
                    } else if (zzfx.zzw(zza2)) {
                        zzgj2 = zzgj2.zzb(zza2, Long.valueOf(j));
                    } else {
                        zzhz zzhz2 = this.zzbs;
                        String valueOf3 = String.valueOf(zzch);
                        String valueOf4 = String.valueOf(zzch2);
                        zzhz2.zzb(new StringBuilder(String.valueOf(valueOf3).length() + 88 + String.valueOf(valueOf4).length()).append("We are pruning at ").append(valueOf3).append(" and have data at ").append(valueOf4).append(" that isn't marked for pruning or keeping. Ignoring.").toString(), (Throwable) null);
                    }
                }
            }
            int i = 0;
            int i2 = 0;
            if (!zzgj.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                zza(zzch, zzch.zzbt(), zzgj, zzgj2, zzfx, arrayList);
                Collection values = zzgj.values();
                String zza3 = zza((Collection<Long>) values);
                this.zzbr.delete("serverCache", new StringBuilder(String.valueOf(zza3).length() + 11).append("rowid IN (").append(zza3).append(")").toString(), (String[]) null);
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    zzkn zzkn = (zzkn) arrayList2.get(i3);
                    zzc(zzch.zzh((zzch) zzkn.getFirst()), (zzja) zzkn.zzgv());
                }
                i = values.size();
                i2 = arrayList.size();
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            if (this.zzbs.zzfa()) {
                this.zzbs.zza(String.format("Pruned %d rows with %d nodes resaved in %dms", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
            }
        }
    }

    public final void zza(zzch zzch, zzja zzja) {
        zzn();
        zza(zzch, zzja, false);
    }

    public final void zza(zzch zzch, zzja zzja, long j) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        zza(zzch, j, "o", zza(zzja.getValue(true)));
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zza(zzgb zzgb) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Long.valueOf(zzgb.f26id));
        contentValues.put("path", zzc(zzgb.zznp.zzg()));
        contentValues.put("queryParams", zzgb.zznp.zzen().zzel());
        contentValues.put("lastUse", Long.valueOf(zzgb.zznq));
        contentValues.put("complete", Boolean.valueOf(zzgb.zznr));
        contentValues.put("active", Boolean.valueOf(zzgb.zzns));
        this.zzbr.insertWithOnConflict("trackedQueries", (String) null, contentValues, 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final void zzb(long j) {
        zzn();
        String valueOf = String.valueOf(j);
        this.zzbr.delete("trackedQueries", "id = ?", new String[]{valueOf});
        this.zzbr.delete("trackedKeys", "id = ?", new String[]{valueOf});
    }

    public final void zzb(zzch zzch, zzja zzja) {
        zzn();
        zza(zzch, zzja, true);
    }

    public final void zzc(long j) {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        ContentValues contentValues = new ContentValues();
        contentValues.put("active", false);
        contentValues.put("lastUse", Long.valueOf(j));
        this.zzbr.updateWithOnConflict("trackedQueries", contentValues, "active = 1", new String[0], 5);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }

    public final Set<zzid> zzd(long j) {
        return zza((Set<Long>) Collections.singleton(Long.valueOf(j)));
    }

    public final List<zzfa> zzj() {
        byte[] zza;
        zzfa zzfa;
        String[] strArr = {"id", "path", AppMeasurement.Param.TYPE, "part", "node"};
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzbr.query("writes", strArr, (String) null, (String[]) null, (String) null, (String) null, "id, part");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                long j = query.getLong(0);
                zzch zzch = new zzch(query.getString(1));
                String string = query.getString(2);
                if (query.isNull(3)) {
                    zza = query.getBlob(4);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    do {
                        arrayList2.add(query.getBlob(4));
                        if (!query.moveToNext() || query.getLong(0) != j) {
                            query.moveToPrevious();
                            zza = zza((List<byte[]>) arrayList2);
                        }
                        arrayList2.add(query.getBlob(4));
                        break;
                    } while (query.getLong(0) != j);
                    query.moveToPrevious();
                    zza = zza((List<byte[]>) arrayList2);
                }
                Object zzw = zzke.zzw(new String(zza, zzbq));
                if ("o".equals(string)) {
                    zzfa = new zzfa(j, zzch, zzjd.zza(zzw, zzir.zzfv()), true);
                } else if ("m".equals(string)) {
                    zzfa = new zzfa(j, zzch, zzbv.zzf((Map<String, Object>) (Map) zzw));
                } else {
                    String valueOf = String.valueOf(string);
                    throw new IllegalStateException(valueOf.length() != 0 ? "Got invalid write type: ".concat(valueOf) : new String("Got invalid write type: "));
                }
                arrayList.add(zzfa);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final long zzk() {
        Cursor rawQuery = this.zzbr.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{FirebaseAnalytics.Param.VALUE, "path", "serverCache"}), (String[]) null);
        try {
            if (rawQuery.moveToFirst()) {
                return rawQuery.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            rawQuery.close();
        }
    }

    public final List<zzgb> zzl() {
        long currentTimeMillis = System.currentTimeMillis();
        Cursor query = this.zzbr.query("trackedQueries", new String[]{"id", "path", "queryParams", "lastUse", "complete", "active"}, (String) null, (String[]) null, (String) null, (String) null, "id");
        ArrayList arrayList = new ArrayList();
        while (query.moveToNext()) {
            try {
                arrayList.add(new zzgb(query.getLong(0), new zzhh(new zzch(query.getString(1)), zzhe.zzh(zzke.zzv(query.getString(2)))), query.getLong(3), query.getInt(4) != 0, query.getInt(5) != 0));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
        query.close();
        return arrayList;
    }

    public final void zzm() {
        zzn();
        long currentTimeMillis = System.currentTimeMillis();
        int delete = this.zzbr.delete("writes", (String) null, (String[]) null);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (this.zzbs.zzfa()) {
            this.zzbs.zza(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(delete), Long.valueOf(currentTimeMillis2)}), (Throwable) null, new Object[0]);
        }
    }
}
