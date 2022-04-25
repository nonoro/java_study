## < 예외처리(exception handling) >
### 1. 프로그램 오류
#### - 컴파일 에러 : 컴파일 시에 발생하는 에러
#### - 런타임 에러 : 실행 시에 발생하는 에러
#### - 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것
#### - javac.exe : 자바 컴파일러 : 얘가 하는일
        1) 구문체크
        2) 번역
        3) 최적화
        4) 생략된 코드 추가
#### - java의 런타임 에러(실행중에 발생하는 에러)
        1) 에러(error) : 수습될 수 없는 심각한 오류 : 메모리 부족(OutOfMemoryError), 스택오버플로우(StackOverflowError)등
        2) 예외(exception) : 수습될 수 있는 다소 미약한 오류
#### - 예외처리의 정의와 목적
        1) 정의 : 예외의 발생에 대비한 코드를 작성하는 것
        2) 목적 : 비정상 종료를 막고 정상적인 실행상태를 유지하는 것

### 2. 예외 클래스의 계층 구조
#### - Exception클래스와 그 자손들(RuntimeException과 그의 자손들 제외) : ***사용자의 실수***와 같은 ***외적인 요인***에 의해 발생하는 예외
#### - RuntimeException클래스와 그 자손들 : ***프로그래머의 실수***로 발생하는 예외 : 배열의 범위를 벗어난경우(ArrayIndexOutOfBoundsException), 값이 null인 참조변수의 멤버를 호출하려 한 경우(NullPointerException) 등

### 3. 예외처리하기 - try - catch문
#### 예외 정리)
    1) 프로그램오류
        a) 컴파일에러
        b) 런타임에러(실행중)
            A) Error : 심각한 에러
            B) Excption : 미약한 에러
                ㄱ) Exception과 그 자손들
                ㄴ) RuntimeExcption과 그 자손들
        c) 논리적에러

#### - 예외처리의 
        1) 정의 : 프로그램 실행 시 발생할 수 있는 예외의 발생에 대비한 코드를 작성하는 것
        2) 목적 : 프로그램의 비정상 종료를 막고, 정상적인 실행상태를 유지하는 것
        3) 예시 
```
try {           //  { 생략 불가
// 예외가 발생할 가능성이 있는 문장들을 넣는다 
} catch (Exception1 e1) {

} catch (Exception1 e2) {

} catch (Exception1 eN) {

}

* if문과 달리, try블럭이나 catch블럭 내에 포함된 문장이 하나뿐이어도 괄호{}를 생략할 수 없다.
```

#### - try - catch문에서의 흐름
    1) try블럭 내에서 예외가 발생한 경우
        a) 발생한 예외와 일치하는 catch블럭이 있는지 확인한다.
        b) 일치하는 catch블럭을 찾게 되면, 그 catch블럭 내의 문장들을 수행하고 전체 try-catch문을 빠져나가서 그 다음 문장을 계속해서 수행한다.
           만일 일치하는 catch블럭을 찾지 못하면, 예외는 처리되지 못한다. 그리고 다음문장을 실행하지 못하고 프로그램이 비정상으로 종료된다.
        * 캐치블록이 여러개있어도 발생한 예외에 해당하는 캐치블럭 한개만 수행하고 트라이 캐치문을 빠져나온다
    2) try블럭 내에서 예외가 발생하지 않은 경우
        a) catch블럭을 거치지 않고 전체 try-catch문을 빠져나가서 수행을 계속한다.
        * catch (Exception e)는 모든 예외의 최고 조상이므로 모든 예외처리가 가능하다 그래서 이 캐치블럭을 맨위에 두게되면 내가 예외처리하고싶지 않은 것들도    
          모두 예외처리가 되므로 Exception e 캐치블록은 제일 마지막 부분에 놓는다

#### - printStackTrace()와 getMessage()
    => 예외가 발생했을 때 생성되는 예외 클래스의 인스턴스에는 발생한 예외에 대한 정보가 담겨 있고, catch블럭의 괄호()에 선언된 참조변수를 통해 이 인스턴스에 접근할 수 있다.
    1) printStackTrace() : 예외발생 당시 호출스텍에 있었던 메서드의 정보와 예외 메시지를 화면에 출력한다
    2) getMessage() : 발생한 예외클래스의 인스턴스에 저장된 메시지를 얻을 수 있다.

