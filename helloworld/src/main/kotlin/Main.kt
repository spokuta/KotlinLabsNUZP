import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.tanh

// Імпорти вашої фабрики
import com.diacht.ktest.juicefactory.JuiceFactory
import com.diacht.ktest.FactoryItf

fun seed(): String = "spokuta" // Ваш нік

fun labNumber(): Int = BuildConfig.LAB_NUMBER

// Система знайде цю функцію сама, тому що вона має правильну назву
fun getSimulationObject(): FactoryItf {
    return JuiceFactory()
}

fun main() {
    // Передаємо тільки 2 аргументи, як вимагає помилка
    startTestUi(
        seed = seed(),
        labNumber = labNumber()
    )
}