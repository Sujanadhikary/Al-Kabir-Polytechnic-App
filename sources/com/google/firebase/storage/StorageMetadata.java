package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzg;
import com.google.android.gms.internal.firebase_storage.zzk;
import com.google.android.gms.internal.firebase_storage.zzp;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class StorageMetadata {
    /* access modifiers changed from: private */
    public String mPath;
    private FirebaseStorage zzaa;
    /* access modifiers changed from: private */
    public String zzab;
    /* access modifiers changed from: private */
    public String zzac;
    /* access modifiers changed from: private */
    public zza<String> zzad;
    /* access modifiers changed from: private */
    public String zzae;
    /* access modifiers changed from: private */
    public String zzaf;
    /* access modifiers changed from: private */
    public String zzag;
    /* access modifiers changed from: private */
    public long zzah;
    /* access modifiers changed from: private */
    public String zzai;
    /* access modifiers changed from: private */
    public zza<String> zzaj;
    /* access modifiers changed from: private */
    public zza<String> zzak;
    /* access modifiers changed from: private */
    public zza<String> zzal;
    /* access modifiers changed from: private */
    public zza<String> zzam;
    /* access modifiers changed from: private */
    public zza<Map<String, String>> zzan;
    private String[] zzao;
    /* access modifiers changed from: private */
    public StorageReference zzd;

    public static class Builder {
        private StorageMetadata zzap;
        private boolean zzaq;

        public Builder() {
            this.zzap = new StorageMetadata();
        }

        public Builder(StorageMetadata storageMetadata) {
            this.zzap = new StorageMetadata(false);
        }

        private Builder(JSONObject jSONObject) throws JSONException {
            this.zzap = new StorageMetadata();
            if (jSONObject != null) {
                String unused = this.zzap.zzac = jSONObject.optString("generation");
                String unused2 = this.zzap.mPath = jSONObject.optString("name");
                String unused3 = this.zzap.zzab = jSONObject.optString("bucket");
                String unused4 = this.zzap.zzae = jSONObject.optString("metageneration");
                String unused5 = this.zzap.zzaf = jSONObject.optString("timeCreated");
                String unused6 = this.zzap.zzag = jSONObject.optString("updated");
                long unused7 = this.zzap.zzah = jSONObject.optLong("size");
                String unused8 = this.zzap.zzai = jSONObject.optString("md5Hash");
                this.zzap.zza(jSONObject.optString("downloadTokens"));
                if (jSONObject.has("metadata") && !jSONObject.isNull("metadata")) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        setCustomMetadata(next, jSONObject2.getString(next));
                    }
                }
                String zza = zza(jSONObject, "contentType");
                if (zza != null) {
                    setContentType(zza);
                }
                String zza2 = zza(jSONObject, "cacheControl");
                if (zza2 != null) {
                    setCacheControl(zza2);
                }
                String zza3 = zza(jSONObject, "contentDisposition");
                if (zza3 != null) {
                    setContentDisposition(zza3);
                }
                String zza4 = zza(jSONObject, "contentEncoding");
                if (zza4 != null) {
                    setContentEncoding(zza4);
                }
                String zza5 = zza(jSONObject, "contentLanguage");
                if (zza5 != null) {
                    setContentLanguage(zza5);
                }
                this.zzaq = true;
            }
        }

        Builder(JSONObject jSONObject, StorageReference storageReference) throws JSONException {
            this(jSONObject);
            StorageReference unused = this.zzap.zzd = storageReference;
        }

        @Nullable
        private static String zza(JSONObject jSONObject, String str) throws JSONException {
            if (!jSONObject.has(str) || jSONObject.isNull(str)) {
                return null;
            }
            return jSONObject.getString(str);
        }

        public StorageMetadata build() {
            return new StorageMetadata(this.zzaq);
        }

        public Builder setCacheControl(@Nullable String str) {
            zza unused = this.zzap.zzaj = zza.zzb(str);
            return this;
        }

        public Builder setContentDisposition(@Nullable String str) {
            zza unused = this.zzap.zzak = zza.zzb(str);
            return this;
        }

        public Builder setContentEncoding(@Nullable String str) {
            zza unused = this.zzap.zzal = zza.zzb(str);
            return this;
        }

        public Builder setContentLanguage(@Nullable String str) {
            zza unused = this.zzap.zzam = zza.zzb(str);
            return this;
        }

        public Builder setContentType(@Nullable String str) {
            zza unused = this.zzap.zzad = zza.zzb(str);
            return this;
        }

        public Builder setCustomMetadata(String str, String str2) {
            if (!this.zzap.zzan.zzc()) {
                zza unused = this.zzap.zzan = zza.zzb(new HashMap());
            }
            ((Map) this.zzap.zzan.getValue()).put(str, str2);
            return this;
        }
    }

    private static class zza<T> {
        @Nullable
        private final T value;
        private final boolean zzar;

        private zza(@Nullable T t, boolean z) {
            this.zzar = z;
            this.value = t;
        }

        static <T> zza<T> zza(T t) {
            return new zza<>(t, false);
        }

        static <T> zza<T> zzb(@Nullable T t) {
            return new zza<>(t, true);
        }

        /* access modifiers changed from: package-private */
        @Nullable
        public final T getValue() {
            return this.value;
        }

        /* access modifiers changed from: package-private */
        public final boolean zzc() {
            return this.zzar;
        }
    }

    public StorageMetadata() {
        this.mPath = null;
        this.zzaa = null;
        this.zzd = null;
        this.zzab = null;
        this.zzac = null;
        this.zzad = zza.zza("");
        this.zzae = null;
        this.zzaf = null;
        this.zzag = null;
        this.zzai = null;
        this.zzaj = zza.zza("");
        this.zzak = zza.zza("");
        this.zzal = zza.zza("");
        this.zzam = zza.zza("");
        this.zzan = zza.zza(Collections.emptyMap());
        this.zzao = null;
    }

    private StorageMetadata(@NonNull StorageMetadata storageMetadata, boolean z) {
        this.mPath = null;
        this.zzaa = null;
        this.zzd = null;
        this.zzab = null;
        this.zzac = null;
        this.zzad = zza.zza("");
        this.zzae = null;
        this.zzaf = null;
        this.zzag = null;
        this.zzai = null;
        this.zzaj = zza.zza("");
        this.zzak = zza.zza("");
        this.zzal = zza.zza("");
        this.zzam = zza.zza("");
        this.zzan = zza.zza(Collections.emptyMap());
        this.zzao = null;
        Preconditions.checkNotNull(storageMetadata);
        this.mPath = storageMetadata.mPath;
        this.zzaa = storageMetadata.zzaa;
        this.zzd = storageMetadata.zzd;
        this.zzab = storageMetadata.zzab;
        this.zzad = storageMetadata.zzad;
        this.zzaj = storageMetadata.zzaj;
        this.zzak = storageMetadata.zzak;
        this.zzal = storageMetadata.zzal;
        this.zzam = storageMetadata.zzam;
        this.zzan = storageMetadata.zzan;
        this.zzao = storageMetadata.zzao;
        if (z) {
            this.zzai = storageMetadata.zzai;
            this.zzah = storageMetadata.zzah;
            this.zzag = storageMetadata.zzag;
            this.zzaf = storageMetadata.zzaf;
            this.zzae = storageMetadata.zzae;
            this.zzac = storageMetadata.zzac;
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            this.zzao = str.split(",");
        }
    }

    @Nullable
    public String getBucket() {
        return this.zzab;
    }

    @Nullable
    public String getCacheControl() {
        return this.zzaj.getValue();
    }

    @Nullable
    public String getContentDisposition() {
        return this.zzak.getValue();
    }

    @Nullable
    public String getContentEncoding() {
        return this.zzal.getValue();
    }

    @Nullable
    public String getContentLanguage() {
        return this.zzam.getValue();
    }

    public String getContentType() {
        return this.zzad.getValue();
    }

    public long getCreationTimeMillis() {
        return zzk.zze(this.zzaf);
    }

    public String getCustomMetadata(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) this.zzan.getValue().get(str);
    }

    @NonNull
    public Set<String> getCustomMetadataKeys() {
        return this.zzan.getValue().keySet();
    }

    @Nullable
    @Deprecated
    public Uri getDownloadUrl() {
        List<Uri> downloadUrls = getDownloadUrls();
        if (downloadUrls == null || downloadUrls.size() <= 0) {
            return null;
        }
        return downloadUrls.get(0);
    }

    @Nullable
    @Deprecated
    public List<Uri> getDownloadUrls() {
        ArrayList arrayList = new ArrayList();
        if (!(this.zzao == null || this.zzd == null)) {
            try {
                String zzb = zzp.zzb(this.zzd.getStorage().getApp()).zzb(this.zzd.zze());
                if (!TextUtils.isEmpty(zzb)) {
                    for (String str : this.zzao) {
                        if (!TextUtils.isEmpty(str)) {
                            arrayList.add(Uri.parse(new StringBuilder(String.valueOf(zzb).length() + 17 + String.valueOf(str).length()).append(zzb).append("?alt=media&token=").append(str).toString()));
                        }
                    }
                }
            } catch (RemoteException e) {
                Log.e("StorageMetadata", "Unexpected error getting DownloadUrls.", e);
            }
        }
        return arrayList;
    }

    @Nullable
    public String getGeneration() {
        return this.zzac;
    }

    @Nullable
    public String getMd5Hash() {
        return this.zzai;
    }

    @Nullable
    public String getMetadataGeneration() {
        return this.zzae;
    }

    @Nullable
    public String getName() {
        String path = getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    @NonNull
    public String getPath() {
        return this.mPath != null ? this.mPath : "";
    }

    @Nullable
    public StorageReference getReference() {
        if (this.zzd != null || this.zzaa == null) {
            return this.zzd;
        }
        String bucket = getBucket();
        String path = getPath();
        if (TextUtils.isEmpty(bucket) || TextUtils.isEmpty(path)) {
            return null;
        }
        try {
            return new StorageReference(new Uri.Builder().scheme("gs").authority(bucket).encodedPath(zzg.zzb(path)).build(), this.zzaa);
        } catch (UnsupportedEncodingException e) {
            Log.e("StorageMetadata", new StringBuilder(String.valueOf(bucket).length() + 38 + String.valueOf(path).length()).append("Unable to create a valid default Uri. ").append(bucket).append(path).toString(), e);
            throw new IllegalStateException(e);
        }
    }

    public long getSizeBytes() {
        return this.zzah;
    }

    public long getUpdatedTimeMillis() {
        return zzk.zze(this.zzag);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final JSONObject zzb() throws JSONException {
        HashMap hashMap = new HashMap();
        if (this.zzad.zzc()) {
            hashMap.put("contentType", getContentType());
        }
        if (this.zzan.zzc()) {
            hashMap.put("metadata", new JSONObject(this.zzan.getValue()));
        }
        if (this.zzaj.zzc()) {
            hashMap.put("cacheControl", getCacheControl());
        }
        if (this.zzak.zzc()) {
            hashMap.put("contentDisposition", getContentDisposition());
        }
        if (this.zzal.zzc()) {
            hashMap.put("contentEncoding", getContentEncoding());
        }
        if (this.zzam.zzc()) {
            hashMap.put("contentLanguage", getContentLanguage());
        }
        return new JSONObject(hashMap);
    }
}
