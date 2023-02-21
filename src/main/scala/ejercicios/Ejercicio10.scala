package ejercicios

import lib.CustomError


object Ejercicio10 extends App {
  val listaInmuebles = List(
    Map("año" -> 2000, "metros" -> 100, "habitaciones" -> 3, "garaje" -> true, "zona" -> "A"),
    Map("año" -> 2012, "metros" -> 60, "habitaciones" -> 2, "garaje" -> true, "zona" -> "B"),
    Map("año" -> 1980, "metros" -> 120, "habitaciones" -> 4, "garaje" -> false, "zona" -> "A"),
    Map("año" -> 2005, "metros" -> 75, "habitaciones" -> 3, "garaje" -> true, "zona" -> "B"),
    Map("año" -> 2015, "metros" -> 90, "habitaciones" -> 2, "garaje" -> false, "zona" -> "A")
  )

  println(quePedo.buscarInmueblesPorPrecio(listaInmuebles = listaInmuebles, precio = 100_000))
}


object quePedo {
  def buscarInmueblesPorPrecio(listaInmuebles: List[Map[String, Any]], precio: Double): List[Map[String, Any]] = {
    listaInmuebles.filter(inmueble => calcularPrecio(inmueble) <= precio)
      .map(inmueble => inmueble + ("precio" -> calcularPrecio(inmueble)))
  }

  private def calcularPrecio(inmueble: Map[String, Any]): Double = {
    try {
      val zona = inmueble("zona").asInstanceOf[String]
      val metros = inmueble("metros").asInstanceOf[Int]
      val habitaciones = inmueble("habitaciones").asInstanceOf[Int]
      val garaje = inmueble("garaje").asInstanceOf[Boolean]
      val antiguedad = 2023 - inmueble("año").asInstanceOf[Int]
      if (zona == "A") {
        (metros * 1000 + habitaciones * 5000 + (if (garaje) 15000 else 0)) * (1 - antiguedad / 100.0)
      } else {
        (metros * 1000 + habitaciones * 5000 + (if (garaje) 15000 else 0)) * (1 - antiguedad / 100.0) * 1.5
      }
    } catch {
      case _: NoSuchElementException => throw new IllegalArgumentException("La cesta debe ser un mapa con las claves 'precio' y 'porcentaje'.")
    }
  }

}