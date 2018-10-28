package main.com.codecool;

public class Timer extends Thread {

    private String timerName;
    private int seconds;
    private boolean isSuspended;

    Timer(String timerName) {
        this.timerName = timerName;
    }

    public void run() {
        while(!this.isInterrupted() || !isSuspended) {
            try{
                this.sleep(1000);
                this.seconds++;
                synchronized (this) {
                    while(this.isSuspended) {
                        this.wait();
                    }
                }
            } catch (InterruptedException e) {
                synchronized (this) {
                    System.out.println(this.toString() + " has been interrupted.");
                    if(this.interrupted()) {
                        return;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return  "Name: '" + timerName + '\'' +
                ", seconds: " + seconds +
                ", threadId: " + this.getId();
    }

    synchronized void suspendThread(){
        this.isSuspended = true;
    }

    synchronized void resumeThread() {
        this.isSuspended = false;
        this.notify();
    }

    synchronized String getTimerName() {
        return this.timerName;
    }
}
