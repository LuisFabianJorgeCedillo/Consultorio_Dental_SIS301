package com.example.horarios
import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.consultoriodental.R
import java.sql.Time
import java.text.Format
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import java.util.Timer

class horario : AppCompatActivity() {

    private lateinit var textdatepicker:TextView
    private lateinit var btndatepicker:Button
    private lateinit var texttimepicker:TextView
    private lateinit var btntimepicker:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horario)



        textdatepicker=findViewById(R.id.textfecha)
        btndatepicker=findViewById(R.id.fecha)
        texttimepicker=findViewById(R.id.texthora)
        btntimepicker=findViewById(R.id.btnhora)
        val myCalendar= Calendar.getInstance()

        val myTime=Calendar.getInstance()
        val timePicker=TimePickerDialog.OnTimeSetListener{view,hourOfDay,minute->
            myTime.set(Calendar.HOUR_OF_DAY,hourOfDay)
            myTime.set(Calendar.MINUTE,minute)
            myTime.timeZone= TimeZone.getDefault()
            updateLabletimer(myTime)
        }

        val datePicker=DatePickerDialog.OnDateSetListener{view, year, month, dayOfMonth ->
            myCalendar.set(Calendar.YEAR,year)
            myCalendar.set(Calendar.MONTH,month)
            myCalendar.set(Calendar.DAY_OF_MONTH,dayOfMonth)
            updateLable(myCalendar)
        }
        btndatepicker.setOnClickListener{
            DatePickerDialog(this, datePicker,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
        btntimepicker.setOnClickListener {
            TimePickerDialog(this,timePicker,myTime.get(Calendar.HOUR_OF_DAY),myTime.get(Calendar.MINUTE),false).show()
        }
        val anio=myCalendar.get(Calendar.YEAR)
    }

    private fun updateLabletimer(myTime: Calendar) {
val myFormat2="hh:mm aa"
        val asd= SimpleDateFormat(myFormat2,Locale.UK)
        texttimepicker.setText(asd.format(myTime.time))
    }

    private fun updateLable(myCalendar: Calendar) {
val myFormat="dd-MM-yy"

        val sdf= SimpleDateFormat(myFormat, Locale.UK)
        textdatepicker.setText(sdf.format(myCalendar.time))
    }



}