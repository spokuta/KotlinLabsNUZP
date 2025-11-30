import com.diacht.ktest.compose.startTestUi
import org.example.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.tanh
import com.diacht.ktest.juicefactory.JuiceFactory
import com.diacht.ktest.FactoryItf

fun seed(): String = "spokuta"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

fun getSimulationObject(): FactoryItf {
    return JuiceFactory()
}

fun main() {
    startTestUi(
        seed = seed(),
        labNumber = labNumber()
    )
}