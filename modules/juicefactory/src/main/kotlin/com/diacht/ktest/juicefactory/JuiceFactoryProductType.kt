package com.diacht.ktest.juicefactory

import com.diacht.ktest.ProductType

// --- Інгредієнти ---
object APPLE : ProductType()
object ORANGE : ProductType()
object CARROT : ProductType()
object TOMATO : ProductType()
object SALT : ProductType()

// --- Створюємо "свої" воду та цукор, щоб не залежати від помилок імпорту ---
object WATER : ProductType()
object SUGAR : ProductType()
object NONE : ProductType()

// --- Готові соки ---
object ORANGE_JUICE : ProductType()
object APPLE_JUICE : ProductType()
object APPLE_CARROT_JUICE : ProductType()
object TOMATO_CARROT_JUICE : ProductType()
object TOMATO_JUICE : ProductType()