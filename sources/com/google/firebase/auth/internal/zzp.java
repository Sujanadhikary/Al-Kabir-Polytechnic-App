package com.google.firebase.auth.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.view.MotionEventCompat;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import java.util.Arrays;
import java.util.List;

public final class zzp {
    @NonNull
    public static Status zzaf(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return new Status(FirebaseError.ERROR_INTERNAL_ERROR);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && split[1] != null) {
            split[1] = split[1].trim();
        }
        List asList = Arrays.asList(split);
        return asList.size() > 1 ? zzb((String) asList.get(0), (String) asList.get(1)) : zzb((String) asList.get(0), (String) null);
    }

    @NonNull
    private static Status zzb(@NonNull String str, @Nullable String str2) {
        int i;
        char c = 65535;
        switch (str.hashCode()) {
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    c = 26;
                    break;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    c = 3;
                    break;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    c = '%';
                    break;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    c = '\'';
                    break;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    c = 23;
                    break;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    c = 22;
                    break;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    c = 27;
                    break;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    c = ' ';
                    break;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    c = 21;
                    break;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    c = '\"';
                    break;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    c = 6;
                    break;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    c = '&';
                    break;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    c = 0;
                    break;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    c = 28;
                    break;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    c = 19;
                    break;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    c = 16;
                    break;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    c = '(';
                    break;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    c = 8;
                    break;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    c = 15;
                    break;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    c = 7;
                    break;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    c = 25;
                    break;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    c = 29;
                    break;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    c = 9;
                    break;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    c = 13;
                    break;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    c = ')';
                    break;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    c = 17;
                    break;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    c = '#';
                    break;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    c = 1;
                    break;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    c = 24;
                    break;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    c = 20;
                    break;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    c = 2;
                    break;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    c = 10;
                    break;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    c = 14;
                    break;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    c = '$';
                    break;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    c = 31;
                    break;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    c = 12;
                    break;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    c = 5;
                    break;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    c = 4;
                    break;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    c = 30;
                    break;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    c = 18;
                    break;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    c = 11;
                    break;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    c = '!';
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                i = 17016;
                break;
            case 1:
                i = 17002;
                break;
            case 2:
                i = 17000;
                break;
            case 3:
                i = 17004;
                break;
            case 4:
                i = 17005;
                break;
            case 5:
            case 6:
                i = 17008;
                break;
            case 7:
            case 8:
                i = 17011;
                break;
            case 9:
                i = 17007;
                break;
            case 10:
                i = 17009;
                break;
            case 11:
                i = 17010;
                break;
            case 12:
                i = 17025;
                break;
            case 13:
                i = 17017;
                break;
            case 14:
                i = 17020;
                break;
            case 15:
                i = 17026;
                break;
            case 16:
            case 17:
                i = 17006;
                break;
            case 18:
                i = 17028;
                break;
            case 19:
                i = 17014;
                break;
            case 20:
                i = 17010;
                break;
            case 21:
                i = 17021;
                break;
            case MotionEventCompat.AXIS_GAS:
                i = 17030;
                break;
            case 23:
                i = 17029;
                break;
            case MotionEventCompat.AXIS_DISTANCE:
                i = 17031;
                break;
            case 25:
                i = 17032;
                break;
            case MotionEventCompat.AXIS_SCROLL:
                i = 17033;
                break;
            case MotionEventCompat.AXIS_RELATIVE_X:
                i = 17034;
                break;
            case MotionEventCompat.AXIS_RELATIVE_Y:
                i = 17035;
                break;
            case 29:
                i = 17041;
                break;
            case 30:
                i = 17042;
                break;
            case 31:
                i = 17043;
                break;
            case ' ':
                i = 17044;
                break;
            case MotionEventCompat.AXIS_GENERIC_2:
                i = 17045;
                break;
            case MotionEventCompat.AXIS_GENERIC_3:
                i = 17046;
                break;
            case MotionEventCompat.AXIS_GENERIC_4:
                i = 17049;
                break;
            case MotionEventCompat.AXIS_GENERIC_5:
                i = 17051;
                break;
            case MotionEventCompat.AXIS_GENERIC_6:
                i = 17052;
                break;
            case MotionEventCompat.AXIS_GENERIC_7:
                i = 17064;
                break;
            case MotionEventCompat.AXIS_GENERIC_8:
                i = 17061;
                break;
            case MotionEventCompat.AXIS_GENERIC_9:
                i = 17062;
                break;
            case MotionEventCompat.AXIS_GENERIC_10:
                i = 17065;
                break;
            default:
                i = 17499;
                break;
        }
        return i == 17499 ? str2 != null ? new Status(i, new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length()).append(str).append(":").append(str2).toString()) : new Status(i, str) : new Status(i, str2);
    }
}
