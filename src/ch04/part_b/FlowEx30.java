package ch04.part_b;

public class FlowEx30 {
    public static void main(String[] args) {
        int sum = 0;
        int i = 0;

        while(true) {
            if (sum > 100)
                break;
            ++i;
            sum += i; // 이거랑 윗줄을 합쳐서 sum +=++i이렇게 바꿀수있음
        } // end of while

        System.out.println("i=" + i);
        System.out.println("sum=" + sum);
    }
}
