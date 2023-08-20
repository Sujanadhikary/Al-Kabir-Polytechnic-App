package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zze;
import com.google.android.gms.internal.firebase_storage.zzf;
import com.google.android.gms.internal.firebase_storage.zzk;
import com.google.android.gms.internal.firebase_storage.zzq;
import com.google.firebase.storage.StorageTask;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;

public class UploadTask extends StorageTask<TaskSnapshot> {
    private volatile StorageMetadata zzap;
    private final Uri zzcu;
    private final long zzcv;
    private final zze zzcw;
    private final AtomicLong zzcx = new AtomicLong(0);
    private int zzcy = 262144;
    private boolean zzcz;
    /* access modifiers changed from: private */
    public final StorageReference zzd;
    private volatile Uri zzda = null;
    private volatile Exception zzdb = null;
    private volatile String zzdc;
    private zzf zzf;
    private volatile Exception zzk = null;
    private volatile int zzm = 0;

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final StorageMetadata zzap;
        private final Uri zzda;
        private final long zzdf;

        TaskSnapshot(Exception exc, long j, Uri uri, StorageMetadata storageMetadata) {
            super(exc);
            this.zzdf = j;
            this.zzda = uri;
            this.zzap = storageMetadata;
        }

        public long getBytesTransferred() {
            return this.zzdf;
        }

        @Nullable
        public Uri getDownloadUrl() {
            StorageMetadata metadata = getMetadata();
            if (metadata != null) {
                return metadata.getDownloadUrl();
            }
            return null;
        }

        @Nullable
        public StorageMetadata getMetadata() {
            return this.zzap;
        }

        public long getTotalByteCount() {
            return UploadTask.this.getTotalByteCount();
        }

