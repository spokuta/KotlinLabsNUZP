package lab1

fun main() {
    // Виклик функції seed з вашим нікнеймом
    seed("spokuta")

    // --- Кошеня №1 (приклад) ---
    val name1 = "Мурчик"
    val age1 = 10
    val weight1 = 5.5
    val image1 = "🐱"
    println("Кошеня №1: $name1, вік: $age1, вага: $weight1 $image1")

    // --- Кошеня №2 (приклад) ---
    val name2 = "Барсик"
    val age2 = 3
    val weight2 = 4.0
    val image2 = "🐈"
    println("Кошеня №2: $name2, вік: $age2, вага: $weight2 $image2")

    // --- Кошеня №3 (Ваше завдання) ---
    val name3 = "Рудий"
    val age3 = 6         // Це число (Int), без лапок!
    val weight3 = 8.2    // Це дробове число (Double), без лапок!
    val image3 = "\uD83D\uDC06" // Юнікод картинка

    println("Кошеня №3: $name3, вік: $age3, вага: $weight3 $image3")
}

// Функція seed, яку вимагає тест
fun seed(username: String) {
    println("GitHub username: $username")
}