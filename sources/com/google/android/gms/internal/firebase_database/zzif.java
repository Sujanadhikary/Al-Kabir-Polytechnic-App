package com.google.android.gms.internal.firebase_database;

import com.google.firebase.database.collection.ImmutableSortedMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class zzif implements zzja {
    public static Comparator<zzid> zzrd = new zzig();
    private final ImmutableSortedMap<zzid, zzja> zzob;
    private final zzja zzre;
    private String zzrf;

    protected zzif() {
        this.zzrf = null;
        this.zzob = ImmutableSortedMap.Builder.emptyMap(zzrd);
        this.zzre = zzir.zzfv();
    }

    protected zzif(ImmutableSortedMap<zzid, zzja> immutableSortedMap, zzja zzja) {
        this.zzrf = null;
        if (!immutableSortedMap.isEmpty() || zzja.isEmpty()) {
            this.zzre = zzja;
            this.zzob = immutableSortedMap;
            return;
        }
        throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append(" ");
        }
    }

    private final void zzb(StringBuilder sb, int i) {
        if (!this.zzob.isEmpty() || !this.zzre.isEmpty()) {
            sb.append("{\n");
            Iterator<Map.Entry<zzid, zzja>> it = this.zzob.iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                zza(sb, i + 2);
                sb.append(((zzid) next.getKey()).zzfg());
                sb.append("=");
                if (next.getValue() instanceof zzif) {
                    ((zzif) next.getValue()).zzb(sb, i + 2);
                } else {
                    sb.append(((zzja) next.getValue()).toString());
                }
                sb.append("\n");
            }
            if (!this.zzre.isEmpty()) {
                zza(sb, i + 2);
                sb.append(".priority=");
                sb.append(this.zzre.toString());
                sb.append("\n");
            }
            zza(sb, i);
            sb.append("}");
            return;
        }
        sb.append("{ }");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r4 = 1
            r3 = 0
            if (r9 != 0) goto L_0x0006
            r0 = r3
        L_0x0005:
            return r0
        L_0x0006:
            if (r9 != r8) goto L_0x000a
            r0 = r4
            goto L_0x0005
        L_0x000a:
            boolean r0 = r9 instanceof com.google.android.gms.internal.firebase_database.zzif
            if (r0 != 0) goto L_0x0010
            r0 = r3
            goto L_0x0005
        L_0x0010:
            com.google.android.gms.internal.firebase_database.zzif r9 = (com.google.android.gms.internal.firebase_database.zzif) r9
            com.google.android.gms.internal.firebase_database.zzja r0 = r8.zzfl()
            com.google.android.gms.internal.firebase_database.zzja r1 = r9.zzfl()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0022
            r0 = r3
            goto L_0x0005
        L_0x0022:
            com.google.firebase.database.collection.ImmutableSortedMap<com.google.android.gms.internal.firebase_database.zzid, com.google.android.gms.internal.firebase_database.zzja> r0 = r8.zzob
            int r0 = r0.size()
            com.google.firebase.database.collection.ImmutableSortedMap<com.google.android.gms.internal.firebase_database.zzid, com.google.android.gms.internal.firebase_database.zzja> r1 = r9.zzob
            int r1 = r1.size()
            if (r0 == r1) goto L_0x0032
            r0 = r3
            goto L_0x0005
        L_0x0032:
            com.google.firebase.database.collection.ImmutableSortedMap<com.google.android.gms.internal.firebase_database.zzid, com.google.android.gms.internal.firebase_database.zzja> r0 = r8.zzob
            java.util.Iterator r5 = r0.iterator()
            com.google.firebase.database.collection.ImmutableSortedMap<com.google.android.gms.internal.firebase_database.zzid, com.google.android.gms.internal.firebase_database.zzja> r0 = r9.zzob
            java.util.Iterator r6 = r0.iterator()
        L_0x003e:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0078
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0078
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r6.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r0.getKey()
            com.google.android.gms.internal.firebase_database.zzid r2 = (com.google.android.gms.internal.firebase_database.zzid) r2
            java.lang.Object r7 = r1.getKey()
            boolean r2 = r2.equals(r7)
            if (r2 == 0) goto L_0x0076
            java.lang.Object r0 = r0.getValue()
            com.google.android.gms.internal.firebase_database.zzja r0 = (com.google.android.gms.internal.firebase_database.zzja) r0
            java.lang.Object r1 = r1.getValue()
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003e
        L_0x0076:
            r0 = r3
            goto L_0x0005
        L_0x0078:
            boolean r0 = r5.hasNext()
            if (r0 != 0) goto L_0x0084
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x008c
        L_0x0084:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Something went wrong internally."
            r0.<init>(r1)
            throw r0
        L_0x008c:
            r0 = r4
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_database.zzif.equals(java.lang.Object):boolean");
    }

    public int getChildCount() {
        return this.zzob.size();
    }

    public Object getValue() {
        return getValue(false);
    }

    public Object getValue(boolean z) {
        boolean z2;
        Integer zzaa;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<zzid, zzja>> it = this.zzob.iterator();
        boolean z3 = true;
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String zzfg = ((zzid) next.getKey()).zzfg();
            hashMap.put(zzfg, ((zzja) next.getValue()).getValue(z));
            int i3 = i2 + 1;
            if (z3) {
                if ((zzfg.length() > 1 && zzfg.charAt(0) == '0') || (zzaa = zzkq.zzaa(zzfg)) == null || zzaa.intValue() < 0) {
                    z2 = false;
                    z3 = z2;
                    i2 = i3;
                } else if (zzaa.intValue() > i) {
                    i = zzaa.intValue();
                    i2 = i3;
                }
            }
            z2 = z3;
            z3 = z2;
            i2 = i3;
        }
        if (z || !z3 || i >= i2 * 2) {
            if (z && !this.zzre.isEmpty()) {
                hashMap.put(".priority", this.zzre.getValue());
            }
            return hashMap;
        }
        ArrayList arrayList = new ArrayList(i + 1);
        for (int i4 = 0; i4 <= i; i4++) {
            arrayList.add(hashMap.get(new StringBuilder(11).append(i4).toString()));
        }
        return arrayList;
    }

    public int hashCode() {
        int i = 0;
        Iterator<zziz> it = iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            zziz next = it.next();
            i = next.zzd().hashCode() + (((i2 * 31) + next.zzge().hashCode()) * 17);
        }
    }

    public boolean isEmpty() {
        return this.zzob.isEmpty();
    }

    public Iterator<zziz> iterator() {
        return new zzij(this.zzob.iterator());
    }

    public Iterator<zziz> reverseIterator() {
        return new zzij(this.zzob.reverseIterator());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        zzb(sb, 0);
        return sb.toString();
    }

    public String zza(zzjc zzjc) {
        int i = 0;
        if (zzjc != zzjc.V1) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder sb = new StringBuilder();
        if (!this.zzre.isEmpty()) {
            sb.append("priority:");
            sb.append(this.zzre.zza(zzjc.V1));
            sb.append(":");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<zziz> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            zziz next = it.next();
            arrayList.add(next);
            z = z || !next.zzd().zzfl().isEmpty();
        }
        if (z) {
            Collections.sort(arrayList, zzjf.zzgf());
        }
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            zziz zziz = (zziz) obj;
            String zzfj = zziz.zzd().zzfj();
            if (!zzfj.equals("")) {
                sb.append(":");
                sb.append(zziz.zzge().zzfg());
                sb.append(":");
                sb.append(zzfj);
            }
        }
        return sb.toString();
    }

    public final void zza(zzii zzii, boolean z) {
        if (!z || zzfl().isEmpty()) {
            this.zzob.inOrderTraversal(zzii);
        } else {
            this.zzob.inOrderTraversal(new zzih(this, zzii));
        }
    }

    public zzja zzam(zzch zzch) {
        zzid zzbw = zzch.zzbw();
        return zzbw == null ? this : zzm(zzbw).zzam(zzch.zzbx());
    }

    public zzja zze(zzid zzid, zzja zzja) {
        if (zzid.zzfh()) {
            return zzf(zzja);
        }
        ImmutableSortedMap<zzid, zzja> immutableSortedMap = this.zzob;
        if (immutableSortedMap.containsKey(zzid)) {
            immutableSortedMap = immutableSortedMap.remove(zzid);
        }
        if (!zzja.isEmpty()) {
            immutableSortedMap = immutableSortedMap.insert(zzid, zzja);
        }
        return immutableSortedMap.isEmpty() ? zzir.zzfv() : new zzif(immutableSortedMap, this.zzre);
    }

    public zzja zzf(zzja zzja) {
        return this.zzob.isEmpty() ? zzir.zzfv() : new zzif(this.zzob, zzja);
    }

    public String zzfj() {
        if (this.zzrf == null) {
            String zza = zza(zzjc.V1);
            this.zzrf = zza.isEmpty() ? "" : zzkq.zzy(zza);
        }
        return this.zzrf;
    }

    public boolean zzfk() {
        return false;
    }

    public zzja zzfl() {
        return this.zzre;
    }

    public final zzid zzfm() {
        return this.zzob.getMinKey();
    }

    public final zzid zzfn() {
        return this.zzob.getMaxKey();
    }

    /* renamed from: zzg */
    public int compareTo(zzja zzja) {
        if (isEmpty()) {
            return zzja.isEmpty() ? 0 : -1;
        }
        if (zzja.zzfk()) {
            return 1;
        }
        if (zzja.isEmpty()) {
            return 1;
        }
        return zzja == zzja.zzsj ? -1 : 0;
    }

    public boolean zzk(zzid zzid) {
        return !zzm(zzid).isEmpty();
    }

    public zzid zzl(zzid zzid) {
        return this.zzob.getPredecessorKey(zzid);
    }

    public zzja zzl(zzch zzch, zzja zzja) {
        zzid zzbw = zzch.zzbw();
        return zzbw == null ? zzja : zzbw.zzfh() ? zzf(zzja) : zze(zzbw, zzm(zzbw).zzl(zzch.zzbx(), zzja));
    }

    public zzja zzm(zzid zzid) {
        return (!zzid.zzfh() || this.zzre.isEmpty()) ? this.zzob.containsKey(zzid) ? this.zzob.get(zzid) : zzir.zzfv() : this.zzre;
    }
}
