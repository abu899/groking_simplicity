package com.study.groking.part1.ch8

class Pattern1_V2 {

    fun freeTieClip(cart: List<Item>): List<Item> {
        var hasTie = isInCart(cart, "tie");
        var hasTieClip = isInCart(cart, "tie clip");
        if (hasTie && !hasTieClip) {
            var tieClip = Item("tie clip", 0)
            return addItem(cart, tieClip)
        }

        return cart
    }

    fun removeItemByName(cart: List<Item>, name: String): List<Item> {
        val idx: Int? = indexOfItem(cart, name)

        if (idx != null) {
            return removeItem(cart, idx)
        }
        return cart
    }

    private fun isInCart(cart: List<Item>, name: String): Boolean {
        indexOfItem(cart, name)?.let {
            return true
        }
        return false
    }

    private fun indexOfItem(cart: List<Item>, name: String): Int? {
        var idx: Int? = null
        for ((i, item) in cart.withIndex()) {
            if (item.name == name) {
                idx = i
                break
            }
        }
        return idx
    }

    private fun addItem(cart: List<Item>, tieClip: Item): List<Item> {
        return addElementLast(cart, tieClip)
    }

    private fun addElementLast(array: List<Item>, elem: Item): MutableList<Item> {
        val newArray = array.toMutableList()
        newArray.add(elem)
        return newArray
    }

    private fun removeItem(cart: List<Item>, idx: Int): List<Item> {
        val newArray = cart.toMutableList()
        newArray.removeAt(idx)
        return newArray
    }

    data class Item(
        val name: String,
        val price: Int
    );
}