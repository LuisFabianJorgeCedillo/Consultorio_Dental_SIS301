package com.example.consultoriodental

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class miSQLITEhelper(context: Context) :SQLiteOpenHelper(context,"PACIENTES.db",null,1){
    override fun onCreate(db: SQLiteDatabase?) {
val creartabla="CREATE TABLE "+
        "PACIENTES (ci INTEGER PRIMARY KEY NOT NULL,nombre VARCHAR(35),apellido VARCHAR(35),email VARCHAR(35),contrasenia VARCHAR(35));"
        db?.execSQL(creartabla)
    }

    override fun onUpgrade(db: SQLiteDatabase?, olderVersion: Int, newVersion: Int) {

    }

    fun insertardatos(pacientes: Pacientes):String{
        val db=this.writableDatabase
        var datos=ContentValues();
        datos.put("ci",pacientes.ci)
        datos.put("nombre",pacientes.nombre)
        datos.put("apellido",pacientes.apellido)
        datos.put("email",pacientes.email)
        datos.put("contrasenia",pacientes.contrasenia)

        var resultados=db.insert("Pacientes",null,datos)
        if(resultados==-1.toLong()){
return "fallas en la insercion";
        }else{
            return "Datos insertados"
        }
    }

    @SuppressLint("Range")
    fun traerdatos():MutableList<Pacientes>{
var lista:MutableList<Pacientes> = ArrayList()
        val db=this.readableDatabase
        val sql ="select * from Pacientes"
        val resultado=db.rawQuery(sql,null)
        if(resultado.moveToFirst()){
            do{
    var pac=Pacientes()
                pac.ci=resultado.getString(resultado.getColumnIndex("ci")).toInt()
                pac.nombre=resultado.getString(resultado.getColumnIndex("nombre"))
                pac.apellido=resultado.getString(resultado.getColumnIndex("apellido"))
                pac.email=resultado.getString(resultado.getColumnIndex("email"))
                pac.contrasenia=resultado.getString(resultado.getColumnIndex("contrasenia"))
                lista.add(pac)
            }while(resultado.moveToNext())
            resultado.close()
            db.close()

        }
        return(lista)
    }

    fun actualizardatos(ci:String,nombre:String,apellido:String,email:String,contrasenia:String):String{
val db=writableDatabase
        var datos=ContentValues()
        datos.put("nombre",nombre)
        datos.put("apellido",apellido)
        datos.put("email",email)
        datos.put("contrasenia",contrasenia)
        var resultado = db.update("Pacientes",datos,"ci=?", arrayOf(ci))
            if(resultado > 0){
                return "datos actualizados"
            }else{
                return "error de actualizacion"
            }
    }

    fun borrardatos(codigo:String){
        val db=writableDatabase
        if(codigo.length>0){
db.delete("Usuario","ci=?", arrayOf(codigo))
        }
    }



}
