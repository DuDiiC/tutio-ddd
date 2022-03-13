package com.ddd.tutio.booking

import spock.lang.Specification

import java.math.RoundingMode

class LessonPriceTest extends Specification {

    def "Validation passed for appropriate instance"(String price, Currency currency, BigDecimal scaledPrice) {

        when: "Creating instance"
        def lessonPrice = new LessonPrice(new BigDecimal(price), currency)

        then: "No exception has been thrown"
        noExceptionThrown()

        and: "Price is in correct scale"
        lessonPrice.price == scaledPrice

        where: "Parameters"
        price                                                               | currency     | scaledPrice
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN)                     | Currency.PLN | price.setScale(2, RoundingMode.CEILING)
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN).add(BigDecimal.ONE) | Currency.PLN | price.setScale(2, RoundingMode.CEILING)
    }

    def "Validation failed if price is below minimum meeting price"(String price, Currency currency) {

        when: "Creating instance"
        new LessonPrice(new BigDecimal(price), currency)

        then: "Throw exception with correct message"
        def ex = thrown(IllegalArgumentException)
        ex.message == "The price must not be below MIN_MEETING_PRICE (${-> LessonPrice.MIN_MEETING_PRICE.get(currency)} ${-> currency.name()})"

        where: "Parameters"
        price                                                                              | currency
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN).subtract(new BigDecimal("0.0001")) | Currency.PLN
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN).subtract(new BigDecimal("0.001"))  | Currency.PLN
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN).subtract(new BigDecimal("0.01"))   | Currency.PLN
        LessonPrice.MIN_MEETING_PRICE.get(Currency.PLN).subtract(BigDecimal.TEN)           | Currency.PLN
    }
}
