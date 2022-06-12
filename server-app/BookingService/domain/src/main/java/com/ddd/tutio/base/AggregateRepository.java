package com.ddd.tutio.base;

/**
 * Interfejs zapewniający kontrakt dla wzorca taktycznego <b>repozytorium</b>.
 * Rozszerza funkcjonalność interfejsu {@link ReadOnlyAggregateRepository} o zachowania związane z dowolnymi zmianami wprowadzanymi w ramach agregatów.
 * <b>Każdy agregat powinien posiadać własną implementację {@link AggregateRepository} lub {@link ReadOnlyAggregateRepository}</b>.
 *
 * @param <ID> - typ identyfikatora agregatu
 * @param <Aggregate> - typ agregatu
 */
public interface AggregateRepository<ID, Aggregate> extends ReadOnlyAggregateRepository<ID, Aggregate> {

    /**
     * Odpowiada za generowanie nowego, <b>unikalnego w obrębie całego systemu</b> identyfikatora agregatu.
     * @return wygenerowany identyfikator
     */
    ID generateNext();

    /**
     * Odpowiada za utrwalenie w magazynie trwałości nowej instancji agregatu.
     * @param aggregate instancja agregatu, która ma zostać utrwalona
     */
    void add(Aggregate aggregate);

    /**
     * Odpowiada za usunięcie z magazynu trwałości istniejącej instancji agregatu.
     * @param aggregate instancja agregatu, która ma zostać usunięta
     */
    void remove(Aggregate aggregate);
}
