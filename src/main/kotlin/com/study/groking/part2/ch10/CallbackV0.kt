package com.study.groking.part2.ch10

class CallbackV0 {

    fun cooksAndEatFoods() {
        val foods = listOf(Food("Pizza"), Food("Burger"))
        for (food in foods) {
            cook(food)
            eat(food)
        }
    }

    fun cleanDishes() {
        val dishes = listOf(Dish("Pasta"), Dish("Salad"))
        for (dish in dishes) {
            wash(dish)
            dry(dish)
            putAway(dish)
        }
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
    val callbackV0 = CallbackV0()
    callbackV0.cooksAndEatFoods()
    callbackV0.cleanDishes()
}