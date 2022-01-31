package com.ashish.processor;

import com.ashish.models.LogRecord;
import com.ashish.reader.LogReader;
import com.ashish.storage.Storage;

import java.io.IOException;
import java.time.LocalDateTime;

public class BasicLogProcessor implements  LogProcessor {

    Storage storage;

    public BasicLogProcessor(Storage storage){
        this.storage = storage;
    }

    @Override
    public void processLogFile(LogReader reader) throws IOException {
        LogRecord<String, LocalDateTime> record = null;

        while ( ( record = reader.readRecord() ) != null ){
            storage.loadData(record.getKey(), record.getValue());
        }
    }
}
