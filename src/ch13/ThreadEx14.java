package ch13;

import javax.swing.JOptionPane;

class ThreadEx14 {
    public static void main(String[] args) throws Exception {
        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다. ");
        th1.interrupt();        //  interrup()를 호출하면, interrupted상태가 true가 된다.
        System.out.println("isInterrupted():" + th1.isInterrupted());       //  true
        System.out.println("isInterrupted():" + th1.isInterrupted());       //  true

    }
}

class ThreadEx14_1 extends Thread {
    public void run() {
        int i = 10;

        while(i != 0 && !isInterrupted()) {
            System.out.println(i--);
            try {
                Thread.sleep(1000);     //  1초 지연
            } catch (InterruptedException e) {
                this.interrupt();       //  interrupted를 true로 바꿔서 while문에 isInterupted를 false로 바꿔서 while문 탈출
            }
        }
        System.out.println("카운트가 종료되었습니다.");
    }
}