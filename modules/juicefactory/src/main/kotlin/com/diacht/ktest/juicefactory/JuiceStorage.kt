package com.diacht.ktest.juicefactory

import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import com.diacht.ktest.Storage

class JuiceStorage : Storage {
    // Карта: Тип продукту -> Кількість
    private val inventory = mutableMapOf<ProductType, Int>()

    override fun addProduct(product: Product) {
        val currentCount = inventory.getOrDefault(product.type, 0)
        inventory[product.type] = currentCount + product.count
    }

    override fun checkProductCount(type: ProductType): Int {
        return inventory.getOrDefault(type, 0)
    }

    override fun getProduct(productType: ProductType, count: Int): Product {
        val currentCount = inventory.getOrDefault(productType, 0)
        if (currentCount < count) {
            throw IllegalStateException("Not enough product: $productType. Required: $count, Available: $currentCount")
        }
        inventory[productType] = currentCount - count
        return Product(type = productType, count = count)
    }

    override fun getLeftovers(): List<Product> {
        return inventory.map { (type, count) ->
            Product(type = type, count = count)
        }
    }

    override fun resetSimulation() {
        inventory.clear()
    }
}