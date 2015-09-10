package com.thoughtworks.baseline;

import java.util.ArrayList;

public class Parser {

    private String rawInput;

    public Parser(String rawInput) {
        this.rawInput = rawInput;
    }

    public ArrayList<String> tokenize() {
        String[] rawInputSplits = rawInput.split(" ");
        ArrayList<String> tokens = new ArrayList<String>();
        tokens.add(rawInputSplits[0]);
        String tokenTwo = "";
        for (int i = 1; i < rawInputSplits.length - 1; i++) {
            tokenTwo = tokenTwo + " " + rawInputSplits[i];
        }
        tokens.add(tokenTwo.substring(1));
        tokens.add(rawInputSplits[rawInputSplits.length - 1]);
        return tokens;
    }
}
