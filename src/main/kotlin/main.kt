import java.lang.ArithmeticException

const val PI = 3.1416

fun main() {
    //variables()

    //estructurasDeControl()

    //Bucles()
    //pruebaNull()

    //listas()
    //funcionesConListas()
    //maps()
    //sets()

    //funciones()
    //lambda()
    //highOrderFunction()

    //scopeFunction()

}


fun variables(){
    println("Hello world")

    var dinero = 10
    println(dinero)
    dinero = 5
    println(dinero)

    val nombre = "Rodrigo"
    println()
    println(PI)

    val isBig = true
    val numeroLargo : Long = 243L
    val double = 2.5
    val float = 1.1f

    val apellido = "Marquez"
    val nombreCompleto = "$nombre $apellido"
    println("Mi nombre es $nombreCompleto")
}

fun estructurasDeControl(){
    val nombre = "Rodrigo"

    // ### if   normal
    if (nombre.isNotEmpty()){
        println("El largo de nuestra variable es ${nombre.length}")
    } else {
        println("Error, la variable esta vacia")
    }

    // ### if   asignado a variable
    val mensaje =
        if (nombre.length > 4)  "Tu nombre es largo"
        else if (nombre.isEmpty())  "Nombre esta vacio"
        else "Tienes un nombre corto"
    println(mensaje)
    println("\n")
    // ### when
    val nombreColor = "Amarillo"

    when (nombreColor){
        "Amarillo" -> println("El amarillo es el color del sol")
        "Rojo", "Carmesi" -> println("El Rojo simboliza el fuego")
        else -> println("Error. No tengo informacion de ese color")
    }

    val code = 404
    when (code){
        in 200..209 -> println("Todo ha ido bien")
        in 400..500 -> println("Algo ha fallado")
        else -> println("Codigo desconocido, algo ha fallado")
    }

    val tallaDeZapatos = 41
    val mensaje2 = when(tallaDeZapatos){
        41,43 -> "Tenemos disponible"
        42,44 -> "Nos quedan pocos"
        45 -> "Lo siento, no hay disponibles"
        else -> "Estos zapatos solo estan disponibles en tallas 41, 42, 43, 44, 45"
    }
    println(mensaje2)
}

fun Bucles(){

    //  ### while
    var contador = 10
    while (contador > 0){
        println("El valor de contador es $contador")
        contador--
    }
    println("\n")

    //  ### do while
    do {
        println("Generando numero aleatorio...")
        val numeroaleatorio = (0..100).random()
        println("El numero aleatorio es $numeroaleatorio")
    }while (numeroaleatorio < 50)
    println("\n")

    //  ### for
    val listaDeFrutas = listOf("Manzana", "Pera", "Frambuesa", "Durazno")
    for (fruta in listaDeFrutas){
        println("Hoy voy a comerme la fruta: $fruta")
    }
    println("\n")

    //  ### forEach
    listaDeFrutas.forEach { fruta -> println("Hoy voy a sabrosearme la fruta: $fruta") }
    println("\n")

    //  ### map

    val caracteresDeFruta = listaDeFrutas.map { fruta -> fruta.length }
    println(caracteresDeFruta)
    println("\n")

    //  ### filter
    val listaFiltrada = caracteresDeFruta.filter { lengthDeFruta -> lengthDeFruta > 5 }
    println(listaFiltrada)

}

fun pruebaNull(){
    var nombre : String? = null
    try {
        nombre!!.length
    } catch (excepcion : NullPointerException){
        println("Ha ocurrido un error")
    } finally {     // Se ejecuta al final del try y catch
        println("Cerrando aplicacion")
    }
    println("\n")

    try {
        println( 2/0 )
        println("hello")
    } catch (e: ArithmeticException){
        println("Inside Catch Block")
        println(e.message)
    }
    println("\n")

    val nombre2 : String? = null
    val mensaje = nombre2?.plus(" es el nombre")?:"Es nulo"
    println(mensaje)

}

fun listas(){

    // ### Lista inmutable
    val listaDeNombres = listOf<String>()       // Lista inmutable
    val listaDeNombres2 = listOf("Juan","Enrique","Camila")
    println(listaDeNombres2)

    // ### Lista Mutable
    val listaVacia = mutableListOf<String>()    // Lista mutable
    listaVacia.add("Pepe")                      //Agregar item a mutableList
    println("Lista vacia es $listaVacia")

    // Obteniendo valor de la lista
    val  valorUsandoGet = listaVacia.get(0)
    println(valorUsandoGet)
    val valorUsandoOperador = listaVacia[0]
    println(valorUsandoOperador)

    // Obteniendo primer valor
    val primerValor = listaDeNombres2.first()   // Devuelve el primer elemento de la lista, se puede
                // poner parametro para que devuelva el primer elemento que cumpla con esa condicion
    val primerValorVacio = listaDeNombres.firstOrNull() // Si no encuentra elemento retorna String vacio
    println(primerValor)
    println(primerValorVacio)

    // Removiendo valor
    listaVacia.removeAt(0)
    println(listaVacia)

    // Agregando valor
    listaVacia.add("Pedro")
    listaVacia.add("Ana")
    println(listaVacia)
    listaVacia.removeIf { caracteres -> caracteres.length > 3 }
    println(listaVacia)

    /*
        ### Array - Estructura de datos que contiene lista de elementos agrupados
                    Kotlin los adecua dependiendo las necesidades
                    Cuenata con menos funciones que las Listas
                    Se recomienda listas, pero si el performance del calculo de miles de cosas es importante, usa Arrays
     */
    val myArray = arrayOf(1, 2, 3, 4)
    println(myArray)
    println(myArray.toList())

}

