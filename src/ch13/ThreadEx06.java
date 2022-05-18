package ch13;

class ThreadEx06 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx06_1 th1 = new ThreadEx06_1();
        ThreadEx06_2 th2 = new ThreadEx06_2();
        System.out.print("소요시간:" + (System.currentTimeMillis() - startTime));
        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();


    }   //  main
}

class ThreadEx06_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("-"));
        }
    }
}

class ThreadEx06_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print(new String("|"));
        }
    }
}
