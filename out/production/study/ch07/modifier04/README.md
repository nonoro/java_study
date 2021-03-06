## < 제어자(modifier) >

### 1. 제어자란?
    => 클래스와 클래스의 멤버(멤버 변수, 메서드)에 부가적인 의미 부여 = 형용사와 비슷함
    - 제어자의 종류
        a) 접근 제어자 : public, protected, (default)(얘는 아무것도 안붙임), private ( 얘내는 이 4개중 1개만 붙일 수 있다 예를 들면 iv앞에 이 4개중 1개만 붙일 수 있다)
        b) 그      외 : static, final, abstract, native, transient, synchronized, volatile, strictfp
    - 제어자의 사용 예시
        => public static final int WIDTH = 200; 
           public static void main(String[] args) {}
        => public static final 얘내의 순서는 상관없지만 관례적으로 접근 제어자를 제일 왼쪽에 쓴다. final보다 static을 왼쪽에 쓴다.

### 2. static - 클래스의, 공통적인
    - 인스턴스변수는 하나의 클래스로부터 생성되었더라도 각기 다른 값을 유지하지만 클래스변수(static멤버변수)는 인스턴스에 관계없이 같은 값을 갖는다. 그 이유는 하나의 변수를 모든 인스턴스가 공유하기 때문이다.
    - static이 붙은 멤버변수와 메서드, 그리고 초기화 블럭은 인스턴스가 아닌 클래스에 관계된 것이기 때문에 인스턴스를 생성하지 않고도 사용할 수 있다.
    - 인스턴스메서드와 static메서드의 근본적인 차이는 메서드 내에서 인스턴스 멤버를 사용하는가의 여부에 있다.
    * static이 사용될 수 있는 곳 - 멤버변수(static int ~~ = ??; 간단초기화(명시적초기화), 메서드(static int ~~(int ~~, int ~~) iv사용 x, 인스턴스 메서드 사용불가), 초기화 블럭(static {} 복잡한 초기화 수행)

    * static(객체생성없이 사용가능) - 멤버변수 - a) 모든 인스턴스에 공통적으로 사용되는 클래스 변수가 된다.
                                               b) 클래스 변수는 인스턴스를 생성하지 않고도 사용 가능하다.
                                               c) 클래스가 메모리에 로드될 때 생성된다.

                                      메서드  - a) 인스턴스를 생성하지 않고도 호출이 가능한 static 메서드가 된다
                                               b) static메서드 내에서는 인스턴스멤버(iv, im)들을 직접 사용할 수 없다.

