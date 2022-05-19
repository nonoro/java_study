package ch13;

class ThreadEx19 {
    public static void main(String[] args) {
        ThreadEx19_1 th1 = new ThreadEx19_1("*");
        ThreadEx19_1 th2 = new ThreadEx19_1("**");
        ThreadEx19_1 th3 = new ThreadEx19_1("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {

        }
    }       //  main
}

class ThreadEx19_1 implements Runnable {
    boolean suspended = false;
    boolean stopped = false;

    Thread th;

    ThreadEx19_1(String name) {
        th = new Thread(this, name);    //  Thread(Runnalbe r, String name)
    }
    public void run() {
        String name = th.getName();

        while(!stopped) {
            if (!suspended) {
                System.out.println(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name + " - interrupted");
            }

            } else {
                Thread.yield();
            }
        }
        System.out.println(name + " - stopped");
    }       //  run()


public void suspend() {
    suspended = true;
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by suspend() ");
}

public void stop() {
    stopped = true;
    th.interrupt();
    System.out.println(th.getName() + " - interrupt() by stop()");
}

public void resume() {
    suspended = false;
}
public void start() {
    th.start();
}
}