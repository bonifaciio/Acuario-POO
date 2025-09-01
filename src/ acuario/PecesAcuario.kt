package acuario

// Clase abstracta
abstract class Pez {
    abstract val color: String
}

// Interfaz que define la acción comer()
interface AccionPez {
    fun comer()
}

// Tiburón hereda de Pez e implementa AccionPez
class Tiburon : Pez(), AccionPez {
    override val color: String = "gris"

    override fun comer() {
        println("cazar y comer peces")
    }
}

// PezPayaso hereda de Pez e implementa AccionPez
class PezPayaso : Pez(), AccionPez {
    override val color: String = "dorado"

    override fun comer() {
        println("comer algas")
    }
}