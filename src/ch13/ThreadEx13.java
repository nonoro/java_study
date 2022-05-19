package ch13;

import javax.swing.JOptionPane;

class ThreadEx13 {
    public static void main(String[] args) throws Exception {
        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다. ");
        th1.interrupt();        //  interrup()를 호출하면, interrupted상태가 true가 된다.
        System.out.println("isInterrupted():" + th1.isInterrupted());       //  true
        //  main쓰레드가 interrupt되었는지 확인
        System.out.println("interrupted():" + Thread.interrupted());        //  false
    }
}

class ThreadEx13_1 extends Thread {
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            for (long x = 0; x < 2500000000L; x++);     //  시간 지연
        }
        System.out.println("isInterrupted():" + this.isInterrupted());       //  true
        System.out.println("isInterrupted():" + this.isInterrupted());       //  true
        System.out.println("interrupted():" + Thread.interrupted());         //  true
        //  isInterrupted()와 달리 interrupted()는 interrupted라는 상태변수를 false로 초기화 한다.
        System.out.println("interrupted():" + Thread.interrupted());        //  false


        System.out.println("카운트가 종료되었습니다.");
    }
}


//      게임에서 죽었을때 시간초 흐르면서 계속하시겠습니까? 그거랑 같은로직
