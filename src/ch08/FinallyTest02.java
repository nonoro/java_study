//package ch08;
//
//public class FinallyTest02 {
//    public static void main(String[] args) {
//        try {
//            startInstall();         //  프로그램 설치에 필요한 준비를 한다.
//            copyFiles();            //  파일들을 복사한다.
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            deleteTempFiles();      //  프로그램 설치에 사용된 임시파일들을 삭제한다
//        }   //  try-catch의 끝
//    }   //  main의 끝
//
//    static void startInstall() {
//        /* 프로그램 설치에 필요한 준비를 하는 코드를 적는다. */
//    }
//    static void copyFiles() { /* 파일들을 복사하는 코드를 적는다. */ }
//    static void dedleteTempFiles() { /* 임시파일들을 삭제하는 코드를 적는다 */ }
//}
//
//
//
//// try와 catch에 중복으로 사용되는 코드를 finally에 옮겨서 중복된 코드를 제거했다.