package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zzbt;
import com.google.android.gms.internal.firebase_database.zzce;
import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzck;
import com.google.android.gms.internal.firebase_database.zzfc;
import com.google.android.gms.internal.firebase_database.zzfh;
import com.google.android.gms.internal.firebase_database.zzhe;
import com.google.android.gms.internal.firebase_database.zzhh;
import com.google.android.gms.internal.firebase_database.zzic;
import com.google.android.gms.internal.firebase_database.zzid;
import com.google.android.gms.internal.firebase_database.zziq;
import com.google.android.gms.internal.firebase_database.zzir;
import com.google.android.gms.internal.firebase_database.zziu;
import com.google.android.gms.internal.firebase_database.zzja;
import com.google.android.gms.internal.firebase_database.zzje;
import com.google.android.gms.internal.firebase_database.zzjf;
import com.google.android.gms.internal.firebase_database.zzjg;
import com.google.android.gms.internal.firebase_database.zzji;
import com.google.android.gms.internal.firebase_database.zzjk;
import com.google.android.gms.internal.firebase_database.zzkq;
import com.google.android.gms.internal.firebase_database.zzks;

public class Query {
    protected final zzck zzai;
    protected final zzch zzap;
    private final zzhe zzat;
    private final boolean zzau;

    Query(zzck zzck, zzch zzch) {
        this.zzai = zzck;
        this.zzap = zzch;
        this.zzat = zzhe.zzpi;
        this.zzau = false;
    }

    private Query(zzck zzck, zzch zzch, zzhe zzhe, boolean z) throws DatabaseException {
        this.zzai = zzck;
        this.zzap = zzch;
        this.zzat = zzhe;
        this.zzau = z;
        zzkq.zza(!zzhe.zzdy() || !zzhe.zzeb() || !zzhe.zzee() || zzhe.zzef(), "Validation of queries failed.");
    }

    private final Query zza(zzja zzja, String str) {
        zzks.zzad(str);
        if (!zzja.zzfk() && !zzja.isEmpty()) {
            throw new IllegalArgumentException("Can only use simple values for startAt()");
        } else if (this.zzat.zzdy()) {
            throw new IllegalArgumentException("Can't call startAt() or equalTo() multiple times");
        } else {
            zzhe zza = this.zzat.zza(zzja, str != null ? zzid.zzt(str) : null);
            zzb(zza);
            zza(zza);
            return new Query(this.zzai, this.zzap, zza, this.zzau);
        }
    }

    private final void zza(zzce zzce) {
        zzfh.zzcu().zzj(zzce);
        this.zzai.zzc((Runnable) new zzq(this, zzce));
    }

