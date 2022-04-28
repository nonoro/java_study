## < java.lang패키지 >

### 1. Object클래스
    - 모든 클래스의 최고 조상. 오직 11개의 메서드만을 가지고 있다. iv, cv는 없다
    - notify(), wait() 등은 쓰레드와 관련된 메서드이다.
    - 종류
    => boolean equals(Object ojt) (객체비교), Object clone()(객체 복사), int hashCode(), String toString() (객체를 문자열로 반환), Class getClass() (객체의 클래스 정보를 반환)

#### 1) boolean equals(Object obj)
    - 객체 자신(this)과 주어진 객체(obj)를 비교한다. 같으면 true 다르면 false
    - Object클래스의 equals()는 객체의 주소를 비교(참조변수 값 비교)
    - equals(Object obj)의 오버라이딩 : 인스턴스 변수(iv)의 값을 비교하도록 equals()를 오버라이딩해야 한다.

### 2. hashCode()
    - 객체의 해시코드를 반환하는 메서드, 해시코드 : 정수값 : 해싱이라는 알고리즘에서 사용 : 11장 컬렉션프레임워크에서 자세히 배움
    - Object클래스의 hashCode()는 객체의 주소를 int로 변환해서 반환
    - 해싱은 데이터 관리기법 중 하나로 다량의 데이터를 저장하고 검색하는데 유용
    - equals()를 오버라이딩하면, hashCode()도 오버라이딩 해야한다. : 두개의 공통점은 객체의 주소를 가지고 작업을 한다는 점이고 equals는 주소를 iv를 가지고 작업하게 오버라이딩을 하는데 
                                                               hashCode도 마찬가지로 주소를 가지고 작업을 하기 때문에 iv를 이용해서 작업하도록 오버라이딩을 해야한다.
    - 암기 : equals() 결과가 true인 두 객체의 해시코드는 같아야한다.
    - System.identityHashCode(Object obj)는 Object클래스의 hashCode()와 동일 : identityHashCode 객체마다 다른 해시코드 반환 (참고)
    - 32bit JVM에선 주소값이 int값임 그래서 해시코드가 int 값, 근데 64bit JVM에서는 주소가 8바이트여서 long임 따라서 주소값이 겹치는 경우가 발생 할 수도 있음

### 3. toString(), toString()의 오버라이딩
    - toString() : 객체를 문자열(String)으로 변환하기 위한 메서드
    - 해시코드와 마찬가지로 toStiring은 주소값을 불러오기 때문에 오버라이딩 하지 않으면 객체의 주소값을 불러온다 형태는 : 클래스이름"@"16진객체주소
    - 객체 == iv집합 이므로 객체를 문자열로 변환한다는 것은 iv의 값을 문자열로 변환한다는 것과 같다.

### 4. clone()
    - 객체 자신을 복제해서 새로운 객체를 생성하는 메서드
    - Cloneable인터페이스를 구현한 클래스의 인스턴스만 복제할 수 있다.
    - Object클래스에 정의된 clone()은 인스턴스변수의 값만을 복제한다
    - 인스턴스변수가 참조형일 때, 참조하는 객체도 복제되게 오버라이딩 해야된다 안그러면 불완전복제(얕은 복사)가 되어 참조변수가 같은 주소를 가질 뿐 복제된 객체가 생성되지 않는다

### 5. 공변 반환타입
    - 오버라이딩할 때 조상 메서드의 반환타입을 자손 클래스의 타입으로 변경을 허용하는 것
    - 조상의 타입이 아닌 실제로 반환되는 자손 객체의 타입으로 변환할 수 있어서 번거로운 형변환이 줄어든다.
    - 예시 : 배열의 clone
            int[] arr = {1, 2, 3, 4, 5};
            int[] arrClone = arr.clone();

### 6. 얕은 복사와 깊은복사
    - 얕은 복사 : 원본과 복제본이 같은 객체를 공유하므로 원본을 변경하면 복사본도 영향을 받는다
    - 깊은 복사 : 원본과 볷제본이 서로 다른 객체를 참조하기 때문에 원본의 변경이 복제본에 영향을 미치지 않는다.

