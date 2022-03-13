package com.ddd.tutio.booking;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

class LessonPrice {

    static final Map<Currency, BigDecimal> MIN_MEETING_PRICE = Map.of(
            Currency.PLN, new BigDecimal("20.0000")
    );

    final BigDecimal price;
    final Currency currency;

    public LessonPrice(BigDecimal price, Currency currency) {
        validate(price, currency);
        this.price = price.setScale(2, RoundingMode.CEILING);
        this.currency = currency;
    }

    private void validate(BigDecimal price, Currency currency) {
        if (!isGreaterThanOrEqualMinimumPrice(price, currency)) {
            throw new IllegalArgumentException("The price must not be below MIN_MEETING_PRICE (" + MIN_MEETING_PRICE.get(currency) + " " + currency.name() + ")");
        }
    }

    private boolean isGreaterThanOrEqualMinimumPrice(BigDecimal price, Currency currency) {
        return price.compareTo(MIN_MEETING_PRICE.get(currency)) >= 0;
    }
}
