package main.com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Application {


    public static void run() {

        boolean isWorking = true;
        List<Timer> timerList = new ArrayList<>();
        Input input = new Input();
        String command;
        String[] parsedCommand;

        while(isWorking) {
            View.printCommand();

            command = input.getScanner().nextLine();
            parsedCommand = command.split(" ");

            if(parsedCommand[0].equals("start")) {
                startTimer(parsedCommand[1], timerList);
            } else if(parsedCommand[0].equals("check")) {
                View.printTimers(timerList);
            } else if(parsedCommand[0].equals("exit")) {
                isWorking = exit(timerList);
            }
        }
    }

    private static void startTimer(String name, List<Timer> timerList) {
        Timer timer = new Timer(name);
        timer.start();
        timerList.add(timer);
    }

    private static boolean exit(List<Timer> timerList) {
        for(Timer timer: timerList) {
            timer.interrupt();
        }
        return false;
    }
}
