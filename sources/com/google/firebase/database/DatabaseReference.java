package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zzbv;
import com.google.android.gms.internal.firebase_database.zzcc;
import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzck;
import com.google.android.gms.internal.firebase_database.zzdo;
import com.google.android.gms.internal.firebase_database.zzfb;
import com.google.android.gms.internal.firebase_database.zzid;
import com.google.android.gms.internal.firebase_database.zzja;
import com.google.android.gms.internal.firebase_database.zzjd;
import com.google.android.gms.internal.firebase_database.zzjg;
import com.google.android.gms.internal.firebase_database.zzkn;
import com.google.android.gms.internal.firebase_database.zzkp;
import com.google.android.gms.internal.firebase_database.zzkq;
import com.google.android.gms.internal.firebase_database.zzks;
import com.google.android.gms.internal.firebase_database.zzkt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.Transaction;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class DatabaseReference extends Query {
    private static zzcc zzv;

    public interface CompletionListener {
        void onComplete(DatabaseError databaseError, DatabaseReference databaseReference);
    }

    DatabaseReference(zzck zzck, zzch zzch) {
        super(zzck, zzch);
    }

    public static void goOffline() {
        zzdo.zzd(zzb());
    }

    public static void goOnline() {
        zzdo.zze(zzb());
    }

    private final Task<Void> zza(zzja zzja, CompletionListener completionListener) {
        zzks.zzan(this.zzap);
        zzkn<Task<Void>, CompletionListener> zzb = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zzd(this, zzja, zzb));
        return zzb.getFirst();
    }

    private final Task<Void> zza(Object obj, zzja zzja, CompletionListener completionListener) {
        zzks.zzan(this.zzap);
        zzfb.zza(this.zzap, obj);
        Object zzh = zzkt.zzh(obj);
        zzks.zzg(zzh);
        zzja zza = zzjd.zza(zzh, zzja);
        zzkn<Task<Void>, CompletionListener> zzb = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zzc(this, zza, zzb));
        return zzb.getFirst();
    }

    private final Task<Void> zza(Map<String, Object> map, CompletionListener completionListener) {
        if (map == null) {
            throw new NullPointerException("Can't pass null for argument 'update' in updateChildren()");
        }
        Map<String, Object> zzi = zzkt.zzi(map);
        zzbv zzg = zzbv.zzg(zzks.zzb(this.zzap, zzi));
        zzkn<Task<Void>, CompletionListener> zzb = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zze(this, zzg, zzb, zzi));
        return zzb.getFirst();
    }

    private static synchronized zzcc zzb() {
        zzcc zzcc;
        synchronized (DatabaseReference.class) {
            if (zzv == null) {
                zzv = new zzcc();
            }
            zzcc = zzv;
        }
        return zzcc;
    }

    public DatabaseReference child(String str) {
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in child()");
        }
        if (this.zzap.isEmpty()) {
            zzks.zzac(str);
        } else {
            zzks.zzab(str);
        }
        return new DatabaseReference(this.zzai, this.zzap.zzh(new zzch(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof DatabaseReference) && toString().equals(obj.toString());
    }

    public FirebaseDatabase getDatabase() {
        return this.zzai.getDatabase();
    }

    public String getKey() {
        if (this.zzap.isEmpty()) {
            return null;
        }
        return this.zzap.zzbz().zzfg();
    }

    public DatabaseReference getParent() {
        zzch zzby = this.zzap.zzby();
        if (zzby != null) {
            return new DatabaseReference(this.zzai, zzby);
        }
        return null;
    }

    public DatabaseReference getRoot() {
        return new DatabaseReference(this.zzai, new zzch(""));
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public OnDisconnect onDisconnect() {
        zzks.zzan(this.zzap);
        return new OnDisconnect(this.zzai, this.zzap);
    }

    public DatabaseReference push() {
        return new DatabaseReference(this.zzai, this.zzap.zza(zzid.zzt(zzkp.zzo(this.zzai.zzcc()))));
    }

    public Task<Void> removeValue() {
        return setValue((Object) null);
    }

    public void removeValue(CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public void runTransaction(Transaction.Handler handler) {
        runTransaction(handler, true);
    }

    public void runTransaction(Transaction.Handler handler, boolean z) {
        if (handler == null) {
            throw new NullPointerException("Can't pass null for argument 'handler' in runTransaction()");
        }
        zzks.zzan(this.zzap);
        this.zzai.zzc((Runnable) new zzf(this, handler, z));
    }

    public Task<Void> setPriority(Object obj) {
        return zza(zzjg.zzc(this.zzap, obj), (CompletionListener) null);
    }

    public void setPriority(Object obj, CompletionListener completionListener) {
        zza(zzjg.zzc(this.zzap, obj), completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zza(obj, zzjg.zzc(this.zzap, (Object) null), (CompletionListener) null);
    }

    public Task<Void> setValue(Object obj, Object obj2) {
        return zza(obj, zzjg.zzc(this.zzap, obj2), (CompletionListener) null);
    }

    public void setValue(Object obj, CompletionListener completionListener) {
        zza(obj, zzjg.zzc(this.zzap, (Object) null), completionListener);
    }

    public void setValue(Object obj, Object obj2, CompletionListener completionListener) {
        zza(obj, zzjg.zzc(this.zzap, obj2), completionListener);
    }

    public String toString() {
        DatabaseReference parent = getParent();
        if (parent == null) {
            return this.zzai.toString();
        }
        try {
            String databaseReference = parent.toString();
            String replace = URLEncoder.encode(getKey(), "UTF-8").replace("+", "%20");
            return new StringBuilder(String.valueOf(databaseReference).length() + 1 + String.valueOf(replace).length()).append(databaseReference).append("/").append(replace).toString();
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf = String.valueOf(getKey());
            throw new DatabaseException(valueOf.length() != 0 ? "Failed to URLEncode key: ".concat(valueOf) : new String("Failed to URLEncode key: "), unsupportedEncodingException);
        }
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza(map, (CompletionListener) null);
    }

    public void updateChildren(Map<String, Object> map, CompletionListener completionListener) {
        zza(map, completionListener);
    }
}
