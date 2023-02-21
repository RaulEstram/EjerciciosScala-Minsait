package ejercicios

import scala.math.{sin, cos, tan, exp, log}
import scala.io.StdIn.readInt
import lib.PrintError.printError


object Ejercicio5 extends App {
  scientificCalculator()
}


def scientificCalculator(): Unit = {

  val function = pedirFunicion()
  val value = pedirInt()

  println("x\tf(x)")
  for (x <- 1 to value) {
    val result = function match {
      case 1 => sin(x)
      case 2 => cos(x)
      case 3 => tan(x)
      case 4 => exp(x)
      case 5 => log(x)
      case _ => 0.0
    }
    println(s"$x\t$result")
  }
}

def pedirFunicion(): Int = {
  var selectFunction = 0
  while (!List(1, 2, 3, 4, 5).contains(selectFunction)) {
    println("Seleccione una función:")
    println("1 - Seno")
    println("2 - Coseno")
    println("3 - Tangente")
    println("4 - Exponencial")
    println("5 - Logaritmo neperiano")
    try {
      val input = readInt()
      if (List(1, 2, 3, 4, 5).contains(input)) {
        selectFunction = input
      } else {
        printError("Se tiene que seleccionar un valor válido (1-5)")
      }
    } catch {
      case _: Throwable => {
        printError("Se tiene que digitar un valor numérico (1-5)")
      }
    }
  }
  selectFunction
}


def pedirInt(): Int = {
  var value = 0
  var validInput = false

  while (!validInput) {
    try {
      print("Introduzca un valor: ")
      value = readInt()
      validInput = true
    } catch {
      case _: NumberFormatException =>
        printError("El valor introducido no es válido. Por favor, introduzca un valor numérico entero.")
    }
  }
  value
}