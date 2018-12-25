package com.sandeep.higherorderfunctionkotlindemo.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.sandeep.higherorderfunctionkotlindemo.R
import com.sandeep.higherorderfunctionkotlindemo.entities.Student
import kotlinx.android.synthetic.main.dialog_student_details.*
import java.io.Serializable
import java.util.*

class StudentDetailDialog() : DialogFragment(), View.OnClickListener
{

    companion object
    {
        fun getInstance(onNewStudent: (Student) -> Unit): StudentDetailDialog
        {
            val bundle = Bundle()
            bundle.putSerializable(ARG_STUDENT_CALLBACK, onNewStudent as Serializable)

            val studentDetailDialog = StudentDetailDialog()
            studentDetailDialog.arguments = bundle
            return studentDetailDialog

        }

        const val ARG_STUDENT_CALLBACK: String = "arg_student_callback"
    }

    private lateinit var onNewStudentEntered: (Student) -> Unit

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        onNewStudentEntered = arguments!!.getSerializable(ARG_STUDENT_CALLBACK) as (Student) -> Unit
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?
    {
        return inflater.inflate(R.layout.dialog_student_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        btnOk.setOnClickListener(this)
        btnCancel.setOnClickListener(this)
    }

    override fun onClick(v: View?)
    {
        when (v!!.id)
        {
            R.id.btnOk ->
            {
                if (!etStudentName.text.isEmpty())
                {
                    onNewStudentEntered(Student(Random().nextInt(), etStudentName.text.toString()))
                    dismiss()
                } else
                {
                    Toast.makeText(context, "Please enter student name", Toast.LENGTH_SHORT).show()
                }
            }

            R.id.btnCancel ->
            {
                dismiss()
            }
        }
    }

}