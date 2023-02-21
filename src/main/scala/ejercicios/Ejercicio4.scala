package ejercicios

object Ejercicio4 extends App {
  val canasta: Map[String, Map[String, Double]] = Map(
    "Chips Fuego" -> Map("precio" -> 25.00, "porcentaje" -> 10),
    "Helado de Choco menta" -> Map("precio" -> 80.00, "porcentaje" -> 15),
    "Comida China" -> Map("precio" -> 190, "porcentaje" -> 5),
    "Arizona de fresa kiwi" -> Map("precio" -> 22.00, "porcentaje" -> 10)
  )
  val total: Double = aplicarDescuentosOIVA(canasta, aplicarDescuento)
  println(s"El total de la canasta es de: $total")

}

def aplicarDescuento(precio: Double, descuento: Double): Double = {
  precio * (1 - descuento / 100)
}

def aplicarIVA(precio: Double, iva: Double): Double = {
  precio * (1 + iva / 100)
}

def aplicarDescuentosOIVA(cesta: Map[String, Map[String, Double]], funcion: (Double, Double) => Double): Double = {
  try {
    var total = 0.0
    for ((_, detalles) <- cesta) {
      val precio = detalles("precio")
      val porcentaje = detalles("porcentaje")
      total += funcion(precio, porcentaje)
    }
    total
  } catch {
    case _: NoSuchElementException => throw new IllegalArgumentException("La cesta debe ser un mapa con las claves 'precio' y 'porcentaje'.")
  }
}
