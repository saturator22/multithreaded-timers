package main.com.codecool;

import java.util.List;

class View {

    static void printCommand() {
        System.out.print("Command ?: ");
    }

    static void printTimers(List<Timer> timerList) {
        for(Timer timer: timerList) {
            System.out.println(timer.toString());
        }
    }
}
