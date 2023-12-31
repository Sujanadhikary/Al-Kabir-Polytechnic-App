package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

public class Storage {
    private static final Lock zzaf = new ReentrantLock();
    @GuardedBy("sLk")
    private static Storage zzag;
    private final Lock zzah = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences zzai;

    @VisibleForTesting
    private Storage(Context context) {
        this.zzai = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static Storage getInstance(Context context) {
        Preconditions.checkNotNull(context);
        zzaf.lock();
        try {
            if (zzag == null) {
                zzag = new Storage(context.getApplicationContext());
            }
            return zzag;
        } finally {
            zzaf.unlock();
        }
    }

    @VisibleForTesting
    public static void setInstance(@Nullable Storage storage) {
        zzaf.lock();
        try {
            zzag = storage;
        } finally {
            zzaf.unlock();
        }
    }

    private static String zza(String str, String str2) {
        return new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(":").append(str2).toString();
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInAccount zzb(String str) {
        String fromStore;
        if (TextUtils.isEmpty(str) || (fromStore = getFromStore(zza("googleSignInAccount", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInAccount.fromJsonString(fromStore);
        } catch (JSONException e) {
            return null;
        }
    }

    @Nullable
    @VisibleForTesting
    private final GoogleSignInOptions zzc(String str) {
        String fromStore;
        if (TextUtils.isEmpty(str) || (fromStore = getFromStore(zza("googleSignInOptions", str))) == null) {
            return null;
        }
        try {
            return GoogleSignInOptions.fromJsonString(fromStore);
        } catch (JSONException e) {
            return null;
        }
    }

    public void clear() {
        this.zzah.lock();
        try {
            this.zzai.edit().clear().apply();
        } finally {
            this.zzah.unlock();
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public String getFromStore(String str) {
        this.zzah.lock();
        try {
            return this.zzai.getString(str, (String) null);
        } finally {
            this.zzah.unlock();
        }
    }

    @Nullable
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        return zzb(getFromStore("defaultGoogleSignInAccount"));
    }

    @Nullable
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        return zzc(getFromStore("defaultGoogleSignInAccount"));
    }

    @Nullable
    public String getSavedRefreshToken() {
        return getFromStore("refreshToken");
    }

    /* access modifiers changed from: protected */
    public void removeFromStore(String str) {
        this.zzah.lock();
        try {
            this.zzai.edit().remove(str).apply();
        } finally {
            this.zzah.unlock();
        }
    }

    public void removeSavedDefaultGoogleSignInAccount() {
        String fromStore = getFromStore("defaultGoogleSignInAccount");
        removeFromStore("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(fromStore)) {
            removeFromStore(zza("googleSignInAccount", fromStore));
            removeFromStore(zza("googleSignInOptions", fromStore));
        }
    }

    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        saveToStore("defaultGoogleSignInAccount", googleSignInAccount.getObfuscatedIdentifier());
        Preconditions.checkNotNull(googleSignInAccount);
        Preconditions.checkNotNull(googleSignInOptions);
        String obfuscatedIdentifier = googleSignInAccount.getObfuscatedIdentifier();
        saveToStore(zza("googleSignInAccount", obfuscatedIdentifier), googleSignInAccount.toJsonForStorage());
        saveToStore(zza("googleSignInOptions", obfuscatedIdentifier), googleSignInOptions.toJson());
    }

    public void saveRefreshToken(String str) {
        if (!TextUtils.isEmpty(str)) {
            saveToStore("refreshToken", str);
        }
    }

    /* access modifiers changed from: protected */
    public void saveToStore(String str, String str2) {
        this.zzah.lock();
        try {
            this.zzai.edit().putString(str, str2).apply();
        } finally {
            this.zzah.unlock();
        }
    }
}
