package com.google.android.gms.internal.firebase_database;

public class zzid implements Comparable<zzid> {
    private static final zzid zzqy = new zzid("[MIN_KEY]");
    private static final zzid zzqz = new zzid("[MAX_KEY]");
    private static final zzid zzra = new zzid(".priority");
    private static final zzid zzrb = new zzid(".info");
    /* access modifiers changed from: private */
    public final String zzqx;

    private static class zza extends zzid {
        private final int zzrc;

        zza(String str, int i) {
            super(str);
            this.zzrc = i;
        }

        /* access modifiers changed from: protected */
        public final int intValue() {
            return this.zzrc;
        }

        public final String toString() {
            String zzj = this.zzqx;
            return new StringBuilder(String.valueOf(zzj).length() + 20).append("IntegerChildName(\"").append(zzj).append("\")").toString();
        }

        /* access modifiers changed from: protected */
        public final boolean zzfi() {
            return true;
        }
    }

    private zzid(String str) {
        this.zzqx = str;
    }

    public static zzid zzfc() {
        return zzqy;
    }

    public static zzid zzfd() {
        return zzqz;
    }

    public static zzid zzfe() {
        return zzra;
    }

    public static zzid zzff() {
        return zzrb;
    }

    public static zzid zzt(String str) {
        Integer zzaa = zzkq.zzaa(str);
        return zzaa != null ? new zza(str, zzaa.intValue()) : str.equals(".priority") ? zzra : new zzid(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzid)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.zzqx.equals(((zzid) obj).zzqx);
    }

    public int hashCode() {
        return this.zzqx.hashCode();
    }

    /* access modifiers changed from: protected */
    public int intValue() {
        return 0;
    }

    public String toString() {
        String str = this.zzqx;
        return new StringBuilder(String.valueOf(str).length() + 12).append("ChildKey(\"").append(str).append("\")").toString();
    }

    public final String zzfg() {
        return this.zzqx;
    }

    public final boolean zzfh() {
        return this == zzra;
    }

    /* access modifiers changed from: protected */
    public boolean zzfi() {
        return false;
    }

    /* renamed from: zzi */
    public final int compareTo(zzid zzid) {
        if (this == zzid) {
            return 0;
        }
        if (this == zzqy || zzid == zzqz) {
            return -1;
        }
        if (zzid == zzqy || this == zzqz) {
            return 1;
        }
        if (zzfi()) {
            if (!zzid.zzfi()) {
                return -1;
            }
            int zza2 = zzkq.zza(intValue(), zzid.intValue());
            return zza2 == 0 ? zzkq.zza(this.zzqx.length(), zzid.zzqx.length()) : zza2;
        } else if (zzid.zzfi()) {
            return 1;
        } else {
            return this.zzqx.compareTo(zzid.zzqx);
        }
    }
}
