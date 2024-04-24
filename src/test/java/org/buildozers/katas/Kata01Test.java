package org.buildozers.katas;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class Kata01Test {

    @Test
    @DisplayName("Exercice 01 - DaysBetweenDates ")
    void test() {

        LocalDate now = LocalDate.now();

        assertThat(now).isNotNull();

    }
}