package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzbn;
import com.google.android.gms.internal.firebase_auth.zzbo;

public abstract class zzbo<MessageType extends zzbn<MessageType, BuilderType>, BuilderType extends zzbo<MessageType, BuilderType>> implements zzei {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzei zza(zzeh zzeh) {
        if (zzdy().getClass().isInstance(zzeh)) {
            return zza((zzbn) zzeh);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    /* renamed from: zzbn */
    public abstract BuilderType clone();
}
