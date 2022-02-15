package com.ashish.reader;

import com.ashish.models.LogRecord;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class CsvLogReader implements  LogReader {
    File file;
    BufferedReader reader;
    public CsvLogReader(File file) throws FileNotFoundException {
        this.file = file;
        reader = new BufferedReader(new FileReader(this.file));
    }

    @Override
    public LogRecord readRecord() throws IOException {
        String line = reader.readLine();
        if ( line == null){
            return  null;
        }
        String [] records = line.split(",");
        return  new LogRecord<String, LocalDateTime>(records[0], LocalDateTime.parse(records[1], DateTimeFormatter.ISO_OFFSET_DATE_TIME));

    }
}
