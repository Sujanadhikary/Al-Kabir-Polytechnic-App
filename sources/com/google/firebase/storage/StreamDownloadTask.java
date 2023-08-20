package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzf;
import com.google.android.gms.internal.firebase_storage.zzq;
import com.google.firebase.storage.StorageTask;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class StreamDownloadTask extends StorageTask<TaskSnapshot> {
    private StreamProcessor zzby;
    private long zzbz;
    /* access modifiers changed from: private */
    public InputStream zzca;
    /* access modifiers changed from: private */
    public zzq zzcb;
    private StorageReference zzd;
    private zzf zzf;
    private long zzh;
    private long zzi = -1;
    private String zzj;
    private volatile Exception zzk = null;
    private volatile int zzm = 0;

    public interface StreamProcessor {
        void doInBackground(TaskSnapshot taskSnapshot, InputStream inputStream) throws IOException;
    }

    public class TaskSnapshot extends StorageTask<TaskSnapshot>.SnapshotBase {
        private final long zzh;

        TaskSnapshot(@Nullable Exception exc, long j) {
            super(exc);
            this.zzh = j;
        }

        public long getBytesTransferred() {
            return this.zzh;
        }

        public InputStream getStream() {
            return StreamDownloadTask.this.zzca;
        }

        public long getTotalByteCount() {
            return StreamDownloadTask.this.getTotalBytes();
        }
    }

    static class zza extends InputStream {
        @Nullable
        private StreamDownloadTask zzcd;
        @Nullable
        private InputStream zzce;
        private Callable<InputStream> zzcf;
        private IOException zzcg;
        private int zzch;
        private int zzci;
        private boolean zzcj;

        zza(@NonNull Callable<InputStream> callable, @Nullable StreamDownloadTask streamDownloadTask) {
            this.zzcd = streamDownloadTask;
            this.zzcf = callable;
        }

        private final void zza(long j) {
            if (this.zzcd != null) {
                this.zzcd.zza(j);
            }
            this.zzch = (int) (((long) this.zzch) + j);
        }

        private final void zzn() throws IOException {
            if (this.zzcd != null && this.zzcd.zzg() == 32) {
                throw new zza();
            }
        }

        /* access modifiers changed from: private */
        public final boolean zzo() throws IOException {
            zzn();
            if (this.zzcg != null) {
                try {
                    if (this.zzce != null) {
                        this.zzce.close();
                    }
                } catch (IOException e) {
                }
                this.zzce = null;
                if (this.zzci == this.zzch) {
                    Log.i("StreamDownloadTask", "Encountered exception during stream operation. Aborting.", this.zzcg);
                    return false;
                }
                Log.i("StreamDownloadTask", new StringBuilder(70).append("Encountered exception during stream operation. Retrying at ").append(this.zzch).toString(), this.zzcg);
                this.zzci = this.zzch;
                this.zzcg = null;
            }
            if (this.zzcj) {
                throw new IOException("Can't perform operation on closed stream");
            }
            if (this.zzce == null) {
                try {
                    this.zzce = this.zzcf.call();
                } catch (Exception e2) {
                    if (e2 instanceof IOException) {
                        throw ((IOException) e2);
                    }
                    throw new IOException("Unable to open stream", e2);
                }
            }
            return true;
        }

        public final int available() throws IOException {
            while (zzo()) {
                try {
                    return this.zzce.available();
                } catch (IOException e) {
                    this.zzcg = e;
                }
            }
            throw this.zzcg;
        }

        public final void close() throws IOException {
            if (this.zzce != null) {
                this.zzce.close();
            }
            this.zzcj = true;
            if (!(this.zzcd == null || this.zzcd.zzcb == null)) {
                this.zzcd.zzcb.zzv();
                zzq unused = this.zzcd.zzcb = null;
            }
            zzn();
        }

        public final void mark(int i) {
        }

        public final boolean markSupported() {
            return false;
        }

        public final int read() throws IOException {
            while (zzo()) {
                try {
                    int read = this.zzce.read();
                    if (read != -1) {
                        zza(1);
                    }
                    return read;
                } catch (IOException e) {
                    this.zzcg = e;
                }
            }
            throw this.zzcg;
        }

        public final int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
            int i3;
            IOException e;
            int i4 = 0;
            while (zzo()) {
                while (((long) i2) > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        int read = this.zzce.read(bArr, i, 262144);
                        if (read != -1) {
                            i3 = i4 + read;
                            i += read;
                            i2 -= read;
                            try {
                                zza((long) read);
                                zzn();
                                i4 = i3;
                            } catch (IOException e2) {
                                IOException iOException = e2;
                                i4 = i3;
                                e = iOException;
                                this.zzcg = e;
                            }
                        } else if (i4 == 0) {
                            return -1;
                        } else {
                            return i4;
                        }
                    } catch (IOException e3) {
                        e = e3;
                    }
                }
                if (i2 > 0) {
                    int read2 = this.zzce.read(bArr, i, i2);
                    if (read2 != -1) {
                        i += read2;
                        i3 = i4 + read2;
                        i2 -= read2;
                        zza((long) read2);
                        i4 = i3;
                    } else if (i4 == 0) {
                        return -1;
                    } else {
                        return i4;
                    }
                }
                if (i2 == 0) {
                    return i4;
                }
            }
            throw this.zzcg;
        }

        public final long skip(long j) throws IOException {
            int i = 0;
            while (zzo()) {
                int i2 = i;
                while (j > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    try {
                        long skip = this.zzce.skip(PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
                        if (skip >= 0) {
                            i2 = (int) (((long) i2) + skip);
                            j -= skip;
                            zza(skip);
                            zzn();
                        } else if (i2 == 0) {
                            return -1;
                        } else {
                            return (long) i2;
                        }
                    } catch (IOException e) {
                        IOException iOException = e;
                        i = i2;
                        this.zzcg = iOException;
                    }
                }
                if (j > 0) {
                    long skip2 = this.zzce.skip(j);
                    if (skip2 >= 0) {
                        i2 = (int) (((long) i2) + skip2);
                        j -= skip2;
                        zza(skip2);
                    } else if (i2 == 0) {
                        return -1;
                    } else {
                        return (long) i2;
                    }
                }
                i = i2;
                if (j == 0) {
                    return (long) i;
                }
            }
            throw this.zzcg;
        }
    }

    StreamDownloadTask(@NonNull StorageReference storageReference) {
        this.zzd = storageReference;
        this.zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxDownloadRetryTimeMillis());
    }

    /* access modifiers changed from: private */
    public final InputStream zzm() throws Exception {
        this.zzf.reset();
        if (this.zzcb != null) {
            this.zzcb.zzv();
        }
        try {
            this.zzcb = this.zzd.zzd().zza(this.zzd.zze(), this.zzh);
            this.zzf.zza(this.zzcb, false);
            this.zzm = this.zzcb.getResultCode();
            this.zzk = this.zzcb.getException() != null ? this.zzcb.getException() : this.zzk;
            int i = this.zzm;
            if ((i == 308 || (i >= 200 && i < 300)) && this.zzk == null && zzg() == 4) {
                String zzh2 = this.zzcb.zzh("ETag");
                if (TextUtils.isEmpty(zzh2) || this.zzj == null || this.zzj.equals(zzh2)) {
                    this.zzj = zzh2;
                    if (this.zzi == -1) {
                        this.zzi = (long) this.zzcb.zzab();
                    }
                    return this.zzcb.getStream();
                }
                this.zzm = 409;
                throw new IOException("The ETag on the server changed.");
            }
            throw new IOException("Could not open resulting stream.");
        } catch (RemoteException e) {
            Log.e("StreamDownloadTask", "Unable to create firebase storage network request.", e);
            throw e;
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

    /* access modifiers changed from: protected */
    public void onProgress() {
        this.zzbz = this.zzh;
    }

    public boolean pause() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    public boolean resume() {
        throw new UnsupportedOperationException("this operation is not supported on StreamDownloadTask.");
    }

    /* access modifiers changed from: package-private */
    public final void run() {
        if (this.zzk != null) {
            zza(64, false);
        } else if (zza(4, false)) {
            zza zza2 = new zza(new zzw(this), this);
            this.zzca = new BufferedInputStream(zza2);
            try {
                boolean unused = zza2.zzo();
                if (this.zzby != null) {
                    try {
                        this.zzby.doInBackground((TaskSnapshot) zzh(), this.zzca);
                    } catch (Exception e) {
                        Log.w("StreamDownloadTask", "Exception occurred calling doInBackground.", e);
                        this.zzk = e;
                    }
                }
            } catch (IOException e2) {
                Log.d("StreamDownloadTask", "Initial opening of Stream failed", e2);
                this.zzk = e2;
            }
            if (this.zzca == null) {
                this.zzcb.zzv();
                this.zzcb = null;
            }
            if (this.zzk == null && zzg() == 4) {
                zza(4, false);
                zza(128, false);
                return;
            }
            if (!zza(zzg() == 32 ? 256 : 64, false)) {
                Log.w("StreamDownloadTask", new StringBuilder(62).append("Unable to change download task to final state from ").append(zzg()).toString());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void schedule() {
        zzu.zzc(zzj());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final /* synthetic */ StorageTask.ProvideError zza() {
        return new TaskSnapshot(StorageException.fromExceptionAndHttpCode(this.zzk, this.zzm), this.zzbz);
    }

    /* access modifiers changed from: package-private */
    public final StreamDownloadTask zza(@NonNull StreamProcessor streamProcessor) {
        Preconditions.checkNotNull(streamProcessor);
        Preconditions.checkState(this.zzby == null);
        this.zzby = streamProcessor;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j) {
        this.zzh += j;
        if (this.zzbz + PlaybackStateCompat.ACTION_SET_REPEAT_MODE > this.zzh) {
            return;
        }
        if (zzg() == 4) {
            zza(4, false);
        } else {
            this.zzbz = this.zzh;
        }
    }
}
