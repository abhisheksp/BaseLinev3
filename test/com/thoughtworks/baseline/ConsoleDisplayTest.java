package com.thoughtworks.baseline;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ConsoleDisplayTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setupStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayGivenMessageOnConsole(){
        ConsoleDisplay consoleDisplay = new ConsoleDisplay("Message to be displayed");

        consoleDisplay.display();

        assertEquals("Message to be displayed\n", outContent.toString());
    }
}
