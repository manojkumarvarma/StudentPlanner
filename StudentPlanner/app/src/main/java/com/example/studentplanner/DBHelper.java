package com.example.studentplanner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * This class will help to in database related activities
 */

public class DBHelper  extends SQLiteOpenHelper {

    public DBHelper(Context context) {
        super(context, DBRelatedConstants.DATABASE_NAME, null, DBRelatedConstants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating required tables
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TERMS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_COURSES);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TASKS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_TASK_ATTACHMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_ASSIGNMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_ASSIGNMENT_ATTACHMENTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECTS);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECT_PHASES);
        db.execSQL(DBRelatedConstants.CREATE_TABLE_PROJECT_PHASE_ATTACHMENTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TERMS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_COURSES);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TASKS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_TASK_ATTACHMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_ASSIGNMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_ASSIGNMENT_ATTACHMENTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECTS);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECT_PHASES);
        db.execSQL("DROP TABLE IF EXISTS " + DBRelatedConstants.TABLE_PROJECT_PHASES_ATTACHMENTS);
        // create new tables
        onCreate(db);
    }

    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


    public void addNewTerm(StudentTermModel newTerm) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBRelatedConstants.TERM_TERMNAME, newTerm.getTermName());
        values.put(DBRelatedConstants.TERM_TERMSTARTDATE, newTerm.getTermStartDate());
        values.put(DBRelatedConstants.TERM_TERMENDDATE, newTerm.getTermEndDate());
        // insert row
        long newTermRow = db.insert(DBRelatedConstants.TABLE_TERMS, null, values);
        Log.d(" New Row iD", "New row inserted  in Term table" + newTermRow);

    }
}
