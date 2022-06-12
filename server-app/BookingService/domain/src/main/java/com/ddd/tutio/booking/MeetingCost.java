package com.ddd.tutio.booking;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Obiekt wartości kosztu spotkania.
 */
public final class MeetingCost {

    public final BigDecimal amount;
    public final Currency currency;

    public MeetingCost(BigDecimal amount, Currency currency) {
        this.amount = amount.setScale(2, RoundingMode.CEILING);
        this.currency = currency;
    }

    /**
     * Dokonuje przeliczenia i uwzględnienia kwoty zniżki, zwracając nową instancję obiektu wartości.
     */
    public MeetingCost withDiscount(BigDecimal discountValue) {
        return new MeetingCost(amount.subtract(discountValue).max(BigDecimal.ZERO), currency);
    }
}