### 7. getClass()
    - 자신이 속한 클래스의 Class 객체를 반환하는 메서드
    - Class객체를 통해서 객체를 생성하고 메서드를 호출하는 등 보다 동적인 코드를 작성할 수 있다
    - Class 객체는 클래스의 모든 정보를 담고 있으며 클래스당 단 1개만 존재 클래스파일(*.class)이 메모리에 로드될때 생성된다 
      클래스 : 클래스객체 = 1 : 1
    - Class 객체를 얻는 방법
        1) Class cObj = new Card().getClass();  //  생성된 객체로 부터 얻는 방법
        2) Class cObj = Card.class;             //  클래스 리터럴(*.class)로 부터 얻는 방법
        3) Class cObj = Class.forName("Card");  //  클래스 이름으로 부터 얻는 방법

### 8. String클래스
    - 문자열을 다루기 위한 클래스
    - String클래스 = 데이터(char[]=문자배열) + 메서드(문자열 관련)

#### 1) 변경 불가능한(immutable) 클래스
    - 내용을 변경할 수 없는 불변(immutable) 클래스  // im(not) + mut(change) + able
    - 덧셈 연산자(+)를 이용한 문자열 결합은 성능이 떨어짐 : 문자열은 내용을 변경할 수 없어서 계속 새로운 객체가 만들어지기 때문에 성능이 떨어짐
        String a = "a";
        String b = "b";
        a = a + b;     //  "ab"가 출력됨 근데 이게 a 값이 바뀐게아니라 "ab"를 담는 새로운 객체 주소가 생성되고 a의 주소가 "ab"의 객체 주소로 바뀔뿐임
        * 따라서 문자열의 결합이나 변경이 잦다면, 내용을 변경가능한 StringBuffer를 사용 : 간단한 한 두번의 문자결합은 괜찮지만 반복문 안에서 문자를 지속적으로 결합할 경우 StringBuffer를 사용한다.
    
#### 2) 문자열의 비교
    - String str = "abc"(문자열 리터럴); 와 String str = new String("abc");의 비교
        String str1 = "abc";    //  문자열 리터럴 "abc"의 주소가 str1에 저장됨
        String str2 = "abc";    //  문자열 리터럴 "abc"의 주소가 str2에 저장됨
        String str3 = new String("abc");        //  새로운 String인스턴스를 생성
        String str4 = new String("abc");        //  새로운 String인스턴스를 생성
        1) 문자열 리터럴로 문자열을 만들면 하나의 문자열을 여러 참조변수가 공유한다 따라서 주소가 같음(문자열 리터럴은 이미 존재하는 것을 재사용하는 것)
        2) new 연산자 사용시 항상 새로운 객체가 만들어짐 따라서 주소가 다름
        * 그런데 문자열은 어짜피 내용을 변경불가임 그래서 굳이 new를 이용해서 같은 내용의 문자열을 여러개를 만들 필요가 없음
        * 문자열의 같고 다름을 뵤시할 떄는 equals를 써야됨 등가비교 연산자 == 는 주소비교이고 equals는 내용비교임 따라서 어떨땐 true고 어떨땐 false라서 
          문자열을 비교할땐 항상 equals를 이용해서 비교하기

#### 3) 문자열 리터럴(리터럴 = 상수)
    - 문자열 리터럴은 프로그램 실행시 자동으로 생성된다.(constant pool에 저장 = 상수 저장소)
    - 같은 내용의 문자열 리터럴은 하나만 만들어진다. : String객체는 내용불변이기 때문

#### 4) 빈 문자열("", empty string)
    - 내용이 없는 문자열. 크기가 0인 char형 배열을 저장하는 문자열
        String str = ""  //  str을 빈 문자열로 초기화
    - 길이가 0인 배열을 생성하는 것은 어느 타입이나 가능 (자바는 가능한데 씨언어는 불가능)
        char[] chArr = new char[0];     //  길이가 0인 char배열
        int[] iArr = {};                //  길이가 0인 int배열
    - 빈 문자열 쓰는 이유는 숫자를 문자로 바꿀때 빈 문자열을 사용하고, 또 배열을 초기화 할 때도 null보단 빈 문자열로 하는게 유용함
    - 문자(char)와 문자열(String)의 초기화
        String s = null;                ----->              String s = "";  //  빈 문자열로 초기화
        char c = '\u0000'               ----->              char c = ' ';   //  공백으로 초기화
        * 오른쪽 코드가 더 좋은 코드이다

