package com.ddd.tutio.discount;

import com.ddd.tutio.booking.MeetingCost;

import java.math.BigDecimal;

public interface Discount {

    BigDecimal calculateDiscount(MeetingCost baseMeetingCost);

    boolean discountCombinesWithOthers();
}
