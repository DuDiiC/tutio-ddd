package com.ddd.tutio.discount;

import com.ddd.tutio.booking.MeetingCost;

import java.math.BigDecimal;

/**
 * Interfejs zapewniający kontrakt dla zniżek dotyczących kosztu spotkania.
 */
public interface Discount {

    /**
     * Wyznacza kwotę zniżki przy pomocy algorytmu specyficznego dla konkretnej implementacji.
     * @param baseMeetingCost podstawowy koszt spotkania, dla którego liczona jest zniżka
     * @return kwota wyliczonej zniżki
     */
    BigDecimal calculateDiscount(MeetingCost baseMeetingCost);

    /**
     * Zwraca informację, czy zniżka łączy się z innymi.
     */
    boolean discountCombinesWithOthers();
}
