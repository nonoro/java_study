## < 열거형(enum) >
- 관련된 상수들을 같이 묶어 놓은 것. Java는 타입에 안전한 열거형을 제공(값 & 타입 둘다 체크해서 아무리 상수값이 같더라도 타입이 다르면 false)

> 1. 열거형의 정의와 사용
- 열거형을 정의하는 방법
  - enum 열거형이름 { 상수명1, 상수명2, 상수명3, '''')
  - 열거형 타입의 변수를 선언하고 사용하는 방법
  - 열거형 상수의 비교에 ==와 compareTo()-[같으면 0 왼쪽이크면 양수 오른쪽이 크면 음수]사용가능, 비교연산자 사용불가
- 열거형의 정의된 상수를 사용하는 방법
  - '열거형이름'.상수명(클래스의 static변수를 참조하는 것과 동일)
- switch문의 조건식에도 열거형을 사용할 수 있다.(case문에 열거형의 이름은 적지않고 상수의 이름만 적는다)


> 2. 열거형의 조상 - java.lang.Enum
- 모든 열거형은 Enum의 자손이며, 아래의 메서드를 상속받는다.
- valueOf(), valueOf()는 컴파일러가 자동으로 추가

> 3. 열거형의 멤버 추가하기
- 불연속적인 열거형 상수의 경우, 원하는 값을 괄호()안에 적는다.
  - enum Direciton { EAST(1), SOUTH(5), WEST(-1), NORTH(10) }
- 괄호()를 사용하려면, 인스턴스 변수와 생성자를 새로 추가해 줘야 한다
  ```
  enum Direciton { EAST(1), SOUTH(5), WEST(-1), NORTH(10);        //  열거형 상수 마지막에 ;을 꼭 추가해야됨 
  
        private final int value;            //  정수를 저장할 필드(인스턴스 변수) 추가
        Direction(int value) {
           this.value = value;
        }
        
        public int getValue() {             //  외부에서 이 값을 얻을 수 있게 추가한 함수
             return value;
        }
   }
  ```
- 열거형의 생성자는 묵시적으로 private이므로, 외부에서 객체생성 불가

> 4. 열거형의 추상메서드(가볍게 참고)
- 열거형  Transportation은 운송 수단의 종류 별로 상수를 정의하고 각 운송 수단에는 기본요금(BASIC_FARE)이 책정되어있다.
- 거리에 따라 요금을 계산하는 방식이 각 운송 수단마다 다르기 때문에 이거한 기능을 추가하기 위해 추상 메서드 fare(int distance)를 선언할 수 있다.
  - abstract in fare(int distance) : 거리에 따른 요금을 계산하는 추상메서드

  