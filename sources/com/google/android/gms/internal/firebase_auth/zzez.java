package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzez {
    private static final Class<?> zzvb = zzge();
    private static final zzfr<?, ?> zzvc = zzj(false);
    private static final zzfr<?, ?> zzvd = zzj(true);
    private static final zzfr<?, ?> zzve = new zzft();

    static <UT, UB> UB zza(int i, int i2, UB ub, zzfr<UT, UB> zzfr) {
        if (ub == null) {
            ub = zzfr.zzgq();
        }
        zzfr.zza(ub, i, (long) i2);
        return ub;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzdf<?> zzdf, UB ub, zzfr<UT, UB> zzfr) {
        UB ub2;
        UB zza;
        int i2;
        if (zzdf == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i3 = 0;
            int i4 = 0;
            ub2 = ub;
            while (i3 < size) {
                int intValue = list.get(i3).intValue();
                if (zzdf.zzal(intValue) != null) {
                    if (i3 != i4) {
                        list.set(i4, Integer.valueOf(intValue));
                    }
                    i2 = i4 + 1;
                    zza = ub2;
                } else {
                    int i5 = i4;
                    zza = zza(i, intValue, ub2, zzfr);
                    i2 = i5;
                }
                i3++;
                ub2 = zza;
                i4 = i2;
            }
            if (i4 != size) {
                list.subList(i4, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (zzdf.zzal(intValue2) == null) {
                    ub = zza(i, intValue2, ub, zzfr);
                    it.remove();
                }
            }
            ub2 = ub;
        }
        return ub2;
    }

    public static void zza(int i, List<String> list, zzgl zzgl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zza(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzgl zzgl, zzex zzex) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zza(i, list, zzex);
        }
    }

    public static void zza(int i, List<Double> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzg(i, list, z);
        }
    }

    static <T, FT extends zzcu<FT>> void zza(zzcp<FT> zzcp, T t, T t2) {
        zzcs<FT> zzc = zzcp.zzc(t2);
        if (!zzc.isEmpty()) {
            zzcp.zzd(t).zza(zzc);
        }
    }

    static <T> void zza(zzec zzec, T t, T t2, long j) {
        zzfx.zza((Object) t, j, zzec.zzb(zzfx.zzp(t, j), zzfx.zzp(t2, j)));
    }

    static <T, UT, UB> void zza(zzfr<UT, UB> zzfr, T t, T t2) {
        zzfr.zze(t, zzfr.zzg(zzfr.zzr(t), zzfr.zzr(t2)));
    }

    static int zzaa(List<?> list) {
        return list.size() << 3;
    }

    static int zzab(List<?> list) {
        return list.size();
    }

    public static void zzb(int i, List<zzbu> list, zzgl zzgl) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzb(i, list);
        }
    }

    public static void zzb(int i, List<?> list, zzgl zzgl, zzex zzex) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzb(i, list, zzex);
        }
    }

    public static void zzb(int i, List<Float> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzf(i, list, z);
        }
    }

    static int zzc(int i, Object obj, zzex zzex) {
        return obj instanceof zzdo ? zzci.zza(i, (zzdo) obj) : zzci.zzb(i, (zzeh) obj, zzex);
    }

    static int zzc(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzci.zzz(i) * size;
        if (list instanceof zzdq) {
            zzdq zzdq = (zzdq) list;
            int i2 = 0;
            while (i2 < size) {
                Object raw = zzdq.getRaw(i2);
                i2++;
                zzz = (raw instanceof zzbu ? zzci.zzb((zzbu) raw) : zzci.zzam((String) raw)) + zzz;
            }
            return zzz;
        }
        int i3 = 0;
        while (i3 < size) {
            Object obj = list.get(i3);
            i3++;
            zzz = (obj instanceof zzbu ? zzci.zzb((zzbu) obj) : zzci.zzam((String) obj)) + zzz;
        }
        return zzz;
    }

    static int zzc(int i, List<?> list, zzex zzex) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = zzci.zzz(i) * size;
        int i2 = 0;
        while (i2 < size) {
            Object obj = list.get(i2);
            i2++;
            zzz = (obj instanceof zzdo ? zzci.zza((zzdo) obj) : zzci.zzb((zzeh) obj, zzex)) + zzz;
        }
        return zzz;
    }

    public static void zzc(int i, List<Long> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzc(i, list, z);
        }
    }

    public static boolean zzc(int i, int i2, int i3) {
        return i2 < 40 || ((((long) i2) - ((long) i)) + 1) + 9 <= ((2 * ((long) i3)) + 3) + ((((long) i3) + 3) * 3);
    }

    static int zzd(int i, List<zzbu> list) {
        int i2 = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzz = size * zzci.zzz(i);
        while (true) {
            int i3 = i2;
            if (i3 >= list.size()) {
                return zzz;
            }
            zzz += zzci.zzb(list.get(i3));
            i2 = i3 + 1;
        }
    }

    static int zzd(int i, List<zzeh> list, zzex zzex) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzci.zzc(i, list.get(i3), zzex);
        }
        return i2;
    }

    public static void zzd(int i, List<Long> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzd(i, list, z);
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static void zze(int i, List<Long> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzl(i, list, z);
        }
    }

    public static void zzg(Class<?> cls) {
        if (!zzdb.class.isAssignableFrom(cls) && zzvb != null && !zzvb.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static zzfr<?, ?> zzgb() {
        return zzvc;
    }

    public static zzfr<?, ?> zzgc() {
        return zzvd;
    }

    public static zzfr<?, ?> zzgd() {
        return zzve;
    }

    private static Class<?> zzge() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable th) {
            return null;
        }
    }

    private static Class<?> zzgf() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzh(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzj(i, list, z);
        }
    }

    private static zzfr<?, ?> zzj(boolean z) {
        try {
            Class<?> zzgf = zzgf();
            if (zzgf == null) {
                return null;
            }
            return (zzfr) zzgf.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable th) {
            return null;
        }
    }

    public static void zzj(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzgl zzgl, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzgl.zzi(i, list, z);
        }
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzs(list) + (list.size() * zzci.zzz(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzt(list);
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzu(list);
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzv(list);
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzw(list);
    }

    static int zzs(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            int i2 = 0;
            while (i2 < size) {
                int zzd = zzci.zzd(zzdv.getLong(i2)) + i;
                i2++;
                i = zzd;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzd(list.get(i4).longValue());
        }
        return i3;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzx(list);
    }

    static int zzt(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            int i2 = 0;
            while (i2 < size) {
                int zze = zzci.zze(zzdv.getLong(i2)) + i;
                i2++;
                i = zze;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zze(list.get(i4).longValue());
        }
        return i3;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return (size * zzci.zzz(i)) + zzy(list);
    }

    static int zzu(List<Long> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            int i2 = 0;
            while (i2 < size) {
                int zzf = zzci.zzf(zzdv.getLong(i2)) + i;
                i2++;
                i = zzf;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzf(list.get(i4).longValue());
        }
        return i3;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzci.zzj(i, 0) * size;
    }

    static int zzv(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            int i2 = 0;
            while (i2 < size) {
                int zzaf = zzci.zzaf(zzdc.getInt(i2)) + i;
                i2++;
                i = zzaf;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzaf(list.get(i4).intValue());
        }
        return i3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzci.zzg(i, 0);
    }

    static int zzw(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            int i2 = 0;
            while (i2 < size) {
                int zzaa = zzci.zzaa(zzdc.getInt(i2)) + i;
                i2++;
                i = zzaa;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzaa(list.get(i4).intValue());
        }
        return i3;
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzci.zzc(i, true);
    }

    static int zzx(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            int i2 = 0;
            while (i2 < size) {
                int zzab = zzci.zzab(zzdc.getInt(i2)) + i;
                i2++;
                i = zzab;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzab(list.get(i4).intValue());
        }
        return i3;
    }

    static int zzy(List<Integer> list) {
        int i = 0;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            int i2 = 0;
            while (i2 < size) {
                int zzac = zzci.zzac(zzdc.getInt(i2)) + i;
                i2++;
                i = zzac;
            }
            return i;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            i3 += zzci.zzac(list.get(i4).intValue());
        }
        return i3;
    }

    static int zzz(List<?> list) {
        return list.size() << 2;
    }
}
