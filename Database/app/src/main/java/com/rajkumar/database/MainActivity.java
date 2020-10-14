package com.rajkumar.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mEtStudentName;
    private EditText mEtStudentAge;
    private EditText mEtStudentClass;
    private EditText mEtStudentMarks;


    private DBHelper dbHelper;

    private int StudentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEtStudentName = findViewById(R.id.et_student_name);
        mEtStudentAge = findViewById(R.id.et_student_age);
        mEtStudentClass = findViewById(R.id.et_student_class);
        mEtStudentMarks = findViewById(R.id.et_student_marks);

        dbHelper = new DBHelper(MainActivity.this);

    }
}