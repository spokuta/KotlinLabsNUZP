package com.diacht.ktest.juicefactory

import com.diacht.ktest.ProductType
// Import library types instead of defining custom ones
import com.diacht.ktest.WATER
import com.diacht.ktest.SUGAR

// --- Інгредієнти ---
object APPLE : ProductType()
object ORANGE : ProductType()
object CARROT : ProductType()
object TOMATO : ProductType()
object SALT : ProductType()

// REMOVED: object WATER : ProductType()
// REMOVED: object SUGAR : ProductType()

object NONE : ProductType()

// --- Готові соки ---
object ORANGE_JUICE : ProductType()
object APPLE_JUICE : ProductType()
object APPLE_CARROT_JUICE : ProductType()
object TOMATO_CARROT_JUICE : ProductType()
object TOMATO_JUICE : ProductType()