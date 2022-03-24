package ch02;
//형식화된 출력 - printf()
public class PrintfEx1 {
    public static void main (String[] args) {
        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000_000L; // long big = 100000000000L;
        long hex = 0xFFFF_FFFF_FFFF_FFFFL;

        int octNum = 010;      //  8진수 10, 10진수로는 8
        int hexNum = 0x10;     //  16진수 10, 10진수로는 16
        int binNum = 0b10;     //  2진수 10, 10진수로는 2

        System. out. printf("b=%d%n", b); // 뒤에 회색 글씨로된 b나 s c finger이런거는 다 출력됐을때 이름임 ex) b = 1 할때 b 를 지칭
        System. out. printf("s=%d%n", s);
        System. out. printf("c=%c, %d %n", c, (int)c); //문자 A의 유니코드가 65임 그래서 c를 정수로 변환했을때 65가 나옴
        System. out. printf("finger=[%5d]%n",  finger);
        System. out. printf("finger=[%-5d]%n", finger);
        System. out. printf("finger=[%05d]%n", finger);
        System. out. printf("big=%d%n", big);
        System. out. printf("hex=%#x%n", hex);     // '#'은 접두사(16진수 0x, 8진수 0)
        System. out. printf("octNum=%o, %d%n", octNum, octNum);
        System. out. printf("hexNum=%x, %d%n", hexNum, hexNum);
        System. out. printf("binNum=%s, %d%n", Integer.toBinaryString(binNum)
                                                                        , binNum);
    }
}
