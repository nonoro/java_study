package ch13;

class ThreadEx03 {
    public static void main(String[] args) throws Exception {
        ThreadEx03_1 t1 = new ThreadEx03_1();
        t1.run();           //      얘는 run()을 호출했기 때문에 새로운 쓰레드가 작업을 실행하는데 필요한 호출스택을 생성하지 않음 그냥 main메서드가 있는 호출스택에서 쓰레드가 작업을함
    }
}

class ThreadEx03_1 extends Thread {
    public void run() {
        throwException();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
