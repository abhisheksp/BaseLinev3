package com.thoughtworks.baseline;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParserTest {

    @Test
    public void shouldSplitRawInputIntoThreeTokensWhenTokenizerIsCalled() {
        String input = "1 book at 12.49";
        ArrayList<String> tokens = new ArrayList<String>();
        tokens.add("1");
        tokens.add("book at");
        tokens.add("12.49");
        Parser parser = new Parser(input);

        assertEquals(tokens.toString(), parser.tokenize().toString());
    }
}
