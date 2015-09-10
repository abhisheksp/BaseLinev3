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
        ArrayList<String> exemptedItems = new ArrayList<String>();
        exemptedItems.add("book");
        exemptedItems.add("chocolate bar");
        exemptedItems.add("box of chocolates");
        exemptedItems.add("chocolates");
        exemptedItems.add("headache pills");
        Parser parser = new Parser(input, exemptedItems);

        assertEquals(tokens.toString(), parser.tokenize().toString());
    }

    @Test
    public void shouldReturnNewItemInitializedWithGivenTokensWhenParserIsCalledForExemptedItem() {
        String input = "1 book at 12.49";
        ArrayList<String> tokens = new ArrayList<String>();
        tokens.add("1");
        tokens.add("book at");
        tokens.add("12.49");
        ArrayList<String> exemptedItems = new ArrayList<String>();
        exemptedItems.add("book");
        exemptedItems.add("chocolate bar");
        exemptedItems.add("box of chocolates");
        exemptedItems.add("chocolates");
        exemptedItems.add("headache pills");
        Parser parser = new Parser(input, exemptedItems);

        assertEquals(new Item("book", 12.49, true, false).hashCode(), parser.parse(tokens).toString());
    }
}
