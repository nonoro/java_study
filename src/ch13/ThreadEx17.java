package ch13;

class ThreadEx17 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx17_1 th1 = new ThreadEx17_1();
        ThreadEx17_2 th2 = new ThreadEx17_2();
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();     //  현재시간, 시작시간 저장

        try {
            th1.join();     //  main쓰레드가 th1의 작업이 끝날 때까지 기다린다.
            th2.join();     //  main쓰레드가 th2의 작업이 끝날 때까지 기다린다.
        } catch(InterruptedException e) {}

        System.out.print("소요시간:" + (System.currentTimeMillis() - ThreadEx17.startTime));        //  소요시간 = 시작시간 - 종료시간

    }       //  main
}

class ThreadEx17_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }   //  run()
}

class ThreadEx17_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }   //  run()
}

