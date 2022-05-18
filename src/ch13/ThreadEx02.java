package ch13;

class ThreadEx02 {
    public static void main(String[] args) throws Exception {
        ThreadEx02_1 t1 = new ThreadEx02_1();
        t1.start();                 //      얘는 start()를 호출했기 때문에 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택을 생성한 다음에 새로 생성된 호출스택에 run()이 첫 번째로 올라가게 한다
    }
}

class ThreadEx02_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}