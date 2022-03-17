package com.ddd.tutio.booking.service

import com.ddd.tutio.booking.Currency
import com.ddd.tutio.booking.MeetingCost
import com.ddd.tutio.booking.TestBookingFactory
import com.ddd.tutio.discount.Discount
import spock.lang.Specification

import java.time.Duration
import java.time.Instant

class MeetingCostCalculatorTest extends Specification implements TestBookingFactory {

    MeetingCostCalculator calculator
    Discount discount25PercentNotCombine
    Discount discount30PercentNotCombine
    Discount discount10PercentCombine
    Discount discount5PLNCombine

    def setup() {
        calculator = new MeetingCostCalculator()
        discount25PercentNotCombine = new Discount() {
            @Override
            BigDecimal calculateDiscount(MeetingCost baseMeetingCost) {
                def discountValue = baseMeetingCost.amount * new BigDecimal("0.75")
                return baseMeetingCost.amount - discountValue
            }

            @Override
            boolean discountCombinesWithOthers() { return false }
        }
        discount30PercentNotCombine = new Discount() {
            @Override
            BigDecimal calculateDiscount(MeetingCost baseMeetingCost) {
                def discountValue = baseMeetingCost.amount * new BigDecimal("0.70")
                return baseMeetingCost.amount - discountValue
            }

            @Override
            boolean discountCombinesWithOthers() { return false }
        }
        discount10PercentCombine = new Discount() {
            @Override
            BigDecimal calculateDiscount(MeetingCost baseMeetingCost) {
                def discountValue = baseMeetingCost.amount * new BigDecimal("0.90")
                return baseMeetingCost.amount - discountValue
            }

            @Override
            boolean discountCombinesWithOthers() { return true }
        }
        discount5PLNCombine = new Discount() {
            @Override
            BigDecimal calculateDiscount(MeetingCost baseMeetingCost) {
                return new BigDecimal("5.00")
            }

            @Override
            boolean discountCombinesWithOthers() { return true }
        }
    }

    def "Correct calculate meeting cost without discounts"(
            Duration meetingDuration, String lessonPrice, String requiredAmount, Currency requiredCurrency) {

        given: "Booking aggregate instance"
        def booking = getInstance(Instant.now(), meetingDuration, new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def meetingCost = calculator.calculateMeetingCost(booking, [])

        then: "Calculate meeting cost correctly"
        meetingCost.amount == new BigDecimal(requiredAmount)
        meetingCost.currency == requiredCurrency

        where: "Parameters"
        meetingDuration        | lessonPrice | requiredAmount | requiredCurrency
        Duration.ofHours(2)    | "30.0000"   | "60.00"        | Currency.PLN
        Duration.ofMinutes(45) | "50.0000"   | "37.50"        | Currency.PLN
        Duration.ofMinutes(35) | "45.5000"   | "26.54"        | Currency.PLN
    }

    def "Correct calculate meeting cost for discount which are not combine with others"(
            Duration meetingDuration, String lessonPrice, String requiredAmount, Currency requiredCurrency) {

        given: "Booking aggregate instance"
        def booking = getInstance(Instant.now(), meetingDuration, new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def meetingCost = calculator.calculateMeetingCost(booking, [discount25PercentNotCombine, discount30PercentNotCombine])

        then: "Calculate meeting cost correctly"
        meetingCost.amount == new BigDecimal(requiredAmount)
        meetingCost.currency == requiredCurrency

        where: "Parameters"
        meetingDuration        | lessonPrice | requiredAmount | requiredCurrency
        Duration.ofHours(2)    | "30.0000"   | "42.00"        | Currency.PLN
        Duration.ofMinutes(45) | "50.0000"   | "26.25"        | Currency.PLN
        Duration.ofMinutes(35) | "45.5000"   | "18.58"        | Currency.PLN
    }

    def "Correct calculate meeting cost for discount which are combine with others"(
            Duration meetingDuration, String lessonPrice, String requiredAmount, Currency requiredCurrency) {

        given: "Booking aggregate instance"
        def booking = getInstance(Instant.now(), meetingDuration, new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def meetingCost = calculator.calculateMeetingCost(booking, [discount10PercentCombine, discount5PLNCombine])

        then: "Calculate meeting cost correctly"
        meetingCost.amount == new BigDecimal(requiredAmount)
        meetingCost.currency == requiredCurrency

        where: "Parameters"
        meetingDuration        | lessonPrice | requiredAmount | requiredCurrency
        Duration.ofHours(2)    | "30.0000"   | "49.00"        | Currency.PLN
        Duration.ofMinutes(45) | "50.0000"   | "28.75"        | Currency.PLN
        Duration.ofMinutes(35) | "45.5000"   | "18.89"        | Currency.PLN
    }

    def "Correct calculate meeting cost for different types discounts"(
            Duration meetingDuration, String lessonPrice, String requiredAmount, Currency requiredCurrency) {

        given: "Booking aggregate instance"
        def booking = getInstance(Instant.now(), meetingDuration, new BigDecimal(lessonPrice))

        when: "Calculate meeting cost"
        def meetingCost = calculator.calculateMeetingCost(booking, [discount30PercentNotCombine, discount10PercentCombine, discount5PLNCombine])

        then: "Calculate meeting cost correctly"
        meetingCost.amount == new BigDecimal(requiredAmount)
        meetingCost.currency == requiredCurrency

        where: "Parameters"
        meetingDuration        | lessonPrice | requiredAmount | requiredCurrency
        Duration.ofHours(2)    | "50.0000"   | "70.00"        | Currency.PLN
        Duration.ofMinutes(45) | "50.0000"   | "26.25"        | Currency.PLN
        Duration.ofMinutes(35) | "30.5000"   | "11.02"        | Currency.PLN
    }
}
