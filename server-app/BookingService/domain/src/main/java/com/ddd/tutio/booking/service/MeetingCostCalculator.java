package com.ddd.tutio.booking.service;

import com.ddd.tutio.booking.Booking;
import com.ddd.tutio.booking.MeetingCost;
import com.ddd.tutio.discount.Discount;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

class MeetingCostCalculator {

    private final List<Discount> discounts;

    public MeetingCostCalculator(List<Discount> discounts) {
        this.discounts = Objects.requireNonNullElseGet(discounts, ArrayList::new);
    }

    public MeetingCost calculateMeetingCost(Booking booking) {
        var baseCost = booking.calculateMeetingCost();
        Map<Discount, BigDecimal> discountValues = calculateDiscounts(baseCost);
        BigDecimal combinedDiscount = calculateCombinedDiscountsValue(discountValues);
        BigDecimal maxNonCombinedDiscount = calculateMaxNonCombinedDiscountValue(discountValues);
        return baseCost.withDiscount(combinedDiscount.max(maxNonCombinedDiscount));
    }

    private BigDecimal calculateMaxNonCombinedDiscountValue(Map<Discount, BigDecimal> discountValues) {
        return discounts.stream()
                .filter(discount -> !discount.discountCombinesWithOthers())
                .map(discountValues::get)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);
    }

    private Map<Discount, BigDecimal> calculateDiscounts(MeetingCost calculatedCost) {
        return discounts.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        discount -> discount.calculateDiscount(calculatedCost)
                ));
    }

    private BigDecimal calculateCombinedDiscountsValue(Map<Discount, BigDecimal> discountValues) {
        return discounts.stream()
                .filter(Discount::discountCombinesWithOthers)
                .map(discountValues::get)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
