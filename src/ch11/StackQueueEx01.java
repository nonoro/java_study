package ch11;

import java.util.*;

class StackQueueEx01 {
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue q = new LinkedList();     //  Queue인터페이스의 구현체인 LinkedList를 사용

        st.push("0");
        st.push("1");
        st.push("2");

        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("= Stack =");
        while (!st.empty()) {                   //  비어있지 않으면 참
            System.out.println(st.pop());       //  스택에서 요소 하나를 꺼내서 출력
        }

        System.out.println("= Queue =");
        while (!q.isEmpty()) {                  //  비어있지 않으면 참
            System.out.println(q.poll());       //  스택에서 요소 하나를 꺼내서 출력
        }
    }
}