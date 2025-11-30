package com.diacht.ktest.juicefactory

import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType

// --- УВАГА: Рядок імпорту видалено, бо ми вже в цьому пакеті ---

class JuiceFactory : FactoryItf() {
    private val storage = JuiceStorage()
    private val machine = JuicePress(storage)

    // Додаємо змінну cash, якої немає в старій версії бібліотеки
    private var cash = 0

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { product ->
            // Конвертуємо чужі інгредієнти у свої
            val myType = mapIngredient(product.type)
            storage.addProduct(Product(myType, product.count))
        }
    }

    private fun mapIngredient(incomingType: ProductType): ProductType {
        val name = incomingType::class.simpleName ?: incomingType.toString()
        return when (name) {
            "WATER" -> WATER
            "SUGAR" -> SUGAR
            "APPLE" -> APPLE
            "ORANGE" -> ORANGE
            "CARROT" -> CARROT
            "TOMATO" -> TOMATO
            "SALT" -> SALT
            else -> incomingType
        }
    }

    // Прибрали override, щоб працювало на старій версії лаби
    fun getProductWithBiggestCalorie(): Product {
        val calories = mapOf(
            APPLE_CARROT_JUICE to 150,
            APPLE_JUICE to 140,
            ORANGE_JUICE to 120,
            TOMATO_CARROT_JUICE to 80,
            TOMATO_JUICE to 60
        )
        val maxEntry = calories.maxByOrNull { it.value }

        // Використовуємо наш локальний NONE
        return if (maxEntry != null) Product(maxEntry.key, 1) else Product(NONE, 0)
    }

    override fun order(order: List<Pair<ProductType, Int>>): List<Product> {
        val resultList = mutableListOf<Product>()

        for ((type, count) in order) {
            val receipt = JuiceReceipts.getReceipt(type)
            if (receipt != null) {
                repeat(count) {
                    try {
                        receipt.products.forEach { ingredient ->
                            storage.getProduct(ingredient.type, ingredient.count)
                        }
                        resultList.add(Product(type = receipt.outProductType, count = 1))

                        // Додаємо гроші
                        cash += receipt.price.toInt()

                    } catch (e: Exception) {
                        // Не вдалося приготувати
                    }
                }
            }
        }
        return resultList
    }

    override fun getLeftovers(): List<Product> {
        return storage.getLeftovers()
    }

    override fun resetSimulation() {
        storage.resetSimulation()
        cash = 0
    }
}