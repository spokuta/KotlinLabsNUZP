package lab1

fun main() {
    // Викликаємо функцію seed (тепер вона повертає рядок)
    println("GitHub username: ${seed()}")

    // --- Кошеня №1 ---
    val name1 = "Мурчик"
    val age1 = 10
    val weight1 = 5.5
    val image1 = "🐱"
    println("Кошеня №1: $name1, вік: $age1, вага: $weight1 $image1")

    // --- Кошеня №2 ---
    val name2 = "Барсик"
    val age2 = 3
    val weight2 = 4.0
    val image2 = "🐈"
    println("Кошеня №2: $name2, вік: $age2, вага: $weight2 $image2")

    // --- Кошеня №3 (Ваше завдання) ---
    val name3 = "Рудий"
    val age3 = 6
    val weight3 = 8.2
    val image3 = "\uD83D\uDC06"

    println("Кошеня №3: $name3, вік: $age3, вага: $weight3 $image3")
}

// ВИПРАВЛЕНО: Функція винесена з main і повертає String
fun seed(): String {
    return "spokuta"
}