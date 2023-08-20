package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultFirebaseUserMetadataCreator")
public final class zzm implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzm> CREATOR = new zzn();
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo8007id = 2)
    private long zzjn;
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", mo8007id = 1)
    private long zzla;

    @SafeParcelable.Constructor
    public zzm(@SafeParcelable.Param(mo8010id = 1) long j, @SafeParcelable.Param(mo8010id = 2) long j2) {
        this.zzla = j;
        this.zzjn = j2;
    }

    public static zzm zza(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzm(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException e) {
            return null;
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final long getCreationTimestamp() {
        return this.zzjn;
    }

    public final long getLastSignInTimestamp() {
        return this.zzla;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getLastSignInTimestamp());
        SafeParcelWriter.writeLong(parcel, 2, getCreationTimestamp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final JSONObject zzbe() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zzla);
            jSONObject.put("creationTimestamp", this.zzjn);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
