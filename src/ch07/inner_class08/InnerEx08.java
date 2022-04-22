package ch07.inner_class08;

import java.awt.*;
import java.awt.event.*;

class InnerEx08 {
    public static void main(String[] args) {
        Button button = new Button("start");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.out.println("ActionEvent occurred!!!");
                }
            }       //  익명 클래스의 끝
        );
    }   //   main의 끝
}   //  InnerEx08의 끝

