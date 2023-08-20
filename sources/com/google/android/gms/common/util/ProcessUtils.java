package com.google.android.gms.common.util;

import android.os.Binder;
import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;
import javax.annotation.Nullable;

public class ProcessUtils {
    private static String zzaai = null;
    private static int zzaaj = 0;

    public static class SystemGroupsNotAvailableException extends Exception {
        SystemGroupsNotAvailableException(String str) {
            super(str);
        }

        SystemGroupsNotAvailableException(String str, Throwable th) {
            super(str, th);
        }
    }

    private ProcessUtils() {
    }

    @Nullable
    public static String getCallingProcessName() {
        int callingPid = Binder.getCallingPid();
        return callingPid == zzde() ? getMyProcessName() : zzl(callingPid);
    }

    @Nullable
    public static String getMyProcessName() {
        if (zzaai == null) {
            zzaai = zzl(zzde());
        }
        return zzaai;
    }

    public static boolean hasSystemGroups() throws SystemGroupsNotAvailableException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = zzm(new StringBuilder(24).append("/proc/").append(zzde()).append("/status").toString());
            boolean zzk = zzk(bufferedReader);
            IOUtils.closeQuietly((Closeable) bufferedReader);
            return zzk;
        } catch (IOException e) {
            throw new SystemGroupsNotAvailableException("Unable to access /proc/pid/status.", e);
        } catch (Throwable th) {
            IOUtils.closeQuietly((Closeable) bufferedReader);
            throw th;
        }
    }

    private static int zzde() {
        if (zzaaj == 0) {
            zzaaj = Process.myPid();
        }
        return zzaaj;
    }

    private static boolean zzk(BufferedReader bufferedReader) throws IOException, SystemGroupsNotAvailableException {
        String readLine = bufferedReader.readLine();
        while (readLine != null) {
            String trim = readLine.trim();
            if (trim.startsWith("Groups:")) {
                for (String parseLong : trim.substring(7).trim().split("\\s", -1)) {
                    try {
                        long parseLong2 = Long.parseLong(parseLong);
                        if (parseLong2 >= 1000 && parseLong2 < 2000) {
                            return true;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
                return false;
            }
            readLine = bufferedReader.readLine();
        }
        throw new SystemGroupsNotAvailableException("Missing Groups entry from proc/pid/status.");
    }

    @Nullable
    private static String zzl(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        String str = null;
        if (i > 0) {
            try {
                bufferedReader = zzm(new StringBuilder(25).append("/proc/").append(i).append("/cmdline").toString());
                try {
                    str = bufferedReader.readLine().trim();
                    IOUtils.closeQuietly((Closeable) bufferedReader);
                } catch (IOException e) {
                    IOUtils.closeQuietly((Closeable) bufferedReader);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    IOUtils.closeQuietly((Closeable) bufferedReader);
                    throw th;
                }
            } catch (IOException e2) {
                bufferedReader = null;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                bufferedReader = null;
                th = th4;
                IOUtils.closeQuietly((Closeable) bufferedReader);
                throw th;
            }
        }
        return str;
    }

    private static BufferedReader zzm(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
