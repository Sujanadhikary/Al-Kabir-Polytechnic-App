package com.google.android.gms.internal.firebase_auth;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

final class zzfx {
    private static final Logger logger = Logger.getLogger(zzfx.class.getName());
    private static final Class<?> zzly = zzbr.zzbs();
    private static final boolean zzmz = zzgx();
    private static final Unsafe zztc = zzgw();
    private static final boolean zzwf = zzj(Long.TYPE);
    private static final boolean zzwg = zzj(Integer.TYPE);
    private static final zzd zzwh = (zztc == null ? null : zzbr.zzbr() ? zzwf ? new zzb(zztc) : zzwg ? new zza(zztc) : null : new zzc(zztc));
    private static final boolean zzwi = zzgy();
    /* access modifiers changed from: private */
    public static final long zzwj = ((long) zzh(byte[].class));
    private static final long zzwk = ((long) zzh(boolean[].class));
    private static final long zzwl = ((long) zzi(boolean[].class));
    private static final long zzwm = ((long) zzh(int[].class));
    private static final long zzwn = ((long) zzi(int[].class));
    private static final long zzwo = ((long) zzh(long[].class));
    private static final long zzwp = ((long) zzi(long[].class));
    private static final long zzwq = ((long) zzh(float[].class));
    private static final long zzwr = ((long) zzi(float[].class));
    private static final long zzws = ((long) zzh(double[].class));
    private static final long zzwt = ((long) zzi(double[].class));
    private static final long zzwu = ((long) zzh(Object[].class));
    private static final long zzwv = ((long) zzi(Object[].class));
    private static final long zzww = zzb(zzgz());
    private static final long zzwx;
    /* access modifiers changed from: private */
    public static final boolean zzwy = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte((int) (-1 & j), b);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfx.zzwy) {
                zzfx.zzb(obj, j, z);
            } else {
                zzfx.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (-1 & j2), bArr, (int) j, (int) j3);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfx.zzwy) {
                zzfx.zza(obj, j, b);
            } else {
                zzfx.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzfx.zzwy ? zzfx.zzs(obj, j) : zzfx.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzfx.zzwy ? zzfx.zzq(obj, j) : zzfx.zzr(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzfx.zzwy) {
                zzfx.zzb(obj, j, z);
            } else {
                zzfx.zzc(obj, j, z);
            }
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzfx.zzwy) {
                zzfx.zza(obj, j, b);
            } else {
                zzfx.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzfx.zzwy ? zzfx.zzs(obj, j) : zzfx.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzfx.zzwy ? zzfx.zzq(obj, j) : zzfx.zzr(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(long j, byte b) {
            this.zzwz.putByte(j, b);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzwz.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzwz.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzwz.putBoolean(obj, j, z);
        }

        public final void zza(byte[] bArr, long j, long j2, long j3) {
            this.zzwz.copyMemory(bArr, zzfx.zzwj + j, (Object) null, j2, j3);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzwz.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzwz.getBoolean(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return this.zzwz.getFloat(obj, j);
        }

        public final double zzo(Object obj, long j) {
            return this.zzwz.getDouble(obj, j);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzwz.getByte(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzwz;

        zzd(Unsafe unsafe) {
            this.zzwz = unsafe;
        }

        public final long zza(Field field) {
            return this.zzwz.objectFieldOffset(field);
        }

        public abstract void zza(long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzwz.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zza(byte[] bArr, long j, long j2, long j3);

        public final void zzb(Object obj, long j, int i) {
            this.zzwz.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzwz.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzwz.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    static {
        Field field = null;
        Field zzb2 = zzb(String.class, FirebaseAnalytics.Param.VALUE);
        if (zzb2 != null && zzb2.getType() == char[].class) {
            field = zzb2;
        }
        zzwx = zzb(field);
    }

    private zzfx() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzwh.zzy(bArr, zzwj + j);
    }

    static long zza(Field field) {
        return zzwh.zza(field);
    }

    static void zza(long j, byte b) {
        zzwh.zza(j, b);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j & -4, (zzk(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    static void zza(Object obj, long j, double d) {
        zzwh.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzwh.zza(obj, j, f);
    }

    static void zza(Object obj, long j, long j2) {
        zzwh.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzwh.zzwz.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzwh.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzwh.zze(bArr, zzwj + j, b);
    }

    static void zza(byte[] bArr, long j, long j2, long j3) {
        zzwh.zza(bArr, j, j2, j3);
    }

    private static long zzb(Field field) {
        if (field == null || zzwh == null) {
            return -1;
        }
        return zzwh.zza(field);
    }

    static long zzb(ByteBuffer byteBuffer) {
        return zzwh.zzl(byteBuffer, zzww);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        int i = (((int) j) & 3) << 3;
        zzb(obj, j & -4, (zzk(obj, j & -4) & ((255 << i) ^ -1)) | ((b & 255) << i));
    }

    static void zzb(Object obj, long j, int i) {
        zzwh.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, (byte) (z ? 1 : 0));
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, (byte) (z ? 1 : 0));
    }

    static boolean zzgu() {
        return zzmz;
    }

    static boolean zzgv() {
        return zzwi;
    }

    static Unsafe zzgw() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzfy());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzgx() {
        if (zztc == null) {
            return false;
        }
        try {
            Class<?> cls = zztc.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzbr.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static boolean zzgy() {
        if (zztc == null) {
            return false;
        }
        try {
            Class<?> cls = zztc.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzgz() == null) {
                return false;
            }
            if (zzbr.zzbr()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", new StringBuilder(String.valueOf(valueOf).length() + 71).append("platform method missing - proto runtime falling back to safer methods: ").append(valueOf).toString());
            return false;
        }
    }

    private static Field zzgz() {
        Field zzb2;
        if (zzbr.zzbr() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static int zzh(Class<?> cls) {
        if (zzmz) {
            return zzwh.zzwz.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzmz) {
            return zzwh.zzwz.arrayIndexScale(cls);
        }
        return -1;
    }

    private static boolean zzj(Class<?> cls) {
        if (!zzbr.zzbr()) {
            return false;
        }
        try {
            Class<?> cls2 = zzly;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    static int zzk(Object obj, long j) {
        return zzwh.zzk(obj, j);
    }

    static long zzl(Object obj, long j) {
        return zzwh.zzl(obj, j);
    }

    static boolean zzm(Object obj, long j) {
        return zzwh.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zzwh.zzn(obj, j);
    }

    static double zzo(Object obj, long j) {
        return zzwh.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zzwh.zzwz.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((-1 ^ j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((3 & j) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }
}
