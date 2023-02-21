package ejercicios

object Ejemplo7 extends App {
  val numeros = List(-2, 5, -1, 0, 3, -4, 6)
  val numerosPositivos = filterList((x: Int) => x > 0, numeros)
  println(numerosPositivos)
}

object filterList {
  def apply[A](f: A => Boolean, list: List[A]): List[A] = {
    list.filter(f)
  }
}