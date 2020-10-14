package com.rajkumar.database;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentInfoAdapter extends RecyclerView.Adapter<StudentInfoAdapter.StudentInfoHolder> {

    private Context context;
    private ArrayList<Student> StudentDetails;

    public StudentInfoAdapter(Context context, ArrayList<Student> StudentDetails){
        this.context = context;
        this.StudentDetails = StudentDetails;

    }

    @NonNull
    @Override
    public StudentInfoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        StudentInfoHolder holder = new StudentInfoHolder(LayoutInflater.from(context).inflate(R.layout.cell_student, parent, false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentInfoHolder holder, int position) {

        Student student = StudentDetails.get(position);

        holder.mTvStudentName.setText(student.getStudentName());
        holder.mTvStudentAge.setText(student.getStudentAge());
        holder.mTvStudentClass.setText(student.getStudentClass());
        holder.mTvStudentMarks.setText(student.getStudentMarks());

    }

    @Override
    public int getItemCount() {
        return StudentDetails.size();
    }

    class StudentInfoHolder extends RecyclerView.ViewHolder{

        private TextView mTvStudentName;
        private TextView mTvStudentAge;
        private TextView mTvStudentClass;
        private TextView mTvStudentMarks;

        public StudentInfoHolder(@NonNull View itemView) {
            super(itemView);

            mTvStudentName = itemView.findViewById(R.id.tv_Student_name);
            mTvStudentAge = itemView.findViewById(R.id.tv_Student_Age);
            mTvStudentClass = itemView.findViewById(R.id.tv_Student_class);
            mTvStudentMarks = itemView.findViewById(R.id.tv_Student_marks);
        }
    }
}
