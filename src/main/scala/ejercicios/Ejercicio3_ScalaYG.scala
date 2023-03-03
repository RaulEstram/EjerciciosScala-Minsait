package ejercicios

import scala.io.StdIn.readLine
import scala.util.Random as r

object Ejercico3_ScalaYG extends App {
  val c1 = new Password(6)
  println(c1.contrasena)
  println(c1.longitud)
  println(c1.esFuerte())
  println(c1.getPassword())
  println(c1.generarPassword(10))
}


class Password(var longitud: Int = 8, var contrasena: String = "") {

  this.contrasena = generarPassword(longitud)
  // var n: Int = l

  def generarPassword(n: Int = longitud): String = {
    if (n == 0) ""
    else randomChar + generarPassword(n - 1)
  }

  private def randomChar: String =
    var MMU: Int = r.between(1, 4)
    val randomMay: Int = r.between(0, Password.mayusculas.length)
    val randomMin: Int = r.between(0, Password.minusculas.length)
    val randomNum: Int = r.between(0, Password.numeros.length)

    if (MMU == 1) Password.mayusculas.charAt(randomMay).toString
    else if (MMU == 2) Password.minusculas.charAt(randomMin).toString
    else if (MMU == 3) Password.numeros.charAt(randomNum).toString
    else ""

  def esFuerte(): Boolean = {
    val numMayusculas = contrasena.count(Password.mayusculas.contains(_))
    val numMinusculas = contrasena.count(Password.minusculas.contains(_))
    val numNumeros = contrasena.count(Password.numeros.contains(_))
    if (numMayusculas > 2 && numMinusculas > 1 && numNumeros > 5) true
    else false
  }

  def getPassword(): String = contrasena

}

object Password {

  val minusculas: String = "abcdefghijklmnopqrstuvwxyz"
  val mayusculas: String = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val numeros: String = "01023456789"


}