package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "StringListCreator")
public final class zzbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbd> CREATOR = new zzbe();
    @SafeParcelable.VersionField(mo8013id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getValues", mo8007id = 2)
    private List<String> zzkc;

    public zzbd() {
        this((List<String>) null);
    }

    @SafeParcelable.Constructor
    zzbd(@SafeParcelable.Param(mo8010id = 1) int i, @SafeParcelable.Param(mo8010id = 2) List<String> list) {
        this.versionCode = i;
        if (list == null || list.isEmpty()) {
            this.zzkc = Collections.emptyList();
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                list.set(i3, Strings.emptyToNull(list.get(i3)));
                i2 = i3 + 1;
            } else {
                this.zzkc = Collections.unmodifiableList(list);
                return;
            }
        }
    }

    private zzbd(@Nullable List<String> list) {
        this.versionCode = 1;
        this.zzkc = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.zzkc.addAll(list);
        }
    }

    public static zzbd zza(zzbd zzbd) {
        return new zzbd(zzbd != null ? zzbd.zzkc : null);
    }

    public static zzbd zzbb() {
        return new zzbd((List<String>) null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzkc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final List<String> zzba() {
        return this.zzkc;
    }
}
