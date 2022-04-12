package ch06;

class StaticBlockTest {
    static int[] arr = new int[10];    //  명시적 초기화를 통해 배열 arr 생성

    static {
        for(int i = 0; i < arr.length; i++) {
            // 1과 10사이의 임의의 값을 배열 arr에 저장한다. , 클래스 초기화 블럭을 이용해 배열의 각 요소들을 ramdom()을 사용해 임의의 값으로 10자리를 채움
            arr[i] = (int) (Math.random() * 10) + 1;
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println("arr["+i+"] :" + arr[i]);
        }
    }
}
