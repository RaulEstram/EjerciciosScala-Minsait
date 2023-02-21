package ejercicios

object Ejercicio8 extends App {
  val enunciado = "Hola Jóvenes, ¿cómo estás el día de Hoy?"
  val result = obtenerLongitudDeCadaPalabra(enunciado)
  println(result)
}

object obtenerLongitudDeCadaPalabra {
  def apply(texto: String): Map[String, Int] = {
    val textoLimpio = texto.replaceAll("[!?\\-,.¿;]+", "")
    //  "\s+" representa cualquier secuencia de uno o más espacios en blanco
    val palabras = textoLimpio.split("\\s+")
    palabras.map(word => (word, word.length)).toMap
  }
}