package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

public final class zzgy {
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    private static final int zzyx = 11;
    private static final int zzyy = 12;
    private static final int zzyz = 16;
    private static final int zzza = 26;
    public static final int[] zzzb = new int[0];
    private static final long[] zzzc = new long[0];
    private static final float[] zzzd = new float[0];
    private static final double[] zzze = new double[0];
    private static final boolean[] zzzf = new boolean[0];
    private static final byte[][] zzzg = new byte[0][];
    public static final byte[] zzzh = new byte[0];

    public static final int zzb(zzgm zzgm, int i) throws IOException {
        int i2 = 1;
        int position = zzgm.getPosition();
        zzgm.zzm(i);
        while (zzgm.zzbz() == i) {
            zzgm.zzm(i);
            i2++;
        }
        zzgm.zzs(position, i);
        return i2;
    }
}
