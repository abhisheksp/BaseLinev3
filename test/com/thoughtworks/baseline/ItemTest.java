package com.thoughtworks.baseline;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {

    @Test
    public void shouldReturnNetAmountSameAsBaseAmountGivenItemIsExemptedAndNotImported() {
        Item item = new Item("book", 12.49, true, false);

        assertEquals(12.49, item.netAmount(), 0.0001);
    }
}
