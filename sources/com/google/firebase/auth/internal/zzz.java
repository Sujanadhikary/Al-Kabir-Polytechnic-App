package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.dynamite.ProviderConstants;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.android.gms.internal.firebase_auth.zzv;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzz {
    private Logger zzdv = new Logger("StorageHelpers", new String[0]);
    private Context zzgo;
    private String zzlm;
    private SharedPreferences zzln = this.zzgo.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzlm}), 0);

    public zzz(@NonNull Context context, @NonNull String str) {
        Preconditions.checkNotNull(context);
        this.zzlm = Preconditions.checkNotEmpty(str);
        this.zzgo = context.getApplicationContext();
    }

    private final zzk zzc(@NonNull JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString(ProviderConstants.API_COLNAME_FEATURE_VERSION);
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray = jSONObject.getJSONArray("userInfos");
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzh.zzad(jSONArray.getString(i)));
            }
            zzk zzk = new zzk(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzk.zza(zzao.zzs(string));
            }
            ((zzk) zzk.zza(z)).zzae(str);
            zzm zza = zzm.zza(jSONObject.getJSONObject("userMetadata"));
            if (zza != null) {
                zzk.zza(zza);
            }
            return zzk;
        } catch (zzv | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzdv.wtf(e);
            return null;
        }
    }

    @Nullable
    private final String zzi(@NonNull FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzk.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzk zzk = (zzk) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", zzk.zzo());
            jSONObject.put("applicationName", zzk.zzm().getName());
            jSONObject.put(AppMeasurement.Param.TYPE, "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzk.zzbd() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzh> zzbd = zzk.zzbd();
                for (int i = 0; i < zzbd.size(); i++) {
                    jSONArray.put(zzbd.get(i).toJson());
                }
                jSONObject.put("userInfos", jSONArray);
            }
            jSONObject.put("anonymous", zzk.isAnonymous());
            jSONObject.put(ProviderConstants.API_COLNAME_FEATURE_VERSION, "2");
            jSONObject.put("userMetadata", ((zzm) zzk.getMetadata()).zzbe());
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzdv.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzv((Throwable) e);
        }
    }

    public final void clear(String str) {
        this.zzln.edit().remove(str).apply();
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzao zzao) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzao);
        this.zzln.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzao.toJson()).apply();
    }

    @Nullable
    public final FirebaseUser zzbi() {
        String string = this.zzln.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (!jSONObject.has(AppMeasurement.Param.TYPE) || !"com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString(AppMeasurement.Param.TYPE))) {
                return null;
            }
            return zzc(jSONObject);
        } catch (Exception e) {
            return null;
        }
    }

    public final void zzg(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zzi = zzi(firebaseUser);
        if (!TextUtils.isEmpty(zzi)) {
            this.zzln.edit().putString("com.google.firebase.auth.FIREBASE_USER", zzi).apply();
        }
    }

    public final zzao zzh(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzln.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), (String) null);
        if (string != null) {
            return zzao.zzs(string);
        }
        return null;
    }
}
