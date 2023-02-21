package models

import scala.util.Random

// constructor con la longitud que nosotros le pasemos y genera la contraseña aleatoria
class Password(private var longitud: Int = 8, private var especiales: Boolean = true) {
  private var password: String = generarPassword()

  // constructor por defecto
  def this() = this(8)

  // métodos

  def esFuerte(): Boolean = {
    val numMayusculas = password.count(c => c.isUpper)
    val numMinusculas = password.count(c => c.isLower)
    val numNumeros = password.count(c => c.isDigit)
    val numEspeciales = password.count(c => !c.isLetterOrDigit)

    numMayusculas >= 1
      && numMinusculas >= 1
      && numNumeros >= 1
      && ((numEspeciales >= 1 && especiales) || (numEspeciales == 0 && !especiales))
  }

  private def generarPassword(): String = {
    // se crea una lista con todos los caracteres validos
    var caracteres = Password.letrasMinusculas
      + Password.letrasMayusculas
      + Password.digitos
    if (especiales) caracteres += Password.caracteresEspeciales

    // creamos un StringBuilder para mas velocidad al generar la contraseña
    val password = new StringBuilder
    // mediante un for y la clase Random seleccionamos caracteres al azar para formar la contraseña
    for (i <- 0 to longitud) {
      password.append(Random.shuffle(caracteres.toList).head)
    }

    password.toString()
  }

  // getters && setters

  def getLongitud: Int = longitud

  def getPassword: String = password

  def getEspeciales: Boolean = especiales

  def setLongitud(longitud: Int): Unit = {
    this.longitud = longitud
    this.password = generarPassword()
  }

  def setEspeciales(especiales: Boolean): Unit = {
    this.especiales = especiales
    this.password = generarPassword()
  }


  override def toString = s"Password($password, $longitud, $especiales)"
}

object Password {
  val letrasMayusculas: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val letrasMinusculas: String = "abcdefghijklmnopqrstuvwxyz"
  val digitos: String = "0123456789"
  val caracteresEspeciales: String = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~"

}