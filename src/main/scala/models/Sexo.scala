package models

enum Sexo(private val sexo: String) {
  case H extends Sexo("Hombre")
  case M extends Sexo("Mujer")
  case O extends Sexo("Otro")

  override def toString = s"$sexo"
}