#### - 멀티 catch블럭
    => JDK1.7부터 여러 catch블럭을 '|'기호를 이용해서, 하나의 catch블럭으로 합칠 수 있게 되었으며, 이를 '멀티 catch블럭'이라 한다.
       멀티 catch블럭을 이용하면 중복된 코드를 줄일 수 있다. 그리고 '|'기호로 연결할 수 있는 예외 클래스의 개수에는 제한이 없다.
    - 만일 멀티 catch블럭의 '|'기호로 연결된 예외 클래스가 조상과 자손의 관계에 있다면 컴파일 에러가 발생한다 이유는 두 예외 클래스가 조상과 자손의 관계에 있다면
      조상 클래스만 써주는 것과 똑같기 때문에 불필요한 코드는 제거하라는 의미에서 에러가 발생하는 것이다.

### 4. 예외 발생시키기
    => 키워드 throw를 사요해서 프로그래머가 고의로 예외를 발생시킬 수 있으며 방법은 아래와 같다.
        - 먼저, 연산자 new를 이용해서 발생시키려는 예외 클래스의 객체를 만든 다음
            Exception e = new Exception ("고의로 발생시켰음");
        - 키워드 throw를 이용해서 예외를 발생시킨다.
            throw e;
        * 만약 throw로 던졌는데 catch로 받는게 없으면 에러가 뜸

#### - checked예외, unchecked예외
        1) checked예외 : 컴파일러가 예외 처리 여부를 체크(예외 처리 필수) - Exception과 Exception자손
        2) unchecked예외 : 컴파일러가 예외 처리 여부를 체크 안함(예외 처리 선택) - RuntimeException과 RuntimException자손

        * 정리)
            a) 컴파일에러
            b) 런타임에러
                A) Error : 심각
                B) Exception : 덜심각
                    ㄱ) Exception과 자손 : 체크드 예외(컴파일러체크)(try-catch필수)
                    ㄴ) RuntimeException과 자손 : 언체크트 예외(컴파일러체크)(try-catch선택)
            c) 논리적에러

### 5. 메서드에 예외 선언하기
    - 예외 처리 방법
        1) try-catch문
        2) 예외를 메서드에 선언하는 방법 (자기를 호출한 사람한테 예외 떠넘기기(알리기))
            void method() throws Exception1, Exception2, ... ExceptionN {
                //  메서드의 내용
            }
        3) 은폐 덮기 (catch블럭에 빈 catch블럭을 씀)

        * 오버라이딩 조건 3가지
            - 선언부 일치
            - 조상보다 접근제어자 좁게 x
            - 조상보다 많은 예외 선언 x

### 6. finally블럭
    - 예외 발생여부와 관계없이 수행되어야 하는 코드를 넣는다. 
    - 순서 
        1) 예외 발생시 실행순서 : try - catch - finally
        2) 예외 발생 안했을시 실행순서 : try - finally
    - finally는 보통 try와 catch에서 중복된 코드를 없애기위해서 쓴다

### 7. 자동 자원 반환 - try - with - resources문
    - JDK1.7부터 try-with-resources문이라는 try-catch문의 변형이 새로 추가되었다.
    - 이 구문은 15장 입출력(I/O)과 관련된 클래스를 사용할 때 유용하다

### 8. 사용자정의 예외 만들기
    - 우리가 직접 예외 클래스를 정의할 수 있다.
        1) 조상은 Exception과 RuntimeException중에서 선택
        2) String매개변수가 있는 생성자를 넣어주기
```
ex) class MyException extends Exception {
        MyException(String msg) {   //  문자열을 매개변수로 받는 생성자
               super(msg)   //  조상인 Exception클래스의 생성자를 호출한다
```
    - 기존의 예외 클래스는 주로 Exception을 상속받아서 'checked예외'로 작성하는 경우가 많았지만, 요즘은 예외처리를 선택적으로 할 수 있도록 TuntimeException을 상속받아서 작성하는 쪽으로 바뀌고있다
      왜냐하면 checked예외는 반드시 예외처리를 해줘야하기 때문에 예외처리가 불필요한 경우에도 try-catch문을 넣어서 코드가 복잡해지기 때문이다.

### 9. 예외 되던지기(exception re-throwing)
    - 예외를 처리한 후에 다시 예외를 발생시키는 것
    - 호출한 메서드와 호출된 메서드 양쪽 모두에서 예외처리를하는 것

### 10. 연결된 예외(chained exception)
    - 한 예외가 다른 예외를 발생시킬 수 있다.
    - 예외 A가 예외 B를 발생시키면, A는 B의 원인 예외(cause exception)
        Throwable initCause(Throwable cause) : 지정한 예외를 원인 예외로 등록
        Throwable getCause()                 : 원인 예외를 반환
    * Throwable : Exception과 Error의 조상 그래서 Throwable을 Exception으로 봐도 무방
    - 연결된 예외 쓰는 이유
        1) 여러 예외를 하나로 묶어서 다루기 위해서 
        2) checked예외(Exception의 자손, 필수처리)를 unchecked(RuntimeException의 자손, 선택처리)예외로 변경하려 할 때
            