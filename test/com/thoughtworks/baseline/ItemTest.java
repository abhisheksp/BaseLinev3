package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ItemTest {

    @Test
    public void shouldReturnNetAmountSameAsBaseAmountGivenItemIsExemptedAndNotImported() {
        Item item = new Item("book", 12.49, true, false);

        assertEquals(12.49, item.netAmount(), 0.0001);
    }

    @Test
    public void shouldReturnNetAmountTenPercentHigherThanGrossAmountRoundedToNearestPointZeroFiveGivenItemIsNotExemptedAndNotImported() {
        Item item = new Item("box of chocolate", 14.99, false, false);

        assertEquals(16.49, item.netAmount(), 0.0001);
    }

    @Test
    public void shouldReturnNetAmountFivePercentHigherThanGrossAmountRoundedToNearestPointZeroFiveGivenItemIsExemptedAndIsImported() {
        Item item = new Item("imported box of chocolate", 10.00, true, true);

        assertEquals(10.50, item.netAmount(), 0.0001);
    }

    @Test
    public void shouldReturnNetAmountFifteenPercentHigherThanGrossAmountRoundedToNearestPointZeroFiveGivenItemIsNotExemptedAndIsImported() {
        Item item = new Item("imported bottle of perfume", 47.50, false, true);

        assertEquals(54.65, item.netAmount(), 0.0001);
    }

    @Test
    public void ItemShoudlBeEqualToItself() {
        Item item = new Item("imported bottle of perfume", 47.50, false, true);

        assertEquals(item, item);
    }

    @Test
    public void ItemShoudlBeEqualToAnotherItemWithSameDetails() {
        assertEquals(new Item("imported bottle of perfume", 47.50, false, true), new Item("imported bottle of perfume", 47.50, false, true));
    }

    @Test
    public void ItemShoudlNotBeEqualToAnotherItemWithDifferentDetails() {
        assertNotEquals(new Item("imported bottle of perfume", 47.50, false, true), new Item("bottle of perfume", 47.50, false, false));
    }

    @Test
    public void ItemShoudlHaveSameHashCodeAsAnotherItemWithSameDetails() {
        assertNotEquals(new Item("imported bottle of perfume", 47.50, false, true).hashCode(), new Item("bottle of perfume", 47.50, false, false).hashCode());
    }
}
