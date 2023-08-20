package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.content.ContextCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.firebase_messaging.zzh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

final class zzp {
    zzp() {
    }

    @Nullable
    private static zzq zza(SharedPreferences sharedPreferences, String str) throws zzr {
        String string = sharedPreferences.getString(zzao.zzd(str, "|P|"), (String) null);
        String string2 = sharedPreferences.getString(zzao.zzd(str, "|K|"), (String) null);
        if (string == null || string2 == null) {
            return null;
        }
        return new zzq(zzc(string, string2), zzb(sharedPreferences, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0044, code lost:
        r6 = r1;
        r1 = r0;
        r0 = r6;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.firebase.iid.zzq zza(java.io.File r7) throws com.google.firebase.iid.zzr, java.io.IOException {
        /*
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream
            r2.<init>(r7)
            java.util.Properties r0 = new java.util.Properties     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            r0.<init>()     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            r0.load(r2)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            java.lang.String r3 = "pub"
            java.lang.String r3 = r0.getProperty(r3)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            java.lang.String r4 = "pri"
            java.lang.String r4 = r0.getProperty(r4)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            if (r3 == 0) goto L_0x001e
            if (r4 != 0) goto L_0x0023
        L_0x001e:
            zza((java.lang.Throwable) r1, (java.io.FileInputStream) r2)
            r0 = r1
        L_0x0022:
            return r0
        L_0x0023:
            java.security.KeyPair r3 = zzc((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            java.lang.String r4 = "cre"
            java.lang.String r0 = r0.getProperty(r4)     // Catch:{ NumberFormatException -> 0x003a }
            long r4 = java.lang.Long.parseLong(r0)     // Catch:{ NumberFormatException -> 0x003a }
            com.google.firebase.iid.zzq r0 = new com.google.firebase.iid.zzq     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            r0.<init>(r3, r4)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            zza((java.lang.Throwable) r1, (java.io.FileInputStream) r2)
            goto L_0x0022
        L_0x003a:
            r0 = move-exception
            com.google.firebase.iid.zzr r3 = new com.google.firebase.iid.zzr     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            r3.<init>(r0)     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
            throw r3     // Catch:{ Throwable -> 0x0041, all -> 0x004b }
        L_0x0041:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L_0x0047:
            zza((java.lang.Throwable) r1, (java.io.FileInputStream) r2)
            throw r0
        L_0x004b:
            r0 = move-exception
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(java.io.File):com.google.firebase.iid.zzq");
    }

    static void zza(Context context) {
        for (File file : zzb(context).listFiles()) {
            if (file.getName().startsWith("com.google.InstanceId")) {
                file.delete();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        zza(r1, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(android.content.Context r6, java.lang.String r7, com.google.firebase.iid.zzq r8) {
        /*
            r1 = 0
            java.lang.String r0 = "FirebaseInstanceId"
            r2 = 3
            boolean r0 = android.util.Log.isLoggable(r0, r2)     // Catch:{ IOException -> 0x0051 }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r2 = "Writing key to properties file"
            android.util.Log.d(r0, r2)     // Catch:{ IOException -> 0x0051 }
        L_0x0011:
            java.io.File r0 = zzf(r6, r7)     // Catch:{ IOException -> 0x0051 }
            r0.createNewFile()     // Catch:{ IOException -> 0x0051 }
            java.util.Properties r2 = new java.util.Properties     // Catch:{ IOException -> 0x0051 }
            r2.<init>()     // Catch:{ IOException -> 0x0051 }
            java.lang.String r3 = "pub"
            java.lang.String r4 = r8.zzq()     // Catch:{ IOException -> 0x0051 }
            r2.setProperty(r3, r4)     // Catch:{ IOException -> 0x0051 }
            java.lang.String r3 = "pri"
            java.lang.String r4 = r8.zzr()     // Catch:{ IOException -> 0x0051 }
            r2.setProperty(r3, r4)     // Catch:{ IOException -> 0x0051 }
            java.lang.String r3 = "cre"
            long r4 = r8.zzbe     // Catch:{ IOException -> 0x0051 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0051 }
            r2.setProperty(r3, r4)     // Catch:{ IOException -> 0x0051 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0051 }
            r3.<init>(r0)     // Catch:{ IOException -> 0x0051 }
            r0 = 0
            r2.store(r3, r0)     // Catch:{ Throwable -> 0x004a }
            r0 = 0
            zza((java.lang.Throwable) r0, (java.io.FileOutputStream) r3)     // Catch:{ IOException -> 0x0051 }
        L_0x0049:
            return
        L_0x004a:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004c }
        L_0x004c:
            r0 = move-exception
            zza((java.lang.Throwable) r1, (java.io.FileOutputStream) r3)     // Catch:{ IOException -> 0x0051 }
            throw r0     // Catch:{ IOException -> 0x0051 }
        L_0x0051:
            r0 = move-exception
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r2 = r2 + 21
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Failed to write key: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r1, r0)
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzp.zza(android.content.Context, java.lang.String, com.google.firebase.iid.zzq):void");
    }

    private static /* synthetic */ void zza(Throwable th, FileInputStream fileInputStream) {
        if (th != null) {
            try {
                fileInputStream.close();
            } catch (Throwable th2) {
                zzh.zza(th, th2);
            }
        } else {
            fileInputStream.close();
        }
    }

    private static /* synthetic */ void zza(Throwable th, FileOutputStream fileOutputStream) {
        if (th != null) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                zzh.zza(th, th2);
            }
        } else {
            fileOutputStream.close();
        }
    }

    private static long zzb(SharedPreferences sharedPreferences, String str) {
        String string = sharedPreferences.getString(zzao.zzd(str, "cre"), (String) null);
        if (string != null) {
            try {
                return Long.parseLong(string);
            } catch (NumberFormatException e) {
            }
        }
        return 0;
    }

    private static File zzb(Context context) {
        File noBackupFilesDir = ContextCompat.getNoBackupFilesDir(context);
        if (noBackupFilesDir != null && noBackupFilesDir.isDirectory()) {
            return noBackupFilesDir;
        }
        Log.w("FirebaseInstanceId", "noBackupFilesDir doesn't exist, using regular files directory instead");
        return context.getFilesDir();
    }

    private final void zzb(Context context, String str, zzq zzq) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        try {
            if (zzq.equals(zza(sharedPreferences, str))) {
                return;
            }
        } catch (zzr e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Writing key to shared preferences");
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(zzao.zzd(str, "|P|"), zzq.zzq());
        edit.putString(zzao.zzd(str, "|K|"), zzq.zzr());
        edit.putString(zzao.zzd(str, "cre"), String.valueOf(zzq.zzbe));
        edit.commit();
    }

    private static KeyPair zzc(String str, String str2) throws zzr {
        try {
            byte[] decode = Base64.decode(str, 8);
            byte[] decode2 = Base64.decode(str2, 8);
            try {
                KeyFactory instance = KeyFactory.getInstance("RSA");
                return new KeyPair(instance.generatePublic(new X509EncodedKeySpec(decode)), instance.generatePrivate(new PKCS8EncodedKeySpec(decode2)));
            } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
                String valueOf = String.valueOf(e);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 19).append("Invalid key stored ").append(valueOf).toString());
                throw new zzr(e);
            }
        } catch (IllegalArgumentException e2) {
            throw new zzr(e2);
        }
    }

    @Nullable
    private final zzq zzd(Context context, String str) throws zzr {
        zzr zzr;
        try {
            zzq zze = zze(context, str);
            if (zze != null) {
                zzb(context, str, zze);
                return zze;
            }
            zzr = null;
            try {
                zzq zza = zza(context.getSharedPreferences("com.google.android.gms.appid", 0), str);
                if (zza != null) {
                    zza(context, str, zza);
                    return zza;
                }
                e = zzr;
                if (e == null) {
                    return null;
                }
                throw e;
            } catch (zzr e) {
                e = e;
            }
        } catch (zzr e2) {
            zzr = e2;
        }
    }

    @Nullable
    private final zzq zze(Context context, String str) throws zzr {
        File zzf = zzf(context, str);
        if (!zzf.exists()) {
            return null;
        }
        try {
            return zza(zzf);
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(e);
                Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 40).append("Failed to read key from file, retrying: ").append(valueOf).toString());
            }
            try {
                return zza(zzf);
            } catch (IOException e2) {
                String valueOf2 = String.valueOf(e2);
                Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf2).length() + 45).append("IID file exists, but failed to read from it: ").append(valueOf2).toString());
                throw new zzr(e2);
            }
        }
    }

    private static File zzf(Context context, String str) {
        String sb;
        if (TextUtils.isEmpty(str)) {
            sb = "com.google.InstanceId.properties";
        } else {
            try {
                String encodeToString = Base64.encodeToString(str.getBytes("UTF-8"), 11);
                sb = new StringBuilder(String.valueOf(encodeToString).length() + 33).append("com.google.InstanceId_").append(encodeToString).append(".properties").toString();
            } catch (UnsupportedEncodingException e) {
                throw new AssertionError(e);
            }
        }
        return new File(zzb(context), sb);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzq zzb(Context context, String str) throws zzr {
        zzq zzd = zzd(context, str);
        return zzd != null ? zzd : zzc(context, str);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final zzq zzc(Context context, String str) {
        zzq zzq = new zzq(zza.zzb(), System.currentTimeMillis());
        try {
            zzq zzd = zzd(context, str);
            if (zzd != null) {
                if (!Log.isLoggable("FirebaseInstanceId", 3)) {
                    return zzd;
                }
                Log.d("FirebaseInstanceId", "Loaded key after generating new one, using loaded one");
                return zzd;
            }
        } catch (zzr e) {
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Generated new key");
        }
        zza(context, str, zzq);
        zzb(context, str, zzq);
        return zzq;
    }
}
