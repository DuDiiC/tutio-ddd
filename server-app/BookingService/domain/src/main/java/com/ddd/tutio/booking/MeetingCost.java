package com.ddd.tutio.booking;

import java.math.BigDecimal;

public record MeetingCost(BigDecimal amount, Currency currency) {
}
