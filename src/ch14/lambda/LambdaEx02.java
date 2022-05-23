package ch14.lambda;

@FunctionalInterface
interface MyFunction2 {
    public abstract void myMethod();        //  void myMethod();
}

class LambdaEx02 {
    public static void main(String[] args) {
        MyFunction2 f = () -> {};       //  MyFunction f = (MyFunction) (() -> {});
        Object obj = (MyFunction2) (() -> {});      //  Object타입으로 형변환이 생략됨 원래 (Object) (MyFunction2) (() -> {});
        String str = ((Object)(MyFunction2)(() -> {})).toString();

        System.out.println(f);
        System.out.println(obj);
        System.out.println(str);

        //  System.out.println(() -> {});     //  에러. 람다식은 (Object)타입으로 형변환 아노딤
        System.out.println((MyFunction)(() -> {}));
        System.out.println(((MyFunction)(() -> {})).toString());        //  에러
        System.out.println(((Object) (MyFunction2) (() -> {})).toString());
    }
}
