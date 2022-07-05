package com.ddd.tutio.base;

import java.io.Serializable;

public interface Entity<ID> extends Serializable {

    ID getIdentifier();
}
