package ch08;

class ExceptionEx01 {
    public static void main(String[] args) {
        try {
            try {  } catch (Exception exception) { }
        } catch (Exception exception) {
//            try {  } catch (Exception exception) { }  //  에러. 변수 e가 중복 선언되었다.
        }   // try - catch의 끝

        try {

        } catch (Exception exception) {

        }   //  try - catch의 끝
    }   //  main메서드의 끝
}
