package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.List;

final class zzcg implements zzew {
    private int tag;
    private final zzcd zzmv;
    private int zzmw;
    private int zzmx = 0;

    private zzcg(zzcd zzcd) {
        this.zzmv = (zzcd) zzdd.zza(zzcd, "input");
        this.zzmv.zzmn = this;
    }

    public static zzcg zza(zzcd zzcd) {
        return zzcd.zzmn != null ? zzcd.zzmn : new zzcg(zzcd);
    }

    private final Object zza(zzgf zzgf, Class<?> cls, zzco zzco) throws IOException {
        switch (zzch.zzmy[zzgf.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzcf());
            case 2:
                return zzch();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzcj());
            case 5:
                return Integer.valueOf(zzce());
            case 6:
                return Long.valueOf(zzcd());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzcc());
            case 9:
                return Long.valueOf(zzcb());
            case 10:
                zzr(2);
                return zzc(zzes.zzfd().zzf(cls), zzco);
            case 11:
                return Integer.valueOf(zzck());
            case 12:
                return Long.valueOf(zzcl());
            case 13:
                return Integer.valueOf(zzcm());
            case 14:
                return Long.valueOf(zzcn());
            case 15:
                return zzcg();
            case 16:
                return Integer.valueOf(zzci());
            case 17:
                return Long.valueOf(zzca());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbz;
        int zzbz2;
        if ((this.tag & 7) != 2) {
            throw zzdh.zzef();
        } else if (!(list instanceof zzdq) || z) {
            do {
                list.add(z ? zzcg() : readString());
                if (!this.zzmv.zzcp()) {
                    zzbz = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz == this.tag);
            this.zzmx = zzbz;
        } else {
            zzdq zzdq = (zzdq) list;
            do {
                zzdq.zzc(zzch());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
        }
    }

    private final <T> T zzc(zzex<T> zzex, zzco zzco) throws IOException {
        int zzci = this.zzmv.zzci();
        if (this.zzmv.zzmk >= this.zzmv.zzml) {
            throw zzdh.zzeg();
        }
        int zzo = this.zzmv.zzo(zzci);
        T newInstance = zzex.newInstance();
        this.zzmv.zzmk++;
        zzex.zza(newInstance, this, zzco);
        zzex.zze(newInstance);
        this.zzmv.zzl(0);
        zzcd zzcd = this.zzmv;
        zzcd.zzmk--;
        this.zzmv.zzp(zzo);
        return newInstance;
    }

    private final <T> T zzd(zzex<T> zzex, zzco zzco) throws IOException {
        int i = this.zzmw;
        this.zzmw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzex.newInstance();
            zzex.zza(newInstance, this, zzco);
            zzex.zze(newInstance);
            if (this.tag == this.zzmw) {
                return newInstance;
            }
            throw zzdh.zzeh();
        } finally {
            this.zzmw = i;
        }
    }