fun funcionesConListas(){
    val numeros = listOf(11, 18, 2, 49, 3, 69, 1, 24)
    println(numeros)

    // Ordenar menor a mayor
    val numerosSorted = numeros.sorted()
    println(numerosSorted)

    // Ordenar  mayor a menor
    val numerosSortedDecendiente = numeros.sortedDescending()
    println(numerosSortedDecendiente)

    // ordenar conforme a la condicion
    val ordenarPorMultiplos = numeros.sortedBy { numero -> numero < 50 }
    println(ordenarPorMultiplos)

    // Aleatorios de la lista
    val numerosAleatorios = numeros.shuffled()
    println(numerosAleatorios)

    // Invierte orden
    val numerosEnReversa = numeros.reversed()
    println(numerosEnReversa)

    // Crea una funcion que implementa para cada valor
    val mensajeDeNumeros = numeros.map { numero ->
        "Tunumero de loteria es $numero"
    }
    println(mensajeDeNumeros)

    // Filtra conforme a la condicion
    val numerosFiltrados = numeros.filter { numero -> numero < 20 }
    println(numerosFiltrados)
}

fun maps(){
    val edadDeSuperHeroes = mapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroes)

    val edadDeSuperHeroesMutable = mutableMapOf(
        "Ironman" to 35,
        "Spiderman" to 23,
        "Capitan America" to 99
    )
    println(edadDeSuperHeroesMutable)

    // Agrega key/value
    edadDeSuperHeroesMutable.put("Superman", 35)
    println(edadDeSuperHeroesMutable)

    // Agrega key/value
    edadDeSuperHeroesMutable["Wolverine"] = 45
    println(edadDeSuperHeroesMutable)

    //Obtiene valor
    val edadIronman = edadDeSuperHeroesMutable.get("Ironman")
    val edadWolverine = edadDeSuperHeroesMutable["Wolverine"]
    println("Ironman = $edadIronman  y   de Wolverine = $edadWolverine")

    // Remueve del map
    edadDeSuperHeroesMutable.remove("Ironman")
    println(edadDeSuperHeroesMutable)

    // obtiene todas la keys del map
    println(edadDeSuperHeroesMutable.keys)
    // obtiene todos los values del map
    println(edadDeSuperHeroesMutable.values)

    // Antes de hacer algo manualmente preguntate si exite una funcion de hacerlo

}

fun sets(){
    // No puede tener elementos repetidos, todo repetido será eliminado
    // Los sets NO tienen INDICE

    val vocalesRepetidas = setOf("a", "e", "i", "o", "u", "a", "e", "i", "o", "u")
    println(vocalesRepetidas)

    // Agregar valor,
    // El add se hace directo con el valor, ya que no tiene indice y no puede haber otro igual, sino no se agrega nada
    val numerosFavoritos = mutableSetOf(1,2,3,4)
    println(numerosFavoritos)
    numerosFavoritos.add(5)
    numerosFavoritos.add(5)
    println(numerosFavoritos)

    numerosFavoritos.remove(5) // en List se elimina dependiendo posicion, en Sets dependiendo de valor
    println(numerosFavoritos)

    val valorDeSet = numerosFavoritos.firstOrNull() { n -> n > 2 }
    println(valorDeSet)
}

fun funciones(){
    val freseAleatoria = "Crece grande y fuerte con Chocokrispis"
    println(randomCase(freseAleatoria))
    println(randomCase(freseAleatoria))
    println(randomCase(freseAleatoria))
    println(randomCase(freseAleatoria))
    println(randomCase(freseAleatoria))

    // Usando funcion de extension para la clase String
    val frase = "Hola Mundo"
    println(frase.randomcase2())
    println(frase.randomcase2())
    println(frase.randomcase2())
    println(frase.randomcase2())
    println(frase.randomcase2())

    // Parametros
    // Parametros nombrados
    imprimirNombre("Rodrigo", apellido = "Marquez");
    imprimirNombre("Juanito", "bananas", "Marquez");
    parametros("", doble = 3.5)

}
// funcion tipica
fun randomCase(frase :String) : String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0){    //residuo de dividir entre dos
        frase.toUpperCase()
    } else frase.toLowerCase()
}
// funcion de extencion
fun String.randomcase2() : String {
    val numeroAleatorio = 0..99
    val resultadoAleatorio = numeroAleatorio.random()
    return if (resultadoAleatorio.rem(2) == 0){    //residuo de dividir entre dos
        this.toUpperCase()
    } else this.toLowerCase()
}
// Parametros con un valor por defecto
fun imprimirNombre(nombre: String, segundoNombre: String = "", apellido: String) {
    println("Mi nombre es $nombre $segundoNombre y mi apellido es $apellido")
}
fun parametros(string: String, entero: Int = 2, doble: Double = 10.4){
    println("Excelente")
}

