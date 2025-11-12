package com.study.groking.part1.ch4

class MegaMartV0 {

    private val shoppingCart = mutableListOf<Cart>()
    private var shoppingCartTotal: Int = 0


    fun addItemToCart(
        name: String,
        price: Int
    ) {
        val item = Cart(name, price)
        shoppingCart.add(item)
    }

    fun calcCartTotal() {
        for (cart in shoppingCart) {
            shoppingCartTotal += cart.price
        }

        setCartTotalDom()
        updateShippingIcons()
        updateTaxDom()
    }

    private fun updateShippingIcons() {
        val buyButtons = getBuyButtonsDom()
        for (button in buyButtons) {
            val item = button.item
            if (item.price + shoppingCartTotal >= 20) {
                button.showFreeShoppingIcon()
            } else {
                button.hideFreeShippingIcon()
            }
        }
    }

    private fun getBuyButtonsDom(): List<BuyButton> {
        // 모든 구매버튼의 정보
        return listOf(
            BuyButton(Item(1000))
        )
    }

    private fun setCartTotalDom() {
        // 금액 합계 반영을 위한 DOM 업데이트
    }

    private fun updateTaxDom() {
        // 세금 반영을 위한 DOM 업데이트
        setTaxDom(shoppingCartTotal * 0.1)
    }

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
