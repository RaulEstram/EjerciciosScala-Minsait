package ejercicios

import models.{Password, Sexo}

import scala.io.StdIn.{readInt, readLine}


object Ejercicio3 extends App {
  // 1.- Crea un array de Passwords con el tamaño que tú le indiques por teclado.
  val cantidad = pedirIntPositivo("Digite cuantas Passwords quieres: ")
  val listPasswords = Array.ofDim[Password](cantidad)
  // 4.- Lista para el punto 4 que esta mas adelante
  val sonSeguras = Array.ofDim[Boolean](cantidad)

  // 3.- Indica también por teclado la longitud de los Passwords (antes de bucle).
  val longitud = pedirIntPositivo("Digite el tamaño de los Passwords: ")
  val especiales = pedirBoolean("Quiere caracteres espaciales (S/N): ")

  // 2.- Crea un bucle que cree un objeto para cada posición del array.
  for (i <- 0 until cantidad) {

    listPasswords(i) = new Password(longitud = longitud, especiales = especiales)

    // 4.- Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte (usa el bucle anterior).
    sonSeguras(i) = listPasswords(i).esFuerte()

  }
  // 5.- Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior).
  val pairs = listPasswords.zip(sonSeguras)
  for ((password, seguras) <- pairs) {
    println(s"${password.getPassword} - $seguras")
  }

}


def pedirIntPositivo(texto: String = "Digite un Int"): Int = {
  var valor: Int = -1
  while (valor < 0) {
    print(texto)
    try valor = readInt() catch case e: NumberFormatException => valor = -1
  }
  valor
}

def pedirBoolean(texto: String): Boolean = {
  var opcion = ""
  while (opcion != "Y" && opcion != "N" && opcion != "S") {
    opcion = readLine(texto).toUpperCase()
  }
  opcion match {
    case "Y" | "S" => true
    case "N" => false
  }
}