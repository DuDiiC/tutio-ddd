package com.ddd.tutio.booking;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

/**
 * Obiekt wartości ceny lekcji. Kwota, na jaką nauczyciel wycenia godzinę zegarową spotkania prowadzonego w ramach ustalonego kursu (w tym prowizja
 * platformy oraz opłaty związane z podatkami).
 */
class LessonPrice implements Serializable {

    /**
     * Mapa przechowująca informację (dla każdej waluty) o minimalnej cenie lekcji, dla której można utworzyć spotkanie.
     */
    static final Map<Currency, BigDecimal> MIN_MEETING_PRICE = Map.of(
            Currency.PLN, new BigDecimal("20.0000")
    );

    BigDecimal price;
    Currency currency;

    protected LessonPrice() {
    }

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

    /**
     * @return {@code true}, jeśli cena jest większa lub równa minimalnej cenie spotkania w danej walucie, {@code false} w przeciwnym wypadku
     */
    private boolean isGreaterThanOrEqualMinimumPrice(BigDecimal price, Currency currency) {
        return price.compareTo(MIN_MEETING_PRICE.get(currency)) >= 0;
    }
}
