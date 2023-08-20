package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzao;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultFirebaseUserCreator")
public class zzk extends FirebaseUser {
    public static final Parcelable.Creator<zzk> CREATOR = new zzl();
    @SafeParcelable.Field(getter = "isNewUser", mo8007id = 10)
    private boolean zzai;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", mo8007id = 11)
    private zzd zzjp;
    @SafeParcelable.Field(getter = "getCachedTokenState", mo8007id = 1)
    private zzao zzkr;
    @SafeParcelable.Field(getter = "getDefaultAuthUserInfo", mo8007id = 2)
    private zzh zzks;
    @SafeParcelable.Field(getter = "getFirebaseAppName", mo8007id = 3)
    private String zzkt;
    @SafeParcelable.Field(getter = "getUserType", mo8007id = 4)
    private String zzku;
    @SafeParcelable.Field(getter = "getUserInfos", mo8007id = 5)
    private List<zzh> zzkv;
    @SafeParcelable.Field(getter = "getProviders", mo8007id = 6)
    private List<String> zzkw;
    @SafeParcelable.Field(getter = "getCurrentVersion", mo8007id = 7)
    private String zzkx;
    @SafeParcelable.Field(getter = "isAnonymous", mo8007id = 8)
    private boolean zzky;
    @SafeParcelable.Field(getter = "getMetadata", mo8007id = 9)
    private zzm zzkz;

    @SafeParcelable.Constructor
    zzk(@SafeParcelable.Param(mo8010id = 1) zzao zzao, @SafeParcelable.Param(mo8010id = 2) zzh zzh, @SafeParcelable.Param(mo8010id = 3) String str, @SafeParcelable.Param(mo8010id = 4) String str2, @SafeParcelable.Param(mo8010id = 5) List<zzh> list, @SafeParcelable.Param(mo8010id = 6) List<String> list2, @SafeParcelable.Param(mo8010id = 7) String str3, @SafeParcelable.Param(mo8010id = 8) boolean z, @SafeParcelable.Param(mo8010id = 9) zzm zzm, @SafeParcelable.Param(mo8010id = 10) boolean z2, @SafeParcelable.Param(mo8010id = 11) zzd zzd) {
        this.zzkr = zzao;
        this.zzks = zzh;
        this.zzkt = str;
        this.zzku = str2;
        this.zzkv = list;
        this.zzkw = list2;
        this.zzkx = str3;
        this.zzky = z;
        this.zzkz = zzm;
        this.zzai = z2;
        this.zzjp = zzd;
    }

    public zzk(@NonNull FirebaseApp firebaseApp, @NonNull List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzkt = firebaseApp.getName();
        this.zzku = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzkx = "2";
        zza(list);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzks.getDisplayName();
    }

    @Nullable
    public String getEmail() {
        return this.zzks.getEmail();
    }

    public FirebaseUserMetadata getMetadata() {
        return this.zzkz;
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzks.getPhoneNumber();
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzks.getPhotoUrl();
    }

    @NonNull
    public List<? extends UserInfo> getProviderData() {
        return this.zzkv;
    }

    @NonNull
    public String getProviderId() {
        return this.zzks.getProviderId();
    }

    @Nullable
    public final List<String> getProviders() {
        return this.zzkw;
    }

    @NonNull
    public String getUid() {
        return this.zzks.getUid();
    }

    public boolean isAnonymous() {
        return this.zzky;
    }

    public boolean isEmailVerified() {
        return this.zzks.isEmailVerified();
    }

    public final boolean isNewUser() {
        return this.zzai;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzn(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzks, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzkt, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzku, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzkv, false);
        SafeParcelWriter.writeStringList(parcel, 6, getProviders(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzkx, false);
        SafeParcelWriter.writeBoolean(parcel, 8, isAnonymous());
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzai);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzjp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final FirebaseUser zza(@NonNull List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zzkv = new ArrayList(list.size());
        this.zzkw = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzks = (zzh) userInfo;
            } else {
                this.zzkw.add(userInfo.getProviderId());
            }
            this.zzkv.add((zzh) userInfo);
        }
        if (this.zzks == null) {
            this.zzks = this.zzkv.get(0);
        }
        return this;
    }

    public final /* synthetic */ FirebaseUser zza(boolean z) {
        this.zzky = z;
        return this;
    }

    public final void zza(@NonNull zzao zzao) {
        this.zzkr = (zzao) Preconditions.checkNotNull(zzao);
    }

    public final void zza(zzm zzm) {
        this.zzkz = zzm;
    }

    public final zzk zzae(@NonNull String str) {
        this.zzkx = str;
        return this;
    }

    @Nullable
    public final zzd zzat() {
        return this.zzjp;
    }

    public final List<zzh> zzbd() {
        return this.zzkv;
    }

    public final void zzc(zzd zzd) {
        this.zzjp = zzd;
    }

    public final void zzf(boolean z) {
        this.zzai = z;
    }

    @NonNull
    public final FirebaseApp zzm() {
        return FirebaseApp.getInstance(this.zzkt);
    }

    @NonNull
    public final zzao zzn() {
        return this.zzkr;
    }

    @NonNull
    public final String zzo() {
        return this.zzkr.toJson();
    }

    @NonNull
    public final String zzp() {
        return zzn().zzau();
    }
}