### 3. final - 마지막의, 변경될 수 없는 (상수)
    - 거의 모든 대산에 사용가능
    - 변수(멤버변수, 지역변수)에 사용시 값을 변경할 수 없는 상수가 됨
    - 메서드에 사용시 오버라이딩을 할 수 없게 됨
    - 클래스에 사용시 자신을 확장하는 자손클래스를 정의하지 못함 = 다른 클래스의 조상이 될 수 없음
    * final이 사용될 수 있는 곳 - 클래스, 메서드, 멤버변수, 지역변수
    * 대표적인 final 클래스 = String(비밀번호 같은 보안문제 때매 상속받은 자손에서 알 수 없게 하기 위해 final, Math(전부 static 메서드의 집합이라 굳이 이 클래스를 상속받아서 쓸일이 없어서 final)

#### 1) 생성자를 이용한 final멤버 변수의 초기화
        => 클래스 내에 매개변수를 갖는 생성자를 선언하여 각 인스턴스마다 final이 붙은 멤버변수가 다른 값을 갖도록 하는것이 가능하다.

### 4. abstract - 추상의, 미완성의
    => 메서드의 선언부만 작성하고 실제 수행내용은 구현하지 않는 추상 메서드를 선언하는데 사용된다.
    - abstract가 사용될 수 있는 곳 - 클래스, 메서드
    - 추상 클래스는 아직 미완성된 메서드가 존재하는 '미완성 설계도'이므로 인스턴스를 생성할 수 없다.(메서드에 선언부(()얘가 선언부)만 있고 구현부({})가 없음)
    - ex) abstract class AbstractTest {    //  추상 클래스(추상 메서드를 포함한 클래스)
                abstract void move();  //   추상 메서드(구현부({} 이 괄호 즉 몸통)가 없는 메서드 {}로 안끝나고 ;로 끝남)
         
          AbstractTest a = new AbstractTest();   //  에러! 추상 클래스의 인스턴스 생성불가
    - 추상 클래스(<-> 구상클래스)를 상속 받아서 완전한 클래스(완성 설계도)를 만든 후에야 객체를 생성할 수 있다.

### 5. 접근 제어자(access modifier)

#### * public      :  접근제한 없음
#### * protected   :  같은 패키지 + 자손(다른 패키지에서 사용가능) 
#### * (default)   :  같은 패키지
#### * private     :  같은 클래스

#### 1) 대상에 따라 사용할 수 있는 접근 제어자
        - 클래스   : public, (default)
        - 메서드   : public, protected, (default), private
        - 멤버변수 : public, protected, (default), private
        - 지역변수 : 없음

#### 2) 접근 제어자를 이용한 캡슐화(접근 제어자를 활용하여 외부에서 직접 접근 하지 못하고 메서드를 통해 간접 접근 할 수 있게하여 데이터를 보호하는행위)
        - 접근 제어자를 사용하는 이유  
            a) 외부로부터 데이터를 보호하기 위해서 (데이터가 유효한 값을 유지하도록, 또는 비밀번호와 같은 데이터를 외부에서 함부로 변경하지 못하도록), (데이터 감추기)
            b) 외부에는 불필요한, 내부적으로만 사용되는, 부분을 감추기 위해서 (복잡성을 줄임)
        - 보통 멤버변수의 값을 읽는 메서드의 이름을 'get멤버변수이름'으로 한다 (get으로 시작하는 메서드 = 겟터)
        - 보통 멤버변수의 값을 변경하는 메서드의 이름을 'set멤버변수이름'으로 한다 (set으로 시작하는 메서드 = 셋터)
        * 범위를 초과해서 다시 처음부터 시작할때는 모듈러 연산 % 을 써서 할 것

#### 3) 생성자의 접근 제어자
        - 생성자에 접근 제어자를 사용함으로써 인스턴스의 생성을 제한할 수 있다.
        - 생성자의 접근 제어자를 private로 지정하면 외부에서 생성자에 접근할 수 없으므로 인스턴스를 생성할 수 없다. 하지만 클래스 내부에서는 생성 가능하다.
        - 생성자가 private인 클래스는 다른 클래스의 조상이 될 수 없다 왜냐하면, 자손클래스의 인스턴스를 생성할 때 조상클래스의 생성자를 호출해야만 하는데, 생성자의 접근 제어자가 private이므로 자손클래스에서 호출하는 것이 불가능하기 때문이다. 그래서 클래스 앞에 final을 더 추가하여 상속할 수 없는 클래스라는 것을 알리는 것이 좋다.
        

### 6. 제어자(modifier)의 조합
        - 대상에 따라 사용할 수 있는 제어자  
            => 클래스 - public, (default), final, abstract
               메서드 - 모든 접근 제어자, final, abstract, static
             멤버변수  - 모든 접근 제어자, fianl, static
             지역변수  - final
        - 제어자를 조합해서 사용시 주의사항
            1) 메서드에 static과 abstract를 함께 사용할 수 없다. ( static은 몸통이 있는 메서드만 사용가능하므로)
            2) 클래스에 abstract와 fianl을 동시에 사용할 수 없다. ( final은 클래스 확장 불가 abstract는 상속을 통해 완성되야 한다는 의미로 서로 모순되기 때문)
            3) abstract메서드의 접근 제어자가 private일 수 없다. ( abstract메서드는 자손클래스에서 구현해주어야 하는데 접근 제어자가 private이면, 자손클래스에서 접근할 수 없다.)
            4) 메서드에 private와 final을 같이 사용할 필요는 없다. ( 접근 제어자가 private인 메서드는 오버라이딩 될 수 없기 때문이다)


                                  

