package main.com.codecool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isWorking = true;
        List<Timer> timerList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String command;
        String[] parsedCommand;

        while(isWorking) {
            System.out.print("Command ?: ");
            command = scanner.nextLine();
            parsedCommand = command.split(" ");

            if(parsedCommand[0].equals("start")) {
                Timer timer = new Timer((parsedCommand[1]));
                timer.start();
                timerList.add(timer);

            } else if(parsedCommand[0].equals("check")) {
                for(Timer timer: timerList) {
                    System.out.println(timer.toString());
                }

            } else if(parsedCommand[0].equals("exit")) {
                for(Timer timer: timerList) {
                    timer.interrupt();
                }
                isWorking = false;
            }
        }
        System.exit(0);
    }
}
