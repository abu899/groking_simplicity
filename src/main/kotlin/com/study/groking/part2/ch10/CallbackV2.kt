package com.study.groking.part2.ch10

class CallbackV2 {

    fun operateOnArray(array: List<Food>, function: (CallbackV2, Food) -> Unit) {
        for (item in array) {
            function(this, item)
        }
    }

    fun operateOnArray(array: List<Dish>, function: (CallbackV2, Dish) -> Unit) {
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
    val callbackV2 = CallbackV2()

    val foods = listOf(Food("Pizza"), Food("Burger"))
    callbackV2.operateOnArray(foods, CallbackV2::cookAndEat)

    val dishes = listOf(Dish("Pasta"), Dish("Salad"))
    callbackV2.operateOnArray(dishes, CallbackV2::clean)
}
