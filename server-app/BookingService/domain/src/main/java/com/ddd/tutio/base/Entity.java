package com.ddd.tutio.base;

import java.io.Serializable;

public interface Entity<T> extends Serializable {

    T getIdentifier();
}
