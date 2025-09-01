package smarthome

// =========================
// Clase base SmartDevice
// =========================
open class SmartDevice(
    val name: String,
    val category: String
) {
    var deviceType: String = "Generic"
    var deviceStatus: String = "off"
    var deviceTurnOnCount: Int = 0

    fun turnOn() {
        if (deviceStatus != "on") {
            deviceStatus = "on"
            deviceTurnOnCount++
            println("$name está encendido.")
        }
    }

    fun turnOff() {
        if (deviceStatus != "off") {
            deviceStatus = "off"
            println("$name está apagado.")
        }
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType, status: $deviceStatus, turned on $deviceTurnOnCount veces")
    }
}

// =========================
// Clase SmartTvDevice
// =========================
class SmartTvDevice(name: String, category: String) : SmartDevice(name, category) {
    var volume: Int = 50
    var channel: Int = 1

    init {
        deviceType = "Smart TV"
    }

    fun increaseVolume() {
        if (deviceStatus == "on") {
            volume++
            println("Volumen de $name: $volume")
        }
    }

    fun decreaseVolume() {
        if (deviceStatus == "on" && volume > 0) {
            volume--
            println("Volumen de $name: $volume")
        }
    }

    fun nextChannel() {
        if (deviceStatus == "on") {
            channel++
            println("Canal actual en $name: $channel")
        }
    }

    fun previousChannel() {
        if (deviceStatus == "on" && channel > 1) {
            channel--
            println("Canal actual en $name: $channel")
        }
    }
}

// =========================
// Clase SmartLightDevice
// =========================
class SmartLightDevice(name: String, category: String) : SmartDevice(name, category) {
    var brightness: Int = 100

    init {
        deviceType = "Smart Light"
    }

    fun increaseBrightness() {
        if (deviceStatus == "on" && brightness < 100) {
            brightness += 10
            println("Brillo de $name: $brightness%")
        }
    }

    fun decreaseBrightness() {
        if (deviceStatus == "on" && brightness > 0) {
            brightness -= 10
            println("Brillo de $name: $brightness%")
        }
    }
}

// =========================
// Clase SmartHome
// =========================
class SmartHome(
    val tv: SmartTvDevice,
    val light: SmartLightDevice
) {
    fun decreaseTvVolume() {
        if (tv.deviceStatus == "on") tv.decreaseVolume()
        else println("La TV está apagada.")
    }

    fun changeTvChannelToPrevious() {
        if (tv.deviceStatus == "on") tv.previousChannel()
        else println("La TV está apagada.")
    }

    fun decreaseLightBrightness() {
        if (light.deviceStatus == "on") light.decreaseBrightness()
        else println("La luz está apagada.")
    }

    fun printSmartTvInfo() {
        tv.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        light.printDeviceInfo()
    }
}

// =========================
// Función main
// =========================
fun main() {
    val tv = SmartTvDevice("Samsung QLED", "Entretenimiento")
    val light = SmartLightDevice("Philips Hue", "Iluminación")

    val home = SmartHome(tv, light)

    // Encendemos dispositivos
    tv.turnOn()
    light.turnOn()

    // Probar métodos de SmartHome
    println("\n--- Probando SmartHome ---")
    home.decreaseTvVolume()
    home.changeTvChannelToPrevious()
    home.decreaseLightBrightness()

    println("\n--- Info de dispositivos ---")
    home.printSmartTvInfo()
    home.printSmartLightInfo()
}