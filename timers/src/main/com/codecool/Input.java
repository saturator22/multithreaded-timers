package main.com.codecool;

import java.util.Scanner;

class Input {

    private Scanner scanner;

    Input() {
        this.scanner = new Scanner(System.in);
    }

    Scanner getScanner() {
        return scanner;
    }
}
