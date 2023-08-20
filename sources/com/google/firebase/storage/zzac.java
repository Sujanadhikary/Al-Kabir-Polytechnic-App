package com.google.firebase.storage;

import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.util.Log;
import com.google.android.gms.internal.firebase_storage.zzf;
import com.google.android.gms.internal.firebase_storage.zzq;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageMetadata;
import org.json.JSONException;

final class zzac implements Runnable {
    private final StorageMetadata zzct;
    private final StorageReference zzd;
    private final TaskCompletionSource<StorageMetadata> zze;
    private zzf zzf;
    private StorageMetadata zzu = null;

    public zzac(@NonNull StorageReference storageReference, @NonNull TaskCompletionSource<StorageMetadata> taskCompletionSource, @NonNull StorageMetadata storageMetadata) {
        this.zzd = storageReference;
        this.zze = taskCompletionSource;
        this.zzct = storageMetadata;
        this.zzf = new zzf(this.zzd.getStorage().getApp(), this.zzd.getStorage().getMaxOperationRetryTimeMillis());
    }

    public final void run() {
        try {
            zzq zza = this.zzd.zzd().zza(this.zzd.zze(), this.zzct.zzb());
            this.zzf.zza(zza, true);
            if (zza.zzaa()) {
                try {
                    this.zzu = new StorageMetadata.Builder(zza.zzad(), this.zzd).build();
                } catch (RemoteException | JSONException e) {
                    String valueOf = String.valueOf(zza.zzy());
                    Log.e("UpdateMetadataTask", valueOf.length() != 0 ? "Unable to parse a valid JSON object from resulting metadata:".concat(valueOf) : new String("Unable to parse a valid JSON object from resulting metadata:"), e);
                    this.zze.setException(StorageException.fromException(e));
                    return;
                }
            }
            if (this.zze != null) {
                zza.zza(this.zze, this.zzu);
            }
        } catch (RemoteException | JSONException e2) {
            Log.e("UpdateMetadataTask", "Unable to create the request from metadata.", e2);
            this.zze.setException(StorageException.fromException(e2));
        }
    }
}