// Funciones anomimas
// Son objetos
fun lambda(){
    val myLambda : (String) -> Int = { valor -> valor.length }
    println(myLambda("Hola mundo"))

    // Se pueden pasar lambdas como parametro a otras funciones
    val saludos = listOf("Hello","Hola","Ciao")
    val longituddeSaludos = saludos.map(myLambda)
    println(longituddeSaludos)

    // Lambda de 3 parametros
    val operacion : (String, Int, Int) -> Int = { operacion: String, x: Int, y: Int ->
        when (operacion){
            "suma" -> x+y
            "resta" -> x-y
            else -> 0
        }
    }
    val suma1 = operacion("suma",10,2)
    val resta1 = operacion("resta",10,2)
    println("La suma es $suma1 \nLa resta es $resta1")
}

fun highOrderFunction(){
    // Funcion con lambda de parametro
    val largoDelValorInicial = superFuncion(valorInicial = "hola", block = {valor ->
        valor.length
    })
    // Se puede mover la lambda fuera del parentesis
    /*
        val largoDelValorInicial = superFuncion(valorInicial = "hola") { valor ->
        valor.length
        }
     */
    println(largoDelValorInicial)

    // Funcion con Lambda de retorno
    val lambdaDeInception: (Int) -> String = funcionInception("Juan")
    val stringDeInception: String = lambdaDeInception(2)
    println(stringDeInception)
}
fun superFuncion(valorInicial : String, block : (String) -> Int) : Int{
// block - sintaxis recomendada por kotlin para llamar las lamdas cuando ejecuta codigo,
// evert o listener cuando realizas una accion dependiendo de un evento
    return block(valorInicial)
}

fun funcionInception(nombre: String) : (Int) -> String {
    return { numero ->
        "Hola desde la lambda $nombre \nEl numero es $numero"

    }
}

fun scopeFunction() {
    // scope -> (es) ámbito, campo, alcance
    // Funciones que no implanta nueva capacidad tecnica, permite realizar ciertas operacions de forma mas concisa y legible en el contexto del objeto
    // Basicamente las funciones hacen lo  mismo, ejecutan un bloque de codigo en un objeto. Lo diferente
    // es como el objeto se vuelve disponible dentro del block (bloque de codigo) y el resultado de la expresion


    // LET - Permite ejecutar un codigo cunado nuestra variable nullable no es null
    println(" -- LET --")
    var nombre : String? = null
    nombre?.let { valor ->
        println("El nombre no es nulo es $valor")
    }
    nombre = "Juanito"
    nombre?.let { valor ->
        println("El nombre no es nulo es $nombre")
    }

    // WITH -  Permite acceder directamente a las propiedades de una variable que
    //          pasamos como parametro
    println("\n -- WITH --")
    val colores = listOf("Azul", "Amarillo", "Rojo")
    with(colores) {
        println("Nuestros colores son $this")
        println("El tamaño de la list es de $size")
    }

    // RUN - Ejecuta una serie de operaciones luego de declarar una variable
    println("\n -- RUN --")
    var moviles = mutableListOf("Samsung", "Iphone 1", "Iphone 2", "Xperia", "LG", "Google 1", "Google 2")
        .run {
            removeIf { movil -> movil.contains("1") }
            this                                            // Necesario devolver el valor
        }
    println(moviles)

    // APPLY - Permite realizar operaciones sobre una variable y devolver el valor automaticamente
    //          si lo combinamos con safe casat creamos una funcion apply segura
    //          Puede funcionar como el with pero acepta valores nulables
    println("\n -- APPLY --")
    moviles = mutableListOf("Samsung", "Iphone 1", "Iphone 2", "Xperia", "LG", "Google 1", "Google 2")
        .apply {
            removeIf { movil -> movil.contains("2") }
        }
    println(moviles)

    var numeros : MutableList<String>? = null
    numeros?.apply {                // Kotlin nos asegura que dentro del apply va ser segura con o sin valor asignado
        println("Nuestros numeros son: $this")
        println("La cantidad de numeros es $size")
    }
    numeros = mutableListOf("1", "2", "5.9", "8", "-33.45")
    numeros?.apply {                // Kotlin nos asegura que dentro del apply va ser segura con o sin valor asignado
        println("Nuestros numeros son: $this")
        println("La cantidad de numeros es $size")
    }
    // Se recomienda utilizar apply para convertir nullables a no nullables

    // ALSO - Nos permite obtener una varible, ejecutar un codigo por esa
    println("\n -- ALSO --")
    moviles = mutableListOf("Samsung", "Iphone 1", "Iphone 2", "Xperia", "LG", "Google 1", "Google 2")
        .also { lista ->
            println("El valor original de la lista es $lista")
            lista.removeIf { movil -> movil.contains("Google") }
        }.asReversed()
    println(moviles)
}
