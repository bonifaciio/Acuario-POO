package zoologico

// =========================
// CLASE BASE ANIMAL
// =========================
open class Animal(
    open var nombre: String,
    open var edad: Int,
    open var habitat: String
) {
    open fun mostrarInfo() {
        println("Animal: $nombre | Edad: $edad años | Hábitat: $habitat")
    }
}

// =========================
// SUBCLASE LEON
// =========================
class Leon(
    nombre: String,
    edad: Int,
    habitat: String,
    var melena: Boolean
) : Animal(nombre, edad, habitat) {
    override fun mostrarInfo() {
        println("León: $nombre | Edad: $edad años | Hábitat: $habitat | Melena: ${if (melena) "Sí" else "No"}")
    }
}

// =========================
// CLASE ABSTRACTA EMPLEADO
// =========================
abstract class Empleado {
    abstract val nombre: String
    abstract val puesto: String
}

// =========================
// INTERFAZ AccionEmpleado
// =========================
interface AccionEmpleado {
    fun alimentar(animal: Animal)
}

// =========================
// IMPLEMENTACIONES DE EMPLEADO
// =========================
class Cuidador(override val nombre: String) : Empleado(), AccionEmpleado {
    override val puesto: String = "Cuidador"

    override fun alimentar(animal: Animal) {
        println("$puesto $nombre alimenta al animal ${animal.nombre}.")
    }
}

class Veterinario(override val nombre: String) : Empleado(), AccionEmpleado {
    override val puesto: String = "Veterinario"

    override fun alimentar(animal: Animal) {
        println("$puesto $nombre revisa y alimenta al animal ${animal.nombre}.")
    }
}

// =========================
// FUNCIONES DEMO
// =========================
fun demoZoologico() {
    val leon = Leon("Simba", 5, "Sabana", melena = true)
    val mono = Animal("George", 3, "Selva")
    val pinguino = Animal("Pingu", 2, "Antártida")

    leon.mostrarInfo()
    mono.mostrarInfo()
    pinguino.mostrarInfo()

    val cuidador = Cuidador("Luis")
    val veterinario = Veterinario("María")

    cuidador.alimentar(leon)
    veterinario.alimentar(pinguino)
}

// =========================
// FUNCIÓN MAIN
// =========================
fun main() {
    println("===== DEMO ZOOLÓGICO =====")
    demoZoologico()
    println("\n===== FIN DEL LABORATORIO =====")
}