package com.diacht.ktest.juicefactory

import com.diacht.ktest.FactoryItf
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType

// УВАГА: Ми НЕ імпортуємо JuiceFactoryProductType, бо ми вже в цьому пакеті.
// Об'єкти APPLE, ORANGE_JUICE, NONE доступні автоматично.

class JuiceFactory : FactoryItf() {
    private val storage = JuiceStorage()
    private val machine = JuicePress(storage)

    override fun loadProducts(productsFromSupplier: List<Product>) {
        productsFromSupplier.forEach { product ->
            storage.addProduct(product)
        }
    }

    fun getProductWithBiggestCalorie(): Product {
        // Карта калорійності
        val calories = mapOf(
            APPLE_CARROT_JUICE to 150,
            APPLE_JUICE to 140,
            ORANGE_JUICE to 120,
            TOMATO_CARROT_JUICE to 80,
            TOMATO_JUICE to 60
        )

        val maxEntry = calories.maxByOrNull { it.value }

        return if (maxEntry != null) {
            Product(maxEntry.key, 1)
        } else {
            // Тепер NONE береться з вашого файлу JuiceFactoryProductType
            Product(NONE, 0)
        }
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
                    } catch (e: Exception) {
                        // println("Failed to make $type: ${e.message}")
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
    }
}