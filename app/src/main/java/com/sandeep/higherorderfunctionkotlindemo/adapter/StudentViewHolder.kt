package com.sandeep.higherorderfunctionkotlindemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandeep.higherorderfunctionkotlindemo.R
import com.sandeep.higherorderfunctionkotlindemo.entities.Student
import kotlinx.android.synthetic.main.item_student_details.view.*

class StudentViewHolder(view: View, private val onStudentClicked: (Int) -> Unit) :
        RecyclerView.ViewHolder(view)
{
    init
    {
        view.setOnClickListener {
            onStudentClicked(adapterPosition)
        }
    }

    fun bindView(student: Student)
    {
        itemView.tvStudentName.text = student.name
    }


    companion object
    {

        fun create(context: Context, parent: ViewGroup, onStudentClicked: (Int) -> Unit): StudentViewHolder
        {
            return StudentViewHolder(LayoutInflater.from(context).inflate(R.layout.item_student_details, parent, false)
                    , onStudentClicked
            )
        }
    }
}