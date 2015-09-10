package com.thoughtworks.baseline;

/* ConsoleDiplay has message that it displays on console */
public class ConsoleDisplay {

    private String message;

    public ConsoleDisplay(String message) {
        this.message = message;
    }

    public void display() {
        System.out.println(message);
    }
}
