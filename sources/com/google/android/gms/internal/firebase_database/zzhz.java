package com.google.android.gms.internal.firebase_database;

import java.io.PrintWriter;
import java.io.StringWriter;

public final class zzhz {
    private final zzia zzco;
    private final String zzqp;
    private final String zzqq;

    public zzhz(zzia zzia, String str) {
        this(zzia, str, (String) null);
    }

    public zzhz(zzia zzia, String str, String str2) {
        this.zzco = zzia;
        this.zzqp = str;
        this.zzqq = str2;
    }

    private final String zza(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.zzqq == null) {
            return str;
        }
        String str2 = this.zzqq;
        return new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(str).length()).append(str2).append(" - ").append(str).toString();
    }

    private static String zzb(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zze.zza(th, new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public final void info(String str) {
        this.zzco.zzb(zzib.INFO, this.zzqp, zza(str, new Object[0]), System.currentTimeMillis());
    }

    public final void zza(String str, Throwable th) {
        String zza = zza(str, new Object[0]);
        String zzb = zzb(th);
        this.zzco.zzb(zzib.ERROR, this.zzqp, new StringBuilder(String.valueOf(zza).length() + 1 + String.valueOf(zzb).length()).append(zza).append("\n").append(zzb).toString(), System.currentTimeMillis());
    }

    public final void zza(String str, Throwable th, Object... objArr) {
        if (zzfa()) {
            String zza = zza(str, objArr);
            if (th != null) {
                String zzb = zzb(th);
                zza = new StringBuilder(String.valueOf(zza).length() + 1 + String.valueOf(zzb).length()).append(zza).append("\n").append(zzb).toString();
            }
            this.zzco.zzb(zzib.DEBUG, this.zzqp, zza, System.currentTimeMillis());
        }
    }

    public final void zzb(String str, Throwable th) {
        this.zzco.zzb(zzib.WARN, this.zzqp, zza(str, new Object[0]), System.currentTimeMillis());
    }

    public final boolean zzfa() {
        return this.zzco.zzbn().ordinal() <= zzib.DEBUG.ordinal();
    }
}
