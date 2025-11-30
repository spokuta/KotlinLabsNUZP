package com.diacht.ktest.juicefactory

import com.diacht.ktest.Machine
import com.diacht.ktest.Storage

// Машина обов'язково приймає Storage у конструктор
class JuicePress(storage: Storage) : Machine(storage) {
    // Логіка виготовлення реалізована в базовому класі або у Factory,
    // тут достатньо просто наслідування.
}