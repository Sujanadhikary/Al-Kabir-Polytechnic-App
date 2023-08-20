package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

final class zzeb extends zzjq {
    zzeb(zzjr zzjr) {
        super(zzjr);
    }

    private final Boolean zza(double d, zzkg zzkg) {
        try {
            return zza(new BigDecimal(d), zzkg, Math.ulp(d));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Boolean zza(long j, zzkg zzkg) {
        try {
            return zza(new BigDecimal(j), zzkg, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    private final Boolean zza(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException e) {
                    zzge().zzip().zzg("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(String str, zzkg zzkg) {
        if (!zzka.zzck(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzkg, 0.0d);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzki zzki) {
        List arrayList;
        String str2 = null;
        Preconditions.checkNotNull(zzki);
        if (str == null || zzki.zzash == null || zzki.zzash.intValue() == 0) {
            return null;
        }
        if (zzki.zzash.intValue() == 6) {
            if (zzki.zzask == null || zzki.zzask.length == 0) {
                return null;
            }
        } else if (zzki.zzasi == null) {
            return null;
        }
        int intValue = zzki.zzash.intValue();
        boolean z = zzki.zzasj != null && zzki.zzasj.booleanValue();
        String upperCase = (z || intValue == 1 || intValue == 6) ? zzki.zzasi : zzki.zzasi.toUpperCase(Locale.ENGLISH);
        if (zzki.zzask == null) {
            arrayList = null;
        } else {
            String[] strArr = zzki.zzask;
            if (z) {
                arrayList = Arrays.asList(strArr);
            } else {
                arrayList = new ArrayList();
                for (String upperCase2 : strArr) {
                    arrayList.add(upperCase2.toUpperCase(Locale.ENGLISH));
                }
            }
        }
        if (intValue == 1) {
            str2 = upperCase;
        }
        return zza(str, intValue, z, upperCase, arrayList, str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x007e, code lost:
        if (r5 != null) goto L_0x0080;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.zzkg r11, double r12) {
        /*
            r8 = 4
            r7 = -1
            r1 = 0
            r0 = 1
            r2 = 0
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.Integer r3 = r11.zzarz
            if (r3 == 0) goto L_0x0014
            java.lang.Integer r3 = r11.zzarz
            int r3 = r3.intValue()
            if (r3 != 0) goto L_0x0016
        L_0x0014:
            r0 = r2
        L_0x0015:
            return r0
        L_0x0016:
            java.lang.Integer r3 = r11.zzarz
            int r3 = r3.intValue()
            if (r3 != r8) goto L_0x0028
            java.lang.String r3 = r11.zzasc
            if (r3 == 0) goto L_0x0026
            java.lang.String r3 = r11.zzasd
            if (r3 != 0) goto L_0x002e
        L_0x0026:
            r0 = r2
            goto L_0x0015
        L_0x0028:
            java.lang.String r3 = r11.zzasb
            if (r3 != 0) goto L_0x002e
            r0 = r2
            goto L_0x0015
        L_0x002e:
            java.lang.Integer r3 = r11.zzarz
            int r6 = r3.intValue()
            java.lang.Integer r3 = r11.zzarz
            int r3 = r3.intValue()
            if (r3 != r8) goto L_0x0066
            java.lang.String r3 = r11.zzasc
            boolean r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3)
            if (r3 == 0) goto L_0x004c
            java.lang.String r3 = r11.zzasd
            boolean r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3)
            if (r3 != 0) goto L_0x004e
        L_0x004c:
            r0 = r2
            goto L_0x0015
        L_0x004e:
            java.math.BigDecimal r4 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r3 = r11.zzasc     // Catch:{ NumberFormatException -> 0x0063 }
            r4.<init>(r3)     // Catch:{ NumberFormatException -> 0x0063 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0063 }
            java.lang.String r5 = r11.zzasd     // Catch:{ NumberFormatException -> 0x0063 }
            r3.<init>(r5)     // Catch:{ NumberFormatException -> 0x0063 }
            r5 = r2
        L_0x005d:
            if (r6 != r8) goto L_0x007e
            if (r4 != 0) goto L_0x0080
            r0 = r2
            goto L_0x0015
        L_0x0063:
            r0 = move-exception
            r0 = r2
            goto L_0x0015
        L_0x0066:
            java.lang.String r3 = r11.zzasb
            boolean r3 = com.google.android.gms.internal.measurement.zzka.zzck(r3)
            if (r3 != 0) goto L_0x0070
            r0 = r2
            goto L_0x0015
        L_0x0070:
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x007b }
            java.lang.String r4 = r11.zzasb     // Catch:{ NumberFormatException -> 0x007b }
            r3.<init>(r4)     // Catch:{ NumberFormatException -> 0x007b }
            r4 = r2
            r5 = r3
            r3 = r2
            goto L_0x005d
        L_0x007b:
            r0 = move-exception
            r0 = r2
            goto L_0x0015
        L_0x007e:
            if (r5 == 0) goto L_0x0083
        L_0x0080:
            switch(r6) {
                case 1: goto L_0x0085;
                case 2: goto L_0x0092;
                case 3: goto L_0x00a0;
                case 4: goto L_0x00ee;
                default: goto L_0x0083;
            }
        L_0x0083:
            r0 = r2
            goto L_0x0015
        L_0x0085:
            int r2 = r10.compareTo(r5)
            if (r2 != r7) goto L_0x0090
        L_0x008b:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x0090:
            r0 = r1
            goto L_0x008b
        L_0x0092:
            int r2 = r10.compareTo(r5)
            if (r2 != r0) goto L_0x009e
        L_0x0098:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x009e:
            r0 = r1
            goto L_0x0098
        L_0x00a0:
            r2 = 0
            int r2 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00e0
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r12)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r4 = 2
            r3.<init>(r4)
            java.math.BigDecimal r2 = r2.multiply(r3)
            java.math.BigDecimal r2 = r5.subtract(r2)
            int r2 = r10.compareTo(r2)
            if (r2 != r0) goto L_0x00de
            java.math.BigDecimal r2 = new java.math.BigDecimal
            r2.<init>(r12)
            java.math.BigDecimal r3 = new java.math.BigDecimal
            r4 = 2
            r3.<init>(r4)
            java.math.BigDecimal r2 = r2.multiply(r3)
            java.math.BigDecimal r2 = r5.add(r2)
            int r2 = r10.compareTo(r2)
            if (r2 != r7) goto L_0x00de
        L_0x00d8:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x00de:
            r0 = r1
            goto L_0x00d8
        L_0x00e0:
            int r2 = r10.compareTo(r5)
            if (r2 != 0) goto L_0x00ec
        L_0x00e6:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x00ec:
            r0 = r1
            goto L_0x00e6
        L_0x00ee:
            int r2 = r10.compareTo(r4)
            if (r2 == r7) goto L_0x0100
            int r2 = r10.compareTo(r3)
            if (r2 == r0) goto L_0x0100
        L_0x00fa:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            goto L_0x0015
        L_0x0100:
            r0 = r1
            goto L_0x00fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzkg, double):java.lang.Boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v123, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0465  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x046e  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x076a  */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x076d  */
    /* JADX WARNING: Removed duplicated region for block: B:317:0x0bc2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0238  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x02ac  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0345  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.measurement.zzkm[] zza(java.lang.String r37, com.google.android.gms.internal.measurement.zzkn[] r38, com.google.android.gms.internal.measurement.zzks[] r39) {
        /*
            r36 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r37)
            java.util.HashSet r26 = new java.util.HashSet
            r26.<init>()
            android.support.v4.util.ArrayMap r27 = new android.support.v4.util.ArrayMap
            r27.<init>()
            android.support.v4.util.ArrayMap r28 = new android.support.v4.util.ArrayMap
            r28.<init>()
            android.support.v4.util.ArrayMap r29 = new android.support.v4.util.ArrayMap
            r29.<init>()
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            r0 = r37
            java.util.Map r8 = r4.zzbf(r0)
            if (r8 == 0) goto L_0x00e1
            java.util.Set r4 = r8.keySet()
            java.util.Iterator r9 = r4.iterator()
        L_0x002b:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x00e1
            java.lang.Object r4 = r9.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r10 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            java.lang.Object r4 = r8.get(r4)
            com.google.android.gms.internal.measurement.zzkr r4 = (com.google.android.gms.internal.measurement.zzkr) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            r0 = r28
            java.lang.Object r5 = r0.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r0 = r29
            java.lang.Object r6 = r0.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            if (r5 != 0) goto L_0x007b
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r0 = r28
            r0.put(r6, r5)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            r0 = r29
            r0.put(r7, r6)
        L_0x007b:
            r7 = 0
        L_0x007c:
            long[] r11 = r4.zzauk
            int r11 = r11.length
            int r11 = r11 << 6
            if (r7 >= r11) goto L_0x00b1
            long[] r11 = r4.zzauk
            boolean r11 = com.google.android.gms.internal.measurement.zzka.zza((long[]) r11, (int) r7)
            if (r11 == 0) goto L_0x00ae
            com.google.android.gms.internal.measurement.zzfg r11 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r11 = r11.zzit()
            java.lang.String r12 = "Filter already evaluated. audience ID, filter ID"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r10)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r7)
            r11.zze(r12, r13, r14)
            r6.set(r7)
            long[] r11 = r4.zzaul
            boolean r11 = com.google.android.gms.internal.measurement.zzka.zza((long[]) r11, (int) r7)
            if (r11 == 0) goto L_0x00ae
            r5.set(r7)
        L_0x00ae:
            int r7 = r7 + 1
            goto L_0x007c
        L_0x00b1:
            com.google.android.gms.internal.measurement.zzkm r7 = new com.google.android.gms.internal.measurement.zzkm
            r7.<init>()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r0 = r27
            r0.put(r10, r7)
            r10 = 0
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            r7.zzasy = r10
            r7.zzasx = r4
            com.google.android.gms.internal.measurement.zzkr r4 = new com.google.android.gms.internal.measurement.zzkr
            r4.<init>()
            r7.zzasw = r4
            com.google.android.gms.internal.measurement.zzkr r4 = r7.zzasw
            long[] r5 = com.google.android.gms.internal.measurement.zzka.zza((java.util.BitSet) r5)
            r4.zzaul = r5
            com.google.android.gms.internal.measurement.zzkr r4 = r7.zzasw
            long[] r5 = com.google.android.gms.internal.measurement.zzka.zza((java.util.BitSet) r6)
            r4.zzauk = r5
            goto L_0x002b
        L_0x00e1:
            if (r38 == 0) goto L_0x0787
            r10 = 0
            r8 = 0
            r5 = 0
            android.support.v4.util.ArrayMap r30 = new android.support.v4.util.ArrayMap
            r30.<init>()
            r0 = r38
            int r0 = r0.length
            r31 = r0
            r4 = 0
            r25 = r4
        L_0x00f4:
            r0 = r25
            r1 = r31
            if (r0 >= r1) goto L_0x0787
            r14 = r38[r25]
            java.lang.String r11 = r14.name
            com.google.android.gms.internal.measurement.zzko[] r12 = r14.zzata
            com.google.android.gms.internal.measurement.zzef r4 = r36.zzgg()
            com.google.android.gms.internal.measurement.zzex<java.lang.Boolean> r6 = com.google.android.gms.internal.measurement.zzew.zzahv
            r0 = r37
            boolean r4 = r4.zzd(r0, r6)
            if (r4 == 0) goto L_0x0ba7
            r36.zzgb()
            java.lang.String r4 = "_eid"
            java.lang.Object r7 = com.google.android.gms.internal.measurement.zzka.zzb(r14, r4)
            java.lang.Long r7 = (java.lang.Long) r7
            if (r7 == 0) goto L_0x014e
            r4 = 1
            r6 = r4
        L_0x011d:
            if (r6 == 0) goto L_0x0151
            java.lang.String r4 = "_ep"
            boolean r4 = r11.equals(r4)
            if (r4 == 0) goto L_0x0151
            r4 = 1
        L_0x0128:
            if (r4 == 0) goto L_0x02f5
            r36.zzgb()
            java.lang.String r4 = "_en"
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzka.zzb(r14, r4)
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
            boolean r4 = android.text.TextUtils.isEmpty(r11)
            if (r4 == 0) goto L_0x0153
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()
            java.lang.String r6 = "Extra parameter without an event name. eventId"
            r4.zzg(r6, r7)
        L_0x0149:
            int r4 = r25 + 1
            r25 = r4
            goto L_0x00f4
        L_0x014e:
            r4 = 0
            r6 = r4
            goto L_0x011d
        L_0x0151:
            r4 = 0
            goto L_0x0128
        L_0x0153:
            if (r10 == 0) goto L_0x0163
            if (r5 == 0) goto L_0x0163
            long r16 = r7.longValue()
            long r18 = r5.longValue()
            int r4 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r4 == 0) goto L_0x0bb3
        L_0x0163:
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            r0 = r37
            android.util.Pair r6 = r4.zza((java.lang.String) r0, (java.lang.Long) r7)
            if (r6 == 0) goto L_0x0173
            java.lang.Object r4 = r6.first
            if (r4 != 0) goto L_0x0181
        L_0x0173:
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()
            java.lang.String r6 = "Extra parameter without existing main event. eventName, eventId"
            r4.zze(r6, r11, r7)
            goto L_0x0149
        L_0x0181:
            java.lang.Object r4 = r6.first
            com.google.android.gms.internal.measurement.zzkn r4 = (com.google.android.gms.internal.measurement.zzkn) r4
            java.lang.Object r5 = r6.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r8 = r5.longValue()
            r36.zzgb()
            java.lang.String r5 = "_eid"
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzka.zzb(r4, r5)
            java.lang.Long r5 = (java.lang.Long) r5
            r13 = r5
            r10 = r4
        L_0x019a:
            r4 = 1
            long r8 = r8 - r4
            r4 = 0
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x0202
            com.google.android.gms.internal.measurement.zzei r5 = r36.zzix()
            r5.zzab()
            com.google.android.gms.internal.measurement.zzfg r4 = r5.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzit()
            java.lang.String r6 = "Clearing complex main event info. appId"
            r0 = r37
            r4.zzg(r6, r0)
            android.database.sqlite.SQLiteDatabase r4 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x01f3 }
            java.lang.String r6 = "delete from main_event_params where app_id=?"
            r7 = 1
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x01f3 }
            r15 = 0
            r7[r15] = r37     // Catch:{ SQLiteException -> 0x01f3 }
            r4.execSQL(r6, r7)     // Catch:{ SQLiteException -> 0x01f3 }
        L_0x01c8:
            com.google.android.gms.internal.measurement.zzko[] r4 = r10.zzata
            int r4 = r4.length
            int r5 = r12.length
            int r4 = r4 + r5
            com.google.android.gms.internal.measurement.zzko[] r6 = new com.google.android.gms.internal.measurement.zzko[r4]
            r5 = 0
            com.google.android.gms.internal.measurement.zzko[] r15 = r10.zzata
            int r0 = r15.length
            r16 = r0
            r4 = 0
            r7 = r4
        L_0x01d7:
            r0 = r16
            if (r7 >= r0) goto L_0x020c
            r17 = r15[r7]
            r36.zzgb()
            r0 = r17
            java.lang.String r4 = r0.name
            com.google.android.gms.internal.measurement.zzko r4 = com.google.android.gms.internal.measurement.zzka.zza((com.google.android.gms.internal.measurement.zzkn) r14, (java.lang.String) r4)
            if (r4 != 0) goto L_0x0bc5
            int r4 = r5 + 1
            r6[r5] = r17
        L_0x01ee:
            int r5 = r7 + 1
            r7 = r5
            r5 = r4
            goto L_0x01d7
        L_0x01f3:
            r4 = move-exception
            com.google.android.gms.internal.measurement.zzfg r5 = r5.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzim()
            java.lang.String r6 = "Error clearing complex main event"
            r5.zzg(r6, r4)
            goto L_0x01c8
        L_0x0202:
            com.google.android.gms.internal.measurement.zzei r5 = r36.zzix()
            r6 = r37
            r5.zza(r6, r7, r8, r10)
            goto L_0x01c8
        L_0x020c:
            if (r5 <= 0) goto L_0x02dc
            int r15 = r12.length
            r4 = 0
        L_0x0210:
            if (r4 >= r15) goto L_0x021c
            r16 = r12[r4]
            int r7 = r5 + 1
            r6[r5] = r16
            int r4 = r4 + 1
            r5 = r7
            goto L_0x0210
        L_0x021c:
            int r4 = r6.length
            if (r5 != r4) goto L_0x02d4
            r4 = r6
        L_0x0220:
            r19 = r4
            r20 = r11
            r21 = r13
            r22 = r8
            r24 = r10
        L_0x022a:
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            java.lang.String r5 = r14.name
            r0 = r37
            com.google.android.gms.internal.measurement.zzeq r4 = r4.zzf(r0, r5)
            if (r4 != 0) goto L_0x0345
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzip()
            java.lang.String r5 = "Event aggregate wasn't created during raw event logging. appId, event"
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)
            com.google.android.gms.internal.measurement.zzfe r7 = r36.zzga()
            r0 = r20
            java.lang.String r7 = r7.zzbj(r0)
            r4.zze(r5, r6, r7)
            com.google.android.gms.internal.measurement.zzeq r5 = new com.google.android.gms.internal.measurement.zzeq
            java.lang.String r7 = r14.name
            r8 = 1
            r10 = 1
            java.lang.Long r4 = r14.zzatb
            long r12 = r4.longValue()
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r6 = r37
            r5.<init>(r6, r7, r8, r10, r12, r14, r16, r17, r18)
        L_0x026e:
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            r4.zza((com.google.android.gms.internal.measurement.zzeq) r5)
            long r12 = r5.zzafr
            r0 = r30
            r1 = r20
            java.lang.Object r4 = r0.get(r1)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto L_0x0bc2
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            r0 = r37
            r1 = r20
            java.util.Map r4 = r4.zzk(r0, r1)
            if (r4 != 0) goto L_0x0296
            android.support.v4.util.ArrayMap r4 = new android.support.v4.util.ArrayMap
            r4.<init>()
        L_0x0296:
            r0 = r30
            r1 = r20
            r0.put(r1, r4)
            r7 = r4
        L_0x029e:
            java.util.Set r4 = r7.keySet()
            java.util.Iterator r11 = r4.iterator()
        L_0x02a6:
            boolean r4 = r11.hasNext()
            if (r4 == 0) goto L_0x0bba
            java.lang.Object r4 = r11.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r14 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r0 = r26
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x034b
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzit()
            java.lang.String r5 = "Skipping failed audience ID"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            r4.zzg(r5, r6)
            goto L_0x02a6
        L_0x02d4:
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r6, r5)
            com.google.android.gms.internal.measurement.zzko[] r4 = (com.google.android.gms.internal.measurement.zzko[]) r4
            goto L_0x0220
        L_0x02dc:
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzip()
            java.lang.String r5 = "No unique parameters in main event. eventName"
            r4.zzg(r5, r11)
            r19 = r12
            r20 = r11
            r21 = r13
            r22 = r8
            r24 = r10
            goto L_0x022a
        L_0x02f5:
            if (r6 == 0) goto L_0x0ba7
            r36.zzgb()
            java.lang.String r5 = "_epc"
            r8 = 0
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzka.zzb(r14, r5)
            if (r5 != 0) goto L_0x032d
        L_0x0308:
            java.lang.Long r4 = (java.lang.Long) r4
            long r8 = r4.longValue()
            r4 = 0
            int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r4 > 0) goto L_0x032f
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzip()
            java.lang.String r5 = "Complex event with zero extra param count. eventName"
            r4.zzg(r5, r11)
            r19 = r12
            r20 = r11
            r21 = r7
            r22 = r8
            r24 = r14
            goto L_0x022a
        L_0x032d:
            r4 = r5
            goto L_0x0308
        L_0x032f:
            com.google.android.gms.internal.measurement.zzei r5 = r36.zzix()
            r6 = r37
            r10 = r14
            r5.zza(r6, r7, r8, r10)
            r19 = r12
            r20 = r11
            r21 = r7
            r22 = r8
            r24 = r14
            goto L_0x022a
        L_0x0345:
            com.google.android.gms.internal.measurement.zzeq r5 = r4.zzie()
            goto L_0x026e
        L_0x034b:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r0 = r27
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzkm r4 = (com.google.android.gms.internal.measurement.zzkm) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r0 = r28
            java.lang.Object r5 = r0.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            r0 = r29
            java.lang.Object r6 = r0.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            if (r4 != 0) goto L_0x0bb6
            com.google.android.gms.internal.measurement.zzkm r4 = new com.google.android.gms.internal.measurement.zzkm
            r4.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r0 = r27
            r0.put(r5, r4)
            r5 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.zzasy = r5
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r0 = r28
            r0.put(r4, r5)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r0 = r29
            r0.put(r4, r6)
            r8 = r6
            r9 = r5
        L_0x03a4:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.Object r4 = r7.get(r4)
            java.util.List r4 = (java.util.List) r4
            java.util.Iterator r15 = r4.iterator()
        L_0x03b2:
            boolean r4 = r15.hasNext()
            if (r4 == 0) goto L_0x02a6
            java.lang.Object r4 = r15.next()
            com.google.android.gms.internal.measurement.zzke r4 = (com.google.android.gms.internal.measurement.zzke) r4
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            r6 = 2
            boolean r5 = r5.isLoggable(r6)
            if (r5 == 0) goto L_0x0403
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzit()
            java.lang.String r6 = "Evaluating filter. audience, filter, event"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)
            java.lang.Integer r0 = r4.zzarp
            r16 = r0
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r4.zzarq
            r18 = r0
            java.lang.String r17 = r17.zzbj(r18)
            r0 = r16
            r1 = r17
            r5.zzd(r6, r10, r0, r1)
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzit()
            java.lang.String r6 = "Filter definition"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            java.lang.String r10 = r10.zza((com.google.android.gms.internal.measurement.zzke) r4)
            r5.zzg(r6, r10)
        L_0x0403:
            java.lang.Integer r5 = r4.zzarp
            if (r5 == 0) goto L_0x0411
            java.lang.Integer r5 = r4.zzarp
            int r5 = r5.intValue()
            r6 = 256(0x100, float:3.59E-43)
            if (r5 <= r6) goto L_0x0429
        L_0x0411:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Invalid event filter ID. appId, id"
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)
            java.lang.Integer r4 = r4.zzarp
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5.zze(r6, r10, r4)
            goto L_0x03b2
        L_0x0429:
            java.lang.Integer r5 = r4.zzarp
            int r5 = r5.intValue()
            boolean r5 = r9.get(r5)
            if (r5 == 0) goto L_0x044a
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzit()
            java.lang.String r6 = "Event filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r14)
            java.lang.Integer r4 = r4.zzarp
            r5.zze(r6, r10, r4)
            goto L_0x03b2
        L_0x044a:
            com.google.android.gms.internal.measurement.zzkg r5 = r4.zzart
            if (r5 == 0) goto L_0x0485
            com.google.android.gms.internal.measurement.zzkg r5 = r4.zzart
            r0 = r36
            java.lang.Boolean r5 = r0.zza((long) r12, (com.google.android.gms.internal.measurement.zzkg) r5)
            if (r5 != 0) goto L_0x0479
            r5 = 0
        L_0x0459:
            com.google.android.gms.internal.measurement.zzfg r6 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r10 = r6.zzit()
            java.lang.String r16 = "Event filter result"
            if (r5 != 0) goto L_0x076a
            java.lang.String r6 = "null"
        L_0x0467:
            r0 = r16
            r10.zzg(r0, r6)
            if (r5 != 0) goto L_0x076d
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            r0 = r26
            r0.add(r4)
            goto L_0x03b2
        L_0x0479:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0485
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x0485:
            java.util.HashSet r6 = new java.util.HashSet
            r6.<init>()
            com.google.android.gms.internal.measurement.zzkf[] r10 = r4.zzarr
            int r0 = r10.length
            r16 = r0
            r5 = 0
        L_0x0490:
            r0 = r16
            if (r5 >= r0) goto L_0x04c9
            r17 = r10[r5]
            r0 = r17
            java.lang.String r0 = r0.zzary
            r18 = r0
            boolean r18 = android.text.TextUtils.isEmpty(r18)
            if (r18 == 0) goto L_0x04bb
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "null or empty param name in filter. event"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            r5.zzg(r6, r10)
            r5 = 0
            goto L_0x0459
        L_0x04bb:
            r0 = r17
            java.lang.String r0 = r0.zzary
            r17 = r0
            r0 = r17
            r6.add(r0)
            int r5 = r5 + 1
            goto L_0x0490
        L_0x04c9:
            android.support.v4.util.ArrayMap r16 = new android.support.v4.util.ArrayMap
            r16.<init>()
            r0 = r19
            int r10 = r0.length
            r5 = 0
        L_0x04d2:
            if (r5 >= r10) goto L_0x056a
            r17 = r19[r5]
            r0 = r17
            java.lang.String r0 = r0.name
            r18 = r0
            r0 = r18
            boolean r18 = r6.contains(r0)
            if (r18 == 0) goto L_0x0501
            r0 = r17
            java.lang.Long r0 = r0.zzate
            r18 = r0
            if (r18 == 0) goto L_0x0504
            r0 = r17
            java.lang.String r0 = r0.name
            r18 = r0
            r0 = r17
            java.lang.Long r0 = r0.zzate
            r17 = r0
            r0 = r16
            r1 = r18
            r2 = r17
            r0.put(r1, r2)
        L_0x0501:
            int r5 = r5 + 1
            goto L_0x04d2
        L_0x0504:
            r0 = r17
            java.lang.Double r0 = r0.zzarc
            r18 = r0
            if (r18 == 0) goto L_0x0522
            r0 = r17
            java.lang.String r0 = r0.name
            r18 = r0
            r0 = r17
            java.lang.Double r0 = r0.zzarc
            r17 = r0
            r0 = r16
            r1 = r18
            r2 = r17
            r0.put(r1, r2)
            goto L_0x0501
        L_0x0522:
            r0 = r17
            java.lang.String r0 = r0.zzajf
            r18 = r0
            if (r18 == 0) goto L_0x0540
            r0 = r17
            java.lang.String r0 = r0.name
            r18 = r0
            r0 = r17
            java.lang.String r0 = r0.zzajf
            r17 = r0
            r0 = r16
            r1 = r18
            r2 = r17
            r0.put(r1, r2)
            goto L_0x0501
        L_0x0540:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Unknown value for param. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r17
            java.lang.String r0 = r0.name
            r17 = r0
            java.lang.String r16 = r16.zzbk(r17)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x056a:
            com.google.android.gms.internal.measurement.zzkf[] r0 = r4.zzarr
            r17 = r0
            r0 = r17
            int r0 = r0.length
            r18 = r0
            r5 = 0
            r10 = r5
        L_0x0575:
            r0 = r18
            if (r10 >= r0) goto L_0x0763
            r32 = r17[r10]
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            r0 = r32
            java.lang.Boolean r6 = r0.zzarx
            boolean r33 = r5.equals(r6)
            r0 = r32
            java.lang.String r0 = r0.zzary
            r34 = r0
            boolean r5 = android.text.TextUtils.isEmpty(r34)
            if (r5 == 0) goto L_0x05ab
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Event has empty param name. event"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            r5.zzg(r6, r10)
            r5 = 0
            goto L_0x0459
        L_0x05ab:
            r0 = r16
            r1 = r34
            java.lang.Object r5 = r0.get(r1)
            boolean r6 = r5 instanceof java.lang.Long
            if (r6 == 0) goto L_0x0610
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r6 = r0.zzarw
            if (r6 != 0) goto L_0x05e5
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "No number filter for long param. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x05e5:
            java.lang.Long r5 = (java.lang.Long) r5
            long r34 = r5.longValue()
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r5 = r0.zzarw
            r0 = r36
            r1 = r34
            java.lang.Boolean r5 = r0.zza((long) r1, (com.google.android.gms.internal.measurement.zzkg) r5)
            if (r5 != 0) goto L_0x05fc
            r5 = 0
            goto L_0x0459
        L_0x05fc:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x060e
            r5 = 1
        L_0x0603:
            r5 = r5 ^ r33
            if (r5 == 0) goto L_0x075e
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x060e:
            r5 = 0
            goto L_0x0603
        L_0x0610:
            boolean r6 = r5 instanceof java.lang.Double
            if (r6 == 0) goto L_0x066d
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r6 = r0.zzarw
            if (r6 != 0) goto L_0x0642
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "No number filter for double param. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x0642:
            java.lang.Double r5 = (java.lang.Double) r5
            double r34 = r5.doubleValue()
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r5 = r0.zzarw
            r0 = r36
            r1 = r34
            java.lang.Boolean r5 = r0.zza((double) r1, (com.google.android.gms.internal.measurement.zzkg) r5)
            if (r5 != 0) goto L_0x0659
            r5 = 0
            goto L_0x0459
        L_0x0659:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x066b
            r5 = 1
        L_0x0660:
            r5 = r5 ^ r33
            if (r5 == 0) goto L_0x075e
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x066b:
            r5 = 0
            goto L_0x0660
        L_0x066d:
            boolean r6 = r5 instanceof java.lang.String
            if (r6 == 0) goto L_0x0708
            r0 = r32
            com.google.android.gms.internal.measurement.zzki r6 = r0.zzarv
            if (r6 == 0) goto L_0x0688
            java.lang.String r5 = (java.lang.String) r5
            r0 = r32
            com.google.android.gms.internal.measurement.zzki r6 = r0.zzarv
            r0 = r36
            java.lang.Boolean r5 = r0.zza((java.lang.String) r5, (com.google.android.gms.internal.measurement.zzki) r6)
        L_0x0683:
            if (r5 != 0) goto L_0x06f4
            r5 = 0
            goto L_0x0459
        L_0x0688:
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r6 = r0.zzarw
            if (r6 == 0) goto L_0x06cc
            r6 = r5
            java.lang.String r6 = (java.lang.String) r6
            boolean r6 = com.google.android.gms.internal.measurement.zzka.zzck(r6)
            if (r6 == 0) goto L_0x06a4
            java.lang.String r5 = (java.lang.String) r5
            r0 = r32
            com.google.android.gms.internal.measurement.zzkg r6 = r0.zzarw
            r0 = r36
            java.lang.Boolean r5 = r0.zza((java.lang.String) r5, (com.google.android.gms.internal.measurement.zzkg) r6)
            goto L_0x0683
        L_0x06a4:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Invalid param value for number filter. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x06cc:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "No filter for String param. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x06f4:
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x0706
            r5 = 1
        L_0x06fb:
            r5 = r5 ^ r33
            if (r5 == 0) goto L_0x075e
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x0706:
            r5 = 0
            goto L_0x06fb
        L_0x0708:
            if (r5 != 0) goto L_0x0736
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzit()
            java.lang.String r6 = "Missing param for filter. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x0736:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Unknown param type. event, param"
            com.google.android.gms.internal.measurement.zzfe r10 = r36.zzga()
            r0 = r20
            java.lang.String r10 = r10.zzbj(r0)
            com.google.android.gms.internal.measurement.zzfe r16 = r36.zzga()
            r0 = r16
            r1 = r34
            java.lang.String r16 = r0.zzbk(r1)
            r0 = r16
            r5.zze(r6, r10, r0)
            r5 = 0
            goto L_0x0459
        L_0x075e:
            int r5 = r10 + 1
            r10 = r5
            goto L_0x0575
        L_0x0763:
            r5 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            goto L_0x0459
        L_0x076a:
            r6 = r5
            goto L_0x0467
        L_0x076d:
            java.lang.Integer r6 = r4.zzarp
            int r6 = r6.intValue()
            r8.set(r6)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x03b2
            java.lang.Integer r4 = r4.zzarp
            int r4 = r4.intValue()
            r9.set(r4)
            goto L_0x03b2
        L_0x0787:
            if (r39 == 0) goto L_0x0a93
            android.support.v4.util.ArrayMap r11 = new android.support.v4.util.ArrayMap
            r11.<init>()
            r0 = r39
            int r12 = r0.length
            r4 = 0
            r10 = r4
        L_0x0793:
            if (r10 >= r12) goto L_0x0a93
            r13 = r39[r10]
            java.lang.String r4 = r13.name
            java.lang.Object r4 = r11.get(r4)
            java.util.Map r4 = (java.util.Map) r4
            if (r4 != 0) goto L_0x0ba4
            com.google.android.gms.internal.measurement.zzei r4 = r36.zzix()
            java.lang.String r5 = r13.name
            r0 = r37
            java.util.Map r4 = r4.zzl(r0, r5)
            if (r4 != 0) goto L_0x07b4
            android.support.v4.util.ArrayMap r4 = new android.support.v4.util.ArrayMap
            r4.<init>()
        L_0x07b4:
            java.lang.String r5 = r13.name
            r11.put(r5, r4)
            r7 = r4
        L_0x07ba:
            java.util.Set r4 = r7.keySet()
            java.util.Iterator r14 = r4.iterator()
        L_0x07c2:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x0a8e
            java.lang.Object r4 = r14.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r15 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r26
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L_0x07f0
            com.google.android.gms.internal.measurement.zzfg r4 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzit()
            java.lang.String r5 = "Skipping failed audience ID"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r4.zzg(r5, r6)
            goto L_0x07c2
        L_0x07f0:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r27
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzkm r4 = (com.google.android.gms.internal.measurement.zzkm) r4
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            r0 = r28
            java.lang.Object r5 = r0.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r0 = r29
            java.lang.Object r6 = r0.get(r6)
            java.util.BitSet r6 = (java.util.BitSet) r6
            if (r4 != 0) goto L_0x0847
            com.google.android.gms.internal.measurement.zzkm r4 = new com.google.android.gms.internal.measurement.zzkm
            r4.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r15)
            r0 = r27
            r0.put(r5, r4)
            r5 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            r4.zzasy = r5
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r28
            r0.put(r4, r5)
            java.util.BitSet r6 = new java.util.BitSet
            r6.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r29
            r0.put(r4, r6)
        L_0x0847:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            java.lang.Object r4 = r7.get(r4)
            java.util.List r4 = (java.util.List) r4
            java.util.Iterator r16 = r4.iterator()
        L_0x0855:
            boolean r4 = r16.hasNext()
            if (r4 == 0) goto L_0x07c2
            java.lang.Object r4 = r16.next()
            com.google.android.gms.internal.measurement.zzkh r4 = (com.google.android.gms.internal.measurement.zzkh) r4
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            r9 = 2
            boolean r8 = r8.isLoggable(r9)
            if (r8 == 0) goto L_0x08ac
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzit()
            java.lang.String r9 = "Evaluating filter. audience, filter, property"
            java.lang.Integer r17 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r0 = r4.zzarp
            r18 = r0
            com.google.android.gms.internal.measurement.zzfe r19 = r36.zzga()
            java.lang.String r0 = r4.zzasf
            r20 = r0
            java.lang.String r19 = r19.zzbl(r20)
            r0 = r17
            r1 = r18
            r2 = r19
            r8.zzd(r9, r0, r1, r2)
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzit()
            java.lang.String r9 = "Filter definition"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            r0 = r17
            java.lang.String r17 = r0.zza((com.google.android.gms.internal.measurement.zzkh) r4)
            r0 = r17
            r8.zzg(r9, r0)
        L_0x08ac:
            java.lang.Integer r8 = r4.zzarp
            if (r8 == 0) goto L_0x08ba
            java.lang.Integer r8 = r4.zzarp
            int r8 = r8.intValue()
            r9 = 256(0x100, float:3.59E-43)
            if (r8 <= r9) goto L_0x08dc
        L_0x08ba:
            com.google.android.gms.internal.measurement.zzfg r5 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzip()
            java.lang.String r6 = "Invalid property filter ID. appId, id"
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)
            java.lang.Integer r4 = r4.zzarp
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r5.zze(r6, r8, r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r26
            r0.add(r4)
            goto L_0x07c2
        L_0x08dc:
            java.lang.Integer r8 = r4.zzarp
            int r8 = r8.intValue()
            boolean r8 = r5.get(r8)
            if (r8 == 0) goto L_0x08ff
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzit()
            java.lang.String r9 = "Property filter already evaluated true. audience ID, filter ID"
            java.lang.Integer r17 = java.lang.Integer.valueOf(r15)
            java.lang.Integer r4 = r4.zzarp
            r0 = r17
            r8.zze(r9, r0, r4)
            goto L_0x0855
        L_0x08ff:
            com.google.android.gms.internal.measurement.zzkf r8 = r4.zzasg
            if (r8 != 0) goto L_0x0941
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "Missing property filter. property"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            r0 = r17
            r8.zzg(r9, r0)
            r8 = 0
        L_0x091f:
            com.google.android.gms.internal.measurement.zzfg r9 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r17 = r9.zzit()
            java.lang.String r18 = "Property filter result"
            if (r8 != 0) goto L_0x0a71
            java.lang.String r9 = "null"
        L_0x092d:
            r0 = r17
            r1 = r18
            r0.zzg(r1, r9)
            if (r8 != 0) goto L_0x0a74
            java.lang.Integer r4 = java.lang.Integer.valueOf(r15)
            r0 = r26
            r0.add(r4)
            goto L_0x0855
        L_0x0941:
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            java.lang.Boolean r0 = r8.zzarx
            r17 = r0
            r0 = r17
            boolean r9 = r9.equals(r0)
            java.lang.Long r0 = r13.zzate
            r17 = r0
            if (r17 == 0) goto L_0x098d
            com.google.android.gms.internal.measurement.zzkg r0 = r8.zzarw
            r17 = r0
            if (r17 != 0) goto L_0x0976
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "No number filter for long property. property"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            r0 = r17
            r8.zzg(r9, r0)
            r8 = 0
            goto L_0x091f
        L_0x0976:
            java.lang.Long r0 = r13.zzate
            r17 = r0
            long r18 = r17.longValue()
            com.google.android.gms.internal.measurement.zzkg r8 = r8.zzarw
            r0 = r36
            r1 = r18
            java.lang.Boolean r8 = r0.zza((long) r1, (com.google.android.gms.internal.measurement.zzkg) r8)
            java.lang.Boolean r8 = zza((java.lang.Boolean) r8, (boolean) r9)
            goto L_0x091f
        L_0x098d:
            java.lang.Double r0 = r13.zzarc
            r17 = r0
            if (r17 == 0) goto L_0x09cf
            com.google.android.gms.internal.measurement.zzkg r0 = r8.zzarw
            r17 = r0
            if (r17 != 0) goto L_0x09b7
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "No number filter for double property. property"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            r0 = r17
            r8.zzg(r9, r0)
            r8 = 0
            goto L_0x091f
        L_0x09b7:
            java.lang.Double r0 = r13.zzarc
            r17 = r0
            double r18 = r17.doubleValue()
            com.google.android.gms.internal.measurement.zzkg r8 = r8.zzarw
            r0 = r36
            r1 = r18
            java.lang.Boolean r8 = r0.zza((double) r1, (com.google.android.gms.internal.measurement.zzkg) r8)
            java.lang.Boolean r8 = zza((java.lang.Boolean) r8, (boolean) r9)
            goto L_0x091f
        L_0x09cf:
            java.lang.String r0 = r13.zzajf
            r17 = r0
            if (r17 == 0) goto L_0x0a53
            com.google.android.gms.internal.measurement.zzki r0 = r8.zzarv
            r17 = r0
            if (r17 != 0) goto L_0x0a3f
            com.google.android.gms.internal.measurement.zzkg r0 = r8.zzarw
            r17 = r0
            if (r17 != 0) goto L_0x09ff
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "No string or number filter defined. property"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            r0 = r17
            r8.zzg(r9, r0)
        L_0x09fc:
            r8 = 0
            goto L_0x091f
        L_0x09ff:
            java.lang.String r0 = r13.zzajf
            r17 = r0
            boolean r17 = com.google.android.gms.internal.measurement.zzka.zzck(r17)
            if (r17 == 0) goto L_0x0a1d
            java.lang.String r0 = r13.zzajf
            r17 = r0
            com.google.android.gms.internal.measurement.zzkg r8 = r8.zzarw
            r0 = r36
            r1 = r17
            java.lang.Boolean r8 = r0.zza((java.lang.String) r1, (com.google.android.gms.internal.measurement.zzkg) r8)
            java.lang.Boolean r8 = zza((java.lang.Boolean) r8, (boolean) r9)
            goto L_0x091f
        L_0x0a1d:
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "Invalid user property value for Numeric number filter. property, value"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            java.lang.String r0 = r13.zzajf
            r18 = r0
            r0 = r17
            r1 = r18
            r8.zze(r9, r0, r1)
            goto L_0x09fc
        L_0x0a3f:
            java.lang.String r0 = r13.zzajf
            r17 = r0
            com.google.android.gms.internal.measurement.zzki r8 = r8.zzarv
            r0 = r36
            r1 = r17
            java.lang.Boolean r8 = r0.zza((java.lang.String) r1, (com.google.android.gms.internal.measurement.zzki) r8)
            java.lang.Boolean r8 = zza((java.lang.Boolean) r8, (boolean) r9)
            goto L_0x091f
        L_0x0a53:
            com.google.android.gms.internal.measurement.zzfg r8 = r36.zzge()
            com.google.android.gms.internal.measurement.zzfi r8 = r8.zzip()
            java.lang.String r9 = "User property has no value, property"
            com.google.android.gms.internal.measurement.zzfe r17 = r36.zzga()
            java.lang.String r0 = r13.name
            r18 = r0
            java.lang.String r17 = r17.zzbl(r18)
            r0 = r17
            r8.zzg(r9, r0)
            r8 = 0
            goto L_0x091f
        L_0x0a71:
            r9 = r8
            goto L_0x092d
        L_0x0a74:
            java.lang.Integer r9 = r4.zzarp
            int r9 = r9.intValue()
            r6.set(r9)
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x0855
            java.lang.Integer r4 = r4.zzarp
            int r4 = r4.intValue()
            r5.set(r4)
            goto L_0x0855
        L_0x0a8e:
            int r4 = r10 + 1
            r10 = r4
            goto L_0x0793
        L_0x0a93:
            int r4 = r28.size()
            com.google.android.gms.internal.measurement.zzkm[] r8 = new com.google.android.gms.internal.measurement.zzkm[r4]
            r4 = 0
            java.util.Set r5 = r28.keySet()
            java.util.Iterator r9 = r5.iterator()
            r5 = r4
        L_0x0aa3:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0b9a
            java.lang.Object r4 = r9.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r10 = r4.intValue()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r0 = r26
            boolean r4 = r0.contains(r4)
            if (r4 != 0) goto L_0x0aa3
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r0 = r27
            java.lang.Object r4 = r0.get(r4)
            com.google.android.gms.internal.measurement.zzkm r4 = (com.google.android.gms.internal.measurement.zzkm) r4
            if (r4 != 0) goto L_0x0ba1
            com.google.android.gms.internal.measurement.zzkm r4 = new com.google.android.gms.internal.measurement.zzkm
            r4.<init>()
            r7 = r4
        L_0x0ad3:
            int r6 = r5 + 1
            r8[r5] = r7
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r7.zzarl = r4
            com.google.android.gms.internal.measurement.zzkr r4 = new com.google.android.gms.internal.measurement.zzkr
            r4.<init>()
            r7.zzasw = r4
            com.google.android.gms.internal.measurement.zzkr r5 = r7.zzasw
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r0 = r28
            java.lang.Object r4 = r0.get(r4)
            java.util.BitSet r4 = (java.util.BitSet) r4
            long[] r4 = com.google.android.gms.internal.measurement.zzka.zza((java.util.BitSet) r4)
            r5.zzaul = r4
            com.google.android.gms.internal.measurement.zzkr r5 = r7.zzasw
            java.lang.Integer r4 = java.lang.Integer.valueOf(r10)
            r0 = r29
            java.lang.Object r4 = r0.get(r4)
            java.util.BitSet r4 = (java.util.BitSet) r4
            long[] r4 = com.google.android.gms.internal.measurement.zzka.zza((java.util.BitSet) r4)
            r5.zzauk = r4
            com.google.android.gms.internal.measurement.zzei r5 = r36.zzix()
            com.google.android.gms.internal.measurement.zzkr r4 = r7.zzasw
            r5.zzch()
            r5.zzab()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r37)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            int r7 = r4.zzvm()     // Catch:{ IOException -> 0x0b70 }
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x0b70 }
            r11 = 0
            int r12 = r7.length     // Catch:{ IOException -> 0x0b70 }
            com.google.android.gms.internal.measurement.zzabw r11 = com.google.android.gms.internal.measurement.zzabw.zzb(r7, r11, r12)     // Catch:{ IOException -> 0x0b70 }
            r4.zza(r11)     // Catch:{ IOException -> 0x0b70 }
            r11.zzve()     // Catch:{ IOException -> 0x0b70 }
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.String r11 = "app_id"
            r0 = r37
            r4.put(r11, r0)
            java.lang.String r11 = "audience_id"
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            r4.put(r11, r10)
            java.lang.String r10 = "current_results"
            r4.put(r10, r7)
            android.database.sqlite.SQLiteDatabase r7 = r5.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0b85 }
            java.lang.String r10 = "audience_filter_values"
            r11 = 0
            r12 = 5
            long r10 = r7.insertWithOnConflict(r10, r11, r4, r12)     // Catch:{ SQLiteException -> 0x0b85 }
            r12 = -1
            int r4 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r4 != 0) goto L_0x0b6d
            com.google.android.gms.internal.measurement.zzfg r4 = r5.zzge()     // Catch:{ SQLiteException -> 0x0b85 }
            com.google.android.gms.internal.measurement.zzfi r4 = r4.zzim()     // Catch:{ SQLiteException -> 0x0b85 }
            java.lang.String r7 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)     // Catch:{ SQLiteException -> 0x0b85 }
            r4.zzg(r7, r10)     // Catch:{ SQLiteException -> 0x0b85 }
        L_0x0b6d:
            r5 = r6
            goto L_0x0aa3
        L_0x0b70:
            r4 = move-exception
            com.google.android.gms.internal.measurement.zzfg r5 = r5.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzim()
            java.lang.String r7 = "Configuration loss. Failed to serialize filter results. appId"
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)
            r5.zze(r7, r10, r4)
            r5 = r6
            goto L_0x0aa3
        L_0x0b85:
            r4 = move-exception
            com.google.android.gms.internal.measurement.zzfg r5 = r5.zzge()
            com.google.android.gms.internal.measurement.zzfi r5 = r5.zzim()
            java.lang.String r7 = "Error storing filter results. appId"
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzfg.zzbm(r37)
            r5.zze(r7, r10, r4)
            r5 = r6
            goto L_0x0aa3
        L_0x0b9a:
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r8, r5)
            com.google.android.gms.internal.measurement.zzkm[] r4 = (com.google.android.gms.internal.measurement.zzkm[]) r4
            return r4
        L_0x0ba1:
            r7 = r4
            goto L_0x0ad3
        L_0x0ba4:
            r7 = r4
            goto L_0x07ba
        L_0x0ba7:
            r19 = r12
            r20 = r11
            r21 = r5
            r22 = r8
            r24 = r10
            goto L_0x022a
        L_0x0bb3:
            r13 = r5
            goto L_0x019a
        L_0x0bb6:
            r8 = r6
            r9 = r5
            goto L_0x03a4
        L_0x0bba:
            r5 = r21
            r8 = r22
            r10 = r24
            goto L_0x0149
        L_0x0bc2:
            r7 = r4
            goto L_0x029e
        L_0x0bc5:
            r4 = r5
            goto L_0x01ee
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzeb.zza(java.lang.String, com.google.android.gms.internal.measurement.zzkn[], com.google.android.gms.internal.measurement.zzks[]):com.google.android.gms.internal.measurement.zzkm[]");
    }

    /* access modifiers changed from: protected */
    public final boolean zzhf() {
        return false;
    }
}
