package com.google.firebase.database;

import com.google.android.gms.internal.firebase_database.zzja;

public class Transaction {

    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    public static class Result {
        private boolean zzba;
        private zzja zzbb;

        private Result(boolean z, zzja zzja) {
            this.zzba = z;
            this.zzbb = zzja;
        }

        public boolean isSuccess() {
            return this.zzba;
        }

        public final zzja zzd() {
            return this.zzbb;
        }
    }

    public static Result abort() {
        return new Result(false, (zzja) null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.zzd());
    }
}
