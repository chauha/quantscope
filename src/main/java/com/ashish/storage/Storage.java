package com.ashish.storage;

import java.time.LocalDateTime;
import java.util.List;

public interface Storage<Key> {


    /*
        Key - cookieId
        Value - ISODate
    */
    public void loadData(Key key, LocalDateTime value);

    /*
        Find most frequent based on duration
     */
    public List<Key> getMostFrequent(LocalDateTime value);

}
