package ejercicios

import lib.CustomError
import lib.PrintError.printError
import models.Cuenta

object Ejercicio1 extends App {
  // Ejemplo

  private val myCuenta = new Cuenta(titular = "Raúl", 4000)

  try {
    myCuenta.retirar(5000)
  } catch {
    case e: CustomError => printError("Hay un error :c\n" + e.toString)
  }
}