#### 5) Strin클래스의 생성자와 메서드
    - String(String s) : 잘 안씀
        String s = new String("Hello");        :       s = "Hello"
    - String(char[] value) : 잘 씀        : char[]을 String으로 변경할 때 쓰는 생성자
        char[] c = {'H', 'e', 'l', 'l', 'o'};                               //  char[] ---> String 으로 바꾸는방법 (캐릭터배열을 스트링으로 바꾸는 방법)
        String s = new String(c);               :   s = "Hello"             //  반대로 String을 Char[]로 바꿀땐 tocharArray()라는 메서드를 쓰면된다.
    - String(StringBuffer buf)      : 내용변경 가능 , StringBuffer를 String으로 변경할 때 쓰는 생성자
    - char charAt(int index)        : 지정된 위치에 있는 문자를 1개 반환하는 생성자
    - int compareTo(String str)     : 문자열과 사전순서로 비교하는 생성자(정렬에사용) ex) int i = "aaa".compareTo("aaa");  --> i = 0 // 같아서 0임 만약 오른쪽이 "bbb"였으면 i = -1 왼쪽이 "bbb" 였으면 i = 1;
                                    정리 ) 같으면 0, 왼쪽이 작으면 -1, 오른쪽이 작으면 1
    - String concat(String str)     : 문자열을 뒤에 덧붙이는 생성자 : Hello에 World를 따로 선언해서 Hellow World로 출력되게함
    - boolean contains(CharSequence s)  : 지정된 문자열이 포함되었는지 검사하는 생성자 
    - 나머지 책 내용 참조 

#### 6) join()과 StringJoiner
    - join()은 static 메서드이며 여러 문자열 사이에 구분자를 넣어서 결합한다.
        String animals = "dog,cat,bear"
        String[] arr = animals.split(",");  //  문자열을 ','를 구분자로 나눠서 배열에 저장 (',' 이건 구분자)
        String str = String.join("-", arr); //  배열의 문자열을 '-'로 구분해서 결합 ('-' 이건 구분자)
        System.out.println(str);            //  dog-cat-bear ("dog" + "-" + "cat" + "-" + "bear")
    - StringJoiner : java.util.StringJoiner클래스를 사용하여 문자열을 결합할 수도 있다.
        new StringJoiner(구분자, 처음, 끝)

#### 7) 유니코드의 보충문자
    - 확장에 의해 새로 추가된 문자들을 보충문자라고 하는데 String클래스에서 보충문자를 지원하는 것은 
      매개변수가 int ch인 것들은 보충문자 지원, 매개변수가 char ch인 것들은 보충문자 지원하지 않음

#### 8) 문자 인코딩 변환
    - getBytes(String charsetName)를 사용하면, 문자열의 문자 인코딩을 다른 인코딩으로 변경할 수 있다.

#### 9) String.format()
    - printf()하고 사용법이 완전히 똑같다

#### 10) 문자열과 기본형 간의 변환
    - 숫자를 문자열로 바꾸는 방법(valueOf)
        int i = 100;   // 숫자 + ""(빈문자열)
        String str1 = i + "";               //  100을 "100"으로 변환하는 방법1 - 편리 보통이걸씀
        String str2 = String.valueOf(i);    //  100을 "100"으로 변환하는 방법2 - 속도가 빠름
    - 문자열을 숫자로 바꾸는 방법(valueOf)
        int i = Integer.parseInt("100");    //  "100"을 100으로 변환하는 방법1 old한 방법 얘는 parse 뒤에 기본형에따라 달라짐
        int i2 = Integer.valueOf("100");    //  "100"을 100으로 변환하는 방법2 new방법 얘는 그냥 앞에 타입만 맞추고 뒤엔 뭐든 valuOf하면됨 이거쓰기
        Integer i2 = Integer.valueOf("100");    // 원래는 valueOf 반환 타입이 Integer 참조형임 근데 int 기본형으로 써도됨 
