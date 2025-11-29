import com.diacht.ktest.compose.startTestUi
import me.tetiana.helloworld.BuildConfig
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.pow
import kotlin.math.tanh

fun seed(): String = "spokuta"

fun labNumber(): Int = BuildConfig.LAB_NUMBER

// Завдання №1
// Формула: tanh(x0^3 + x1^3 + x2^3 + x3^3 + x4^3)
fun iCalculate(
    x0: Int = 53,
    x1: Int = 82,
    x2: Int = 110,
    x3: Int = -102,
    x4: Int = -114
): Double {
    // Підносимо до куба (3-го степеня), конвертуємо в Double, щоб працювала функція pow і tanh
    val sum = x0.toDouble().pow(3) +
            x1.toDouble().pow(3) +
            x2.toDouble().pow(3) +
            x3.toDouble().pow(3) +
            x4.toDouble().pow(3)

    return tanh(sum)
}

// Завдання №2
// Формула: tanh(max(|x0|, |x1|, |x2|))
fun dCalculate(
    x0: Double = -58.32,
    x1: Double = -23.4,
    x2: Double = -67.34
): Double {
    // Знаходимо максимальне серед абсолютних значень (модулів)
    val maxVal = max(abs(x0), max(abs(x1), abs(x2)))
    return tanh(maxVal)
}

// Завдання №3
// Порівняння символів на парних позиціях (0, 2, 4...). T та J вважаються однаковими.
fun strCalculate(x0: String, x1: String): Int {
    var mismatches = 0 // Лічильник розбіжностей

    // Проходимо по рядку з кроком 2 (step 2), щоб брати тільки парні індекси
    for (i in 0 until x0.length step 2) {
        val char1 = x0[i]
        val char2 = x1[i]

        // Перевіряємо, чи символи "однакові" за умовою задачі
        val areEqual = (char1 == char2) ||
                (char1 == 'T' && char2 == 'J') ||
                (char1 == 'J' && char2 == 'T')

        if (!areEqual) {
            mismatches++
        }
    }
    return mismatches
}

fun main(args: Array<String>) {
    println("Лабораторна робота №${labNumber()} користувача ${seed()}")
    startTestUi(seed(), labNumber())
}