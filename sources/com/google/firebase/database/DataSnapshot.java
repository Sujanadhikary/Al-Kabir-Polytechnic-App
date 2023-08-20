package com.google.firebase.database;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzit;
import com.google.android.gms.internal.firebase_database.zzks;
import com.google.android.gms.internal.firebase_database.zzkt;

public class DataSnapshot {
    private final zzit zzl;
    /* access modifiers changed from: private */
    public final DatabaseReference zzm;

    DataSnapshot(DatabaseReference databaseReference, zzit zzit) {
        this.zzl = zzit;
        this.zzm = databaseReference;
    }

    public DataSnapshot child(String str) {
        return new DataSnapshot(this.zzm.child(str), zzit.zzj(this.zzl.zzd().zzam(new zzch(str))));
    }

    public boolean exists() {
        return !this.zzl.zzd().isEmpty();
    }

    public Iterable<DataSnapshot> getChildren() {
        return new zza(this, this.zzl.iterator());
    }

    public long getChildrenCount() {
        return (long) this.zzl.zzd().getChildCount();
    }

    public String getKey() {
        return this.zzm.getKey();
    }

    public Object getPriority() {
        Object value = this.zzl.zzd().zzfl().getValue();
        return value instanceof Long ? Double.valueOf((double) ((Long) value).longValue()) : value;
    }

    public DatabaseReference getRef() {
        return this.zzm;
    }

    @Nullable
    public Object getValue() {
        return this.zzl.zzd().getValue();
    }

    @Nullable
    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzkt.zza(this.zzl.zzd().getValue(), genericTypeIndicator);
    }

    @Nullable
    public <T> T getValue(Class<T> cls) {
        return zzkt.zza(this.zzl.zzd().getValue(), cls);
    }

    @Nullable
    public Object getValue(boolean z) {
        return this.zzl.zzd().getValue(z);
    }

    public boolean hasChild(String str) {
        if (this.zzm.getParent() == null) {
            zzks.zzac(str);
        } else {
            zzks.zzab(str);
        }
        return !this.zzl.zzd().zzam(new zzch(str)).isEmpty();
    }

    public boolean hasChildren() {
        return this.zzl.zzd().getChildCount() > 0;
    }

    public String toString() {
        String key = this.zzm.getKey();
        String valueOf = String.valueOf(this.zzl.zzd().getValue(true));
        return new StringBuilder(String.valueOf(key).length() + 33 + String.valueOf(valueOf).length()).append("DataSnapshot { key = ").append(key).append(", value = ").append(valueOf).append(" }").toString();
    }
}
