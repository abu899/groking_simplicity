package com.study.groking.part1.ch4

class MegaMartV1 {

    private var shoppingCart = mutableListOf<Cart>() // Action
    private var shoppingCartTotal: Int = 0 // Action

    // Action
    fun addItemToCart(name: String, price: Int) {
        shoppingCart = addItem(shoppingCart, name, price)
        calcCartTotal()
    }

    // Action
    fun calcCartTotal() {
        shoppingCartTotal = calcTotal(shoppingCart)
        setCartTotalDom()
        updateShippingIcons()
        updateTaxDom()
    }

    // Action
    fun updateTaxDom() {
        // 세금 반영을 위한 DOM 업데이트
        setTaxDom(calcTax(shoppingCartTotal))
    }

    // Action
    fun updateShippingIcons() {
        val buyButtons = getBuyButtonsDom()
        for (button in buyButtons) {
            val item = button.item
            if (getFreeShipping(item.price, shoppingCartTotal)) {
                button.showFreeShoppingIcon()
            } else {
                button.hideFreeShippingIcon()
            }
        }
    }

    // Calculation
    private fun addItem(carts: List<Cart>, name: String, price: Int): MutableList<Cart> {
        val item = Cart(name, price)
        val newCart = carts.toMutableList()
        newCart.add(item)
        return newCart
    }

    // Calculation
    private fun calcTotal(carts: List<Cart>): Int {
        var total = 0
        for (cart in carts) {
            total += cart.price
        }
        return total
    }

    private fun setCartTotalDom() {
        // 금액 합계 반영을 위한 DOM 업데이트
    }

    // Calculation
    private fun getFreeShipping(itemPrice: Int, total: Int) = itemPrice + total >= 20

    private fun getBuyButtonsDom(): List<BuyButton> {
        // 모든 구매버튼의 정보
        return listOf(
            BuyButton(Item(1000))
        )
    }

    // Calculation
    private fun calcTax(amount: Int) = amount * 0.1

    private fun setTaxDom(d: Double) {
        TODO("Not yet implemented")
    }

    data class Cart(
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

    data class Item(
        val price: Int
    )
}
