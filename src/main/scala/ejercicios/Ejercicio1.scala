package ejercicios

import lib.CustomError
import lib.PrintError.printError
import models.Cuenta

object Ejercicio1 extends App {
  // Ejemplo

  private val myCuenta = new Cuenta(titular = "Raúl", 4000)
  println(myCuenta)

  myCuenta.ingresar(500)
  println(myCuenta)

  myCuenta.retirar(5000)
  println(myCuenta)
}


