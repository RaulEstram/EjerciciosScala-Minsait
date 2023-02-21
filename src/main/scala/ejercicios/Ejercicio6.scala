package ejercicios

object Ejercicio6 extends App {
  val numeros: List[Int] = (1 to 10).toList
  val resultado = ApplyToList((x: Int) => x * x, numeros)
  println(resultado)
}

object ApplyToList {
  def apply[A, B](function: A => B, list: List[A]): List[B] = {
    list.map(function)
  }
}
