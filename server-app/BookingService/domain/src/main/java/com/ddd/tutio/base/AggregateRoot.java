package com.ddd.tutio.base;

import java.util.List;

/**
 * Interfejs implementowany przez <b>każdą</b> klasę reprezentującą wzorzec taktyczny <b>agregatu</b>.
 * Rozszerza interfejs {@link Entity} zapewniający kontrakt dotyczący unikalnej tożsamości.
 * Dodatkowo zapewnia kontrakt dotyczący zdarzeń domenowych w obrębie agregatu.
 * @param <ID>
 */
public interface AggregateRoot<ID> extends Entity<ID> {

    /**
     * Zapewnia kontrakt dotyczący zdarzeń domenowych dotyczących danego agregatu.
     * @return listę zdarzeń domenowych dotyczących agregatu, występujących od czasu utworzenia/pobrania instancji z magazynu trwałości
     */
    List<DomainEvent> events();
}
