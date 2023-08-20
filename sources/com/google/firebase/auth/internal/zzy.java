package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzv;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class zzy {
    private static final Logger zzdv = new Logger("JSONParser", new String[0]);

    @VisibleForTesting
    private static List<Object> zza(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= jSONArray.length()) {
                return arrayList;
            }
            Object obj = jSONArray.get(i2);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            arrayList.add(obj);
            i = i2 + 1;
        }
    }

    @NonNull
    public static Map<String, Object> zzah(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        String[] split = str.split("\\.");
        if (split.length < 2) {
            Logger logger = zzdv;
            String valueOf = String.valueOf(str);
            logger.mo8036e(valueOf.length() != 0 ? "Invalid idToken ".concat(valueOf) : new String("Invalid idToken "), new Object[0]);
            return Collections.EMPTY_MAP;
        }
        try {
            Map<String, Object> zzai = zzai(new String(Base64Utils.decodeUrlSafeNoPadding(split[1]), "UTF-8"));
            return zzai == null ? Collections.EMPTY_MAP : zzai;
        } catch (UnsupportedEncodingException e) {
            zzdv.mo8035e("Unable to decode token", e, new Object[0]);
            return Collections.EMPTY_MAP;
        }
    }

    @Nullable
    public static Map<String, Object> zzai(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject != JSONObject.NULL) {
                return zzb(jSONObject);
            }
            return null;
        } catch (Exception e) {
            Log.d("JSONParser", "Failed to parse JSONObject into Map.");
            throw new zzv((Throwable) e);
        }
    }

    @VisibleForTesting
    private static Map<String, Object> zzb(JSONObject jSONObject) throws JSONException {
        ArrayMap arrayMap = new ArrayMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = zza((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = zzb((JSONObject) obj);
            }
            arrayMap.put(next, obj);
        }
        return arrayMap;
    }
}