        @Nullable
        public Uri getUploadSessionUri() {
            return this.zzda;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: android.content.Context} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v13, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v17, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v28, resolved type: long} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    UploadTask(com.google.firebase.storage.StorageReference r12, com.google.firebase.storage.StorageMetadata r13, android.net.Uri r14, android.net.Uri r15) {
        /*
            r11 = this;
            r11.<init>()
            java.util.concurrent.atomic.AtomicLong r0 = new java.util.concurrent.atomic.AtomicLong
            r2 = 0
            r0.<init>(r2)
            r11.zzcx = r0
            r0 = 262144(0x40000, float:3.67342E-40)
            r11.zzcy = r0
            r0 = 0
            r11.zzda = r0
            r0 = 0
            r11.zzk = r0
            r0 = 0
            r11.zzdb = r0
            r0 = 0
            r11.zzm = r0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)
            r11.zzd = r12
            r11.zzap = r13
            r11.zzcu = r14
            r4 = 0
            com.google.android.gms.internal.firebase_storage.zzf r0 = new com.google.android.gms.internal.firebase_storage.zzf
            com.google.firebase.storage.StorageReference r1 = r11.zzd
            com.google.firebase.storage.FirebaseStorage r1 = r1.getStorage()
            com.google.firebase.FirebaseApp r1 = r1.getApp()
            com.google.firebase.storage.StorageReference r2 = r11.zzd
            com.google.firebase.storage.FirebaseStorage r2 = r2.getStorage()
            long r2 = r2.getMaxUploadRetryTimeMillis()
            r0.<init>(r1, r2)
            r11.zzf = r0
            r0 = -1
            com.google.firebase.storage.StorageReference r2 = r11.zzd     // Catch:{ FileNotFoundException -> 0x00f5 }
            com.google.firebase.storage.FirebaseStorage r2 = r2.getStorage()     // Catch:{ FileNotFoundException -> 0x00f5 }
            com.google.firebase.FirebaseApp r2 = r2.getApp()     // Catch:{ FileNotFoundException -> 0x00f5 }
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ FileNotFoundException -> 0x00f5 }
            android.content.ContentResolver r5 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00f5 }
            android.net.Uri r2 = r11.zzcu     // Catch:{ NullPointerException -> 0x0094, IOException -> 0x00a2 }
            java.lang.String r3 = "r"
            android.os.ParcelFileDescriptor r2 = r5.openFileDescriptor(r2, r3)     // Catch:{ NullPointerException -> 0x0094, IOException -> 0x00a2 }
            if (r2 == 0) goto L_0x0069
            long r0 = r2.getStatSize()     // Catch:{ NullPointerException -> 0x0094, IOException -> 0x00a2 }
            r2.close()     // Catch:{ NullPointerException -> 0x0094, IOException -> 0x00a2 }
        L_0x0069:
            android.net.Uri r2 = r11.zzcu     // Catch:{ FileNotFoundException -> 0x00f5 }
            java.io.InputStream r3 = r5.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x00f5 }
            if (r3 == 0) goto L_0x0101
            r4 = -1
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x007e
            int r2 = r3.available()     // Catch:{ IOException -> 0x00f3 }
            if (r2 < 0) goto L_0x007e
            long r0 = (long) r2
        L_0x007e:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x00fb }
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00fb }
        L_0x0083:
            r11.zzcv = r0
            com.google.android.gms.internal.firebase_storage.zze r0 = new com.google.android.gms.internal.firebase_storage.zze
            r1 = 262144(0x40000, float:3.67342E-40)
            r0.<init>(r2, r1)
            r11.zzcw = r0
            r0 = 1
            r11.zzcz = r0
            r11.zzda = r15
            return
        L_0x0094:
            r2 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            java.lang.String r1 = "UploadTask"
            java.lang.String r6 = "NullPointerException during file size calculation."
            android.util.Log.w(r1, r6, r0)     // Catch:{ FileNotFoundException -> 0x00c9 }
            r0 = -1
            goto L_0x0069
        L_0x00a2:
            r2 = move-exception
            r9 = r2
            r2 = r0
            r0 = r9
            java.lang.String r6 = "UploadTask"
            java.lang.String r7 = "could not retrieve file size for upload "
            android.net.Uri r1 = r11.zzcu     // Catch:{ FileNotFoundException -> 0x00c9 }
            java.lang.String r1 = r1.toString()     // Catch:{ FileNotFoundException -> 0x00c9 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ FileNotFoundException -> 0x00c9 }
            int r8 = r1.length()     // Catch:{ FileNotFoundException -> 0x00c9 }
            if (r8 == 0) goto L_0x00c3
            java.lang.String r1 = r7.concat(r1)     // Catch:{ FileNotFoundException -> 0x00c9 }
        L_0x00be:
            android.util.Log.w(r6, r1, r0)     // Catch:{ FileNotFoundException -> 0x00c9 }
            r0 = r2
            goto L_0x0069
        L_0x00c3:
            java.lang.String r1 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00c9 }
            r1.<init>(r7)     // Catch:{ FileNotFoundException -> 0x00c9 }
            goto L_0x00be
        L_0x00c9:
            r0 = move-exception
            r1 = r4
            r4 = r0
        L_0x00cc:
            java.lang.String r5 = "UploadTask"
            java.lang.String r6 = "could not locate file for uploading:"
            android.net.Uri r0 = r11.zzcu
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r7 = r0.length()
            if (r7 == 0) goto L_0x00ed
            java.lang.String r0 = r6.concat(r0)
        L_0x00e4:
            android.util.Log.e(r5, r0)
            r11.zzk = r4
            r9 = r2
            r2 = r1
            r0 = r9
            goto L_0x0083
        L_0x00ed:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r6)
            goto L_0x00e4
        L_0x00f3:
            r2 = move-exception
            goto L_0x007e
        L_0x00f5:
            r2 = move-exception
            r9 = r2
            r2 = r0
            r1 = r4
            r4 = r9
            goto L_0x00cc
        L_0x00fb:
            r2 = move-exception
            r4 = r2
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00cc
        L_0x0101:
            r2 = r3
            goto L_0x0083
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.<init>(com.google.firebase.storage.StorageReference, com.google.firebase.storage.StorageMetadata, android.net.Uri, android.net.Uri):void");
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, InputStream inputStream) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(inputStream);
        this.zzcv = -1;
        this.zzd = storageReference;
        this.zzap = storageMetadata;
        this.zzcw = new zze(inputStream, 262144);
        this.zzcz = false;
        this.zzcu = null;
        this.zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxUploadRetryTimeMillis());
    }

    UploadTask(StorageReference storageReference, StorageMetadata storageMetadata, byte[] bArr) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(bArr);
        this.zzcv = (long) bArr.length;
        this.zzd = storageReference;
        this.zzap = storageMetadata;
        this.zzcu = null;
        this.zzcw = new zze(new ByteArrayInputStream(bArr), 262144);
        this.zzcz = true;
        this.zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxUploadRetryTimeMillis());
    }

    private final boolean zza(boolean z) {
        try {
            zzq zzb = this.zzd.zzd().zzb(this.zzd.zze(), this.zzda.toString());
            if ("final".equals(this.zzdc)) {
                return false;
            }
            if (z) {
                if (!zzc(zzb)) {
                    return false;
                }
            } else if (!zzb(zzb)) {
                return false;
            }
            if ("final".equals(zzb.zzh("X-Goog-Upload-Status"))) {
                this.zzk = new IOException("The server has terminated the upload session");
                return false;
            }
            String zzh = zzb.zzh("X-Goog-Upload-Size-Received");
            long parseLong = !TextUtils.isEmpty(zzh) ? Long.parseLong(zzh) : 0;
            long j = this.zzcx.get();
            if (j > parseLong) {
                this.zzk = new IOException("Unexpected error. The server lost a chunk update.");
                return false;
            }
            if (j < parseLong) {
                try {
                    if (((long) this.zzcw.zzb((int) (parseLong - j))) != parseLong - j) {
                        this.zzk = new IOException("Unexpected end of stream encountered.");
                        return false;
                    } else if (!this.zzcx.compareAndSet(j, parseLong)) {
                        Log.e("UploadTask", "Somehow, the uploaded bytes changed during an uploaded.  This should nothappen");
                        this.zzk = new IllegalStateException("uploaded bytes changed unexpectedly.");
                        return false;
                    }
                } catch (IOException e) {
                    Log.e("UploadTask", "Unable to recover position in Stream during resumable upload", e);
                    this.zzk = e;
                    return false;
                }
            }
            return true;
        } catch (RemoteException e2) {
            Log.e("UploadTask", "Unable to recover status during resumable upload", e2);
            this.zzk = e2;
            return false;
        }
    }

    private final boolean zzb(zzq zzq) {
        zzq.zza(zzk.zza(this.zzd.getStorage().getApp()), this.zzd.getStorage().getApp().getApplicationContext());
        return zzd(zzq);
    }

    private final boolean zzc(zzq zzq) {
        this.zzf.zza(zzq, true);
        return zzd(zzq);
    }

    private final boolean zzd(zzq zzq) {
        int resultCode = zzq.getResultCode();
        if (zzf.zze(resultCode)) {
            resultCode = -2;
        }
        this.zzm = resultCode;
        this.zzdb = zzq.getException();
        this.zzdc = zzq.zzh("X-Goog-Upload-Status");
        int i = this.zzm;
        return (i == 308 || (i >= 200 && i < 300)) && this.zzdb == null;
    }

    private final boolean zzq() {
        if (zzg() == 128) {
            return false;
        }
        if (Thread.interrupted()) {
            this.zzk = new InterruptedException();
            zza(64, false);
            return false;
        } else if (zzg() == 32) {
            zza(256, false);
            return false;
        } else if (zzg() == 8) {
            zza(16, false);
            return false;
        } else if (!zzr()) {
            return false;
        } else {
            if (this.zzda == null) {
                if (this.zzk == null) {
                    this.zzk = new IllegalStateException("Unable to obtain an upload URL.");
                }
                zza(64, false);
                return false;
            } else if (this.zzk != null) {
                zza(64, false);
                return false;
            } else {
                if (!(this.zzdb != null || this.zzm < 200 || this.zzm >= 300) || zza(true)) {
                    return true;
                }
                if (!zzr()) {
                    return false;
                }
                zza(64, false);
                return false;
            }
        }
    }

    private final boolean zzr() {
        if (!"final".equals(this.zzdc)) {
            return true;
        }
        if (this.zzk == null) {
            this.zzk = new IOException("The server has terminated the upload session", this.zzdb);
        }
        zza(64, false);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final StorageReference getStorage() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final long getTotalByteCount() {
        return this.zzcv;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCanceled() {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase_storage.zzf r0 = r4.zzf
            r0.cancel()
            r1 = 0
            android.net.Uri r0 = r4.zzda
            if (r0 == 0) goto L_0x003e
            com.google.firebase.storage.StorageReference r0 = r4.zzd     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.internal.firebase_storage.zzp r0 = r0.zzd()     // Catch:{ RemoteException -> 0x0036 }
            com.google.firebase.storage.StorageReference r2 = r4.zzd     // Catch:{ RemoteException -> 0x0036 }
            android.net.Uri r2 = r2.zze()     // Catch:{ RemoteException -> 0x0036 }
            android.net.Uri r3 = r4.zzda     // Catch:{ RemoteException -> 0x0036 }
            java.lang.String r3 = r3.toString()     // Catch:{ RemoteException -> 0x0036 }
            com.google.android.gms.internal.firebase_storage.zzq r0 = r0.zza((android.net.Uri) r2, (java.lang.String) r3)     // Catch:{ RemoteException -> 0x0036 }
        L_0x0020:
            if (r0 == 0) goto L_0x002a
            com.google.firebase.storage.zzad r1 = new com.google.firebase.storage.zzad
            r1.<init>(r4, r0)
            com.google.firebase.storage.zzu.zza(r1)
        L_0x002a:
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.RESULT_CANCELED
            com.google.firebase.storage.StorageException r0 = com.google.firebase.storage.StorageException.fromErrorStatus(r0)
            r4.zzk = r0
            super.onCanceled()
            return
        L_0x0036:
            r0 = move-exception
            java.lang.String r2 = "UploadTask"
            java.lang.String r3 = "Unable to create chunk upload request"
            android.util.Log.e(r2, r3, r0)
        L_0x003e:
            r0 = r1
            goto L_0x0020
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.onCanceled():void");
    }

    /* access modifiers changed from: protected */
    public void resetState() {
        this.zzk = null;
        this.zzdb = null;
        this.zzm = 0;
        this.zzdc = null;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0199 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01a4 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0099 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            r1 = 0
            r9 = 4
            r8 = 0
            com.google.android.gms.internal.firebase_storage.zzf r0 = r10.zzf
            r0.reset()
            boolean r0 = r10.zza((int) r9, (boolean) r8)
            if (r0 != 0) goto L_0x0016
            java.lang.String r0 = "UploadTask"
            java.lang.String r1 = "The upload cannot continue as it is not in a valid state."
            android.util.Log.d(r0, r1)
        L_0x0015:
            return
        L_0x0016:
            com.google.firebase.storage.StorageReference r0 = r10.zzd
            com.google.firebase.storage.StorageReference r0 = r0.getParent()
            if (r0 != 0) goto L_0x0027
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r2 = "Cannot upload to getRoot. You should upload to a storage location such as .getReference('image.png').putFile..."
            r0.<init>(r2)
            r10.zzk = r0
        L_0x0027:
            java.lang.Exception r0 = r10.zzk
            if (r0 != 0) goto L_0x0015
            android.net.Uri r0 = r10.zzda
            if (r0 != 0) goto L_0x0111
            com.google.firebase.storage.StorageMetadata r0 = r10.zzap
            if (r0 == 0) goto L_0x01cd
            com.google.firebase.storage.StorageMetadata r0 = r10.zzap
            java.lang.String r0 = r0.getContentType()
        L_0x0039:
            android.net.Uri r2 = r10.zzcu
            if (r2 == 0) goto L_0x005b
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x005b
            com.google.firebase.storage.StorageReference r0 = r10.zzd
            com.google.firebase.storage.FirebaseStorage r0 = r0.getStorage()
            com.google.firebase.FirebaseApp r0 = r0.getApp()
            android.content.Context r0 = r0.getApplicationContext()
            android.content.ContentResolver r0 = r0.getContentResolver()
            android.net.Uri r2 = r10.zzcu
            java.lang.String r0 = r0.getType(r2)
        L_0x005b:
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 == 0) goto L_0x0063
            java.lang.String r0 = "application/octet-stream"
        L_0x0063:
            com.google.firebase.storage.StorageReference r2 = r10.zzd     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            com.google.android.gms.internal.firebase_storage.zzp r2 = r2.zzd()     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            com.google.firebase.storage.StorageReference r3 = r10.zzd     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            android.net.Uri r3 = r3.zze()     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            com.google.firebase.storage.StorageMetadata r4 = r10.zzap     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            if (r4 == 0) goto L_0x0079
            com.google.firebase.storage.StorageMetadata r1 = r10.zzap     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            org.json.JSONObject r1 = r1.zzb()     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
        L_0x0079:
            com.google.android.gms.internal.firebase_storage.zzq r0 = r2.zza(r3, r1, r0)     // Catch:{ JSONException -> 0x01ca, RemoteException -> 0x0106 }
            boolean r1 = r10.zzc(r0)
            if (r1 == 0) goto L_0x0095
            java.lang.String r1 = "X-Goog-Upload-URL"
            java.lang.String r0 = r0.zzh(r1)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x0095
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r10.zzda = r0
        L_0x0095:
            boolean r0 = r10.zzq()
        L_0x0099:
            if (r0 == 0) goto L_0x01aa
            com.google.android.gms.internal.firebase_storage.zze r0 = r10.zzcw     // Catch:{ IOException -> 0x0120 }
            int r1 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            r0.zzc(r1)     // Catch:{ IOException -> 0x0120 }
            int r0 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            com.google.android.gms.internal.firebase_storage.zze r1 = r10.zzcw     // Catch:{ IOException -> 0x0120 }
            int r1 = r1.available()     // Catch:{ IOException -> 0x0120 }
            int r6 = java.lang.Math.min(r0, r1)     // Catch:{ IOException -> 0x0120 }
            com.google.firebase.storage.StorageReference r0 = r10.zzd     // Catch:{ RemoteException -> 0x0115 }
            com.google.android.gms.internal.firebase_storage.zzp r0 = r0.zzd()     // Catch:{ RemoteException -> 0x0115 }
            com.google.firebase.storage.StorageReference r1 = r10.zzd     // Catch:{ RemoteException -> 0x0115 }
            android.net.Uri r1 = r1.zze()     // Catch:{ RemoteException -> 0x0115 }
            android.net.Uri r2 = r10.zzda     // Catch:{ RemoteException -> 0x0115 }
            java.lang.String r2 = r2.toString()     // Catch:{ RemoteException -> 0x0115 }
            com.google.android.gms.internal.firebase_storage.zze r3 = r10.zzcw     // Catch:{ RemoteException -> 0x0115 }
            byte[] r3 = r3.zzu()     // Catch:{ RemoteException -> 0x0115 }
            java.util.concurrent.atomic.AtomicLong r4 = r10.zzcx     // Catch:{ RemoteException -> 0x0115 }
            long r4 = r4.get()     // Catch:{ RemoteException -> 0x0115 }
            com.google.android.gms.internal.firebase_storage.zze r7 = r10.zzcw     // Catch:{ RemoteException -> 0x0115 }
            boolean r7 = r7.isFinished()     // Catch:{ RemoteException -> 0x0115 }
            com.google.android.gms.internal.firebase_storage.zzq r2 = r0.zza(r1, r2, r3, r4, r6, r7)     // Catch:{ RemoteException -> 0x0115 }
            boolean r0 = r10.zzb(r2)     // Catch:{ IOException -> 0x0120 }
            if (r0 != 0) goto L_0x012b
            r0 = 262144(0x40000, float:3.67342E-40)
            r10.zzcy = r0     // Catch:{ IOException -> 0x0120 }
            java.lang.String r0 = "UploadTask"
            int r1 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0120 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0120 }
            java.lang.String r2 = "Resetting chunk size to "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x0120 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ IOException -> 0x0120 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0120 }
            android.util.Log.d(r0, r1)     // Catch:{ IOException -> 0x0120 }
        L_0x00fc:
            boolean r0 = r10.zzq()
            if (r0 == 0) goto L_0x0099
            r10.zza((int) r9, (boolean) r8)
            goto L_0x0099
        L_0x0106:
            r0 = move-exception
        L_0x0107:
            java.lang.String r1 = "UploadTask"
            java.lang.String r2 = "Unable to create a network request from metadata"
            android.util.Log.e(r1, r2, r0)
            r10.zzk = r0
            goto L_0x0095
        L_0x0111:
            r10.zza((boolean) r8)
            goto L_0x0095
        L_0x0115:
            r0 = move-exception
            java.lang.String r1 = "UploadTask"
            java.lang.String r2 = "Unable to create chunk upload request"
            android.util.Log.e(r1, r2, r0)     // Catch:{ IOException -> 0x0120 }
            r10.zzk = r0     // Catch:{ IOException -> 0x0120 }
            goto L_0x00fc
        L_0x0120:
            r0 = move-exception
            java.lang.String r1 = "UploadTask"
            java.lang.String r2 = "Unable to read bytes for uploading"
            android.util.Log.e(r1, r2, r0)
            r10.zzk = r0
            goto L_0x00fc
        L_0x012b:
            java.util.concurrent.atomic.AtomicLong r0 = r10.zzcx     // Catch:{ IOException -> 0x0120 }
            long r4 = (long) r6     // Catch:{ IOException -> 0x0120 }
            r0.getAndAdd(r4)     // Catch:{ IOException -> 0x0120 }
            com.google.android.gms.internal.firebase_storage.zze r0 = r10.zzcw     // Catch:{ IOException -> 0x0120 }
            boolean r0 = r0.isFinished()     // Catch:{ IOException -> 0x0120 }
            if (r0 != 0) goto L_0x0167
            com.google.android.gms.internal.firebase_storage.zze r0 = r10.zzcw     // Catch:{ IOException -> 0x0120 }
            r0.zzb(r6)     // Catch:{ IOException -> 0x0120 }
            int r0 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            r1 = 33554432(0x2000000, float:9.403955E-38)
            if (r0 >= r1) goto L_0x00fc
            int r0 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            int r0 = r0 << 1
            r10.zzcy = r0     // Catch:{ IOException -> 0x0120 }
            java.lang.String r0 = "UploadTask"
            int r1 = r10.zzcy     // Catch:{ IOException -> 0x0120 }
            r2 = 36
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0120 }
            r3.<init>(r2)     // Catch:{ IOException -> 0x0120 }
            java.lang.String r2 = "Increasing chunk size to "
            java.lang.StringBuilder r2 = r3.append(r2)     // Catch:{ IOException -> 0x0120 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ IOException -> 0x0120 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x0120 }
            android.util.Log.d(r0, r1)     // Catch:{ IOException -> 0x0120 }
            goto L_0x00fc
        L_0x0167:
            com.google.firebase.storage.StorageMetadata$Builder r0 = new com.google.firebase.storage.StorageMetadata$Builder     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            org.json.JSONObject r1 = r2.zzad()     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            com.google.firebase.storage.StorageReference r3 = r10.zzd     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            r0.<init>(r1, r3)     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            com.google.firebase.storage.StorageMetadata r0 = r0.build()     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            r10.zzap = r0     // Catch:{ JSONException -> 0x0185, RemoteException -> 0x01c7 }
            r0 = 4
            r1 = 0
            r10.zza((int) r0, (boolean) r1)     // Catch:{ IOException -> 0x0120 }
            r0 = 128(0x80, float:1.794E-43)
            r1 = 0
            r10.zza((int) r0, (boolean) r1)     // Catch:{ IOException -> 0x0120 }
            goto L_0x00fc
        L_0x0185:
            r0 = move-exception
            r1 = r0
        L_0x0187:
            java.lang.String r3 = "UploadTask"
            java.lang.String r4 = "Unable to parse resulting metadata from upload:"
            java.lang.String r0 = r2.zzy()     // Catch:{ IOException -> 0x0120 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x0120 }
            int r2 = r0.length()     // Catch:{ IOException -> 0x0120 }
            if (r2 == 0) goto L_0x01a4
            java.lang.String r0 = r4.concat(r0)     // Catch:{ IOException -> 0x0120 }
        L_0x019d:
            android.util.Log.e(r3, r0, r1)     // Catch:{ IOException -> 0x0120 }
            r10.zzk = r1     // Catch:{ IOException -> 0x0120 }
            goto L_0x00fc
        L_0x01a4:
            java.lang.String r0 = new java.lang.String     // Catch:{ IOException -> 0x0120 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0120 }
            goto L_0x019d
        L_0x01aa:
            boolean r0 = r10.zzcz
            if (r0 == 0) goto L_0x0015
            int r0 = r10.zzg()
            r1 = 16
            if (r0 == r1) goto L_0x0015
            com.google.android.gms.internal.firebase_storage.zze r0 = r10.zzcw     // Catch:{ IOException -> 0x01bd }
            r0.close()     // Catch:{ IOException -> 0x01bd }
            goto L_0x0015
        L_0x01bd:
            r0 = move-exception
            java.lang.String r1 = "UploadTask"
            java.lang.String r2 = "Unable to close stream."
            android.util.Log.e(r1, r2, r0)
            goto L_0x0015
        L_0x01c7:
            r0 = move-exception
            r1 = r0
            goto L_0x0187
        L_0x01ca:
            r0 = move-exception
            goto L_0x0107
        L_0x01cd:
            r0 = r1
            goto L_0x0039
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.storage.UploadTask.run():void");
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzu.zzb(zzj());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final /* synthetic */ StorageTask.ProvideError zza() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.zzk != null ? this.zzk : this.zzdb, this.zzm), this.zzcx.get(), this.zzda, this.zzap);
    }
}
