package com.ashish.reader;

import com.ashish.models.LogRecord;

import java.io.IOException;

public interface LogReader {

     LogRecord readRecord() throws IOException;
}
