package com.ddd.tutio.base;

/**
 * Interfejs zapewniający kontrakt dla wzorca taktycznego <b>repozytorium</b>.
 * Zapewnia zachowania <b>tylko do odczytu</b>, dla agregatów, które wykorzystywane są w danym kontekście jedynie w celach wyświetlania/przekazania
 * ich danych w ramach procesów.
 * <b>Każdy agregat powinien posiadać własną implementację {@link AggregateRepository} lub {@link ReadOnlyAggregateRepository}</b>.
 *
 * @param <ID> - typ identyfikatora agregatu
 * @param <Aggregate> - typ agregatu
 */
public interface ReadOnlyAggregateRepository<ID, Aggregate> {

    /**
     * Wyszukuje instancję agregaty w magazynie trwałości.
     * @param id unikalny identyfikator agregatu, po którym odbywa się wyszukiwanie
     * @return pobrana z magazynu trwałości instancja agregatu ({@code null} w przypadku nieznalezienia instancji)
     */
    Aggregate getById(ID id);

    /**
     * Sprawdza istnienie w magazynie trwałości instancji agregatu.
     * @param id unikalny identyfikator agregatu, dla którego odbywa się sprawdzenie
     * @return {@code true} jeśli instancja agregatu o podanym {@code  id} istnieje, {@code false} w przeciwnym wypadku
     */
    boolean existsById(ID id);
}
