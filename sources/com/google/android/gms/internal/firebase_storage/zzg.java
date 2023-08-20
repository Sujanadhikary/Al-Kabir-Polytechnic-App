package com.google.android.gms.internal.firebase_storage;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

public final class zzg {
    @NonNull
    public static String zzb(@Nullable String str) throws UnsupportedEncodingException {
        return TextUtils.isEmpty(str) ? "" : zzc(Uri.encode(str));
    }

    @NonNull
    public static String zzc(@NonNull String str) {
        Preconditions.checkNotNull(str);
        return str.replace("%2F", "/");
    }

    @NonNull
    public static String zzd(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("/")) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append("/").append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }
}
