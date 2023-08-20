package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_storage.zzf;
import com.google.android.gms.internal.firebase_storage.zzp;
import com.google.android.gms.internal.firebase_storage.zzq;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import org.json.JSONException;

final class zzc implements Runnable {
    private StorageReference zzd;
    private TaskCompletionSource<StorageMetadata> zze;
    private zzf zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxOperationRetryTimeMillis());
    private StorageMetadata zzu;

    public zzc(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource) {
        Preconditions.checkNotNull(storageReference);
        Preconditions.checkNotNull(taskCompletionSource);
        this.zzd = storageReference;
        this.zze = taskCompletionSource;
    }

    public final void run() {
        try {
            zzq zzd2 = zzp.zzb(this.zzd.getStorage().getApp()).zzd(this.zzd.zze());
            this.zzf.zza(zzd2, true);
            if (zzd2.zzaa()) {
                try {
                    this.zzu = new StorageMetadata.Builder(zzd2.zzad(), this.zzd).build();
                } catch (RemoteException | JSONException e) {
                    String valueOf = String.valueOf(zzd2.zzy());
                    Log.e("GetMetadataTask", valueOf.length() != 0 ? "Unable to parse resulting metadata. ".concat(valueOf) : new String("Unable to parse resulting metadata. "), e);
                    this.zze.setException(StorageException.fromException(e));
                    return;
                }
            }
            if (this.zze != null) {
                zzd2.zza(this.zze, this.zzu);
            }
        } catch (RemoteException e2) {
            Log.e("GetMetadataTask", "Unable to create firebase storage network request.", e2);
            this.zze.setException(StorageException.fromException(e2));
        }
    }
}
