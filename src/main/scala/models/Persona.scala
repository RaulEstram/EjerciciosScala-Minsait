package models

import models.Sexo
import scala.util.Random

class Persona(
               private var nombre: String = "",
               private var edad: Int = 0,
               private var DNI: String,
               private var sexo: Sexo = Sexo.H,
               private var peso: Double = 0,
               private var altura: Double = 0
             ) {
  // constructor con todos los atributos como parámetros

  // constructor por defecto
  def this() = this(DNI = "")

  // Constructor con nombre, edad, sex
  def this(nombre: String, edad: Int, sexo: Sexo) = this(nombre = nombre, edad = edad, sexo = sexo, DNI = "")

  if (this.DNI == "") this.DNI = this.generarDNI

  // métodos

  def calcularIMC(): Int = {
    val imc: Double = peso / (altura * altura)
    if (imc < 20) return -1 // comele más
    if (imc >= 20 && imc <= 25) return 0 // optimo
    return 1 // sobrepeso
  }

  def esMayorDeEdad(): Boolean = edad >= 18

  def comprobarSexo(sexo: Char): Boolean = this.sexo.toString.charAt(0) == sexo.toUpper

  private def generarDNI: String = {
    val letras = "TRWAGMYFPDXBNJZSQVHLCKE" // Letras del DNI
    val numDNI = 10000000 + Random.nextInt(90000000) // Número de DNI aleatorio
    val letraDNI = letras.charAt(numDNI % 23) // Letra correspondiente al número
    return s"$numDNI$letraDNI" // Devolver número y letra en un String de 9 caracteres
  }

  override def toString = s"Persona($nombre, $edad, $DNI, $sexo, $peso, $altura)"

  // getters & setters

  def getNombre: String = nombre

  def getEdad: Int = edad

  def getDNI: String = DNI

  def getSexo: Sexo = sexo

  def getPeso: Double = peso

  def getAltura: Double = peso

  def setNombre(nombre: String): Unit = this.nombre = nombre

  def setEdad(edad: Int): Unit = this.edad = edad

  def setSexo(sexo: Sexo): Unit = this.sexo = sexo

  def setPeso(peso: Double): Unit = this.peso = peso

  def setAltura(altura: Double): Unit = this.altura = altura
}