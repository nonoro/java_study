package ch09.javaLangPackage;

class WrapperEx01 {
    public static void main(String[] args) {

        Integer i = new Integer(100);
        Integer i2 = new Integer(100);

        System.out.println("i==i2 ? " + (i == i2));                     //      주소비교 같으면 true 다르면 false
        System.out.println("i.equals(i2) ? " + i.equals(i2));           //      내용비교 같으면 true 다르면 false
        System.out.println("i.compareTo(i2)=" + i.compareTo(i2));       //      같으면 0, 오른쪽값이 작으면 양수, 오른쪽값이 작으면 음수, 정렬에 사용(11장)
        System.out.println("i.toString()=" + i.toString());

        System.out.println("MAX_VALUE=" + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE=" + Integer.MIN_VALUE);
        System.out.println("SIZE=" + Integer.SIZE + " bits");
        System.out.println("BYTES=" + Integer.BYTES + " bytes");
        System.out.println("TYPE=" + Integer.TYPE);
    }
}