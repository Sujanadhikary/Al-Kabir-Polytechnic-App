package com.google.android.gms.internal.firebase_auth;

import android.support.p000v4.view.MotionEventCompat;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.internal.firebase_auth.zzdb;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzel<T> implements zzex<T> {
    private static final Unsafe zztc = zzfx.zzgw();
    private final int[] zztd;
    private final Object[] zzte;
    private final int zztf;
    private final int zztg;
    private final int zzth;
    private final zzeh zzti;
    private final boolean zztj;
    private final boolean zztk;
    private final boolean zztl;
    private final boolean zztm;
    private final int[] zztn;
    private final int[] zzto;
    private final int[] zztp;
    private final zzeo zztq;
    private final zzdr zztr;
    private final zzfr<?, ?> zzts;
    private final zzcp<?> zztt;
    private final zzec zztu;

    private zzel(int[] iArr, Object[] objArr, int i, int i2, int i3, zzeh zzeh, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzeo zzeo, zzdr zzdr, zzfr<?, ?> zzfr, zzcp<?> zzcp, zzec zzec) {
        this.zztd = iArr;
        this.zzte = objArr;
        this.zztf = i;
        this.zztg = i2;
        this.zzth = i3;
        this.zztk = zzeh instanceof zzdb;
        this.zztl = z;
        this.zztj = zzcp != null && zzcp.zze(zzeh);
        this.zztm = false;
        this.zztn = iArr2;
        this.zzto = iArr3;
        this.zztp = iArr4;
        this.zztq = zzeo;
        this.zztr = zzdr;
        this.zzts = zzfr;
        this.zztt = zzcp;
        this.zzti = zzeh;
        this.zztu = zzec;
    }

    private static <UT, UB> int zza(zzfr<UT, UB> zzfr, T t) {
        return zzfr.zzo(zzfr.zzr(t));
    }

    static <T> zzel<T> zza(Class<T> cls, zzef zzef, zzeo zzeo, zzdr zzdr, zzfr<?, ?> zzfr, zzcp<?> zzcp, zzec zzec) {
        int zzff;
        int zzfg;
        int zzfk;
        int zza;
        int i;
        int i2;
        if (zzef instanceof zzet) {
            zzet zzet = (zzet) zzef;
            boolean z = zzet.zzew() == zzdb.zze.zzrh;
            if (zzet.getFieldCount() == 0) {
                zzff = 0;
                zzfg = 0;
                zzfk = 0;
            } else {
                zzff = zzet.zzff();
                zzfg = zzet.zzfg();
                zzfk = zzet.zzfk();
            }
            int[] iArr = new int[(zzfk << 2)];
            Object[] objArr = new Object[(zzfk << 1)];
            int[] iArr2 = zzet.zzfh() > 0 ? new int[zzet.zzfh()] : null;
            int[] iArr3 = zzet.zzfi() > 0 ? new int[zzet.zzfi()] : null;
            int i3 = 0;
            int i4 = 0;
            zzeu zzfe = zzet.zzfe();
            if (zzfe.next()) {
                int zzcx = zzfe.zzcx();
                int i5 = 0;
                while (true) {
                    if (zzcx >= zzet.zzfl() || i5 >= ((zzcx - zzff) << 2)) {
                        if (zzfe.zzfp()) {
                            zza = (int) zzfx.zza(zzfe.zzfq());
                            i = (int) zzfx.zza(zzfe.zzfr());
                            i2 = 0;
                        } else {
                            zza = (int) zzfx.zza(zzfe.zzfs());
                            if (zzfe.zzft()) {
                                i = (int) zzfx.zza(zzfe.zzfu());
                                i2 = zzfe.zzfv();
                            } else {
                                i = 0;
                                i2 = 0;
                            }
                        }
                        iArr[i5] = zzfe.zzcx();
                        iArr[i5 + 1] = zza | (zzfe.zzfx() ? CrashUtils.ErrorDialogData.DYNAMITE_CRASH : 0) | (zzfe.zzfw() ? CrashUtils.ErrorDialogData.BINDER_CRASH : 0) | (zzfe.zzfn() << 20);
                        iArr[i5 + 2] = i | (i2 << 20);
                        if (zzfe.zzga() != null) {
                            objArr[(i5 / 4) << 1] = zzfe.zzga();
                            if (zzfe.zzfy() != null) {
                                objArr[((i5 / 4) << 1) + 1] = zzfe.zzfy();
                            } else if (zzfe.zzfz() != null) {
                                objArr[((i5 / 4) << 1) + 1] = zzfe.zzfz();
                            }
                        } else if (zzfe.zzfy() != null) {
                            objArr[((i5 / 4) << 1) + 1] = zzfe.zzfy();
                        } else if (zzfe.zzfz() != null) {
                            objArr[((i5 / 4) << 1) + 1] = zzfe.zzfz();
                        }
                        int zzfn = zzfe.zzfn();
                        if (zzfn == zzcv.MAP.ordinal()) {
                            iArr2[i3] = i5;
                            i3++;
                        } else if (zzfn >= 18 && zzfn <= 49) {
                            iArr3[i4] = iArr[i5 + 1] & 1048575;
                            i4++;
                        }
                        if (!zzfe.next()) {
                            break;
                        }
                        zzcx = zzfe.zzcx();
                    } else {
                        for (int i6 = 0; i6 < 4; i6++) {
                            iArr[i5 + i6] = -1;
                        }
                    }
                    i5 += 4;
                }
            }
            return new zzel<>(iArr, objArr, zzff, zzfg, zzet.zzfl(), zzet.zzey(), z, false, zzet.zzfj(), iArr2, iArr3, zzeo, zzdr, zzfr, zzcp, zzec);
        }
        ((zzfk) zzef).zzew();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzdf<?> zzdf, UB ub, zzfr<UT, UB> zzfr) {
        zzea<?, ?> zzn = this.zztu.zzn(zzan(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (zzdf.zzal(((Integer) next.getValue()).intValue()) == null) {
                if (ub == null) {
                    ub = zzfr.zzgq();
                }
                zzbz zzk = zzbu.zzk(zzdz.zza(zzn, next.getKey(), next.getValue()));
                try {
                    zzdz.zza(zzk.zzby(), zzn, next.getKey(), next.getValue());
                    zzfr.zza(ub, i2, zzk.zzbx());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzfr<UT, UB> zzfr) {
        zzdf<?> zzao;
        int i2 = this.zztd[i];
        Object zzp = zzfx.zzp(obj, (long) (zzap(i) & 1048575));
        if (zzp == null || (zzao = zzao(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zztu.zzi(zzp), zzao, ub, zzfr);
    }

    private static void zza(int i, Object obj, zzgl zzgl) throws IOException {
        if (obj instanceof String) {
            zzgl.zza(i, (String) obj);
        } else {
            zzgl.zza(i, (zzbu) obj);
        }
    }

    private static <UT, UB> void zza(zzfr<UT, UB> zzfr, T t, zzgl zzgl) throws IOException {
        zzfr.zza(zzfr.zzr(t), zzgl);
    }

    private final <K, V> void zza(zzgl zzgl, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzgl.zza(i, this.zztu.zzn(zzan(i2)), this.zztu.zzj(obj));
        }
    }

    private final void zza(Object obj, int i, zzew zzew) throws IOException {
        if (zzar(i)) {
            zzfx.zza(obj, (long) (i & 1048575), (Object) zzew.zzcg());
        } else if (this.zztk) {
            zzfx.zza(obj, (long) (i & 1048575), (Object) zzew.readString());
        } else {
            zzfx.zza(obj, (long) (i & 1048575), (Object) zzew.zzch());
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzap = (long) (zzap(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzfx.zzp(t, zzap);
            Object zzp2 = zzfx.zzp(t2, zzap);
            if (zzp != null && zzp2 != null) {
                zzfx.zza((Object) t, zzap, zzdd.zza(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzfx.zza((Object) t, zzap, zzp2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zztl) {
            int zzap = zzap(i);
            long j = (long) (zzap & 1048575);
            switch ((zzap & 267386880) >>> 20) {
                case 0:
                    return zzfx.zzo(t, j) != 0.0d;
                case 1:
                    return zzfx.zzn(t, j) != 0.0f;
                case 2:
                    return zzfx.zzl(t, j) != 0;
                case 3:
                    return zzfx.zzl(t, j) != 0;
                case 4:
                    return zzfx.zzk(t, j) != 0;
                case 5:
                    return zzfx.zzl(t, j) != 0;
                case 6:
                    return zzfx.zzk(t, j) != 0;
                case 7:
                    return zzfx.zzm(t, j);
                case 8:
                    Object zzp = zzfx.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzbu) {
                        return !zzbu.zzmc.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfx.zzp(t, j) != null;
                case 10:
                    return !zzbu.zzmc.equals(zzfx.zzp(t, j));
                case 11:
                    return zzfx.zzk(t, j) != 0;
                case 12:
                    return zzfx.zzk(t, j) != 0;
                case 13:
                    return zzfx.zzk(t, j) != 0;
                case 14:
                    return zzfx.zzl(t, j) != 0;
                case 15:
                    return zzfx.zzk(t, j) != 0;
                case 16:
                    return zzfx.zzl(t, j) != 0;
                case 17:
                    return zzfx.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzaq = zzaq(i);
            return (zzfx.zzk(t, (long) (zzaq & 1048575)) & (1 << (zzaq >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfx.zzk(t, (long) (zzaq(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zztl ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzex zzex) {
        return zzex.zzp(zzfx.zzp(obj, (long) (1048575 & i)));
    }

    private final zzex zzam(int i) {
        int i2 = (i / 4) << 1;
        zzex zzex = (zzex) this.zzte[i2];
        if (zzex != null) {
            return zzex;
        }
        zzex zzf = zzes.zzfd().zzf((Class) this.zzte[i2 + 1]);
        this.zzte[i2] = zzf;
        return zzf;
    }

    private final Object zzan(int i) {
        return this.zzte[(i / 4) << 1];
    }

    private final zzdf<?> zzao(int i) {
        return (zzdf) this.zzte[((i / 4) << 1) + 1];
    }

    private final int zzap(int i) {
        return this.zztd[i + 1];
    }

    private final int zzaq(int i) {
        return this.zztd[i + 2];
    }

    private static boolean zzar(int i) {
        return (536870912 & i) != 0;
    }

    private final int zzas(int i) {
        if (i >= this.zztf) {
            if (i < this.zzth) {
                int i2 = (i - this.zztf) << 2;
                if (this.zztd[i2] == i) {
                    return i2;
                }
                return -1;
            } else if (i <= this.zztg) {
                int i3 = this.zzth - this.zztf;
                int length = (this.zztd.length / 4) - 1;
                while (i3 <= length) {
                    int i4 = (length + i3) >>> 1;
                    int i5 = i4 << 2;
                    int i6 = this.zztd[i5];
                    if (i == i6) {
                        return i5;
                    }
                    if (i < i6) {
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                return -1;
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (!this.zztl) {
            int zzaq = zzaq(i);
            long j = (long) (zzaq & 1048575);
            zzfx.zzb((Object) t, j, zzfx.zzk(t, j) | (1 << (zzaq >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzfx.zzb((Object) t, (long) (zzaq(i2) & 1048575), i);
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 387 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.firebase_auth.zzgl r19) throws java.io.IOException {
        /*
            r17 = this;
            r3 = 0
            r2 = 0
            r0 = r17
            boolean r4 = r0.zztj
            if (r4 == 0) goto L_0x0022
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzcp<?> r4 = r0.zztt
            r0 = r18
            com.google.android.gms.internal.firebase_auth.zzcs r4 = r4.zzc(r0)
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0022
            java.util.Iterator r3 = r4.iterator()
            java.lang.Object r2 = r3.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
        L_0x0022:
            r6 = -1
            r5 = 0
            r0 = r17
            int[] r4 = r0.zztd
            int r9 = r4.length
            sun.misc.Unsafe r10 = zztc
            r4 = 0
            r8 = r4
            r16 = r5
            r5 = r6
            r6 = r2
            r2 = r16
        L_0x0033:
            if (r8 >= r9) goto L_0x068b
            r0 = r17
            int r11 = r0.zzap(r8)
            r0 = r17
            int[] r4 = r0.zztd
            r12 = r4[r8]
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r11
            int r13 = r4 >>> 20
            r4 = 0
            r0 = r17
            boolean r7 = r0.zztl
            if (r7 != 0) goto L_0x0686
            r7 = 17
            if (r13 > r7) goto L_0x0686
            r0 = r17
            int[] r4 = r0.zztd
            int r7 = r8 + 2
            r7 = r4[r7]
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r4 & r7
            if (r4 == r5) goto L_0x0683
            long r14 = (long) r4
            r0 = r18
            int r2 = r10.getInt(r0, r14)
        L_0x0066:
            r5 = 1
            int r7 = r7 >>> 20
            int r5 = r5 << r7
            r7 = r6
            r6 = r4
            r4 = r5
            r5 = r2
        L_0x006e:
            if (r7 == 0) goto L_0x0093
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r0.zztt
            int r2 = r2.zza(r7)
            if (r2 > r12) goto L_0x0093
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r0.zztt
            r0 = r19
            r2.zza((com.google.android.gms.internal.firebase_auth.zzgl) r0, (java.util.Map.Entry<?, ?>) r7)
            boolean r2 = r3.hasNext()
            if (r2 == 0) goto L_0x0091
            java.lang.Object r2 = r3.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
        L_0x008f:
            r7 = r2
            goto L_0x006e
        L_0x0091:
            r2 = 0
            goto L_0x008f
        L_0x0093:
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r11
            long r14 = (long) r2
            switch(r13) {
                case 0: goto L_0x00a2;
                case 1: goto L_0x00b2;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00d2;
                case 4: goto L_0x00e2;
                case 5: goto L_0x00f2;
                case 6: goto L_0x0102;
                case 7: goto L_0x0112;
                case 8: goto L_0x0123;
                case 9: goto L_0x0134;
                case 10: goto L_0x014b;
                case 11: goto L_0x015e;
                case 12: goto L_0x016f;
                case 13: goto L_0x0180;
                case 14: goto L_0x0191;
                case 15: goto L_0x01a2;
                case 16: goto L_0x01b3;
                case 17: goto L_0x01c4;
                case 18: goto L_0x01db;
                case 19: goto L_0x01f1;
                case 20: goto L_0x0207;
                case 21: goto L_0x021d;
                case 22: goto L_0x0233;
                case 23: goto L_0x0249;
                case 24: goto L_0x025f;
                case 25: goto L_0x0275;
                case 26: goto L_0x028b;
                case 27: goto L_0x02a0;
                case 28: goto L_0x02bb;
                case 29: goto L_0x02d0;
                case 30: goto L_0x02e6;
                case 31: goto L_0x02fc;
                case 32: goto L_0x0312;
                case 33: goto L_0x0328;
                case 34: goto L_0x033e;
                case 35: goto L_0x0354;
                case 36: goto L_0x036a;
                case 37: goto L_0x0380;
                case 38: goto L_0x0396;
                case 39: goto L_0x03ac;
                case 40: goto L_0x03c2;
                case 41: goto L_0x03d8;
                case 42: goto L_0x03ee;
                case 43: goto L_0x0404;
                case 44: goto L_0x041a;
                case 45: goto L_0x0430;
                case 46: goto L_0x0446;
                case 47: goto L_0x045c;
                case 48: goto L_0x0472;
                case 49: goto L_0x0488;
                case 50: goto L_0x04a3;
                case 51: goto L_0x04b2;
                case 52: goto L_0x04c9;
                case 53: goto L_0x04e0;
                case 54: goto L_0x04f7;
                case 55: goto L_0x050e;
                case 56: goto L_0x0525;
                case 57: goto L_0x053c;
                case 58: goto L_0x0553;
                case 59: goto L_0x056a;
                case 60: goto L_0x0581;
                case 61: goto L_0x059e;
                case 62: goto L_0x05b7;
                case 63: goto L_0x05ce;
                case 64: goto L_0x05e5;
                case 65: goto L_0x05fc;
                case 66: goto L_0x0613;
                case 67: goto L_0x062a;
                case 68: goto L_0x0641;
                default: goto L_0x009b;
            }
        L_0x009b:
            int r2 = r8 + 4
            r8 = r2
            r2 = r5
            r5 = r6
            r6 = r7
            goto L_0x0033
        L_0x00a2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            double r14 = com.google.android.gms.internal.firebase_auth.zzfx.zzo(r0, r14)
            r0 = r19
            r0.zza((int) r12, (double) r14)
            goto L_0x009b
        L_0x00b2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            float r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzn(r0, r14)
            r0 = r19
            r0.zza((int) r12, (float) r2)
            goto L_0x009b
        L_0x00c2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = r10.getLong(r0, r14)
            r0 = r19
            r0.zzi(r12, r14)
            goto L_0x009b
        L_0x00d2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = r10.getLong(r0, r14)
            r0 = r19
            r0.zza((int) r12, (long) r14)
            goto L_0x009b
        L_0x00e2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zzc((int) r12, (int) r2)
            goto L_0x009b
        L_0x00f2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = r10.getLong(r0, r14)
            r0 = r19
            r0.zzc((int) r12, (long) r14)
            goto L_0x009b
        L_0x0102:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zzf(r12, r2)
            goto L_0x009b
        L_0x0112:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r0, r14)
            r0 = r19
            r0.zzb((int) r12, (boolean) r2)
            goto L_0x009b
        L_0x0123:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r19
            zza((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0)
            goto L_0x009b
        L_0x0134:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r4 = r0.zzam(r8)
            r0 = r19
            r0.zza((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x009b
        L_0x014b:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            com.google.android.gms.internal.firebase_auth.zzbu r2 = (com.google.android.gms.internal.firebase_auth.zzbu) r2
            r0 = r19
            r0.zza((int) r12, (com.google.android.gms.internal.firebase_auth.zzbu) r2)
            goto L_0x009b
        L_0x015e:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zzd(r12, r2)
            goto L_0x009b
        L_0x016f:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zzn(r12, r2)
            goto L_0x009b
        L_0x0180:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zzm(r12, r2)
            goto L_0x009b
        L_0x0191:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = r10.getLong(r0, r14)
            r0 = r19
            r0.zzj(r12, r14)
            goto L_0x009b
        L_0x01a2:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = r10.getInt(r0, r14)
            r0 = r19
            r0.zze(r12, r2)
            goto L_0x009b
        L_0x01b3:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = r10.getLong(r0, r14)
            r0 = r19
            r0.zzb((int) r12, (long) r14)
            goto L_0x009b
        L_0x01c4:
            r2 = r5 & r4
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r4 = r0.zzam(r8)
            r0 = r19
            r0.zzb((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x009b
        L_0x01db:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r4, (java.util.List<java.lang.Double>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (boolean) r11)
            goto L_0x009b
        L_0x01f1:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r4, (java.util.List<java.lang.Float>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (boolean) r11)
            goto L_0x009b
        L_0x0207:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r4, r2, r0, r11)
            goto L_0x009b
        L_0x021d:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0233:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0249:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r4, r2, r0, r11)
            goto L_0x009b
        L_0x025f:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0275:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r4, r2, r0, r11)
            goto L_0x009b
        L_0x028b:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r4, (java.util.List<java.lang.String>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0)
            goto L_0x009b
        L_0x02a0:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r11 = r0.zzam(r8)
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r4, (java.util.List<?>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (com.google.android.gms.internal.firebase_auth.zzex) r11)
            goto L_0x009b
        L_0x02bb:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzb(r4, r2, r0)
            goto L_0x009b
        L_0x02d0:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r4, r2, r0, r11)
            goto L_0x009b
        L_0x02e6:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r4, r2, r0, r11)
            goto L_0x009b
        L_0x02fc:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0312:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0328:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r4, r2, r0, r11)
            goto L_0x009b
        L_0x033e:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 0
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zze(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0354:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r4, (java.util.List<java.lang.Double>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (boolean) r11)
            goto L_0x009b
        L_0x036a:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r4, (java.util.List<java.lang.Float>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (boolean) r11)
            goto L_0x009b
        L_0x0380:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0396:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r4, r2, r0, r11)
            goto L_0x009b
        L_0x03ac:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r4, r2, r0, r11)
            goto L_0x009b
        L_0x03c2:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r4, r2, r0, r11)
            goto L_0x009b
        L_0x03d8:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r4, r2, r0, r11)
            goto L_0x009b
        L_0x03ee:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0404:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r4, r2, r0, r11)
            goto L_0x009b
        L_0x041a:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0430:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0446:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r4, r2, r0, r11)
            goto L_0x009b
        L_0x045c:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0472:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r11 = 1
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zze(r4, r2, r0, r11)
            goto L_0x009b
        L_0x0488:
            r0 = r17
            int[] r2 = r0.zztd
            r4 = r2[r8]
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            java.util.List r2 = (java.util.List) r2
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r11 = r0.zzam(r8)
            r0 = r19
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r4, (java.util.List<?>) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0, (com.google.android.gms.internal.firebase_auth.zzex) r11)
            goto L_0x009b
        L_0x04a3:
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r17
            r1 = r19
            r0.zza((com.google.android.gms.internal.firebase_auth.zzgl) r1, (int) r12, (java.lang.Object) r2, (int) r8)
            goto L_0x009b
        L_0x04b2:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            double r14 = zzf(r0, r14)
            r0 = r19
            r0.zza((int) r12, (double) r14)
            goto L_0x009b
        L_0x04c9:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            float r2 = zzg(r0, r14)
            r0 = r19
            r0.zza((int) r12, (float) r2)
            goto L_0x009b
        L_0x04e0:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = zzi(r0, r14)
            r0 = r19
            r0.zzi(r12, r14)
            goto L_0x009b
        L_0x04f7:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = zzi(r0, r14)
            r0 = r19
            r0.zza((int) r12, (long) r14)
            goto L_0x009b
        L_0x050e:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zzc((int) r12, (int) r2)
            goto L_0x009b
        L_0x0525:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = zzi(r0, r14)
            r0 = r19
            r0.zzc((int) r12, (long) r14)
            goto L_0x009b
        L_0x053c:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zzf(r12, r2)
            goto L_0x009b
        L_0x0553:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            boolean r2 = zzj(r0, r14)
            r0 = r19
            r0.zzb((int) r12, (boolean) r2)
            goto L_0x009b
        L_0x056a:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r19
            zza((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzgl) r0)
            goto L_0x009b
        L_0x0581:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r4 = r0.zzam(r8)
            r0 = r19
            r0.zza((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x009b
        L_0x059e:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            com.google.android.gms.internal.firebase_auth.zzbu r2 = (com.google.android.gms.internal.firebase_auth.zzbu) r2
            r0 = r19
            r0.zza((int) r12, (com.google.android.gms.internal.firebase_auth.zzbu) r2)
            goto L_0x009b
        L_0x05b7:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zzd(r12, r2)
            goto L_0x009b
        L_0x05ce:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zzn(r12, r2)
            goto L_0x009b
        L_0x05e5:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zzm(r12, r2)
            goto L_0x009b
        L_0x05fc:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = zzi(r0, r14)
            r0 = r19
            r0.zzj(r12, r14)
            goto L_0x009b
        L_0x0613:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            int r2 = zzh(r0, r14)
            r0 = r19
            r0.zze(r12, r2)
            goto L_0x009b
        L_0x062a:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            long r14 = zzi(r0, r14)
            r0 = r19
            r0.zzb((int) r12, (long) r14)
            goto L_0x009b
        L_0x0641:
            r0 = r17
            r1 = r18
            boolean r2 = r0.zza(r1, (int) r12, (int) r8)
            if (r2 == 0) goto L_0x009b
            r0 = r18
            java.lang.Object r2 = r10.getObject(r0, r14)
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzex r4 = r0.zzam(r8)
            r0 = r19
            r0.zzb((int) r12, (java.lang.Object) r2, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x009b
        L_0x065e:
            r2 = 0
        L_0x065f:
            if (r2 == 0) goto L_0x0677
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzcp<?> r4 = r0.zztt
            r0 = r19
            r4.zza((com.google.android.gms.internal.firebase_auth.zzgl) r0, (java.util.Map.Entry<?, ?>) r2)
            boolean r2 = r3.hasNext()
            if (r2 == 0) goto L_0x065e
            java.lang.Object r2 = r3.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            goto L_0x065f
        L_0x0677:
            r0 = r17
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r2 = r0.zzts
            r0 = r18
            r1 = r19
            zza(r2, r0, (com.google.android.gms.internal.firebase_auth.zzgl) r1)
            return
        L_0x0683:
            r4 = r5
            goto L_0x0066
        L_0x0686:
            r7 = r6
            r6 = r5
            r5 = r2
            goto L_0x006e
        L_0x068b:
            r2 = r6
            goto L_0x065f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzgl):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzap = zzap(i);
        int i2 = this.zztd[i];
        long j = (long) (zzap & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzfx.zzp(t, j);
            Object zzp2 = zzfx.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzfx.zza((Object) t, j, zzdd.zza(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzfx.zza((Object) t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zzfx.zzp(obj, j);
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzfx.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzfx.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzfx.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzfx.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzfx.zzp(t, j)).booleanValue();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r12, T r13) {
        /*
            r11 = this;
            r1 = 1
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r0 = 0
            int[] r2 = r11.zztd
            int r4 = r2.length
            r3 = r0
        L_0x0009:
            if (r3 >= r4) goto L_0x01cf
            int r2 = r11.zzap(r3)
            r5 = r2 & r10
            long r6 = (long) r5
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r2 = r2 & r5
            int r2 = r2 >>> 20
            switch(r2) {
                case 0: goto L_0x001e;
                case 1: goto L_0x0032;
                case 2: goto L_0x0044;
                case 3: goto L_0x0058;
                case 4: goto L_0x006c;
                case 5: goto L_0x007e;
                case 6: goto L_0x0092;
                case 7: goto L_0x00a5;
                case 8: goto L_0x00b8;
                case 9: goto L_0x00cf;
                case 10: goto L_0x00e6;
                case 11: goto L_0x00fd;
                case 12: goto L_0x0110;
                case 13: goto L_0x0123;
                case 14: goto L_0x0136;
                case 15: goto L_0x014b;
                case 16: goto L_0x015e;
                case 17: goto L_0x0173;
                case 18: goto L_0x018a;
                case 19: goto L_0x018a;
                case 20: goto L_0x018a;
                case 21: goto L_0x018a;
                case 22: goto L_0x018a;
                case 23: goto L_0x018a;
                case 24: goto L_0x018a;
                case 25: goto L_0x018a;
                case 26: goto L_0x018a;
                case 27: goto L_0x018a;
                case 28: goto L_0x018a;
                case 29: goto L_0x018a;
                case 30: goto L_0x018a;
                case 31: goto L_0x018a;
                case 32: goto L_0x018a;
                case 33: goto L_0x018a;
                case 34: goto L_0x018a;
                case 35: goto L_0x018a;
                case 36: goto L_0x018a;
                case 37: goto L_0x018a;
                case 38: goto L_0x018a;
                case 39: goto L_0x018a;
                case 40: goto L_0x018a;
                case 41: goto L_0x018a;
                case 42: goto L_0x018a;
                case 43: goto L_0x018a;
                case 44: goto L_0x018a;
                case 45: goto L_0x018a;
                case 46: goto L_0x018a;
                case 47: goto L_0x018a;
                case 48: goto L_0x018a;
                case 49: goto L_0x018a;
                case 50: goto L_0x0198;
                case 51: goto L_0x01a6;
                case 52: goto L_0x01a6;
                case 53: goto L_0x01a6;
                case 54: goto L_0x01a6;
                case 55: goto L_0x01a6;
                case 56: goto L_0x01a6;
                case 57: goto L_0x01a6;
                case 58: goto L_0x01a6;
                case 59: goto L_0x01a6;
                case 60: goto L_0x01a6;
                case 61: goto L_0x01a6;
                case 62: goto L_0x01a6;
                case 63: goto L_0x01a6;
                case 64: goto L_0x01a6;
                case 65: goto L_0x01a6;
                case 66: goto L_0x01a6;
                case 67: goto L_0x01a6;
                case 68: goto L_0x01a6;
                default: goto L_0x001a;
            }
        L_0x001a:
            r2 = r1
        L_0x001b:
            if (r2 != 0) goto L_0x01ca
        L_0x001d:
            return r0
        L_0x001e:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0030
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x0030:
            r2 = r0
            goto L_0x001b
        L_0x0032:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0042
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x0042:
            r2 = r0
            goto L_0x001b
        L_0x0044:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0056
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x0056:
            r2 = r0
            goto L_0x001b
        L_0x0058:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x006a
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x006a:
            r2 = r0
            goto L_0x001b
        L_0x006c:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x007c
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x007c:
            r2 = r0
            goto L_0x001b
        L_0x007e:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0090
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x0090:
            r2 = r0
            goto L_0x001b
        L_0x0092:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x00a2
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x00a2:
            r2 = r0
            goto L_0x001b
        L_0x00a5:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x00b5
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r12, r6)
            boolean r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x00b5:
            r2 = r0
            goto L_0x001b
        L_0x00b8:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x00cc
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x001a
        L_0x00cc:
            r2 = r0
            goto L_0x001b
        L_0x00cf:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x00e3
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x001a
        L_0x00e3:
            r2 = r0
            goto L_0x001b
        L_0x00e6:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x00fa
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x001a
        L_0x00fa:
            r2 = r0
            goto L_0x001b
        L_0x00fd:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x010d
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x010d:
            r2 = r0
            goto L_0x001b
        L_0x0110:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0120
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x0120:
            r2 = r0
            goto L_0x001b
        L_0x0123:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0133
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x0133:
            r2 = r0
            goto L_0x001b
        L_0x0136:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0148
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x0148:
            r2 = r0
            goto L_0x001b
        L_0x014b:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x015b
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r6)
            if (r2 == r5) goto L_0x001a
        L_0x015b:
            r2 = r0
            goto L_0x001b
        L_0x015e:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0170
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r12, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r13, r6)
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x001a
        L_0x0170:
            r2 = r0
            goto L_0x001b
        L_0x0173:
            boolean r2 = r11.zzc(r12, r13, r3)
            if (r2 == 0) goto L_0x0187
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x001a
        L_0x0187:
            r2 = r0
            goto L_0x001b
        L_0x018a:
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            goto L_0x001b
        L_0x0198:
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            goto L_0x001b
        L_0x01a6:
            int r2 = r11.zzaq(r3)
            r5 = r2 & r10
            long r8 = (long) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r12, r8)
            r2 = r2 & r10
            long r8 = (long) r2
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r13, r8)
            if (r5 != r2) goto L_0x01c7
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r12, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r6)
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzez.zzd((java.lang.Object) r2, (java.lang.Object) r5)
            if (r2 != 0) goto L_0x001a
        L_0x01c7:
            r2 = r0
            goto L_0x001b
        L_0x01ca:
            int r2 = r3 + 4
            r3 = r2
            goto L_0x0009
        L_0x01cf:
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r2 = r11.zzts
            java.lang.Object r2 = r2.zzr(r12)
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r3 = r11.zzts
            java.lang.Object r3 = r3.zzr(r13)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001d
            boolean r0 = r11.zztj
            if (r0 == 0) goto L_0x01f7
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r11.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r0 = r0.zzc(r12)
            com.google.android.gms.internal.firebase_auth.zzcp<?> r1 = r11.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r1 = r1.zzc(r13)
            boolean r0 = r0.equals(r1)
            goto L_0x001d
        L_0x01f7:
            r0 = r1
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r10) {
        /*
            r9 = this;
            r1 = 37
            r0 = 0
            int[] r2 = r9.zztd
            int r4 = r2.length
            r3 = r0
            r2 = r0
        L_0x0008:
            if (r3 >= r4) goto L_0x0255
            int r0 = r9.zzap(r3)
            int[] r5 = r9.zztd
            r5 = r5[r3]
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r6 & r0
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r8
            int r0 = r0 >>> 20
            switch(r0) {
                case 0: goto L_0x0025;
                case 1: goto L_0x0035;
                case 2: goto L_0x0041;
                case 3: goto L_0x004d;
                case 4: goto L_0x0059;
                case 5: goto L_0x0061;
                case 6: goto L_0x006d;
                case 7: goto L_0x0075;
                case 8: goto L_0x0081;
                case 9: goto L_0x008f;
                case 10: goto L_0x009d;
                case 11: goto L_0x00aa;
                case 12: goto L_0x00b3;
                case 13: goto L_0x00bc;
                case 14: goto L_0x00c5;
                case 15: goto L_0x00d2;
                case 16: goto L_0x00db;
                case 17: goto L_0x00e8;
                case 18: goto L_0x00f7;
                case 19: goto L_0x00f7;
                case 20: goto L_0x00f7;
                case 21: goto L_0x00f7;
                case 22: goto L_0x00f7;
                case 23: goto L_0x00f7;
                case 24: goto L_0x00f7;
                case 25: goto L_0x00f7;
                case 26: goto L_0x00f7;
                case 27: goto L_0x00f7;
                case 28: goto L_0x00f7;
                case 29: goto L_0x00f7;
                case 30: goto L_0x00f7;
                case 31: goto L_0x00f7;
                case 32: goto L_0x00f7;
                case 33: goto L_0x00f7;
                case 34: goto L_0x00f7;
                case 35: goto L_0x00f7;
                case 36: goto L_0x00f7;
                case 37: goto L_0x00f7;
                case 38: goto L_0x00f7;
                case 39: goto L_0x00f7;
                case 40: goto L_0x00f7;
                case 41: goto L_0x00f7;
                case 42: goto L_0x00f7;
                case 43: goto L_0x00f7;
                case 44: goto L_0x00f7;
                case 45: goto L_0x00f7;
                case 46: goto L_0x00f7;
                case 47: goto L_0x00f7;
                case 48: goto L_0x00f7;
                case 49: goto L_0x00f7;
                case 50: goto L_0x0104;
                case 51: goto L_0x0111;
                case 52: goto L_0x0128;
                case 53: goto L_0x013b;
                case 54: goto L_0x014e;
                case 55: goto L_0x0161;
                case 56: goto L_0x0170;
                case 57: goto L_0x0183;
                case 58: goto L_0x0192;
                case 59: goto L_0x01a5;
                case 60: goto L_0x01ba;
                case 61: goto L_0x01cd;
                case 62: goto L_0x01e0;
                case 63: goto L_0x01ef;
                case 64: goto L_0x01fe;
                case 65: goto L_0x020d;
                case 66: goto L_0x0220;
                case 67: goto L_0x022f;
                case 68: goto L_0x0242;
                default: goto L_0x001f;
            }
        L_0x001f:
            r0 = r2
        L_0x0020:
            int r2 = r3 + 4
            r3 = r2
            r2 = r0
            goto L_0x0008
        L_0x0025:
            int r0 = r2 * 53
            double r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzo(r10, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0035:
            int r0 = r2 * 53
            float r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzn(r10, r6)
            int r2 = java.lang.Float.floatToIntBits(r2)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0041:
            int r0 = r2 * 53
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x004d:
            int r0 = r2 * 53
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0059:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0061:
            int r0 = r2 * 53
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x006d:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0075:
            int r0 = r2 * 53
            boolean r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzi(r2)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0081:
            int r2 = r2 * 53
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x008f:
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            if (r0 == 0) goto L_0x0277
            int r0 = r0.hashCode()
        L_0x0099:
            int r2 = r2 * 53
            int r0 = r0 + r2
            goto L_0x0020
        L_0x009d:
            int r0 = r2 * 53
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00aa:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00b3:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00bc:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00c5:
            int r0 = r2 * 53
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00d2:
            int r0 = r2 * 53
            int r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00db:
            int r0 = r2 * 53
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00e8:
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            if (r0 == 0) goto L_0x0274
            int r0 = r0.hashCode()
        L_0x00f2:
            int r2 = r2 * 53
            int r0 = r0 + r2
            goto L_0x0020
        L_0x00f7:
            int r0 = r2 * 53
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0104:
            int r0 = r2 * 53
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0111:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            double r6 = zzf(r10, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0128:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            float r2 = zzg(r10, r6)
            int r2 = java.lang.Float.floatToIntBits(r2)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x013b:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            long r6 = zzi(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x014e:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            long r6 = zzi(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0161:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0170:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            long r6 = zzi(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0183:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0192:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            boolean r2 = zzj(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzi(r2)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01a5:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r2 = r2 * 53
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            java.lang.String r0 = (java.lang.String) r0
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01ba:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2 * 53
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01cd:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01e0:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01ef:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x01fe:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x020d:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            long r6 = zzi(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0220:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            int r2 = zzh(r10, r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x022f:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            int r0 = r2 * 53
            long r6 = zzi(r10, r6)
            int r2 = com.google.android.gms.internal.firebase_auth.zzdd.zzk(r6)
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0242:
            boolean r0 = r9.zza(r10, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x001f
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r10, r6)
            int r2 = r2 * 53
            int r0 = r0.hashCode()
            int r0 = r0 + r2
            goto L_0x0020
        L_0x0255:
            int r0 = r2 * 53
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r1 = r9.zzts
            java.lang.Object r1 = r1.zzr(r10)
            int r1 = r1.hashCode()
            int r0 = r0 + r1
            boolean r1 = r9.zztj
            if (r1 == 0) goto L_0x0273
            int r0 = r0 * 53
            com.google.android.gms.internal.firebase_auth.zzcp<?> r1 = r9.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r1 = r1.zzc(r10)
            int r1 = r1.hashCode()
            int r0 = r0 + r1
        L_0x0273:
            return r0
        L_0x0274:
            r0 = r1
            goto L_0x00f2
        L_0x0277:
            r0 = r1
            goto L_0x0099
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.hashCode(java.lang.Object):int");
    }

    public final T newInstance() {
        return this.zztq.newInstance(this.zzti);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r13, com.google.android.gms.internal.firebase_auth.zzew r14, com.google.android.gms.internal.firebase_auth.zzco r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r15 != 0) goto L_0x0008
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            throw r0
        L_0x0008:
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r6 = r12.zzts
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r12.zztt
            r5 = 0
            r4 = 0
        L_0x000e:
            int r1 = r14.zzcx()     // Catch:{ all -> 0x00e9 }
            int r2 = r12.zzas(r1)     // Catch:{ all -> 0x00e9 }
            if (r2 >= 0) goto L_0x0079
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x0036
            int[] r0 = r12.zzto
            if (r0 == 0) goto L_0x0030
            int[] r1 = r12.zzto
            int r2 = r1.length
            r0 = 0
        L_0x0025:
            if (r0 >= r2) goto L_0x0030
            r3 = r1[r0]
            java.lang.Object r5 = r12.zza((java.lang.Object) r13, (int) r3, r5, r6)
            int r0 = r0 + 1
            goto L_0x0025
        L_0x0030:
            if (r5 == 0) goto L_0x0035
            r6.zzf(r13, r5)
        L_0x0035:
            return
        L_0x0036:
            boolean r2 = r12.zztj     // Catch:{ all -> 0x00e9 }
            if (r2 != 0) goto L_0x004a
            r2 = 0
        L_0x003b:
            if (r2 == 0) goto L_0x0051
            if (r4 != 0) goto L_0x0043
            com.google.android.gms.internal.firebase_auth.zzcs r4 = r0.zzd(r13)     // Catch:{ all -> 0x00e9 }
        L_0x0043:
            r1 = r14
            r3 = r15
            java.lang.Object r5 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e9 }
            goto L_0x000e
        L_0x004a:
            com.google.android.gms.internal.firebase_auth.zzeh r2 = r12.zzti     // Catch:{ all -> 0x00e9 }
            java.lang.Object r2 = r0.zza(r15, r2, r1)     // Catch:{ all -> 0x00e9 }
            goto L_0x003b
        L_0x0051:
            r6.zza(r14)     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x005a
            java.lang.Object r5 = r6.zzs(r13)     // Catch:{ all -> 0x00e9 }
        L_0x005a:
            boolean r1 = r6.zza(r5, (com.google.android.gms.internal.firebase_auth.zzew) r14)     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x000e
            int[] r0 = r12.zzto
            if (r0 == 0) goto L_0x0073
            int[] r1 = r12.zzto
            int r2 = r1.length
            r0 = 0
        L_0x0068:
            if (r0 >= r2) goto L_0x0073
            r3 = r1[r0]
            java.lang.Object r5 = r12.zza((java.lang.Object) r13, (int) r3, r5, r6)
            int r0 = r0 + 1
            goto L_0x0068
        L_0x0073:
            if (r5 == 0) goto L_0x0035
            r6.zzf(r13, r5)
            goto L_0x0035
        L_0x0079:
            int r3 = r12.zzap(r2)     // Catch:{ all -> 0x00e9 }
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r7 = r7 & r3
            int r7 = r7 >>> 20
            switch(r7) {
                case 0: goto L_0x00a4;
                case 1: goto L_0x00d8;
                case 2: goto L_0x00fd;
                case 3: goto L_0x010e;
                case 4: goto L_0x011f;
                case 5: goto L_0x0130;
                case 6: goto L_0x0141;
                case 7: goto L_0x0152;
                case 8: goto L_0x0163;
                case 9: goto L_0x016b;
                case 10: goto L_0x01a5;
                case 11: goto L_0x01b6;
                case 12: goto L_0x01c7;
                case 13: goto L_0x01ea;
                case 14: goto L_0x01fb;
                case 15: goto L_0x020c;
                case 16: goto L_0x021d;
                case 17: goto L_0x022e;
                case 18: goto L_0x0268;
                case 19: goto L_0x0278;
                case 20: goto L_0x0288;
                case 21: goto L_0x0298;
                case 22: goto L_0x02a8;
                case 23: goto L_0x02b8;
                case 24: goto L_0x02c8;
                case 25: goto L_0x02d8;
                case 26: goto L_0x02e8;
                case 27: goto L_0x030e;
                case 28: goto L_0x0322;
                case 29: goto L_0x0332;
                case 30: goto L_0x0342;
                case 31: goto L_0x035a;
                case 32: goto L_0x036a;
                case 33: goto L_0x037a;
                case 34: goto L_0x038a;
                case 35: goto L_0x039a;
                case 36: goto L_0x03aa;
                case 37: goto L_0x03ba;
                case 38: goto L_0x03ca;
                case 39: goto L_0x03da;
                case 40: goto L_0x03ea;
                case 41: goto L_0x03fa;
                case 42: goto L_0x040a;
                case 43: goto L_0x041a;
                case 44: goto L_0x042a;
                case 45: goto L_0x0442;
                case 46: goto L_0x0452;
                case 47: goto L_0x0462;
                case 48: goto L_0x0472;
                case 49: goto L_0x0482;
                case 50: goto L_0x0496;
                case 51: goto L_0x04da;
                case 52: goto L_0x04ef;
                case 53: goto L_0x0504;
                case 54: goto L_0x0519;
                case 55: goto L_0x052e;
                case 56: goto L_0x0543;
                case 57: goto L_0x0558;
                case 58: goto L_0x056d;
                case 59: goto L_0x0582;
                case 60: goto L_0x058a;
                case 61: goto L_0x05c6;
                case 62: goto L_0x05d7;
                case 63: goto L_0x05ec;
                case 64: goto L_0x0613;
                case 65: goto L_0x0628;
                case 66: goto L_0x063d;
                case 67: goto L_0x0652;
                case 68: goto L_0x0667;
                default: goto L_0x0085;
            }
        L_0x0085:
            if (r5 != 0) goto L_0x008b
            java.lang.Object r5 = r6.zzgq()     // Catch:{ zzdi -> 0x00b5 }
        L_0x008b:
            boolean r1 = r6.zza(r5, (com.google.android.gms.internal.firebase_auth.zzew) r14)     // Catch:{ zzdi -> 0x00b5 }
            if (r1 != 0) goto L_0x000e
            int[] r0 = r12.zzto
            if (r0 == 0) goto L_0x067c
            int[] r1 = r12.zzto
            int r2 = r1.length
            r0 = 0
        L_0x0099:
            if (r0 >= r2) goto L_0x067c
            r3 = r1[r0]
            java.lang.Object r5 = r12.zza((java.lang.Object) r13, (int) r3, r5, r6)
            int r0 = r0 + 1
            goto L_0x0099
        L_0x00a4:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1
            double r10 = r14.readDouble()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (double) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x00b5:
            r1 = move-exception
            r6.zza(r14)     // Catch:{ all -> 0x00e9 }
            if (r5 != 0) goto L_0x00bf
            java.lang.Object r5 = r6.zzs(r13)     // Catch:{ all -> 0x00e9 }
        L_0x00bf:
            boolean r1 = r6.zza(r5, (com.google.android.gms.internal.firebase_auth.zzew) r14)     // Catch:{ all -> 0x00e9 }
            if (r1 != 0) goto L_0x000e
            int[] r0 = r12.zzto
            if (r0 == 0) goto L_0x0683
            int[] r1 = r12.zzto
            int r2 = r1.length
            r0 = 0
        L_0x00cd:
            if (r0 >= r2) goto L_0x0683
            r3 = r1[r0]
            java.lang.Object r5 = r12.zza((java.lang.Object) r13, (int) r3, r5, r6)
            int r0 = r0 + 1
            goto L_0x00cd
        L_0x00d8:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1
            float r1 = r14.readFloat()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (float) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x00e9:
            r0 = move-exception
            int[] r1 = r12.zzto
            if (r1 == 0) goto L_0x068a
            int[] r2 = r12.zzto
            int r3 = r2.length
            r1 = 0
        L_0x00f2:
            if (r1 >= r3) goto L_0x068a
            r4 = r2[r1]
            java.lang.Object r5 = r12.zza((java.lang.Object) r13, (int) r4, r5, r6)
            int r1 = r1 + 1
            goto L_0x00f2
        L_0x00fd:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1
            long r10 = r14.zzcb()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (long) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x010e:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzca()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (long) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x011f:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r14.zzcc()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0130:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcd()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (long) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0141:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r14.zzce()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0152:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            boolean r1 = r14.zzcf()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (boolean) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0163:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.firebase_auth.zzew) r14)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x016b:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r1 == 0) goto L_0x0190
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r2 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = com.google.android.gms.internal.firebase_auth.zzdd.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0190:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r1 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = r14.zza(r1, r15)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01a5:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzbu r1 = r14.zzch()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01b6:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r14.zzci()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01c7:
            int r7 = r14.zzcj()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdf r8 = r12.zzao(r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r8 == 0) goto L_0x01d7
            com.google.android.gms.internal.firebase_auth.zzde r8 = r8.zzal(r7)     // Catch:{ zzdi -> 0x00b5 }
            if (r8 == 0) goto L_0x01e4
        L_0x01d7:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r7)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01e4:
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzez.zza((int) r1, (int) r7, r5, r6)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01ea:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r14.zzck()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x01fb:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcl()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (long) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x020c:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r14.zzcm()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zzb((java.lang.Object) r13, (long) r8, (int) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x021d:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcn()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (long) r10)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x022e:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r1 == 0) goto L_0x0253
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r2 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = com.google.android.gms.internal.firebase_auth.zzdd.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0253:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r1 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = r14.zzb(r1, r15)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0268:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzc(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0278:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzd(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0288:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzf(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0298:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zze(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02a8:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzg(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02b8:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzh(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02c8:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzi(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02d8:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzj(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02e8:
            boolean r1 = zzar(r3)     // Catch:{ zzdi -> 0x00b5 }
            if (r1 == 0) goto L_0x02fe
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzk(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x02fe:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.readStringList(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x030e:
            com.google.android.gms.internal.firebase_auth.zzex r1 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdr r7 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r2 = r7.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zza(r2, r1, (com.google.android.gms.internal.firebase_auth.zzco) r15)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0322:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzl(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0332:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzm(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0342:
            com.google.android.gms.internal.firebase_auth.zzdr r7 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r8
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r3 = r7.zza(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzn(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdf r2 = r12.zzao(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzez.zza(r1, r3, r2, r5, r6)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x035a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzo(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x036a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzp(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x037a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzq(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x038a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzr(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x039a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzc(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03aa:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzd(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03ba:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzf(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03ca:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zze(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03da:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzg(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03ea:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzh(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x03fa:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzi(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x040a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzj(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x041a:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzm(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x042a:
            com.google.android.gms.internal.firebase_auth.zzdr r7 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r8
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r3 = r7.zza(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzn(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdf r2 = r12.zzao(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzez.zza(r1, r3, r2, r5, r6)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0442:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzo(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0452:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzp(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0462:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzq(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0472:
            com.google.android.gms.internal.firebase_auth.zzdr r1 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r3
            long r2 = (long) r2     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzr(r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0482:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r3
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r1 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdr r2 = r12.zztr     // Catch:{ zzdi -> 0x00b5 }
            java.util.List r2 = r2.zza(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            r14.zzb(r2, r1, r15)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0496:
            java.lang.Object r3 = r12.zzan(r2)     // Catch:{ zzdi -> 0x00b5 }
            int r1 = r12.zzap(r2)     // Catch:{ zzdi -> 0x00b5 }
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r2
            long r8 = (long) r1     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r2 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            if (r2 != 0) goto L_0x04c3
            com.google.android.gms.internal.firebase_auth.zzec r1 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = r1.zzm(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
        L_0x04b2:
            com.google.android.gms.internal.firebase_auth.zzec r2 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            java.util.Map r1 = r2.zzi(r1)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzec r2 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzea r2 = r2.zzn(r3)     // Catch:{ zzdi -> 0x00b5 }
            r14.zza(r1, r2, (com.google.android.gms.internal.firebase_auth.zzco) r15)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x04c3:
            com.google.android.gms.internal.firebase_auth.zzec r1 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            boolean r1 = r1.zzk(r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r1 == 0) goto L_0x0690
            com.google.android.gms.internal.firebase_auth.zzec r1 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r1 = r1.zzm(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzec r7 = r12.zztu     // Catch:{ zzdi -> 0x00b5 }
            r7.zzb(r1, r2)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r1)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x04b2
        L_0x04da:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            double r10 = r14.readDouble()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Double r3 = java.lang.Double.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x04ef:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            float r3 = r14.readFloat()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Float r3 = java.lang.Float.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0504:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcb()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0519:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzca()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x052e:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            int r3 = r14.zzcc()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0543:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcd()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0558:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            int r3 = r14.zzce()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x056d:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            boolean r3 = r14.zzcf()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0582:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.firebase_auth.zzew) r14)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x058a:
            boolean r7 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r7 == 0) goto L_0x05b2
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r3
            long r8 = (long) r7     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r8)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r8 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r8 = r14.zza(r8, r15)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzdd.zza((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ zzdi -> 0x00b5 }
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r8
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r7)     // Catch:{ zzdi -> 0x00b5 }
        L_0x05ad:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x05b2:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r3 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x05ad
        L_0x05c6:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzbu r3 = r14.zzch()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x05d7:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            int r3 = r14.zzci()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x05ec:
            int r7 = r14.zzcj()     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzdf r8 = r12.zzao(r2)     // Catch:{ zzdi -> 0x00b5 }
            if (r8 == 0) goto L_0x05fc
            com.google.android.gms.internal.firebase_auth.zzde r8 = r8.zzal(r7)     // Catch:{ zzdi -> 0x00b5 }
            if (r8 == 0) goto L_0x060d
        L_0x05fc:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r8
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x060d:
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzez.zza((int) r1, (int) r7, r5, r6)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0613:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            int r3 = r14.zzck()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0628:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcl()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x063d:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            int r3 = r14.zzcm()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0652:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            long r10 = r14.zzcn()     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Long r3 = java.lang.Long.valueOf(r10)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x0667:
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r3 = r3 & r7
            long r8 = (long) r3     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzex r3 = r12.zzam(r2)     // Catch:{ zzdi -> 0x00b5 }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzdi -> 0x00b5 }
            com.google.android.gms.internal.firebase_auth.zzfx.zza((java.lang.Object) r13, (long) r8, (java.lang.Object) r3)     // Catch:{ zzdi -> 0x00b5 }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzdi -> 0x00b5 }
            goto L_0x000e
        L_0x067c:
            if (r5 == 0) goto L_0x0035
            r6.zzf(r13, r5)
            goto L_0x0035
        L_0x0683:
            if (r5 == 0) goto L_0x0035
            r6.zzf(r13, r5)
            goto L_0x0035
        L_0x068a:
            if (r5 == 0) goto L_0x068f
            r6.zzf(r13, r5)
        L_0x068f:
            throw r0
        L_0x0690:
            r1 = r2
            goto L_0x04b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzew, com.google.android.gms.internal.firebase_auth.zzco):void");
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 547 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r11, com.google.android.gms.internal.firebase_auth.zzgl r12) throws java.io.IOException {
        /*
            r10 = this;
            int r0 = r12.zzdc()
            int r1 = com.google.android.gms.internal.firebase_auth.zzdb.zze.zzrk
            if (r0 != r1) goto L_0x060b
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r0 = r10.zzts
            zza(r0, r11, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            r1 = 0
            r0 = 0
            boolean r2 = r10.zztj
            if (r2 == 0) goto L_0x0029
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r10.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r2 = r2.zzc(r11)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x0029
            java.util.Iterator r1 = r2.descendingIterator()
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
        L_0x0029:
            int[] r2 = r10.zztd
            int r2 = r2.length
            int r2 = r2 + -4
            r3 = r2
        L_0x002f:
            if (r3 < 0) goto L_0x05f7
            int r4 = r10.zzap(r3)
            int[] r2 = r10.zztd
            r5 = r2[r3]
            r2 = r0
        L_0x003a:
            if (r2 == 0) goto L_0x0059
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r10.zztt
            int r0 = r0.zza(r2)
            if (r0 <= r5) goto L_0x0059
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r10.zztt
            r0.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (java.util.Map.Entry<?, ?>) r2)
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
        L_0x0055:
            r2 = r0
            goto L_0x003a
        L_0x0057:
            r0 = 0
            goto L_0x0055
        L_0x0059:
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r4
            int r0 = r0 >>> 20
            switch(r0) {
                case 0: goto L_0x0066;
                case 1: goto L_0x0079;
                case 2: goto L_0x008c;
                case 3: goto L_0x009f;
                case 4: goto L_0x00b2;
                case 5: goto L_0x00c5;
                case 6: goto L_0x00d8;
                case 7: goto L_0x00ec;
                case 8: goto L_0x0100;
                case 9: goto L_0x0114;
                case 10: goto L_0x012c;
                case 11: goto L_0x0142;
                case 12: goto L_0x0156;
                case 13: goto L_0x016a;
                case 14: goto L_0x017e;
                case 15: goto L_0x0192;
                case 16: goto L_0x01a6;
                case 17: goto L_0x01ba;
                case 18: goto L_0x01d2;
                case 19: goto L_0x01e7;
                case 20: goto L_0x01fc;
                case 21: goto L_0x0211;
                case 22: goto L_0x0226;
                case 23: goto L_0x023b;
                case 24: goto L_0x0250;
                case 25: goto L_0x0265;
                case 26: goto L_0x027a;
                case 27: goto L_0x028e;
                case 28: goto L_0x02a6;
                case 29: goto L_0x02ba;
                case 30: goto L_0x02cf;
                case 31: goto L_0x02e4;
                case 32: goto L_0x02f9;
                case 33: goto L_0x030e;
                case 34: goto L_0x0323;
                case 35: goto L_0x0338;
                case 36: goto L_0x034d;
                case 37: goto L_0x0362;
                case 38: goto L_0x0377;
                case 39: goto L_0x038c;
                case 40: goto L_0x03a1;
                case 41: goto L_0x03b6;
                case 42: goto L_0x03cb;
                case 43: goto L_0x03e0;
                case 44: goto L_0x03f5;
                case 45: goto L_0x040a;
                case 46: goto L_0x041f;
                case 47: goto L_0x0434;
                case 48: goto L_0x0449;
                case 49: goto L_0x045e;
                case 50: goto L_0x0476;
                case 51: goto L_0x0484;
                case 52: goto L_0x0498;
                case 53: goto L_0x04ac;
                case 54: goto L_0x04c0;
                case 55: goto L_0x04d4;
                case 56: goto L_0x04e8;
                case 57: goto L_0x04fc;
                case 58: goto L_0x0510;
                case 59: goto L_0x0524;
                case 60: goto L_0x0538;
                case 61: goto L_0x0550;
                case 62: goto L_0x0566;
                case 63: goto L_0x057a;
                case 64: goto L_0x058e;
                case 65: goto L_0x05a2;
                case 66: goto L_0x05b6;
                case 67: goto L_0x05ca;
                case 68: goto L_0x05de;
                default: goto L_0x0061;
            }
        L_0x0061:
            int r0 = r3 + -4
            r3 = r0
            r0 = r2
            goto L_0x002f
        L_0x0066:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            double r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzo(r11, r6)
            r12.zza((int) r5, (double) r6)
            goto L_0x0061
        L_0x0079:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            float r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzn(r11, r6)
            r12.zza((int) r5, (float) r0)
            goto L_0x0061
        L_0x008c:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r6)
            r12.zzi(r5, r6)
            goto L_0x0061
        L_0x009f:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r6)
            r12.zza((int) r5, (long) r6)
            goto L_0x0061
        L_0x00b2:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zzc((int) r5, (int) r0)
            goto L_0x0061
        L_0x00c5:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r6)
            r12.zzc((int) r5, (long) r6)
            goto L_0x0061
        L_0x00d8:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zzf(r5, r0)
            goto L_0x0061
        L_0x00ec:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            boolean r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r11, r6)
            r12.zzb((int) r5, (boolean) r0)
            goto L_0x0061
        L_0x0100:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            zza((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0061
        L_0x0114:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            r12.zza((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x012c:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzbu r0 = (com.google.android.gms.internal.firebase_auth.zzbu) r0
            r12.zza((int) r5, (com.google.android.gms.internal.firebase_auth.zzbu) r0)
            goto L_0x0061
        L_0x0142:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zzd(r5, r0)
            goto L_0x0061
        L_0x0156:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zzn(r5, r0)
            goto L_0x0061
        L_0x016a:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zzm(r5, r0)
            goto L_0x0061
        L_0x017e:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r6)
            r12.zzj(r5, r6)
            goto L_0x0061
        L_0x0192:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r6)
            r12.zze(r5, r0)
            goto L_0x0061
        L_0x01a6:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r6)
            r12.zzb((int) r5, (long) r6)
            goto L_0x0061
        L_0x01ba:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            r12.zzb((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x01d2:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r5, (java.util.List<java.lang.Double>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r4)
            goto L_0x0061
        L_0x01e7:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r5, (java.util.List<java.lang.Float>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r4)
            goto L_0x0061
        L_0x01fc:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0211:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0226:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r5, r0, r12, r4)
            goto L_0x0061
        L_0x023b:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0250:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0265:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r5, r0, r12, r4)
            goto L_0x0061
        L_0x027a:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r5, (java.util.List<java.lang.String>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0061
        L_0x028e:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r5, (java.util.List<?>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x02a6:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzez.zzb(r5, r0, r12)
            goto L_0x0061
        L_0x02ba:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r5, r0, r12, r4)
            goto L_0x0061
        L_0x02cf:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r5, r0, r12, r4)
            goto L_0x0061
        L_0x02e4:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r5, r0, r12, r4)
            goto L_0x0061
        L_0x02f9:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r5, r0, r12, r4)
            goto L_0x0061
        L_0x030e:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0323:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zze(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0338:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r5, (java.util.List<java.lang.Double>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r4)
            goto L_0x0061
        L_0x034d:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r5, (java.util.List<java.lang.Float>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r4)
            goto L_0x0061
        L_0x0362:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0377:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r5, r0, r12, r4)
            goto L_0x0061
        L_0x038c:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r5, r0, r12, r4)
            goto L_0x0061
        L_0x03a1:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r5, r0, r12, r4)
            goto L_0x0061
        L_0x03b6:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r5, r0, r12, r4)
            goto L_0x0061
        L_0x03cb:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r5, r0, r12, r4)
            goto L_0x0061
        L_0x03e0:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r5, r0, r12, r4)
            goto L_0x0061
        L_0x03f5:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r5, r0, r12, r4)
            goto L_0x0061
        L_0x040a:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r5, r0, r12, r4)
            goto L_0x0061
        L_0x041f:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0434:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r5, r0, r12, r4)
            goto L_0x0061
        L_0x0449:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            r4 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zze(r5, r0, r12, r4)
            goto L_0x0061
        L_0x045e:
            int[] r0 = r10.zztd
            r5 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r5, (java.util.List<?>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x0476:
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            r10.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (int) r5, (java.lang.Object) r0, (int) r3)
            goto L_0x0061
        L_0x0484:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            double r6 = zzf(r11, r6)
            r12.zza((int) r5, (double) r6)
            goto L_0x0061
        L_0x0498:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            float r0 = zzg(r11, r6)
            r12.zza((int) r5, (float) r0)
            goto L_0x0061
        L_0x04ac:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = zzi(r11, r6)
            r12.zzi(r5, r6)
            goto L_0x0061
        L_0x04c0:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = zzi(r11, r6)
            r12.zza((int) r5, (long) r6)
            goto L_0x0061
        L_0x04d4:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zzc((int) r5, (int) r0)
            goto L_0x0061
        L_0x04e8:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = zzi(r11, r6)
            r12.zzc((int) r5, (long) r6)
            goto L_0x0061
        L_0x04fc:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zzf(r5, r0)
            goto L_0x0061
        L_0x0510:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            boolean r0 = zzj(r11, r6)
            r12.zzb((int) r5, (boolean) r0)
            goto L_0x0061
        L_0x0524:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            zza((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0061
        L_0x0538:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            r12.zza((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x0550:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzbu r0 = (com.google.android.gms.internal.firebase_auth.zzbu) r0
            r12.zza((int) r5, (com.google.android.gms.internal.firebase_auth.zzbu) r0)
            goto L_0x0061
        L_0x0566:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zzd(r5, r0)
            goto L_0x0061
        L_0x057a:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zzn(r5, r0)
            goto L_0x0061
        L_0x058e:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zzm(r5, r0)
            goto L_0x0061
        L_0x05a2:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = zzi(r11, r6)
            r12.zzj(r5, r6)
            goto L_0x0061
        L_0x05b6:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            int r0 = zzh(r11, r6)
            r12.zze(r5, r0)
            goto L_0x0061
        L_0x05ca:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            long r6 = zzi(r11, r6)
            r12.zzb((int) r5, (long) r6)
            goto L_0x0061
        L_0x05de:
            boolean r0 = r10.zza(r11, (int) r5, (int) r3)
            if (r0 == 0) goto L_0x0061
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r4
            long r6 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r6)
            com.google.android.gms.internal.firebase_auth.zzex r4 = r10.zzam(r3)
            r12.zzb((int) r5, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r4)
            goto L_0x0061
        L_0x05f6:
            r0 = 0
        L_0x05f7:
            if (r0 == 0) goto L_0x0c11
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r10.zztt
            r2.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (java.util.Map.Entry<?, ?>) r0)
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x05f6
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x05f7
        L_0x060b:
            boolean r0 = r10.zztl
            if (r0 == 0) goto L_0x0c12
            r1 = 0
            r0 = 0
            boolean r2 = r10.zztj
            if (r2 == 0) goto L_0x062b
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r10.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r2 = r2.zzc(r11)
            boolean r3 = r2.isEmpty()
            if (r3 != 0) goto L_0x062b
            java.util.Iterator r1 = r2.iterator()
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
        L_0x062b:
            int[] r2 = r10.zztd
            int r4 = r2.length
            r2 = 0
            r3 = r2
        L_0x0630:
            if (r3 >= r4) goto L_0x0bf8
            int r5 = r10.zzap(r3)
            int[] r2 = r10.zztd
            r6 = r2[r3]
            r2 = r0
        L_0x063b:
            if (r2 == 0) goto L_0x065a
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r10.zztt
            int r0 = r0.zza(r2)
            if (r0 > r6) goto L_0x065a
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r10.zztt
            r0.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (java.util.Map.Entry<?, ?>) r2)
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0658
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
        L_0x0656:
            r2 = r0
            goto L_0x063b
        L_0x0658:
            r0 = 0
            goto L_0x0656
        L_0x065a:
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r0 = r0 >>> 20
            switch(r0) {
                case 0: goto L_0x0667;
                case 1: goto L_0x067a;
                case 2: goto L_0x068d;
                case 3: goto L_0x06a0;
                case 4: goto L_0x06b3;
                case 5: goto L_0x06c6;
                case 6: goto L_0x06d9;
                case 7: goto L_0x06ed;
                case 8: goto L_0x0701;
                case 9: goto L_0x0715;
                case 10: goto L_0x072d;
                case 11: goto L_0x0743;
                case 12: goto L_0x0757;
                case 13: goto L_0x076b;
                case 14: goto L_0x077f;
                case 15: goto L_0x0793;
                case 16: goto L_0x07a7;
                case 17: goto L_0x07bb;
                case 18: goto L_0x07d3;
                case 19: goto L_0x07e8;
                case 20: goto L_0x07fd;
                case 21: goto L_0x0812;
                case 22: goto L_0x0827;
                case 23: goto L_0x083c;
                case 24: goto L_0x0851;
                case 25: goto L_0x0866;
                case 26: goto L_0x087b;
                case 27: goto L_0x088f;
                case 28: goto L_0x08a7;
                case 29: goto L_0x08bb;
                case 30: goto L_0x08d0;
                case 31: goto L_0x08e5;
                case 32: goto L_0x08fa;
                case 33: goto L_0x090f;
                case 34: goto L_0x0924;
                case 35: goto L_0x0939;
                case 36: goto L_0x094e;
                case 37: goto L_0x0963;
                case 38: goto L_0x0978;
                case 39: goto L_0x098d;
                case 40: goto L_0x09a2;
                case 41: goto L_0x09b7;
                case 42: goto L_0x09cc;
                case 43: goto L_0x09e1;
                case 44: goto L_0x09f6;
                case 45: goto L_0x0a0b;
                case 46: goto L_0x0a20;
                case 47: goto L_0x0a35;
                case 48: goto L_0x0a4a;
                case 49: goto L_0x0a5f;
                case 50: goto L_0x0a77;
                case 51: goto L_0x0a85;
                case 52: goto L_0x0a99;
                case 53: goto L_0x0aad;
                case 54: goto L_0x0ac1;
                case 55: goto L_0x0ad5;
                case 56: goto L_0x0ae9;
                case 57: goto L_0x0afd;
                case 58: goto L_0x0b11;
                case 59: goto L_0x0b25;
                case 60: goto L_0x0b39;
                case 61: goto L_0x0b51;
                case 62: goto L_0x0b67;
                case 63: goto L_0x0b7b;
                case 64: goto L_0x0b8f;
                case 65: goto L_0x0ba3;
                case 66: goto L_0x0bb7;
                case 67: goto L_0x0bcb;
                case 68: goto L_0x0bdf;
                default: goto L_0x0662;
            }
        L_0x0662:
            int r0 = r3 + 4
            r3 = r0
            r0 = r2
            goto L_0x0630
        L_0x0667:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            double r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzo(r11, r8)
            r12.zza((int) r6, (double) r8)
            goto L_0x0662
        L_0x067a:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            float r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzn(r11, r8)
            r12.zza((int) r6, (float) r0)
            goto L_0x0662
        L_0x068d:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r8)
            r12.zzi(r6, r8)
            goto L_0x0662
        L_0x06a0:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r8)
            r12.zza((int) r6, (long) r8)
            goto L_0x0662
        L_0x06b3:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zzc((int) r6, (int) r0)
            goto L_0x0662
        L_0x06c6:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r8)
            r12.zzc((int) r6, (long) r8)
            goto L_0x0662
        L_0x06d9:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zzf(r6, r0)
            goto L_0x0662
        L_0x06ed:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            boolean r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzm(r11, r8)
            r12.zzb((int) r6, (boolean) r0)
            goto L_0x0662
        L_0x0701:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            zza((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0662
        L_0x0715:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            r12.zza((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x072d:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzbu r0 = (com.google.android.gms.internal.firebase_auth.zzbu) r0
            r12.zza((int) r6, (com.google.android.gms.internal.firebase_auth.zzbu) r0)
            goto L_0x0662
        L_0x0743:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zzd(r6, r0)
            goto L_0x0662
        L_0x0757:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zzn(r6, r0)
            goto L_0x0662
        L_0x076b:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zzm(r6, r0)
            goto L_0x0662
        L_0x077f:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r8)
            r12.zzj(r6, r8)
            goto L_0x0662
        L_0x0793:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzk(r11, r8)
            r12.zze(r6, r0)
            goto L_0x0662
        L_0x07a7:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = com.google.android.gms.internal.firebase_auth.zzfx.zzl(r11, r8)
            r12.zzb((int) r6, (long) r8)
            goto L_0x0662
        L_0x07bb:
            boolean r0 = r10.zza(r11, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            r12.zzb((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x07d3:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r6, (java.util.List<java.lang.Double>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r5)
            goto L_0x0662
        L_0x07e8:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r6, (java.util.List<java.lang.Float>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r5)
            goto L_0x0662
        L_0x07fd:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0812:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0827:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r6, r0, r12, r5)
            goto L_0x0662
        L_0x083c:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0851:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0866:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r6, r0, r12, r5)
            goto L_0x0662
        L_0x087b:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r6, (java.util.List<java.lang.String>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0662
        L_0x088f:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r6, (java.util.List<?>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x08a7:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzez.zzb(r6, r0, r12)
            goto L_0x0662
        L_0x08bb:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r6, r0, r12, r5)
            goto L_0x0662
        L_0x08d0:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r6, r0, r12, r5)
            goto L_0x0662
        L_0x08e5:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r6, r0, r12, r5)
            goto L_0x0662
        L_0x08fa:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r6, r0, r12, r5)
            goto L_0x0662
        L_0x090f:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0924:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzez.zze(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0939:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zza((int) r6, (java.util.List<java.lang.Double>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r5)
            goto L_0x0662
        L_0x094e:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r6, (java.util.List<java.lang.Float>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (boolean) r5)
            goto L_0x0662
        L_0x0963:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzc(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0978:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzd(r6, r0, r12, r5)
            goto L_0x0662
        L_0x098d:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzh(r6, r0, r12, r5)
            goto L_0x0662
        L_0x09a2:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzf(r6, r0, r12, r5)
            goto L_0x0662
        L_0x09b7:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzk(r6, r0, r12, r5)
            goto L_0x0662
        L_0x09cc:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzn(r6, r0, r12, r5)
            goto L_0x0662
        L_0x09e1:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzi(r6, r0, r12, r5)
            goto L_0x0662
        L_0x09f6:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzm(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0a0b:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzl(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0a20:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzg(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0a35:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zzj(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0a4a:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzez.zze(r6, r0, r12, r5)
            goto L_0x0662
        L_0x0a5f:
            int[] r0 = r10.zztd
            r6 = r0[r3]
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            java.util.List r0 = (java.util.List) r0
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r6, (java.util.List<?>) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x0a77:
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            r10.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (int) r6, (java.lang.Object) r0, (int) r3)
            goto L_0x0662
        L_0x0a85:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            double r8 = zzf(r11, r8)
            r12.zza((int) r6, (double) r8)
            goto L_0x0662
        L_0x0a99:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            float r0 = zzg(r11, r8)
            r12.zza((int) r6, (float) r0)
            goto L_0x0662
        L_0x0aad:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = zzi(r11, r8)
            r12.zzi(r6, r8)
            goto L_0x0662
        L_0x0ac1:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = zzi(r11, r8)
            r12.zza((int) r6, (long) r8)
            goto L_0x0662
        L_0x0ad5:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zzc((int) r6, (int) r0)
            goto L_0x0662
        L_0x0ae9:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = zzi(r11, r8)
            r12.zzc((int) r6, (long) r8)
            goto L_0x0662
        L_0x0afd:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zzf(r6, r0)
            goto L_0x0662
        L_0x0b11:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            boolean r0 = zzj(r11, r8)
            r12.zzb((int) r6, (boolean) r0)
            goto L_0x0662
        L_0x0b25:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            zza((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0662
        L_0x0b39:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            r12.zza((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x0b51:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzbu r0 = (com.google.android.gms.internal.firebase_auth.zzbu) r0
            r12.zza((int) r6, (com.google.android.gms.internal.firebase_auth.zzbu) r0)
            goto L_0x0662
        L_0x0b67:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zzd(r6, r0)
            goto L_0x0662
        L_0x0b7b:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zzn(r6, r0)
            goto L_0x0662
        L_0x0b8f:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zzm(r6, r0)
            goto L_0x0662
        L_0x0ba3:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = zzi(r11, r8)
            r12.zzj(r6, r8)
            goto L_0x0662
        L_0x0bb7:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            int r0 = zzh(r11, r8)
            r12.zze(r6, r0)
            goto L_0x0662
        L_0x0bcb:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            long r8 = zzi(r11, r8)
            r12.zzb((int) r6, (long) r8)
            goto L_0x0662
        L_0x0bdf:
            boolean r0 = r10.zza(r11, (int) r6, (int) r3)
            if (r0 == 0) goto L_0x0662
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r8 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r11, r8)
            com.google.android.gms.internal.firebase_auth.zzex r5 = r10.zzam(r3)
            r12.zzb((int) r6, (java.lang.Object) r0, (com.google.android.gms.internal.firebase_auth.zzex) r5)
            goto L_0x0662
        L_0x0bf7:
            r0 = 0
        L_0x0bf8:
            if (r0 == 0) goto L_0x0c0c
            com.google.android.gms.internal.firebase_auth.zzcp<?> r2 = r10.zztt
            r2.zza((com.google.android.gms.internal.firebase_auth.zzgl) r12, (java.util.Map.Entry<?, ?>) r0)
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L_0x0bf7
            java.lang.Object r0 = r1.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            goto L_0x0bf8
        L_0x0c0c:
            com.google.android.gms.internal.firebase_auth.zzfr<?, ?> r0 = r10.zzts
            zza(r0, r11, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
        L_0x0c11:
            return
        L_0x0c12:
            r10.zzb(r11, (com.google.android.gms.internal.firebase_auth.zzgl) r12)
            goto L_0x0c11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzgl):void");
    }

    public final void zzc(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zztd.length; i += 4) {
            int zzap = zzap(i);
            long j = (long) (1048575 & zzap);
            int i2 = this.zztd[i];
            switch ((zzap & 267386880) >>> 20) {
                case 0:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzo(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 1:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzn(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 2:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 3:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 4:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 5:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 6:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 7:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzm(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 8:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzp(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzp(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 11:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 12:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 13:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 14:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 15:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zzb((Object) t, j, zzfx.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 16:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case MotionEventCompat.AXIS_GAS:
                case 23:
                case MotionEventCompat.AXIS_DISTANCE:
                case 25:
                case MotionEventCompat.AXIS_SCROLL:
                case MotionEventCompat.AXIS_RELATIVE_X:
                case MotionEventCompat.AXIS_RELATIVE_Y:
                case 29:
                case 30:
                case 31:
                case 32:
                case MotionEventCompat.AXIS_GENERIC_2:
                case MotionEventCompat.AXIS_GENERIC_3:
                case MotionEventCompat.AXIS_GENERIC_4:
                case MotionEventCompat.AXIS_GENERIC_5:
                case MotionEventCompat.AXIS_GENERIC_6:
                case MotionEventCompat.AXIS_GENERIC_7:
                case MotionEventCompat.AXIS_GENERIC_8:
                case MotionEventCompat.AXIS_GENERIC_9:
                case MotionEventCompat.AXIS_GENERIC_10:
                case MotionEventCompat.AXIS_GENERIC_11:
                case MotionEventCompat.AXIS_GENERIC_12:
                case MotionEventCompat.AXIS_GENERIC_13:
                case MotionEventCompat.AXIS_GENERIC_14:
                case MotionEventCompat.AXIS_GENERIC_15:
                case MotionEventCompat.AXIS_GENERIC_16:
                case 48:
                case 49:
                    this.zztr.zza(t, t2, j);
                    break;
                case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                    zzez.zza(this.zztu, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzp(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zzfx.zza((Object) t, j, zzfx.zzp(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (!this.zztl) {
            zzez.zza(this.zzts, t, t2);
            if (this.zztj) {
                zzez.zza(this.zztt, t, t2);
            }
        }
    }

    public final void zze(T t) {
        if (this.zzto != null) {
            for (int zzap : this.zzto) {
                long zzap2 = (long) (zzap(zzap) & 1048575);
                Object zzp = zzfx.zzp(t, zzap2);
                if (zzp != null) {
                    zzfx.zza((Object) t, zzap2, this.zztu.zzl(zzp));
                }
            }
        }
        if (this.zztp != null) {
            for (int i : this.zztp) {
                this.zztr.zzb(t, (long) i);
            }
        }
        this.zzts.zze(t);
        if (this.zztj) {
            this.zztt.zze((Object) t);
        }
    }

    public final int zzo(T t) {
        int i;
        int i2;
        int i3;
        if (this.zztl) {
            Unsafe unsafe = zztc;
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4;
                if (i6 >= this.zztd.length) {
                    return zza(this.zzts, t) + i5;
                }
                int zzap = zzap(i6);
                int i7 = (267386880 & zzap) >>> 20;
                int i8 = this.zztd[i6];
                long j = (long) (zzap & 1048575);
                int i9 = (i7 < zzcv.DOUBLE_LIST_PACKED.mo8863id() || i7 > zzcv.SINT64_LIST_PACKED.mo8863id()) ? 0 : this.zztd[i6 + 2] & 1048575;
                switch (i7) {
                    case 0:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzb(i8, 0.0d);
                            break;
                        }
                    case 1:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzb(i8, 0.0f);
                            break;
                        }
                    case 2:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzd(i8, zzfx.zzl(t, j));
                            break;
                        }
                    case 3:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zze(i8, zzfx.zzl(t, j));
                            break;
                        }
                    case 4:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzg(i8, zzfx.zzk(t, j));
                            break;
                        }
                    case 5:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzg(i8, 0);
                            break;
                        }
                    case 6:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzj(i8, 0);
                            break;
                        }
                    case 7:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, true);
                            break;
                        }
                    case 8:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            Object zzp = zzfx.zzp(t, j);
                            if (!(zzp instanceof zzbu)) {
                                i5 += zzci.zzb(i8, (String) zzp);
                                break;
                            } else {
                                i5 += zzci.zzc(i8, (zzbu) zzp);
                                break;
                            }
                        }
                    case 9:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzez.zzc(i8, zzfx.zzp(t, j), zzam(i6));
                            break;
                        }
                    case 10:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, (zzbu) zzfx.zzp(t, j));
                            break;
                        }
                    case 11:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzh(i8, zzfx.zzk(t, j));
                            break;
                        }
                    case 12:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzl(i8, zzfx.zzk(t, j));
                            break;
                        }
                    case 13:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzk(i8, 0);
                            break;
                        }
                    case 14:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzh(i8, 0);
                            break;
                        }
                    case 15:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzi(i8, zzfx.zzk(t, j));
                            break;
                        }
                    case 16:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzf(i8, zzfx.zzl(t, j));
                            break;
                        }
                    case 17:
                        if (!zza(t, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, (zzeh) zzfx.zzp(t, j), zzam(i6));
                            break;
                        }
                    case 18:
                        i5 += zzez.zzw(i8, zze(t, j), false);
                        break;
                    case 19:
                        i5 += zzez.zzv(i8, zze(t, j), false);
                        break;
                    case 20:
                        i5 += zzez.zzo(i8, zze(t, j), false);
                        break;
                    case 21:
                        i5 += zzez.zzp(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_GAS:
                        i5 += zzez.zzs(i8, zze(t, j), false);
                        break;
                    case 23:
                        i5 += zzez.zzw(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_DISTANCE:
                        i5 += zzez.zzv(i8, zze(t, j), false);
                        break;
                    case 25:
                        i5 += zzez.zzx(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_SCROLL:
                        i5 += zzez.zzc(i8, zze(t, j));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_X:
                        i5 += zzez.zzc(i8, (List<?>) zze(t, j), zzam(i6));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y:
                        i5 += zzez.zzd(i8, (List<zzbu>) zze(t, j));
                        break;
                    case 29:
                        i5 += zzez.zzt(i8, zze(t, j), false);
                        break;
                    case 30:
                        i5 += zzez.zzr(i8, zze(t, j), false);
                        break;
                    case 31:
                        i5 += zzez.zzv(i8, zze(t, j), false);
                        break;
                    case 32:
                        i5 += zzez.zzw(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_2:
                        i5 += zzez.zzu(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        i5 += zzez.zzq(i8, zze(t, j), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_4:
                        int zzaa = zzez.zzaa((List) unsafe.getObject(t, j));
                        if (zzaa > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzaa);
                            }
                            i5 += zzaa + zzci.zzz(i8) + zzci.zzab(zzaa);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_5:
                        int zzz = zzez.zzz((List) unsafe.getObject(t, j));
                        if (zzz > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzz);
                            }
                            i5 += zzz + zzci.zzz(i8) + zzci.zzab(zzz);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_6:
                        int zzs = zzez.zzs((List) unsafe.getObject(t, j));
                        if (zzs > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzs);
                            }
                            i5 += zzs + zzci.zzz(i8) + zzci.zzab(zzs);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_7:
                        int zzt = zzez.zzt((List) unsafe.getObject(t, j));
                        if (zzt > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzt);
                            }
                            i5 += zzt + zzci.zzz(i8) + zzci.zzab(zzt);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_8:
                        int zzw = zzez.zzw((List) unsafe.getObject(t, j));
                        if (zzw > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzw);
                            }
                            i5 += zzw + zzci.zzz(i8) + zzci.zzab(zzw);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_9:
                        int zzaa2 = zzez.zzaa((List) unsafe.getObject(t, j));
                        if (zzaa2 > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzaa2);
                            }
                            i5 += zzaa2 + zzci.zzz(i8) + zzci.zzab(zzaa2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_10:
                        int zzz2 = zzez.zzz((List) unsafe.getObject(t, j));
                        if (zzz2 > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzz2);
                            }
                            i5 += zzz2 + zzci.zzz(i8) + zzci.zzab(zzz2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_11:
                        int zzab = zzez.zzab((List) unsafe.getObject(t, j));
                        if (zzab > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzab);
                            }
                            i5 += zzab + zzci.zzz(i8) + zzci.zzab(zzab);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_12:
                        int zzx = zzez.zzx((List) unsafe.getObject(t, j));
                        if (zzx > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzx);
                            }
                            i5 += zzx + zzci.zzz(i8) + zzci.zzab(zzx);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_13:
                        int zzv = zzez.zzv((List) unsafe.getObject(t, j));
                        if (zzv > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzv);
                            }
                            i5 += zzv + zzci.zzz(i8) + zzci.zzab(zzv);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_14:
                        int zzz3 = zzez.zzz((List) unsafe.getObject(t, j));
                        if (zzz3 > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzz3);
                            }
                            i5 += zzz3 + zzci.zzz(i8) + zzci.zzab(zzz3);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_15:
                        int zzaa3 = zzez.zzaa((List) unsafe.getObject(t, j));
                        if (zzaa3 > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzaa3);
                            }
                            i5 += zzaa3 + zzci.zzz(i8) + zzci.zzab(zzaa3);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_16:
                        int zzy = zzez.zzy((List) unsafe.getObject(t, j));
                        if (zzy > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzy);
                            }
                            i5 += zzy + zzci.zzz(i8) + zzci.zzab(zzy);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzu = zzez.zzu((List) unsafe.getObject(t, j));
                        if (zzu > 0) {
                            if (this.zztm) {
                                unsafe.putInt(t, (long) i9, zzu);
                            }
                            i5 += zzu + zzci.zzz(i8) + zzci.zzab(zzu);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i5 += zzez.zzd(i8, zze(t, j), zzam(i6));
                        break;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        i5 += this.zztu.zzb(i8, zzfx.zzp(t, j), zzan(i6));
                        break;
                    case 51:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzb(i8, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzb(i8, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzd(i8, zzi(t, j));
                            break;
                        }
                    case 54:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zze(i8, zzi(t, j));
                            break;
                        }
                    case 55:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzg(i8, zzh(t, j));
                            break;
                        }
                    case 56:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzg(i8, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzj(i8, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, true);
                            break;
                        }
                    case 59:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            Object zzp2 = zzfx.zzp(t, j);
                            if (!(zzp2 instanceof zzbu)) {
                                i5 += zzci.zzb(i8, (String) zzp2);
                                break;
                            } else {
                                i5 += zzci.zzc(i8, (zzbu) zzp2);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzez.zzc(i8, zzfx.zzp(t, j), zzam(i6));
                            break;
                        }
                    case 61:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, (zzbu) zzfx.zzp(t, j));
                            break;
                        }
                    case 62:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzh(i8, zzh(t, j));
                            break;
                        }
                    case 63:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzl(i8, zzh(t, j));
                            break;
                        }
                    case 64:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzk(i8, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzh(i8, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzi(i8, zzh(t, j));
                            break;
                        }
                    case 67:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzf(i8, zzi(t, j));
                            break;
                        }
                    case 68:
                        if (!zza(t, i8, i6)) {
                            break;
                        } else {
                            i5 += zzci.zzc(i8, (zzeh) zzfx.zzp(t, j), zzam(i6));
                            break;
                        }
                }
                i4 = i6 + 4;
            }
        } else {
            Unsafe unsafe2 = zztc;
            int i10 = -1;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.zztd.length) {
                int zzap2 = zzap(i12);
                int i14 = this.zztd[i12];
                int i15 = (267386880 & zzap2) >>> 20;
                int i16 = 0;
                if (i15 <= 17) {
                    int i17 = this.zztd[i12 + 2];
                    int i18 = 1048575 & i17;
                    int i19 = 1 << (i17 >>> 20);
                    if (i18 != i10) {
                        i13 = unsafe2.getInt(t, (long) i18);
                        i10 = i18;
                    }
                    i = i10;
                    i2 = i13;
                    i3 = i19;
                    i16 = i17;
                } else if (!this.zztm || i15 < zzcv.DOUBLE_LIST_PACKED.mo8863id() || i15 > zzcv.SINT64_LIST_PACKED.mo8863id()) {
                    i = i10;
                    i2 = i13;
                    i3 = 0;
                } else {
                    i16 = this.zztd[i12 + 2] & 1048575;
                    i = i10;
                    i2 = i13;
                    i3 = 0;
                }
                long j2 = (long) (1048575 & zzap2);
                switch (i15) {
                    case 0:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzb(i14, 0.0d);
                            break;
                        }
                    case 1:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzb(i14, 0.0f);
                            break;
                        }
                    case 2:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzd(i14, unsafe2.getLong(t, j2));
                            break;
                        }
                    case 3:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zze(i14, unsafe2.getLong(t, j2));
                            break;
                        }
                    case 4:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzg(i14, unsafe2.getInt(t, j2));
                            break;
                        }
                    case 5:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzg(i14, 0);
                            break;
                        }
                    case 6:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzj(i14, 0);
                            break;
                        }
                    case 7:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, true);
                            break;
                        }
                    case 8:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            Object object = unsafe2.getObject(t, j2);
                            if (!(object instanceof zzbu)) {
                                i11 += zzci.zzb(i14, (String) object);
                                break;
                            } else {
                                i11 += zzci.zzc(i14, (zzbu) object);
                                break;
                            }
                        }
                    case 9:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzez.zzc(i14, unsafe2.getObject(t, j2), zzam(i12));
                            break;
                        }
                    case 10:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, (zzbu) unsafe2.getObject(t, j2));
                            break;
                        }
                    case 11:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzh(i14, unsafe2.getInt(t, j2));
                            break;
                        }
                    case 12:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzl(i14, unsafe2.getInt(t, j2));
                            break;
                        }
                    case 13:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzk(i14, 0);
                            break;
                        }
                    case 14:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzh(i14, 0);
                            break;
                        }
                    case 15:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzi(i14, unsafe2.getInt(t, j2));
                            break;
                        }
                    case 16:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzf(i14, unsafe2.getLong(t, j2));
                            break;
                        }
                    case 17:
                        if ((i3 & i2) == 0) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, (zzeh) unsafe2.getObject(t, j2), zzam(i12));
                            break;
                        }
                    case 18:
                        i11 += zzez.zzw(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 19:
                        i11 += zzez.zzv(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 20:
                        i11 += zzez.zzo(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 21:
                        i11 += zzez.zzp(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_GAS:
                        i11 += zzez.zzs(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 23:
                        i11 += zzez.zzw(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_DISTANCE:
                        i11 += zzez.zzv(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 25:
                        i11 += zzez.zzx(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_SCROLL:
                        i11 += zzez.zzc(i14, (List) unsafe2.getObject(t, j2));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_X:
                        i11 += zzez.zzc(i14, (List<?>) (List) unsafe2.getObject(t, j2), zzam(i12));
                        break;
                    case MotionEventCompat.AXIS_RELATIVE_Y:
                        i11 += zzez.zzd(i14, (List<zzbu>) (List) unsafe2.getObject(t, j2));
                        break;
                    case 29:
                        i11 += zzez.zzt(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 30:
                        i11 += zzez.zzr(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 31:
                        i11 += zzez.zzv(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case 32:
                        i11 += zzez.zzw(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_2:
                        i11 += zzez.zzu(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_3:
                        i11 += zzez.zzq(i14, (List) unsafe2.getObject(t, j2), false);
                        break;
                    case MotionEventCompat.AXIS_GENERIC_4:
                        int zzaa4 = zzez.zzaa((List) unsafe2.getObject(t, j2));
                        if (zzaa4 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzaa4);
                            }
                            i11 += zzaa4 + zzci.zzz(i14) + zzci.zzab(zzaa4);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_5:
                        int zzz4 = zzez.zzz((List) unsafe2.getObject(t, j2));
                        if (zzz4 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzz4);
                            }
                            i11 += zzz4 + zzci.zzz(i14) + zzci.zzab(zzz4);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_6:
                        int zzs2 = zzez.zzs((List) unsafe2.getObject(t, j2));
                        if (zzs2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzs2);
                            }
                            i11 += zzs2 + zzci.zzz(i14) + zzci.zzab(zzs2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_7:
                        int zzt2 = zzez.zzt((List) unsafe2.getObject(t, j2));
                        if (zzt2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzt2);
                            }
                            i11 += zzt2 + zzci.zzz(i14) + zzci.zzab(zzt2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_8:
                        int zzw2 = zzez.zzw((List) unsafe2.getObject(t, j2));
                        if (zzw2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzw2);
                            }
                            i11 += zzw2 + zzci.zzz(i14) + zzci.zzab(zzw2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_9:
                        int zzaa5 = zzez.zzaa((List) unsafe2.getObject(t, j2));
                        if (zzaa5 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzaa5);
                            }
                            i11 += zzaa5 + zzci.zzz(i14) + zzci.zzab(zzaa5);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_10:
                        int zzz5 = zzez.zzz((List) unsafe2.getObject(t, j2));
                        if (zzz5 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzz5);
                            }
                            i11 += zzz5 + zzci.zzz(i14) + zzci.zzab(zzz5);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_11:
                        int zzab2 = zzez.zzab((List) unsafe2.getObject(t, j2));
                        if (zzab2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzab2);
                            }
                            i11 += zzab2 + zzci.zzz(i14) + zzci.zzab(zzab2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_12:
                        int zzx2 = zzez.zzx((List) unsafe2.getObject(t, j2));
                        if (zzx2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzx2);
                            }
                            i11 += zzx2 + zzci.zzz(i14) + zzci.zzab(zzx2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_13:
                        int zzv2 = zzez.zzv((List) unsafe2.getObject(t, j2));
                        if (zzv2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzv2);
                            }
                            i11 += zzv2 + zzci.zzz(i14) + zzci.zzab(zzv2);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_14:
                        int zzz6 = zzez.zzz((List) unsafe2.getObject(t, j2));
                        if (zzz6 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzz6);
                            }
                            i11 += zzz6 + zzci.zzz(i14) + zzci.zzab(zzz6);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_15:
                        int zzaa6 = zzez.zzaa((List) unsafe2.getObject(t, j2));
                        if (zzaa6 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzaa6);
                            }
                            i11 += zzaa6 + zzci.zzz(i14) + zzci.zzab(zzaa6);
                            break;
                        } else {
                            break;
                        }
                    case MotionEventCompat.AXIS_GENERIC_16:
                        int zzy2 = zzez.zzy((List) unsafe2.getObject(t, j2));
                        if (zzy2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzy2);
                            }
                            i11 += zzy2 + zzci.zzz(i14) + zzci.zzab(zzy2);
                            break;
                        } else {
                            break;
                        }
                    case 48:
                        int zzu2 = zzez.zzu((List) unsafe2.getObject(t, j2));
                        if (zzu2 > 0) {
                            if (this.zztm) {
                                unsafe2.putInt(t, (long) i16, zzu2);
                            }
                            i11 += zzu2 + zzci.zzz(i14) + zzci.zzab(zzu2);
                            break;
                        } else {
                            break;
                        }
                    case 49:
                        i11 += zzez.zzd(i14, (List) unsafe2.getObject(t, j2), zzam(i12));
                        break;
                    case ActivityChooserModel.DEFAULT_HISTORY_MAX_LENGTH:
                        i11 += this.zztu.zzb(i14, unsafe2.getObject(t, j2), zzan(i12));
                        break;
                    case 51:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzb(i14, 0.0d);
                            break;
                        }
                    case 52:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzb(i14, 0.0f);
                            break;
                        }
                    case 53:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzd(i14, zzi(t, j2));
                            break;
                        }
                    case 54:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zze(i14, zzi(t, j2));
                            break;
                        }
                    case 55:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzg(i14, zzh(t, j2));
                            break;
                        }
                    case 56:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzg(i14, 0);
                            break;
                        }
                    case 57:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzj(i14, 0);
                            break;
                        }
                    case 58:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, true);
                            break;
                        }
                    case 59:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            Object object2 = unsafe2.getObject(t, j2);
                            if (!(object2 instanceof zzbu)) {
                                i11 += zzci.zzb(i14, (String) object2);
                                break;
                            } else {
                                i11 += zzci.zzc(i14, (zzbu) object2);
                                break;
                            }
                        }
                    case 60:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzez.zzc(i14, unsafe2.getObject(t, j2), zzam(i12));
                            break;
                        }
                    case 61:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, (zzbu) unsafe2.getObject(t, j2));
                            break;
                        }
                    case 62:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzh(i14, zzh(t, j2));
                            break;
                        }
                    case 63:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzl(i14, zzh(t, j2));
                            break;
                        }
                    case 64:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzk(i14, 0);
                            break;
                        }
                    case 65:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzh(i14, 0);
                            break;
                        }
                    case 66:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzi(i14, zzh(t, j2));
                            break;
                        }
                    case 67:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzf(i14, zzi(t, j2));
                            break;
                        }
                    case 68:
                        if (!zza(t, i14, i12)) {
                            break;
                        } else {
                            i11 += zzci.zzc(i14, (zzeh) unsafe2.getObject(t, j2), zzam(i12));
                            break;
                        }
                }
                i12 += 4;
                i13 = i2;
                i10 = i;
            }
            int zza = zza(this.zzts, t) + i11;
            return this.zztj ? zza + this.zztt.zzc(t).zzdn() : zza;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x004c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzp(T r13) {
        /*
            r12 = this;
            int[] r0 = r12.zztn
            if (r0 == 0) goto L_0x0009
            int[] r0 = r12.zztn
            int r0 = r0.length
            if (r0 != 0) goto L_0x000b
        L_0x0009:
            r0 = 1
        L_0x000a:
            return r0
        L_0x000b:
            r3 = -1
            r1 = 0
            int[] r5 = r12.zztn
            int r6 = r5.length
            r0 = 0
            r4 = r0
        L_0x0012:
            if (r4 >= r6) goto L_0x010b
            r7 = r5[r4]
            int r8 = r12.zzas(r7)
            int r9 = r12.zzap(r8)
            r0 = 0
            boolean r2 = r12.zztl
            if (r2 != 0) goto L_0x0121
            int[] r0 = r12.zztd
            int r2 = r8 + 2
            r0 = r0[r2]
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r2 = r2 & r0
            r10 = 1
            int r0 = r0 >>> 20
            int r0 = r10 << r0
            if (r2 == r3) goto L_0x0121
            sun.misc.Unsafe r1 = zztc
            long r10 = (long) r2
            int r1 = r1.getInt(r13, r10)
            r3 = r2
            r2 = r1
            r1 = r0
        L_0x003e:
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r0 = r0 & r9
            if (r0 == 0) goto L_0x004e
            r0 = 1
        L_0x0044:
            if (r0 == 0) goto L_0x0050
            boolean r0 = r12.zza(r13, (int) r8, (int) r2, (int) r1)
            if (r0 != 0) goto L_0x0050
            r0 = 0
            goto L_0x000a
        L_0x004e:
            r0 = 0
            goto L_0x0044
        L_0x0050:
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r9
            int r0 = r0 >>> 20
            switch(r0) {
                case 9: goto L_0x005d;
                case 17: goto L_0x005d;
                case 27: goto L_0x006f;
                case 49: goto L_0x006f;
                case 50: goto L_0x00b3;
                case 60: goto L_0x00a0;
                case 68: goto L_0x00a0;
                default: goto L_0x0058;
            }
        L_0x0058:
            int r0 = r4 + 1
            r4 = r0
            r1 = r2
            goto L_0x0012
        L_0x005d:
            boolean r0 = r12.zza(r13, (int) r8, (int) r2, (int) r1)
            if (r0 == 0) goto L_0x0058
            com.google.android.gms.internal.firebase_auth.zzex r0 = r12.zzam(r8)
            boolean r0 = zza((java.lang.Object) r13, (int) r9, (com.google.android.gms.internal.firebase_auth.zzex) r0)
            if (r0 != 0) goto L_0x0058
            r0 = 0
            goto L_0x000a
        L_0x006f:
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r9
            long r0 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r0)
            java.util.List r0 = (java.util.List) r0
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x009e
            com.google.android.gms.internal.firebase_auth.zzex r7 = r12.zzam(r8)
            r1 = 0
        L_0x0085:
            int r8 = r0.size()
            if (r1 >= r8) goto L_0x009e
            java.lang.Object r8 = r0.get(r1)
            boolean r8 = r7.zzp(r8)
            if (r8 != 0) goto L_0x009b
            r0 = 0
        L_0x0096:
            if (r0 != 0) goto L_0x0058
            r0 = 0
            goto L_0x000a
        L_0x009b:
            int r1 = r1 + 1
            goto L_0x0085
        L_0x009e:
            r0 = 1
            goto L_0x0096
        L_0x00a0:
            boolean r0 = r12.zza(r13, (int) r7, (int) r8)
            if (r0 == 0) goto L_0x0058
            com.google.android.gms.internal.firebase_auth.zzex r0 = r12.zzam(r8)
            boolean r0 = zza((java.lang.Object) r13, (int) r9, (com.google.android.gms.internal.firebase_auth.zzex) r0)
            if (r0 != 0) goto L_0x0058
            r0 = 0
            goto L_0x000a
        L_0x00b3:
            com.google.android.gms.internal.firebase_auth.zzec r0 = r12.zztu
            r1 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r9
            long r10 = (long) r1
            java.lang.Object r1 = com.google.android.gms.internal.firebase_auth.zzfx.zzp(r13, r10)
            java.util.Map r1 = r0.zzj(r1)
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x0109
            java.lang.Object r0 = r12.zzan(r8)
            com.google.android.gms.internal.firebase_auth.zzec r7 = r12.zztu
            com.google.android.gms.internal.firebase_auth.zzea r0 = r7.zzn(r0)
            com.google.android.gms.internal.firebase_auth.zzgf r0 = r0.zzsx
            com.google.android.gms.internal.firebase_auth.zzgk r0 = r0.zzhb()
            com.google.android.gms.internal.firebase_auth.zzgk r7 = com.google.android.gms.internal.firebase_auth.zzgk.MESSAGE
            if (r0 != r7) goto L_0x0109
            r0 = 0
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x00e5:
            boolean r7 = r1.hasNext()
            if (r7 == 0) goto L_0x0109
            java.lang.Object r7 = r1.next()
            if (r0 != 0) goto L_0x00fd
            com.google.android.gms.internal.firebase_auth.zzes r0 = com.google.android.gms.internal.firebase_auth.zzes.zzfd()
            java.lang.Class r8 = r7.getClass()
            com.google.android.gms.internal.firebase_auth.zzex r0 = r0.zzf(r8)
        L_0x00fd:
            boolean r7 = r0.zzp(r7)
            if (r7 != 0) goto L_0x00e5
            r0 = 0
        L_0x0104:
            if (r0 != 0) goto L_0x0058
            r0 = 0
            goto L_0x000a
        L_0x0109:
            r0 = 1
            goto L_0x0104
        L_0x010b:
            boolean r0 = r12.zztj
            if (r0 == 0) goto L_0x011e
            com.google.android.gms.internal.firebase_auth.zzcp<?> r0 = r12.zztt
            com.google.android.gms.internal.firebase_auth.zzcs r0 = r0.zzc(r13)
            boolean r0 = r0.isInitialized()
            if (r0 != 0) goto L_0x011e
            r0 = 0
            goto L_0x000a
        L_0x011e:
            r0 = 1
            goto L_0x000a
        L_0x0121:
            r2 = r1
            r1 = r0
            goto L_0x003e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzel.zzp(java.lang.Object):boolean");
    }
}
