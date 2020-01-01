package com.example.vibhor.sqllitedatabaseappdemo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by vibhor on 30-Apr-16.
 */
public class vibhHelper extends SQLiteOpenHelper {

    private static final String UID = "_id";
    private static final String DATABASE_NAME = "vibhor_database";
    private static final String TABLE_NAME = "vibhor_table";
    private static final String NAME = "NAME ";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE = "CREATE TABLE  " + TABLE_NAME + "( " + UID + "INTEGER PRIMARY KEY AUTO_INCREMENT" +
            " , " + NAME + " VARCHAR(255)) ;";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    Context context;

    /**
     * Create a helper object to create, open, and/or manage a database.
     * This method always returns very quickly.  The database is not actually
     * created or opened until one of {@link #getWritableDatabase} or
     * {@link #getReadableDatabase} is called.
     *
     * @param context to use to open or create the database
     */
    public vibhHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }


    /**
     * Called when the database is created for the first time. This is where the
     * creation of tables and the initial population of the tables should happen.
     *
     * @param db The database.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            Message.message(context, "onCreate was called");
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            Message.message(context, " " + e);
        }

    }

    /**
     * Called when the database needs to be upgraded. The implementation
     * should use this method to drop tables, add tables, or do anything else it
     * needs to upgrade to the new schema version.
     * <p/>
     * <p>
     * The SQLite ALTER TABLE documentation can be found
     * <a href="http://sqlite.org/lang_altertable.html">here</a>. If you add new columns
     * you can use ALTER TABLE to insert them into a live table. If you rename or remove columns
     * you can use ALTER TABLE to rename the old table, then create the new table and then
     * populate the new table with the contents of the old table.
     * </p><p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db         The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Message.message(context, "onUpgrade was called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context, " " + e);
        }

    }
}
