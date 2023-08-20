package com.google.firebase.database;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzdx;
import com.google.android.gms.internal.firebase_database.zzfb;
import com.google.android.gms.internal.firebase_database.zzid;
import com.google.android.gms.internal.firebase_database.zzir;
import com.google.android.gms.internal.firebase_database.zzit;
import com.google.android.gms.internal.firebase_database.zzja;
import com.google.android.gms.internal.firebase_database.zzjd;
import com.google.android.gms.internal.firebase_database.zzjg;
import com.google.android.gms.internal.firebase_database.zzks;
import com.google.android.gms.internal.firebase_database.zzkt;

public class MutableData {
    /* access modifiers changed from: private */
    public final zzdx zzal;
    /* access modifiers changed from: private */
    public final zzch zzam;

    private MutableData(zzdx zzdx, zzch zzch) {
        this.zzal = zzdx;
        this.zzam = zzch;
        zzfb.zza(this.zzam, getValue());
    }

    /* synthetic */ MutableData(zzdx zzdx, zzch zzch, zzi zzi) {
        this(zzdx, zzch);
    }

    MutableData(zzja zzja) {
        this(new zzdx(zzja), new zzch(""));
    }

    public MutableData child(String str) {
        zzks.zzab(str);
        return new MutableData(this.zzal, this.zzam.zzh(new zzch(str)));
    }

    public boolean equals(Object obj) {
        return (obj instanceof MutableData) && this.zzal.equals(((MutableData) obj).zzal) && this.zzam.equals(((MutableData) obj).zzam);
    }

    public Iterable<MutableData> getChildren() {
        zzja zzd = zzd();
        return (zzd.isEmpty() || zzd.zzfk()) ? new zzi(this) : new zzk(this, zzit.zzj(zzd).iterator());
    }

    public long getChildrenCount() {
        return (long) zzd().getChildCount();
    }

    public String getKey() {
        if (this.zzam.zzbz() != null) {
            return this.zzam.zzbz().zzfg();
        }
        return null;
    }

    public Object getPriority() {
        return zzd().zzfl().getValue();
    }

    @Nullable
    public Object getValue() {
        return zzd().getValue();
    }

    @Nullable
    public <T> T getValue(GenericTypeIndicator<T> genericTypeIndicator) {
        return zzkt.zza(zzd().getValue(), genericTypeIndicator);
    }

    @Nullable
    public <T> T getValue(Class<T> cls) {
        return zzkt.zza(zzd().getValue(), cls);
    }

    public boolean hasChild(String str) {
        return !zzd().zzam(new zzch(str)).isEmpty();
    }

    public boolean hasChildren() {
        zzja zzd = zzd();
        return !zzd.zzfk() && !zzd.isEmpty();
    }

    public void setPriority(Object obj) {
        this.zzal.zzg(this.zzam, zzd().zzf(zzjg.zzc(this.zzam, obj)));
    }

    public void setValue(Object obj) throws DatabaseException {
        zzfb.zza(this.zzam, obj);
        Object zzh = zzkt.zzh(obj);
        zzks.zzg(zzh);
        this.zzal.zzg(this.zzam, zzjd.zza(zzh, zzir.zzfv()));
    }

    public String toString() {
        zzid zzbw = this.zzam.zzbw();
        String zzfg = zzbw != null ? zzbw.zzfg() : "<none>";
        String valueOf = String.valueOf(this.zzal.zzcg().getValue(true));
        return new StringBuilder(String.valueOf(zzfg).length() + 32 + String.valueOf(valueOf).length()).append("MutableData { key = ").append(zzfg).append(", value = ").append(valueOf).append(" }").toString();
    }

    /* access modifiers changed from: package-private */
    public final zzja zzd() {
        return this.zzal.zzp(this.zzam);
    }
}
