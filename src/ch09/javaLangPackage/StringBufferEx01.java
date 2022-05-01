package ch09.javaLangPackage;

class StringBufferEx01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abc");
        StringBuffer sb2 = new StringBuffer("abc");

        System.out.println("sb == sb2 ? " + sb.equals(sb2));        //  == 주소비교
        System.out.println("sb.equals(sb2) ?" + sb.equals(sb2));    //  StringBuffer에서는 equals가 오버라이딩 되어있지 않아서 주소비교

        //  StringBuffer의 내용을 String으로 변환한다.
        String s = sb.toString();   //  String s = new String(sb);와 같다
        String s2 = sb2.toString();

        System.out.println("s.equals ? " + s.equals(s2));

    }
}
