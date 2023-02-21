package models

import lib.CustomError
import lib.PrintError.printError

class Cuenta(private var titular: String, private var cantidad: Double = 0.0) {

  def this(titular: String) = {
    this(titular, 0.0)
  }

  def ingresar(cantidad: Double): Unit = {
    if (cantidad <= 0) throw new CustomError("No se pueden ingresar números negativos o No ingresar nada.")
    this.cantidad += cantidad
  }

  def retirar(cantidad: Double): Unit = {
    if (cantidad <= 0) throw new CustomError("No se pueden retirar números negativos o No retirar nada.")
    // if (cantidad > this.cantidad) throw new CustomError("No se puede retirar más de lo que se tiene.")
    if (cantidad > this.cantidad) {
      this.cantidad = 0
      return
    }

    this.cantidad = this.cantidad - cantidad
  }

  def getTitular: String = titular

  def setTitular(titular: String): Unit = {
    this.titular = titular
  }

  def getCantidad: Double = cantidad

  def setCantidad(cantidad: Double): Unit = {
    this.cantidad = cantidad
  }

  override def toString: String = {
    s"Titular: $titular, Cantidad: $cantidad"
  }
}

