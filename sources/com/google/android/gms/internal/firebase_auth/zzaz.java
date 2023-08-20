package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.api.internal.zzdp;

public final class zzaz implements zzdp<zzo> {
    private String zzad;
    private String zzae;
    private String zzaf;
    private String zzbf;
    private String zzbg;
    private String zzbp;
    private boolean zzbr = true;
    private zzbd zzjz = new zzbd();
    private zzbd zzka = new zzbd();

    @Nullable
    public final String getDisplayName() {
        return this.zzbf;
    }

    @Nullable
    public final String getEmail() {
        return this.zzaf;
    }

    @Nullable
    public final String getPassword() {
        return this.zzbg;
    }

    @NonNull
    public final zzaz zzaa(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        this.zzjz.zzba().add(str);
        return this;
    }

    @NonNull
    public final zzaz zzab(@NonNull String str) {
        this.zzae = Preconditions.checkNotEmpty(str);
        return this;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzgv zzam() {
        /*
            r10 = this;
            r4 = 2
            r3 = 1
            r2 = 0
            com.google.android.gms.internal.firebase_auth.zzo r6 = new com.google.android.gms.internal.firebase_auth.zzo
            r6.<init>()
            java.lang.String r0 = r10.zzad
            r6.zzad = r0
            java.lang.String r0 = r10.zzaf
            r6.zzaf = r0
            java.lang.String r0 = r10.zzbg
            r6.zzbg = r0
            java.lang.String r0 = r10.zzbf
            r6.zzbf = r0
            java.lang.String r0 = r10.zzbp
            r6.zzbp = r0
            com.google.android.gms.internal.firebase_auth.zzbd r0 = r10.zzjz
            java.util.List r0 = r0.zzba()
            com.google.android.gms.internal.firebase_auth.zzbd r1 = r10.zzjz
            java.util.List r1 = r1.zzba()
            int r1 = r1.size()
            java.lang.String[] r1 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r6.zzbs = r0
            com.google.android.gms.internal.firebase_auth.zzbd r0 = r10.zzka
            java.util.List r7 = r0.zzba()
            int r0 = r7.size()
            int[] r8 = new int[r0]
            r1 = r2
        L_0x0043:
            int r0 = r7.size()
            if (r1 >= r0) goto L_0x0093
            java.lang.Object r0 = r7.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r5 = -1
            int r9 = r0.hashCode()
            switch(r9) {
                case -333046776: goto L_0x006d;
                case 66081660: goto L_0x0063;
                case 1939891618: goto L_0x0081;
                case 1999612571: goto L_0x0077;
                default: goto L_0x0057;
            }
        L_0x0057:
            r0 = r5
        L_0x0058:
            switch(r0) {
                case 0: goto L_0x008b;
                case 1: goto L_0x008d;
                case 2: goto L_0x008f;
                case 3: goto L_0x0091;
                default: goto L_0x005b;
            }
        L_0x005b:
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x005d:
            r8[r1] = r0
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0043
        L_0x0063:
            java.lang.String r9 = "EMAIL"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0057
            r0 = r2
            goto L_0x0058
        L_0x006d:
            java.lang.String r9 = "DISPLAY_NAME"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0057
            r0 = r3
            goto L_0x0058
        L_0x0077:
            java.lang.String r9 = "PASSWORD"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0057
            r0 = r4
            goto L_0x0058
        L_0x0081:
            java.lang.String r9 = "PHOTO_URL"
            boolean r0 = r0.equals(r9)
            if (r0 == 0) goto L_0x0057
            r0 = 3
            goto L_0x0058
        L_0x008b:
            r0 = r3
            goto L_0x005d
        L_0x008d:
            r0 = r4
            goto L_0x005d
        L_0x008f:
            r0 = 5
            goto L_0x005d
        L_0x0091:
            r0 = 4
            goto L_0x005d
        L_0x0093:
            r6.zzbq = r8
            boolean r0 = r10.zzbr
            r6.zzbr = r0
            java.lang.String r0 = r10.zzae
            r6.zzae = r0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzaz.zzam():com.google.android.gms.internal.firebase_auth.zzgv");
    }

    @Nullable
    public final String zzr() {
        return this.zzbp;
    }

    public final boolean zzu(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzka.zzba().contains(str);
    }

    @NonNull
    public final zzaz zzv(@NonNull String str) {
        this.zzad = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzaz zzw(@Nullable String str) {
        if (str == null) {
            this.zzka.zzba().add("EMAIL");
        } else {
            this.zzaf = str;
        }
        return this;
    }

    @NonNull
    public final zzaz zzx(@Nullable String str) {
        if (str == null) {
            this.zzka.zzba().add("PASSWORD");
        } else {
            this.zzbg = str;
        }
        return this;
    }

    @NonNull
    public final zzaz zzy(@Nullable String str) {
        if (str == null) {
            this.zzka.zzba().add("DISPLAY_NAME");
        } else {
            this.zzbf = str;
        }
        return this;
    }

    @NonNull
    public final zzaz zzz(@Nullable String str) {
        if (str == null) {
            this.zzka.zzba().add("PHOTO_URL");
        } else {
            this.zzbp = str;
        }
        return this;
    }
}
