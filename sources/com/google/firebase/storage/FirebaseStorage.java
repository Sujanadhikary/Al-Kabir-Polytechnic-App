package com.google.firebase.storage;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzk;
import com.google.firebase.FirebaseApp;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class FirebaseStorage {
    private static final Map<String, Map<String, FirebaseStorage>> zzo = new HashMap();
    @NonNull
    private final FirebaseApp zzp;
    @Nullable
    private final String zzq;
    private long zzr = 600000;
    private long zzs = 600000;
    private long zzt = 120000;

    private FirebaseStorage(@Nullable String str, @NonNull FirebaseApp firebaseApp) {
        this.zzq = str;
        this.zzp = firebaseApp;
    }

    @NonNull
    public static FirebaseStorage getInstance() {
        FirebaseApp instance = FirebaseApp.getInstance();
        Preconditions.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance);
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        String storageBucket = firebaseApp.getOptions().getStorageBucket();
        if (storageBucket == null) {
            return zza(firebaseApp, (Uri) null);
        }
        try {
            String valueOf = String.valueOf(firebaseApp.getOptions().getStorageBucket());
            return zza(firebaseApp, zzk.zza(firebaseApp, valueOf.length() != 0 ? "gs://".concat(valueOf) : new String("gs://")));
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf2 = String.valueOf(storageBucket);
            Log.e("FirebaseStorage", valueOf2.length() != 0 ? "Unable to parse bucket:".concat(valueOf2) : new String("Unable to parse bucket:"), unsupportedEncodingException);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkArgument(firebaseApp != null, "Null is not a valid value for the FirebaseApp.");
        if (!str.toLowerCase().startsWith("gs://")) {
            throw new IllegalArgumentException("Please use a gs:// URL for your Firebase Storage bucket.");
        }
        try {
            return zza(firebaseApp, zzk.zza(firebaseApp, str));
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf = String.valueOf(str);
            Log.e("FirebaseStorage", valueOf.length() != 0 ? "Unable to parse url:".concat(valueOf) : new String("Unable to parse url:"), unsupportedEncodingException);
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    @NonNull
    public static FirebaseStorage getInstance(@NonNull String str) {
        FirebaseApp instance = FirebaseApp.getInstance();
        Preconditions.checkArgument(instance != null, "You must call FirebaseApp.initialize() first.");
        return getInstance(instance, str);
    }

    private static FirebaseStorage zza(@NonNull FirebaseApp firebaseApp, @Nullable Uri uri) {
        HashMap hashMap;
        FirebaseStorage firebaseStorage;
        String host = uri != null ? uri.getHost() : null;
        if (uri == null || TextUtils.isEmpty(uri.getPath())) {
            synchronized (zzo) {
                Map map = zzo.get(firebaseApp.getName());
                if (map == null) {
                    HashMap hashMap2 = new HashMap();
                    zzo.put(firebaseApp.getName(), hashMap2);
                    hashMap = hashMap2;
                } else {
                    hashMap = map;
                }
                firebaseStorage = (FirebaseStorage) hashMap.get(host);
                if (firebaseStorage == null) {
                    firebaseStorage = new FirebaseStorage(host, firebaseApp);
                    hashMap.put(host, firebaseStorage);
                }
            }
            return firebaseStorage;
        }
        throw new IllegalArgumentException("The storage Uri cannot contain a path element.");
    }

    @NonNull
    private final StorageReference zza(@NonNull Uri uri) {
        Preconditions.checkNotNull(uri, "uri must not be null");
        String str = this.zzq;
        Preconditions.checkArgument(TextUtils.isEmpty(str) || uri.getAuthority().equalsIgnoreCase(str), "The supplied bucketname does not match the storage bucket of the current instance.");
        return new StorageReference(uri, this);
    }

    @NonNull
    public FirebaseApp getApp() {
        return this.zzp;
    }

    public long getMaxDownloadRetryTimeMillis() {
        return this.zzs;
    }

    public long getMaxOperationRetryTimeMillis() {
        return this.zzt;
    }

    public long getMaxUploadRetryTimeMillis() {
        return this.zzr;
    }

    @NonNull
    public StorageReference getReference() {
        if (!TextUtils.isEmpty(this.zzq)) {
            return zza(new Uri.Builder().scheme("gs").authority(this.zzq).path("/").build());
        }
        throw new IllegalStateException("FirebaseApp was not initialized with a bucket name.");
    }

    @NonNull
    public StorageReference getReference(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("gs://") && !lowerCase.startsWith("https://") && !lowerCase.startsWith("http://")) {
            return getReference().child(str);
        }
        throw new IllegalArgumentException("location should not be a full URL.");
    }

    @NonNull
    public StorageReference getReferenceFromUrl(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "location must not be null or empty");
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith("gs://") || lowerCase.startsWith("https://") || lowerCase.startsWith("http://")) {
            try {
                Uri zza = zzk.zza(this.zzp, str);
                if (zza != null) {
                    return zza(zza);
                }
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            } catch (UnsupportedEncodingException e) {
                UnsupportedEncodingException unsupportedEncodingException = e;
                String valueOf = String.valueOf(str);
                Log.e("FirebaseStorage", valueOf.length() != 0 ? "Unable to parse location:".concat(valueOf) : new String("Unable to parse location:"), unsupportedEncodingException);
                throw new IllegalArgumentException("The storage Uri could not be parsed.");
            }
        } else {
            throw new IllegalArgumentException("The storage Uri could not be parsed.");
        }
    }

    public void setMaxDownloadRetryTimeMillis(long j) {
        this.zzs = j;
    }

    public void setMaxOperationRetryTimeMillis(long j) {
        this.zzt = j;
    }

    public void setMaxUploadRetryTimeMillis(long j) {
        this.zzr = j;
    }
}
