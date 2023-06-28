package com.flimbis.model;

import java.time.LocalDate;

public record Message(String content, LocalDate timestamp) {
}
