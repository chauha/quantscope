package com.ashish.models;

public class LogRecord<Key, Value> {
    Key key;
    Value value;

    public LogRecord(Key key, Value value){
        this.key = key;
        this.value = value;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }
}
