package com.study.groking.part1.ch8

class Pattern1_V1 {

    fun freeTieClip(cart: List<Item>): List<Item> {
        var hasTie = false;
        var hasTieClip = false;
        for (item in cart) {
            if(item.name == "tie") {
                hasTie = true
            }
            if(item.name == "tie clip") {
                hasTieClip = true
            }
        }

        if(hasTie && !hasTieClip) {
            var tieClip = Item("tie clip", 0)
            return addItem(cart, tieClip)
        }

        return cart
    }

    fun removeItemByName(cart: List<Item>, name: String): List<Item> {
        var idx: Int? = null
        for ((i, item) in cart.withIndex()) {
            if (item.name == name) {
                idx = i
                break
            }
        }

        if (idx != null) {
            return removeItem(cart, idx)
        }
        return cart
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