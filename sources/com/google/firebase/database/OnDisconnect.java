package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzck;
import com.google.android.gms.internal.firebase_database.zzfb;
import com.google.android.gms.internal.firebase_database.zzir;
import com.google.android.gms.internal.firebase_database.zzja;
import com.google.android.gms.internal.firebase_database.zzjd;
import com.google.android.gms.internal.firebase_database.zzjg;
import com.google.android.gms.internal.firebase_database.zzkn;
import com.google.android.gms.internal.firebase_database.zzkq;
import com.google.android.gms.internal.firebase_database.zzks;
import com.google.android.gms.internal.firebase_database.zzkt;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import java.util.Map;

public class OnDisconnect {
    /* access modifiers changed from: private */
    public zzck zzai;
    /* access modifiers changed from: private */
    public zzch zzap;

    OnDisconnect(zzck zzck, zzch zzch) {
        this.zzai = zzck;
        this.zzap = zzch;
    }

    private final Task<Void> zza(DatabaseReference.CompletionListener completionListener) {
        zzkn<Task<Void>, DatabaseReference.CompletionListener> zzb = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zzo(this, zzb));
        return zzb.getFirst();
    }

    private final Task<Void> zza(Map<String, Object> map, DatabaseReference.CompletionListener completionListener) {
        Map<zzch, zzja> zzb = zzks.zzb(this.zzap, map);
        zzkn<Task<Void>, DatabaseReference.CompletionListener> zzb2 = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zzn(this, zzb, zzb2, map));
        return zzb2.getFirst();
    }

    private final Task<Void> zzb(Object obj, zzja zzja, DatabaseReference.CompletionListener completionListener) {
        zzks.zzan(this.zzap);
        zzfb.zza(this.zzap, obj);
        Object zzh = zzkt.zzh(obj);
        zzks.zzg(zzh);
        zzja zza = zzjd.zza(zzh, zzja);
        zzkn<Task<Void>, DatabaseReference.CompletionListener> zzb = zzkq.zzb(completionListener);
        this.zzai.zzc((Runnable) new zzm(this, zza, zzb));
        return zzb.getFirst();
    }

    public Task<Void> cancel() {
        return zza((DatabaseReference.CompletionListener) null);
    }

    public void cancel(DatabaseReference.CompletionListener completionListener) {
        zza(completionListener);
    }

    public Task<Void> removeValue() {
        return setValue((Object) null);
    }

    public void removeValue(DatabaseReference.CompletionListener completionListener) {
        setValue((Object) null, completionListener);
    }

    public Task<Void> setValue(Object obj) {
        return zzb(obj, zzir.zzfv(), (DatabaseReference.CompletionListener) null);
    }

    public Task<Void> setValue(Object obj, double d) {
        return zzb(obj, zzjg.zzc(this.zzap, Double.valueOf(d)), (DatabaseReference.CompletionListener) null);
    }

    public Task<Void> setValue(Object obj, String str) {
        return zzb(obj, zzjg.zzc(this.zzap, str), (DatabaseReference.CompletionListener) null);
    }

    public void setValue(Object obj, double d, DatabaseReference.CompletionListener completionListener) {
        zzb(obj, zzjg.zzc(this.zzap, Double.valueOf(d)), completionListener);
    }

    public void setValue(Object obj, DatabaseReference.CompletionListener completionListener) {
        zzb(obj, zzir.zzfv(), completionListener);
    }

    public void setValue(Object obj, String str, DatabaseReference.CompletionListener completionListener) {
        zzb(obj, zzjg.zzc(this.zzap, str), completionListener);
    }

    public void setValue(Object obj, Map map, DatabaseReference.CompletionListener completionListener) {
        zzb(obj, zzjg.zzc(this.zzap, map), completionListener);
    }

    public Task<Void> updateChildren(Map<String, Object> map) {
        return zza(map, (DatabaseReference.CompletionListener) null);
    }

    public void updateChildren(Map<String, Object> map, DatabaseReference.CompletionListener completionListener) {
        zza(map, completionListener);
    }
}
