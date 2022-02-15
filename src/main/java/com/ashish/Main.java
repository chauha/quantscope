package com.ashish;

import com.ashish.exceptions.NoEntryFoundException;
import com.ashish.manager.LogManager;
import com.ashish.models.Result;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class Main {

    public static void main(String [] args ){
        final Options options = new Options();
        Option filePathOption = new Option("f", "cookie_file", true, "Input file to read cookies");
        Option dateOption = new Option("d", "date", true, "Date to query for");
        filePathOption.setRequired(true);
        dateOption.setRequired(true);
        options.addOption(filePathOption);
        options.addOption(dateOption);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = null;
        String filePath = "";
        LocalDate dateTime = null;
        HelpFormatter formatter = new HelpFormatter();
        try {
             cmd = parser.parse(options, args);
             filePath = cmd.getOptionValue("f");
             File file = new File(filePath);
             dateTime = LocalDate.parse(cmd.getOptionValue("d"));

             Result result  = new LogManager().processRequest(file, dateTime.atStartOfDay());
             System.out.println(result.getData().toString());
        } catch (ParseException e){
            formatter.printHelp("java -cp quant.jar com.ashish.Main", options);
            System.out.println("Please enter valid args");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("File doesn't exist" + filePath);
        }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("Couldn't read file" + filePath);
        } catch (NoEntryFoundException e){
            System.out.println("No entries exist for " + dateTime );
        }
    }
}
