package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.zzh;

public final class zzbt extends zzce {
    private final zzck zzai;
    private final ChildEventListener zzgt;
    private final zzhh zzgu;

    public zzbt(zzck zzck, ChildEventListener childEventListener, zzhh zzhh) {
        this.zzai = zzck;
        this.zzgt = childEventListener;
        this.zzgu = zzhh;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzbt) && ((zzbt) obj).zzgt.equals(this.zzgt) && ((zzbt) obj).zzai.equals(this.zzai) && ((zzbt) obj).zzgu.equals(this.zzgu);
    }

    public final int hashCode() {
        return (((this.zzgt.hashCode() * 31) + this.zzai.hashCode()) * 31) + this.zzgu.hashCode();
    }

    public final String toString() {
        return "ChildEventRegistration";
    }

    public final zzce zza(zzhh zzhh) {
        return new zzbt(this.zzai, this.zzgt, zzhh);
    }

    public final zzgx zza(zzgw zzgw, zzhh zzhh) {
        return new zzgx(zzgw.zzdt(), this, zzh.zza(zzh.zza(this.zzai, zzhh.zzg().zza(zzgw.zzds())), zzgw.zzdq()), zzgw.zzdu() != null ? zzgw.zzdu().zzfg() : null);
    }

    public final void zza(zzgx zzgx) {
        if (!zzbs()) {
            switch (zzgx.zzdt()) {
                case CHILD_ADDED:
                    this.zzgt.onChildAdded(zzgx.zzdw(), zzgx.zzdx());
                    return;
                case CHILD_CHANGED:
                    this.zzgt.onChildChanged(zzgx.zzdw(), zzgx.zzdx());
                    return;
                case CHILD_MOVED:
                    this.zzgt.onChildMoved(zzgx.zzdw(), zzgx.zzdx());
                    return;
                case CHILD_REMOVED:
                    this.zzgt.onChildRemoved(zzgx.zzdw());
                    return;
                default:
                    return;
            }
        }
    }

    public final void zza(DatabaseError databaseError) {
        this.zzgt.onCancelled(databaseError);
    }

    public final boolean zza(zzgz zzgz) {
        return zzgz != zzgz.VALUE;
    }

    public final zzhh zzbe() {
        return this.zzgu;
    }

    public final boolean zzc(zzce zzce) {
        return (zzce instanceof zzbt) && ((zzbt) zzce).zzgt.equals(this.zzgt);
    }
}
