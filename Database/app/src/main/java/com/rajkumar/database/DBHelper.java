package com.rajkumar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "student_info_table";
    private static final String COL_ID = "id";
    private static final String COL_STUDENT_NAME = "student_name";
    private static final String COL_STUDENT_AGE = "student_age";
    private static final String COL_STUDENT_CLASS = "student_class";
    private static final String COL_STUDENT_MARKS = "student_marks";


    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_STUDENT_NAME +
            " TEXT," + COL_STUDENT_AGE + " TEXT," + COL_STUDENT_CLASS + " TEXT," + COL_STUDENT_MARKS + " TEXT)";

    public DBHelper(@Nullable Context context) {
        super(context, "Student.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void InsertDataIntoDatabase(SQLiteDatabase database,Student student) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STUDENT_NAME,student.getStudentName());
        contentValues.put(COL_STUDENT_AGE,student.getStudentAge());
        contentValues.put(COL_STUDENT_CLASS,student.getStudentClass());
        contentValues.put(COL_STUDENT_MARKS,student.getStudentMarks());

        database.insert(TABLE_NAME,null,contentValues);

    }

    public  void UpdateDataInDatabase(SQLiteDatabase database,Student student) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_STUDENT_NAME,student.getStudentName());
        contentValues.put(COL_STUDENT_AGE,student.getStudentAge());
        contentValues.put(COL_STUDENT_CLASS,student.getStudentClass());
        contentValues.put(COL_STUDENT_MARKS,student.getStudentMarks());

        database.insert(TABLE_NAME,null,contentValues);

    }

    public void DeleteDataFromDatabase(SQLiteDatabase database,Student student) {

        database.delete(TABLE_NAME, COL_ID + "=" + student.getStudentID(),null);

    }

    public ArrayList<Student> getDataFromDatabase(SQLiteDatabase database) {

        ArrayList<Student> StudentLists = new ArrayList<>();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME,null);

        if(cursor != null && cursor.moveToFirst()){
            do{
                Student StudentInfo = new Student();

                StudentInfo.setStudentID(cursor.getInt(cursor.getColumnIndex(COL_ID)));
                StudentInfo.setStudentName(cursor.getString(cursor.getColumnIndex(COL_STUDENT_NAME)));
                StudentInfo.setStudentAge(cursor.getString(cursor.getColumnIndex(COL_STUDENT_AGE)));
                StudentInfo.setStudentClass(cursor.getString(cursor.getColumnIndex(COL_STUDENT_CLASS)));
                StudentInfo.setStudentMarks(cursor.getString(cursor.getColumnIndex(COL_STUDENT_MARKS)));

                StudentLists.add(StudentInfo);
            }while (cursor.moveToNext());

            cursor.close();
        }

        return StudentLists;
    }
}
