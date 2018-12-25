package com.sandeep.higherorderfunctionkotlindemo.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandeep.higherorderfunctionkotlindemo.entities.Student

class StudentListAdapter(
    private val context: Context, private val studentList: MutableList<Student>,
    private val onStudentClicked: (Int) -> Unit
) : RecyclerView.Adapter<StudentViewHolder>()
{

    fun getItem(position: Int): Student
    {
        return studentList[position]
    }

    fun addStudent(student: Student)
    {
        studentList.add(student)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder
    {
        return StudentViewHolder.create(context, parent, onStudentClicked)
    }

    override fun getItemCount(): Int
    {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int)
    {
        holder.bindView(studentList[position])
    }


}


