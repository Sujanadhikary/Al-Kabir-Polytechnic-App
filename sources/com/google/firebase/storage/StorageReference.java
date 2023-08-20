package com.google.firebase.storage;

import android.net.Uri;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzg;
import com.google.android.gms.internal.firebase_storage.zzp;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StreamDownloadTask;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class StorageReference {
    private final Uri zzas;
    private final FirebaseStorage zzat;

    StorageReference(@NonNull Uri uri, @NonNull FirebaseStorage firebaseStorage) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "storageUri cannot be null");
        Preconditions.checkArgument(firebaseStorage == null ? false : z, "FirebaseApp cannot be null");
        this.zzas = uri;
        this.zzat = firebaseStorage;
    }

    @NonNull
    public StorageReference child(@NonNull String str) {
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "childName cannot be null or empty");
        String zzd = zzg.zzd(str);
        try {
            return new StorageReference(this.zzas.buildUpon().appendEncodedPath(zzg.zzb(zzd)).build(), this.zzat);
        } catch (UnsupportedEncodingException e) {
            UnsupportedEncodingException unsupportedEncodingException = e;
            String valueOf = String.valueOf(zzd);
            Log.e("StorageReference", valueOf.length() != 0 ? "Unable to create a valid default Uri. ".concat(valueOf) : new String("Unable to create a valid default Uri. "), unsupportedEncodingException);
            throw new IllegalArgumentException("childName");
        }
    }

    public Task<Void> delete() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zza(new zzb(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StorageReference)) {
            return false;
        }
        return ((StorageReference) obj).toString().equals(toString());
    }

    @NonNull
    public List<FileDownloadTask> getActiveDownloadTasks() {
        return zzt.zzl().zzb(this);
    }

    @NonNull
    public List<UploadTask> getActiveUploadTasks() {
        return zzt.zzl().zza(this);
    }

    @NonNull
    public String getBucket() {
        return this.zzas.getAuthority();
    }

    @NonNull
    public Task<byte[]> getBytes(long j) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        ((StorageTask) streamDownloadTask.zza((StreamDownloadTask.StreamProcessor) new zzi(this, j, taskCompletionSource)).addOnSuccessListener((OnSuccessListener) new zzh(this, taskCompletionSource))).addOnFailureListener((OnFailureListener) new zzg(this, taskCompletionSource));
        streamDownloadTask.zzf();
        return taskCompletionSource.getTask();
    }

    @NonNull
    public Task<Uri> getDownloadUrl() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Task<StorageMetadata> metadata = getMetadata();
        metadata.addOnSuccessListener(new zze(this, taskCompletionSource));
        metadata.addOnFailureListener(new zzf(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull Uri uri) {
        FileDownloadTask fileDownloadTask = new FileDownloadTask(this, uri);
        fileDownloadTask.zzf();
        return fileDownloadTask;
    }

    @NonNull
    public FileDownloadTask getFile(@NonNull File file) {
        return getFile(Uri.fromFile(file));
    }

    @NonNull
    public Task<StorageMetadata> getMetadata() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zza(new zzc(this, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    @NonNull
    public String getName() {
        String path = this.zzas.getPath();
        int lastIndexOf = path.lastIndexOf(47);
        return lastIndexOf != -1 ? path.substring(lastIndexOf + 1) : path;
    }

    @Nullable
    public StorageReference getParent() {
        String path = this.zzas.getPath();
        if (TextUtils.isEmpty(path) || path.equals("/")) {
            return null;
        }
        int lastIndexOf = path.lastIndexOf(47);
        return new StorageReference(this.zzas.buildUpon().path(lastIndexOf == -1 ? "/" : path.substring(0, lastIndexOf)).build(), this.zzat);
    }

    @NonNull
    public String getPath() {
        return this.zzas.getPath();
    }

    @NonNull
    public StorageReference getRoot() {
        return new StorageReference(this.zzas.buildUpon().path("").build(), this.zzat);
    }

    @NonNull
    public FirebaseStorage getStorage() {
        return this.zzat;
    }

    @NonNull
    public StreamDownloadTask getStream() {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zzf();
        return streamDownloadTask;
    }

    @NonNull
    public StreamDownloadTask getStream(@NonNull StreamDownloadTask.StreamProcessor streamProcessor) {
        StreamDownloadTask streamDownloadTask = new StreamDownloadTask(this);
        streamDownloadTask.zza(streamProcessor);
        streamDownloadTask.zzf();
        return streamDownloadTask;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr) {
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, bArr);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putBytes(@NonNull byte[] bArr, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(bArr != null, "bytes cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, bArr);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri) {
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, uri, (Uri) null);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, (Uri) null);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putFile(@NonNull Uri uri, @Nullable StorageMetadata storageMetadata, @Nullable Uri uri2) {
        boolean z = true;
        Preconditions.checkArgument(uri != null, "uri cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, uri, uri2);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream) {
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        UploadTask uploadTask = new UploadTask(this, (StorageMetadata) null, inputStream);
        uploadTask.zzf();
        return uploadTask;
    }

    @NonNull
    public UploadTask putStream(@NonNull InputStream inputStream, @NonNull StorageMetadata storageMetadata) {
        boolean z = true;
        Preconditions.checkArgument(inputStream != null, "stream cannot be null");
        if (storageMetadata == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "metadata cannot be null");
        UploadTask uploadTask = new UploadTask(this, storageMetadata, inputStream);
        uploadTask.zzf();
        return uploadTask;
    }

    public String toString() {
        String authority = this.zzas.getAuthority();
        String encodedPath = this.zzas.getEncodedPath();
        return new StringBuilder(String.valueOf(authority).length() + 5 + String.valueOf(encodedPath).length()).append("gs://").append(authority).append(encodedPath).toString();
    }

    @NonNull
    public Task<StorageMetadata> updateMetadata(@NonNull StorageMetadata storageMetadata) {
        Preconditions.checkNotNull(storageMetadata);
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zzu.zza(new zzac(this, taskCompletionSource, storageMetadata));
        return taskCompletionSource.getTask();
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final zzp zzd() throws RemoteException {
        return zzp.zzb(getStorage().getApp());
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public final Uri zze() {
        return this.zzas;
    }
}
