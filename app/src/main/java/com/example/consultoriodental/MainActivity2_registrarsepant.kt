package com.example.consultoriodental

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import com.example.consultoriodental.databinding.ActivityMainActivity2RegistrarsepantBinding
import com.example.consultoriodental.databinding.ActivityMainBinding

class MainActivity2_registrarsepant : AppCompatActivity() {
lateinit var ci:EditText
    lateinit var nombre:EditText
    lateinit var apellido:EditText
    lateinit var email:EditText
    lateinit var contrasenia:EditText
    //ver lista
lateinit var lista:TextView
    lateinit var registrar: Button
    lateinit var mostrar:Button

    lateinit var  codborrado:TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_registrarsepant)
        ci=findViewById(R.id.txtregistci)
        nombre=findViewById(R.id.txtregistnombre)
        apellido=findViewById(R.id.txtregistapellido)
        email=findViewById(R.id.txtregistcorreo)
        contrasenia=findViewById(R.id.txtregistcontraseña)
        lista=findViewById(R.id.textView2)
        registrar=findViewById(R.id.btnregistrarme)
        mostrar=findViewById(R.id.btnmostrar)

        registrar.setOnClickListener {
            creardatos(lista)
        }
        mostrar.setOnClickListener {
        listardatos(lista)
        }
    }
fun creardatos(view: View) {
    var db=miSQLITEhelper(this)
    var paci=Pacientes()
    if (nombre.text.toString().length > 0 && apellido.text.toString().length > 0 && email.text.toString().length>0
        && ci.text.toString().length>0 && contrasenia.text.toString().length>0 )
    {
        paci.ci=ci.text.toString().toInt()
        paci.nombre=nombre.text.toString()
        paci.apellido=apellido.text.toString()
        paci.email=email.text.toString()
        paci.contrasenia=contrasenia.text.toString()
        db.insertardatos(paci)
    }
}

    fun listardatos(view:View){
        var db=miSQLITEhelper(this)

           var datosl= db.traerdatos()
            for(i in 0..datosl.size-1){
lista.append("CI: "+ datosl.get(i).ci.toString()+" Nombre: "+ datosl.get(i).nombre+
    " Apellido: " +datosl.get(i).apellido+" Email: "+datosl.get(i).email+" contrasenia: "+datosl.get(i).contrasenia+"\n")
            }

    }

    //@SuppressLint("SuspiciousIndentation")
    //fun borrardatos(view:View){
      //var db=miSQLITEhelper(this)
        //if(codborrado.text.toString()){
          //  db.borrardatos(codborrado.text.toString())
        //}
    //}
}