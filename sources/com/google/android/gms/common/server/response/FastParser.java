package com.google.android.gms.common.server.response;

import android.support.p000v4.view.MotionEventCompat;
import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

public class FastParser<T extends FastJsonResponse> {
    private static final char[] zzwv = {'u', 'l', 'l'};
    private static final char[] zzww = {'r', 'u', 'e'};
    private static final char[] zzwx = {'r', 'u', 'e', '\"'};
    private static final char[] zzwy = {'a', 'l', 's', 'e'};
    private static final char[] zzwz = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zzxa = {10};
    private static final zza<Integer> zzxc = new zza();
    private static final zza<Long> zzxd = new zzb();
    private static final zza<Float> zzxe = new zzc();
    private static final zza<Double> zzxf = new zzd();
    private static final zza<Boolean> zzxg = new zze();
    private static final zza<String> zzxh = new zzf();
    private static final zza<BigInteger> zzxi = new zzg();
    private static final zza<BigDecimal> zzxj = new zzh();
    private final char[] zzwq = new char[1];
    private final char[] zzwr = new char[32];
    private final char[] zzws = new char[1024];
    private final StringBuilder zzwt = new StringBuilder(32);
    private final StringBuilder zzwu = new StringBuilder(1024);
    private final Stack<Integer> zzxb = new Stack<>();

    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    private interface zza<O> {
        O zzh(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    private final int zza(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zzj = zzj(bufferedReader);
        if (zzj == 0) {
            throw new ParseException("Unexpected EOF");
        } else if (zzj == ',') {
            throw new ParseException("Missing value");
        } else if (zzj == 'n') {
            zzb(bufferedReader, zzwv);
            return 0;
        } else {
            bufferedReader.mark(1024);
            if (zzj == '\"') {
                boolean z = false;
                int i2 = 0;
                while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                    char c = cArr[i2];
                    if (Character.isISOControl(c)) {
                        throw new ParseException("Unexpected control character while reading string");
                    } else if (c != '\"' || z) {
                        z = c == '\\' ? !z : false;
                        i2++;
                    } else {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i2 + 1));
                        return i2;
                    }
                }
                i = i2;
            } else {
                cArr[0] = zzj;
                i = 1;
                while (i < cArr.length && bufferedReader.read(cArr, i, 1) != -1) {
                    if (cArr[i] == '}' || cArr[i] == ',' || Character.isWhitespace(cArr[i]) || cArr[i] == ']') {
                        bufferedReader.reset();
                        bufferedReader.skip((long) (i - 1));
                        cArr[i] = 0;
                        return i;
                    }
                    i++;
                }
            }
            if (i == cArr.length) {
                throw new ParseException("Absurdly long value");
            }
            throw new ParseException("Unexpected EOF");
        }
    }

    private final String zza(BufferedReader bufferedReader) throws ParseException, IOException {
        String str = null;
        this.zzxb.push(2);
        char zzj = zzj(bufferedReader);
        switch (zzj) {
            case MotionEventCompat.AXIS_GENERIC_3:
                this.zzxb.push(3);
                str = zzb(bufferedReader, this.zzwr, this.zzwt, (char[]) null);
                zzk(3);
                if (zzj(bufferedReader) != ':') {
                    throw new ParseException("Expected key/value separator");
                }
                break;
            case ']':
                zzk(2);
                zzk(1);
                zzk(5);
                break;
            case '}':
                zzk(2);
                break;
            default:
                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
        }
        return str;
    }

    private final String zza(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        switch (zzj(bufferedReader)) {
            case MotionEventCompat.AXIS_GENERIC_3:
                return zzb(bufferedReader, cArr, sb, cArr2);
            case 'n':
                zzb(bufferedReader, zzwv);
                return null;
            default:
                throw new ParseException("Expected string");
        }
    }

    private final <T extends FastJsonResponse> ArrayList<T> zza(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = new ArrayList<>();
        char zzj = zzj(bufferedReader);
        switch (zzj) {
            case ']':
                zzk(5);
                return arrayList;
            case 'n':
                zzb(bufferedReader, zzwv);
                zzk(5);
                return null;
            case '{':
                this.zzxb.push(1);
                while (true) {
                    try {
                        FastJsonResponse newConcreteTypeInstance = field.newConcreteTypeInstance();
                        if (!zza(bufferedReader, newConcreteTypeInstance)) {
                            return arrayList;
                        }
                        arrayList.add(newConcreteTypeInstance);
                        char zzj2 = zzj(bufferedReader);
                        switch (zzj2) {
                            case MotionEventCompat.AXIS_GENERIC_13:
                                if (zzj(bufferedReader) != '{') {
                                    throw new ParseException("Expected start of next object in array");
                                }
                                this.zzxb.push(1);
                            case ']':
                                zzk(5);
                                return arrayList;
                            default:
                                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj2).toString());
                        }
                    } catch (InstantiationException e) {
                        throw new ParseException("Error instantiating inner object", e);
                    } catch (IllegalAccessException e2) {
                        throw new ParseException("Error instantiating inner object", e2);
                    }
                }
            default:
                throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
        }
    }

    private final <O> ArrayList<O> zza(BufferedReader bufferedReader, zza<O> zza2) throws ParseException, IOException {
        char zzj = zzj(bufferedReader);
        if (zzj != 'n') {
            if (zzj == '[') {
                this.zzxb.push(5);
                ArrayList<O> arrayList = new ArrayList<>();
                while (true) {
                    bufferedReader.mark(1024);
                    switch (zzj(bufferedReader)) {
                        case 0:
                            throw new ParseException("Unexpected EOF");
                        case MotionEventCompat.AXIS_GENERIC_13:
                            break;
                        case ']':
                            zzk(5);
                            return arrayList;
                        default:
                            bufferedReader.reset();
                            arrayList.add(zza2.zzh(this, bufferedReader));
                            break;
                    }
                }
            } else {
                throw new ParseException("Expected start of array");
            }
        } else {
            zzb(bufferedReader, zzwv);
            return null;
        }
    }

    /* JADX WARNING: CFG modification limit reached, blocks count: 231 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.io.BufferedReader r12, com.google.android.gms.common.server.response.FastJsonResponse r13) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r11 = this;
            r10 = 4
            r3 = 0
            r9 = 110(0x6e, float:1.54E-43)
            r2 = 0
            r4 = 1
            java.util.Map r5 = r13.getFieldMappings()
            java.lang.String r0 = r11.zza(r12)
            if (r0 != 0) goto L_0x0016
            r11.zzk(r4)
            r0 = r3
        L_0x0014:
            return r0
        L_0x0015:
            r0 = r2
        L_0x0016:
            if (r0 == 0) goto L_0x02bf
            java.lang.Object r0 = r5.get(r0)
            com.google.android.gms.common.server.response.FastJsonResponse$Field r0 = (com.google.android.gms.common.server.response.FastJsonResponse.Field) r0
            if (r0 != 0) goto L_0x0025
            java.lang.String r0 = r11.zzb(r12)
            goto L_0x0016
        L_0x0025:
            java.util.Stack<java.lang.Integer> r1 = r11.zzxb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r1.push(r6)
            int r1 = r0.getTypeIn()
            switch(r1) {
                case 0: goto L_0x0054;
                case 1: goto L_0x0094;
                case 2: goto L_0x00ac;
                case 3: goto L_0x00c4;
                case 4: goto L_0x00dc;
                case 5: goto L_0x00f6;
                case 6: goto L_0x0110;
                case 7: goto L_0x012a;
                case 8: goto L_0x0144;
                case 9: goto L_0x0157;
                case 10: goto L_0x016a;
                case 11: goto L_0x0231;
                default: goto L_0x0035;
            }
        L_0x0035:
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            int r0 = r0.getTypeIn()
            r2 = 30
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Invalid field type "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x0054:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x008c
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.Integer> r1 = zzxc
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setIntegers(r0, (java.util.ArrayList<java.lang.Integer>) r1)
        L_0x0063:
            r11.zzk(r10)
            r0 = 2
            r11.zzk(r0)
            char r0 = r11.zzj(r12)
            switch(r0) {
                case 44: goto L_0x02b9;
                case 125: goto L_0x0015;
                default: goto L_0x0071;
            }
        L_0x0071:
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            r2 = 55
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Expected end of object or field separator, but found: "
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.StringBuilder r0 = r2.append(r0)
            java.lang.String r0 = r0.toString()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x008c:
            int r1 = r11.zzd(r12)
            r13.setInteger(r0, (int) r1)
            goto L_0x0063
        L_0x0094:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x00a4
            com.google.android.gms.common.server.response.FastParser$zza<java.math.BigInteger> r1 = zzxi
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setBigIntegers(r0, (java.util.ArrayList<java.math.BigInteger>) r1)
            goto L_0x0063
        L_0x00a4:
            java.math.BigInteger r1 = r11.zzf(r12)
            r13.setBigInteger(r0, (java.math.BigInteger) r1)
            goto L_0x0063
        L_0x00ac:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x00bc
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.Long> r1 = zzxd
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setLongs(r0, (java.util.ArrayList<java.lang.Long>) r1)
            goto L_0x0063
        L_0x00bc:
            long r6 = r11.zze(r12)
            r13.setLong(r0, (long) r6)
            goto L_0x0063
        L_0x00c4:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x00d4
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.Float> r1 = zzxe
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setFloats(r0, (java.util.ArrayList<java.lang.Float>) r1)
            goto L_0x0063
        L_0x00d4:
            float r1 = r11.zzg(r12)
            r13.setFloat(r0, (float) r1)
            goto L_0x0063
        L_0x00dc:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x00ed
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.Double> r1 = zzxf
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setDoubles(r0, (java.util.ArrayList<java.lang.Double>) r1)
            goto L_0x0063
        L_0x00ed:
            double r6 = r11.zzh(r12)
            r13.setDouble(r0, (double) r6)
            goto L_0x0063
        L_0x00f6:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x0107
            com.google.android.gms.common.server.response.FastParser$zza<java.math.BigDecimal> r1 = zzxj
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setBigDecimals(r0, (java.util.ArrayList<java.math.BigDecimal>) r1)
            goto L_0x0063
        L_0x0107:
            java.math.BigDecimal r1 = r11.zzi(r12)
            r13.setBigDecimal(r0, (java.math.BigDecimal) r1)
            goto L_0x0063
        L_0x0110:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x0121
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.Boolean> r1 = zzxg
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setBooleans(r0, (java.util.ArrayList<java.lang.Boolean>) r1)
            goto L_0x0063
        L_0x0121:
            boolean r1 = r11.zza((java.io.BufferedReader) r12, (boolean) r3)
            r13.setBoolean(r0, (boolean) r1)
            goto L_0x0063
        L_0x012a:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x013b
            com.google.android.gms.common.server.response.FastParser$zza<java.lang.String> r1 = zzxh
            java.util.ArrayList r1 = r11.zza((java.io.BufferedReader) r12, r1)
            r13.setStrings(r0, (java.util.ArrayList<java.lang.String>) r1)
            goto L_0x0063
        L_0x013b:
            java.lang.String r1 = r11.zzc(r12)
            r13.setString(r0, (java.lang.String) r1)
            goto L_0x0063
        L_0x0144:
            char[] r1 = r11.zzws
            java.lang.StringBuilder r6 = r11.zzwu
            char[] r7 = zzxa
            java.lang.String r1 = r11.zza(r12, r1, r6, r7)
            byte[] r1 = com.google.android.gms.common.util.Base64Utils.decode(r1)
            r13.setDecodedBytes(r0, (byte[]) r1)
            goto L_0x0063
        L_0x0157:
            char[] r1 = r11.zzws
            java.lang.StringBuilder r6 = r11.zzwu
            char[] r7 = zzxa
            java.lang.String r1 = r11.zza(r12, r1, r6, r7)
            byte[] r1 = com.google.android.gms.common.util.Base64Utils.decodeUrlSafe(r1)
            r13.setDecodedBytes(r0, (byte[]) r1)
            goto L_0x0063
        L_0x016a:
            char r1 = r11.zzj(r12)
            if (r1 != r9) goto L_0x017b
            char[] r1 = zzwv
            r11.zzb((java.io.BufferedReader) r12, (char[]) r1)
            r1 = r2
        L_0x0176:
            r13.setStringMap(r0, (java.util.Map<java.lang.String, java.lang.String>) r1)
            goto L_0x0063
        L_0x017b:
            r6 = 123(0x7b, float:1.72E-43)
            if (r1 == r6) goto L_0x0187
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Expected start of a map object"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0187:
            java.util.Stack<java.lang.Integer> r1 = r11.zzxb
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            r1.push(r6)
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
        L_0x0195:
            char r6 = r11.zzj(r12)
            switch(r6) {
                case 0: goto L_0x019d;
                case 34: goto L_0x01a5;
                case 125: goto L_0x022c;
                default: goto L_0x019c;
            }
        L_0x019c:
            goto L_0x0195
        L_0x019d:
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Unexpected EOF"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x01a5:
            char[] r6 = r11.zzwr
            java.lang.StringBuilder r7 = r11.zzwt
            java.lang.String r6 = zzb(r12, r6, r7, r2)
            char r7 = r11.zzj(r12)
            r8 = 58
            if (r7 == r8) goto L_0x01d1
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r2 = "No map value found for key "
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x01cb
            java.lang.String r0 = r2.concat(r0)
        L_0x01c7:
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x01cb:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x01c7
        L_0x01d1:
            char r7 = r11.zzj(r12)
            r8 = 34
            if (r7 == r8) goto L_0x01f5
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r2 = "Expected String value for key "
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r3 = r0.length()
            if (r3 == 0) goto L_0x01ef
            java.lang.String r0 = r2.concat(r0)
        L_0x01eb:
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x01ef:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
            goto L_0x01eb
        L_0x01f5:
            char[] r7 = r11.zzwr
            java.lang.StringBuilder r8 = r11.zzwt
            java.lang.String r7 = zzb(r12, r7, r8, r2)
            r1.put(r6, r7)
            char r6 = r11.zzj(r12)
            r7 = 44
            if (r6 == r7) goto L_0x0195
            r7 = 125(0x7d, float:1.75E-43)
            if (r6 != r7) goto L_0x0211
            r11.zzk(r4)
            goto L_0x0176
        L_0x0211:
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            r1 = 48
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Unexpected character while parsing string map: "
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.StringBuilder r1 = r1.append(r6)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x022c:
            r11.zzk(r4)
            goto L_0x0176
        L_0x0231:
            boolean r1 = r0.isTypeInArray()
            if (r1 == 0) goto L_0x026e
            char r1 = r11.zzj(r12)
            if (r1 != r9) goto L_0x024b
            char[] r1 = zzwv
            r11.zzb((java.io.BufferedReader) r12, (char[]) r1)
            java.lang.String r1 = r0.getOutputFieldName()
            r13.addConcreteTypeArrayInternal(r0, r1, r2)
            goto L_0x0063
        L_0x024b:
            java.util.Stack<java.lang.Integer> r6 = r11.zzxb
            r7 = 5
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r6.push(r7)
            r6 = 91
            if (r1 == r6) goto L_0x0261
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Expected array start"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0261:
            java.lang.String r1 = r0.getOutputFieldName()
            java.util.ArrayList r6 = r11.zza((java.io.BufferedReader) r12, (com.google.android.gms.common.server.response.FastJsonResponse.Field<?, ?>) r0)
            r13.addConcreteTypeArrayInternal(r0, r1, r6)
            goto L_0x0063
        L_0x026e:
            char r1 = r11.zzj(r12)
            if (r1 != r9) goto L_0x0282
            char[] r1 = zzwv
            r11.zzb((java.io.BufferedReader) r12, (char[]) r1)
            java.lang.String r1 = r0.getOutputFieldName()
            r13.addConcreteTypeInternal(r0, r1, r2)
            goto L_0x0063
        L_0x0282:
            java.util.Stack<java.lang.Integer> r6 = r11.zzxb
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            r6.push(r7)
            r6 = 123(0x7b, float:1.72E-43)
            if (r1 == r6) goto L_0x0297
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Expected start of object"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0297:
            com.google.android.gms.common.server.response.FastJsonResponse r1 = r0.newConcreteTypeInstance()     // Catch:{ InstantiationException -> 0x02a7, IllegalAccessException -> 0x02b0 }
            r11.zza((java.io.BufferedReader) r12, (com.google.android.gms.common.server.response.FastJsonResponse) r1)     // Catch:{ InstantiationException -> 0x02a7, IllegalAccessException -> 0x02b0 }
            java.lang.String r6 = r0.getOutputFieldName()     // Catch:{ InstantiationException -> 0x02a7, IllegalAccessException -> 0x02b0 }
            r13.addConcreteTypeInternal(r0, r6, r1)     // Catch:{ InstantiationException -> 0x02a7, IllegalAccessException -> 0x02b0 }
            goto L_0x0063
        L_0x02a7:
            r0 = move-exception
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r2 = "Error instantiating inner object"
            r1.<init>(r2, r0)
            throw r1
        L_0x02b0:
            r0 = move-exception
            com.google.android.gms.common.server.response.FastParser$ParseException r1 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r2 = "Error instantiating inner object"
            r1.<init>(r2, r0)
            throw r1
        L_0x02b9:
            java.lang.String r0 = r11.zza(r12)
            goto L_0x0016
        L_0x02bf:
            com.google.android.gms.common.server.response.PostProcessor r0 = r13.getPostProcessor()
            if (r0 == 0) goto L_0x02c8
            r0.postProcess(r13)
        L_0x02c8:
            r11.zzk(r4)
            r0 = r4
            goto L_0x0014
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zza(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean");
    }

    /* access modifiers changed from: private */
    public final boolean zza(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char zzj = zzj(bufferedReader);
            switch (zzj) {
                case MotionEventCompat.AXIS_GENERIC_3:
                    if (z) {
                        throw new ParseException("No boolean value found in string");
                    }
                    z = true;
                case 'f':
                    zzb(bufferedReader, z ? zzwz : zzwy);
                    return false;
                case 'n':
                    zzb(bufferedReader, zzwv);
                    return false;
                case 't':
                    zzb(bufferedReader, z ? zzwx : zzww);
                    return true;
                default:
                    throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
            }
        }
    }

    private final String zzb(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        bufferedReader.mark(1024);
        switch (zzj(bufferedReader)) {
            case MotionEventCompat.AXIS_GENERIC_3:
                if (bufferedReader.read(this.zzwq) != -1) {
                    char c = this.zzwq[0];
                    boolean z2 = false;
                    while (true) {
                        if (c == '\"' && !z2) {
                            break;
                        } else {
                            boolean z3 = c == '\\' ? !z2 : false;
                            if (bufferedReader.read(this.zzwq) == -1) {
                                throw new ParseException("Unexpected EOF while parsing string");
                            }
                            char c2 = this.zzwq[0];
                            if (Character.isISOControl(c2)) {
                                throw new ParseException("Unexpected control character while reading string");
                            }
                            char c3 = c2;
                            z2 = z3;
                            c = c3;
                        }
                    }
                } else {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
            case MotionEventCompat.AXIS_GENERIC_13:
                throw new ParseException("Missing value");
            case '[':
                this.zzxb.push(5);
                bufferedReader.mark(32);
                if (zzj(bufferedReader) != ']') {
                    bufferedReader.reset();
                    int i = 1;
                    boolean z4 = false;
                    boolean z5 = false;
                    while (i > 0) {
                        char zzj = zzj(bufferedReader);
                        if (zzj == 0) {
                            throw new ParseException("Unexpected EOF while parsing array");
                        } else if (Character.isISOControl(zzj)) {
                            throw new ParseException("Unexpected control character while reading array");
                        } else {
                            if (zzj != '\"' || z5) {
                                z = z4;
                            } else {
                                z = !z4;
                            }
                            int i2 = (zzj != '[' || z) ? i : i + 1;
                            i = (zzj != ']' || z) ? i2 : i2 - 1;
                            if (zzj != '\\' || !z) {
                                z4 = z;
                                z5 = false;
                            } else {
                                z5 = !z5;
                                z4 = z;
                            }
                        }
                    }
                    zzk(5);
                    break;
                } else {
                    zzk(5);
                    break;
                }
            case '{':
                this.zzxb.push(1);
                bufferedReader.mark(32);
                char zzj2 = zzj(bufferedReader);
                if (zzj2 == '}') {
                    zzk(1);
                    break;
                } else if (zzj2 == '\"') {
                    bufferedReader.reset();
                    zza(bufferedReader);
                    do {
                    } while (zzb(bufferedReader) != null);
                    zzk(1);
                    break;
                } else {
                    throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(zzj2).toString());
                }
            default:
                bufferedReader.reset();
                zza(bufferedReader, this.zzws);
                break;
        }
        char zzj3 = zzj(bufferedReader);
        switch (zzj3) {
            case MotionEventCompat.AXIS_GENERIC_13:
                zzk(2);
                return zza(bufferedReader);
            case '}':
                zzk(2);
                return null;
            default:
                throw new ParseException(new StringBuilder(18).append("Unexpected token ").append(zzj3).toString());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x002a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String zzb(java.io.BufferedReader r9, char[] r10, java.lang.StringBuilder r11, char[] r12) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r4 = 1
            r1 = 0
            r11.setLength(r1)
            int r0 = r10.length
            r9.mark(r0)
            r0 = r1
            r2 = r1
        L_0x000b:
            int r6 = r9.read(r10)
            r3 = -1
            if (r6 == r3) goto L_0x0072
            r5 = r1
        L_0x0013:
            if (r5 >= r6) goto L_0x006a
            char r7 = r10[r5]
            boolean r3 = java.lang.Character.isISOControl(r7)
            if (r3 == 0) goto L_0x0037
            if (r12 == 0) goto L_0x0035
            r3 = r1
        L_0x0020:
            int r8 = r12.length
            if (r3 >= r8) goto L_0x0035
            char r8 = r12[r3]
            if (r8 != r7) goto L_0x0032
            r3 = r4
        L_0x0028:
            if (r3 != 0) goto L_0x0037
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Unexpected control character while reading string"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0032:
            int r3 = r3 + 1
            goto L_0x0020
        L_0x0035:
            r3 = r1
            goto L_0x0028
        L_0x0037:
            r3 = 34
            if (r7 != r3) goto L_0x0059
            if (r2 != 0) goto L_0x0059
            r11.append(r10, r1, r5)
            r9.reset()
            int r1 = r5 + 1
            long r2 = (long) r1
            r9.skip(r2)
            if (r0 == 0) goto L_0x0054
            java.lang.String r0 = r11.toString()
            java.lang.String r0 = com.google.android.gms.common.util.JsonUtils.unescapeString(r0)
        L_0x0053:
            return r0
        L_0x0054:
            java.lang.String r0 = r11.toString()
            goto L_0x0053
        L_0x0059:
            r3 = 92
            if (r7 != r3) goto L_0x0068
            if (r2 != 0) goto L_0x0066
            r0 = r4
        L_0x0060:
            r2 = r0
            r0 = r4
        L_0x0062:
            int r3 = r5 + 1
            r5 = r3
            goto L_0x0013
        L_0x0066:
            r0 = r1
            goto L_0x0060
        L_0x0068:
            r2 = r1
            goto L_0x0062
        L_0x006a:
            r11.append(r10, r1, r6)
            int r3 = r10.length
            r9.mark(r3)
            goto L_0x000b
        L_0x0072:
            com.google.android.gms.common.server.response.FastParser$ParseException r0 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r1 = "Unexpected EOF while parsing string"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zzb(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final void zzb(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (i < cArr.length) {
            int read = bufferedReader.read(this.zzwr, 0, cArr.length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zzwr[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    /* access modifiers changed from: private */
    public final String zzc(BufferedReader bufferedReader) throws ParseException, IOException {
        return zza(bufferedReader, this.zzwr, this.zzwt, (char[]) null);
    }

    /* access modifiers changed from: private */
    public final int zzd(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        boolean z;
        int i2;
        int i3 = 0;
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            if (cArr[0] == '-') {
                i = Integer.MIN_VALUE;
                z = true;
                i2 = 1;
            } else {
                i = -2147483647;
                z = false;
                i2 = 0;
            }
            if (i2 < zza2) {
                int i4 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                int i5 = i4;
                i3 = -digit;
                i2 = i5;
            }
            while (i2 < zza2) {
                int i6 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (i3 < -214748364) {
                    throw new ParseException("Number too large");
                } else {
                    int i7 = i3 * 10;
                    if (i7 < i + digit2) {
                        throw new ParseException("Number too large");
                    }
                    i3 = i7 - digit2;
                    i2 = i6;
                }
            }
            if (!z) {
                return -i3;
            }
            if (i2 > 1) {
                return i3;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final long zze(BufferedReader bufferedReader) throws ParseException, IOException {
        boolean z;
        long j;
        int i;
        long j2 = 0;
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0;
        }
        char[] cArr = this.zzws;
        if (zza2 > 0) {
            if (cArr[0] == '-') {
                j = Long.MIN_VALUE;
                z = true;
                i = 1;
            } else {
                z = false;
                j = -9223372036854775807L;
                i = 0;
            }
            if (i < zza2) {
                int i2 = i + 1;
                int digit = Character.digit(cArr[i], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                int i3 = i2;
                j2 = (long) (-digit);
                i = i3;
            }
            while (i < zza2) {
                int i4 = i + 1;
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                } else if (j2 < -922337203685477580L) {
                    throw new ParseException("Number too large");
                } else {
                    long j3 = j2 * 10;
                    if (j3 < ((long) digit2) + j) {
                        throw new ParseException("Number too large");
                    }
                    j2 = j3 - ((long) digit2);
                    i = i4;
                }
            }
            if (!z) {
                return -j2;
            }
            if (i > 1) {
                return j2;
            }
            throw new ParseException("No digits to parse");
        }
        throw new ParseException("No number to parse");
    }

    /* access modifiers changed from: private */
    public final BigInteger zzf(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final float zzg(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final double zzh(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zzws, 0, zza2));
    }

    /* access modifiers changed from: private */
    public final BigDecimal zzi(BufferedReader bufferedReader) throws ParseException, IOException {
        int zza2 = zza(bufferedReader, this.zzws);
        if (zza2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zzws, 0, zza2));
    }

    private final char zzj(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zzwq) == -1) {
            return 0;
        }
        while (Character.isWhitespace(this.zzwq[0])) {
            if (bufferedReader.read(this.zzwq) == -1) {
                return 0;
            }
        }
        return this.zzwq[0];
    }

    private final void zzk(int i) throws ParseException {
        if (this.zzxb.isEmpty()) {
            throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had empty stack").toString());
        }
        int intValue = this.zzxb.pop().intValue();
        if (intValue != i) {
            throw new ParseException(new StringBuilder(46).append("Expected state ").append(i).append(" but had ").append(intValue).toString());
        }
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            this.zzxb.push(0);
            char zzj = zzj(bufferedReader);
            switch (zzj) {
                case 0:
                    throw new ParseException("No data to parse");
                case '[':
                    this.zzxb.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                    if (fieldMappings.size() == 1) {
                        FastJsonResponse.Field field = (FastJsonResponse.Field) fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(field, field.getOutputFieldName(), zza(bufferedReader, (FastJsonResponse.Field<?, ?>) field));
                        break;
                    } else {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                case '{':
                    this.zzxb.push(1);
                    zza(bufferedReader, (FastJsonResponse) t);
                    break;
                default:
                    throw new ParseException(new StringBuilder(19).append("Unexpected token: ").append(zzj).toString());
            }
            zzk(0);
            try {
                bufferedReader.close();
            } catch (IOException e) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
        } catch (IOException e2) {
            throw new ParseException((Throwable) e2);
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException e3) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }

    public void parse(String str, T t) throws ParseException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            parse((InputStream) byteArrayInputStream, t);
            try {
            } catch (IOException e) {
                Log.w("FastParser", "Failed to close the input stream while parsing.");
            }
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e2) {
                Log.w("FastParser", "Failed to close the input stream while parsing.");
            }
        }
    }
}
