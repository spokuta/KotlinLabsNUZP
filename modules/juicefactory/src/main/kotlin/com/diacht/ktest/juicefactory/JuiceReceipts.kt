package com.diacht.ktest.juicefactory

import com.diacht.ktest.Receipt
import com.diacht.ktest.Product
import com.diacht.ktest.ProductType
import java.util.concurrent.TimeUnit

// УВАГА: Тут немає жодних import com.diacht...JuiceFactoryProductType
// Вони не потрібні, бо ми в одному пакеті!

object JuiceReceipts {

    val orangeJuice = Receipt(
        products = listOf(
            Product(type = ORANGE, count = 1200),
            Product(type = WATER, count = 250),
            Product(type = SUGAR, count = 25)
        ),
        time = 8,
        timeUnit = TimeUnit.SECONDS,
        outProductType = ORANGE_JUICE,
        price = 50
    )

    val appleJuice = Receipt(
        products = listOf(
            Product(type = APPLE, count = 1500),
            Product(type = WATER, count = 350),
            Product(type = SUGAR, count = 35)
        ),
        time = 10,
        timeUnit = TimeUnit.SECONDS,
        outProductType = APPLE_JUICE,
        price = 30
    )

    val appleCarrotJuice = Receipt(
        products = listOf(
            Product(type = APPLE, count = 800),
            Product(type = CARROT, count = 700),
            Product(type = WATER, count = 340),
            Product(type = SUGAR, count = 40)
        ),
        time = 12,
        timeUnit = TimeUnit.SECONDS,
        outProductType = APPLE_CARROT_JUICE,
        price = 38
    )

    val tomatoCarrotJuice = Receipt(
        products = listOf(
            Product(type = TOMATO, count = 1000),
            Product(type = CARROT, count = 400),
            Product(type = WATER, count = 250),
            Product(type = SALT, count = 8)
        ),
        time = 11,
        timeUnit = TimeUnit.SECONDS,
        outProductType = TOMATO_CARROT_JUICE,
        price = 41
    )

    val tomatoJuice = Receipt(
        products = listOf(
            Product(type = TOMATO, count = 1300),
            Product(type = WATER, count = 200),
            Product(type = SALT, count = 6)
        ),
        time = 7,
        timeUnit = TimeUnit.SECONDS,
        outProductType = TOMATO_JUICE,
        price = 39
    )

    fun getReceipt(type: ProductType): Receipt? {
        return when(type) {
            ORANGE_JUICE -> orangeJuice
            APPLE_JUICE -> appleJuice
            APPLE_CARROT_JUICE -> appleCarrotJuice
            TOMATO_CARROT_JUICE -> tomatoCarrotJuice
            TOMATO_JUICE -> tomatoJuice
            else -> null
        }
    }
}