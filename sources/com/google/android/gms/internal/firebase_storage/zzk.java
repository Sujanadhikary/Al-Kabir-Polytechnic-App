package com.google.android.gms.internal.firebase_storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.GetTokenResult;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class zzk {
    @Nullable
    public static Uri zza(@NonNull FirebaseApp firebaseApp, @Nullable String str) throws UnsupportedEncodingException {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.toLowerCase().startsWith("gs://")) {
            String valueOf = String.valueOf(zzg.zzb(zzg.zzd(str.substring(5))));
            return Uri.parse(valueOf.length() != 0 ? "gs://".concat(valueOf) : new String("gs://"));
        }
        Uri parse = Uri.parse(str);
        String scheme = parse.getScheme();
        if (scheme == null || (!Objects.equal(scheme.toLowerCase(), "http") && !Objects.equal(scheme.toLowerCase(), "https"))) {
            String valueOf2 = String.valueOf(scheme);
            Log.w("StorageUtil", valueOf2.length() != 0 ? "FirebaseStorage is unable to support the scheme:".concat(valueOf2) : new String("FirebaseStorage is unable to support the scheme:"));
            throw new IllegalArgumentException("Uri scheme");
        }
        try {
            int indexOf = parse.getAuthority().toLowerCase().indexOf(zzp.zzb(firebaseApp).zzac());
            String zzc = zzg.zzc(parse.getEncodedPath());
            if (indexOf == 0 && zzc.startsWith("/")) {
                int indexOf2 = zzc.indexOf("/b/", 0);
                int indexOf3 = zzc.indexOf("/", indexOf2 + 3);
                int indexOf4 = zzc.indexOf("/o/", 0);
                if (indexOf2 == -1 || indexOf3 == -1) {
                    Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                    throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                }
                substring = zzc.substring(indexOf2 + 3, indexOf3);
                zzc = indexOf4 != -1 ? zzc.substring(indexOf4 + 3) : "";
            } else if (indexOf > 1) {
                substring = parse.getAuthority().substring(0, indexOf - 1);
            } else {
                Log.w("StorageUtil", "Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
                throw new IllegalArgumentException("Firebase Storage URLs must point to an object in your Storage Bucket. Please obtain a URL using the Firebase Console or getDownloadUrl().");
            }
            Preconditions.checkNotEmpty(substring, "No bucket specified");
            return new Uri.Builder().scheme("gs").authority(substring).encodedPath(zzc).build();
        } catch (RemoteException e) {
            throw new UnsupportedEncodingException("Could not parse Url because the Storage network layer did not load");
        }
    }

    @Nullable
    public static String zza(FirebaseApp firebaseApp) {
        try {
            String token = ((GetTokenResult) Tasks.await(firebaseApp.getToken(false), 30000, TimeUnit.MILLISECONDS)).getToken();
            if (!TextUtils.isEmpty(token)) {
                return token;
            }
            Log.w("StorageUtil", "no auth token for request");
            return null;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e);
            Log.e("StorageUtil", new StringBuilder(String.valueOf(valueOf).length() + 20).append("error getting token ").append(valueOf).toString());
        }
    }

    public static long zze(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        String replaceAll = str.replaceAll("Z$", "-0000");
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", Locale.getDefault()).parse(replaceAll).getTime();
        } catch (ParseException e) {
            ParseException parseException = e;
            String valueOf = String.valueOf(replaceAll);
            Log.w("StorageUtil", valueOf.length() != 0 ? "unable to parse datetime:".concat(valueOf) : new String("unable to parse datetime:"), parseException);
            return 0;
        }
    }
}
