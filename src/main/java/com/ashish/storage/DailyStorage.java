package com.ashish.storage;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class DailyStorage<Key> implements  Storage<Key> {

    Map<LocalDate, Map<Key, Integer>> dataMap = new HashMap<>();

    public void loadData(Key key, LocalDateTime isoDate) {
        LocalDate date = isoDate.toLocalDate();
        dataMap.putIfAbsent(date, new HashMap<>());
        Map<Key, Integer> innerMap = dataMap.get(date);
        innerMap.put(key, innerMap.getOrDefault(key, 0 ) + 1 );
    }


    public List<Key> getMostFrequent(LocalDateTime isoDate) {
        LocalDate date = isoDate.toLocalDate();

        if ( dataMap.containsKey(date) == false ){
            return Collections.emptyList();
        }

        List<Key> result = new ArrayList<>();
        // Find max frequency key for a day
        int maxEntriesCount = Integer.MIN_VALUE;
        for ( Map.Entry<Key, Integer> entry : dataMap.get(date).entrySet() ){
            maxEntriesCount = Math.max(maxEntriesCount, entry.getValue() );
        }

        // collect all cookies which are of max frequency
        for ( Map.Entry<Key, Integer> entry : dataMap.get(date).entrySet() ){
             if ( entry.getValue() == maxEntriesCount ){
                 result.add(entry.getKey());
             }
        }

        return result;
    }
}
