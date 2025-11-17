package com.study.groking.part1.ch4

class MegaMartV2 {

    private var shoppingItem = listOf<Item>() // Action
//    private var shoppingCartTotal: Int = 0 // Action

    // Action
    fun addItemToCart(name: String, price: Int) {
        shoppingItem = addItem(shoppingItem, Item(name, price))

        val total = calcTotal(shoppingItem)
        setCartTotalDom()
        updateShippingIcons(shoppingItem)
        updateTaxDom(total)
    }

    // Action
    fun updateShippingIcons(cart: List<Item>) {
        val buyButtons = getBuyButtonsDom()
        for (button in buyButtons) {
            val item = button.item
            val newCarts = addItem(cart, item)
            if (getFreeShipping(newCarts)) {
                button.showFreeShoppingIcon()
            } else {
                button.hideFreeShippingIcon()
            }
        }
    }

    // Action
    fun updateTaxDom(total: Int) {
        // 세금 반영을 위한 DOM 업데이트
        setTaxDom(calcTax(total))
    }

    private fun setCartTotalDom() {
        // 금액 합계 반영을 위한 DOM 업데이트
    }

    private fun getBuyButtonsDom(): List<BuyButton> {
        // 모든 구매버튼의 정보
        return listOf(
            BuyButton(Item("item1", 1000))
        )
    }

    // Calculation
    private fun addItem(cart: List<Item>, item: Item): List<Item> {
        return addElementLast(cart, item)
    }

    // Calculation
    private fun addElementLast(array: List<Item>, elem: Item): MutableList<Item> {
        val newArray = array.toMutableList()
        newArray.add(elem)
        return newArray
    }

    // Calculation
    private fun calcTotal(cart: List<Item>): Int {
        var total = 0
        for (item in cart) {
            total += item.price
        }
        return total
    }

    // Calculation
    private fun getFreeShipping(cart: List<Item>) = calcTotal(cart) >= 20

    // Calculation
    private fun calcTax(amount: Int) = amount * 0.1

    private fun setTaxDom(d: Double) {
        TODO("Not yet implemented")
    }

    data class Item(
        val name: String,
        val price: Int
    );

    data class BuyButton(
        val item: Item
    ) {
        fun showFreeShoppingIcon() {
            // 무료 배송 아이콘 표시
        }

        fun hideFreeShippingIcon() {
            // 무료 배송 아이콘 숨김
        }
    };
}
