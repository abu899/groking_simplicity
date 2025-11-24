package com.study.groking.part2.ch10

class CallbackV1 {

    fun cooksAndEatArray(array: List<Food>) {
        for (item in array) {
            cookAndEat(item)
        }
    }

    fun cleanArray(array: List<Dish>) {
        for (item in array) {
            clean(item)
        }
    }

    private fun cookAndEat(item: Food) {
        cook(item)
        eat(item)
    }

    private fun clean(item: Dish) {
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
    val callbackV1 = CallbackV1()
    callbackV1.cooksAndEatArray(listOf(Food("Pizza"), Food("Burger")))
    callbackV1.cleanArray(listOf(Dish("Pasta"), Dish("Salad")))
}
