package com.study.groking.part1.ch3

class SendCouponService {
    private fun subCouponRank(subscriber: Subscriber): String {
        if (subscriber.recommendCount >= 10) {
            return "best"
        }
        return "good"
    }

    fun selectCouponsByRank(coupons: List<Coupon>, rank: String): List<String> {
        val ret = mutableListOf<String>()

        for (coupon in coupons) {
            if (coupon.rank == rank) {
                ret.add(coupon.code)
            }
        }
        return ret
    }

    fun emailsForSubscriber(subscribers: List<Subscriber>, bests: List<String>, goods: List<String>): List<Message> {
        val messages = mutableListOf<Message>()
        for (subscriber in subscribers) {
            val message = emailForSubscriber(subscriber, bests, goods)
            messages.add(message)
        }
        return messages
    }

    private fun emailForSubscriber(subscriber: Subscriber, bests: List<String>, goods: List<String>): Message {
        val rank = subCouponRank(subscriber)
        if (rank == "best") {
            return Message(
                from = "newsletters@Coupondog.co",
                to = subscriber.email,
                subject = "Your best coupon",
                body = "Here are the best coupons " + bests.joinToString()
            )
        }
        return Message(
            from = "newsletters@Coupondog.co",
            to = subscriber.email,
            subject = "Your good coupon",
            body = "Here are the good coupons " + goods.joinToString()
        )
    }
}


fun fetchCouponsFromDB(): List<Coupon> {
    return listOf(
        Coupon("MAYDISCOUNT", "good"),
        Coupon("10PERCENT", "bad"),
        Coupon("PROMOTION45", "best"),
        Coupon("IHEARTYOU", "bad"),
        Coupon("GETDEAL", "best"),
        Coupon("ILIKEDISCOUNT", "good")
    )
}

fun fetchSubscribersFromDB(): List<Subscriber> {
    return listOf(
        Subscriber("john@coldMail.com", 2),
        Subscriber("sam@pmail.co", 16),
        Subscriber("linda1989@oal.com", 1),
        Subscriber("jan1940@ahoy.com", 0),
        Subscriber("mrig@pmail.co", 25),
        Subscriber("lol@lol.lol", 0)
    )
}

fun main() {
    val service = SendCouponService()

    val coupons = fetchCouponsFromDB()
    println("coupons: $coupons")
    val goodCoupons = service.selectCouponsByRank(coupons, "good")
    println("Good Coupons: $goodCoupons")
    val bestCoupons = service.selectCouponsByRank(coupons, "best")
    println("Best Coupons: $bestCoupons")

    val subscribers = fetchSubscribersFromDB()
    println("subscribers: $subscribers")
    val emails = service.emailsForSubscriber(subscribers, bestCoupons, goodCoupons)
    for (email in emails) {
        println("Email to be sent: $email")
        // send(email)
    }
}

data class Subscriber(val email: String, val recommendCount: Int)
data class Coupon(val code: String, val rank: String)
data class Message(val from: String, val to: String, val subject: String, val body: String)
