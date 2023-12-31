package com.google.firebase.storage;

import android.support.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class zzt {
    private static final zzt zzbl = new zzt();
    private final Object mSyncObject = new Object();
    private final Map<String, WeakReference<StorageTask>> zzbm = new HashMap();

    zzt() {
    }

    static zzt zzl() {
        return zzbl;
    }

    public final List<UploadTask> zza(@NonNull StorageReference storageReference) {
        List<UploadTask> unmodifiableList;
        synchronized (this.mSyncObject) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Map.Entry next : this.zzbm.entrySet()) {
                if (((String) next.getKey()).startsWith(storageReference2)) {
                    StorageTask storageTask = (StorageTask) ((WeakReference) next.getValue()).get();
                    if (storageTask instanceof UploadTask) {
                        arrayList.add((UploadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public final List<FileDownloadTask> zzb(@NonNull StorageReference storageReference) {
        List<FileDownloadTask> unmodifiableList;
        synchronized (this.mSyncObject) {
            ArrayList arrayList = new ArrayList();
            String storageReference2 = storageReference.toString();
            for (Map.Entry next : this.zzbm.entrySet()) {
                if (((String) next.getKey()).startsWith(storageReference2)) {
                    StorageTask storageTask = (StorageTask) ((WeakReference) next.getValue()).get();
                    if (storageTask instanceof FileDownloadTask) {
                        arrayList.add((FileDownloadTask) storageTask);
                    }
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    public final void zzb(StorageTask storageTask) {
        synchronized (this.mSyncObject) {
            this.zzbm.put(storageTask.getStorage().toString(), new WeakReference(storageTask));
        }
    }

    public final void zzc(StorageTask storageTask) {
        synchronized (this.mSyncObject) {
            String storageReference = storageTask.getStorage().toString();
            WeakReference weakReference = this.zzbm.get(storageReference);
            StorageTask storageTask2 = weakReference != null ? (StorageTask) weakReference.get() : null;
            if (storageTask2 == null || storageTask2 == storageTask) {
                this.zzbm.remove(storageReference);
            }
        }
    }
}
