package ch07.inner_class08;

import java.awt.*;
import java.awt.event.*;

class InnerEx07 {
    public static void main(String[] args) {
        Button button = new Button("start");
        button.addActionListener(new EventHandler());
    }
}

class EventHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        System.out.println("ActionEvent occurred!!!");
    }
}
