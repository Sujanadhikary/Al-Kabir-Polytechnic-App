package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseError;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthActionCodeException;
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;

public final class zzce {
    @VisibleForTesting
    private static final SparseArray<Pair<String, String>> zzhe;

    static {
        SparseArray<Pair<String, String>> sparseArray = new SparseArray<>();
        zzhe = sparseArray;
        sparseArray.put(FirebaseError.ERROR_INVALID_CUSTOM_TOKEN, new Pair("ERROR_INVALID_CUSTOM_TOKEN", "The custom token format is incorrect. Please check the documentation."));
        zzhe.put(FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH, new Pair("ERROR_CUSTOM_TOKEN_MISMATCH", "The custom token corresponds to a different audience."));
        zzhe.put(FirebaseError.ERROR_INVALID_CREDENTIAL, new Pair("ERROR_INVALID_CREDENTIAL", "The supplied auth credential is malformed or has expired."));
        zzhe.put(FirebaseError.ERROR_INVALID_EMAIL, new Pair("ERROR_INVALID_EMAIL", "The email address is badly formatted."));
        zzhe.put(FirebaseError.ERROR_WRONG_PASSWORD, new Pair("ERROR_WRONG_PASSWORD", "The password is invalid or the user does not have a password."));
        zzhe.put(FirebaseError.ERROR_USER_MISMATCH, new Pair("ERROR_USER_MISMATCH", "The supplied credentials do not correspond to the previously signed in user."));
        zzhe.put(FirebaseError.ERROR_REQUIRES_RECENT_LOGIN, new Pair("ERROR_REQUIRES_RECENT_LOGIN", "This operation is sensitive and requires recent authentication. Log in again before retrying this request."));
        zzhe.put(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL, new Pair("ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL", "An account already exists with the same email address but different sign-in credentials. Sign in using a provider associated with this email address."));
        zzhe.put(FirebaseError.ERROR_EMAIL_ALREADY_IN_USE, new Pair("ERROR_EMAIL_ALREADY_IN_USE", "The email address is already in use by another account."));
        zzhe.put(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE, new Pair("ERROR_CREDENTIAL_ALREADY_IN_USE", "This credential is already associated with a different user account."));
        zzhe.put(FirebaseError.ERROR_USER_DISABLED, new Pair("ERROR_USER_DISABLED", "The user account has been disabled by an administrator."));
        zzhe.put(FirebaseError.ERROR_USER_TOKEN_EXPIRED, new Pair("ERROR_USER_TOKEN_EXPIRED", "The user's credential is no longer valid. The user must sign in again."));
        zzhe.put(FirebaseError.ERROR_USER_NOT_FOUND, new Pair("ERROR_USER_NOT_FOUND", "There is no user record corresponding to this identifier. The user may have been deleted."));
        zzhe.put(FirebaseError.ERROR_INVALID_USER_TOKEN, new Pair("ERROR_INVALID_USER_TOKEN", "This user's credential isn't valid for this project. This can happen if the user's token has been tampered with, or if the user isn't for the project associated with this API key."));
        zzhe.put(FirebaseError.ERROR_OPERATION_NOT_ALLOWED, new Pair("ERROR_OPERATION_NOT_ALLOWED", "This operation is not allowed. You must enable this service in the console."));
        zzhe.put(FirebaseError.ERROR_WEAK_PASSWORD, new Pair("ERROR_WEAK_PASSWORD", "The given password is invalid."));
        zzhe.put(17029, new Pair("ERROR_EXPIRED_ACTION_CODE", "The out of band code has expired."));
        zzhe.put(17030, new Pair("ERROR_INVALID_ACTION_CODE", "The out of band code is invalid. This can happen if the code is malformed, expired, or has already been used."));
        zzhe.put(17031, new Pair("ERROR_INVALID_MESSAGE_PAYLOAD", "The email template corresponding to this action contains invalid characters in its message. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzhe.put(17033, new Pair("ERROR_INVALID_RECIPIENT_EMAIL", "The email corresponding to this action failed to send as the provided recipient email address is invalid."));
        zzhe.put(17032, new Pair("ERROR_INVALID_SENDER", "The email template corresponding to this action contains an invalid sender email or name. Please fix by going to the Auth email templates section in the Firebase Console."));
        zzhe.put(17034, new Pair("ERROR_MISSING_EMAIL", "An email address must be provided."));
        zzhe.put(17035, new Pair("ERROR_MISSING_PASSWORD", "A password must be provided."));
        zzhe.put(17041, new Pair("ERROR_MISSING_PHONE_NUMBER", "To send verification codes, provide a phone number for the recipient."));
        zzhe.put(17042, new Pair("ERROR_INVALID_PHONE_NUMBER", "The format of the phone number provided is incorrect. Please enter the phone number in a format that can be parsed into E.164 format. E.164 phone numbers are written in the format [+][country code][subscriber number including area code]."));
        zzhe.put(17043, new Pair("ERROR_MISSING_VERIFICATION_CODE", "The Phone Auth Credential was created with an empty sms verification Code"));
        zzhe.put(17044, new Pair("ERROR_INVALID_VERIFICATION_CODE", "The sms verification code used to create the phone auth credential is invalid. Please resend the verification code sms and be sure use the verification code provided by the user."));
        zzhe.put(17045, new Pair("ERROR_MISSING_VERIFICATION_ID", "The Phone Auth Credential was created with an empty verification ID"));
        zzhe.put(17046, new Pair("ERROR_INVALID_VERIFICATION_ID", "The verification ID used to create the phone auth credential is invalid."));
        zzhe.put(17049, new Pair("ERROR_RETRY_PHONE_AUTH", "An error occurred during authentication using the PhoneAuthCredential. Please retry authentication."));
        zzhe.put(17051, new Pair("ERROR_SESSION_EXPIRED", "The sms code has expired. Please re-send the verification code to try again."));
        zzhe.put(17052, new Pair("ERROR_QUOTA_EXCEEDED", "The sms quota for this project has been exceeded."));
        zzhe.put(FirebaseError.ERROR_APP_NOT_AUTHORIZED, new Pair("ERROR_APP_NOT_AUTHORIZED", "This app is not authorized to use Firebase Authentication. Please verifythat the correct package name and SHA-1 are configured in the Firebase Console."));
        zzhe.put(17063, new Pair("ERROR_API_NOT_AVAILABLE", "The API that you are calling is not available on devices without Google Play Services."));
        zzhe.put(17062, new Pair("ERROR_WEB_INTERNAL_ERROR", "There was an internal error in the web widget."));
        zzhe.put(17064, new Pair("ERROR_INVALID_CERT_HASH", "There was an error while trying to get your package certificate hash."));
        zzhe.put(17065, new Pair("ERROR_WEB_STORAGE_UNSUPPORTED", "This browser is not supported or 3rd party cookies and data may be disabled."));
    }

    private static String zza(String str, Status status) {
        if (TextUtils.isEmpty(status.getStatusMessage())) {
            return str;
        }
        return String.format(String.valueOf(str).concat(" [ %s ]"), new Object[]{status.getStatusMessage()});
    }

    public static FirebaseException zzb(Status status) {
        int statusCode = status.getStatusCode();
        String zza = zza(zzd(statusCode), status);
        switch (statusCode) {
            case FirebaseError.ERROR_INVALID_CUSTOM_TOKEN:
                return new FirebaseAuthInvalidCredentialsException(zzc(statusCode), zza);
            case FirebaseError.ERROR_CUSTOM_TOKEN_MISMATCH:
            case FirebaseError.ERROR_INVALID_CREDENTIAL:
            case FirebaseError.ERROR_INVALID_EMAIL:
            case FirebaseError.ERROR_WRONG_PASSWORD:
            case FirebaseError.ERROR_USER_MISMATCH:
                return new FirebaseAuthInvalidCredentialsException(zzc(statusCode), zza);
            case FirebaseError.ERROR_USER_DISABLED:
            case FirebaseError.ERROR_USER_NOT_FOUND:
            case FirebaseError.ERROR_INVALID_USER_TOKEN:
            case FirebaseError.ERROR_USER_TOKEN_EXPIRED:
                return new FirebaseAuthInvalidUserException(zzc(statusCode), zza);
            case FirebaseError.ERROR_OPERATION_NOT_ALLOWED:
                return new FirebaseAuthException(zzc(statusCode), zza);
            case FirebaseError.ERROR_EMAIL_ALREADY_IN_USE:
            case FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL:
            case FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE:
                return new FirebaseAuthUserCollisionException(zzc(statusCode), zza);
            case FirebaseError.ERROR_TOO_MANY_REQUESTS:
                return new FirebaseTooManyRequestsException(zza("We have blocked all requests from this device due to unusual activity. Try again later.", status));
            case FirebaseError.ERROR_REQUIRES_RECENT_LOGIN:
                return new FirebaseAuthRecentLoginRequiredException(zzc(statusCode), zza);
            case FirebaseError.ERROR_PROVIDER_ALREADY_LINKED:
                return new FirebaseException(zza("User has already been linked to the given provider.", status));
            case FirebaseError.ERROR_NO_SUCH_PROVIDER:
                return new FirebaseException(zza("User was not linked to an account with the given provider.", status));
            case FirebaseError.ERROR_NETWORK_REQUEST_FAILED:
                return new FirebaseNetworkException(zza("A network error (such as timeout, interrupted connection or unreachable host) has occurred.", status));
            case FirebaseError.ERROR_WEAK_PASSWORD:
                return new FirebaseAuthWeakPasswordException(zzc(statusCode), zza, status.getStatusMessage());
            case FirebaseError.ERROR_APP_NOT_AUTHORIZED:
                return new FirebaseAuthException(zzc(statusCode), zza);
            case 17029:
            case 17030:
                return new FirebaseAuthActionCodeException(zzc(statusCode), zza);
            case 17031:
            case 17032:
            case 17033:
                return new FirebaseAuthEmailException(zzc(statusCode), zza);
            case 17034:
            case 17035:
            case 17041:
            case 17042:
            case 17043:
            case 17044:
            case 17045:
            case 17046:
            case 17049:
            case 17051:
                return new FirebaseAuthInvalidCredentialsException(zzc(statusCode), zza);
            case 17052:
                return new FirebaseTooManyRequestsException(zza);
            case 17061:
                return new FirebaseNetworkException(zza("There was a failure in the connection between the web widget and the Firebase Auth backend.", status));
            case 17062:
                return new FirebaseAuthException(zzc(statusCode), zza);
            case 17063:
                return new FirebaseApiNotAvailableException(zza);
            case 17064:
                return new FirebaseAuthException(zzc(statusCode), zza);
            case 17065:
                return new FirebaseAuthException(zzc(statusCode), zza);
            case FirebaseError.ERROR_NO_SIGNED_IN_USER:
                return new FirebaseNoSignedInUserException(zza("Please sign in before trying to get a token.", status));
            case FirebaseError.ERROR_INTERNAL_ERROR:
                return new FirebaseException(zza("An internal error has occurred.", status));
            default:
                return new FirebaseException("An internal error has occurred.");
        }
    }

    public static FirebaseAuthUserCollisionException zzb(Status status, @NonNull PhoneAuthCredential phoneAuthCredential) {
        int statusCode = status.getStatusCode();
        return new FirebaseAuthUserCollisionException(zzc(statusCode), zza(zzd(statusCode), status), phoneAuthCredential);
    }

    private static String zzc(int i) {
        Pair pair = zzhe.get(i);
        return pair != null ? (String) pair.first : "INTERNAL_ERROR";
    }

    private static String zzd(int i) {
        Pair pair = zzhe.get(i);
        return pair != null ? (String) pair.second : "An internal error happened";
    }
}
