package com.ashish;

import com.ashish.manager.LogManager;
import com.ashish.models.Result;
import org.apache.commons.cli.*;

import java.io.File;
import java.time.LocalDate;

public class Main {

    public static void main(String [] args ){
        Options options = new Options();
        Option cookieFile   = Option.builder("f")
                .argName("file")
                .hasArg(true)
                .desc("File to read cookies")
                .build();

        Option dateArg   = Option.builder("d")
                .argName("date")
                .hasArg(true)
                .desc("Date to query for")
                .build();

        options.addOption(cookieFile);
        options.addOption(dateArg);

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(options, args);
            String filePath = cmd.getOptionValue("f");

            File file = new File(filePath);
            LocalDate dateTime = LocalDate.parse(cmd.getOptionValue("d"));
            Result result  = new LogManager().processRequest(file, dateTime.atStartOfDay());
            System.out.println(result.getData().toString());


            /*
                TODO :
                1. Formatter add for date
                2. Exception handling
                3. Cleanup Main method

             */

        } catch (Exception e){
            //formatter.printHelp("", options);
            e.printStackTrace();

            System.out.println("Please enter a valid option");
        }
    }
}
