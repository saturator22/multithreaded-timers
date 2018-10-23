package main.com.codecool;

public class Timer extends Thread {

    private String timerName;
    private int seconds;

    public Timer(String timerName) {
        this.timerName = timerName;
        this.seconds = 0;
    }

    public void run() {
        while(!this.isInterrupted()) {
            try{
                this.sleep(1000);
                this.seconds++;
            } catch (InterruptedException e) {
                System.out.println(this.toString() + " has been interrupted.");
            }
        }
    }

    public int getSeconds() {
        return seconds;
    }

    public String getTimerName() {
        return timerName;
    }

    @Override
    public String toString() {
        return  "Name: '" + timerName + '\'' +
                ", seconds: " + seconds +
                ", threadId: " + this.getId();
    }
}
