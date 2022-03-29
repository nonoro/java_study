package ch04.b;

public class FlowEx33 {
    public static void main(String[] args)
    {
        // for문에 Loop1이라는 이름을 붙였다.
        Loop1 : for(int i=2;i <=9;i++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 5)
                    break Loop1; // j가 5가되는순간 Loop1을 아예 벗어나서 i의 첫번째 시작값인 2단밖에 출력안됨
//                break; // 얘는j가 5가 되어도 Loop1을 벗어나지못해서 i의 값이 9보다 커질때까지 계속 반복한다
//                continue Loop1;
//                continue;
                System.out.println(i + "*" + j + "=" + i * j);
            } //end of for i
            System.out.println();
        } // end of Loop1
    }
}
