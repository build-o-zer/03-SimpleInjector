package org.buildozers;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SimpleTest {

    @Test
    @DisplayName("Given a date, when now, then return the current date (this is a dumb test)")
    void dumbTest() {
        LocalDate now = LocalDate.now();
        assertThat(now).isNotNull();
    }
}