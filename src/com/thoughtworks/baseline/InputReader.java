package com.thoughtworks.baseline;

import java.util.Scanner;

/* InputRead has a scanner which reads input from the user and returns it */
public class InputReader {
    private Scanner scanner;

    public InputReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public String read() {
        return scanner.nextLine();
    }
}
