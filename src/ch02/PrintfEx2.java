package ch02;

public class PrintfEx2 {
    public static void main(String[] args) {
        String url = "www.codechobo.com";

        float f1 = .10f; // 0.10, 1.0e-1 (여기서 0.1=.1)
        float f2 = 1e1f; // 10.0, 1.0e1, 1.0e+1
        float f3 = 3.14e3f; // 3.14 * 10^3 이라는뜻 따라서 3140
        double d = 1.23456789;

        System. out. printf("f1=%f, %e, %g%n", f1, f1, f1);
        System. out. printf("f2=%f, %e, %g%n", f2, f2, f2);
        System. out. printf("f3=%f, %e, %g%n", f3, f3, f3);

        System. out. printf("d=%f%n", d);
        System. out. printf("d=%14.10f%n", d); // 전체 14자리 중 소수점 10자리 / 만약 014.10으로 할 경우 왼쪽 오른쪽 둘다 공백이 0으로 채워짐

        System. out. printf("[12345678901234567890]%n");
        System. out. printf("[%s]%n", url);
        System. out. printf("[%20s]%n", url); // 최소 20글자 출력공간 확보(우측정렬)
        System. out. printf("[%-20s]%n", url); //- 는 좌측정렬
        System. out. printf("[%.8s]%n", url); // .8은 왼쪽에서 8글자만 출력

    }
}
