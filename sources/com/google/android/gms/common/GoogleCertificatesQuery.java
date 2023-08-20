package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GoogleCertificates;
import com.google.android.gms.common.internal.ICertData;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "GoogleCertificatesQueryCreator")
public class GoogleCertificatesQuery extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleCertificatesQuery> CREATOR = new GoogleCertificatesQueryCreator();
    @SafeParcelable.Field(getter = "getCallingPackage", mo8007id = 1)
    private final String zzbh;
    @SafeParcelable.Field(getter = "getCallingCertificateBinder", mo8007id = 2, type = "android.os.IBinder")
    @Nullable
    private final GoogleCertificates.CertData zzbi;
    @SafeParcelable.Field(getter = "getAllowTestKeys", mo8007id = 3)
    private final boolean zzbj;

    @SafeParcelable.Constructor
    GoogleCertificatesQuery(@SafeParcelable.Param(mo8010id = 1) String str, @SafeParcelable.Param(mo8010id = 2) @Nullable IBinder iBinder, @SafeParcelable.Param(mo8010id = 3) boolean z) {
        this.zzbh = str;
        this.zzbi = zza(iBinder);
        this.zzbj = z;
    }

    GoogleCertificatesQuery(String str, @Nullable GoogleCertificates.CertData certData, boolean z) {
        this.zzbh = str;
        this.zzbi = certData;
        this.zzbj = z;
    }

    @Nullable
    private static GoogleCertificates.CertData zza(@Nullable IBinder iBinder) {
        zzb zzb;
        if (iBinder == null) {
            return null;
        }
        try {
            IObjectWrapper bytesWrapped = ICertData.Stub.asInterface(iBinder).getBytesWrapped();
            byte[] bArr = bytesWrapped == null ? null : (byte[]) ObjectWrapper.unwrap(bytesWrapped);
            if (bArr != null) {
                zzb = new zzb(bArr);
            } else {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                zzb = null;
            }
            return zzb;
        } catch (RemoteException e) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            return null;
        }
    }

    public boolean getAllowTestKeys() {
        return this.zzbj;
    }

    @Nullable
    public IBinder getCallingCertificateBinder() {
        if (this.zzbi != null) {
            return this.zzbi.asBinder();
        }
        Log.w("GoogleCertificatesQuery", "certificate binder is null");
        return null;
    }

    public String getCallingPackage() {
        return this.zzbh;
    }

    @Nullable
    public GoogleCertificates.CertData getCertificate() {
        return this.zzbi;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getCallingPackage(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, getCallingCertificateBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, getAllowTestKeys());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
