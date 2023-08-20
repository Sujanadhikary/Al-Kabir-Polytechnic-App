package com.google.android.gms.internal.firebase_database;

import android.util.Base64;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class zzkq {
    private static final char[] zzur = "0123456789abcdef".toCharArray();

    public static int zza(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static void zza(boolean z, String str) {
        if (!z) {
            String valueOf = String.valueOf(str);
            throw new AssertionError(valueOf.length() != 0 ? "hardAssert failed: ".concat(valueOf) : new String("hardAssert failed: "));
        }
    }

    public static Integer zzaa(String str) {
        boolean z = true;
        int i = 0;
        if (str.length() > 11 || str.length() == 0) {
            return null;
        }
        if (str.charAt(0) != '-') {
            z = false;
        } else if (str.length() == 1) {
            return null;
        } else {
            i = 1;
        }
        long j = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt < '0' || charAt > '9') {
                return null;
            }
            j = (j * 10) + ((long) (charAt - '0'));
            i++;
        }
        if (z) {
            if ((-j) < -2147483648L) {
                return null;
            }
            return Integer.valueOf((int) (-j));
        } else if (j > 2147483647L) {
            return null;
        } else {
            return Integer.valueOf((int) j);
        }
    }

    public static int zzb(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static zzkn<Task<Void>, DatabaseReference.CompletionListener> zzb(DatabaseReference.CompletionListener completionListener) {
        if (completionListener != null) {
            return new zzkn<>(null, completionListener);
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        return new zzkn<>(taskCompletionSource.getTask(), new zzkr(taskCompletionSource));
    }

    public static String zzc(double d) {
        StringBuilder sb = new StringBuilder(16);
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 7; i >= 0; i--) {
            int i2 = (int) ((doubleToLongBits >>> (i << 3)) & 255);
            sb.append(zzur[(i2 >> 4) & 15]);
            sb.append(zzur[i2 & 15]);
        }
        return sb.toString();
    }

    public static void zzf(boolean z) {
        zza(z, "");
    }

    public static zzko zzx(String str) throws DatabaseException {
        String str2;
        try {
            int indexOf = str.indexOf("//");
            if (indexOf == -1) {
                throw new URISyntaxException(str, "Invalid scheme specified");
            }
            int indexOf2 = str.substring(indexOf + 2).indexOf("/");
            if (indexOf2 != -1) {
                int i = indexOf + 2 + indexOf2;
                String[] split = str.substring(i).split("/");
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < split.length; i2++) {
                    if (!split[i2].equals("")) {
                        sb.append("/");
                        sb.append(URLEncoder.encode(split[i2], "UTF-8"));
                    }
                }
                String valueOf = String.valueOf(str.substring(0, i));
                String valueOf2 = String.valueOf(sb.toString());
                str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            } else {
                str2 = str;
            }
            URI uri = new URI(str2);
            String replace = uri.getPath().replace("+", " ");
            zzks.zzac(replace);
            zzch zzch = new zzch(replace);
            String scheme = uri.getScheme();
            zzdn zzdn = new zzdn();
            zzdn.zzct = uri.getHost().toLowerCase();
            int port = uri.getPort();
            if (port != -1) {
                zzdn.zzcv = scheme.equals("https");
                String valueOf3 = String.valueOf(zzdn.zzct);
                zzdn.zzct = new StringBuilder(String.valueOf(valueOf3).length() + 12).append(valueOf3).append(":").append(port).toString();
            } else {
                zzdn.zzcv = true;
            }
            zzdn.zzcu = zzdn.zzct.split("\\.")[0].toLowerCase();
            zzdn.zzka = zzdn.zzct;
            zzko zzko = new zzko();
            zzko.zzap = zzch;
            zzko.zzag = zzdn;
            return zzko;
        } catch (URISyntaxException e) {
            throw new DatabaseException("Invalid Firebase Database url specified", e);
        } catch (UnsupportedEncodingException e2) {
            throw new DatabaseException("Failed to URLEncode the path", e2);
        }
    }

    public static String zzy(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA-1");
            instance.update(str.getBytes("UTF-8"));
            return Base64.encodeToString(instance.digest(), 2);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Missing SHA-1 MessageDigest provider.", e);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException("UTF-8 encoding is required for Firebase Database to run!");
        }
    }

    public static String zzz(String str) {
        String replace = str.indexOf(92) != -1 ? str.replace("\\", "\\\\") : str;
        if (str.indexOf(34) != -1) {
            replace = replace.replace("\"", "\\\"");
        }
        return new StringBuilder(String.valueOf(replace).length() + 2).append('\"').append(replace).append('\"').toString();
    }
}
