package com.google.firebase.database;

import android.text.TextUtils;
import com.google.android.gms.internal.firebase_database.zzcc;
import com.google.android.gms.internal.firebase_database.zzch;
import com.google.android.gms.internal.firebase_database.zzck;
import com.google.android.gms.internal.firebase_database.zzdn;
import com.google.android.gms.internal.firebase_database.zzdo;
import com.google.android.gms.internal.firebase_database.zzko;
import com.google.android.gms.internal.firebase_database.zzkq;
import com.google.android.gms.internal.firebase_database.zzks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.Logger;
import java.util.HashMap;
import java.util.Map;

public class FirebaseDatabase {
    private static final Map<String, Map<zzdn, FirebaseDatabase>> zzae = new HashMap();
    private final FirebaseApp zzaf;
    private final zzdn zzag;
    private final zzcc zzah;
    /* access modifiers changed from: private */
    public zzck zzai;

    private FirebaseDatabase(FirebaseApp firebaseApp, zzdn zzdn, zzcc zzcc) {
        this.zzaf = firebaseApp;
        this.zzag = zzdn;
        this.zzah = zzcc;
    }

    public static FirebaseDatabase getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, instance.getOptions().getDatabaseUrl());
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static FirebaseDatabase getInstance(FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, firebaseApp.getOptions().getDatabaseUrl());
    }

    public static synchronized FirebaseDatabase getInstance(FirebaseApp firebaseApp, String str) {
        HashMap hashMap;
        FirebaseDatabase firebaseDatabase;
        synchronized (FirebaseDatabase.class) {
            if (TextUtils.isEmpty(str)) {
                throw new DatabaseException("Failed to get FirebaseDatabase instance: Specify DatabaseURL within FirebaseApp or from your getInstance() call.");
            }
            Map map = zzae.get(firebaseApp.getName());
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                zzae.put(firebaseApp.getName(), hashMap2);
                hashMap = hashMap2;
            } else {
                hashMap = map;
            }
            zzko zzx = zzkq.zzx(str);
            if (!zzx.zzap.isEmpty()) {
                String zzch = zzx.zzap.toString();
                throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 113 + String.valueOf(zzch).length()).append("Specified Database URL '").append(str).append("' is invalid. It should point to the root of a Firebase Database but it includes a path: ").append(zzch).toString());
            }
            firebaseDatabase = (FirebaseDatabase) hashMap.get(zzx.zzag);
            if (firebaseDatabase == null) {
                zzcc zzcc = new zzcc();
                if (!firebaseApp.isDefaultApp()) {
                    zzcc.zzr(firebaseApp.getName());
                }
                zzcc.zza(firebaseApp);
                firebaseDatabase = new FirebaseDatabase(firebaseApp, zzx.zzag, zzcc);
                hashMap.put(zzx.zzag, firebaseDatabase);
            }
        }
        return firebaseDatabase;
    }

    public static FirebaseDatabase getInstance(String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        if (instance != null) {
            return getInstance(instance, str);
        }
        throw new DatabaseException("You must call FirebaseApp.initialize() first.");
    }

    public static String getSdkVersion() {
        return "3.0.0";
    }

    private final void zzb(String str) {
        if (this.zzai != null) {
            throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 77).append("Calls to ").append(str).append("() must be made before any other usage of FirebaseDatabase instance.").toString());
        }
    }

    private final synchronized void zzc() {
        if (this.zzai == null) {
            this.zzai = zzdo.zza(this.zzah, this.zzag, this);
        }
    }

    public FirebaseApp getApp() {
        return this.zzaf;
    }

    public DatabaseReference getReference() {
        zzc();
        return new DatabaseReference(this.zzai, zzch.zzbt());
    }

    public DatabaseReference getReference(String str) {
        zzc();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'pathString' in FirebaseDatabase.getReference()");
        }
        zzks.zzac(str);
        return new DatabaseReference(this.zzai, new zzch(str));
    }

    public DatabaseReference getReferenceFromUrl(String str) {
        zzc();
        if (str == null) {
            throw new NullPointerException("Can't pass null for argument 'url' in FirebaseDatabase.getReferenceFromUrl()");
        }
        zzko zzx = zzkq.zzx(str);
        if (zzx.zzag.zzct.equals(this.zzai.zzcb().zzct)) {
            return new DatabaseReference(this.zzai, zzx.zzap);
        }
        String databaseReference = getReference().toString();
        throw new DatabaseException(new StringBuilder(String.valueOf(str).length() + 93 + String.valueOf(databaseReference).length()).append("Invalid URL (").append(str).append(") passed to getReference().  URL was expected to match configured Database URL: ").append(databaseReference).toString());
    }

    public void goOffline() {
        zzc();
        zzdo.zzk(this.zzai);
    }

    public void goOnline() {
        zzc();
        zzdo.zzl(this.zzai);
    }

    public void purgeOutstandingWrites() {
        zzc();
        this.zzai.zzc((Runnable) new zzg(this));
    }

    public synchronized void setLogLevel(Logger.Level level) {
        zzb("setLogLevel");
        this.zzah.setLogLevel(level);
    }

    public synchronized void setPersistenceCacheSizeBytes(long j) {
        zzb("setPersistenceCacheSizeBytes");
        this.zzah.setPersistenceCacheSizeBytes(j);
    }

    public synchronized void setPersistenceEnabled(boolean z) {
        zzb("setPersistenceEnabled");
        this.zzah.setPersistenceEnabled(z);
    }
}
