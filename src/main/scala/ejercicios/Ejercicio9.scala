package ejercicios


object Ejercicio9 extends App {
  val notas = Map("Matemáticas" -> 9.5, "Lengua" -> 5.99, "Historia" -> 5.5, "Física" -> 7.0)
  val notasAprobadas = obtenerAprobatorias(notas)
  println(notasAprobadas)

}


object obtenerAprobatorias {
  def apply(notas: Map[String, Double]): Map[String, Double] = {
    val notasAprobadas = notas.filter( _._2 >= 6.0)
    notasAprobadas.map(element => element._1.toUpperCase() -> element._2)
  }

}
