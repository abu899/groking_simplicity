package com.study.groking.part2.ch10

import kotlin.reflect.KFunction2

class CallbackV3 {

    fun forEach(array: List<Any>, function: KFunction2<CallbackV3, Any, Unit>) {
        for (item in array) {
            function(this, item)
        }
    }

    fun cookAndEat(item: Food) {
        cook(item)
        eat(item)
    }

    fun clean(item: Dish) {
        wash(item)
        dry(item)
        putAway(item)
    }

    private fun cook(food: Food) {
    }

    private fun eat(food: Food) {
    }

    private fun wash(dish: Dish) {
    }

    private fun dry(dish: Dish) {
    }

    private fun putAway(dish: Dish) {
    }
}

fun main() {
    val callbackV3 = CallbackV3()

    val foods = listOf(Food("Pizza"), Food("Burger"))
//    callbackV3.forEach(foods, callbackV3::cookAndEat)

    val dishes = listOf(Dish("Pasta"), Dish("Salad"))
//    callbackV3.forEach(dishes, CallbackV3::clean)
}
