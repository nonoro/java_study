package ch13;

import javax.swing.JOptionPane;
//  싱글쓰레드
public class ThreadEx07 {
    public static void main(String[] args) throws Exception {
        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요.");    //  싱글 쓰레드는 입력할때까지 정지상태 : 이게 바로 블락킹 구강
        System.out.println("입력하신 값은 " + input + "입니다.");
//  사용자가 입력을 마치고 나서 이제 아래 작업이 시작됨
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);     //  1초 시간을 지연한다.
            } catch(Exception e) {
            }
            }
        }
    }
