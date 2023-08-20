package com.google.firebase.database.connection.idl;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.firebase_database.zzb;

public abstract class zzu extends zzb implements zzt {
    public zzu() {
        super("com.google.firebase.database.connection.idl.IPersistentConnection");
    }

    public static zzt asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.database.connection.idl.IPersistentConnection");
        return queryLocalInterface instanceof zzt ? (zzt) queryLocalInterface : new zzv(iBinder);
    }

    /* JADX WARNING: type inference failed for: r6v0 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r6v3, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v5 */
    /* JADX WARNING: type inference failed for: r6v6, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r6v9, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v14 */
    /* JADX WARNING: type inference failed for: r6v15, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r6v18, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22, types: [com.google.firebase.database.connection.idl.zzah] */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: type inference failed for: r6v25, types: [com.google.firebase.database.connection.idl.zzw] */
    /* JADX WARNING: type inference failed for: r6v26 */
    /* JADX WARNING: type inference failed for: r6v27 */
    /* JADX WARNING: type inference failed for: r6v28 */
    /* JADX WARNING: type inference failed for: r6v29 */
    /* JADX WARNING: type inference failed for: r6v30 */
    /* JADX WARNING: type inference failed for: r6v31 */
    /* JADX WARNING: type inference failed for: r6v32 */
    /* JADX WARNING: type inference failed for: r6v33 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r9, android.os.Parcel r10, android.os.Parcel r11, int r12) throws android.os.RemoteException {
        /*
            r8 = this;
            r6 = 0
            switch(r9) {
                case 1: goto L_0x0006;
                case 2: goto L_0x0054;
                case 3: goto L_0x005b;
                case 4: goto L_0x0062;
                case 5: goto L_0x0074;
                case 6: goto L_0x00c1;
                case 7: goto L_0x00d5;
                case 8: goto L_0x00dd;
                case 9: goto L_0x010b;
                case 10: goto L_0x013d;
                case 11: goto L_0x016b;
                case 12: goto L_0x0199;
                case 13: goto L_0x01c7;
                case 14: goto L_0x01ed;
                case 15: goto L_0x01f9;
                case 16: goto L_0x0205;
                case 17: goto L_0x0069;
                default: goto L_0x0004;
            }
        L_0x0004:
            r0 = 0
        L_0x0005:
            return r0
        L_0x0006:
            android.os.Parcelable$Creator<com.google.firebase.database.connection.idl.zzc> r0 = com.google.firebase.database.connection.idl.zzc.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_database.zzc.zza((android.os.Parcel) r10, r0)
            com.google.firebase.database.connection.idl.zzc r0 = (com.google.firebase.database.connection.idl.zzc) r0
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x002b
            r2 = r6
        L_0x0015:
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r10.readStrongBinder()
            if (r4 != 0) goto L_0x0040
        L_0x0023:
            r8.setup(r0, r2, r3, r6)
            r11.writeNoException()
        L_0x0029:
            r0 = 1
            goto L_0x0005
        L_0x002b:
            java.lang.String r1 = "com.google.firebase.database.connection.idl.IConnectionAuthTokenProvider"
            android.os.IInterface r1 = r2.queryLocalInterface(r1)
            boolean r3 = r1 instanceof com.google.firebase.database.connection.idl.zzk
            if (r3 == 0) goto L_0x0039
            com.google.firebase.database.connection.idl.zzk r1 = (com.google.firebase.database.connection.idl.zzk) r1
            r2 = r1
            goto L_0x0015
        L_0x0039:
            com.google.firebase.database.connection.idl.zzm r1 = new com.google.firebase.database.connection.idl.zzm
            r1.<init>(r2)
            r2 = r1
            goto L_0x0015
        L_0x0040:
            java.lang.String r1 = "com.google.firebase.database.connection.idl.IPersistentConnectionDelegate"
            android.os.IInterface r1 = r4.queryLocalInterface(r1)
            boolean r5 = r1 instanceof com.google.firebase.database.connection.idl.zzw
            if (r5 == 0) goto L_0x004e
            com.google.firebase.database.connection.idl.zzw r1 = (com.google.firebase.database.connection.idl.zzw) r1
            r6 = r1
            goto L_0x0023
        L_0x004e:
            com.google.firebase.database.connection.idl.zzy r6 = new com.google.firebase.database.connection.idl.zzy
            r6.<init>(r4)
            goto L_0x0023
        L_0x0054:
            r8.initialize()
            r11.writeNoException()
            goto L_0x0029
        L_0x005b:
            r8.shutdown()
            r11.writeNoException()
            goto L_0x0029
        L_0x0062:
            r8.refreshAuthToken()
            r11.writeNoException()
            goto L_0x0029
        L_0x0069:
            java.lang.String r0 = r10.readString()
            r8.refreshAuthToken2(r0)
            r11.writeNoException()
            goto L_0x0029
        L_0x0074:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r4 = r10.readStrongBinder()
            if (r4 != 0) goto L_0x0099
            r3 = r6
        L_0x0087:
            long r4 = r10.readLong()
            android.os.IBinder r7 = r10.readStrongBinder()
            if (r7 != 0) goto L_0x00ad
        L_0x0091:
            r0 = r8
            r0.listen(r1, r2, r3, r4, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x0099:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IListenHashProvider"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.firebase.database.connection.idl.zzq
            if (r3 == 0) goto L_0x00a7
            com.google.firebase.database.connection.idl.zzq r0 = (com.google.firebase.database.connection.idl.zzq) r0
            r3 = r0
            goto L_0x0087
        L_0x00a7:
            com.google.firebase.database.connection.idl.zzs r3 = new com.google.firebase.database.connection.idl.zzs
            r3.<init>(r4)
            goto L_0x0087
        L_0x00ad:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r7.queryLocalInterface(r0)
            boolean r6 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r6 == 0) goto L_0x00bb
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x0091
        L_0x00bb:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r7)
            goto L_0x0091
        L_0x00c1:
            java.util.ArrayList r0 = r10.createStringArrayList()
            android.os.IBinder r1 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r8.unlisten(r0, r1)
            r11.writeNoException()
            goto L_0x0029
        L_0x00d5:
            r8.purgeOutstandingWrites()
            r11.writeNoException()
            goto L_0x0029
        L_0x00dd:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x00f7
        L_0x00ef:
            r8.put(r1, r2, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x00f7:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r4 == 0) goto L_0x0105
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x00ef
        L_0x0105:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r3)
            goto L_0x00ef
        L_0x010b:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            java.lang.String r3 = r10.readString()
            android.os.IBinder r4 = r10.readStrongBinder()
            if (r4 != 0) goto L_0x0129
        L_0x0121:
            r8.compareAndPut(r1, r2, r3, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x0129:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r5 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r5 == 0) goto L_0x0137
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x0121
        L_0x0137:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r4)
            goto L_0x0121
        L_0x013d:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x0157
        L_0x014f:
            r8.merge(r1, r2, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x0157:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r4 == 0) goto L_0x0165
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x014f
        L_0x0165:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r3)
            goto L_0x014f
        L_0x016b:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x0185
        L_0x017d:
            r8.onDisconnectPut(r1, r2, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x0185:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r4 == 0) goto L_0x0193
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x017d
        L_0x0193:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r3)
            goto L_0x017d
        L_0x0199:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r0 = r10.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r3 = r10.readStrongBinder()
            if (r3 != 0) goto L_0x01b3
        L_0x01ab:
            r8.onDisconnectMerge(r1, r2, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x01b3:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r3.queryLocalInterface(r0)
            boolean r4 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r4 == 0) goto L_0x01c1
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x01ab
        L_0x01c1:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r3)
            goto L_0x01ab
        L_0x01c7:
            java.util.ArrayList r1 = r10.createStringArrayList()
            android.os.IBinder r2 = r10.readStrongBinder()
            if (r2 != 0) goto L_0x01d9
        L_0x01d1:
            r8.onDisconnectCancel(r1, r6)
            r11.writeNoException()
            goto L_0x0029
        L_0x01d9:
            java.lang.String r0 = "com.google.firebase.database.connection.idl.IRequestResultCallback"
            android.os.IInterface r0 = r2.queryLocalInterface(r0)
            boolean r3 = r0 instanceof com.google.firebase.database.connection.idl.zzah
            if (r3 == 0) goto L_0x01e7
            com.google.firebase.database.connection.idl.zzah r0 = (com.google.firebase.database.connection.idl.zzah) r0
            r6 = r0
            goto L_0x01d1
        L_0x01e7:
            com.google.firebase.database.connection.idl.zzaj r6 = new com.google.firebase.database.connection.idl.zzaj
            r6.<init>(r2)
            goto L_0x01d1
        L_0x01ed:
            java.lang.String r0 = r10.readString()
            r8.interrupt(r0)
            r11.writeNoException()
            goto L_0x0029
        L_0x01f9:
            java.lang.String r0 = r10.readString()
            r8.resume(r0)
            r11.writeNoException()
            goto L_0x0029
        L_0x0205:
            java.lang.String r0 = r10.readString()
            boolean r0 = r8.isInterrupted(r0)
            r11.writeNoException()
            com.google.android.gms.internal.firebase_database.zzc.zza((android.os.Parcel) r11, (boolean) r0)
            goto L_0x0029
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.connection.idl.zzu.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
