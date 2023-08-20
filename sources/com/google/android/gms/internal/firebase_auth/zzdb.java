package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdb.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzdb<MessageType extends zzdb<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbn<MessageType, BuilderType> {
    private static Map<Object, zzdb<?, ?>> zzqt = new ConcurrentHashMap();
    protected zzfs zzqr = zzfs.zzgr();
    private int zzqs = -1;

    public static abstract class zza<MessageType extends zzdb<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzbo<MessageType, BuilderType> {
        private final MessageType zzqu;
        private MessageType zzqv;
        private boolean zzqw = false;

        protected zza(MessageType messagetype) {
            this.zzqu = messagetype;
            this.zzqv = (zzdb) messagetype.zza(zze.zzrb, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzes.zzfd().zzq(messagetype).zzc(messagetype, messagetype2);
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            MessageType messagetype;
            zza zza = (zza) ((zzdb) this.zzqu).zza(zze.zzrc, (Object) null, (Object) null);
            if (this.zzqw) {
                messagetype = this.zzqv;
            } else {
                MessageType messagetype2 = this.zzqv;
                zzes.zzfd().zzq(messagetype2).zze(messagetype2);
                this.zzqw = true;
                messagetype = this.zzqv;
            }
            zza.zza((zzdb) messagetype);
            return zza;
        }

        public final boolean isInitialized() {
            return zzdb.zza(this.zzqv, false);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzqw) {
                MessageType messagetype2 = (zzdb) this.zzqv.zza(zze.zzrb, (Object) null, (Object) null);
                zza(messagetype2, this.zzqv);
                this.zzqv = messagetype2;
                this.zzqw = false;
            }
            zza(this.zzqv, messagetype);
            return this;
        }

        public final /* synthetic */ zzbo zzbn() {
            return (zza) clone();
        }

        public final /* synthetic */ zzeh zzdy() {
            return this.zzqu;
        }

        public final /* synthetic */ zzeh zzdz() {
            if (this.zzqw) {
                return this.zzqv;
            }
            MessageType messagetype = this.zzqv;
            zzes.zzfd().zzq(messagetype).zze(messagetype);
            this.zzqw = true;
            return this.zzqv;
        }

        public final /* synthetic */ zzeh zzea() {
            MessageType messagetype;
            boolean z;
            if (this.zzqw) {
                messagetype = this.zzqv;
            } else {
                MessageType messagetype2 = this.zzqv;
                zzes.zzfd().zzq(messagetype2).zze(messagetype2);
                this.zzqw = true;
                messagetype = this.zzqv;
            }
            zzdb zzdb = (zzdb) messagetype;
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zzdb.zza(zze.zzqy, (Object) null, (Object) null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue == 0) {
                z = false;
            } else {
                boolean zzp = zzes.zzfd().zzq(zzdb).zzp(zzdb);
                if (booleanValue) {
                    zzdb.zza(zze.zzqz, (Object) zzp ? zzdb : null, (Object) null);
                }
                z = zzp;
            }
            if (z) {
                return zzdb;
            }
            throw new zzfq(zzdb);
        }
    }

    public static class zzb<T extends zzdb<T, ?>> extends zzbp<T> {
        private T zzqu;

        public zzb(T t) {
            this.zzqu = t;
        }

        public final /* synthetic */ Object zza(zzcd zzcd, zzco zzco) throws zzdh {
            return zzdb.zza(this.zzqu, zzcd, zzco);
        }
    }

    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzdb<MessageType, BuilderType> implements zzej {
        protected zzcs<Object> zzqx = zzcs.zzdm();
    }

    public static class zzd<ContainingType extends zzeh, Type> extends zzcm<ContainingType, Type> {
    }

    /* 'enum' modifier removed */
    public static final class zze {
        public static final int zzqy = 1;
        public static final int zzqz = 2;
        public static final int zzra = 3;
        public static final int zzrb = 4;
        public static final int zzrc = 5;
        public static final int zzrd = 6;
        public static final int zzre = 7;
        private static final /* synthetic */ int[] zzrf = {zzqy, zzqz, zzra, zzrb, zzrc, zzrd, zzre};
        public static final int zzrg = 1;
        public static final int zzrh = 2;
        private static final /* synthetic */ int[] zzri = {zzrg, zzrh};
        public static final int zzrj = 1;
        public static final int zzrk = 2;
        private static final /* synthetic */ int[] zzrl = {zzrj, zzrk};

        /* renamed from: values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0 */
        public static int[] m35x126d66cb() {
            return (int[]) zzrf.clone();
        }
    }

    static <T extends zzdb<T, ?>> T zza(T t, zzcd zzcd, zzco zzco) throws zzdh {
        T t2 = (zzdb) t.zza(zze.zzrb, (Object) null, (Object) null);
        try {
            zzes.zzfd().zzq(t2).zza(t2, zzcg.zza(zzcd), zzco);
            zzes.zzfd().zzq(t2).zze(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdh) {
                throw ((zzdh) e.getCause());
            }
            throw new zzdh(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdh) {
                throw ((zzdh) e2.getCause());
            }
            throw e2;
        }
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends zzdb<?, ?>> void zza(Class<T> cls, T t) {
        zzqt.put(cls, t);
    }

    protected static final <T extends zzdb<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zzqy, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzes.zzfd().zzq(t).zzp(t);
    }

    static <T extends zzdb<?, ?>> T zzd(Class<T> cls) {
        T t = (zzdb) zzqt.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzdb) zzqt.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t != null) {
            return t;
        }
        String valueOf = String.valueOf(cls.getName());
        throw new IllegalStateException(valueOf.length() != 0 ? "Unable to get default instance for: ".concat(valueOf) : new String("Unable to get default instance for: "));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzdb) zza(zze.zzrd, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzes.zzfd().zzq(this).equals(this, (zzdb) obj);
    }

    public int hashCode() {
        if (this.zzlu != 0) {
            return this.zzlu;
        }
        this.zzlu = zzes.zzfd().zzq(this).hashCode(this);
        return this.zzlu;
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zze.zzqy, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzp = zzes.zzfd().zzq(this).zzp(this);
        if (booleanValue) {
            zza(zze.zzqz, (Object) zzp ? this : null, (Object) null);
        }
        return zzp;
    }

    public String toString() {
        return zzek.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zzb(zzci zzci) throws IOException {
        zzes.zzfd().zzf(getClass()).zza(this, zzck.zza(zzci));
    }

    /* access modifiers changed from: package-private */
    public final int zzbm() {
        return this.zzqs;
    }

    public final int zzdn() {
        if (this.zzqs == -1) {
            this.zzqs = zzes.zzfd().zzq(this).zzo(this);
        }
        return this.zzqs;
    }

    public final /* synthetic */ zzei zzdw() {
        zza zza2 = (zza) zza(zze.zzrc, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzei zzdx() {
        return (zza) zza(zze.zzrc, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzeh zzdy() {
        return (zzdb) zza(zze.zzrd, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzf(int i) {
        this.zzqs = i;
    }
}
