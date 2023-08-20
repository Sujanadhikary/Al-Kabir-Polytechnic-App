package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.zzh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzck implements zzak {
    private final zzdn zzag;
    /* access modifiers changed from: private */
    public zzaj zzfs;
    /* access modifiers changed from: private */
    public final zzkm zzhu = new zzkm(new zzkg(), 0);
    /* access modifiers changed from: private */
    public zzdx zzhv;
    /* access modifiers changed from: private */
    public zzdy zzhw;
    /* access modifiers changed from: private */
    public zzgp<List<zzdl>> zzhx;
    private boolean zzhy = false;
    private final zzhc zzhz;
    private final zzbz zzia;
    /* access modifiers changed from: private */
    public final zzhz zzib;
    private final zzhz zzic;
    private final zzhz zzid;
    private long zzie = 0;
    private long zzif = 1;
    /* access modifiers changed from: private */
    public zzee zzig;
    /* access modifiers changed from: private */
    public zzee zzih;
    private FirebaseDatabase zzii;
    private boolean zzij = false;
    private long zzik = 0;

    zzck(zzdn zzdn, zzbz zzbz, FirebaseDatabase firebaseDatabase) {
        this.zzag = zzdn;
        this.zzia = zzbz;
        this.zzii = firebaseDatabase;
        this.zzib = this.zzia.zzp("RepoOperation");
        this.zzic = this.zzia.zzp("Transaction");
        this.zzid = this.zzia.zzp("DataOperation");
        this.zzhz = new zzhc(this.zzia);
        zzc((Runnable) new zzcl(this));
    }

    private final zzja zza(zzch zzch, List<Long> list) {
        zzja zzc = this.zzih.zzc(zzch, list);
        return zzc == null ? zzir.zzfv() : zzc;
    }

    /* access modifiers changed from: private */
    public final void zza(long j, zzch zzch, DatabaseError databaseError) {
        if (databaseError == null || databaseError.getCode() != -25) {
            List<? extends zzgy> zza = this.zzih.zza(j, !(databaseError == null), true, (zzkf) this.zzhu);
            if (zza.size() > 0) {
                zzn(zzch);
            }
            zzc(zza);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzgp<List<zzdl>> zzgp) {
        Boolean bool;
        if (zzgp.getValue() != null) {
            List<zzdl> zzc = zzc(zzgp);
            Iterator<zzdl> it = zzc.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().zzjl != zzdm.zzju) {
                        bool = false;
                        break;
                    }
                } else {
                    bool = true;
                    break;
                }
            }
            if (bool.booleanValue()) {
                zzch zzg = zzgp.zzg();
                ArrayList arrayList = new ArrayList();
                for (zzdl zzb : zzc) {
                    arrayList.add(Long.valueOf(zzb.zzjp));
                }
                zzja zza = zza(zzg, (List<Long>) arrayList);
                String zzfj = zza.zzfj();
                Iterator<zzdl> it2 = zzc.iterator();
                while (true) {
                    zzja zzja = zza;
                    if (it2.hasNext()) {
                        zzdl next = it2.next();
                        int unused = next.zzjl = zzdm.zzjv;
                        zzdl.zzd(next);
                        zza = zzja.zzl(zzch.zza(zzg, next.zzap), next.zzjr);
                    } else {
                        this.zzfs.zza(zzg.zzbv(), zzja.getValue(true), zzfj, new zzcs(this, zzg, zzc, this));
                        return;
                    }
                }
            }
        } else if (zzgp.hasChildren()) {
            zzgp.zza(new zzcr(this));
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzgp<List<zzdl>> zzgp, int i) {
        DatabaseError zza;
        int i2;
        List value = zzgp.getValue();
        ArrayList arrayList = new ArrayList();
        if (value != null) {
            ArrayList arrayList2 = new ArrayList();
            if (i == -9) {
                zza = DatabaseError.zza("overriddenBySet");
            } else {
                zzkq.zza(i == -25, new StringBuilder(45).append("Unknown transaction abort reason: ").append(i).toString());
                zza = DatabaseError.zza(-25);
            }
            int i3 = -1;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                i2 = i3;
                if (i5 >= value.size()) {
                    break;
                }
                zzdl zzdl = (zzdl) value.get(i5);
                if (zzdl.zzjl != zzdm.zzjx) {
                    if (zzdl.zzjl == zzdm.zzjv) {
                        int unused = zzdl.zzjl = zzdm.zzjx;
                        DatabaseError unused2 = zzdl.zzjo = zza;
                        i3 = i5;
                        i4 = i5 + 1;
                    } else {
                        zze((zzce) new zzfc(this, zzdl.zzjk, zzhh.zzal(zzdl.zzap)));
                        if (i == -9) {
                            arrayList.addAll(this.zzih.zza(zzdl.zzjp, true, false, (zzkf) this.zzhu));
                        } else {
                            zzkq.zza(i == -25, new StringBuilder(45).append("Unknown transaction abort reason: ").append(i).toString());
                        }
                        arrayList2.add(new zzdb(this, zzdl, zza));
                    }
                }
                i3 = i2;
                i4 = i5 + 1;
            }
            if (i2 == -1) {
                zzgp.setValue(null);
            } else {
                zzgp.setValue(value.subList(0, i2 + 1));
            }
            zzc((List<? extends zzgy>) arrayList);
            ArrayList arrayList3 = arrayList2;
            int size = arrayList3.size();
            int i6 = 0;
            while (i6 < size) {
                Object obj = arrayList3.get(i6);
                i6++;
                zza((Runnable) obj);
            }
        }
    }

    private final void zza(zzid zzid2, Object obj) {
        if (zzid2.equals(zzby.zzhc)) {
            this.zzhu.zzn(((Long) obj).longValue());
        }
        zzch zzch = new zzch(zzby.zzhb, zzid2);
        try {
            zzja zza = zzjd.zza(obj, zzir.zzfv());
            this.zzhv.zzg(zzch, zza);
            zzc(this.zzig.zzi(zzch, zza));
        } catch (DatabaseException e) {
            this.zzib.zza("Failed to parse info update", (Throwable) e);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(String str, zzch zzch, DatabaseError databaseError) {
        if (databaseError != null && databaseError.getCode() != -1 && databaseError.getCode() != -25) {
            zzhz zzhz2 = this.zzib;
            String zzch2 = zzch.toString();
            String databaseError2 = databaseError.toString();
            zzhz2.zzb(new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(zzch2).length() + String.valueOf(databaseError2).length()).append(str).append(" at ").append(zzch2).append(" failed: ").append(databaseError2).toString(), (Throwable) null);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(List<zzdl> list, zzgp<List<zzdl>> zzgp) {
        List value = zzgp.getValue();
        if (value != null) {
            list.addAll(value);
        }
        zzgp.zza(new zzcy(this, list));
    }

    /* access modifiers changed from: private */
    public final zzch zzb(zzch zzch, int i) {
        zzch zzg = zzo(zzch).zzg();
        if (this.zzic.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            String valueOf2 = String.valueOf(zzg);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 44 + String.valueOf(valueOf2).length()).append("Aborting transactions for path: ").append(valueOf).append(". Affected: ").append(valueOf2).toString(), (Throwable) null, new Object[0]);
        }
        zzgp<List<zzdl>> zzaj = this.zzhx.zzaj(zzch);
        zzaj.zza(new zzcz(this, i), false);
        zza(zzaj, i);
        zzaj.zza(new zzda(this, i), false, false);
        return zzg;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzgp<List<zzdl>> zzgp) {
        List value = zzgp.getValue();
        if (value != null) {
            int i = 0;
            while (i < value.size()) {
                if (((zzdl) value.get(i)).zzjl == zzdm.zzjw) {
                    value.remove(i);
                } else {
                    i++;
                }
            }
            if (value.size() > 0) {
                zzgp.setValue(value);
            } else {
                zzgp.setValue(null);
            }
        }
        zzgp.zza(new zzcu(this));
    }

    /* access modifiers changed from: private */
    public static DatabaseError zzc(String str, String str2) {
        if (str != null) {
            return DatabaseError.zza(str, str2);
        }
        return null;
    }

    private final List<zzdl> zzc(zzgp<List<zzdl>> zzgp) {
        ArrayList arrayList = new ArrayList();
        zza((List<zzdl>) arrayList, zzgp);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void zzc(List<? extends zzgy> list) {
        if (!list.isEmpty()) {
            this.zzhz.zze(list);
        }
    }

    /* access modifiers changed from: private */
    public final void zzca() {
        this.zzfs = this.zzia.zza(new zzah(this.zzag.zzct, this.zzag.zzcu, this.zzag.zzcv), this);
        this.zzia.zzhg.zza(new zzcx(this));
        this.zzfs.initialize();
        zzfv zzq = this.zzia.zzq(this.zzag.zzct);
        this.zzhv = new zzdx();
        this.zzhw = new zzdy();
        this.zzhx = new zzgp<>();
        this.zzig = new zzee(this.zzia, new zzfu(), new zzdc(this));
        this.zzih = new zzee(this.zzia, zzq, new zzde(this));
        List<zzfa> zzj = zzq.zzj();
        Map<String, Object> zza = zzdu.zza(this.zzhu);
        long j = Long.MIN_VALUE;
        for (zzfa next : zzj) {
            zzdg zzdg = new zzdg(this, next);
            if (j >= next.zzcn()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            long zzcn = next.zzcn();
            this.zzif = next.zzcn() + 1;
            if (next.zzcq()) {
                if (this.zzib.zzfa()) {
                    this.zzib.zza(new StringBuilder(48).append("Restoring overwrite with id ").append(next.zzcn()).toString(), (Throwable) null, new Object[0]);
                }
                this.zzfs.zza(next.zzg().zzbv(), next.zzco().getValue(true), (zzbb) zzdg);
                this.zzih.zza(next.zzg(), next.zzco(), zzdu.zza(next.zzco(), zza), next.zzcn(), true, false);
                j = zzcn;
            } else {
                if (this.zzib.zzfa()) {
                    this.zzib.zza(new StringBuilder(44).append("Restoring merge with id ").append(next.zzcn()).toString(), (Throwable) null, new Object[0]);
                }
                this.zzfs.zza(next.zzg().zzbv(), next.zzcp().zzd(true), (zzbb) zzdg);
                this.zzih.zza(next.zzg(), next.zzcp(), zzdu.zza(next.zzcp(), zza), next.zzcn(), false);
                j = zzcn;
            }
        }
        zza(zzby.zzhd, (Object) false);
        zza(zzby.zzhe, (Object) false);
    }

    private final long zzce() {
        long j = this.zzif;
        this.zzif = 1 + j;
        return j;
    }

    /* access modifiers changed from: private */
    public final void zzcf() {
        zzgp<List<zzdl>> zzgp = this.zzhx;
        zzb(zzgp);
        zza(zzgp);
    }

    /* access modifiers changed from: private */
    public final zzch zzn(zzch zzch) {
        DatabaseError databaseError;
        boolean z;
        Transaction.Result abort;
        zzgp<List<zzdl>> zzo = zzo(zzch);
        zzch zzg = zzo.zzg();
        List<zzdl> zzc = zzc(zzo);
        if (!zzc.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (zzdl zzb : zzc) {
                arrayList2.add(Long.valueOf(zzb.zzjp));
            }
            for (zzdl next : zzc) {
                zzch.zza(zzg, next.zzap);
                ArrayList arrayList3 = new ArrayList();
                if (next.zzjl == zzdm.zzjy) {
                    z = true;
                    databaseError = next.zzjo;
                    if (databaseError.getCode() != -25) {
                        arrayList3.addAll(this.zzih.zza(next.zzjp, true, false, (zzkf) this.zzhu));
                    }
                } else if (next.zzjl != zzdm.zzju) {
                    databaseError = null;
                    z = false;
                } else if (next.retryCount >= 25) {
                    z = true;
                    databaseError = DatabaseError.zza("maxretries");
                    arrayList3.addAll(this.zzih.zza(next.zzjp, true, false, (zzkf) this.zzhu));
                } else {
                    zzja zza = zza(next.zzap, (List<Long>) arrayList2);
                    zzja unused = next.zzjq = zza;
                    try {
                        abort = next.zzjj.doTransaction(zzh.zza(zza));
                        databaseError = null;
                    } catch (Throwable th) {
                        DatabaseError fromException = DatabaseError.fromException(th);
                        abort = Transaction.abort();
                        databaseError = fromException;
                    }
                    if (abort.isSuccess()) {
                        Long valueOf = Long.valueOf(next.zzjp);
                        Map<String, Object> zza2 = zzdu.zza(this.zzhu);
                        zzja zzd = abort.zzd();
                        zzja zza3 = zzdu.zza(zzd, zza2);
                        zzja unused2 = next.zzjr = zzd;
                        zzja unused3 = next.zzjs = zza3;
                        long unused4 = next.zzjp = zzce();
                        arrayList2.remove(valueOf);
                        arrayList3.addAll(this.zzih.zza(next.zzap, zzd, zza3, next.zzjp, next.zzjn, false));
                        arrayList3.addAll(this.zzih.zza(valueOf.longValue(), true, false, (zzkf) this.zzhu));
                        databaseError = null;
                        z = false;
                    } else {
                        z = true;
                        arrayList3.addAll(this.zzih.zza(next.zzjp, true, false, (zzkf) this.zzhu));
                    }
                }
                zzc((List<? extends zzgy>) arrayList3);
                if (z) {
                    int unused5 = next.zzjl = zzdm.zzjw;
                    DataSnapshot zza4 = zzh.zza(zzh.zza(this, next.zzap), zzit.zzj(next.zzjq));
                    zzc((Runnable) new zzcv(this, next));
                    arrayList.add(new zzcw(this, next, databaseError, zza4));
                }
            }
            zzb(this.zzhx);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                zza((Runnable) arrayList.get(i2));
                i = i2 + 1;
            }
            zzcf();
        }
        return zzg;
    }

    private final zzgp<List<zzdl>> zzo(zzch zzch) {
        zzgp<List<zzdl>> zzgp = this.zzhx;
        while (!zzch.isEmpty() && zzgp.getValue() == null) {
            zzgp = zzgp.zzaj(new zzch(zzch.zzbw()));
            zzch = zzch.zzbx();
        }
        return zzgp;
    }

    public final FirebaseDatabase getDatabase() {
        return this.zzii;
    }

    /* access modifiers changed from: package-private */
    public final void interrupt() {
        this.zzfs.interrupt("repo_interrupt");
    }

    public final void onDisconnect() {
        zza(zzby.zzhe, (Object) false);
        Map<String, Object> zza = zzdu.zza(this.zzhu);
        zzdy zzdy = this.zzhw;
        zzdy zzdy2 = new zzdy();
        zzdy.zza(new zzch(""), new zzdv(zzdy2, zza));
        ArrayList arrayList = new ArrayList();
        zzdy2.zza(zzch.zzbt(), new zzco(this, arrayList));
        this.zzhw = new zzdy();
        zzc((List<? extends zzgy>) arrayList);
    }

    public final void purgeOutstandingWrites() {
        if (this.zzib.zzfa()) {
            this.zzib.zza("Purging writes", (Throwable) null, new Object[0]);
        }
        zzc(this.zzih.zzck());
        zzb(zzch.zzbt(), -25);
        this.zzfs.purgeOutstandingWrites();
    }

    /* access modifiers changed from: package-private */
    public final void resume() {
        this.zzfs.resume("repo_interrupt");
    }

    public final String toString() {
        return this.zzag.toString();
    }

    public final void zza(zzch zzch, zzbv zzbv, DatabaseReference.CompletionListener completionListener, Map<String, Object> map) {
        if (this.zzib.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 8).append("update: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzid.zzfa()) {
            zzhz zzhz3 = this.zzid;
            String valueOf2 = String.valueOf(zzch);
            String valueOf3 = String.valueOf(map);
            zzhz3.zza(new StringBuilder(String.valueOf(valueOf2).length() + 9 + String.valueOf(valueOf3).length()).append("update: ").append(valueOf2).append(" ").append(valueOf3).toString(), (Throwable) null, new Object[0]);
        }
        if (zzbv.isEmpty()) {
            if (this.zzib.zzfa()) {
                this.zzib.zza("update called with no changes. No-op", (Throwable) null, new Object[0]);
            }
            zza(completionListener, (DatabaseError) null, zzch);
            return;
        }
        zzbv zza = zzdu.zza(zzbv, zzdu.zza(this.zzhu));
        long zzce = zzce();
        zzc(this.zzih.zza(zzch, zzbv, zza, zzce, true));
        this.zzfs.zza(zzch.zzbv(), map, (zzbb) new zzdj(this, zzch, zzce, completionListener));
        Iterator<Map.Entry<zzch, zzja>> it = zzbv.iterator();
        while (it.hasNext()) {
            zzn(zzb(zzch.zzh((zzch) it.next().getKey()), -9));
        }
    }

    public final void zza(zzch zzch, zzja zzja, DatabaseReference.CompletionListener completionListener) {
        if (this.zzib.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 5).append("set: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzid.zzfa()) {
            zzhz zzhz3 = this.zzid;
            String valueOf2 = String.valueOf(zzch);
            String valueOf3 = String.valueOf(zzja);
            zzhz3.zza(new StringBuilder(String.valueOf(valueOf2).length() + 6 + String.valueOf(valueOf3).length()).append("set: ").append(valueOf2).append(" ").append(valueOf3).toString(), (Throwable) null, new Object[0]);
        }
        zzja zza = zzdu.zza(zzja, zzdu.zza(this.zzhu));
        long zzce = zzce();
        zzc(this.zzih.zza(zzch, zzja, zza, zzce, true, true));
        this.zzfs.zza(zzch.zzbv(), zzja.getValue(true), (zzbb) new zzdi(this, zzch, zzce, completionListener));
        zzn(zzb(zzch, -9));
    }

    public final void zza(zzch zzch, DatabaseReference.CompletionListener completionListener) {
        this.zzfs.zza(zzch.zzbv(), (zzbb) new zzcn(this, zzch, completionListener));
    }

    public final void zza(zzch zzch, Transaction.Handler handler, boolean z) {
        Transaction.Result result;
        DatabaseError databaseError;
        if (this.zzib.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 13).append("transaction: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzid.zzfa()) {
            zzhz zzhz3 = this.zzib;
            String valueOf2 = String.valueOf(zzch);
            zzhz3.zza(new StringBuilder(String.valueOf(valueOf2).length() + 13).append("transaction: ").append(valueOf2).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzia.zzcp && !this.zzij) {
            this.zzij = true;
            this.zzic.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference zza = zzh.zza(this, zzch);
        zzcp zzcp = new zzcp(this);
        zzf((zzce) new zzfc(this, zzcp, zza.zzh()));
        int i = zzdm.zzjt;
        long j = this.zzik;
        this.zzik = 1 + j;
        zzdl zzdl = new zzdl(zzch, handler, zzcp, i, z, j, (zzcl) null);
        zzja zza2 = zza(zzch, (List<Long>) new ArrayList());
        zzja unused = zzdl.zzjq = zza2;
        try {
            Transaction.Result doTransaction = handler.doTransaction(zzh.zza(zza2));
            if (doTransaction == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
            Transaction.Result result2 = doTransaction;
            databaseError = null;
            result = result2;
            if (!result.isSuccess()) {
                zzja unused2 = zzdl.zzjr = null;
                zzja unused3 = zzdl.zzjs = null;
                zza((Runnable) new zzcq(this, handler, databaseError, zzh.zza(zza, zzit.zzj(zzdl.zzjq))));
                return;
            }
            int unused4 = zzdl.zzjl = zzdm.zzju;
            zzgp<List<zzdl>> zzaj = this.zzhx.zzaj(zzch);
            List value = zzaj.getValue();
            if (value == null) {
                value = new ArrayList();
            }
            value.add(zzdl);
            zzaj.setValue(value);
            Map<String, Object> zza3 = zzdu.zza(this.zzhu);
            zzja zzd = result.zzd();
            zzja zza4 = zzdu.zza(zzd, zza3);
            zzja unused5 = zzdl.zzjr = zzd;
            zzja unused6 = zzdl.zzjs = zza4;
            long unused7 = zzdl.zzjp = zzce();
            zzc(this.zzih.zza(zzch, zzd, zza4, zzdl.zzjp, z, false));
            zzcf();
        } catch (Throwable th) {
            databaseError = DatabaseError.fromException(th);
            result = Transaction.abort();
        }
    }

    public final void zza(zzch zzch, Map<zzch, zzja> map, DatabaseReference.CompletionListener completionListener, Map<String, Object> map2) {
        this.zzfs.zzb(zzch.zzbv(), map2, (zzbb) new zzcm(this, zzch, map, completionListener));
    }

    public final void zza(zzhh zzhh, boolean z) {
        this.zzih.zza(zzhh, z);
    }

    /* access modifiers changed from: package-private */
    public final void zza(DatabaseReference.CompletionListener completionListener, DatabaseError databaseError, zzch zzch) {
        if (completionListener != null) {
            zzid zzbz = zzch.zzbz();
            zza((Runnable) new zzdh(this, completionListener, databaseError, (zzbz == null || !zzbz.zzfh()) ? zzh.zza(this, zzch) : zzh.zza(this, zzch.zzby())));
        }
    }

    public final void zza(Runnable runnable) {
        this.zzia.zzbl();
        this.zzia.zzhf.zza(runnable);
    }

    public final void zza(List<String> list, Object obj, boolean z, Long l) {
        List<? extends zzgy> zzi;
        zzch zzch = new zzch(list);
        if (this.zzib.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 14).append("onDataUpdate: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzid.zzfa()) {
            zzhz zzhz3 = this.zzib;
            String valueOf2 = String.valueOf(zzch);
            String valueOf3 = String.valueOf(obj);
            zzhz3.zza(new StringBuilder(String.valueOf(valueOf2).length() + 15 + String.valueOf(valueOf3).length()).append("onDataUpdate: ").append(valueOf2).append(" ").append(valueOf3).toString(), (Throwable) null, new Object[0]);
        }
        this.zzie++;
        if (l != null) {
            try {
                zzex zzex = new zzex(l.longValue());
                if (z) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        hashMap.put(new zzch((String) entry.getKey()), zzjd.zza(entry.getValue(), zzir.zzfv()));
                    }
                    zzi = this.zzih.zza(zzch, (Map<zzch, zzja>) hashMap, zzex);
                } else {
                    zzi = this.zzih.zza(zzch, zzjd.zza(obj, zzir.zzfv()), zzex);
                }
            } catch (DatabaseException e) {
                this.zzib.zza("FIREBASE INTERNAL ERROR", (Throwable) e);
                return;
            }
        } else if (z) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry entry2 : ((Map) obj).entrySet()) {
                hashMap2.put(new zzch((String) entry2.getKey()), zzjd.zza(entry2.getValue(), zzir.zzfv()));
            }
            zzi = this.zzih.zza(zzch, (Map<zzch, zzja>) hashMap2);
        } else {
            zzi = this.zzih.zzi(zzch, zzjd.zza(obj, zzir.zzfv()));
        }
        if (zzi.size() > 0) {
            zzn(zzch);
        }
        zzc(zzi);
    }

    public final void zza(List<String> list, List<zzba> list2, Long l) {
        zzch zzch = new zzch(list);
        if (this.zzib.zzfa()) {
            zzhz zzhz2 = this.zzib;
            String valueOf = String.valueOf(zzch);
            zzhz2.zza(new StringBuilder(String.valueOf(valueOf).length() + 20).append("onRangeMergeUpdate: ").append(valueOf).toString(), (Throwable) null, new Object[0]);
        }
        if (this.zzid.zzfa()) {
            zzhz zzhz3 = this.zzib;
            String valueOf2 = String.valueOf(zzch);
            String valueOf3 = String.valueOf(list2);
            zzhz3.zza(new StringBuilder(String.valueOf(valueOf2).length() + 21 + String.valueOf(valueOf3).length()).append("onRangeMergeUpdate: ").append(valueOf2).append(" ").append(valueOf3).toString(), (Throwable) null, new Object[0]);
        }
        this.zzie++;
        ArrayList arrayList = new ArrayList(list2.size());
        for (zzba zzjh : list2) {
            arrayList.add(new zzjh(zzjh));
        }
        List<? extends zzgy> zza = l != null ? this.zzih.zza(zzch, (List<zzjh>) arrayList, new zzex(l.longValue())) : this.zzih.zzb(zzch, (List<zzjh>) arrayList);
        if (zza.size() > 0) {
            zzn(zzch);
        }
        zzc(zza);
    }

    public final void zzaa() {
        zza(zzby.zzhe, (Object) true);
    }

    public final void zzb(zzch zzch, zzja zzja, DatabaseReference.CompletionListener completionListener) {
        this.zzfs.zzb(zzch.zzbv(), zzja.getValue(true), (zzbb) new zzdk(this, zzch, zzja, completionListener));
    }

    public final void zzb(boolean z) {
        zza(zzby.zzhd, (Object) Boolean.valueOf(z));
    }

    public final void zzc(Runnable runnable) {
        this.zzia.zzbl();
        this.zzia.zzhh.zzc(runnable);
    }

    public final void zzc(Map<String, Object> map) {
        for (Map.Entry next : map.entrySet()) {
            zza(zzid.zzt((String) next.getKey()), next.getValue());
        }
    }

    public final zzdn zzcb() {
        return this.zzag;
    }

    public final long zzcc() {
        return this.zzhu.millis();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzcd() {
        return !this.zzig.isEmpty() || !this.zzih.isEmpty();
    }

    public final void zze(zzce zzce) {
        zzc((List<? extends zzgy>) zzby.zzhb.equals(zzce.zzbe().zzg().zzbw()) ? this.zzig.zzh(zzce) : this.zzih.zzh(zzce));
    }

    public final void zzf(zzce zzce) {
        zzid zzbw = zzce.zzbe().zzg().zzbw();
        zzc((zzbw == null || !zzbw.equals(zzby.zzhb)) ? this.zzih.zzg(zzce) : this.zzig.zzg(zzce));
    }
}
