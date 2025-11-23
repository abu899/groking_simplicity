package com.study.groking.part2.ch10

import com.study.groking.part2.Item

class ImplicitArgumentV0 {

    fun setPriceByName(cart: Map<String, Item>, name: String, price: Int): Map<String, Item> {
        val item = cart[name]
        val newItem = itemSet(item, "price", price)
        val newCart = cartSet(cart, name, newItem)
        return newCart
    }

    fun setShippingByName(cart: Map<String, Item>, name: String, shipping: Int): Map<String, Item> {
        val item = cart[name]
        val newItem = itemSet(item, "shipping", shipping)
        val newCart = cartSet(cart, name, newItem)
        return newCart
    }

    fun setQuantityByName(cart: Map<String, Item>, name: String, quantity: Int): Map<String, Item> {
        val item = cart[name]
        val newItem = itemSet(item, "quantity", quantity)
        val newCart = cartSet(cart, name, newItem)
        return newCart
    }

    fun setTaxByName(cart: Map<String, Item>, name: String, tax: Int): Map<String, Item> {
        val item = cart[name]
        val newItem = itemSet(item, "tax", tax)
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
    val implicitArgumentV0 = ImplicitArgumentV0()
    val cart = mapOf("item1" to Item("item1", 0, 0, 0, 0))
    implicitArgumentV0.setPriceByName(cart, "item1", 1000)
    implicitArgumentV0.setShippingByName(cart, "item1", 100)
    implicitArgumentV0.setQuantityByName(cart, "item1", 2)
    implicitArgumentV0.setTaxByName(cart, "item1", 10)
}