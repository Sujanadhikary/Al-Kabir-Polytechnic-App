package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.List;
import java.util.Map;

interface zzew {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzex<T> zzex, zzco zzco) throws IOException;

    <T> void zza(List<T> list, zzex<T> zzex, zzco zzco) throws IOException;

    <K, V> void zza(Map<K, V> map, zzea<K, V> zzea, zzco zzco) throws IOException;

    @Deprecated
    <T> T zzb(zzex<T> zzex, zzco zzco) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzex<T> zzex, zzco zzco) throws IOException;

    void zzc(List<Double> list) throws IOException;

    long zzca() throws IOException;

    long zzcb() throws IOException;

    int zzcc() throws IOException;

    long zzcd() throws IOException;

    int zzce() throws IOException;

    boolean zzcf() throws IOException;

    String zzcg() throws IOException;

    zzbu zzch() throws IOException;

    int zzci() throws IOException;

    int zzcj() throws IOException;

    int zzck() throws IOException;

    long zzcl() throws IOException;

    int zzcm() throws IOException;

    long zzcn() throws IOException;

    int zzcx() throws IOException;

    boolean zzcy() throws IOException;

    void zzd(List<Float> list) throws IOException;

    void zze(List<Long> list) throws IOException;

    void zzf(List<Long> list) throws IOException;

    void zzg(List<Integer> list) throws IOException;

    void zzh(List<Long> list) throws IOException;

    void zzi(List<Integer> list) throws IOException;

    void zzj(List<Boolean> list) throws IOException;

    void zzk(List<String> list) throws IOException;

    void zzl(List<zzbu> list) throws IOException;

    void zzm(List<Integer> list) throws IOException;

    void zzn(List<Integer> list) throws IOException;

    void zzo(List<Integer> list) throws IOException;

    void zzp(List<Long> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Long> list) throws IOException;
}
