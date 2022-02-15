package com.ashish;

import com.ashish.exceptions.NoEntryFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final  ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final  PrintStream originalOut = System.out;
    private final   PrintStream originalErr = System.err;

    @BeforeEach
    public  void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public  void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    @org.junit.jupiter.api.Test
    void main() {
        String [] args = new String[]{"-f", "src/main/resources/cookie.csv", "-d", "2018-12-09"};
        Main.main(args);
        assertEquals("[AtY0laUfhglK3lC7]\n", outContent.toString());
    }

    @org.junit.jupiter.api.Test
    void testFnf() throws FileNotFoundException {
        String [] args = new String[]{"-f", "src/main/resources/non_existent_cookie.csv", "-d", "2018-12-09"};
        Main.main(args);
    }

    @org.junit.jupiter.api.Test
    void testNef() throws NoEntryFoundException {
        String [] args = new String[]{"-f", "src/main/resources/cookie.csv", "-d", "2018-12-02"};
        Main.main(args);
    }

}