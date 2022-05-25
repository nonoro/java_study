package ch14.stream;

import java.util.Optional;

class OptionalEx01 {
    public static void main(String[] args) {
//        int[] arr = {};
        int[] arr = new int[0];
        System.out.println("arr.length=" + arr.length);

//        Optional<String> opt = null;        //  OK 하지만 바람직하지 않음
        Optional<String> opt = Optional.empty();
        System.out.println("opt=" + opt);
//        System.out.println("opt=" + opt.get());         //  값이 없어서 오류발생 그래서 get은 잘 안쓰고

        String str = "";

//        str = opt.orElse("");       //  Optional에 저장된 값이 null이면 ""반환 "" 말고도 특정 값을 넣으면 그 값으로 반환
//        str = opt.orElseGet(() -> new String());        //  람다식
        str = opt.orElseGet(String::new);       //  메서드 참조
        System.out.println("str=" + str);
    }
}
