package com.study.groking.part2.ch10

import com.study.groking.part2.Item

class ImplicitArgumentV1 {
    val validItemFields = setOf("price", "shipping", "tax", "quantity") // 문자열 검증을 위한 set
    val translations = mapOf("quantity" to "number")

    fun setFieldByName(cart: Map<String, Item>, name: String, field: String, value: Int): Map<String, Item> {
        if (!validItemFields.contains(field)) {
            throw IllegalArgumentException("Invalid item field: $field")
        }

        var innerField = field
        if (translations.containsKey(field)) {
            innerField = translations[field]!!
        }

        val item = cart[name]
        val newItem = itemSet(item, innerField, value)
        val newCart = cartSet(cart, name, newItem)
        return newCart
    }

    private fun itemSet(item: Item?, key: String, value: Int): Item {
        return when (key) {
            "price" -> Item(item!!.name, value, item.shipping, item.tax, item.quantity)
            "shipping" -> Item(item!!.name, item.price, value, item.tax, item.quantity)
            "tax" -> Item(item!!.name, item.price, item.shipping, value, item.quantity)
            "quantity" -> Item(item!!.name, item.price, item.shipping, item.tax, value)
            else -> item!!
        }
    }

    private fun cartSet(cart: Map<String, Item>, name: String, newItem: Item): Map<String, Item> {
        val newCart = cart.toMutableMap()
        newCart[name] = newItem
        return newCart
    }
}

fun main() {
    val implicitArgumentV1 = ImplicitArgumentV1()
    val cart = mapOf("item1" to Item("item1", 0, 0, 0, 0))
    implicitArgumentV1.setFieldByName(cart, "item1", "price", 1000)
    implicitArgumentV1.setFieldByName(cart, "item1", "shipping", 50)
    implicitArgumentV1.setFieldByName(cart, "item1", "quantity", 2)
    implicitArgumentV1.setFieldByName(cart, "item1", "tax", 100)
}