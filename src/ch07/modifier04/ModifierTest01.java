package ch07.modifier04;

class Modifier {
    private    int prv;  //  같은 클래스 내에서만 사용가능
               int dft;  //  같은 패키지 내에서 사용가능 얘의 접근 제어자는 (default)임 얘는 이렇게 아무것도 안씀
    protected  int prt;  //  같은 패키지 + 자손(다른 패키지) 에서 사용 가능
    public     int pub;  //  접근제한 없음

    public void printMembers() {
        System.out.println(prv);    //  OK
        System.out.println(dft);    //  OK
        System.out.println(prt);    //  OK
        System.out.println(pub);    //  OK
    }
}

public class ModifierTest01 {
    public static void main(String[] args) {
        Modifier m = new Modifier();
//        System.out.println(m.prv);    //  에러 같은 클래스가 아님
        System.out.println(m.dft);    //  OK
        System.out.println(m.prt);    //  OK
        System.out.println(m.pub);    //  OK
    }
}
