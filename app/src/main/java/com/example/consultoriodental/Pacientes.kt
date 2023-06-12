package com.example.consultoriodental

class Pacientes {
    var ci:Int=0
    var nombre:String=""
    var apellido:String=""
    var email:String=""
    var contrasenia:String=""
    constructor(ci:Int,nombre:String,apellido:String,email:String,contrasenia:String){
        this.ci=ci
        this.nombre=nombre
        this.apellido=apellido
        this.email=email
        this.contrasenia=contrasenia
    }
    constructor(){

    }
}