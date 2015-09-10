package com.thoughtworks.baseline;

/* Item has name, grossamount, ifexempted, ifimported and can calculate its net amount */
public class Item {

    private String name;
    private double grossAmount;
    private Boolean isExempted;
    private Boolean isImported;

    public Item(String name, double grossAmount, Boolean isExempted, Boolean isImported) {
        this.name = name;
        this.grossAmount = grossAmount;
        this.isExempted = isExempted;
        this.isImported = isImported;
    }

    public double netAmount() {
        double netAmount = grossAmount;
        if (!isExempted)
            netAmount += (Math.ceil(grossAmount * (10.0 / 100) * 20) / 20);
        if (isImported)
            netAmount += (Math.ceil(grossAmount * (5.0 / 100) * 20) / 20);
        return netAmount;
    }
}
