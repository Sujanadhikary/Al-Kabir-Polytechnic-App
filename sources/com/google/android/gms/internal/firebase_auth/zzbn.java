package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzbn;
import com.google.android.gms.internal.firebase_auth.zzbo;
import java.io.IOException;

public abstract class zzbn<MessageType extends zzbn<MessageType, BuilderType>, BuilderType extends zzbo<MessageType, BuilderType>> implements zzeh {
    private static boolean zzlv = false;
    protected int zzlu = 0;

    public final zzbu zzbl() {
        try {
            zzbz zzk = zzbu.zzk(zzdn());
            zzb(zzk.zzby());
            return zzk.zzbx();
        } catch (IOException e) {
            String name = getClass().getName();
            throw new RuntimeException(new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length()).append("Serializing ").append(name).append(" to a ").append("ByteString").append(" threw an IOException (should never happen).").toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbm() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzf(int i) {
        throw new UnsupportedOperationException();
    }
}
