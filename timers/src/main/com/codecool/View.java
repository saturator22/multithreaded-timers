package main.com.codecool;

import java.util.List;

public class View {

    public static void printCommand() {
        System.out.print("Command ?: ");
    }

    public static void printTimers(List<Timer> timerList) {
        for(Timer timer: timerList) {
            System.out.println(timer.toString());
        }
    }
}
