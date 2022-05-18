package ch13;

import javax.swing.*;

public class ThreadEx08 {
    public static void main(String[] args) throws Exception {       //  멀티쓰레드 블락킹구간이 없음 입력을 안하고 있어도 멈추지않고 다른 쓰레든는 작업을 진행중
        ThreadEx08_1 th1 = new ThreadEx08_1();
        th1.start();

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}

class ThreadEx08_1 extends Thread {
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);     //  1초 시간을 지연한다.
            } catch(Exception e) {
            }
        }
    }
}