package com.sandeep.higherorderfunctionkotlindemo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandeep.higherorderfunctionkotlindemo.R
import com.sandeep.higherorderfunctionkotlindemo.adapter.StudentListAdapter
import com.sandeep.higherorderfunctionkotlindemo.dialog.StudentDetailDialog
import com.sandeep.higherorderfunctionkotlindemo.entities.Student
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    private lateinit var adapter: StudentListAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews()
    {
        rvStudentList.layoutManager = LinearLayoutManager(this)

        adapter = StudentListAdapter(this, getDataSet(), onStudentClicked())

        rvStudentList.adapter = adapter

        addStudent.setOnClickListener {
            val addStudent = StudentDetailDialog.getInstance(onNewStudent())
            addStudent.show(supportFragmentManager, "")
            addStudent.isCancelable = false
        }
    }

    private fun onNewStudent(): (Student) -> Unit
    {
        return {
            adapter.addStudent(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun getDataSet(): MutableList<Student>
    {
        return mutableListOf(
            Student(1, "Sandeep"),
            Student(2, "Dipali"),
            Student(3, "Sagar"),
            Student(4, "Komal"),
            Student(5, "Girish"),
            Student(6, "Dhanashri")
        )
    }

    private fun onStudentClicked(): (Int) -> Unit
    {
        return {

            Toast.makeText(this, adapter.getItem(it).name, Toast.LENGTH_SHORT).show()
        }

    }


}
