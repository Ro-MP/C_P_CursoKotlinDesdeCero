//Declarando valores de las respuestas
const val RESPUESTA_AFIRMATIVA = "✅"
const val RESPUESTA_NEGATIVA = "❌"
const val RESPUESTA_DUDOSA = "?"

//Uniendo las respuestas con sus valores
val respuestas = mapOf(
    "Si" to RESPUESTA_AFIRMATIVA,
    "Es verdad" to RESPUESTA_AFIRMATIVA,
    "Totally" to RESPUESTA_AFIRMATIVA,
    "Undoubtedly" to RESPUESTA_AFIRMATIVA,
    "Ask in an other moment" to RESPUESTA_DUDOSA,
    "I can't say you in this moment" to RESPUESTA_DUDOSA,
    "Maybe yes, or maybe not" to RESPUESTA_DUDOSA,
    "It's not going to happen" to RESPUESTA_NEGATIVA,
    "Do not count on it" to RESPUESTA_NEGATIVA,
    "Definitely not" to RESPUESTA_NEGATIVA,
    "I don't believe it" to RESPUESTA_NEGATIVA
)


fun main(args: Array<String>) {

    println("Hola soy tu bola 8 mágica en KT. " +
            "¿Cual de estas opciones deseas realizar?")
    println(" 1. Realizar una pregunta\n" +
            " 2. Revisar todas las respuestas\n" +
            " 3. Salir")

    val valorIngresado = readLine()

    // readline retorna valor nullable. por lo que se ocupan valores string,
    // ya que si se quiere convertir a entero dará un error
    when(valorIngresado) {
        "1" -> realizarPregunta()
        "2" -> mostrarRespuestas()
        "3" -> salir()
        else -> mostrarError()
    }


}

fun mostrarError() {
    println("\nUy! Elegiste opcion no valida \nIntenta de nuevo")
}

fun salir() {
    println("Hasta Luego!")
}

fun mostrarRespuestas() {
    println("Selecciona una opcion")
    println(" 1. Revisar todas las respuestas\n" +
            " 2. Revisar solo las respuestas afirmativas\n" +
            " 2. Revisar solo las respuestas dudosas\n" +
            " 3. Revisar solo las respuestas negativas")

    val opcionIngresada = readLine()
    when(opcionIngresada) {
        "1" -> mostrarRespuestasPorTipo()
        "2" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_AFIRMATIVA)
        "3" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        "4" -> mostrarRespuestasPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        else -> println("Respuesta no valida. Adios")
    }
}

fun mostrarRespuestasPorTipo(tipoDeRespuesta: String = "TODOS"){
    when(tipoDeRespuesta) {
        "TODOS" -> respuestas.keys.forEach { respuesta -> println(respuesta) }
        RESPUESTA_AFIRMATIVA -> respuestas.filterValues { it == RESPUESTA_AFIRMATIVA }
            .also { println(it.keys) }
        RESPUESTA_NEGATIVA -> respuestas.filterValues { it == RESPUESTA_NEGATIVA }
            .also { println(it.keys) }
        RESPUESTA_DUDOSA -> respuestas.filterValues { it == RESPUESTA_DUDOSA }
            .also { println(it.keys) }
    }

}

fun realizarPregunta(){
    println("Que pregunta deseas realizar")
    readLine()
    println("Asi que esa era tu pregunta... La respuesta a eso es: ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}