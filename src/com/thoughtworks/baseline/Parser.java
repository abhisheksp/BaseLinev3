package com.thoughtworks.baseline;

import java.util.ArrayList;

public class Parser {

    private String rawInput;
    private ArrayList<String> exemptedItems;

    public Parser(String rawInput, ArrayList<String> exemptedItems) {
        this.rawInput = rawInput;
        this.exemptedItems = exemptedItems;
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

    public Item parse(ArrayList<String> tokens) {
        Boolean isExempted = false;
        String itemDetailToken = tokens.get(1);
        for (String item : exemptedItems) {
            if (itemDetailToken.contains(item))
                isExempted = true;
        }
        String itemName = itemDetailToken.substring(0, itemDetailToken.length() - 3);
        Double grossAmount = Double.parseDouble(tokens.get(2));
        return new Item(itemName, grossAmount, isExempted, false);
    }
}
