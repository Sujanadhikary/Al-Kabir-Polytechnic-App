package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

final class zzdl implements Comparable<zzdl> {
    /* access modifiers changed from: private */
    public int retryCount;
    /* access modifiers changed from: private */
    public zzch zzap;
    /* access modifiers changed from: private */
    public Transaction.Handler zzjj;
    /* access modifiers changed from: private */
    public ValueEventListener zzjk;
    /* access modifiers changed from: private */
    public int zzjl;
    private long zzjm;
    /* access modifiers changed from: private */
    public boolean zzjn;
    /* access modifiers changed from: private */
    public DatabaseError zzjo;
    /* access modifiers changed from: private */
    public long zzjp;
    /* access modifiers changed from: private */
    public zzja zzjq;
    /* access modifiers changed from: private */
    public zzja zzjr;
    /* access modifiers changed from: private */
    public zzja zzjs;

    private zzdl(zzch zzch, Transaction.Handler handler, ValueEventListener valueEventListener, int i, boolean z, long j) {
        this.zzap = zzch;
        this.zzjj = handler;
        this.zzjk = valueEventListener;
        this.zzjl = i;
        this.retryCount = 0;
        this.zzjn = z;
        this.zzjm = j;
        this.zzjo = null;
        this.zzjq = null;
        this.zzjr = null;
        this.zzjs = null;
    }

    /* synthetic */ zzdl(zzch zzch, Transaction.Handler handler, ValueEventListener valueEventListener, int i, boolean z, long j, zzcl zzcl) {
        this(zzch, handler, valueEventListener, i, z, j);
    }

    static /* synthetic */ int zzd(zzdl zzdl) {
        int i = zzdl.retryCount;
        zzdl.retryCount = i + 1;
        return i;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        zzdl zzdl = (zzdl) obj;
        if (this.zzjm < zzdl.zzjm) {
            return -1;
        }
        return this.zzjm == zzdl.zzjm ? 0 : 1;
    }
}
