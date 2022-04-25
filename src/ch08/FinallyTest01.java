//package ch08;
//
//class FinallyTest01 {
//    public static void main(String[] args) {
//        try {
//            startInstall();         //  프로그램 설치에 필요한 준비를 한다.
//            copyFiles();            //  파일들을 복사한다.
//            deleteTempFiles();      //  프로그램 설치에 사용된 임시파일들을 삭제한다.
//        } catch (Exception e) {
//            e.printStackTrace();
//            deleteTempFiles();      //  프로그램 설치에 사용된 임시파일들을 삭제한다.
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
////  이 예제가 하는 일은 프로그램설치를 위한 준비를 하고 파일들을 복사하고 설치가 완료되면 프로그램을 설치하는데 사용된 임시파일들을 삭제하는 순서로 진행된다.
////  프로그램 설치과정 중에 예외가 발생하더라도, 설치에 사용된 임시파일들이 삭제되도록 catch블럭에 deleteTempFiles()메서드를 넣었다
////  결국 try블럭의 문장을 수행하는 동안에 예외의 발생여부에 관계없이 deleteTempFiles()메서드는 실행되어야 한다.
//
//
