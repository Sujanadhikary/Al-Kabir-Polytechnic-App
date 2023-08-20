package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_storage.zzf;
import com.google.android.gms.internal.firebase_storage.zzp;
import com.google.android.gms.internal.firebase_storage.zzq;
import com.google.firebase.storage.StorageTask;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileDownloadTask extends StorageTask<TaskSnapshot> {
    private StorageReference zzd;
    private zzf zzf;
    private final Uri zzg;
    private long zzh;
    private long zzi = -1;
    private String zzj = null;
    private volatile Exception zzk = null;
    private long zzl = 0;
    private int zzm;

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long zzh;

        TaskSnapshot(@Nullable Exception exc, long j) {
            super(exc);
            this.zzh = j;
        }

        public long getBytesTransferred() {
            return this.zzh;
        }

        public long getTotalByteCount() {
            return FileDownloadTask.this.getTotalBytes();
        }
    }

    FileDownloadTask(@NonNull StorageReference storageReference, @NonNull Uri uri) {
        this.zzd = storageReference;
        this.zzg = uri;
        this.zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxDownloadRetryTimeMillis());
    }

    private final int zza(InputStream inputStream, byte[] bArr) {
        int read;
        int i = 0;
        boolean z = false;
        while (i != bArr.length && (read = inputStream.read(bArr, i, bArr.length - i)) != -1) {
            try {
                i += read;
                z = true;
            } catch (IOException e) {
                this.zzk = e;
            }
        }
        if (z) {
            return i;
        }
        return -1;
    }

    private final boolean zza(zzq zzq) throws IOException {
        FileOutputStream fileOutputStream;
        InputStream stream = zzq.getStream();
        if (stream != null) {
            File file = new File(this.zzg.getPath());
            if (!file.exists()) {
                if (this.zzl > 0) {
                    String valueOf = String.valueOf(file.getAbsolutePath());
                    Log.e("FileDownloadTask", valueOf.length() != 0 ? "The file downloading to has been deleted:".concat(valueOf) : new String("The file downloading to has been deleted:"));
                    throw new IllegalStateException("expected a file to resume from.");
                } else if (!file.createNewFile()) {
                    String valueOf2 = String.valueOf(file.getAbsolutePath());
                    Log.w("FileDownloadTask", valueOf2.length() != 0 ? "unable to create file:".concat(valueOf2) : new String("unable to create file:"));
                }
            }
            if (this.zzl > 0) {
                String absolutePath = file.getAbsolutePath();
                Log.d("FileDownloadTask", new StringBuilder(String.valueOf(absolutePath).length() + 47).append("Resuming download file ").append(absolutePath).append(" at ").append(this.zzl).toString());
                fileOutputStream = new FileOutputStream(file, true);
            } else {
                fileOutputStream = new FileOutputStream(file);
            }
            try {
                byte[] bArr = new byte[262144];
                boolean z = true;
                while (z) {
                    int zza = zza(stream, bArr);
                    if (zza == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, zza);
                    this.zzh += (long) zza;
                    if (this.zzk != null) {
                        Log.d("FileDownloadTask", "Exception occurred during file download. Retrying.", this.zzk);
                        this.zzk = null;
                        z = false;
                    }
                    if (!zza(4, false)) {
                        z = false;
                    }
                }
                return z;
            } finally {
                fileOutputStream.flush();
                fileOutputStream.close();
                stream.close();
            }
        } else {
            this.zzk = new IllegalStateException("Unable to open Firebase Storage stream.");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final StorageReference getStorage() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final long getTotalBytes() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public void onCanceled() {
        this.zzf.cancel();
        this.zzk = StorageException.fromErrorStatus(Status.RESULT_CANCELED);
    }

    /* access modifiers changed from: package-private */
    public final void run() {
        if (this.zzk != null) {
            zza(64, false);
        } else if (zza(4, false)) {
            do {
                this.zzh = 0;
                this.zzk = null;
                this.zzf.reset();
                try {
                    zzq zza = zzp.zzb(this.zzd.getStorage().getApp()).zza(this.zzd.zze(), this.zzl);
                    this.zzf.zza(zza, false);
                    this.zzm = zza.getResultCode();
                    this.zzk = zza.getException() != null ? zza.getException() : this.zzk;
                    int i = this.zzm;
                    boolean z = (i == 308 || (i >= 200 && i < 300)) && this.zzk == null && zzg() == 4;
                    if (z) {
                        this.zzi = (long) zza.zzab();
                        String zzh2 = zza.zzh("ETag");
                        if (TextUtils.isEmpty(zzh2) || this.zzj == null || this.zzj.equals(zzh2)) {
                            this.zzj = zzh2;
                            try {
                                z = zza(zza);
                            } catch (IOException e) {
                                Log.e("FileDownloadTask", "Exception occurred during file write.  Aborting.", e);
                                this.zzk = e;
                            }
                        } else {
                            Log.w("FileDownloadTask", "The file at the server has changed.  Restarting from the beginning.");
                            this.zzl = 0;
                            this.zzj = null;
                            zza.zzv();
                            schedule();
                            return;
                        }
                    }
                    zza.zzv();
                    if (z && this.zzk == null && zzg() == 4) {
                        zza(128, false);
                        return;
                    }
                    File file = new File(this.zzg.getPath());
                    if (file.exists()) {
                        this.zzl = file.length();
                    } else {
                        this.zzl = 0;
                    }
                    if (zzg() == 8) {
                        zza(16, false);
                        return;
                    } else if (zzg() == 32) {
                        if (!zza(256, false)) {
                            Log.w("FileDownloadTask", new StringBuilder(62).append("Unable to change download task to final state from ").append(zzg()).toString());
                            return;
                        }
                        return;
                    }
                } catch (RemoteException e2) {
                    Log.e("FileDownloadTask", "Unable to create firebase storage network request.", e2);
                    this.zzk = e2;
                    zza(64, false);
                    return;
                }
            } while (this.zzh > 0);
            zza(64, false);
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzu.zzc(zzj());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final /* synthetic */ StorageTask.ProvideError zza() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.zzk, this.zzm), this.zzh + this.zzl);
    }
}
