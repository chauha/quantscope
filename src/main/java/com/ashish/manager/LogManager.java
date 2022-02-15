package com.ashish.manager;

import com.ashish.exceptions.NoEntryFoundException;
import com.ashish.models.Frequency;
import com.ashish.models.QueryParams;
import com.ashish.models.Result;
import com.ashish.processor.BasicLogProcessor;
import com.ashish.processor.BasicQueryProcessor;
import com.ashish.processor.LogProcessor;
import com.ashish.processor.QueryProcessor;
import com.ashish.reader.CsvLogReader;
import com.ashish.reader.LogReader;
import com.ashish.storage.DailyStorage;
import com.ashish.storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogManager {

    public Result processRequest(File file, LocalDateTime dateTime) throws IOException, NoEntryFoundException {
        // Define type of data we want to store.
        // choosing String for the assignment, since we deal
        // with string type cookies.
        Storage<String> storage = new DailyStorage();
        LogReader reader = new CsvLogReader(file);
        LogProcessor logProcessor = new BasicLogProcessor(storage);
        QueryProcessor queryProcessor = new BasicQueryProcessor(storage);

        // Process log file
        logProcessor.processLogFile(reader);
        // Query for result.
        Result result = queryProcessor.query(new QueryParams(dateTime, Frequency.MOST));

        return result;
    }

}