    private static void zza(zzhe zzhe) {
        if (zzhe.zzeg().equals(zziu.zzgb())) {
            if (zzhe.zzdy()) {
                zzja zzdz = zzhe.zzdz();
                if (zzhe.zzea() != zzid.zzfc() || !(zzdz instanceof zzji)) {
                    throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
            if (zzhe.zzeb()) {
                zzja zzec = zzhe.zzec();
                if (zzhe.zzed() != zzid.zzfd() || !(zzec instanceof zzji)) {
                    throw new IllegalArgumentException("You must use startAt(String value), endAt(String value) or equalTo(String value) in combination with orderByKey(). Other type of values or using the version with 2 parameters is not supported");
                }
            }
        } else if (!zzhe.zzeg().equals(zzjf.zzgf())) {
        } else {
            if ((zzhe.zzdy() && !zzjg.zzl(zzhe.zzdz())) || (zzhe.zzeb() && !zzjg.zzl(zzhe.zzec()))) {
                throw new IllegalArgumentException("When using orderByPriority(), values provided to startAt(), endAt(), or equalTo() must be valid priorities.");
            }
        }
    }

    private final Query zzb(zzja zzja, String str) {
        zzks.zzad(str);
        if (zzja.zzfk() || zzja.isEmpty()) {
            zzid zzt = str != null ? zzid.zzt(str) : null;
            if (this.zzat.zzeb()) {
                throw new IllegalArgumentException("Can't call endAt() or equalTo() multiple times");
            }
            zzhe zzb = this.zzat.zzb(zzja, zzt);
            zzb(zzb);
            zza(zzb);
            return new Query(this.zzai, this.zzap, zzb, this.zzau);
        }
        throw new IllegalArgumentException("Can only use simple values for endAt()");
    }

    private final void zzb(zzce zzce) {
        zzfh.zzcu().zzi(zzce);
        this.zzai.zzc((Runnable) new zzr(this, zzce));
    }

    private static void zzb(zzhe zzhe) {
        if (zzhe.zzdy() && zzhe.zzeb() && zzhe.zzee() && !zzhe.zzef()) {
            throw new IllegalArgumentException("Can't combine startAt(), endAt() and limit(). Use limitToFirst() or limitToLast() instead");
        }
    }

    private final void zze() {
        if (this.zzat.zzdy()) {
            throw new IllegalArgumentException("Can't call equalTo() and startAt() combined");
        } else if (this.zzat.zzeb()) {
            throw new IllegalArgumentException("Can't call equalTo() and endAt() combined");
        }
    }

    private final void zzf() {
        if (this.zzau) {
            throw new IllegalArgumentException("You can't combine multiple orderBy calls!");
        }
    }

    public ChildEventListener addChildEventListener(ChildEventListener childEventListener) {
        zzb((zzce) new zzbt(this.zzai, childEventListener, zzh()));
        return childEventListener;
    }

    public void addListenerForSingleValueEvent(ValueEventListener valueEventListener) {
        zzb((zzce) new zzfc(this.zzai, new zzp(this, valueEventListener), zzh()));
    }

    public ValueEventListener addValueEventListener(ValueEventListener valueEventListener) {
        zzb((zzce) new zzfc(this.zzai, valueEventListener, zzh()));
        return valueEventListener;
    }

    public Query endAt(double d) {
        return endAt(d, (String) null);
    }

    public Query endAt(double d, String str) {
        return zzb(new zziq(Double.valueOf(d), zzir.zzfv()), str);
    }

    public Query endAt(String str) {
        return endAt(str, (String) null);
    }

    public Query endAt(String str, String str2) {
        return zzb(str != null ? new zzji(str, zzir.zzfv()) : zzir.zzfv(), str2);
    }

    public Query endAt(boolean z) {
        return endAt(z, (String) null);
    }

    public Query endAt(boolean z, String str) {
        return zzb(new zzic(Boolean.valueOf(z), zzir.zzfv()), str);
    }

    public Query equalTo(double d) {
        zze();
        return startAt(d).endAt(d);
    }

    public Query equalTo(double d, String str) {
        zze();
        return startAt(d, str).endAt(d, str);
    }

    public Query equalTo(String str) {
        zze();
        return startAt(str).endAt(str);
    }

    public Query equalTo(String str, String str2) {
        zze();
        return startAt(str, str2).endAt(str, str2);
    }

    public Query equalTo(boolean z) {
        zze();
        return startAt(z).endAt(z);
    }

    public Query equalTo(boolean z, String str) {
        zze();
        return startAt(z, str).endAt(z, str);
    }

    public DatabaseReference getRef() {
        return new DatabaseReference(this.zzai, this.zzap);
    }

    public void keepSynced(boolean z) {
        if (this.zzap.isEmpty() || !this.zzap.zzbw().equals(zzid.zzff())) {
            this.zzai.zzc((Runnable) new zzs(this, z));
            return;
        }
        throw new DatabaseException("Can't call keepSynced() on .info paths.");
    }

    public Query limitToFirst(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.zzat.zzee()) {
            return new Query(this.zzai, this.zzap, this.zzat.zzc(i), this.zzau);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query limitToLast(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Limit must be a positive integer!");
        } else if (!this.zzat.zzee()) {
            return new Query(this.zzai, this.zzap, this.zzat.zzd(i), this.zzau);
        } else {
            throw new IllegalArgumentException("Can't call limitToLast on query with previously set limit!");
        }
    }

    public Query orderByChild(String str) {
        if (str == null) {
            throw new NullPointerException("Key can't be null");
        } else if (str.equals("$key") || str.equals(".key")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 54).append("Can't use '").append(str).append("' as path, please use orderByKey() instead!").toString());
        } else if (str.equals("$priority") || str.equals(".priority")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 59).append("Can't use '").append(str).append("' as path, please use orderByPriority() instead!").toString());
        } else if (str.equals("$value") || str.equals(".value")) {
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(str).length() + 56).append("Can't use '").append(str).append("' as path, please use orderByValue() instead!").toString());
        } else {
            zzks.zzab(str);
            zzf();
            zzch zzch = new zzch(str);
            if (zzch.size() == 0) {
                throw new IllegalArgumentException("Can't use empty path, use orderByValue() instead!");
            }
            return new Query(this.zzai, this.zzap, this.zzat.zza(new zzje(zzch)), true);
        }
    }

    public Query orderByKey() {
        zzf();
        zzhe zza = this.zzat.zza(zziu.zzgb());
        zza(zza);
        return new Query(this.zzai, this.zzap, zza, true);
    }

    public Query orderByPriority() {
        zzf();
        zzhe zza = this.zzat.zza(zzjf.zzgf());
        zza(zza);
        return new Query(this.zzai, this.zzap, zza, true);
    }

    public Query orderByValue() {
        zzf();
        return new Query(this.zzai, this.zzap, this.zzat.zza(zzjk.zzgg()), true);
    }

    public void removeEventListener(ChildEventListener childEventListener) {
        if (childEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza((zzce) new zzbt(this.zzai, childEventListener, zzh()));
    }

    public void removeEventListener(ValueEventListener valueEventListener) {
        if (valueEventListener == null) {
            throw new NullPointerException("listener must not be null");
        }
        zza((zzce) new zzfc(this.zzai, valueEventListener, zzh()));
    }

    public Query startAt(double d) {
        return startAt(d, (String) null);
    }

    public Query startAt(double d, String str) {
        return zza(new zziq(Double.valueOf(d), zzir.zzfv()), str);
    }

    public Query startAt(String str) {
        return startAt(str, (String) null);
    }

    public Query startAt(String str, String str2) {
        return zza(str != null ? new zzji(str, zzir.zzfv()) : zzir.zzfv(), str2);
    }

    public Query startAt(boolean z) {
        return startAt(z, (String) null);
    }

    public Query startAt(boolean z, String str) {
        return zza(new zzic(Boolean.valueOf(z), zzir.zzfv()), str);
    }

    public final zzch zzg() {
        return this.zzap;
    }

    public final zzhh zzh() {
        return new zzhh(this.zzap, this.zzat);
    }
}
