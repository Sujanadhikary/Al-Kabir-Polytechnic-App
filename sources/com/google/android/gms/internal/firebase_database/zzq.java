package com.google.android.gms.internal.firebase_database;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.idl.zzc;
import com.google.firebase.database.connection.idl.zzf;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

public final class zzq implements zzcj {
    private final FirebaseApp zzbd;
    /* access modifiers changed from: private */
    public final Context zzbj;
    private final Set<String> zzbk = new HashSet();

    public zzq(FirebaseApp firebaseApp) {
        this.zzbd = firebaseApp;
        if (this.zzbd == null) {
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Log.e("FirebaseDatabase", "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
            Log.e("FirebaseDatabase", "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            throw new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        }
        this.zzbj = this.zzbd.getApplicationContext();
    }

    public final zzaj zza(zzbz zzbz, zzaf zzaf, zzah zzah, zzak zzak) {
        zzf zza = zzf.zza(this.zzbj, new zzc(zzah, zzbz.zzbn(), (List<String>) null, zzbz.zzt(), FirebaseDatabase.getSdkVersion(), zzbz.zzv(), zzi()), zzaf, zzak);
        this.zzbd.addBackgroundStateChangeListener(new zzt(this, zza));
        return zza;
    }

    public final zzbq zza(ScheduledExecutorService scheduledExecutorService) {
        return new zzk(this.zzbd, scheduledExecutorService);
    }

    public final zzcg zza(zzbz zzbz) {
        return new zzp();
    }

    public final zzfv zza(zzbz zzbz, String str) {
        String zzbq = zzbz.zzbq();
        String sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(zzbq).length()).append(str).append("_").append(zzbq).toString();
        if (this.zzbk.contains(sb)) {
            throw new DatabaseException(new StringBuilder(String.valueOf(zzbq).length() + 47).append("SessionPersistenceKey '").append(zzbq).append("' has already been used.").toString());
        }
        this.zzbk.add(sb);
        return new zzfs(zzbz, new zzu(this.zzbj, zzbz, sb), new zzft(zzbz.zzbo()));
    }

    public final zzia zza(zzbz zzbz, zzib zzib, List<String> list) {
        return new zzhw(zzib, (List<String>) null);
    }

    public final zzdt zzb(zzbz zzbz) {
        return new zzr(this, zzbz.zzp("RunLoop"));
    }

    public final String zzc(zzbz zzbz) {
        return new StringBuilder(19).append(Build.VERSION.SDK_INT).append("/Android").toString();
    }

    public final File zzi() {
        return this.zzbj.getApplicationContext().getDir("sslcache", 0);
    }
}