    private final void zzr(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzdh.zzef();
        }
    }

    private static void zzs(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzdh.zzeh();
        }
    }

    private static void zzt(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzdh.zzeh();
        }
    }

    private final void zzu(int i) throws IOException {
        if (this.zzmv.zzcq() != i) {
            throw zzdh.zzeb();
        }
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() throws IOException {
        zzr(1);
        return this.zzmv.readDouble();
    }

    public final float readFloat() throws IOException {
        zzr(5);
        return this.zzmv.readFloat();
    }

    public final String readString() throws IOException {
        zzr(2);
        return this.zzmv.readString();
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final <T> T zza(zzex<T> zzex, zzco zzco) throws IOException {
        zzr(2);
        return zzc(zzex, zzco);
    }

    public final <T> void zza(List<T> list, zzex<T> zzex, zzco zzco) throws IOException {
        int zzbz;
        if ((this.tag & 7) != 2) {
            throw zzdh.zzef();
        }
        int i = this.tag;
        do {
            list.add(zzc(zzex, zzco));
            if (!this.zzmv.zzcp() && this.zzmx == 0) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == i);
        this.zzmx = zzbz;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r7, com.google.android.gms.internal.firebase_auth.zzea<K, V> r8, com.google.android.gms.internal.firebase_auth.zzco r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 2
            r6.zzr((int) r0)
            com.google.android.gms.internal.firebase_auth.zzcd r0 = r6.zzmv
            int r0 = r0.zzci()
            com.google.android.gms.internal.firebase_auth.zzcd r1 = r6.zzmv
            int r2 = r1.zzo(r0)
            K r1 = r8.zzsw
            V r0 = r8.zzsy
        L_0x0014:
            int r3 = r6.zzcx()     // Catch:{ all -> 0x0045 }
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r4) goto L_0x0062
            com.google.android.gms.internal.firebase_auth.zzcd r4 = r6.zzmv     // Catch:{ all -> 0x0045 }
            boolean r4 = r4.zzcp()     // Catch:{ all -> 0x0045 }
            if (r4 != 0) goto L_0x0062
            switch(r3) {
                case 1: goto L_0x004c;
                case 2: goto L_0x0055;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r3 = r6.zzcy()     // Catch:{ zzdi -> 0x0036 }
            if (r3 != 0) goto L_0x0014
            com.google.android.gms.internal.firebase_auth.zzdh r3 = new com.google.android.gms.internal.firebase_auth.zzdh     // Catch:{ zzdi -> 0x0036 }
            java.lang.String r4 = "Unable to parse map entry."
            r3.<init>(r4)     // Catch:{ zzdi -> 0x0036 }
            throw r3     // Catch:{ zzdi -> 0x0036 }
        L_0x0036:
            r3 = move-exception
            boolean r3 = r6.zzcy()     // Catch:{ all -> 0x0045 }
            if (r3 != 0) goto L_0x0014
            com.google.android.gms.internal.firebase_auth.zzdh r0 = new com.google.android.gms.internal.firebase_auth.zzdh     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "Unable to parse map entry."
            r0.<init>(r1)     // Catch:{ all -> 0x0045 }
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r0 = move-exception
            com.google.android.gms.internal.firebase_auth.zzcd r1 = r6.zzmv
            r1.zzp(r2)
            throw r0
        L_0x004c:
            com.google.android.gms.internal.firebase_auth.zzgf r3 = r8.zzsv     // Catch:{ zzdi -> 0x0036 }
            r4 = 0
            r5 = 0
            java.lang.Object r1 = r6.zza((com.google.android.gms.internal.firebase_auth.zzgf) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.firebase_auth.zzco) r5)     // Catch:{ zzdi -> 0x0036 }
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.firebase_auth.zzgf r3 = r8.zzsx     // Catch:{ zzdi -> 0x0036 }
            V r4 = r8.zzsy     // Catch:{ zzdi -> 0x0036 }
            java.lang.Class r4 = r4.getClass()     // Catch:{ zzdi -> 0x0036 }
            java.lang.Object r0 = r6.zza((com.google.android.gms.internal.firebase_auth.zzgf) r3, (java.lang.Class<?>) r4, (com.google.android.gms.internal.firebase_auth.zzco) r9)     // Catch:{ zzdi -> 0x0036 }
            goto L_0x0014
        L_0x0062:
            r7.put(r1, r0)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.firebase_auth.zzcd r0 = r6.zzmv
            r0.zzp(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcg.zza(java.util.Map, com.google.android.gms.internal.firebase_auth.zzea, com.google.android.gms.internal.firebase_auth.zzco):void");
    }

    public final <T> T zzb(zzex<T> zzex, zzco zzco) throws IOException {
        zzr(3);
        return zzd(zzex, zzco);
    }

    public final <T> void zzb(List<T> list, zzex<T> zzex, zzco zzco) throws IOException {
        int zzbz;
        if ((this.tag & 7) != 3) {
            throw zzdh.zzef();
        }
        int i = this.tag;
        do {
            list.add(zzd(zzex, zzco));
            if (!this.zzmv.zzcp() && this.zzmx == 0) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == i);
        this.zzmx = zzbz;
    }

    public final void zzc(List<Double> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzcl) {
            zzcl zzcl = (zzcl) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzs(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzcl.zzc(this.zzmv.readDouble());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzcl.zzc(this.zzmv.readDouble());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzs(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Double.valueOf(this.zzmv.readDouble()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Double.valueOf(this.zzmv.readDouble()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final long zzca() throws IOException {
        zzr(0);
        return this.zzmv.zzca();
    }

    public final long zzcb() throws IOException {
        zzr(0);
        return this.zzmv.zzcb();
    }

    public final int zzcc() throws IOException {
        zzr(0);
        return this.zzmv.zzcc();
    }

    public final long zzcd() throws IOException {
        zzr(1);
        return this.zzmv.zzcd();
    }

    public final int zzce() throws IOException {
        zzr(5);
        return this.zzmv.zzce();
    }

    public final boolean zzcf() throws IOException {
        zzr(0);
        return this.zzmv.zzcf();
    }

    public final String zzcg() throws IOException {
        zzr(2);
        return this.zzmv.zzcg();
    }

    public final zzbu zzch() throws IOException {
        zzr(2);
        return this.zzmv.zzch();
    }

    public final int zzci() throws IOException {
        zzr(0);
        return this.zzmv.zzci();
    }

    public final int zzcj() throws IOException {
        zzr(0);
        return this.zzmv.zzcj();
    }

    public final int zzck() throws IOException {
        zzr(5);
        return this.zzmv.zzck();
    }

    public final long zzcl() throws IOException {
        zzr(1);
        return this.zzmv.zzcl();
    }

    public final int zzcm() throws IOException {
        zzr(0);
        return this.zzmv.zzcm();
    }

    public final long zzcn() throws IOException {
        zzr(0);
        return this.zzmv.zzcn();
    }

    public final int zzcx() throws IOException {
        if (this.zzmx != 0) {
            this.tag = this.zzmx;
            this.zzmx = 0;
        } else {
            this.tag = this.zzmv.zzbz();
        }
        if (this.tag == 0 || this.tag == this.zzmw) {
            return Integer.MAX_VALUE;
        }
        return this.tag >>> 3;
    }

    public final boolean zzcy() throws IOException {
        if (this.zzmv.zzcp() || this.tag == this.zzmw) {
            return false;
        }
        return this.zzmv.zzm(this.tag);
    }

    public final void zzd(List<Float> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzcy) {
            zzcy zzcy = (zzcy) list;
            switch (this.tag & 7) {
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzt(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzcy.zzc(this.zzmv.readFloat());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                case 5:
                    break;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzcy.zzc(this.zzmv.readFloat());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzt(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Float.valueOf(this.zzmv.readFloat()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            case 5:
                break;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Float.valueOf(this.zzmv.readFloat()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zze(List<Long> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdv.zzl(this.zzmv.zzca());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdv.zzl(this.zzmv.zzca());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Long.valueOf(this.zzmv.zzca()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Long.valueOf(this.zzmv.zzca()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdv.zzl(this.zzmv.zzcb());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdv.zzl(this.zzmv.zzcb());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Long.valueOf(this.zzmv.zzcb()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Long.valueOf(this.zzmv.zzcb()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzcc());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzcc());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzcc()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzcc()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzh(List<Long> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzs(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzdv.zzl(this.zzmv.zzcd());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdv.zzl(this.zzmv.zzcd());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzs(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Long.valueOf(this.zzmv.zzcd()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Long.valueOf(this.zzmv.zzcd()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzi(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzt(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzce());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                case 5:
                    break;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzce());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzt(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzce()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            case 5:
                break;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzce()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzj(List<Boolean> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzbs) {
            zzbs zzbs = (zzbs) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzbs.addBoolean(this.zzmv.zzcf());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzbs.addBoolean(this.zzmv.zzcf());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Boolean.valueOf(this.zzmv.zzcf()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Boolean.valueOf(this.zzmv.zzcf()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzk(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzl(List<zzbu> list) throws IOException {
        int zzbz;
        if ((this.tag & 7) != 2) {
            throw zzdh.zzef();
        }
        do {
            list.add(zzch());
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzci());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzci());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzci()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzci()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzcj());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzcj());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzcj()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzcj()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzt(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzck());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                case 5:
                    break;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzck());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzt(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzck()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            case 5:
                break;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzck()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            switch (this.tag & 7) {
                case 1:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci();
                    zzs(zzci);
                    int zzcq = zzci + this.zzmv.zzcq();
                    do {
                        zzdv.zzl(this.zzmv.zzcl());
                    } while (this.zzmv.zzcq() < zzcq);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdv.zzl(this.zzmv.zzcl());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 1:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci();
                zzs(zzci2);
                int zzcq2 = zzci2 + this.zzmv.zzcq();
                do {
                    list.add(Long.valueOf(this.zzmv.zzcl()));
                } while (this.zzmv.zzcq() < zzcq2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Long.valueOf(this.zzmv.zzcl()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzq(List<Integer> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdc) {
            zzdc zzdc = (zzdc) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdc.zzak(this.zzmv.zzcm());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdc.zzak(this.zzmv.zzcm());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Integer.valueOf(this.zzmv.zzcm()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Integer.valueOf(this.zzmv.zzcm()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }

    public final void zzr(List<Long> list) throws IOException {
        int zzbz;
        int zzbz2;
        if (list instanceof zzdv) {
            zzdv zzdv = (zzdv) list;
            switch (this.tag & 7) {
                case 0:
                    break;
                case 2:
                    int zzci = this.zzmv.zzci() + this.zzmv.zzcq();
                    do {
                        zzdv.zzl(this.zzmv.zzcn());
                    } while (this.zzmv.zzcq() < zzci);
                    zzu(zzci);
                    return;
                default:
                    throw zzdh.zzef();
            }
            do {
                zzdv.zzl(this.zzmv.zzcn());
                if (!this.zzmv.zzcp()) {
                    zzbz2 = this.zzmv.zzbz();
                } else {
                    return;
                }
            } while (zzbz2 == this.tag);
            this.zzmx = zzbz2;
            return;
        }
        switch (this.tag & 7) {
            case 0:
                break;
            case 2:
                int zzci2 = this.zzmv.zzci() + this.zzmv.zzcq();
                do {
                    list.add(Long.valueOf(this.zzmv.zzcn()));
                } while (this.zzmv.zzcq() < zzci2);
                zzu(zzci2);
                return;
            default:
                throw zzdh.zzef();
        }
        do {
            list.add(Long.valueOf(this.zzmv.zzcn()));
            if (!this.zzmv.zzcp()) {
                zzbz = this.zzmv.zzbz();
            } else {
                return;
            }
        } while (zzbz == this.tag);
        this.zzmx = zzbz;
    }
}
