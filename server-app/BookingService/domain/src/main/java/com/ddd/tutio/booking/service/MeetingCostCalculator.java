package com.ddd.tutio.booking.service;

import com.ddd.tutio.booking.Booking;
import com.ddd.tutio.booking.MeetingCost;
import com.ddd.tutio.discount.Discount;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class MeetingCostCalculator {

    public MeetingCost calculateMeetingCost(Booking booking, List<Discount> discounts) {
        var baseCost = booking.calculateBaseMeetingCost();
        Map<Discount, BigDecimal> discountValues = calculateDiscounts(baseCost, discounts);
        BigDecimal combinedDiscount = calculateCombinedDiscountsValue(discounts, discountValues);
        BigDecimal maxNonCombinedDiscount = calculateMaxNonCombinedDiscountValue(discounts, discountValues);
        return baseCost.withDiscount(combinedDiscount.max(maxNonCombinedDiscount));
    }

    private BigDecimal calculateMaxNonCombinedDiscountValue(
            List<Discount> discounts, Map<Discount, BigDecimal> discountValues
    ) {
        return discounts.stream()
                .filter(discount -> !discount.discountCombinesWithOthers())
                .map(discountValues::get)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    private Map<Discount, BigDecimal> calculateDiscounts(
            MeetingCost calculatedCost, List<Discount> discounts
    ) {
        return discounts.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        discount -> discount.calculateDiscount(calculatedCost)
                ));
    }

    private BigDecimal calculateCombinedDiscountsValue(
            List<Discount> discounts, Map<Discount, BigDecimal> discountValues
    ) {
        return discounts.stream()
                .filter(Discount::discountCombinesWithOthers)
                .map(discountValues::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
