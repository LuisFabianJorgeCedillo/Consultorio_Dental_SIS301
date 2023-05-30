package com.example.citasmedicas

import com.example.consultoriodental.R

import android.app.DatePickerDialog
import android.icu.text.SimpleDateFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.Calendar
import java.util.Locale

class citasmedicas : AppCompatActivity() {

private lateinit var botonfecha: Button
private lateinit var textofecha: TextView

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_citasmedicas)

        textofecha=findViewById(R.id.textfecha)
        botonfecha=findViewById(R.id.btnfecha)
        val myCalendar=Calendar.getInstance()

        val datePicker=DatePickerDialog.OnDateSetListener{view,year,month,DayOfMonth->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,DayOfMonth)
            updateLable(myCalendar)
    }
        botonfecha.setOnClickListener {
            DatePickerDialog(this,datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun updateLable(myCalendar: Calendar) {
val myformat="dd-MM-yy"

        val fec=SimpleDateFormat(myformat, Locale.UK)
        textofecha.setText(fec.format(myCalendar.time))
    }
}