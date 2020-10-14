package com.rajkumar.database;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        RecyclerView mRcStudentInfo = findViewById(R.id.rc_student_info);

        mRcStudentInfo.setLayoutManager(new LinearLayoutManager(ViewActivity.this, RecyclerView.VERTICAL, false));

        DBHelper dbHelper = new DBHelper(ViewActivity.this);
        ArrayList<Student> StudentDetails = dbHelper.getDataFromDatabase(dbHelper.getReadableDatabase());

        StudentInfoAdapter adapter = new StudentInfoAdapter(ViewActivity.this, StudentDetails);

        mRcStudentInfo.setAdapter(adapter);
    }


}
