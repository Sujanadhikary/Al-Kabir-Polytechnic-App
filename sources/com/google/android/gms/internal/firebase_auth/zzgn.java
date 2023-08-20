package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

public final class zzgn {
    private final ByteBuffer zzne;
    private zzci zzyl;
    private int zzym;

    private zzgn(ByteBuffer byteBuffer) {
        this.zzne = byteBuffer;
        this.zzne.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzgn(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    private static int zza(CharSequence charSequence) {
        int i;
        int i2 = 0;
        int length = charSequence.length();
        int i3 = 0;
        while (i3 < length && charSequence.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                i = i4;
                break;
            }
            char charAt = charSequence.charAt(i3);
            if (charAt < 2048) {
                i4 += (127 - charAt) >>> 31;
                i3++;
            } else {
                int length2 = charSequence.length();
                while (i3 < length2) {
                    char charAt2 = charSequence.charAt(i3);
                    if (charAt2 < 2048) {
                        i2 += (127 - charAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i3) < 65536) {
                                throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3).toString());
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i = i4 + i2;
            }
        }
        if (i >= length) {
            return i;
        }
        throw new IllegalArgumentException(new StringBuilder(54).append("UTF-8 length does not fit in int: ").append(((long) i) + 4294967296L).toString());
    }

    public static int zzaa(int i) {
        if (i >= 0) {
            return zzah(i);
        }
        return 10;
    }

    public static int zzah(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (-268435456 & i) == 0 ? 4 : 5;
    }

    public static int zzam(String str) {
        int zza = zza(str);
        return zza + zzah(zza);
    }

    private final void zzaz(int i) throws IOException {
        byte b = (byte) i;
        if (!this.zzne.hasRemaining()) {
            throw new zzgo(this.zzne.position(), this.zzne.limit());
        }
        this.zzne.put(b);
    }

    public static int zzb(int i, zzgv zzgv) {
        int zzz = zzz(i);
        int zzdn = zzgv.zzdn();
        return zzz + zzdn + zzah(zzdn);
    }

    public static int zzb(int i, String str) {
        return zzz(i) + zzam(str);
    }

    public static int zzb(int i, byte[] bArr) {
        return zzz(i) + zzah(bArr.length) + bArr.length;
    }

    private final void zzb(int i, int i2) throws IOException {
        zzba((i << 3) | i2);
    }

    public static int zzd(int i, long j) {
        return ((-128 & j) == 0 ? 1 : (-16384 & j) == 0 ? 2 : (-2097152 & j) == 0 ? 3 : (-268435456 & j) == 0 ? 4 : (-34359738368L & j) == 0 ? 5 : (-4398046511104L & j) == 0 ? 6 : (-562949953421312L & j) == 0 ? 7 : (-72057594037927936L & j) == 0 ? 8 : (Long.MIN_VALUE & j) == 0 ? 9 : 10) + zzz(i);
    }

    private static void zzd(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        int i3 = 0;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        } else if (byteBuffer.hasArray()) {
            try {
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                int remaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i4 = arrayOffset + remaining;
                while (i3 < length && i3 + arrayOffset < i4) {
                    char charAt = charSequence.charAt(i3);
                    if (charAt >= 128) {
                        break;
                    }
                    array[arrayOffset + i3] = (byte) charAt;
                    i3++;
                }
                if (i3 == length) {
                    i = arrayOffset + length;
                } else {
                    int i5 = arrayOffset + i3;
                    while (i3 < length) {
                        char charAt2 = charSequence.charAt(i3);
                        if (charAt2 < 128 && i5 < i4) {
                            i2 = i5 + 1;
                            array[i5] = (byte) charAt2;
                        } else if (charAt2 < 2048 && i5 <= i4 - 2) {
                            int i6 = i5 + 1;
                            array[i5] = (byte) ((charAt2 >>> 6) | 960);
                            i2 = i6 + 1;
                            array[i6] = (byte) ((charAt2 & '?') | 128);
                        } else if ((charAt2 < 55296 || 57343 < charAt2) && i5 <= i4 - 3) {
                            int i7 = i5 + 1;
                            array[i5] = (byte) ((charAt2 >>> 12) | 480);
                            int i8 = i7 + 1;
                            array[i7] = (byte) (((charAt2 >>> 6) & 63) | 128);
                            i2 = i8 + 1;
                            array[i8] = (byte) ((charAt2 & '?') | 128);
                        } else if (i5 <= i4 - 4) {
                            if (i3 + 1 != charSequence.length()) {
                                i3++;
                                char charAt3 = charSequence.charAt(i3);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    int i9 = i5 + 1;
                                    array[i5] = (byte) ((codePoint >>> 18) | 240);
                                    int i10 = i9 + 1;
                                    array[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                                    int i11 = i10 + 1;
                                    array[i10] = (byte) (((codePoint >>> 6) & 63) | 128);
                                    i2 = i11 + 1;
                                    array[i11] = (byte) ((codePoint & 63) | 128);
                                }
                            }
                            throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3 - 1).toString());
                        } else {
                            throw new ArrayIndexOutOfBoundsException(new StringBuilder(37).append("Failed writing ").append(charAt2).append(" at index ").append(i5).toString());
                        }
                        i3++;
                        i5 = i2;
                    }
                    i = i5;
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        } else {
            int length2 = charSequence.length();
            while (i3 < length2) {
                char charAt4 = charSequence.charAt(i3);
                if (charAt4 < 128) {
                    byteBuffer.put((byte) charAt4);
                } else if (charAt4 < 2048) {
                    byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else if (charAt4 < 55296 || 57343 < charAt4) {
                    byteBuffer.put((byte) ((charAt4 >>> 12) | 480));
                    byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                    byteBuffer.put((byte) ((charAt4 & '?') | 128));
                } else {
                    if (i3 + 1 != charSequence.length()) {
                        i3++;
                        char charAt5 = charSequence.charAt(i3);
                        if (Character.isSurrogatePair(charAt4, charAt5)) {
                            int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                            byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                            byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                            byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                            byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                        }
                    }
                    throw new IllegalArgumentException(new StringBuilder(39).append("Unpaired surrogate at index ").append(i3 - 1).toString());
                }
                i3++;
            }
        }
    }

    public static zzgn zzf(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    public static int zzg(int i, int i2) {
        return zzz(i) + zzaa(i2);
    }

    public static zzgn zzj(byte[] bArr, int i, int i2) {
        return new zzgn(bArr, 0, i2);
    }

    private final void zzm(long j) throws IOException {
        while ((-128 & j) != 0) {
            zzaz((((int) j) & 127) | 128);
            j >>>= 7;
        }
        zzaz((int) j);
    }

    public static int zzz(int i) {
        return zzah(i << 3);
    }

    public final void zza(int i, zzgv zzgv) throws IOException {
        zzb(i, 2);
        if (zzgv.zzyw < 0) {
            zzgv.zzdn();
        }
        zzba(zzgv.zzyw);
        zzgv.zza(this);
    }

    public final void zza(int i, String str) throws IOException {
        zzb(i, 2);
        try {
            int zzah = zzah(str.length());
            if (zzah == zzah(str.length() * 3)) {
                int position = this.zzne.position();
                if (this.zzne.remaining() < zzah) {
                    throw new zzgo(zzah + position, this.zzne.limit());
                }
                this.zzne.position(position + zzah);
                zzd((CharSequence) str, this.zzne);
                int position2 = this.zzne.position();
                this.zzne.position(position);
                zzba((position2 - position) - zzah);
                this.zzne.position(position2);
                return;
            }
            zzba(zza(str));
            zzd((CharSequence) str, this.zzne);
        } catch (BufferOverflowException e) {
            zzgo zzgo = new zzgo(this.zzne.position(), this.zzne.limit());
            zzgo.initCause(e);
            throw zzgo;
        }
    }

    public final void zza(int i, byte[] bArr) throws IOException {
        zzb(i, 2);
        zzba(bArr.length);
        zzg(bArr);
    }

    public final void zzb(int i, boolean z) throws IOException {
        int i2 = 0;
        zzb(i, 0);
        if (z) {
            i2 = 1;
        }
        byte b = (byte) i2;
        if (!this.zzne.hasRemaining()) {
            throw new zzgo(this.zzne.position(), this.zzne.limit());
        }
        this.zzne.put(b);
    }

    public final void zzba(int i) throws IOException {
        while ((i & -128) != 0) {
            zzaz((i & 127) | 128);
            i >>>= 7;
        }
        zzaz(i);
    }

    public final void zzc(int i, int i2) throws IOException {
        zzb(i, 0);
        if (i2 >= 0) {
            zzba(i2);
        } else {
            zzm((long) i2);
        }
    }

    public final void zze(int i, zzeh zzeh) throws IOException {
        if (this.zzyl == null) {
            this.zzyl = zzci.zza(this.zzne);
            this.zzym = this.zzne.position();
        } else if (this.zzym != this.zzne.position()) {
            this.zzyl.write(this.zzne.array(), this.zzym, this.zzne.position() - this.zzym);
            this.zzym = this.zzne.position();
        }
        zzci zzci = this.zzyl;
        zzci.zza(13, zzeh);
        zzci.flush();
        this.zzym = this.zzne.position();
    }

    public final void zzg(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.zzne.remaining() >= length) {
            this.zzne.put(bArr, 0, length);
            return;
        }
        throw new zzgo(this.zzne.position(), this.zzne.limit());
    }

    public final void zzhe() {
        if (this.zzne.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", new Object[]{Integer.valueOf(this.zzne.remaining())}));
        }
    }

    public final void zzi(int i, long j) throws IOException {
        zzb(i, 0);
        zzm(j);
    }
}
