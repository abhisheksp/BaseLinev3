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

    private double roundOffToNearestPointZeroFive(double value) {
        return Math.ceil(value * 20) / 20;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Item thatItem = (Item) that;
        if (Double.compare(thatItem.grossAmount, grossAmount) != 0) return false;
        if (!name.equals(thatItem.name)) return false;
        if (!isExempted.equals(thatItem.isExempted)) return false;
        return isImported.equals(thatItem.isImported);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(grossAmount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + isExempted.hashCode();
        result = 31 * result + isImported.hashCode();
        return result;
    }

    public double netAmount() {
        double netAmount = grossAmount;
        if (!isExempted)
            netAmount += roundOffToNearestPointZeroFive(grossAmount * 10.0 / 100);
        if (isImported)
            netAmount += roundOffToNearestPointZeroFive(grossAmount * 5.0 / 100);
        return netAmount;

    }
}
