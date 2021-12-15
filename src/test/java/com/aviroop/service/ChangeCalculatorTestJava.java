package com.aviroop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;


class ChangeCalculatorTestJava {

    @Test
    void calculateChangeForPurchaseWithNonExactChange() throws Exception {
        Set<Integer> coins = new HashSet<>();

        coins.add(1);
        coins.add(2);
        coins.add(5);
        coins.add(10);
        coins.add(20);
        coins.add(50);
        coins.add(100);

        Map<Integer, Integer> changeGiven = ChangeCalculatorJava.calculateMinCoinsForChange(
                new BigDecimal("1.50"),
                Arrays.asList(
                        100, 100
                ),
                coins
        );

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(50, 1);
        Assertions.assertEquals(expected, changeGiven);
    }
}
