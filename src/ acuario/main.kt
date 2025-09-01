package acuario

fun construirAcuario() {
    val miAcuario = Acuario(ancho = 25, largo = 25, alto = 40)
    miAcuario.imprimirTamano()

    val miTorre = TanqueTorre(diametro = 25, alto = 40)
    miTorre.imprimirTamano()
}

fun crearPeces() {
    val tiburon = Tiburon()
    val pezPayaso = PezPayaso()

    println("Tiburón de color: ${tiburon.color}")
    tiburon.comer()

    println("Pez Payaso de color: ${pezPayaso.color}")
    pezPayaso.comer()
}

fun main() {
    construirAcuario()
    println("----- Creando peces -----")
    crearPeces()
}