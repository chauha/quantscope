package com.ashish.processor;

import com.ashish.reader.LogReader;

import java.io.IOException;

public interface LogProcessor {

    public void processLogFile(LogReader reader) throws IOException;
}
