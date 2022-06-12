package com.ddd.tutio.base;

import java.io.Serializable;

/**
 * Interfejs implementowany przez <b>każdą</b> klasę reprezentującą wzorzec taktyczny <b>encji</b>.
 * Zapewnia kontrakt dotyczący dostarczenia unikalnego identyfikatora.
 * @param <ID> - typ identyfikatora encji
 */
public interface Entity<ID> extends Serializable {

    /**
     * Zapewnia kontrakt dotyczący unikalnego identyfikatora encji.
     * @return unikalny identyfikator instancji encji
     */
    ID getIdentifier();
}
