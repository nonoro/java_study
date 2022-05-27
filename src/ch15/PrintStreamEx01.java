package ch15;

import java.util.Date;

class PrintStreamEx01 {
    public static void main(String[] args) {
        int i = 65;
        float f = 1234.56789f;

        Date date = new Date();

        System.out.printf("문자 %c의 코드는 %d%n", i, i);
        System.out.printf("%d는 8진수로 %o, 16진수로 %x%n", i, i, i);
        System.out.printf("%3d%3d%3d\n", 100, 90, 80);
        System.out.println();
        System.out.printf("123456789012345678901234567890%n");
        System.out.printf("%s%-6s%5s%n", "123", "123", "123");
        System.out.println();
        System.out.printf("오늘은 %tY년 %tm월 %td일 입니다.%n", date, date, date);
        System.out.printf("지금은 %tH시 %tM분 %tS초 입니다.%n", date, date, date);
        System.out.printf("지금은 %1$tH시 %1$tM분 %1$tS초 입니다.%n",  date);        //  1$ 첫번쨰 매개변수를 의미
    }
}

