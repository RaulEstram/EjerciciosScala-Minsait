package lib

object PrintError {
  def printError(mensaje: String): Unit = {
    Console.println(Console.RED + mensaje + Console.RESET)
  }
}
