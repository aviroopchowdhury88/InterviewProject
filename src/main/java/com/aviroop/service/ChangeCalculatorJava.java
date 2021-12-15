package com.aviroop.service;

import java.math.BigDecimal;
import java.util.*;

public class ChangeCalculatorJava {
    public static Map<Integer, Integer> calculateMinCoinsForChange(BigDecimal productCost, List<Integer> insertedCoins, Set<Integer> coinSystem) throws Exception {

        /*
        1. convert productCost to p
        2. calculate total change
        3. sort coinSystem by reverse order -- list
        4. for each, if remainingChange/acceptedCoin != 0
            a. update remainingChange = remainingChange % acceptedCoin
            b. insert to map -> key = acceptedCoin; value = remainingChange/acceptedCoin
        5. Return Map
         */
        validateEntries(productCost, insertedCoins, coinSystem);

        Map<Integer, Integer> changeMap = new HashMap<>();

        Integer productCostInP = productCost.multiply(new BigDecimal(100)).intValue();
        Integer totalPaid = insertedCoins.stream().reduce(Integer::sum).orElse(0);
        Integer remainingChange = totalPaid - productCostInP;
        List<Integer> coins = new ArrayList<>(coinSystem);

        coins.sort(Comparator.reverseOrder());
        for(Integer acceptedCoin : coins) {
            Integer changeCount = remainingChange/acceptedCoin;
            if(changeCount != 0) {
                remainingChange = remainingChange % acceptedCoin;
                changeMap.put(acceptedCoin, changeCount);
            }
        }
        return changeMap;
    }

    private static void validateEntries(BigDecimal productCost, List<Integer> insertedCoins, Set<Integer> coinSystem) throws Exception {
        if(null == productCost) {
            throw new Exception("productCost is null");
        }
        if(null == insertedCoins || insertedCoins.isEmpty()) {
            throw new Exception("insertedCoins problem");
        }
        if(null == coinSystem || coinSystem.isEmpty()) {
            throw new Exception("coinSystem problem");
        }
    }
}
