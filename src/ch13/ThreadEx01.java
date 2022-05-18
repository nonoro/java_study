package ch13;

class ThreadEx01 {
    public static void main(String[] args) {
        ThreadEx01_1 t1 = new ThreadEx01_1();

        Runnable r = new ThreadEx01_2();
        Thread t2 = new Thread(r);

        t1.start();     //  0을 출력
        t2.start();     //  1을 출력
        //      이게 출력을 해보면 0이 먼저 나올때도있고 1이 먼저 나올때도있음 OS스케줄러가 가지고있는 스케줄러 로직에 의해서 실행되기 때문에 순서대로 실행되는게 아님!
    }
}

class ThreadEx01_1 extends Thread {     //  1. Thread클래스를 상속해서 쓰레드를 구현
    public void run() {     //  쓰레드가 수행할 작업을 작성
        for (int i =0; i < 5; i++) {
            System.out.println(getName());      //  조상인 Thread의 getName()호출, 원래 this.getName()인데 this 생략
        }
    }
}

class ThreadEx01_2 implements Runnable {        //  2. Runnable인터페이스를 구현해서 쓰레드를 구현
    public void run() {     //  쓰레드가 수행할 작업을 작성
        for (int i = 0; i < 5; i++) {
            //  Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
            System.out.println(Thread.currentThread().getName());       //  얘는 쓰레드를 상속받지 않아서 getName()접근시 커런트쓰레드라는 메서드를 이용해 쓰레드 객체를 참조해야됨
        }
    }
}