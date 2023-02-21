# Ejercicios Scala

A continuación, encontrarás una serie de ejercicios resueltos.

## Ejercicio 1

* Crea una clase llamada **Cuenta** que tendrá los siguientes atributos: titular y cantidad (puede tener decimales).

* El titular será obligatorio y la cantidad es opcional. Crea dos constructores que cumpla lo anterior.

* Crea sus métodos get, set y toString.

* Tendrá dos métodos especiales:
	* **ingresar(double cantidad)**: se ingresa una cantidad a la cuenta, si la cantidad introducida es negativa, no se hará nada.
	* **retirar(double cantidad)**: se retira una cantidad a la cuenta, si restando la cantidad actual a la que nos pasan es negativa, la cantidad de la cuenta pasa a ser 0.

## Ejercicio 2

* Haz una clase llamada **Persona** que siga las siguientes condiciones:
	* Sus atributos son: **nombre, edad, DNI, sexo (H hombre, M mujer), peso y altura**. No queremos que se accedan directamente a ellos. Piensa que modificador de acceso es el más adecuado, también su tipo. Si quieres añadir algún atributo puedes hacerlo.
	* Por defecto, todos los atributos menos el DNI serán valores por defecto según su tipo (0 números, cadena vacía para String, etc.). Sexo será hombre por defecto, usa una constante para ello.

* Se implantarán varios constructores:
	* Un constructor por defecto.
	* Un constructor con el nombre, edad y sexo, el resto por defecto.
	* Un constructor con todos los atributos como parámetro.

* Los métodos que se implementaran son:
	* **calcularIMC()**: calculara si la persona está en su peso ideal (peso en kg/(altura^2 en m)), si esta fórmula devuelve un valor menor que 20, la función devuelve un -1, si devuelve un número entre 20 y 25 (incluidos), significa que está por debajo de su peso ideal la función devuelve un 0 y si devuelve un valor mayor que 25 significa que tiene sobrepeso, la función devuelve un 1. Te recomiendo que uses constantes para devolver estos valores.
	* **esMayorDeEdad()**: indica si es mayor de edad, devuelve un booleano.
	* **comprobarSexo(char sexo)**: comprueba que el sexo introducido es correcto. Si no es correcto, sera H. No sera visible al exterior.
	* **toString()**: devuelve toda la información del objeto.
	* **generaDNI()**: genera un número aleatorio de 8 cifras, genera a partir de este su número su letra correspondiente. Este método será invocado cuando se construya el objeto. Puedes dividir el método para que te sea más fácil. No será visible al exterior. 
	* Métodos set de cada parámetro, excepto de DNI.

Ahora, crea una clase ejecutable que haga lo siguiente:


* Pide por teclado el nombre, la edad, sexo, peso y altura.
* Crea 3 objetos de la clase anterior, el primer objeto obtendrá las anteriores variables pedidas por teclado, el segundo objeto obtendrá todos los anteriores menos el peso y la altura y el último por defecto, para este último utiliza los métodos set para darle a los atributos un valor.
* Para cada objeto, deberá comprobar si está en su peso ideal, tiene sobrepeso o por debajo de su peso ideal con un mensaje.
* Indicar para cada objeto si es mayor de edad.
* Por último, mostrar la información de cada objeto.

Puedes usar métodos en la clase ejecutable, para que os sea más fácil.

## Ejercicio 3

Haz una clase llamada **Password** que siga las siguientes condiciones:
* Que tenga los atributos longitud y contraseña. Por defecto, la longitud será de 8.
* Los constructores serán los siguiente:
	* Un constructor por defecto.
	* Un constructor con la longitud que nosotros le pasemos. Generará una contraseña aleatoria con esa longitud.
* Los métodos que implementa serán:
	* **esFuerte()**: devuelve un booleano si es fuerte o no, para que sea fuerte debe tener más de 2 mayúsculas, más de 1 minúscula y más de 5 números.
	* **generarPassword()**: genera la contraseña del objeto con la longitud que tenga.
	* Método get para contraseña y longitud.
	* Método set para longitud.

Ahora, crea una clase ejecutable:

* Crea un array de Passwords con el tamaño que tú le indiques por teclado.
* Crea un bucle que cree un objeto para cada posición del array.
* Indica también por teclado la longitud de los Passwords (antes de bucle).
* Crea otro array de booleanos donde se almacene si el password del array de Password es o no fuerte (usa el bucle anterior).
* Al final, muestra la contraseña y si es o no fuerte (usa el bucle anterior). Usa este simple formato:
	* contraseña1 valor_booleano
	* contraseña2 valor_bololeano

## Ejercicio 4

Escribir una función que aplique un descuento a un precio y otra que aplique el IVA a un precio. Escribir una tercera función que reciba un diccionario con los precios y porcentajes de una cesta de la compra, y una de las funciones anteriores, y utilice la función pasada para aplicar los descuentos o el IVA a los productos de la cesta y devolver el precio final de la cesta.

## Ejercicio 5

Escribir una función que simule una calculadora científica que permita calcular el seno, coseno, tangente, exponencial y logaritmo neperiano. La función preguntará al usuario el valor y la función a aplicar, y mostrará por pantalla una tabla con los enteros de 1 al valor introducido y el resultado de aplicar la función a esos enteros.

## Ejercicio 6

Escribir una función que reciba otra función y una lista, y devuelva otra lista con el resultado de aplicar la función dada a cada uno de los elementos de la lista.

## Ejercicio 7

Escribir una función que reciba otra función booleana y una lista, y devuelva otra lista con los elementos de la lista que devuelvan True al aplicarles la función booleana.

## Ejercicio 8

Escribir una función que reciba una frase y devuelva un diccionario con las palabras que contiene y su longitud.

## Ejercicio 9

Escribir una función reciba un diccionario con las asignaturas y las notas de un alumno y devuelva otro diccionario con las asignaturas en mayúsculas y las calificaciones correspondientes a las notas aprobadas.

## Ejercicio 10

Una inmobiliaria de una ciudad maneja una lista de inmuebles como la siguiente:

```
[{'año': 2000 , 'metros': 100 , 'habitaciones': 3 , 'garaje': True, 'zona': 'A'},
{'año': 2012 , 'metros': 60 , 'habitaciones': 2 , 'garaje': True, 'zona': 'B'},
{'año': 1980 , 'metros': 120 , 'habitaciones': 4 , 'garaje': False, 'zona': 'A'},
{'año': 2005 , 'metros': 75 , 'habitaciones': 3 , 'garaje': True, 'zona': 'B'},
{'año': 2015 , 'metros': 90 , 'habitaciones': 2 , 'garaje': False, 'zona': 'A'}]
```

* Construir una función que permita hacer búsqueda de inmuebles en función de un presupuesto dado. La función recibirá como entrada la lista de inmuebles y un precio, y devolverá otra lista con los inmuebles cuyo precio sea menor o igual que el dado. Los inmuebles de la lista que se devuelva deben incorporar un nuevo par a cada diccionario con el precio del inmueble, donde el precio de un inmueble se calcula con la siguiente fórmula en función de la zona:

```
Zona A: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100)

Zona B: precio = (metros * 1000 + habitaciones * 5000 + garaje * 15000) * (1-antiguedad/100) * 1.
```

