package com.example.fady.socialnetwork.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class SnaDbHelper extends SQLiteOpenHelper
{
    public static final String LOG_TAG = SnaDbHelper.class.getSimpleName();

    /** Name of the database file */
    private static final String DATABASE_NAME = "users.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;


    public SnaDbHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USERS_TABLE =  "CREATE TABLE " + SnaContract.UsersEntry.TABLE_NAME + " ("
                + SnaContract.UsersEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + SnaContract.UsersEntry.COLUMN_USER_NAME + " TEXT NOT NULL, "
                + SnaContract.UsersEntry.COLUMN_USER_GENDER + " INTEGER NOT NULL, "
                + SnaContract.UsersEntry.COLUMN_USER_NUMBER_OF_FRIENDS + " INTEGER NOT NULL DEFAULT 0, "
                + SnaContract.UsersEntry.COLUMN_USER_NUMBER_OF_POSTS + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USERS_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.

    }
}
