package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zze;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class DatabaseError {
    public static final int DATA_STALE = -1;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int NETWORK_ERROR = -24;
    public static final int OPERATION_FAILED = -2;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int PERMISSION_DENIED = -3;
    public static final int UNAVAILABLE = -10;
    public static final int UNKNOWN_ERROR = -999;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int WRITE_CANCELED = -25;
    private static final Map<Integer, String> zzq;
    private static final Map<String, Integer> zzr;
    private final int zzs;
    private final String zzt;
    private final String zzu;

    static {
        HashMap hashMap = new HashMap();
        zzq = hashMap;
        hashMap.put(-1, "The transaction needs to be run again with current data");
        zzq.put(-2, "The server indicated that this operation failed");
        zzq.put(-3, "This client does not have permission to perform this operation");
        zzq.put(-4, "The operation had to be aborted due to a network disconnect");
        zzq.put(-6, "The supplied auth token has expired");
        zzq.put(-7, "The supplied auth token was invalid");
        zzq.put(-8, "The transaction had too many retries");
        zzq.put(-9, "The transaction was overridden by a subsequent set");
        zzq.put(-10, "The service is unavailable");
        zzq.put(-11, "User code called from the Firebase Database runloop threw an exception:\n");
        zzq.put(-24, "The operation could not be performed due to a network error");
        zzq.put(-25, "The write was canceled by the user.");
        zzq.put(Integer.valueOf(UNKNOWN_ERROR), "An unknown error occurred");
        HashMap hashMap2 = new HashMap();
        zzr = hashMap2;
        hashMap2.put("datastale", -1);
        zzr.put("failure", -2);
        zzr.put("permission_denied", -3);
        zzr.put("disconnected", -4);
        zzr.put("expired_token", -6);
        zzr.put("invalid_token", -7);
        zzr.put("maxretries", -8);
        zzr.put("overriddenbyset", -9);
        zzr.put("unavailable", -10);
        zzr.put("network_error", -24);
        zzr.put("write_canceled", -25);
    }

    private DatabaseError(int i, String str) {
        this(-11, str, (String) null);
    }

    private DatabaseError(int i, String str, String str2) {
        this.zzs = i;
        this.zzt = str;
        this.zzu = "";
    }

    public static DatabaseError fromException(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        zze.zza(th, new PrintWriter(stringWriter));
        String valueOf = String.valueOf(zzq.get(-11));
        String valueOf2 = String.valueOf(stringWriter.toString());
        return new DatabaseError(-11, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public static DatabaseError zza(int i) {
        if (zzq.containsKey(-25)) {
            return new DatabaseError(-25, zzq.get(-25), (String) null);
        }
        throw new IllegalArgumentException(new StringBuilder(49).append("Invalid Firebase Database error code: -25").toString());
    }

    public static DatabaseError zza(String str) {
        Integer num = zzr.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(UNKNOWN_ERROR) : num;
        return new DatabaseError(valueOf.intValue(), zzq.get(valueOf), (String) null);
    }

    public static DatabaseError zza(String str, String str2) {
        Integer num = zzr.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(UNKNOWN_ERROR) : num;
        return new DatabaseError(valueOf.intValue(), str2 == null ? zzq.get(valueOf) : str2, (String) null);
    }

    public int getCode() {
        return this.zzs;
    }

    public String getDetails() {
        return this.zzu;
    }

    public String getMessage() {
        return this.zzt;
    }

    public DatabaseException toException() {
        String valueOf = String.valueOf(this.zzt);
        return new DatabaseException(valueOf.length() != 0 ? "Firebase Database error: ".concat(valueOf) : new String("Firebase Database error: "));
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzt);
        return valueOf.length() != 0 ? "DatabaseError: ".concat(valueOf) : new String("DatabaseError: ");
    }
}
