package ch13;

class ThreadEx16 {
    public static void main(String[] args) {
        RunImplEx16 th1 = new RunImplEx16("*");
        RunImplEx16 th2 = new RunImplEx16("**");
        RunImplEx16 th3 = new RunImplEx16("***");
        th1.start();
        th2.start();
        th3.start();

        try {
            Thread.sleep(2000);
            th1.suspend();      //  th1.suspend가 아님에 주의
            Thread.sleep(2000);
            th2.suspend();
            Thread.sleep(3000);
            th1.resume();
            Thread.sleep(3000);
            th1.stop();
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch (InterruptedException e) {}
    }       //  main
}

class RunImplEx16 implements Runnable {
    volatile boolean suspended = false;     //  volatile 이 값은 자주 가져다 쓰니까 원본(ram)에서 복사본을 cpu로 가져오지말고 원본을 가져다 써라
    volatile boolean stopped = false;

    Thread th;

    RunImplEx16(String name) {
        th = new Thread(this, name);        //  Thread(Runnalbe r, String name)
    }


    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }       //  run()
        System.out.println(Thread.currentThread().getName() + " - stopped");
    }

    void start() {
        th.start();
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void stop() {
        stopped = true;
    }
}