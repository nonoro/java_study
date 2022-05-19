package ch13;

class ThreadEx12 {
    public static void main(String[] args) {
        ThreadEx12_1 th1 = new ThreadEx12_1();
        ThreadEx12_2 th2 = new ThreadEx12_2();
        th1.start();
        th2.start();

        try {
//            th1.sleep(2000);        // th1을 2초동안 잠자게? : 아님 이건 th1을 재우는게 아니라 이 코드를 수행하는건 main 쓰레드이기 때문에 main쓰레드가 잠을잔다
            Thread.sleep(2000);     //  안 헷깔리게 이렇게 해야됨 th1, th2이렇게하며 안됨
        } catch (InterruptedException e) {}     //  만약 th1을 잠자게 하고싶으면

//        delay(2 * 1000);    //   이렇게 메서드를 써서 예외처리해도됨

        System.out.print("<<main 종료>>");
    }       //  main
//
//    static void delay(long millis) {            //  이렇게 delay메서드를 따로 만들고
//        try {
//            Thread.sleep((millis);
//        } catch (InterruptedException e) {}     InterruptedExdception 은 필수 예외라서 무조건 try{} catch{} 문을 써야된다.
    }

class ThreadEx12_1 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
        System.out.print("<<th1 종료>>");
    }       //  run
}

class ThreadEx12_2 extends Thread {
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }

        System.out.print("<<th2 종료>>");
    }       //  run()
}
