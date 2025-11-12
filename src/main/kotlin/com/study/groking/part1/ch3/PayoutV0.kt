package com.study.groking.part1.ch3

class PayoutV0 {

    fun figurePayout(affiliate: Affiliate) {
        val owed = affiliate.sales * affiliate.commission;
        if (owed > 100) {
            sendPayout(affiliate.bankCode, owed) // Action
        }
    }

    fun affiliatePayouts(affiliates: List<Affiliate>) {
        for (affiliate in affiliates) {
            figurePayout(affiliate)
        }
    }

    private fun sendPayout(bankCode: String, owed: Int) {
        TODO("Not yet implemented")
    }

    data class Affiliate(
        val sales: Int,
        val commission: Int,
        val bankCode: String
    );
}

fun main() {
    val payouts = PayoutV0()
    val affiliates = listOf(
        PayoutV0.Affiliate(sales = 50, commission = 3, bankCode = "BANK001"),
        PayoutV0.Affiliate(sales = 200, commission = 1, bankCode = "BANK002"),
        PayoutV0.Affiliate(sales = 150, commission = 1, bankCode = "BANK003"),
    )
    payouts.affiliatePayouts(affiliates)
}