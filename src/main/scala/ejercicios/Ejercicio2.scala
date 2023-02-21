package ejercicios

import scala.util.Random
import scala.io.StdIn.{readLine, readInt, readDouble}
import models.{Sexo, Persona}

object Ejercicio2 extends App {


  // 1 pedir información
  val nombre: String = pedirStringNoVacio("Introduzca el nombre: ")
  val edad: Int = pedirIntPositivo("Introduzca su edad: ")
  val sexo = pedirSexo()
  var peso = pedirDouble("Introduzca su peso (en kilogramos): ")
  var altura = pedirDouble("Introduzca su altura (en metros): ")
  // 2 crea 3 objetos
  val persona1 = new Persona(nombre = nombre, edad = edad, sexo = sexo, peso = peso, altura = altura, DNI = "")
  val persona2 = new Persona(nombre = nombre, edad = edad, sexo = sexo, DNI = "")
  val persona3 = new Persona()
  persona3.setPeso(70)
  persona3.setAltura(1.7)
  persona3.setNombre("Raul")
  persona3.setSexo(Sexo.H)
  persona3.setEdad(22)
  // 3 comprobar el peso ideal
  comprobarPeso(persona1)
  comprobarPeso(persona2)
  comprobarPeso(persona3)
  // 4 comprobar si es mayor de edad
  comprobarEdad(persona1)
  comprobarEdad(persona2)
  comprobarEdad(persona3)
  // 5 mostrar información de cada objeto
  println(persona1)
  println(persona2)
  println(persona3)
}

def pedirStringNoVacio(texto: String = "Introduzca un string no vacío: "): String = {
  var nombre: String = ""
  while (nombre.isEmpty) {
    print(texto)
    nombre = readLine().trim()
  }
  return nombre
}

def pedirIntPositivo(texto: String = "Digite un Int"): Int = {
  var valor: Int = -1
  while (valor < 0) {
    print(texto)
    try valor = readInt() catch case e: NumberFormatException => valor = -1
  }
  return valor
}

def pedirSexo(): Sexo = {
  var sexo = ""
  while (sexo != "H" && sexo != "M" && sexo != "O") {
    print("Introduzca su sexo (H/M/O): ")
    sexo = readLine().toUpperCase()
  }
  sexo match {
    case "H" => Sexo.H
    case "M" => Sexo.M
    case "O" => Sexo.O
  }
}

def pedirDouble(texto: String = "Digite un Double: "): Double = {
  var valor = 0.0
  while (valor <= 0.0) {
    print(texto)
    try valor = readDouble() catch case e: NumberFormatException => valor = 0.0
  }
  return valor
}

def comprobarPeso(persona: Persona): Unit = {
  val imc: Int = persona.calcularIMC()
  if (imc == -1) println(s"${persona.getNombre} esta por debajo de su peso idea.")
  if (imc == 0) println(s"${persona.getNombre} esta en su peso idea.")
  if (imc == 1) println(s"${persona.getNombre} esta sobre su peso ideal.")
}

def comprobarEdad(persona: Persona): Unit = {
  if (persona.getEdad >= 18) {
    println(s"${persona.getNombre} es mayor de edad")
  } else {
    println(s"${persona.getNombre} es menor de edad")
  }
}
